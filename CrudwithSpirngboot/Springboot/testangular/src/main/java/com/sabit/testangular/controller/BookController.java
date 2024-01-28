package com.sabit.testangular.controller;


import com.sabit.testangular.model.Book;
import com.sabit.testangular.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id,@RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            Book existingBook=optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthorName(book.getAuthorName());
            bookRepository.save(existingBook);

            return new ResponseEntity<>(existingBook, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
