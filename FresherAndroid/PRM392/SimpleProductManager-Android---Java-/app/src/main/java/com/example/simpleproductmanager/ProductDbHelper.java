package com.example.simpleproductmanager;

// ProductDbHelper.java
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class ProductDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "goods.db"; // Tên cơ sở dữ liệu
    private static final String TABLE_PRODUCTS = "product"; // Tên bảng

    // Tên cột
    private static final String KEY_ID = "Id";
    private static final String KEY_PRODUCT_NAME = "ProductName";
    private static final String KEY_PRODUCT_DESCRIPTION = "ProductDescription";
    private static final String KEY_PRODUCT_PRICE = "ProductPrice";

    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng sản phẩm
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_PRODUCT_DESCRIPTION + " TEXT,"
                + KEY_PRODUCT_PRICE + " REAL" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nâng cấp cơ sở dữ liệu (xóa bảng cũ và tạo lại)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    // Thêm sản phẩm mới
    public long addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues(); // Sử dụng ContentValues
        values.put(KEY_PRODUCT_NAME, product.getName());
        values.put(KEY_PRODUCT_DESCRIPTION, product.getDescription());
        values.put(KEY_PRODUCT_PRICE, product.getPrice());

        long id = db.insert(TABLE_PRODUCTS, null, values);
        db.close();
        return id;
    }

    // Lấy một sản phẩm theo ID
    public Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS, new String[]{KEY_ID,
                        KEY_PRODUCT_NAME, KEY_PRODUCT_DESCRIPTION, KEY_PRODUCT_PRICE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Product product = null;
        if (cursor != null && cursor.getCount() > 0) {
            product = new Product(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getDouble(3));
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return product;
    }

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); // Dữ liệu trả về dưới dạng Cursor

        // Duyệt qua tất cả các hàng và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getDouble(3));
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productList;
    }

    // Cập nhật sản phẩm
    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, product.getName());
        values.put(KEY_PRODUCT_DESCRIPTION, product.getDescription());
        values.put(KEY_PRODUCT_PRICE, product.getPrice());

        // Cập nhật hàng
        int result = db.update(TABLE_PRODUCTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
        db.close();
        return result;
    }

    // Xóa sản phẩm
    public void deleteProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
        db.close();
    }
}
