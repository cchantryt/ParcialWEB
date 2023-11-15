package com.cobiscorp.postulacion.libros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class BookModel{

    @Id
    @Column(unique = true, nullable = false,length = 150)
    private String nombre;
    @Column(nullable = false,length = 300)
    private String biblioteca;
    @Column(nullable = false,length = 150)
    private String autor;

    //Constructor vacio
    public BookModel(){

    }

    //Constructor
    public BookModel(String nombre, String biblioteca, String autor) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.autor = autor;
    }

    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String titulo) {
        this.nombre = titulo;
    }

    //Biblioteca
    public String getbiblioteca() {
        return biblioteca;
    }

    public void setbiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    //Autor
    public String getautor() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

}