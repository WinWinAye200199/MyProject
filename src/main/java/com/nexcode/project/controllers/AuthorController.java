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

import com.nexcode.project.mapper.AuthorMapper;
import com.nexcode.project.model.dto.AuthorDto;
import com.nexcode.project.model.requests.AuthorRequest;
import com.nexcode.project.model.responses.AuthorResponse;
import com.nexcode.project.services.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	private final AuthorMapper authorMapper;
	
	@Autowired
	private AuthorService authorService;
	
	public AuthorController(AuthorMapper authorMapper) {
		this.authorMapper=authorMapper;
	}
	
	@PostMapping
	public AuthorDto createAuthor(@RequestBody AuthorRequest request)
	{
		AuthorDto authorDto=authorMapper.toDto(request);
		authorService.addAuthor(authorDto);
		return null;
	}
	@GetMapping
	public List<AuthorResponse> getAuthor() {
		List<AuthorDto>authors=authorService.getAllAuthor();
		return authors.stream().map(authorMapper::toResponse).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public List<AuthorResponse> getAuthorById(@PathVariable Long id){
		List<AuthorDto> authors= authorService.getAuthorById(id);
		return authors.stream().map(authorMapper::toResponse).collect(Collectors.toList());
	
	} 
	
	@PutMapping("/{id}")
	public AuthorDto updateAuthor(@RequestBody AuthorRequest request,@PathVariable Long id) {
		AuthorDto authorDto=authorMapper.toDto(request);
		authorService.updateAuthor(authorDto,id);
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		authorService.deleteAuthor(id);
	}

}
