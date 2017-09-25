package com.duongkk.ebook.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duongkk.ebook.R;
import com.duongkk.ebook.adapters.BookCategoryAdapter;
import com.duongkk.ebook.adapters.BookMainAdapter;
import com.duongkk.ebook.interfaces.CallBack;
import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.model.Category;
import com.duongkk.ebook.presenter.MainPresenter;
import com.duongkk.ebook.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView, AdapterView.OnItemSelectedListener,CallBack {
    @BindView(R.id.rcv_book_main)
    RecyclerView rcvBookMain;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.spinner)
    Spinner spinner;

    CollapsingToolbarLayout toolbarLayout;
    private MainPresenter mMainPresenter;
    private BookMainAdapter bookMainAdapter;
    private List<Book> listBooks;
    private List<Category> listCategories;
    private BookCategoryAdapter bookCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }



    private void init() {
        mMainPresenter = new MainPresenter(this);
        listBooks = new ArrayList<>();
        bookMainAdapter = new BookMainAdapter(listBooks, this,this);
        rcvBookMain.setAdapter(bookMainAdapter);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvBookMain.setLayoutManager(layoutManager);
        rcvBookMain.setHasFixedSize(true);
//        rcvBookMain.addItemDecoration(new SpacesItemDecoration(16));
        listCategories = new ArrayList<>();
        bookCategoryAdapter = new BookCategoryAdapter(this, R.layout.item_category, listCategories);
        bookCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(bookCategoryAdapter);
        //  mMainPresenter.loadListBook(Constants.URL_HOME);
        mMainPresenter.loadListCategoriesBook(Constants.URL_HOME);
    }

    @Override
    public void onLoadDone(List<Book> bookList) {
        if (bookList.size() != 0) {
            listBooks.clear();
            listBooks.addAll(bookList);
        }
        bookMainAdapter.notifyDataSetChanged();
        rcvBookMain.scrollToPosition(0);
        showRecyclerview();
    }

    private void showRecyclerview() {
        loading.setVisibility(View.GONE);
        rcvBookMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadFail(Exception e) {
//        showRecyclerview();
        LogUtils.e(e.getMessage());
    }

    @Override
    public void onLoadCategoryDone(List<Category> list) {
        listCategories.addAll(list);
        bookCategoryAdapter.notifyDataSetChanged();
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onLoadCategoryFail(Exception e) {
        LogUtils.e(e.getMessage());
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        showLoading();
        mMainPresenter.loadListBook(listCategories.get(i).getUrl());
    }

    private void showLoading() {
        rcvBookMain.setVisibility(View.INVISIBLE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCallBack(int position) {
        Intent i = new Intent(MainActivity.this,DetailBookActivity.class);
        Bundle b = new Bundle();
        b.putParcelable(Constants.MSG,listBooks.get(position));
        i.putExtra(Constants.BUNDLE,b);
        startActivity(i);
    }
}
