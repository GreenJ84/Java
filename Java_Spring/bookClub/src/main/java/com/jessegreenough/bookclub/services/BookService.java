package com.jessegreenough.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessegreenough.bookclub.models.Book;
import com.jessegreenough.bookclub.repositories.BookRepository;

@Service
public class BookService {

		@Autowired
		private BookRepository bookRepo;
		
		public List<Book> allBooks(){
			return bookRepo.findAll();
		}
		
		public Book getBook(Long id) {
			Optional<Book> thisBook = bookRepo.findById(id);
			if (thisBook !=null)
			{
				return thisBook.get();
			}
			else { return null; }
		}
		
		public List<Book> userBooks(Long userId){
			return bookRepo.findAllByUserId(userId);
		}
		
		public Book saveBook(Book b) {
			return bookRepo.save(b);
		}
		
		public void deleteBook(Long id) {
			bookRepo.deleteById(id);
		}
	
}
