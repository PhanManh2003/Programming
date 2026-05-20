package com.example.simpleproductmanager;

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
