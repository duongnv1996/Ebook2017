package com.duongkk.ebook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duongkk.ebook.R;
import com.duongkk.ebook.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DuongKK on 9/6/2017.
 */

public class BookMainAdapter extends RecyclerView.Adapter<BookMainAdapter.BookHolder> {
    private List<Book> list;
    private Context context;

    public BookMainAdapter(List<Book> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_main, parent, false));
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        if (holder != null) {
            Book b = list.get(position);
            Picasso.with(context).load(b.getUrlImage()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class BookHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.card_root_item_book)
        LinearLayout cardRootItemBook;

        BookHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
