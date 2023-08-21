package com.nexcode.project.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nexcode.project.mapper.AuthorMapper;
import com.nexcode.project.model.dto.AuthorDto;
import com.nexcode.project.model.entities.Author;
import com.nexcode.project.model.requests.AuthorRequest;
import com.nexcode.project.model.responses.AuthorResponse;

@Component
public class AuthorMapperImpl implements AuthorMapper {
	
	@Override
	public AuthorDto toDto(AuthorRequest request) {
		AuthorDto authorDto=new AuthorDto();
		if(request==null) {
			return null;
		}
		authorDto.setName(request.getName());
		return authorDto;
	}
	
	@Override
	public AuthorDto toDto(Author author) {
		if(author==null) {
			return null;
		}
		AuthorDto authorDto=new AuthorDto();
		authorDto.setId(author.getAuthor_id());
		authorDto.setName(author.getName());
		return authorDto;
	}
	
	@Override
	public AuthorResponse toResponse(AuthorDto authorDto) {
		if(authorDto==null) {
			return null;
		}
		AuthorResponse authorResponse=new AuthorResponse();
		authorResponse.setId(authorDto.getId());
		authorResponse.setName(authorDto.getName());
		return authorResponse;
	}

	@Override
	public List<AuthorDto> toDto(List<Author> authors) {
		
		return authors.stream().map(a->toDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<AuthorResponse> toResponse(List<AuthorDto> authors) {
	
		return authors.stream().map(a->toResponse(a)).collect(Collectors.toList());
	}

}
