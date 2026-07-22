package com.example.contactappflow.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.contactappflow.databinding.ActivityMainBinding
import com.example.contactappflow.ui.adapter.ContactAdapter
import com.example.contactappflow.viewmodel.ContactViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.contactappflow.data.local.Contact
import com.example.contactappflow.ui.dialog.AddEditContactDialog
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import com.example.contactappflow.ContactApp
import com.example.contactappflow.viewmodel.ContactViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContactAdapter

    private val viewModel: ContactViewModel by lazy {
        val app = application as ContactApp
        val factory = ContactViewModelFactory(app.repository)
        ViewModelProvider(this, factory)[ContactViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSearchView()
        observeViewModel()
        setupFab()
    }

    private fun setupRecyclerView() {
        adapter = ContactAdapter(
            onEditClick = { contact -> showEditDialog(contact) },
            onDeleteClick = { contact -> confirmDelete(contact) }
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

    private fun observeViewModel() {
        // Collect danh sách contact - tự dừng khi Activity không ở foreground (STARTED)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.contacts.collect { list ->
                    adapter.submitList(list)
                    binding.tvEmpty.visibility =
                        if (list.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
                }
            }
        }

        // Collect lỗi
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.error.collect { msg ->
                    if (msg != null) {
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                        viewModel.clearError()
                    }
                }
            }
        }

        // Collect thông báo thành công
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.actionSuccess.collect { msg ->
                    if (msg != null) {
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                        viewModel.clearActionSuccess()
                    }
                }
            }
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

    private fun confirmDelete(contact: Contact) {
        AlertDialog.Builder(this)
            .setTitle("Delete contact")
            .setMessage("Are you sure you want to delete ${contact.name}?")
            .setPositiveButton("Delete") { _, _ -> viewModel.deleteContact(contact) }
            .setNegativeButton("Cancel", null)
            .show()
    }
}