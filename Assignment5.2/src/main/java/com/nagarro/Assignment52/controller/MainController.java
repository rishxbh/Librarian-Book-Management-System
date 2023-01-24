package com.nagarro.Assignment52.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.Assignment52.model.Book;
import com.nagarro.Assignment52.service.BookService;

@Controller
public class MainController {
	
//	@Autowired
//	private BookService book;
//	
//	@RequestMapping("/books")
//	public String getMain(Model m) {
//		List<Book> books = book.getBooks();
//		m.addAttribute("books", books);
//		return "main.jsp";
//	}
	
}
