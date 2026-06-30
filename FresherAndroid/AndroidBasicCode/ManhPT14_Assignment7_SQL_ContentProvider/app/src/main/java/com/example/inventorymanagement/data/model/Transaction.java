package com.example.inventorymanagement.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Entity: đánh dấu class này là một bảng trong Room database.
 * tableName phải khớp với tên bảng trong TransactionContract để ContentProvider
 * và Room cùng trỏ vào đúng một bảng.
 */
@Entity(tableName = "transactions")
public class Transaction {

    // @PrimaryKey(autoGenerate = true): Room tự tăng ID, không cần truyền vào khi insert.
    // @ColumnInfo(name = "_id"): ánh xạ field "id" → cột "_id" trong SQLite
    // (BaseColumns._ID = "_id", ContentProvider yêu cầu cột này tồn tại).
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "invoice_number")
    private int invoiceNumber;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "amount")
    private double amount;

    @ColumnInfo(name = "currency")
    private String currency;

    @ColumnInfo(name = "holder_name")
    private String holderName;

    @ColumnInfo(name = "date_time")
    private String dateTime;

    public Transaction() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(int invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
}
