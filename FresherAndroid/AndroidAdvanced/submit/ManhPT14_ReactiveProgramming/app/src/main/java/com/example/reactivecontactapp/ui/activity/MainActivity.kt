package com.example.reactivecontactapp.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reactivecontactapp.ContactApp
import com.example.reactivecontactapp.R
import com.example.reactivecontactapp.data.local.Contact
import com.example.reactivecontactapp.databinding.ActivityMainBinding
import com.example.reactivecontactapp.ui.adapter.ContactAdapter
import com.example.reactivecontactapp.ui.dialog.AddEditContactDialog
import com.example.reactivecontactapp.utils.AppSchedulerProvider
import com.example.reactivecontactapp.viewmodel.ContactViewModel
import com.example.reactivecontactapp.viewmodel.ContactViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContactAdapter

    private val viewModel: ContactViewModel by lazy {
        val app = application as ContactApp
        val factory = ContactViewModelFactory(app.repository, AppSchedulerProvider())
        ViewModelProvider(this, factory)[ContactViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSearchView()
        setupObservers()
        setupFab()

    }

    private fun setupRecyclerView() {
        adapter = ContactAdapter(
            onEditClick = { contact -> showEditDialog(contact) },
            onDeleteClick = { contact -> showDeleteConfirmDialog(contact) }
        )
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = adapter
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchContacts(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchContacts(newText.orEmpty())
                return true
            }
        })
    }

    private fun setupObservers() {
        viewModel.contacts.observe(this) { list ->
            adapter.submitList(list)
            binding.tvEmpty.visibility =
                if (list.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        }

        viewModel.error.observe(this) { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        viewModel.actionSuccess.observe(this) { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupFab() {
        binding.fabAdd.setOnClickListener {
            AddEditContactDialog(this, onSave = { contact ->
                viewModel.addContact(contact)
            }).show()
        }
    }

    private fun showEditDialog(contact: Contact) {
        AddEditContactDialog(this, existingContact = contact, onSave = { updated ->
            viewModel.updateContact(updated)
        }).show()
    }

    private fun showDeleteConfirmDialog(contact: Contact) {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_contact_title)
            .setMessage(getString(R.string.delete_contact_message, contact.name))
            .setPositiveButton(R.string.delete) { _, _ -> viewModel.deleteContact(contact) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
}