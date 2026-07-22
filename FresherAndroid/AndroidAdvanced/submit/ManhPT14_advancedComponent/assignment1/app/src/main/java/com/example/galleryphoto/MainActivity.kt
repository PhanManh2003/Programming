package com.example.galleryphoto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.galleryphoto.adapter.ImagePagerAdapter
import com.example.galleryphoto.model.ImageItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        // sample images
        val images = listOf(
            ImageItem(resId = R.drawable.billgate),
            ImageItem(resId = R.drawable.elon),
            ImageItem(resId = R.drawable.messi),
            ImageItem(resId = R.drawable.ronaldo),
            ImageItem(resId = R.drawable.stevejob),
            ImageItem(resId = R.drawable.trinhvanquyet),
            ImageItem(resId = R.drawable.truonggiabinh)
        )

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tvIndicator = findViewById<android.widget.TextView>(R.id.tvIndicator)

        viewPager.adapter = ImagePagerAdapter(images)

        // Cập nhật chỉ số trang khi vuốt
        updateIndicator(tvIndicator, 0, images.size)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicator(tvIndicator, position, images.size)
            }
        })
    }

    private fun updateIndicator(tv: android.widget.TextView, position: Int, total: Int) {
        tv.text = "Image ${position + 1}/$total"
    }
}