package com.example.contactapp.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contactapp.R;
import com.example.contactapp.model.Contact;
import com.example.contactapp.repository.ContactRepository;
import com.example.contactapp.utils.ImageUtils;

public class ContactDetailFragment extends Fragment {

    private static final String ARG_CONTACT_ID = "contact_id";

    private int contactId;
    private Contact currentContact;
    private ContactRepository repository;
    private boolean isFirstLoad = true;

    private TextView tvDetailName;
    private TextView tvDetailPhone;
    private TextView tvDetailEmail;
    private ImageView imgAvatarDetail;
    private TextView tvAvatarLetterDetail;
    private Button btnCall;
    private Button btnEdit;

    public static ContactDetailFragment newInstance(int contactId) {
        ContactDetailFragment fragment = new ContactDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CONTACT_ID, contactId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            contactId = getArguments().getInt(ARG_CONTACT_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDetailName = view.findViewById(R.id.tvDetailName);
        tvDetailPhone = view.findViewById(R.id.tvDetailPhone);
        tvDetailEmail = view.findViewById(R.id.tvDetailEmail);
        imgAvatarDetail = view.findViewById(R.id.imgAvatarDetail);
        tvAvatarLetterDetail = view.findViewById(R.id.tvAvatarLetterDetail);
        btnCall = view.findViewById(R.id.btnCall);
        btnEdit = view.findViewById(R.id.btnEdit);

        repository = new ContactRepository(requireContext());

        loadContact();

        btnCall.setOnClickListener(v -> callPhone());
        btnEdit.setOnClickListener(v -> openEdit());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstLoad) {
            isFirstLoad = false;
            return;
        }
        loadContact(); // reload sau khi quay lại từ EditFragment
    }

    private void loadContact() {
        repository.getById(contactId, contact -> {
            if (!isAdded()) return; // ← fix bug 1
            requireActivity().runOnUiThread(() -> {
                if (contact == null) return;
                currentContact = contact;
                bindViews(contact);
            });
        });
    }

    private void bindViews(Contact contact) {
        requireActivity().setTitle(contact.getName());
        tvDetailName.setText(contact.getName());
        tvDetailPhone.setText(contact.getPhone());

        String email = contact.getEmail();
        tvDetailEmail.setText((email != null && !email.isEmpty()) ? email : "—");

        String base64 = contact.getPhoto();
        if (base64 != null && !base64.isEmpty()) {
            Bitmap bmp = ImageUtils.base64ToBitmap(base64);
            if (bmp != null) {
                imgAvatarDetail.setImageBitmap(bmp);
                imgAvatarDetail.setVisibility(View.VISIBLE);
                tvAvatarLetterDetail.setVisibility(View.GONE);
                return;
            }
        }
        imgAvatarDetail.setVisibility(View.GONE);
        tvAvatarLetterDetail.setVisibility(View.VISIBLE);
        tvAvatarLetterDetail.setText(ImageUtils.getAvatarLetter(contact.getName()));
        if (tvAvatarLetterDetail.getBackground() != null) { // ← fix bug 4
            tvAvatarLetterDetail.getBackground()
                    .setTint(ImageUtils.getAvatarColor(contact.getName()));
        }
    }

    private void callPhone() {
        if (currentContact == null) return;
        String phone = currentContact.getPhone().replaceAll("\\s", "");
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(requireContext(),
                    getString(R.string.msg_no_call_app), Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_delete_contact) {
            confirmDelete();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmDelete() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Delete contact")
                .setMessage(getString(R.string.msg_delete_confirm))
                .setPositiveButton(getString(R.string.dialog_yes), (dialog, which) -> {
                    repository.delete(currentContact, rows -> {
                        if (!isAdded()) return; // ← fix bug 3
                        requireActivity().runOnUiThread(() -> {
                            Toast.makeText(requireContext(),
                                    getString(R.string.msg_delete_success),
                                    Toast.LENGTH_SHORT).show();
                            requireActivity().getSupportFragmentManager().popBackStack();
                        });
                    });
                })
                .setNegativeButton(getString(R.string.dialog_no), null)
                .show();
    }

    private void openEdit() {
        ContactEditFragment editFragment =
                ContactEditFragment.newInstanceEdit(contactId);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, editFragment)
                .addToBackStack(null)
                .commit();
    }
}