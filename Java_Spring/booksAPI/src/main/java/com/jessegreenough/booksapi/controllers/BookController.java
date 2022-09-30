package com.jessegreenough.booksapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.jessegreenough.booksapi.models.Book;
import com.jessegreenough.booksapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService){
        this.bookService = bookService;
    }

	@RequestMapping("")
	public String display(Model model) {
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		return "index.jsp";
	}
	
	@RequestMapping("/{id}")
	public String bookDisplay(
				@PathVariable("id") Long id,
				Model model) {
		Optional<Book> isHere = bookService.findById(id);
		System.out.println(isHere.isPresent());
		Book thisBook = isHere.get();
		
		model.addAttribute("thisBook", thisBook);
		model.addAttribute("id", id);
		return "show.jsp";
	}
	
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	
	@PostMapping("/new/create")
	public String createBook(
			@ModelAttribute("book") Book book,
			BindingResult result)
	{
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
}
