package com.nagarro.Assignment51.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Assignment51.dao.BookRepository;
import com.nagarro.Assignment51.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repo;

	public List<Book> getBooks(){
		return (List<Book>)repo.findAll();
	}
	
	public Book getBook(int id) {
		Book b = null;
		try {
			b = repo.findById(id).get();
		} catch(Exception e) {
			System.out.print("no record");
		}
		return b;
	}
	
	public Book addBook(Book b) {
		repo.save(b);
		return b;
	}
	
	public void deleteBook(int id) {
		repo.deleteById(id);
	}
	
	public void updateBook(Book book) {
		repo.save(book);
	}
}
