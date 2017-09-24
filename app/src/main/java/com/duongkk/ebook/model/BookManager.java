package com.duongkk.ebook.model;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuongKK on 9/6/2017.
 */

public class BookManager {
    private IBook iBook;

    public BookManager(IBook iBook) {
        this.iBook = iBook;
    }

    public void getListBook(final String url) {
        final List<Book> myList = new ArrayList<>();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Document JsoupDoc = Jsoup.connect(url).get();
                    Elements BookTitle = JsoupDoc.select(".news-header[title]");
                    Elements BookUrlImg = JsoupDoc.select(".img-responsive[src]");
                    Elements BookYear = JsoupDoc.select("tbody");
                    Elements BookId = JsoupDoc.select(".text-center");
                    Elements BookLink = JsoupDoc.select(".news-header[href]");
                    for (int i = 0; i < BookTitle.size(); i++) {
                        Book book = new Book();
                        book.setId(BookId.get(i+1).text());
                        book.setUrlImage(BookUrlImg.get(i).attr("abs:src"));
                        book.setUrlDetail(BookLink.get(i).attr("abs:href"));
                        book.setTitle( BookTitle.get(i).text());
                        book.setYear(BookYear.get(i).text().split(" ")[1]);
                        book.setPages(BookYear.get(i).text().split(" ")[3]);
                        myList.add(book);
//                        BookTitle.get(i).text());
//                        BookUrlImgList.add();
//                        InfoBooks.add(BookYear.get(i).text());
//                        BooksId.add(BookId.get(i).text());
//                        BooksLink.add(BookLink.get(i).attr("abs:href"));
//                        String year = InfoBooks.get(i).split("  ")[0];
//                        String pages = InfoBooks.get(i).split("  ")[1];
//                        String size = InfoBooks.get(i).split("  ")[2];
//
//                        BooksYear.add(year);
//                        BooksPage.add(pages);
//                        BooksSize.add(size);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    iBook.loadFailListBook(e);
                    return null;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (myList.size() > 0)
                    iBook.loadDoneListBook(myList);
            }
        }.execute();
    }


}
