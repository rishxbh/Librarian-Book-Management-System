package com.nagarro.Assignment52.service;

import java.util.List;

import com.nagarro.Assignment52.model.Author;
import com.nagarro.Assignment52.model.Book;

public interface BookService {
	List<Book> getBooks();
	List<Author> getAuthors();
	Author getAuthor(int id);
	void addBook(Book b);
	void editBook(Book b);
	void deleteBook(int id);
}
