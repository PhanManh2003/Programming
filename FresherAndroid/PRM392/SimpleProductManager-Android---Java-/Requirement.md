
---

### **Bài tập thực hành: Ứng dụng Quản lý Sản phẩm đơn giản**

**Mục tiêu:**

*   **Cách làm việc giữa Activity và XML:** Hiểu cách bố cục XML được "inflate" (biến bản thiết kế thành giao diện thực tế) trong Activity.
*   **Cách binding các UI element với Activity:** Biết cách liên kết các thành phần giao diện (UI elements) đã định nghĩa trong XML với mã Java trong Activity để thao tác.
*   **Cách triển khai RecyclerView:** Xây dựng một danh sách cuộn hiệu quả để hiển thị dữ liệu.
*   **Setup database để đổ data vào RecyclerView:** Thiết lập cơ sở dữ liệu SQLite cục bộ để lưu trữ và truy xuất dữ liệu sản phẩm, sau đó đổ dữ liệu này vào RecyclerView.

---

**Các bước thực hiện:**

**Bước 1: Tạo dự án Android mới**

1.  Mở **Android Studio**.
2.  Chọn **"Start a new Android Studio project"**.
3.  Chọn mẫu **"Empty Activity"** và nhấn **Next**.
4.  Cấu hình dự án:
    *   **Name:** `SimpleProductManager`
    *   **Package name:** `com.example.simpleproductmanager` (hoặc tên gói của bạn)
    *   **Language:** `Java`
    *   **Minimum SDK level:** Chọn API Level 21 (hoặc theo yêu cầu của bạn).
    *   Nhấn **Finish**.

**Bước 2: Định nghĩa cấu trúc dữ liệu (Model)**

Tạo một lớp Java mới để đại diện cho một sản phẩm.

1.  Trong thư mục `java > com.example.simpleproductmanager`, tạo một lớp Java mới tên là `Product.java`.
2.  Thêm các thuộc tính, constructor và getter/setter cho lớp `Product`:
    ```java
    // Product.java
    public class Product {
        private int id;
        private String name;
        private String description;
        private double price;

        public Product(int id, String name, String description, double price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public String getDescription() { return description; }
        public double getPrice() { return price; }

        // Setters (nếu cần thay đổi dữ liệu sau khi tạo object)
        public void setId(int id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setDescription(String description) { this.description = description; }
        public void setPrice(double price) { this.price = price; }
    }
    ```

**Bước 3: Thiết kế bố cục cho một mục (item) của RecyclerView**

Đây là bố cục cho từng hàng trong danh sách sản phẩm.

1.  Trong thư mục `res > layout`, tạo một tệp bố cục XML mới tên là `item_product.xml`.
2.  Thêm các `TextView` để hiển thị tên và giá sản phẩm:
    ```xml
    <!-- item_product.xml -->
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp"
        android:clickable="true"
        android:focusable="true"
        android:background="?android:attr/selectableItemBackground">

        <TextView
            android:id="@+id/textViewProductName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textStyle="bold"
            android:textSize="18sp"
            android:text="Tên sản phẩm" />

        <TextView
            android:id="@+id/textViewProductPrice"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="14sp"
            android:text="Giá: 0.00 VND" />

    </LinearLayout>
    ```

**Bước 4: Thiết kế giao diện chính (MainActivity)**

Giao diện này sẽ chứa `RecyclerView`.

1.  Mở tệp `activity_main.xml`.
2.  Thêm một `RecyclerView` vào bố cục. `RecyclerView` là một `View` có khả năng hiển thị danh sách các mục có thể cuộn và tái sử dụng `View` hiệu quả.
    ```xml
    <!-- activity_main.xml -->
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerViewProducts"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:padding="8dp"
            android:clipToPadding="false" />

    </RelativeLayout>
    ```

**Bước 5: Thêm dependency cho RecyclerView**

1.  Mở tệp `build.gradle (Module: app)`.
2.  Thêm dependency cho RecyclerView vào phần `dependencies`:
    ```gradle
    // build.gradle (Module: app)
    dependencies {
        // ... các dependency khác
        implementation 'androidx.recyclerview:recyclerview:1.2.1' // Hoặc phiên bản mới nhất
        implementation 'androidx.cardview:cardview:1.0.0' // Tùy chọn, để làm đẹp item
    }
    ```
3.  Đồng bộ hóa dự án bằng cách nhấp vào "Sync Now" ở thanh thông báo.

**Bước 6: Triển khai Adapter cho RecyclerView**

`ProductAdapter` sẽ là cầu nối giữa dữ liệu `List<Product>` và `RecyclerView`.

1.  Tạo một lớp Java mới tên là `ProductAdapter.java`.
2.  Lớp này sẽ kế thừa từ `RecyclerView.Adapter<ProductAdapter.ProductViewHolder>` và chứa lớp `ProductViewHolder` bên trong.
    ```java
    // ProductAdapter.java
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;
    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;
    import java.util.List;

    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        private final LayoutInflater mInflater;
        private List<Product> mProductList; // Cached copy of products
        private OnItemClickListener mListener;

        // Interface để xử lý sự kiện click item
        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            mListener = listener;
        }

        public ProductAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // "Inflate" bố cục XML cho một mục sản phẩm
            View itemView = mInflater.inflate(R.layout.item_product, parent, false);
            return new ProductViewHolder(itemView, mListener);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            // Gán dữ liệu vào các View của từng item
            if (mProductList != null) {
                Product current = mProductList.get(position);
                holder.productNameTextView.setText(current.getName());
                holder.productPriceTextView.setText("Giá: " + String.format("%.2f", current.getPrice()) + " VND");
            } else {
                // Trường hợp không có dữ liệu
                holder.productNameTextView.setText("Không có sản phẩm");
                holder.productPriceTextView.setText("N/A");
            }
        }

        @Override
        public int getItemCount() {
            // Trả về số lượng sản phẩm trong danh sách
            return mProductList != null ? mProductList.size() : 0;
        }

        // Phương thức để cập nhật danh sách sản phẩm
        public void setProducts(List<Product> products) {
            mProductList = products;
            notifyDataSetChanged(); // Thông báo cho Adapter rằng dữ liệu đã thay đổi
        }

        // Lớp ViewHolder để giữ các tham chiếu đến View trong mỗi item
        static class ProductViewHolder extends RecyclerView.ViewHolder {
            private final TextView productNameTextView;
            private final TextView productPriceTextView;

            private ProductViewHolder(View itemView, final OnItemClickListener listener) {
                super(itemView);
                // "Bind" các UI element từ item_product.xml
                productNameTextView = itemView.findViewById(R.id.textViewProductName);
                productPriceTextView = itemView.findViewById(R.id.textViewProductPrice);

                // Thiết lập OnClickListener cho toàn bộ item
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onItemClick(position);
                            }
                        }
                    }
                });
            }
        }
    }
    ```

**Bước 7: Thiết lập cơ sở dữ liệu SQLite cục bộ**

Chúng ta sẽ sử dụng `SQLiteOpenHelper` để quản lý cơ sở dữ liệu.

1.  Tạo một lớp Java mới tên là `ProductDbHelper.java`.
2.  Lớp này sẽ chịu trách nhiệm tạo, cập nhật cơ sở dữ liệu và thực hiện các thao tác CRUD (Create, Read, Update, Delete).
    ```java
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
    ```

**Bước 8: Hiển thị dữ liệu trong MainActivity**

Chúng ta sẽ kết nối `RecyclerView` với `ProductAdapter` và lấy dữ liệu từ `ProductDbHelper`.

1.  Mở tệp `MainActivity.java`.
2.  "Bind" `RecyclerView`, khởi tạo `ProductAdapter` và `ProductDbHelper`, sau đó thiết lập `RecyclerView`.
    ```java
    // MainActivity.java
    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;
    import android.content.Intent;
    import android.view.View;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        private RecyclerView mRecyclerView;
        private ProductAdapter mAdapter;
        private ProductDbHelper mDbHelper;
        private List<Product> mProductList;

        // Mã yêu cầu để nhận kết quả từ Activity thêm/sửa sản phẩm
        public static final int ADD_PRODUCT_REQUEST_CODE = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); // "Inflate" activity_main.xml

            mDbHelper = new ProductDbHelper(this);

            // Khởi tạo RecyclerView
            mRecyclerView = findViewById(R.id.recyclerViewProducts); // "Bind" RecyclerView

            // Khởi tạo Adapter
            mAdapter = new ProductAdapter(this);
            mRecyclerView.setAdapter(mAdapter);

            // Thiết lập LayoutManager (ví dụ: LinearLayoutManager để hiển thị danh sách dọc)
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Thêm dữ liệu mẫu vào DB nếu rỗng và hiển thị
            initializeDataAndDisplay();

            // Thiết lập lắng nghe sự kiện click cho các mục trong RecyclerView
            mAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    // Mở ProductDetailActivity khi một item được click
                    if (mProductList != null && position < mProductList.size()) {
                        Product clickedProduct = mProductList.get(position);
                        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                        // Truyền ID sản phẩm qua Intent
                        intent.putExtra("PRODUCT_ID", clickedProduct.getId());
                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        protected void onResume() {
            super.onResume();
            // Cập nhật lại danh sách khi Activity trở lại foreground
            // Điều này đảm bảo dữ liệu mới thêm/sửa/xóa được hiển thị
            loadProductsAndDisplay();
        }

        private void initializeDataAndDisplay() {
            mProductList = mDbHelper.getAllProducts();
            if (mProductList.isEmpty()) {
                // Thêm một số sản phẩm mẫu nếu cơ sở dữ liệu trống
                mDbHelper.addProduct(new Product(0, "Laptop Gaming", "Laptop mạnh mẽ cho game thủ", 25000000.00));
                mDbHelper.addProduct(new Product(0, "Điện thoại thông minh", "Điện thoại đời mới, camera chất lượng cao", 18000000.00));
                mDbHelper.addProduct(new Product(0, "Tai nghe Bluetooth", "Tai nghe không dây chống ồn", 1500000.00));
            }
            loadProductsAndDisplay();
        }

        private void loadProductsAndDisplay() {
            mProductList = mDbHelper.getAllProducts();
            mAdapter.setProducts(mProductList); // Cập nhật dữ liệu cho Adapter
        }
    }
    ```

**Bước 9: Tạo Activity chi tiết sản phẩm (ProductDetailActivity)**

Activity này sẽ hiển thị thông tin chi tiết của sản phẩm được chọn từ danh sách.

1.  Tạo một "Empty Activity" mới tên là `ProductDetailActivity.java`.
2.  Mở tệp `activity_product_detail.xml`.
3.  Thêm các `TextView` và `ImageView` (tùy chọn) để hiển thị chi tiết sản phẩm.
    ```xml
    <!-- activity_product_detail.xml -->
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="16dp"
        tools:context=".ProductDetailActivity">

        <TextView
            android:id="@+id/detailProductName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="24sp"
            android:textStyle="bold"
            android:layout_marginBottom="8dp"
            android:text="Tên sản phẩm chi tiết" />

        <TextView
            android:id="@+id/detailProductDescription"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            android:layout_marginBottom="8dp"
            android:text="Mô tả chi tiết về sản phẩm..." />

        <TextView
            android:id="@+id/detailProductPrice"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20sp"
            android:textColor="@android:color/holo_green_dark"
            android:text="Giá: 0.00 VND" />

        <!-- Có thể thêm ImageView ở đây nếu có hình ảnh sản phẩm -->
        <!-- <ImageView
            android:id="@+id/detailProductImage"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:layout_marginTop="16dp"
            android:scaleType="centerCrop"
            android:src="@drawable/ic_launcher_background" /> -->

    </LinearLayout>
    ```
4.  Mở tệp `ProductDetailActivity.java`.
5.  "Bind" các `View`, nhận `product_id` từ `Intent` và hiển thị chi tiết sản phẩm.
    ```java
    // ProductDetailActivity.java
    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.TextView;

    public class ProductDetailActivity extends AppCompatActivity {

        private TextView productNameTextView;
        private TextView productDescriptionTextView;
        private TextView productPriceTextView;
        private ProductDbHelper mDbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_product_detail); // "Inflate" activity_product_detail.xml

            mDbHelper = new ProductDbHelper(this);

            // "Bind" các UI element
            productNameTextView = findViewById(R.id.detailProductName);
            productDescriptionTextView = findViewById(R.id.detailProductDescription);
            productPriceTextView = findViewById(R.id.detailProductPrice);

            // Lấy ID sản phẩm từ Intent
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                int productId = extras.getInt("PRODUCT_ID", -1);
                if (productId != -1) {
                    Product product = mDbHelper.getProduct(productId);
                    if (product != null) {
                        // Hiển thị thông tin sản phẩm
                        productNameTextView.setText(product.getName());
                        productDescriptionTextView.setText(product.getDescription());
                        productPriceTextView.setText("Giá: " + String.format("%.2f", product.getPrice()) + " VND");
                    } else {
                        productNameTextView.setText("Không tìm thấy sản phẩm");
                        productDescriptionTextView.setText("");
                        productPriceTextView.setText("");
                    }
                }
            }
        }
    }
    ```

**Bước 10: Khai báo Activity trong AndroidManifest.xml**

Đảm bảo `ProductDetailActivity` được khai báo trong `AndroidManifest.xml`.

1.  Mở tệp `AndroidManifest.xml`.
2.  Thêm thẻ `<activity>` cho `ProductDetailActivity`:
    ```xml
    <!-- AndroidManifest.xml -->
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.example.simpleproductmanager">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.SimpleProductManager">

            <activity
                android:name=".MainActivity"
                android:exported="true">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <!-- Khai báo ProductDetailActivity -->
            <activity android:name=".ProductDetailActivity"
                android:exported="false" />

        </application>

    </manifest>
    ```

**Tổng kết các nội dung đã minh họa:**

*   **Cách làm việc giữa Activity và XML:**
    *   `MainActivity` và `ProductDetailActivity` sử dụng `setContentView(R.layout.activity_main)` và `setContentView(R.layout.activity_product_detail)` để "inflate" bố cục XML tương ứng.
    *   Bố cục của từng item trong `RecyclerView` được "inflate" từ `item_product.xml` trong `ProductAdapter` bằng `mInflater.inflate()`.
*   **Cách binding các UI element với Activity:**
    *   Các `TextView`, `RecyclerView` được liên kết với các biến Java trong `MainActivity`, `ProductDetailActivity` và `ProductViewHolder` bằng phương thức `findViewById(R.id.your_id)`.
    *   Dữ liệu được gán cho `TextView` bằng `setText()`.
*   **Cách triển khai RecyclerView:**
    *   Tạo `RecyclerView` trong `activity_main.xml`.
    *   Thiết kế bố cục `item_product.xml` cho từng mục.
    *   Triển khai `ProductAdapter` mở rộng `RecyclerView.Adapter` với `ProductViewHolder`.
    *   Sử dụng `LinearLayoutManager` và gán `mAdapter` cho `mRecyclerView` trong `MainActivity`.
    *   Thiết lập `OnClickListener` cho các mục trong `RecyclerView` để tương tác.
*   **Setup database để đổ data vào RecyclerView:**
    *   Tạo lớp `ProductDbHelper` kế thừa `SQLiteOpenHelper` để tạo và quản lý cơ sở dữ liệu `goods.db` và bảng `product`.
    *   Triển khai các phương thức `addProduct()`, `getAllProducts()`, `getProduct()`, `updateProduct()`, `deleteProduct()` để thực hiện các thao tác CRUD với SQLite.
    *   Sử dụng `ContentValues` để thêm/cập nhật dữ liệu vào bảng.
    *   Trong `MainActivity`, lấy danh sách sản phẩm từ `ProductDbHelper` và cung cấp cho `ProductAdapter` thông qua `setProducts()`.
    *   Khi click vào một item, truyền `ID` sản phẩm qua `Intent` đến `ProductDetailActivity` và truy xuất chi tiết từ database.

Bạn có thể chạy ứng dụng trên thiết bị giả lập hoặc điện thoại thực để xem kết quả. Khi chạy lần đầu, ứng dụng sẽ tạo cơ sở dữ liệu và thêm một vài sản phẩm mẫu.