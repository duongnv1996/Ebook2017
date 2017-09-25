package com.duongkk.ebook.presenter;

import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.model.BookManager;
import com.duongkk.ebook.model.IBookDetail;
import com.duongkk.ebook.view.activities.IDetailBookView;

/**
 * Created by DuongKK on 9/25/2017.
 */

public class DetailBookPresenter implements IBookDetail {
    private BookManager bookManager;
    private IDetailBookView iDetailBookView;

    public DetailBookPresenter( IDetailBookView iDetailBookView) {
        this.bookManager = new BookManager(null,this);
        this.iDetailBookView = iDetailBookView;
    }
    public void getDetailBook(Book book){
        bookManager.BookDetails(book);
    }
    @Override
    public void loadDetailBookSuccess(Book book) {
        if(book!=null){
            iDetailBookView.onLoadDetailBookSuccess(book);
        }else{
            iDetailBookView.onLoadDetailBookFail(new NullPointerException(""));
        }
    }
    @Override
    public void loadDetailBookFail(Exception e) {
        iDetailBookView.onLoadDetailBookFail(e);

    }
}
