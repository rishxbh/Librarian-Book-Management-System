package com.nagarro.Assignment51.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.Assignment51.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
