package com.nec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nec.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
