import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-apitest',
  templateUrl: './apitest.component.html',
  styleUrl: './apitest.component.css'
})
export class ApitestComponent implements OnInit{
  books: Book[] = [];
  newBook: Book = { authorName: '', title: '' };

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.bookService.getAllBooks().subscribe(
      (data) => {
        this.books = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  addBook(): void {
    this.bookService.addBook(this.newBook).subscribe(
      (data) => {
        this.books.push(data);
        this.newBook = { authorName: '', title: '' }; // Clear the form fields
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
