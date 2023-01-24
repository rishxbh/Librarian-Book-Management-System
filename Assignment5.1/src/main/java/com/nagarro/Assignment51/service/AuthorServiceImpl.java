package com.nagarro.Assignment51.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Assignment51.dao.AuthorRepository;
import com.nagarro.Assignment51.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository repo;
	
	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return (List<Author>) repo.findAll();
	}
	
	public Author getAuthor(int id) {
		Author a = null;
		try {
			a = repo.findById(id).get();
		} catch(Exception e) {
			System.out.print("no record");
		}
		return a;
	}
	
}
