package com.jessegreenough.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jessegreenough.bookclub.models.Book;
import com.jessegreenough.bookclub.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("")
	public String booksDisplay(
				Model model,
				HttpSession session,
				RedirectAttributes flash) {
		if (session.getAttribute("userId") == null) {
			flash.addFlashAttribute("errors", "You are not logged in! Loggin or Register.");
			return "redirect:/user/login";
		}
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@GetMapping("/new")
	public String newBook(
				@ModelAttribute("book") Book book,
				BindingResult results,
				HttpSession session,
				RedirectAttributes flash) {
		if (session.getAttribute("userId") == null) {
			flash.addFlashAttribute("errors", "You are not logged in! Loggin or Register.");
			return "redirect:/user/login";
		}
		
		return "newBook.jsp";
	}
	
	@PostMapping("/new/create")
	public String createBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult results,
			HttpSession session,
			Model model) {
		
		if (results.hasErrors()) {
			model.addAttribute("book", book);
			return "newBook.jsp";
		}
		else {
			
		bookService.saveBook(book);
		return "redirect:/books";
		}
	}
		
	@GetMapping("/display/{bookId}")
	public String displayBook(
				@PathVariable("bookId") Long id,
				Model model,
				HttpSession session,
				RedirectAttributes flash) {
		
		if (session.getAttribute("userId") == null) {
			flash.addFlashAttribute("errors", "You are not logged in! Loggin or Register.");
			return "redirect:/user/login";
		}
		
		Book thisBook = bookService.getBook(id);
		model.addAttribute("thisBook", thisBook);
		return "displayBook.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editBook(
				@PathVariable("id") Long id,
				HttpSession session,
				Model model,
				RedirectAttributes flash) {
		
		if (session.getAttribute("userId") == null) {
			flash.addFlashAttribute("errors", "You are not logged in! Loggin or Register.");
			return "redirect:/user/login";
		}
		
		Book thisBook = bookService.getBook(id);
		model.addAttribute("book", thisBook);

		return "editBook.jsp";
	}
	
	@PutMapping("/create")
	public String updateBook(
				@Valid @ModelAttribute("book") Book book,
				BindingResult results,
				HttpSession session,
				Model model) {
		
		if (results.hasErrors()) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}

		bookService.saveBook(book);
		
		return "redirect:/books";
	}

}
