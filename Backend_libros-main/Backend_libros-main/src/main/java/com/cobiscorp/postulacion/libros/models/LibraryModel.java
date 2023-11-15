package com.cobiscorp.postulacion.libros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Libraries")
public class LibraryModel {
    @Id
    @Column(unique = true, nullable = false,length = 150)
    private String nombre;
    @Column(nullable = false,length = 300)
    private String direccion;
    @Column(nullable = false,length = 150)
    private String ciudad;

    //Constructor vacio
    public LibraryModel(){

    }

    //Constructor
    public LibraryModel(String nombre, String direccion, String ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String titulo) {
        this.nombre = titulo;
    }

    //Direccion
    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    //Ciudad
    public String getciudad() {
        return ciudad;
    }

    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
