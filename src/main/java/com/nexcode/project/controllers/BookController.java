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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.project.mapper.BookMapper;
import com.nexcode.project.model.dto.BookDto;
import com.nexcode.project.model.requests.BookRequest;
import com.nexcode.project.model.responses.BookResponse;
import com.nexcode.project.services.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookMapper bookMapper;
	
	@Autowired
	private BookService bookService;
	
	public BookController(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@PostMapping
	public BookResponse createBook(@RequestBody BookRequest request) {
		BookDto bookDto = bookMapper.toDto(request);
		BookDto saveBook= bookService.addBook(bookDto);
		return bookMapper.toResponse(saveBook);
	}

	@GetMapping
	public List<BookResponse> getBook() {
		
		List<BookDto>books=bookService.getAllBook();
//		for (BookDto bookDto : books) {
//			System.out.println(bookDto.getCategories().size());
//		}
		return books.stream().map(bookMapper::toResponse).collect(Collectors.toList());
	}
	@GetMapping("/{bookId}")
	public BookResponse getBookById(@PathVariable Long bookId) {
		BookDto bookDto = bookService.getBookById(bookId);
		return bookMapper.toResponse(bookDto);
	}
	
	@PutMapping("/{id}")
	public BookResponse updateBook(@RequestBody BookRequest request,@PathVariable Long id) {
		BookDto bookDto=bookMapper.toDto(request);
		BookDto saveBook=bookService.updateBook(bookDto,id);
		return bookMapper.toResponse(saveBook);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
	
//	@GetMapping("/{id}")
//    public List<BookResponse> getBooksById(@PathVariable Long id) {
//		List<BookDto> books=bookService.getAllBooksByIdWithCategoryAndAuthor(id);
//        return  books.stream().map(bookMapper::toResponse).collect(Collectors.toList());
//    }
	
}
