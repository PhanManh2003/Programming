package com.example.inventorymanagement.data.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Contract class: định nghĩa tên bảng, tên cột và URI cho ContentProvider.
 * Dùng constants thay vì string literal để tránh lỗi typo và dễ refactor.
 */
public final class TransactionContract {

    // Authority là địa chỉ duy nhất để hệ thống Android tìm đúng ContentProvider của app
    public static final String AUTHORITY = "com.example.inventorymanagement.provider";

    // Base URI dạng: content://com.example.inventorymanagement.provider
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Không cho phép khởi tạo class này
    private TransactionContract() {}

    /**
     * Inner class đại diện cho bảng "transactions".
     * Implements BaseColumns để thừa kế sẵn hằng _ID và _COUNT.
     */
    public static final class TransactionEntry implements BaseColumns {
        public static final String TABLE_NAME = "transactions";

        // URI đầy đủ để truy cập bảng: content://.../transactions
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();

        // Tên các cột trong bảng
        public static final String COLUMN_INVOICE_NUMBER = "invoice_number"; // Số hóa đơn
        public static final String COLUMN_TYPE          = "type";            // Loại giao dịch
        public static final String COLUMN_AMOUNT        = "amount";          // Số tiền
        public static final String COLUMN_CURRENCY      = "currency";        // Đơn vị tiền tệ
        public static final String COLUMN_HOLDER_NAME   = "holder_name";     // Tên người giao dịch
        public static final String COLUMN_DATE_TIME     = "date_time";       // Thời gian giao dịch

        // Giá trị hợp lệ cho cột type
        public static final String TYPE_SALE   = "SALE";
        public static final String TYPE_REFUND = "REFUND";

        // Giá trị hợp lệ cho cột currency
        public static final String CURRENCY_VND = "VND";
        public static final String CURRENCY_USD = "USD";
    }
}
