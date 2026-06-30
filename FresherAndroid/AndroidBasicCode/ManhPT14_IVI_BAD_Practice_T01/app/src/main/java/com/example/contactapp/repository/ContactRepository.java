package com.example.contactapp.repository;

import android.content.Context;

import com.example.contactapp.database.AppDatabase;
import com.example.contactapp.database.dao.ContactDao;
import com.example.contactapp.model.Contact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Repository — Fragment gọi class này, không đụng thẳng vào DAO.
 * Mọi thao tác DB đều chạy trên background thread qua ExecutorService.
 * Kết quả trả về qua interface Callback để Fragment cập nhật UI trên main thread.
 */
public class ContactRepository {

    public interface Callback<T> {
        void onResult(T result);
    }

    private final ContactDao dao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public ContactRepository(Context context) {
        dao = AppDatabase.getInstance(context).contactDao();
    }

    public void getAll(Callback<List<Contact>> callback) {
        executor.execute(() -> callback.onResult(dao.getAll()));
    }

    public void getById(int id, Callback<Contact> callback) {
        executor.execute(() -> callback.onResult(dao.getById(id)));
    }

    public void search(String keyword, Callback<List<Contact>> callback) {
        executor.execute(() -> callback.onResult(dao.search("%" + keyword + "%")));
    }

    public void insert(Contact contact, Callback<Long> callback) {
        executor.execute(() -> {
            long id = dao.insert(contact);
            if (callback != null) callback.onResult(id);
        });
    }

    public void update(Contact contact, Callback<Integer> callback) {
        executor.execute(() -> {
            int rows = dao.update(contact);
            if (callback != null) callback.onResult(rows);
        });
    }

    public void delete(Contact contact, Callback<Integer> callback) {
        executor.execute(() -> {
            int rows = dao.delete(contact);
            if (callback != null) callback.onResult(rows);
        });
    }
}
