package com.nexcode.project.mapper.impl;

//import java.util.List;

import org.springframework.stereotype.Component;

import com.nexcode.project.mapper.AuthorMapper;
import com.nexcode.project.mapper.BookMapper;
import com.nexcode.project.mapper.CategoryMapper;
import com.nexcode.project.model.dto.BookDto;
import com.nexcode.project.model.entities.Book;
import com.nexcode.project.model.requests.BookRequest;
import com.nexcode.project.model.responses.BookResponse;

@Component
public class BookMapperImpl implements BookMapper{
	
	private final AuthorMapper authorMapper;
	
	private final CategoryMapper categoryMapper;

	public BookMapperImpl(AuthorMapper authorMapper, CategoryMapper categoryMapper) {
		super();
		this.authorMapper = authorMapper;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public BookDto toDto(BookRequest request) {
		
		BookDto bookDto = new BookDto();
		if(request==null) {
			return null;
		}
		bookDto.setBookName(request.getName());
		bookDto.setAuthor_ids(request.getAuthor_id());
		bookDto.setCate_ids(request.getCate_id());
		return bookDto;
	}
	
	@Override
	public BookDto toDto(Book book) {
		if(book==null) {
			return null;
		}
		BookDto bookDto=new BookDto();
		bookDto.setId(book.getId());
		bookDto.setBookName(book.getName());
		bookDto.setCategories(categoryMapper.toDto(book.getCategories()));
		bookDto.setAuthors(authorMapper.toDto(book.getAuthors()));
		return bookDto;
	}
	
	@Override
	public BookResponse toResponse(BookDto bookDto) {
		if(bookDto==null) {
			return null;
		}
		BookResponse bookResponse=new BookResponse();
		bookResponse.setId(bookDto.getId());
		bookResponse.setBookName(bookDto.getBookName());
		bookResponse.setCategories(categoryMapper.toResponse(bookDto.getCategories()));
		bookResponse.setAuthors(authorMapper.toResponse(bookDto.getAuthors()));
		return bookResponse;
	}

}
