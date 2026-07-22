package com.example.contactappflow.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import com.example.contactappflow.data.local.Contact
import com.example.contactappflow.databinding.DialogAddEditContactBinding

class AddEditContactDialog(
    context: Context,
    private val existingContact: Contact? = null,
    private val onSave: (Contact) -> Unit
) : Dialog(context) {

    private lateinit var binding: DialogAddEditContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddEditContactBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        existingContact?.let {
            binding.edtName.setText(it.name)
            binding.edtPhone.setText(it.phone)
            binding.edtEmail.setText(it.email)
        }

        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString().trim()
            val phone = binding.edtPhone.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()

            if (!validateInput(name, phone, email)) return@setOnClickListener

            val contact = existingContact?.copy(
                name = name, phone = phone, email = email
            ) ?: Contact(name = name, phone = phone, email = email)

            onSave(contact)
            dismiss()
        }

        binding.btnCancel.setOnClickListener { dismiss() }
    }

    private fun validateInput(name: String, phone: String, email: String): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            binding.edtName.error = "Name cannot be empty"
            isValid = false
        }

        if (phone.isEmpty()) {
            binding.edtPhone.error = "Phone cannot be empty"
            isValid = false
        } else if (!PHONE_REGEX.matches(phone)) {
            binding.edtPhone.error = "Invalid phone number (9-11 digits)"
            isValid = false
        }

        if (email.isEmpty()) {
            binding.edtEmail.error = "Email cannot be empty"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "Invalid email address"
            isValid = false
        }

        return isValid
    }

    companion object {
        private val PHONE_REGEX = Regex("^[0-9]{9,11}$")
    }
}