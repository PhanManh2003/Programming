package com.example.galleryphoto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryphoto.R
import com.example.galleryphoto.model.ImageItem

class ImagePagerAdapter(private val images: List<ImageItem>) :
    RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = images[position]
        if (item.resId != null) {
            holder.imageView.setImageResource(item.resId)
        } else if (!item.path.isNullOrEmpty()) {
            // Nếu dùng path từ bộ nhớ / URL, có thể dùng Glide/Coil ở đây
            holder.imageView.setImageURI(android.net.Uri.parse(item.path))
        }
    }

    override fun getItemCount(): Int = images.size
}