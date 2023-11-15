package com.cobiscorp.postulacion.libros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobiscorp.postulacion.libros.models.LibraryModel;
import com.cobiscorp.postulacion.libros.services.LibraryService;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<LibraryModel> createLibrary(@RequestBody LibraryModel library) {
        LibraryModel createdLibrary = libraryService.createLibrary(library);
        return new ResponseEntity<>(createdLibrary, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LibraryModel>> getAllLibraries() {
        List<LibraryModel> libraries = libraryService.getAllLibraries();
        return new ResponseEntity<>(libraries, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<LibraryModel> getLibraryByName(@PathVariable("name") String name) {
        Optional<LibraryModel> library = libraryService.getLibraryByName(name);
        return library.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable("name") String name) {
        libraryService.deleteLibrary(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{name}")
    public ResponseEntity<LibraryModel> updateLibrary(@PathVariable("name") String name, @RequestBody LibraryModel updatedLibrary) {
        LibraryModel library = libraryService.updateLibrary(name, updatedLibrary);
        if (library != null) {
            return new ResponseEntity<>(library, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
