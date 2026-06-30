package com.example.ass1.view

/**
 * FILE: ContactAdapter.kt

 *
 * Mục đích: Adapter cho RecyclerView — chịu trách nhiệm hiển thị danh sách Contact.
 *
 * Cách hoạt động:
 * - Mỗi item trong list được inflate từ item_contact.xml
 * - Dùng Data Binding để gán dữ liệu (Contact) vào view
 * - Dùng DiffUtil để so sánh list cũ/mới và chỉ cập nhật những item thay đổi
 *   → animation mượt hơn, hiệu suất tốt hơn notifyDataSetChanged()
 *
 * Kế thừa ListAdapter thay vì RecyclerView.Adapter:
 * - ListAdapter tích hợp sẵn DiffUtil
 * - Chỉ cần gọi submitList(list) để cập nhật dữ liệu
 *
 * Thuộc tầng: VIEW (trong MVVM)
 */


import android.view.LayoutInflater                          // Công cụ tạo View từ XML
import android.view.ViewGroup                              // Container chứa các View
import androidx.recyclerview.widget.DiffUtil               // Thuật toán so sánh list
import androidx.recyclerview.widget.ListAdapter            // Adapter tích hợp DiffUtil
import androidx.recyclerview.widget.RecyclerView           // Base class của ViewHolder
import com.example.ass1.databinding.ItemContactBinding     // Class binding từ item_contact.xml (tên app: ass1)
import com.example.ass1.model.Contact                      // Model Contact
class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(DiffCallback()) {
    /**
     * ViewHolder: giữ tham chiếu đến các View trong 1 item
     * Mỗi ViewHolder tương ứng 1 hàng trong RecyclerView
     */
    inner class ContactViewHolder(
        private val binding: ItemContactBinding  // Binding của layout item_contact.xml
    ) : RecyclerView.ViewHolder(binding.root) { // binding.root = CardView (view gốc của item)
        /**
         * Gán dữ liệu Contact vào các View của item này
         */
        fun bind(contact: Contact) {
            binding.contact = contact            // Gán object Contact vào biến trong XML
            binding.executePendingBindings()     // Thực thi binding ngay lập tức (tránh lag khi scroll)
        }
    }
    /**
     * Được gọi khi RecyclerView cần tạo ViewHolder mới
     * (tức là khi chưa có đủ ViewHolder để tái sử dụng)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // Inflate layout item_contact.xml và tạo binding tương ứng
        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context), // Context để inflate
            parent,                              // ViewGroup cha
            false                                // attachToParent = false (RecyclerView tự quản lý)
        )
        return ContactViewHolder(binding)
    }
    /**
     * Được gọi khi RecyclerView muốn hiển thị data tại vị trí [position]
     * RecyclerView tái sử dụng ViewHolder cũ và bind dữ liệu mới vào
     */
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position)) // getItem(position): lấy Contact tại vị trí đó
    }
    /**
     * DiffCallback: thuật toán so sánh 2 list để tìm ra sự khác biệt
     * Giúp RecyclerView chỉ cập nhật những item thực sự thay đổi
     */
    class DiffCallback : DiffUtil.ItemCallback<Contact>() {
        // Kiểm tra 2 item có cùng ID không (cùng "danh tính")
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean =
            oldItem.id == newItem.id
        // Kiểm tra nội dung 2 item có hoàn toàn giống nhau không
        // data class tự sinh equals() so sánh tất cả fields
        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean =
            oldItem == newItem
    }
}