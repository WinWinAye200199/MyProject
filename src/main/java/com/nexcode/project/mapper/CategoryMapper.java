package com.nexcode.project.mapper;

import java.util.List;

import com.nexcode.project.model.dto.CategoryDto;
import com.nexcode.project.model.entities.Category;
import com.nexcode.project.model.requests.CategoryRequest;
import com.nexcode.project.model.responses.CategoryResponse;

public interface CategoryMapper {
	CategoryDto toDto(CategoryRequest request);
	 
	CategoryDto toDto(Category category);
	CategoryResponse toResponse(CategoryDto categoryDto);

	List<CategoryDto> toDto(List<Category> categories);

	List<CategoryResponse> toResponse (List<CategoryDto>categories);
}
