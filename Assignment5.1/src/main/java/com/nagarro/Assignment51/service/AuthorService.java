package com.nagarro.Assignment51.service;

import java.util.List;

import com.nagarro.Assignment51.model.Author;

public interface AuthorService {
	List<Author> getAuthors();
	public Author getAuthor(int id);
}
