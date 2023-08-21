package com.nexcode.project.mapper;

import com.nexcode.project.model.dto.BookDto;
import com.nexcode.project.model.entities.Book;
import com.nexcode.project.model.requests.BookRequest;
import com.nexcode.project.model.responses.BookResponse;

public interface BookMapper {
	BookDto toDto(BookRequest request);
	
	BookDto toDto(Book book);
	BookResponse toResponse(BookDto bookDto);
}
