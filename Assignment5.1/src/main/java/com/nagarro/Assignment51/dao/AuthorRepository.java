package com.nagarro.Assignment51.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.Assignment51.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
