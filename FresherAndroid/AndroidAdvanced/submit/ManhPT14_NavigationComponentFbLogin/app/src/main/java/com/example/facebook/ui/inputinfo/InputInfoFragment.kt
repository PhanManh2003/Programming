package com.example.facebook.ui.inputinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.facebook.R
import com.example.facebook.databinding.FragmentInputInfoBinding
import com.example.facebook.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputInfoFragment : Fragment() {

    private var _binding: FragmentInputInfoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lấy danh sách user từ DB để hiển thị (Fake data seed)
        viewModel.allUsers.observe(viewLifecycleOwner) { users ->
            if (users.isNotEmpty()) {
                val user = users.first() // Lấy user đầu tiên (Sanjay)
                binding.tvUserName.text = user.name
                user.avatarResId?.let { binding.ivAvatar.setImageResource(it) }
            }
        }

        // Nhấn vào thẻ account (Sanjay Shendy) -> Chuyển sang Login và truyền sẵn email
        binding.layoutAccountCard.setOnClickListener {
            val email = viewModel.allUsers.value?.firstOrNull()?.email ?: ""
            val bundle = bundleOf("email" to email)
            findNavController().navigate(R.id.action_inputInfo_to_login, bundle)
        }

        // Nhấn "Log Into Another Account" -> Chuyển sang Login, truyền email rỗng
        binding.btnLogIntoAnother.setOnClickListener {
            val bundle = bundleOf("email" to "")
            findNavController().navigate(R.id.action_inputInfo_to_login, bundle)
        }

        // Nhấn "Find Your Account" -> Chuyển sang ForgotPassword
        binding.btnFindAccount.setOnClickListener {
            findNavController().navigate(R.id.action_inputInfo_to_forgotPassword)
        }
        
        binding.btnCreateAccount.setOnClickListener {
            // Có thể thêm tính năng Create Account sau, hiện tại ignore
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}