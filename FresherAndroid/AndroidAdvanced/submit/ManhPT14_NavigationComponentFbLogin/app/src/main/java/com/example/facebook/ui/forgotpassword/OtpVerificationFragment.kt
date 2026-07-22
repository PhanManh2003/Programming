package com.example.facebook.ui.forgotpassword

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.facebook.R
import com.example.facebook.databinding.FragmentOtpVerificationBinding
import com.example.facebook.viewmodel.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpVerificationFragment : Fragment() {

    private var _binding: FragmentOtpVerificationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ForgotPasswordViewModel by activityViewModels()

    // Handler để lặp lại Toast mỗi 3 giây
    private val handler = Handler(Looper.getMainLooper())
    private var currentToast: Toast? = null
    private var toastRunnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = arguments?.getString("email") ?: ""
        binding.tvEmail.text = email

        binding.btnBack.setOnClickListener {
            stopOtpToast()
            findNavController().navigateUp()
        }

        // Lấy OTP đã generate từ ForgotPasswordFragment (không generate lại)
        val otp = viewModel.otpGenerated.value ?: ""
        if (otp.isNotEmpty()) {
            startRepeatingOtpToast(otp)
        }

        binding.btnContinue.setOnClickListener {
            val inputOtp = binding.etOtp.text.toString().trim()

            if (inputOtp.isEmpty()) {
                Toast.makeText(context, "Vui lòng nhập mã OTP", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (viewModel.verifyOtp(inputOtp)) {
                // OTP đúng -> dừng toast và sang màn Reset Password
                stopOtpToast()
                val bundle = bundleOf("email" to email)
                findNavController().navigate(R.id.action_otp_to_resetPassword, bundle)
            } else {
                Toast.makeText(context, "Mã OTP không chính xác", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /** Bắt đầu hiển thị Toast OTP, tự lặp lại mỗi 3 giây để không bị tắt */
    private fun startRepeatingOtpToast(otp: String) {
        toastRunnable = object : Runnable {
            override fun run() {
                currentToast?.cancel()
                currentToast = Toast.makeText(context, "Mã OTP: $otp", Toast.LENGTH_LONG)
                currentToast?.show()
                // Lặp lại sau 3 giây (Toast LENGTH_LONG = ~3.5s nên kịp show lại)
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(toastRunnable!!)
    }

    /** Dừng Toast lặp khi rời màn hình */
    private fun stopOtpToast() {
        toastRunnable?.let { handler.removeCallbacks(it) }
        currentToast?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        stopOtpToast()
        _binding = null
    }
}