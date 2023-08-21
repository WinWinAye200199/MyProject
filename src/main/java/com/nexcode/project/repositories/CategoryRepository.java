package com.nexcode.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexcode.project.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
