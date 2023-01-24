package com.nagarro.Assignment51.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Assignment51.model.Book;
import com.nagarro.Assignment51.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return (List<Book>)service.getBooks();
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book b = service.getBook(id);
		if(b == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book b) {
		Book book = null;
		try {
			book = service.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			service.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping("/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book b) {
		try {
			service.updateBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
