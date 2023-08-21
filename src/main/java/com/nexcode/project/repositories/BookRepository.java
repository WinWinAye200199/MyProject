package com.nexcode.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexcode.project.model.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

		
}
