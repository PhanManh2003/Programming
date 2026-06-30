package com.example.contactapp.fragment;

import android.graphics.Bitmap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contactapp.R;
import com.example.contactapp.model.Contact;
import com.example.contactapp.repository.ContactRepository;
import com.example.contactapp.utils.ImageUtils;
public class ContactEditFragment extends Fragment {

    private static final String ARG_CONTACT_ID = "contact_id";
    private static final String ARG_MODE       = "mode";
    private static final String MODE_ADD       = "add";
    private static final String MODE_EDIT      = "edit";

    private String            mode;
    private int               contactId = -1;
    private Contact           currentContact;
    private ContactRepository repository;
    private String            selectedPhotoBase64;

    private EditText    etName;
    private EditText    etPhone;
    private EditText    etEmail;
    private ImageView   imgEditAvatar;
    private TextView    tvEditAvatarLetter;
    private Button      btnSave;
    private Button      btnCancel;
    private FrameLayout frameEditAvatar;

    private final ActivityResultLauncher<String> pickImageLauncher =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null) handleImagePicked(uri);
            });

    public static ContactEditFragment newInstanceAdd() {
        ContactEditFragment fragment = new ContactEditFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MODE, MODE_ADD);
        fragment.setArguments(args);
        return fragment;
    }

    public static ContactEditFragment newInstanceEdit(int contactId) {
        ContactEditFragment fragment = new ContactEditFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MODE, MODE_EDIT);
        args.putInt(ARG_CONTACT_ID, contactId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mode      = getArguments().getString(ARG_MODE, MODE_ADD);
            contactId = getArguments().getInt(ARG_CONTACT_ID, -1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etName             = view.findViewById(R.id.etEditName);
        etPhone            = view.findViewById(R.id.etEditPhone);
        etEmail            = view.findViewById(R.id.etEditEmail);
        imgEditAvatar      = view.findViewById(R.id.imgEditAvatar);
        tvEditAvatarLetter = view.findViewById(R.id.tvEditAvatarLetter);
        frameEditAvatar    = view.findViewById(R.id.frameEditAvatar);
        btnSave            = view.findViewById(R.id.btnSave);
        btnCancel          = view.findViewById(R.id.btnCancel);

        repository = new ContactRepository(requireContext());

        if (MODE_ADD.equals(mode)) {
            requireActivity().setTitle(getString(R.string.title_add));
        } else {
            requireActivity().setTitle(getString(R.string.title_edit));
            loadExistingContact();
        }

        frameEditAvatar.setOnClickListener(v -> pickImageLauncher.launch("image/*"));
        btnSave.setOnClickListener(v -> saveContact());
        btnCancel.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack());
    }

    private void loadExistingContact() {
        repository.getById(contactId, contact -> {
            if (!isAdded()) return; // ← fix bug 1
            requireActivity().runOnUiThread(() -> {
                if (contact == null) return;
                currentContact = contact;
                etName.setText(contact.getName());
                etPhone.setText(contact.getPhone());
                etEmail.setText(contact.getEmail() != null ? contact.getEmail() : "");
                selectedPhotoBase64 = contact.getPhoto();
                updateAvatarPreview(contact.getName(), contact.getPhoto());
            });
        });
    }

    private void handleImagePicked(android.net.Uri uri) {
        String base64 = ImageUtils.uriToBase64(requireContext(), uri);
        if (base64 != null) {
            selectedPhotoBase64 = base64;
            Bitmap bmp = ImageUtils.base64ToBitmap(base64);
            imgEditAvatar.setImageBitmap(bmp);
            imgEditAvatar.setVisibility(View.VISIBLE);
            tvEditAvatarLetter.setVisibility(View.GONE);
        }
    }

    private void updateAvatarPreview(String name, String base64) {
        if (base64 != null && !base64.isEmpty()) {
            Bitmap bmp = ImageUtils.base64ToBitmap(base64);
            if (bmp != null) {
                imgEditAvatar.setImageBitmap(bmp);
                imgEditAvatar.setVisibility(View.VISIBLE);
                tvEditAvatarLetter.setVisibility(View.GONE);
                return;
            }
        }
        imgEditAvatar.setVisibility(View.GONE);
        tvEditAvatarLetter.setVisibility(View.VISIBLE);
        tvEditAvatarLetter.setText(ImageUtils.getAvatarLetter(name));
        if (tvEditAvatarLetter.getBackground() != null) { // ← fix bug 3
            tvEditAvatarLetter.getBackground()
                    .setTint(ImageUtils.getAvatarColor(name));
        }
    }

    private void saveContact() {
        String name  = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError(getString(R.string.msg_name_required));
            etName.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError(getString(R.string.msg_phone_required));
            etPhone.requestFocus();
            return;
        }

        if (MODE_ADD.equals(mode)) {
            Contact newContact = new Contact(name, phone,
                    email.isEmpty() ? null : email,
                    selectedPhotoBase64);

            repository.insert(newContact, id -> {
                if (!isAdded()) return; // ← fix bug 2
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(requireContext(),
                            getString(R.string.msg_save_success),
                            Toast.LENGTH_SHORT).show();
                    requireActivity().getSupportFragmentManager().popBackStack();
                });
            });

        } else {
            if (currentContact == null) return;
            currentContact.setName(name);
            currentContact.setPhone(phone);
            currentContact.setEmail(email.isEmpty() ? null : email);
            currentContact.setPhoto(selectedPhotoBase64);

            repository.update(currentContact, rows -> {
                if (!isAdded()) return; // ← fix bug 2
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(requireContext(),
                            getString(R.string.msg_save_success),
                            Toast.LENGTH_SHORT).show();
                    requireActivity().getSupportFragmentManager().popBackStack();
                });
            });
        }
    }
}