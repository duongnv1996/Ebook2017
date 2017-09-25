package com.duongkk.ebook.model;

/**
 * Created by DuongKK on 9/25/2017.
 */

public interface IBookDetail {
    void loadDetailBookSuccess(Book book);
    void loadDetailBookFail(Exception e);
}
