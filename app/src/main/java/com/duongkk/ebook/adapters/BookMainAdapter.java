package com.duongkk.ebook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.duongkk.ebook.R;
import com.duongkk.ebook.interfaces.CallBack;
import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.view.customviews.CustomTextView;
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
    private CallBack callBack;
    public BookMainAdapter(List<Book> list, Context context,CallBack callBack) {
        this.list = list;
        this.callBack = callBack;
        this.context = context;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_main, parent, false));
    }

    @Override
    public void onBindViewHolder(BookHolder holder, final int position) {
        if (holder != null) {
            Book b = list.get(position);
            Picasso.with(context).load(b.getUrlImage()).into(holder.img);
            holder.tvAuth.setText(b.getPages() + " pages");
            holder.tvTitle.setText(CustomTextView.capitalize(b.getTitle().toLowerCase()));
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callBack.onCallBack(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class BookHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_title)
        CustomTextView tvTitle;

        @BindView(R.id.tv_auth)
        CustomTextView tvAuth;

        BookHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
