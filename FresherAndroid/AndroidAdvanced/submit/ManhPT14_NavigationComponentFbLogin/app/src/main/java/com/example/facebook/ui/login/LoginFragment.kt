package com.example.facebook.ui.login

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.facebook.R
import com.example.facebook.databinding.FragmentLoginBinding
import com.example.facebook.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels()
    private var isPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Nhận email từ InputInfoFragment (nếu có)
        val passedEmail = arguments?.getString("email") ?: ""
        if (passedEmail.isNotEmpty()) {
            binding.etEmail.setText(passedEmail)
            binding.etPassword.requestFocus() // Focus vào ô pass luôn nếu đã có email
        }

        // Toggle Password Visibility
        binding.ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                // Thay đổi icon sang eye_on nếu có, ở đây tạm thời chỉ xử lý input type
            } else {
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            binding.etPassword.setSelection(binding.etPassword.text.length)
        }

        // Log In Button
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()
            
            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            viewModel.login(email, pass)
        }

        // Forgot Password Button
        binding.tvForgotPassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val bundle = bundleOf("email" to email)
            findNavController().navigate(R.id.action_login_to_forgotPassword, bundle)
        }

        // Observe Login Result
        viewModel.loginResult.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                Toast.makeText(context, "Đăng nhập thành công: ${user.name}", Toast.LENGTH_LONG).show()
                // Ở đây thường sẽ lưu session (DataStore/SharedPreferences) và navigate sang Home
                // Tạm thời show Toast vì assignment chỉ yêu cầu UI Login
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { msg ->
            if (msg.isNotEmpty()) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}