import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book.model'; //NO IMPLEMENTADO

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = 'http://localhost:3000/libros';

  constructor(private http: HttpClient) { }

  getLibros(): Observable<Book[]> {
    return this.http.get<Book[]>(this.apiUrl);
  }

  agregarLibro(nuevoLibro: Book): Observable<any> {
    return this.http.post(this.apiUrl, nuevoLibro);
  }
}
