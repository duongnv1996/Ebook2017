package com.duongkk.ebook.model;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuongKK on 9/10/2017.
 */

public class CategoryManager {
    private ICategory mICategory;

    public CategoryManager(ICategory mICategory) {
        this.mICategory = mICategory;
    }

    public void setmICategory(ICategory mICategory) {
        this.mICategory = mICategory;
    }

    public void CategorieParse(final String url) {
        new AsyncTask<Void, Void, Void>() {
            public Document JsoupDoc;
            List<Category> categories = new ArrayList<Category>();

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    JsoupDoc = Jsoup.connect(url).get();
                    Elements CaNamesList = JsoupDoc.select(".collection-item");
                    Elements CaUrlList = JsoupDoc.select(".collection-item[href]");
                    for (int i = 0; i < CaNamesList.size(); i++) {
                        Category category = new Category(CaNamesList.get(i).text(), CaUrlList.get(i).attr("abs:href"));
                        categories.add(category);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    mICategory.loadFailCategoriesBook(e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (categories.size() > 0) {
                    mICategory.loadDoneCategoriesBook(categories);
                } else {
                    mICategory.loadFailCategoriesBook(new Exception("No category was found"));
                }
            }
        }.execute();
    }
}
