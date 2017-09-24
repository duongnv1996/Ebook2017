package com.duongkk.ebook.model;

/**
 * Created by DuongKK on 9/6/2017.
 */

public class Book {

    String id;
    String urlImage;
    String title;
    String auth;
    String urlDetail;
    String category;
    String year;
    String pages;

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
}
