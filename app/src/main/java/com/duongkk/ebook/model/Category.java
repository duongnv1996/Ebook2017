package com.duongkk.ebook.model;

/**
 * Created by DuongKK on 9/10/2017.
 */

public class Category {
    String name;
    String url;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
