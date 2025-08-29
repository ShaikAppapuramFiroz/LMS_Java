package com.nec.controller;
import com.nec.entity.Book; 


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nec.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	private  BookService service;
	
	public BookController(BookService service) {
		this.service=service;
	}
	
	@GetMapping
	public List<Book> getAll(){
		return service.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> getById(@PathVariable Long id){
		return service.getBookById(id);
		}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return service.add(book);
	}

	@DeleteMapping("/{id}")
	public  void delete(@PathVariable Long id) {
		service.deleteBook(id);
	}
	
	
	@PutMapping("/{id}")
	public Book update(@PathVariable Long id,@RequestBody Book book) {
		return service.updateBook(id, book);
	}
	
	
}
