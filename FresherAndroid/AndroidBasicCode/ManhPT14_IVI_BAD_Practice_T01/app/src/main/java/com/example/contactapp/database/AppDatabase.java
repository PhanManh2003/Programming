package com.example.contactapp.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.contactapp.database.dao.ContactDao;
import com.example.contactapp.model.Contact;

import java.util.concurrent.Executors;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "contact_db"
                            )
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadExecutor().execute(() -> {
                                        AppDatabase database = getInstance(context);
                                        ContactDao dao = database.contactDao();
                                        dao.insert(new Contact("Abby Christensen",  "0912 111 001", "abby@gmail.com",       null));
                                        dao.insert(new Contact("Adi Thakkar",       "0912 111 002", "adi@gmail.com",        null));
                                        dao.insert(new Contact("Ally Kulla",        "0912 111 003", "ally@gmail.com",       null));
                                        dao.insert(new Contact("Amar Nwosu",        "0912 111 004", "amar@gmail.com",       null));
                                        dao.insert(new Contact("Bill Xu",           "0912 111 005", "bill@gmail.com",       null));
                                        dao.insert(new Contact("Brianna Levin",     "0912 111 006", "brianna@gmail.com",    null));
                                        dao.insert(new Contact("Bryan Fontana",     "0912 111 007", "bryan@gmail.com",      null));
                                        dao.insert(new Contact("Carlos Mendez",     "0912 111 008", "carlos@gmail.com",     null));
                                        dao.insert(new Contact("Diana Prince",      "0912 111 009", "diana@gmail.com",      null));
                                        dao.insert(new Contact("Edward Norton",     "0912 111 010", "edward@gmail.com",     null));
                                        dao.insert(new Contact("Fiona Green",       "0912 111 011", "fiona@gmail.com",      null));
                                        dao.insert(new Contact("George Miller",     "0912 111 012", "george@gmail.com",     null));
                                        dao.insert(new Contact("Hannah Baker",      "0912 111 013", "hannah@gmail.com",     null));
                                        dao.insert(new Contact("Ivan Drago",        "0912 111 014", "ivan@gmail.com",       null));
                                        dao.insert(new Contact("Jessica Alba",      "0912 111 015", "jessica@gmail.com",    null));
                                        dao.insert(new Contact("Kevin Hart",        "0912 111 016", "kevin@gmail.com",      null));
                                        dao.insert(new Contact("Kimberly Lee",      "0912 111 017", "kim@gmail.com",        null));
                                        dao.insert(new Contact("Laura Palmer",      "0912 111 018", "laura@gmail.com",      null));
                                        dao.insert(new Contact("Michael Scott",     "0912 111 019", "michael@gmail.com",    null));
                                        dao.insert(new Contact("Mindy Russell",     "0912 111 020", "mindy@gmail.com",      null));
                                        dao.insert(new Contact("Nguyen Van A",      "0912 111 021", "nva@gmail.com",        null));
                                        dao.insert(new Contact("Oscar Martinez",    "0912 111 022", "oscar@gmail.com",      null));
                                        dao.insert(new Contact("Pam Beesly",        "0912 111 023", "pam@gmail.com",        null));
                                        dao.insert(new Contact("Quinn Hughes",      "0912 111 024", "quinn@gmail.com",      null));
                                        dao.insert(new Contact("Rachel Green",      "0912 111 025", "rachel@gmail.com",     null));
                                        dao.insert(new Contact("Sean Anderson",     "0912 111 026", "sean@gmail.com",       null));
                                        dao.insert(new Contact("Tran Thi B",        "0912 111 027", "ttb@gmail.com",        null));
                                        dao.insert(new Contact("Uma Thurman",       "0912 111 028", "uma@gmail.com",        null));
                                        dao.insert(new Contact("Victor Stone",      "0912 111 029", "victor@gmail.com",     null));
                                        dao.insert(new Contact("Wendy Williams",    "0912 111 030", "wendy@gmail.com",      null));
                                        dao.insert(new Contact("Xander Cage",       "0912 111 031", "xander@gmail.com",     null));
                                        dao.insert(new Contact("Yvonne Strahovski", "0912 111 032", "yvonne@gmail.com",     null));
                                        dao.insert(new Contact("Zack Morris",       "0912 111 033", "zack@gmail.com",       null));
                                    });
                                }
                            })
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}