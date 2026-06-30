package com.example.hotelroomdb.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.hotelroomdb.database.AppDatabase
import com.example.hotelroomdb.databinding.FragmentOccupationFormBinding
import com.example.hotelroomdb.model.Occupation
import com.example.hotelroomdb.model.Client
import com.example.hotelroomdb.model.relation.RoomWithType
import com.example.hotelroomdb.repository.ClientRepository
import com.example.hotelroomdb.repository.OccupationRepository
import com.example.hotelroomdb.repository.RoomRepository
import com.example.hotelroomdb.viewmodel.ClientViewModel
import com.example.hotelroomdb.viewmodel.OccupationViewModel
import com.example.hotelroomdb.viewmodel.RoomViewModel
import kotlinx.coroutines.launch
import java.util.Calendar

class OccupationFormFragment : Fragment() {

    private var _binding: FragmentOccupationFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var roomViewModel: RoomViewModel
    private lateinit var clientViewModel: ClientViewModel
    private lateinit var occupationViewModel: OccupationViewModel

    private val roomItems = mutableListOf<RoomWithType>()
    private val clientItems = mutableListOf<Client>()
    private lateinit var roomSpinnerAdapter: ArrayAdapter<String>
    private lateinit var clientSpinnerAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOccupationFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = AppDatabase.getInstance(requireContext())
        roomViewModel = ViewModelProvider(
            this, RoomViewModel.factory(RoomRepository(db.roomDao(), db.roomTypeDao()))
        )[RoomViewModel::class.java]
        clientViewModel = ViewModelProvider(
            this, ClientViewModel.factory(ClientRepository(db.clientDao()))
        )[ClientViewModel::class.java]
        occupationViewModel = ViewModelProvider(
            this, OccupationViewModel.factory(OccupationRepository(db.occupationDao()))
        )[OccupationViewModel::class.java]

        roomSpinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mutableListOf())
        roomSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRoom.adapter = roomSpinnerAdapter

        clientSpinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mutableListOf())
        clientSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerClient.adapter = clientSpinnerAdapter

        binding.etCheckIn.setOnClickListener { showDatePicker(isCheckIn = true) }
        binding.etCheckOut.setOnClickListener { showDatePicker(isCheckIn = false) }

        binding.btnSave.setOnClickListener { saveOccupation() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    roomViewModel.roomsWithType.collect { rooms ->
                        roomItems.clear()
                        roomItems.addAll(rooms)
                        roomSpinnerAdapter.clear()
                        roomSpinnerAdapter.addAll(rooms.map { "Room ${it.room.roomNumber} (${it.roomType.typeName})" })
                        roomSpinnerAdapter.notifyDataSetChanged()
                    }
                }
                launch {
                    clientViewModel.clients.collect { clients ->
                        clientItems.clear()
                        clientItems.addAll(clients)
                        clientSpinnerAdapter.clear()
                        clientSpinnerAdapter.addAll(clients.map { "${it.fullName} — ${it.country}" })
                        clientSpinnerAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun showDatePicker(isCheckIn: Boolean) {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                val date = "%04d-%02d-%02d".format(year, month + 1, day)
                if (isCheckIn) binding.etCheckIn.setText(date)
                else binding.etCheckOut.setText(date)
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun saveOccupation() {
        val roomIndex = binding.spinnerRoom.selectedItemPosition
        val clientIndex = binding.spinnerClient.selectedItemPosition
        val checkIn = binding.etCheckIn.text?.toString()?.trim() ?: ""
        val checkOut = binding.etCheckOut.text?.toString()?.trim() ?: ""
        val extraText = binding.etExtraExpenses.text?.toString()?.trim() ?: "0"

        if (roomItems.isEmpty() || clientItems.isEmpty()) {
            Toast.makeText(requireContext(), "No rooms or clients available", Toast.LENGTH_SHORT).show()
            return
        }
        if (checkIn.isEmpty() || checkOut.isEmpty()) {
            Toast.makeText(requireContext(), "Please select check-in and check-out dates", Toast.LENGTH_SHORT).show()
            return
        }
        if (checkIn >= checkOut) {
            Toast.makeText(requireContext(), "Check-out must be after check-in", Toast.LENGTH_SHORT).show()
            return
        }

        val roomNumber = roomItems[roomIndex].room.roomNumber
        val clientId = clientItems[clientIndex].clientId
        val extraExpenses = extraText.toDoubleOrNull() ?: 0.0

        val occupation = Occupation(
            roomNumber = roomNumber,
            clientId = clientId,
            checkIn = checkIn,
            checkOut = checkOut,
            extraExpenses = extraExpenses
        )

        occupationViewModel.insert(occupation)
        Toast.makeText(requireContext(), "Occupation saved", Toast.LENGTH_SHORT).show()
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
