package com.jessegreenough.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jessegreenough.booksapi.models.Book;
import com.jessegreenough.booksapi.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    public Optional<Book> findById(Long id) {
    	return bookRepo.findById(id);
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }		
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		bookRepo.save(book);
		return book;
		}
		
    public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		}

}
