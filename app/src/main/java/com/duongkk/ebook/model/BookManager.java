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
    private IBookDetail iBookDetail;
    public BookManager(IBook iBook) {
        this.iBook = iBook;
    }

    public BookManager(IBook iBook,IBookDetail iBookDetail) {
        this.iBookDetail = iBookDetail;
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
                        book.setId(BookId.get(i + 1).text());
                        book.setUrlImage(BookUrlImg.get(i).attr("abs:src"));
                        book.setUrlDetail(BookLink.get(i).attr("abs:href"));
                        book.setTitle(BookTitle.get(i).text());
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

    public void BookDetails(final Book book) {

        new AsyncTask<Void, Void, Book>() {

            public Document JsoupDoc;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Book doInBackground(Void... voids) {

                try {

                    JsoupDoc = Jsoup.connect(book.getUrlDetail()).get();
                    Elements bookimg = JsoupDoc.select(".img-responsive[src]");
                    Elements bookid = JsoupDoc.select(".text-center strong");
                    Elements bookname = JsoupDoc.select(".col-md-8 h1");
                    Elements bookinfo = JsoupDoc.select("tbody");
                    Elements bookdescription = JsoupDoc.select(".text-justify");
                    Elements booklinkdow = JsoupDoc.select(".btn-primary[href]");
                    Elements booklinkread = JsoupDoc.select(".btn-danger[href]");
                    Elements booktag = JsoupDoc.select("#book-tags");

                    for (int i = 0; i < bookimg.size(); i++) {
                        String shortDesciption = bookdescription.get(i).text();
                        String linkDownload = booklinkdow.get(i).attr("abs:href");
                        String linkRead = booklinkread.get(i).attr("abs:href");
                        String tag = booktag.get(i).text();
                        String publisher = bookinfo.get(i).text().split(" ")[1];
                        String Year = bookinfo.get(i).text().split(" ")[2];
                        String Autor = bookinfo.get(i).text().split(" ")[3];
                        String Page = bookinfo.get(i).text().split(" ")[4];
                        String Size = bookinfo.get(i).text().split(" ")[5];

                        book.setPages(Page);
                        book.setYear(Year);
                        book.setSize(Size);
                        book.setAuth(Autor);
                        book.setPublisher(publisher);
                        book.setTag(tag);
                        book.setLinkDownload(linkDownload);
                        book.setLinkRead(linkRead);
                        book.setShortDesciption(shortDesciption);

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    iBookDetail.loadDetailBookFail(e);
                }

                return book;
            }

            @Override
            protected void onPostExecute(Book book) {
                super.onPostExecute(book);
                iBookDetail.loadDetailBookSuccess(book);
            }


        }.execute();

    }

}
