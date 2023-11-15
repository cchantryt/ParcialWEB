package com.cobiscorp.postulacion.libros.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cobiscorp.postulacion.libros.models.BookModel;


@Component
public class DataBaseInit implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public DataBaseInit(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Datos de prueba
        BookModel book1 = new BookModel();
        book1.setNombre("El hobbit");
        book1.setbiblioteca("Biblioteca Nacional");
        book1.setautor("J.R.R. Tolkien");
        
        BookModel book2 = new BookModel();
        book2.setNombre("El señor de los anillos");
        book2.setbiblioteca("Biblioteca Nacional");
        book2.setautor("J.R.R. Tolkien");
        
        //Guardado de datos
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}