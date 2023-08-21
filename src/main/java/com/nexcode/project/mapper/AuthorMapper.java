package com.nexcode.project.mapper;

import java.util.List;

import com.nexcode.project.model.dto.AuthorDto;
import com.nexcode.project.model.entities.Author;
import com.nexcode.project.model.requests.AuthorRequest;
import com.nexcode.project.model.responses.AuthorResponse;

public interface AuthorMapper {
	
	AuthorDto toDto(AuthorRequest request);
	
	AuthorDto toDto(Author author);
	AuthorResponse toResponse(AuthorDto authorDto);

	List<AuthorDto> toDto(List<Author> authors);

	List<AuthorResponse> toResponse (List<AuthorDto>authors);
}
