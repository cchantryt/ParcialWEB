package com.cobiscorp.postulacion.libros.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cobiscorp.postulacion.libros.models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String> {
}
