package com.example.springapi.service;

import com.example.springapi.api.model.Book;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {

    private int id = 1;
    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        bookList.add(new Book(id++,"Example Book","ExampleAuthor","2025-01-16","An example book"));
        bookList.add(new Book(id++,"Sample Book","SampleAuthor","2024-10-21","A sample book"));
        bookList.add(new Book(id++,"Mock Book","MockAuthor","2021-03-19","A mock book"));
        bookList.add(new Book(id++,"Foundation Book","ReferenceAuthor","2016-12-01","A foundational book"));
        bookList.add(new Book(id++,"Reference Book","ReferenceAuthor","2018-06-18","A reference book"));
        bookList.add(new Book(id++,"Control Book","ExampleAuthor","2019-05-14","A control variable"));
        bookList.add(new Book(id++,"Initial Book","SampleAuthor","2021-04-16","An initial book"));
        bookList.add(new Book(id++,"General Book","SampleAuthor","2022-05-20","A general book"));
        bookList.add(new Book(id++,"Outline Book","ExampleAuthor","2018-09-12","An outline for a book"));
        bookList.add(new Book(id++,"Standard Book","MockAuthor","2024-11-10","A standard book"));
    }

    public Optional<Book> getBook(Integer id) {
        Optional<Book> optional = Optional.empty();
        for(Book book : bookList) {
            if(book.getId() == id) {
                return optional.of(book);
            }
        }
        return optional;
    }

    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }

    public void createBook(Book book) {
        id++;
        book.setId(id);
        bookList.add(book);
    }

    public void updateBook(Book book, Integer id) {
        book.setId(id);
        bookList.set(id-1, book);;
    }

    public void deleteBook(Integer id) {
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getId() == id) {
                bookList.remove(i);
            }
        };
    }
}
