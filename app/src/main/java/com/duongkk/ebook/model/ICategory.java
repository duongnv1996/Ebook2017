package com.duongkk.ebook.model;

import java.util.List;

/**
 * Created by DuongKK on 9/10/2017.
 */

public interface ICategory {
    void loadDoneCategoriesBook(List<Category> listCategories);
    void loadFailCategoriesBook(Exception e);
}
