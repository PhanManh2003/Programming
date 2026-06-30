package com.example.contactapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;
import com.example.contactapp.adapter.ContactAdapter;
import com.example.contactapp.model.Contact;
import com.example.contactapp.repository.ContactRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ContactListFragment extends Fragment {

    private ContactAdapter    adapter;
    private ContactRepository repository;
    private RecyclerView      recyclerView;
    private LinearLayout      layoutEmpty;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Báo fragment tự quản lý menu
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewContacts);
        layoutEmpty  = view.findViewById(R.id.layoutEmpty);
        FloatingActionButton fab = view.findViewById(R.id.fabAddContact);

        repository = new ContactRepository(requireContext());

        // Setup RecyclerView
        adapter = new ContactAdapter(contact -> openDetail(contact));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        // FAB → mở màn hình thêm mới
        fab.setOnClickListener(v -> openAdd());

        // Set tiêu đề Toolbar
        requireActivity().setTitle(getString(R.string.title_contacts));

        loadContacts();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Refresh list mỗi lần quay lại (sau khi add/edit/delete)
        loadContacts();
        requireActivity().setTitle(getString(R.string.title_contacts));
    }

    // ── Load dữ liệu ────────────────────────────────────────────────────────
    private void loadContacts() {
        repository.getAll(contacts -> requireActivity().runOnUiThread(() -> {
            adapter.setContacts(contacts);
            showEmptyIfNeeded(contacts);
        }));
    }

    private void showEmptyIfNeeded(List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            layoutEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            layoutEmpty.setVisibility(View.GONE);
        }
    }

    // ── Menu: Search + Add + Delete ─────────────────────────────────────────
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.hint_search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.trim().isEmpty()) {
                    loadContacts();
                } else {
                    repository.search(newText.trim(), contacts ->
                            requireActivity().runOnUiThread(() -> {
                                adapter.setContacts(contacts);
                                showEmptyIfNeeded(contacts);
                            }));
                }
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            openAdd();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // ── Điều hướng ──────────────────────────────────────────────────────────
    private void openDetail(Contact contact) {
        ContactDetailFragment detailFragment =
                ContactDetailFragment.newInstance(contact.getId());
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    private void openAdd() {
        ContactEditFragment editFragment = ContactEditFragment.newInstanceAdd();
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, editFragment)
                .addToBackStack(null)
                .commit();
    }
}
