package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entity.Book;
@Component
public class BookServices {

	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12, "java", "james gosling"));
		list.add(new Book(24, "python", "Guido van Rossum"));
		list.add(new Book(36, "c", "Dannis Ritchie"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		try {
			book = list.stream().filter(e->e.getId()==id).findFirst().get();			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	public void deleteBook(int id) {
		list=list.stream().filter(book->{
			if (book.getId()!=id) {
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList());
	}

	public void updateBook(Book book, int bookId) {
		list =list.stream().map(b->{
			if (b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
