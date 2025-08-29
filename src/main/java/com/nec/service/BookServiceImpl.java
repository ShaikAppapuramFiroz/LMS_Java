package com.nec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nec.entity.Book;
import com.nec.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book add(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setCategory(book.getCategory());
            existing.setAvailable(book.isAvailable());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
