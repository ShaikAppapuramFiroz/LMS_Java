package com.nec.service;

import java.util.List;
import java.util.Optional;

import com.nec.entity.Book;

public interface BookService {
	Book add(Book book);
	List<Book> getAllBooks();
	Optional<Book> getBookById(Long id);
	Book updateBook(Long id,Book book);
	void deleteBook(Long id);
}
