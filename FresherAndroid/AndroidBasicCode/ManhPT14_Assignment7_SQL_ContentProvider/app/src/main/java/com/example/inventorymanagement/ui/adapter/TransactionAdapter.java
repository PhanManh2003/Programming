package com.example.inventorymanagement.ui.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorymanagement.R;
import com.example.inventorymanagement.data.db.TransactionContract;
import com.example.inventorymanagement.data.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter cầu nối giữa danh sách dữ liệu Transaction và RecyclerView.
 * RecyclerView chỉ tạo đúng số ViewHolder vừa đủ hiển thị trên màn hình,
 * sau đó tái sử dụng (recycle) khi scroll — giúp tiết kiệm bộ nhớ.
 */
public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<Transaction> items = new ArrayList<>();

    /** Cập nhật toàn bộ danh sách và yêu cầu RecyclerView vẽ lại */
    public void setItems(List<Transaction> newItems) {
        items = newItems != null ? newItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    /** Tạo ViewHolder mới — inflate layout item_transaction.xml thành View */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    /** Gán dữ liệu vào ViewHolder tại vị trí position (được gọi khi scroll) */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() { return items.size(); }

    /**
     * ViewHolder giữ tham chiếu đến các View trong một item.
     * Tránh gọi findViewById() mỗi lần scroll (tốn hiệu năng).
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvInvoice;
        private final TextView tvType;
        private final TextView tvHolder;
        private final TextView tvAmount;
        private final TextView tvDateTime;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInvoice  = itemView.findViewById(R.id.tv_invoice);
            tvType     = itemView.findViewById(R.id.tv_type);
            tvHolder   = itemView.findViewById(R.id.tv_holder);
            tvAmount   = itemView.findViewById(R.id.tv_amount);
            tvDateTime = itemView.findViewById(R.id.tv_datetime);
        }

        void bind(Transaction t) {
            // Định dạng số hóa đơn thành 3 chữ số: #INV-001, #INV-012, ...
            tvInvoice.setText(String.format("#INV-%03d", t.getInvoiceNumber()));
            tvHolder.setText(t.getHolderName());
            tvDateTime.setText(t.getDateTime());

            // Đổi màu badge và số tiền theo loại giao dịch
            boolean isSale = TransactionContract.TransactionEntry.TYPE_SALE.equals(t.getType());
            tvType.setText(t.getType());
            tvType.setBackgroundTintList(ColorStateList.valueOf(
                    isSale ? Color.parseColor("#4CAF50") : Color.parseColor("#F44336")));

            // Format số tiền theo đơn vị: VND dùng số nguyên, USD dùng 2 chữ số thập phân
            String amountStr;
            if (TransactionContract.TransactionEntry.CURRENCY_VND.equals(t.getCurrency())) {
                amountStr = String.format("%,.0f VND", t.getAmount());
            } else {
                amountStr = String.format("$%,.2f USD", t.getAmount());
            }
            tvAmount.setText(amountStr);
            tvAmount.setTextColor(isSale ? Color.parseColor("#4CAF50") : Color.parseColor("#F44336"));
        }
    }
}
