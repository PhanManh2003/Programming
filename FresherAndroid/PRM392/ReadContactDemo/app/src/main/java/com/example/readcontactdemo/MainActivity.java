package com.example.readcontactdemo;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_PHONE_NUMBERS;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolver = getContentResolver();
        requestContactPermission(READ_CONTACTS);
        requestContactPermission(READ_PHONE_NUMBERS);
    }

    public void onReadContact(View view) {
        Cursor c = resolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME},
                null,    // selection
                null,    // selectionArgs
                null     // sortOrder
        );

        String contacts = "";
        while (c.moveToNext()) {
            int id_column = c.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = c.getString(id_column);

            int name_column = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = c.getString(name_column);

            // query số điện thoại theo contactId (thêm selection và đóng cursor)
            Cursor c1 = resolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                    new String[]{contactId},
                    null
            );
            String phones = "";
            while (c1.moveToNext()) {
                int phoneCol = c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String phone = c1.getString(phoneCol);
                phones += phone + " | ";
            }
            contacts += contactId + ", " + name + ": " + phones + "\n";
        }
        ((TextView) findViewById(R.id.textView)).setText(contacts);
    }

    public void requestContactPermission(String pm) {
        if (checkSelfPermission(pm) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{pm}, 100);
        }
    }
}