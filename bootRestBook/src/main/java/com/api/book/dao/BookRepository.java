package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.api.book.entity.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Integer>{

	public Book findById(int id);
}
