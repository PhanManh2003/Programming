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
import com.example.hotelroomdb.adapter.RoomAdapter
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentRoomListBinding
import com.example.hotelroomdb.repository.RoomRepository
import com.example.hotelroomdb.viewmodel.RoomViewModel
import kotlinx.coroutines.launch

class RoomListFragment : Fragment() {

    private var _binding: FragmentRoomListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RoomViewModel
    private lateinit var adapter: RoomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        val repository = RoomRepository(db.roomDao(), db.roomTypeDao())
        viewModel = ViewModelProvider(this, RoomViewModel.factory(repository))[RoomViewModel::class.java]

        adapter = RoomAdapter()
        binding.recyclerViewRooms.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewRooms.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.roomsWithType.collect { rooms ->
                    adapter.submitList(rooms)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
