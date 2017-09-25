package com.duongkk.ebook.presenter;

import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.model.BookManager;
import com.duongkk.ebook.model.Category;
import com.duongkk.ebook.model.CategoryManager;
import com.duongkk.ebook.model.IBook;
import com.duongkk.ebook.model.ICategory;
import com.duongkk.ebook.view.activities.IMainView;

import java.util.List;

/**
 * Created by DuongKK on 9/6/2017.
 */

public class MainPresenter implements IBook,ICategory{
    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        bookManager = new BookManager(this);
        categoryManager = new CategoryManager(this);
    }

    public void loadListBook(String url){
        bookManager.getListBook(url);
    }
    public void loadListCategoriesBook(String url){
        categoryManager.CategorieParse(url);
    }
    private IMainView iMainView;
    private BookManager bookManager;
    private CategoryManager categoryManager;


    @Override
    public void loadDoneListBook(List<Book> listBook) {
        iMainView.onLoadDone(listBook);

    }

    @Override
    public void loadFailListBook(Exception e) {
            iMainView.onLoadFail(e);
    }



    @Override
    public void loadDoneCategoriesBook(List<Category> listCategories) {
        iMainView.onLoadCategoryDone(listCategories);
    }

    @Override
    public void loadFailCategoriesBook(Exception e) {
        iMainView.onLoadCategoryFail(e);
    }
}
