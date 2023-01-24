package com.nagarro.Assignment51.service;

import java.util.List;

import com.nagarro.Assignment51.model.Book;

public interface BookService{
	
	public List<Book> getBooks();
	public Book getBook(int id);
	public Book addBook(Book b);
	public void deleteBook(int id);
	public void updateBook(Book book);
	
}
