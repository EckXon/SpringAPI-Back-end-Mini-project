package com.example.springapi.api.controller;

import com.example.springapi.api.model.Book;
import com.example.springapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.ArrayList;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
        Optional<Book> book = bookService.getBook(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books")
    public ResponseEntity<ArrayList<Book>> getBooks() {
        ArrayList<Book> books = new ArrayList<>(bookService.getAllBooks());
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity.ok("Created Book Successfully");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Integer id) {
        bookService.updateBook(book, id);
        Optional<Book> newBook = bookService.getBook(id);
        if (newBook.isPresent()) {
            return new ResponseEntity<>(newBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Optional<Book> book = bookService.getBook(id);
        if (book.isPresent()) {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Deleted Book Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
