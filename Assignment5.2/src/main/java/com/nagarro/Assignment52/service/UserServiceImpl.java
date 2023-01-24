package com.nagarro.Assignment52.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Assignment52.dao.UserRepo;
import com.nagarro.Assignment52.model.Librarian;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public boolean valid(String uname, String upass) {
		// TODO Auto-generated method stub
		Librarian l = null; 
		try {
			l = repo.findById(uname).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User doesn't exists");
		}
		if(l == null) {
			return false;
		} else {
			if(l.getPassword().equals(upass)) {
				return true;
			}
		}
		return false;
	}

}
