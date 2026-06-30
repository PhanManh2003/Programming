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
import com.example.hotelroomdb.adapter.ExpenseAdapter
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentExpenseReportBinding
import com.example.hotelroomdb.repository.OccupationRepository
import com.example.hotelroomdb.viewmodel.OccupationViewModel
import kotlinx.coroutines.launch

class ExpenseReportFragment : Fragment() {

    private var _binding: FragmentExpenseReportBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: OccupationViewModel
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpenseReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        val repository = OccupationRepository(db.occupationDao())
        viewModel = ViewModelProvider(this, OccupationViewModel.factory(repository))[OccupationViewModel::class.java]

        adapter = ExpenseAdapter()
        binding.recyclerViewExpenses.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewExpenses.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clientExpenses2023.collect { expenses ->
                    adapter.submitList(expenses)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
