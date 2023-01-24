package com.nagarro.Assignment52.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.Assignment52.model.Author;
import com.nagarro.Assignment52.model.Book;
import com.nagarro.Assignment52.service.BookService;
import com.nagarro.Assignment52.service.UserService;

@Controller
public class ViewController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String redirect() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(HttpServletRequest req, Model m) {
		String username = req.getParameter("uname");
		String password = req.getParameter("upass");
		if(username != null && userService.valid(username, password)) {
			return "redirect:books";
		} else {
			m.addAttribute("valid", new String("Invalid User!!!"));
			return "index";
		}
	}
	
	@Autowired
	private BookService book;
	
	@GetMapping("/books")
	public ModelAndView getMain() {
		
		List<Book> books = book.getBooks();
		List<Author> authors = book.getAuthors();
//		System.out.println("=============================>" + books.size());
		ModelAndView m = new ModelAndView();
		m.setViewName("main");
		m.addObject("books", books);
		m.addObject("authors", authors);
		return m;
	}
	
	@PostMapping("/add")
	public String add(HttpServletRequest req) {
		String bookName = req.getParameter("name");
		int bookId = Integer.parseInt(req.getParameter("id"));
		int authorId = Integer.parseInt(req.getParameter("author"));
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	    String str = formatter.format(date);
	    Author author = book.getAuthor(authorId);
		Book b = new Book(bookId, bookName, author, str);
		book.addBook(b);
		return "redirect:books";
	}
	
	@GetMapping("/edit")
	public ModelAndView edit(HttpServletRequest req) {
		String bookName =req.getParameter("name");
		String id = req.getParameter("id");
		String date = req.getParameter("date");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		List<Author> authors = book.getAuthors();
		mv.addObject("authors", authors);
		mv.addObject("name", bookName);
		mv.addObject("id", id);
		mv.addObject("date", date);
		return mv;
	}
	
	@PostMapping("/edited")
	public String edited(HttpServletRequest req) {
		String bookName = req.getParameter("name");
		int bookId = Integer.parseInt(req.getParameter("id"));
		int authorId = Integer.parseInt(req.getParameter("author"));
	    String date = req.getParameter("date");
	    Author author = book.getAuthor(authorId);
		Book b = new Book(bookId, bookName, author, date);
		book.editBook(b);
		return "redirect:books";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req) {
		int bookId = Integer.parseInt(req.getParameter("id"));
		book.deleteBook(bookId);
		return "redirect:books";
	}
}
