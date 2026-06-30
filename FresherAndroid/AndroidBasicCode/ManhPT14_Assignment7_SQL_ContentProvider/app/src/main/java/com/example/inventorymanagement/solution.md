# Requirement

**Objectives:**
- Learn how to create and interact with the SQLite database.
- Learn how to create an entity, DAO, and database classes.
- Have a basic understanding of SQL databases and the SQLite language.

**Assumptions — Transaction Data:**
- Transaction Type (SALE, REFUND)
- Amount
- Currency (VND, USD)
- Holder Name
- Date Time (tự set khi tạo transaction thành công)
- Invoice Number (tự tăng, reset khi user Clear Batch)

**Technical Requirements:**
- SQLite, ContentProvider
- Language: Java
- MVVM pattern
- Using Room (++ bonus) ✅

---

# Solution

## Kiến trúc MVVM

```
data/
  model/
    Transaction.java       — @Entity Room, ánh xạ tới bảng "transactions"
    RevenueStats.java      — POJO chứa tổng SALE/REFUND theo VND và USD
  db/
    TransactionContract.java — Hằng số tên bảng, cột, URI (không đổi)
    TransactionDao.java    — Room DAO: @Insert, @RawQuery
    AppDatabase.java       — @Database Room, thay thế DatabaseHelper
  provider/
    TransactionProvider.java — ContentProvider, dùng Room DAO bên trong

repository/
  TransactionRepository.java — Gọi ContentResolver → ContentProvider → Room DAO

viewmodel/
  TransactionViewModel.java  — AndroidViewModel, LiveData, xử lý filter

ui/
  adapter/  TransactionAdapter.java
  dialog/   AddTransactionDialog.java
  MainActivity.java
```

## Luồng dữ liệu

```
MainActivity → ViewModel → Repository → ContentResolver
                                              ↓
                                       ContentProvider
                                              ↓
                                         Room DAO
                                              ↓
                                           SQLite
```

## Features

| Feature | Mô tả |
|---|---|
| SALE | Dialog nhập Amount / Currency / Holder Name, tạo giao dịch bán |
| REFUND | Tương tự SALE nhưng type = REFUND |
| Invoice Number | Tự tăng qua SharedPreferences, reset về 0 khi Clear Batch |
| DateTime | Tự set tại thời điểm insert (`dd/MM/yyyy HH:mm:ss`) |
| Clear Batch | Xóa toàn bộ DB + reset invoice counter, có confirm dialog |
| Revenue Summary | Hiển thị SALE / REFUND / NET riêng theo VND và USD |
| Filter | 5 loại: None, Transaction Type, Date Time, Holder Name, Currency |

## Ghi chú kỹ thuật

- `DatabaseHelper.java` đã deprecated, không còn được dùng sau khi migrate sang Room.
- `ContentProvider` dùng `@RawQuery` + `SimpleSQLiteQuery` cho query/delete/update động,
  dùng `@Insert` (typed) cho insert — Room tự build SQL từ `@Entity`.
- `allowMainThreadQueries()` được bật vì ContentProvider chạy trên Binder thread,
  còn app là demo nên chấp nhận được.
