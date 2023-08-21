package com.nexcode.project.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nexcode.project.mapper.CategoryMapper;
import com.nexcode.project.model.dto.CategoryDto;
import com.nexcode.project.model.entities.Category;
import com.nexcode.project.model.requests.CategoryRequest;
import com.nexcode.project.model.responses.CategoryResponse;

@Component
public class CategoryMapperImpl implements CategoryMapper{

	
	@Override
	public CategoryDto toDto(CategoryRequest request) {
		CategoryDto categoryDto=new CategoryDto();
		if(request==null) {
			return null;
		}
		categoryDto.setName(request.getName());
		return categoryDto;
	}
	@Override
	public CategoryDto toDto(Category category) {
		if(category==null) {
			return null;
		}
		CategoryDto categoryDto=new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		return categoryDto;
	}
	
	@Override
	public CategoryResponse toResponse(CategoryDto categoryDto) {
		if(categoryDto==null) {
			return null;
		}
		CategoryResponse categoryResponse=new CategoryResponse();
		categoryResponse.setId(categoryDto.getId());
		categoryResponse.setName(categoryDto.getName());
		return categoryResponse;
	}
	@Override
	public List<CategoryDto> toDto(List<Category> categories) {
		
		return categories.stream().map(c->toDto(c)).collect(Collectors.toList());
	}
	@Override
	public List<CategoryResponse> toResponse(List<CategoryDto> categories) {
		
		return categories.stream().map(c->toResponse(c)).collect(Collectors.toList());
	}

}
