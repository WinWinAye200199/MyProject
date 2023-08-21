package com.nexcode.project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexcode.project.mapper.AuthorMapper;
import com.nexcode.project.model.dto.AuthorDto;
import com.nexcode.project.model.entities.Author;
import com.nexcode.project.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private AuthorMapper authorMapper;

	public void addAuthor(AuthorDto authorDto) {
		
		Author author=new Author();
		author.setName(authorDto.getName());
		authorRepository.save(author);
	}
	

	public List<AuthorDto> getAllAuthor(){
		List<Author>author=authorRepository.findAll();
		List<AuthorDto> authorDtos = author.stream().map(b->authorMapper.toDto(b)).collect(Collectors.toList());
		return authorDtos;
//		return book1.stream().map(bookMapper::toDto).collect(Collectors.toList());
	}
	
	public List<AuthorDto> getAuthorById(Long id){
		Optional<Author>author=authorRepository.findById(id);
		List<AuthorDto> authorDto= author.stream().map(b->authorMapper.toDto(b)).collect(Collectors.toList());
		return authorDto;
		
	}
	
	public void updateAuthor(AuthorDto authorDto,Long id) {
		
		Author author=authorRepository.findById(id).orElse(null);
		if(author != null) {
		author.setName(authorDto.getName());
//		author.setBook_id(authorDto.getBook_id());
		}
		authorRepository.save(author);
		
	}
	
	public void deleteAuthor(Long id) {
		Author author=authorRepository.findById(id).orElse(null);
		if( author != null) {
			authorRepository.deleteById(id);
		}
	}
}
