package com.nagarro.Assignment52.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.Assignment52.model.Librarian;

@Repository
public interface UserRepo extends CrudRepository<Librarian, String> {

}
