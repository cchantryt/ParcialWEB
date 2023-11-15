package com.cobiscorp.postulacion.libros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobiscorp.postulacion.libros.models.LibraryModel;
import com.cobiscorp.postulacion.libros.repositories.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryModel createLibrary(LibraryModel library) {
        return libraryRepository.save(library);
    }

    public List<LibraryModel> getAllLibraries() {
        return (List<LibraryModel>) libraryRepository.findAll();
    }

    public Optional<LibraryModel> getLibraryByName(String name) {
        return libraryRepository.findById(name);
    }

    public void deleteLibrary(String name) {
        libraryRepository.deleteById(name);
    }

    public LibraryModel updateLibrary(String name, LibraryModel updatedLibrary) {
        Optional<LibraryModel> existingLibrary = libraryRepository.findById(name);
        if (existingLibrary.isPresent()) {
            LibraryModel library = existingLibrary.get();
            library.setdireccion(updatedLibrary.getdireccion());
            library.setciudad(updatedLibrary.getciudad());
            return libraryRepository.save(library);
        }
        return null;
    }
}
