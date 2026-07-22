package com.example.facebook.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.facebook.R
import com.example.facebook.databinding.FragmentForgotPasswordBinding
import com.example.facebook.viewmodel.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ForgotPasswordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lấy email truyền từ Login qua
        val passedEmail = arguments?.getString("email") ?: ""
        if (passedEmail.isNotEmpty()) {
            binding.etEmail.setText(passedEmail)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnFindAccount.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(context, "Vui lòng nhập email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Tìm tài khoản
            viewModel.findAccount(email)
        }

        // Observe kết quả tìm kiếm tài khoản
        viewModel.userFound.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                // Đã tìm thấy -> Generate OTP và chuyển màn
                val otp = viewModel.generateOtp()

                // Hiển thị Toast OTP để người dùng biết mã nhập vào (do không có hệ thống gửi mail thật)
                Toast.makeText(context, "Mã OTP của bạn là: $otp", Toast.LENGTH_LONG).show()

                val bundle = bundleOf("email" to user.email)
                findNavController().navigate(R.id.action_forgotPassword_to_otp, bundle)
            } else {
                Toast.makeText(context, "Không tìm thấy tài khoản với email này", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}