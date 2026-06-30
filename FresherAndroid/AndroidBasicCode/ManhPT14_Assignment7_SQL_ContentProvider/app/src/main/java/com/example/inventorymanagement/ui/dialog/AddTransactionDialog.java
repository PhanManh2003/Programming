package com.example.inventorymanagement.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;

import com.example.inventorymanagement.R;
import com.example.inventorymanagement.data.db.TransactionContract;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Utility class hiển thị dialog nhập thông tin giao dịch.
 * Dùng static method thay vì DialogFragment vì dialog này đơn giản,
 * không cần quản lý lifecycle riêng.
 */
public class AddTransactionDialog {

    /** Callback trả kết quả về cho Activity sau khi người dùng xác nhận */
    public interface OnConfirmListener {
        void onConfirm(double amount, String currency, String holderName);
    }

    /**
     * Hiển thị dialog với tiêu đề tùy chỉnh (ví dụ "New Sale" hoặc "New Refund").
     * Validate input trước khi gọi callback — không để data xấu lọt vào database.
     */
    public static void show(Context context, String title, OnConfirmListener listener) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_add_transaction, null);
        TextInputEditText etAmount = view.findViewById(R.id.et_amount);
        TextInputEditText etHolder = view.findViewById(R.id.et_holder_name);
        RadioGroup rgCurrency      = view.findViewById(R.id.rg_currency);

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setView(view)
                .setPositiveButton("Confirm", null) // null để tự xử lý click, tránh dialog tự đóng khi validation fail
                .setNegativeButton("Cancel", null)
                .create();

        // Override click listener của nút Confirm để kiểm soát khi nào dialog được đóng
        dialog.setOnShowListener(d -> dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            String amountStr  = etAmount.getText() != null ? etAmount.getText().toString().trim() : "";
            String holderName = etHolder.getText() != null ? etHolder.getText().toString().trim() : "";

            // Validate: không để trống
            if (amountStr.isEmpty()) {
                etAmount.setError("Amount is required");
                return;
            }
            if (holderName.isEmpty()) {
                etHolder.setError("Holder name is required");
                return;
            }

            // Validate: amount phải là số dương hợp lệ
            double amount;
            try {
                amount = Double.parseDouble(amountStr);
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                etAmount.setError("Enter a valid positive amount");
                return;
            }

            // Xác định currency từ RadioButton đang được chọn
            String currency = rgCurrency.getCheckedRadioButtonId() == R.id.rb_usd
                    ? TransactionContract.TransactionEntry.CURRENCY_USD
                    : TransactionContract.TransactionEntry.CURRENCY_VND;

            listener.onConfirm(amount, currency, holderName);
            dialog.dismiss();
        }));

        dialog.show();
    }
}
