package com.example.inventorymanagement.ui;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorymanagement.R;
import com.example.inventorymanagement.data.db.TransactionContract;
import com.example.inventorymanagement.data.model.RevenueStats;
import com.example.inventorymanagement.ui.adapter.TransactionAdapter;
import com.example.inventorymanagement.ui.dialog.AddTransactionDialog;
import com.example.inventorymanagement.viewmodel.TransactionViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;
import java.util.Locale;

/**
 * Màn hình chính của ứng dụng.
 * Trong MVVM, Activity chỉ làm đúng một việc: quan sát LiveData và cập nhật UI.
 * Mọi logic nghiệp vụ nằm ở ViewModel và Repository.
 */
public class MainActivity extends AppCompatActivity {

    private TransactionViewModel viewModel;
    private TransactionAdapter adapter;

    private TextView tvSale, tvRefund, tvNet;
    private Spinner spinnerFilter;
    private MaterialButton btnClearFilter;

    // Flag để bỏ qua sự kiện onItemSelected khi thay đổi Spinner bằng code,
    // tránh hiện dialog filter không mong muốn
    private boolean skipNextSpinnerEvent = false;

    // Vị trí tương ứng trong mảng filter_options (strings.xml)
    private static final int FILTER_NONE     = 0;
    private static final int FILTER_TYPE     = 1;
    private static final int FILTER_DATE     = 2;
    private static final int FILTER_HOLDER   = 3;
    private static final int FILTER_CURRENCY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Theme dùng NoActionBar nên phải setup Toolbar thủ công
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvSale   = findViewById(R.id.tv_revenue_sale);
        tvRefund = findViewById(R.id.tv_revenue_refund);
        tvNet    = findViewById(R.id.tv_revenue_net);
        spinnerFilter  = findViewById(R.id.spinner_filter);
        btnClearFilter = findViewById(R.id.btn_clear_filter);

        setupRecyclerView();
        setupViewModel();
        setupFilterSpinner();
        setupButtons();
    }

    private void setupRecyclerView() {
        adapter = new TransactionAdapter();
        RecyclerView rv = findViewById(R.id.rv_transactions);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private void setupViewModel() {
        // ViewModelProvider đảm bảo trả về cùng một instance ViewModel
        // dù Activity bị recreate (xoay màn hình, v.v.)
        viewModel = new ViewModelProvider(this).get(TransactionViewModel.class);

        // Observe danh sách giao dịch — tự động cập nhật RecyclerView khi data thay đổi
        viewModel.getTransactions().observe(this, list -> adapter.setItems(list));

        // Observe thống kê doanh thu — cập nhật Revenue Card
        viewModel.getRevenueStats().observe(this, stats -> {
            if (stats == null) return;
            tvSale.setText(formatRevenueLine("SALE",   stats.totalSaleVND,   stats.totalSaleUSD));
            tvRefund.setText(formatRevenueLine("REFUND", stats.totalRefundVND, stats.totalRefundUSD));

            double netVND = stats.getNetVND();
            double netUSD = stats.getNetUSD();
            tvNet.setText(formatRevenueLine("NET", netVND, netUSD));
            // Net dương → xanh, net âm → đỏ
            tvNet.setTextColor(netVND >= 0 && netUSD >= 0
                    ? Color.parseColor("#4CAF50")
                    : Color.parseColor("#F44336"));
        });
    }

    /** Format dòng doanh thu: "SALE:  500,000 VND  |  $100.00 USD" */
    private String formatRevenueLine(String label, double vnd, double usd) {
        return label + ":  "
                + String.format("%,.0f VND", vnd)
                + "  |  "
                + String.format("$%,.2f USD", usd);
    }

    private void setupFilterSpinner() {
        // Tạo adapter cho Spinner từ string-array trong strings.xml
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.filter_options, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilter.setAdapter(spinnerAdapter);

        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Bỏ qua event khi ta tự set selection bằng code (không phải user chọn)
                if (skipNextSpinnerEvent) {
                    skipNextSpinnerEvent = false;
                    return;
                }
                if (position == FILTER_NONE) {
                    viewModel.clearFilter();
                    btnClearFilter.setVisibility(View.GONE);
                } else {
                    showFilterDialog(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Nút "Clear" xuất hiện khi có filter đang active, bấm để quay về "None (All)"
        btnClearFilter.setOnClickListener(v -> {
            skipNextSpinnerEvent = true;
            spinnerFilter.setSelection(FILTER_NONE);
            viewModel.clearFilter();
            btnClearFilter.setVisibility(View.GONE);
        });
    }

    /** Hiển thị dialog phù hợp với loại filter được chọn */
    private void showFilterDialog(int filterType) {
        switch (filterType) {
            case FILTER_TYPE:
                // Chọn SALE hoặc REFUND
                new AlertDialog.Builder(this)
                        .setTitle("Filter by Transaction Type")
                        .setItems(new String[]{"SALE", "REFUND"}, (d, which) -> {
                            String type = which == 0
                                    ? TransactionContract.TransactionEntry.TYPE_SALE
                                    : TransactionContract.TransactionEntry.TYPE_REFUND;
                            viewModel.filterByType(type);
                            btnClearFilter.setText("Clear (" + type + ")");
                            btnClearFilter.setVisibility(View.VISIBLE);
                        })
                        .setOnCancelListener(d -> resetSpinner()) // Hủy → trả Spinner về None
                        .show();
                break;

            case FILTER_DATE:
                // DatePickerDialog — chọn ngày muốn xem lịch sử giao dịch
                Calendar cal = Calendar.getInstance();
                new DatePickerDialog(this, (dp, year, month, day) -> {
                    // month bắt đầu từ 0 nên phải +1
                    String date = String.format(Locale.getDefault(), "%02d/%02d/%04d", day, month + 1, year);
                    viewModel.filterByDate(date);
                    btnClearFilter.setText("Clear (" + date + ")");
                    btnClearFilter.setVisibility(View.VISIBLE);
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
                        .show();
                break;

            case FILTER_HOLDER:
                // Nhập tên để tìm kiếm (substring search)
                View holderView = getLayoutInflater().inflate(R.layout.dialog_filter_input, null);
                EditText etHolder = holderView.findViewById(R.id.et_filter_input);
                new AlertDialog.Builder(this)
                        .setTitle("Filter by Holder Name")
                        .setView(holderView)
                        .setPositiveButton("Search", (d, w) -> {
                            String name = etHolder.getText().toString().trim();
                            if (!name.isEmpty()) {
                                viewModel.filterByHolder(name);
                                btnClearFilter.setText("Clear (" + name + ")");
                                btnClearFilter.setVisibility(View.VISIBLE);
                            } else {
                                resetSpinner();
                            }
                        })
                        .setNegativeButton("Cancel", (d, w) -> resetSpinner())
                        .setOnCancelListener(d -> resetSpinner())
                        .show();
                break;

            case FILTER_CURRENCY:
                // Chọn VND hoặc USD
                new AlertDialog.Builder(this)
                        .setTitle("Filter by Currency")
                        .setItems(new String[]{
                                TransactionContract.TransactionEntry.CURRENCY_VND,
                                TransactionContract.TransactionEntry.CURRENCY_USD
                        }, (d, which) -> {
                            String currency = which == 0
                                    ? TransactionContract.TransactionEntry.CURRENCY_VND
                                    : TransactionContract.TransactionEntry.CURRENCY_USD;
                            viewModel.filterByCurrency(currency);
                            btnClearFilter.setText("Clear (" + currency + ")");
                            btnClearFilter.setVisibility(View.VISIBLE);
                        })
                        .setOnCancelListener(d -> resetSpinner())
                        .show();
                break;
        }
    }

    /** Trả Spinner về vị trí "None (All)" khi người dùng hủy dialog filter */
    private void resetSpinner() {
        skipNextSpinnerEvent = true;
        spinnerFilter.setSelection(FILTER_NONE);
    }

    private void setupButtons() {
        MaterialButton btnSale       = findViewById(R.id.btn_sale);
        MaterialButton btnRefund     = findViewById(R.id.btn_refund);
        MaterialButton btnClearBatch = findViewById(R.id.btn_clear_batch);

        // Mở dialog nhập thông tin SALE, kết quả trả về qua lambda callback
        btnSale.setOnClickListener(v ->
                AddTransactionDialog.show(this, "New Sale",
                        (amount, currency, holder) -> viewModel.addSale(amount, currency, holder)));

        // Mở dialog nhập thông tin REFUND
        btnRefund.setOnClickListener(v ->
                AddTransactionDialog.show(this, "New Refund",
                        (amount, currency, holder) -> viewModel.addRefund(amount, currency, holder)));

        // Xóa toàn bộ — hiện confirm dialog trước để tránh xóa nhầm
        btnClearBatch.setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Clear Batch")
                        .setMessage("This will delete all transactions. Continue?")
                        .setPositiveButton("Clear", (d, w) -> {
                            viewModel.clearBatch();
                            // Reset Spinner về None sau khi xóa
                            skipNextSpinnerEvent = true;
                            spinnerFilter.setSelection(FILTER_NONE);
                            btnClearFilter.setVisibility(View.GONE);
                        })
                        .setNegativeButton("Cancel", null)
                        .show());
    }
}
