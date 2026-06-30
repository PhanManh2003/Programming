package com.example.inventorymanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inventorymanagement.data.db.TransactionContract;
import com.example.inventorymanagement.data.model.RevenueStats;
import com.example.inventorymanagement.data.model.Transaction;
import com.example.inventorymanagement.repository.TransactionRepository;

import java.util.List;

/**
 * ViewModel giữ và quản lý dữ liệu UI.
 * Nó tồn tại qua các lần xoay màn hình (configuration change) —
 * Activity bị hủy nhưng ViewModel vẫn sống, tránh mất data.
 *
 * Dùng AndroidViewModel thay vì ViewModel vì cần Application context
 * để khởi tạo Repository (Repository cần ContentResolver).
 */
public class TransactionViewModel extends AndroidViewModel {

    private final TransactionRepository repository;

    // MutableLiveData cho phép ghi (setValue/postValue) từ bên trong ViewModel
    // Expose ra ngoài bằng LiveData (chỉ đọc) để View không thể tự ý thay đổi data
    private final MutableLiveData<List<Transaction>> transactions = new MutableLiveData<>();
    private final MutableLiveData<RevenueStats>      revenueStats = new MutableLiveData<>();

    // Lưu điều kiện filter hiện tại để reload đúng data sau mỗi thao tác
    private String   currentSelection     = null;
    private String[] currentSelectionArgs = null;

    public TransactionViewModel(@NonNull Application application) {
        super(application);
        repository = new TransactionRepository(application);
        reload(); // Tải data ngay khi ViewModel được tạo
    }

    // Getter trả về LiveData — Activity/Fragment observe các LiveData này để cập nhật UI
    public LiveData<List<Transaction>> getTransactions() { return transactions; }
    public LiveData<RevenueStats>      getRevenueStats()  { return revenueStats; }

    /** Thêm giao dịch SALE rồi reload list */
    public void addSale(double amount, String currency, String holderName) {
        repository.addTransaction(TransactionContract.TransactionEntry.TYPE_SALE,
                amount, currency, holderName);
        reload();
    }

    /** Thêm giao dịch REFUND rồi reload list */
    public void addRefund(double amount, String currency, String holderName) {
        repository.addTransaction(TransactionContract.TransactionEntry.TYPE_REFUND,
                amount, currency, holderName);
        reload();
    }

    /** Xóa toàn bộ giao dịch và reset filter */
    public void clearBatch() {
        repository.clearBatch();
        currentSelection     = null;
        currentSelectionArgs = null;
        reload();
    }

    // ──────────────── Các phương thức lọc ────────────────

    /** Lọc theo loại giao dịch: "SALE" hoặc "REFUND" */
    public void filterByType(String type) {
        currentSelection     = TransactionContract.TransactionEntry.COLUMN_TYPE + "=?";
        currentSelectionArgs = new String[]{type};
        reload();
    }

    /**
     * Lọc theo ngày.
     * DateTime lưu dạng "dd/MM/yyyy HH:mm:ss" nên dùng LIKE "dd/MM/yyyy%"
     * để khớp tất cả giao dịch trong ngày đó.
     */
    public void filterByDate(String date) {
        currentSelection     = TransactionContract.TransactionEntry.COLUMN_DATE_TIME + " LIKE ?";
        currentSelectionArgs = new String[]{date + "%"};
        reload();
    }

    /** Lọc theo tên người giao dịch (tìm kiếm substring, không phân biệt hoa/thường) */
    public void filterByHolder(String name) {
        currentSelection     = TransactionContract.TransactionEntry.COLUMN_HOLDER_NAME + " LIKE ?";
        currentSelectionArgs = new String[]{"%" + name + "%"};
        reload();
    }

    /** Lọc theo đơn vị tiền tệ: "VND" hoặc "USD" */
    public void filterByCurrency(String currency) {
        currentSelection     = TransactionContract.TransactionEntry.COLUMN_CURRENCY + "=?";
        currentSelectionArgs = new String[]{currency};
        reload();
    }

    /** Xóa filter, hiển thị toàn bộ giao dịch */
    public void clearFilter() {
        currentSelection     = null;
        currentSelectionArgs = null;
        reload();
    }

    /** Truy vấn lại database với filter hiện tại và cập nhật LiveData */
    private void reload() {
        transactions.setValue(repository.getTransactions(currentSelection, currentSelectionArgs));
        revenueStats.setValue(repository.getRevenueStats(currentSelection, currentSelectionArgs));
    }
}
