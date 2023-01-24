package com.nagarro.Assignment52.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Assignment52.model.Author;
import com.nagarro.Assignment52.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Book> getBooks() {
		List<Book> list = null;
		ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/books", Book[].class);
        Book[] responseBody = responseEntity.getBody();
        list = Arrays.asList(responseBody);
		return list;
	}

	public List<Author> getAuthors() {
		List<Author> list = null;
		ResponseEntity<Author[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/authors", Author[].class);
        Author[] responseBody = responseEntity.getBody();
        list = Arrays.asList(responseBody);
		return list;
	}

	@Override
	public Author getAuthor(int id) {
		ResponseEntity<Author> responseEntity = restTemplate.getForEntity("http://localhost:8080/author/{id}", Author.class, id);
		Author responseBody = responseEntity.getBody();
		return responseBody;
	}

	@Override
	public void addBook(Book b) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI url = null;
		try {
			url = new URI("http://localhost:8080/book");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		

		HttpEntity<Book> requestEntity = new HttpEntity<>(b, headers);
		ResponseEntity<Book> responseEntity = restTemplate.postForEntity(url, requestEntity, Book.class);
	}

	@Override
	public void editBook(Book b) {
		addBook(b);
	}

	@Override
	public void deleteBook(int id) {
		restTemplate.delete("http://localhost:8080/book/{id}", id);
	}
	
}
