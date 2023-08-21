package com.nexcode.project.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.project.mapper.CategoryMapper;
import com.nexcode.project.model.dto.CategoryDto;
import com.nexcode.project.model.requests.CategoryRequest;
import com.nexcode.project.model.responses.CategoryResponse;
import com.nexcode.project.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	private final CategoryMapper categoryMapper;
	
	@Autowired
	private CategoryService categoryService;
	
	public CategoryController(CategoryMapper categoryMapper) {
		
		this.categoryMapper=categoryMapper;
	}
	
	@PostMapping
	public CategoryDto createCategory(@RequestBody CategoryRequest request) {
		CategoryDto categoryDto=categoryMapper.toDto(request);
//		CategoryDto cateDto=categoryMapper.toDto(id);
		categoryService.addCategory(categoryDto);
		return null;
	}
	
	@GetMapping
	public List<CategoryResponse> getAllCategories(){
		List<CategoryDto> categories=categoryService.getAllCategories();
		List<CategoryResponse>cate=categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());
		return cate; 
	}
	
	@GetMapping("/{id}")
	public List<CategoryResponse> getCategoryById(@PathVariable Long id){
		List<CategoryDto> categories=categoryService.getCategoryById(id);
		return categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());
	}
	
	@PutMapping("/{id}")
	public  CategoryDto updateCategory(@RequestBody CategoryRequest request,@PathVariable Long id) {
		CategoryDto cateDto=categoryMapper.toDto(request);
		categoryService.updateCategory(cateDto,id);
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
}
