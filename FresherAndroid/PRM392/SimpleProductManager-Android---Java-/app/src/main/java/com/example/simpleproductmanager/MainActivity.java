package com.example.simpleproductmanager;

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