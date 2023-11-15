package com.cobiscorp.postulacion.libros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobiscorp.postulacion.libros.models.BookModel;
import com.cobiscorp.postulacion.libros.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    //Constructor
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Metodos
    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody BookModel book) {
        BookModel createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        List<BookModel> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<BookModel> getBookByName(@PathVariable("name") String name) {
        Optional<BookModel> book = bookService.getBookByName(name);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteBook(@PathVariable("name") String name) {
        bookService.deleteBook(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{name}")
    public ResponseEntity<BookModel> updateBook(@PathVariable("name") String name, @RequestBody BookModel updatedBook) {
        BookModel book = bookService.updateBook(name, updatedBook);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
