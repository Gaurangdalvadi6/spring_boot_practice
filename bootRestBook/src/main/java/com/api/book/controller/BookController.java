package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.services.BookServices;

@RestController
public class BookController {
	
	@Autowired
	private BookServices bookServices;
	
	
	public BookServices getBookServices() {
		return bookServices;
	}


	public void setBookServices(BookServices bookServices) {
		this.bookServices = bookServices;
	}


	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookServices.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookServices.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book book2 = bookServices.addBook(book);
		System.out.println(book2);
		return book2;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId){
		this.bookServices.deleteBook(bookId);
	}
}
