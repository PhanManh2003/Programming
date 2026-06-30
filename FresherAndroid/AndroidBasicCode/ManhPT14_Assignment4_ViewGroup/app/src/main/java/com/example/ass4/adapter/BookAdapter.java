package com.example.ass4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass4.DetailActivity;
import com.example.ass4.R;
import com.example.ass4.model.Book;

import java.util.ArrayList;
import java.util.Collections;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<Book> bookList;
    private Context context;
    private ArrayList<Book> originalList;

    public BookAdapter(Context context, ArrayList<Book> bookList) {
        this.context  = context;
        this.bookList = bookList;
        this.originalList = new ArrayList<>(bookList);
        // original list phải tham chiếu tới object arraylist khác
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvTitle.setText("Title: " + book.getTitle());
        holder.tvAuthor.setText("Author: " + book.getAuthor());
        holder.imgBook.setBackgroundResource(book.getImageRes());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title",    book.getTitle());
            intent.putExtra("author",   book.getAuthor());
            intent.putExtra("imageRes", book.getImageRes());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }



    static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook;
        TextView tvTitle, tvAuthor;

        BookViewHolder(View itemView) {
            super(itemView);
            imgBook  = itemView.findViewById(R.id.imgBook);
            tvTitle  = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }
    }

    // sort
    public void sort(String type) {

        if (type.equals("title")) {

            Collections.sort(bookList, (b1, b2) ->
                    b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        } else if (type.equals("author")) {

            Collections.sort(bookList, (b1, b2) ->
                    b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
        }

        // notifyDataSetChanged() là hàm báo cho RecyclerView biết rằng dữ liệu
        // trong Adapter đã thay đổi, nên nó phải vẽ lại danh sách.
        notifyDataSetChanged();
    }

    // search by name or author
    public void filter(String query) {
        bookList.clear();
        if (query == null || query.trim().isEmpty()) {
            bookList.addAll(originalList);
        } else {
            query = query.toLowerCase();

            // duyệt danh sách gốc , hiển thị bằng bookList vì bookList ở trong bindViewHolder
            for (Book book : originalList) {
                if (book.getTitle().toLowerCase().contains(query)
                        || book.getAuthor().toLowerCase().contains(query)) {
                    bookList.add(book);
                }
            }
        }

        notifyDataSetChanged();
    }
}
