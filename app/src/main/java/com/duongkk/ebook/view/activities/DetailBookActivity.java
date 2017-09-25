package com.duongkk.ebook.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duongkk.ebook.R;
import com.duongkk.ebook.model.Book;
import com.duongkk.ebook.presenter.DetailBookPresenter;
import com.duongkk.ebook.utils.Constants;
import com.duongkk.ebook.view.customviews.CustomTextView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DuongKK on 9/24/2017.
 */

public class DetailBookActivity extends AppCompatActivity implements IDetailBookView {
    @BindView(R.id.idlinearlayoutanh)
    ImageView idlinearlayoutanh;
    @BindView(R.id.imgsach)
    ImageView imgsach;
    @BindView(R.id.textviewtensach)
    CustomTextView textviewtensach;
    @BindView(R.id.texttacgia)
    CustomTextView texttacgia;
    @BindView(R.id.download)
    Button download;
    @BindView(R.id.btn_read)
    Button btnRead;
    @BindView(R.id.tv_publish)
    CustomTextView tvPublish;
    @BindView(R.id.tv_year)
    CustomTextView tvYear;
    @BindView(R.id.tv_page)
    CustomTextView tvPage;
    @BindView(R.id.tv_size)
    CustomTextView tvSize;
    @BindView(R.id.tv_tag)
    CustomTextView tvTag;
    @BindView(R.id.tv_shortContent)
    CustomTextView tvShortContent;
    private DetailBookPresenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        ButterKnife.bind(this);
        mainPresenter = new DetailBookPresenter(this);
        if (getIntent() != null) {
            Bundle b = getIntent().getBundleExtra(Constants.BUNDLE);
            if (b != null) {
                Book book = b.getParcelable(Constants.MSG);
                mainPresenter.getDetailBook(book);
            }
        }
    }

    @Override
    public void onLoadDetailBookFail(Exception e) {
        LogUtils.e(e.getMessage());
        ToastUtils.showShort("Unable to read information of this book.");
    }

    @Override
    public void onLoadDetailBookSuccess(Book book) {
        textviewtensach.setText(book.getTitle());
        texttacgia.setText(book.getAuth());
        tvPage.setText("Pages: " + book.getPages());
        tvPublish.setText("Publisher: " + book.getPublisher());
        tvShortContent.setText(book.getShortDesciption());
        tvSize.setText("Size: " + book.getSize());
        tvTag.setText("Tags: " + book.getTag());
        tvYear.setText("Year: " + book.getYear());
        Picasso.with(this).load(book.getUrlImage()).into(imgsach);
    }

    @OnClick({R.id.download, R.id.btn_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.download:
                break;
            case R.id.btn_read:
                break;
        }
    }
}
