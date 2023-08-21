package com.nexcode.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexcode.project.model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
