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
import com.example.hotelroomdb.activity.MainActivity
import com.example.hotelroomdb.adapter.OccupationAdapter
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentOccupationListBinding
import com.example.hotelroomdb.repository.OccupationRepository
import com.example.hotelroomdb.viewmodel.OccupationViewModel
import kotlinx.coroutines.launch

class OccupationListFragment : Fragment() {

    private var _binding: FragmentOccupationListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: OccupationViewModel
    private lateinit var adapter: OccupationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOccupationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        val repository = OccupationRepository(db.occupationDao())
        viewModel = ViewModelProvider(this, OccupationViewModel.factory(repository))[OccupationViewModel::class.java]

        adapter = OccupationAdapter()
        binding.recyclerViewOccupations.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewOccupations.adapter = adapter

        binding.fabAddOccupation.setOnClickListener {
            (requireActivity() as? MainActivity)?.showOccupationForm()
        }
        binding.btnExpenseReport.setOnClickListener {
            (requireActivity() as? MainActivity)?.showExpenseReport()
        }
        binding.btnRevenueReport.setOnClickListener {
            (requireActivity() as? MainActivity)?.showRevenueReport()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.occupationDetails.collect { occupations ->
                    adapter.submitList(occupations)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
