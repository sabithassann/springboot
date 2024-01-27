import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './models/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8084/api/books';

  constructor(private http: HttpClient) { }

  getAllBooks():Observable<Book[]>{
    return this.http.get<Book[]>(this.baseUrl);

  }

  addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.baseUrl, book);
  }

}
