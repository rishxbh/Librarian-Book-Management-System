package com.nagarro.Assignment51.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Assignment51.model.Author;
import com.nagarro.Assignment51.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService service;
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		return (List<Author>)service.getAuthors();
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getBook(@PathVariable("id") int id) {
		Author a = service.getAuthor(id);
		if(a == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(a));
	}
	
}
