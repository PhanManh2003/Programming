package com.example.facebook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.facebook.R
import com.example.facebook.data.local.entity.UserEntity
import com.example.facebook.data.repository.UserRepository
import com.example.facebook.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Seed Fake Data để test (Chỉ add nếu DB đang trống để tránh trùng lặp)
        lifecycleScope.launch {
            if (userRepository.findByEmail("sanjayshendy123@gmail.com") == null) {
                userRepository.insertUser(
                    UserEntity(
                        name = "Sanjay Shendy",
                        email = "sanjayshendy123@gmail.com",
                        password = "Sanjay1234",
                        avatarResId = R.drawable.ic_launcher_background // Tạm dùng icon mặc định
                    )
                )
            }
            if (userRepository.findByEmail("manhamsterdam2003@gmail.com") == null) {
                userRepository.insertUser(
                    UserEntity(
                        name = "Manh Phan",
                        email = "manhamsterdam2003@gmail.com",
                        password = "manhalex2003",
                        avatarResId = R.drawable.ic_launcher_background
                    )
                )
            }
        }
    }
}