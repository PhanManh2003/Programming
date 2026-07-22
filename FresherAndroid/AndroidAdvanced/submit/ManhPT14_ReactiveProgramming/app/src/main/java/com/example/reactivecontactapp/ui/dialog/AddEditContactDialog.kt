package com.example.reactivecontactapp.ui.dialog

import android.app.Dialog
import android.content.Context
import android.util.Patterns
import android.view.LayoutInflater
import com.example.reactivecontactapp.R
import com.example.reactivecontactapp.data.local.Contact
import com.example.reactivecontactapp.databinding.DialogAddEditContactBinding

class AddEditContactDialog(
    context: Context,
    private val existingContact: Contact? = null,
    private val onSave: (Contact) -> Unit
) : Dialog(context) {

    private lateinit var binding: DialogAddEditContactBinding

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
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

            if (!validate(name, phone, email)) return@setOnClickListener

            val contact = existingContact?.copy(
                name = name, phone = phone, email = email
            ) ?: Contact(name = name, phone = phone, email = email)

            onSave(contact)
            dismiss()
        }

        binding.btnCancel.setOnClickListener { dismiss() }
    }

    private fun validate(name: String, phone: String, email: String): Boolean {
        var isValid = true

        if (name.isBlank()) {
            binding.edtName.error = context.getString(R.string.error_name_required)
            isValid = false
        }

        if (phone.isBlank()) {
            binding.edtPhone.error = context.getString(R.string.error_phone_required)
            isValid = false
        } else if (!Patterns.PHONE.matcher(phone).matches()) {
            binding.edtPhone.error = context.getString(R.string.error_phone_invalid)
            isValid = false
        }

        if (email.isNotBlank() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = context.getString(R.string.error_email_invalid)
            isValid = false
        }

        return isValid
    }
}