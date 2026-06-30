package com.example.hotelroomdb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelroomdb.adapter.ClientAdapter
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentClientListBinding
import com.example.hotelroomdb.repository.ClientRepository
import com.example.hotelroomdb.viewmodel.ClientViewModel
import kotlinx.coroutines.launch

class ClientListFragment : Fragment() {

    private var _binding: FragmentClientListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ClientViewModel
    private lateinit var adapter: ClientAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClientListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        val repository = ClientRepository(db.clientDao())
        viewModel = ViewModelProvider(this, ClientViewModel.factory(repository))[ClientViewModel::class.java]

        adapter = ClientAdapter()
        binding.recyclerViewClients.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewClients.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clients.collect { clients ->
                    adapter.submitList(clients)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
