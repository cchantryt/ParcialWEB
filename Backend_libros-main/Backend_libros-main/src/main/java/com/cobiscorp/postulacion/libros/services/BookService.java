package com.cobiscorp.postulacion.libros.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobiscorp.postulacion.libros.models.BookModel;
import com.cobiscorp.postulacion.libros.repositories.BookRepository;

@Service
public class BookService {

    //Atributos
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Metodos
    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }

    public List<BookModel> getAllBooks() {
        Iterable<BookModel> booksIterable = bookRepository.findAll();
        List<BookModel> booksList = new ArrayList<>();
        booksIterable.forEach(booksList::add);
        return booksList;
    }

    public Optional<BookModel> getBookByName(String name) {
        return bookRepository.findById(name);
    }

    public void deleteBook(String name) {
        bookRepository.deleteById(name);
    }

    public BookModel updateBook(String name, BookModel updatedBook) {
        Optional<BookModel> existingBook = bookRepository.findById(name);
        if (existingBook.isPresent()) {
            BookModel book = existingBook.get();
            book.setbiblioteca(updatedBook.getbiblioteca());
            book.setautor(updatedBook.getautor());
            return bookRepository.save(book);
        }
        return null;
    }
}
