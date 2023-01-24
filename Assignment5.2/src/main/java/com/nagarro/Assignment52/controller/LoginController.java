package com.nagarro.Assignment52.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.Assignment52.model.Book;
import com.nagarro.Assignment52.service.BookService;
import com.nagarro.Assignment52.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String redirect() {
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String loginPage(HttpServletRequest req, Model m) {
		String username = req.getParameter("uname");
		String password = req.getParameter("upass");
		if(userService.valid(username, password)) {
			m.addAttribute("username", username);
			return "main.jsp";
		} else {
			m.addAttribute("valid", new String("Invalid User!!!"));
			return "index.jsp";
		}
	}
	
	@Autowired
	private BookService book;
	
	@RequestMapping("/books")
	public String getMain(Model m) {
		List<Book> books = book.getBooks();
		m.addAttribute("books", books);
		return "main.jsp";
	}
	
}
