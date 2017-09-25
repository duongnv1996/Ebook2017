package com.duongkk.ebook.model;

import java.util.List;

/**
 * Created by DuongKK on 9/6/2017.
 */

public interface IBook {
    void loadDoneListBook(List<Book> listBook);
    void loadFailListBook(Exception e);

}
