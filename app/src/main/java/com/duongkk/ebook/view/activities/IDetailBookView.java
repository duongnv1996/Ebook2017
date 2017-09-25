package com.duongkk.ebook.view.activities;

import com.duongkk.ebook.model.Book;

/**
 * Created by DuongKK on 9/25/2017.
 */

public interface IDetailBookView {
    void onLoadDetailBookFail(Exception e);
    void onLoadDetailBookSuccess(Book book);
}
