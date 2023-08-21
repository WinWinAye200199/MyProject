package com.nexcode.project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexcode.project.mapper.CategoryMapper;
import com.nexcode.project.model.dto.CategoryDto;
import com.nexcode.project.model.entities.Category;
import com.nexcode.project.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryMapper categoryMapper;
	
	public void addCategory(CategoryDto categoryDto) {
		Category category=new Category();
		category.setName(categoryDto.getName());
		categoryRepository.save(category);
	}
	
	public List<CategoryDto> getAllCategories(){
		List<Category> categories=categoryRepository.findAll();
		List<CategoryDto> cateDto=categories.stream().map(c->categoryMapper.toDto(c)).collect(Collectors.toList());
		return cateDto;
	}
	

	
	public List<CategoryDto> getCategoryById(Long id){
		Optional<Category> categories=categoryRepository.findById(id);
		List<CategoryDto> cateDto=categories.stream().map(c->categoryMapper.toDto(c)).collect(Collectors.toList());
		return cateDto;
	}
	
	public void updateCategory(CategoryDto cateDto,Long id) {
		Category category=categoryRepository.findById(id).orElse(null);
		if(category!=null) {
			category.setName(cateDto.getName());
			}
		categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		Category category=categoryRepository.findById(id).orElse(null);
		if(category!=null) {
			categoryRepository.deleteById(id);
		}
	}
}
