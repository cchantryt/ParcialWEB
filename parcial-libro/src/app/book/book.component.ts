import { Component, OnInit } from '@angular/core';
import { Book } from './book.model'; //NO IMPLEMENTADO
import { BookService } from './book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html'
})
export class BookComponent implements OnInit {
  books: Book[] = [];
  nuevoLibro: Book = { nombre: '', autor: '', biblioteca: '' };

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.listarLibros();
  }

  listarLibros(): void {
    this.bookService.getLibros().subscribe(
      (data: Book[]) => {
        this.books = data;
      },
      (error: any) => {
        console.error('Error obteniendo libros:', error);
      }
    );
  }

  agregarLibro(): void {
    this.bookService.agregarLibro(this.nuevoLibro).subscribe(
      (res: any) => {
        console.log('Libro agregado:', res);
        this.listarLibros();
        this.nuevoLibro = { nombre: '', autor: '', biblioteca: '' };
      },
      (error: any) => {
        console.error('Error al agregar libro:', error);
      }
    );
  }
}
