package com.duongkk.ebook.view.activities;

import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.model.Category;

import java.util.List;

/**
 * Created by DuongKK on 9/6/2017.
 */

public interface IMainView {
    void onLoadDone(List<Book> list);
    void onLoadFail(Exception e);
    void onLoadCategoryDone(List<Category> list);
    void onLoadCategoryFail(Exception e);

}
