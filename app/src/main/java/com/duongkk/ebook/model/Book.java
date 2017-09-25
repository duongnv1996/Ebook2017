package com.duongkk.ebook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DuongKK on 9/6/2017.
 */

public class Book implements Parcelable {

    String id;
    String urlImage;
    String title;
    String auth;
    String urlDetail;
    String category;
    String year;
    String pages;
    String shortDesciption;
    String tag;
    String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    String linkRead,linkDownload,publisher;
    public Book(String id, String urlImage, String title, String auth, String urlDetail, String category, String year, String pages, String shortDesciption, String tag, String linkRead, String linkDownload, String publisher) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
        this.auth = auth;
        this.urlDetail = urlDetail;
        this.category = category;
        this.year = year;
        this.pages = pages;
        this.shortDesciption = shortDesciption;
        this.tag = tag;
        this.linkRead = linkRead;
        this.linkDownload = linkDownload;
        this.publisher = publisher;
    }

    public String getShortDesciption() {
        return shortDesciption;
    }

    public void setShortDesciption(String shortDesciption) {
        this.shortDesciption = shortDesciption;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLinkRead() {
        return linkRead;
    }

    public void setLinkRead(String linkRead) {
        this.linkRead = linkRead;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public String getAuth() {
        return auth;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlDetail() {
        return urlDetail;
    }

    public void setUrlDetail(String urlDetail) {
        this.urlDetail = urlDetail;
    }

    public Book() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.urlImage);
        dest.writeString(this.title);
        dest.writeString(this.auth);
        dest.writeString(this.urlDetail);
        dest.writeString(this.category);
        dest.writeString(this.year);
        dest.writeString(this.pages);
        dest.writeString(this.shortDesciption);
        dest.writeString(this.tag);
        dest.writeString(this.size);
        dest.writeString(this.linkRead);
        dest.writeString(this.linkDownload);
        dest.writeString(this.publisher);
    }

    protected Book(Parcel in) {
        this.id = in.readString();
        this.urlImage = in.readString();
        this.title = in.readString();
        this.auth = in.readString();
        this.urlDetail = in.readString();
        this.category = in.readString();
        this.year = in.readString();
        this.pages = in.readString();
        this.shortDesciption = in.readString();
        this.tag = in.readString();
        this.size = in.readString();
        this.linkRead = in.readString();
        this.linkDownload = in.readString();
        this.publisher = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
