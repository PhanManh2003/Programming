package com.example.simpleproductmanager;

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
