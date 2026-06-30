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
import com.example.hotelroomdb.adapter.RevenueAdapter
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentRevenueReportBinding
import com.example.hotelroomdb.repository.OccupationRepository
import com.example.hotelroomdb.viewmodel.OccupationViewModel
import kotlinx.coroutines.launch

class RevenueReportFragment : Fragment() {

    private var _binding: FragmentRevenueReportBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: OccupationViewModel
    private lateinit var adapter: RevenueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRevenueReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        val repository = OccupationRepository(db.occupationDao())
        viewModel = ViewModelProvider(this, OccupationViewModel.factory(repository))[OccupationViewModel::class.java]

        adapter = RevenueAdapter()
        binding.recyclerViewRevenue.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewRevenue.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.yearlyRevenue.collect { revenue ->
                    adapter.submitList(revenue)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
