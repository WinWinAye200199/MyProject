package com.nexcode.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexcode.project.mapper.BookMapper;
import com.nexcode.project.model.dto.BookDto;
import com.nexcode.project.model.entities.Author;
import com.nexcode.project.model.entities.Book;
import com.nexcode.project.model.entities.Category;
import com.nexcode.project.repositories.AuthorRepository;
import com.nexcode.project.repositories.BookRepository;
import com.nexcode.project.repositories.CategoryRepository;

@Service
public class BookService {
	
	
	private final BookRepository bookRepository;
	
	private final BookMapper bookMapper;
	
	private final CategoryRepository categoryRepository;
	
	private final AuthorRepository authorRepository;
	
	public BookService(BookRepository bookRepository, BookMapper bookMapper, CategoryRepository categoryRepository,
			AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.bookMapper = bookMapper;
		this.categoryRepository = categoryRepository;
		this.authorRepository = authorRepository;
	}


	public BookDto addBook(BookDto bookDto) {
		Book book = new Book();
		book.setName(bookDto.getBookName());
		List<Author> authors = new ArrayList<>();
		List<Long> authorIds = bookDto.getAuthor_ids();
		for (Long authorId : authorIds) {
			Author author = authorRepository.findById(authorId).orElse(null);
			authors.add(author);
		}
		book.setAuthors(authors);
		List<Category> categories = new ArrayList<>();
		List<Long> categoryIds = bookDto.getCate_ids();
		for (Long categoryId : categoryIds) {
			Category category = categoryRepository.findById(categoryId).orElse(null);
			categories.add(category);
		}
		book.setCategories(categories);
		Book savedBook = bookRepository.save(book);
		return bookMapper.toDto(savedBook);
	}
	
	
	public List<BookDto> getAllBook(){
		List<Book>book1=bookRepository.findAll();
		List<BookDto> bookDtos = book1.stream().map(b->bookMapper.toDto(b)).collect(Collectors.toList());
		return bookDtos;
//		return book1.stream().map(bookMapper::toDto).collect(Collectors.toList());
	}
	
	public BookDto getBookById(Long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Book book = optionalBook.get();
		
		return bookMapper.toDto(book);
	}
	
//	public List<Book> getAllBooksById(Long bookId) {
//        return bookRepository.findAllById(bookId);
//    }
	
//	public List<BookDto> getAllBooksById(Long id){
//		List<Book>book=bookRepository.findAllById(id);
//		List<BookDto> bookDto= book.stream().map(b->bookMapper.toDto(b)).collect(Collectors.toList());
//		return bookDto;
//		
//	}
	
	
	public BookDto updateBook(BookDto bookDto,Long id) {
		
		Book book=bookRepository.findById(id).orElse(null);
		
		if(book != null) {
			
		book.setName(bookDto.getBookName());
		
		//book.setAuthors(bookDto.getAuthor_ids());
		}
		bookRepository.save(book);
		return bookMapper.toDto(book);
		
	}
	
	public void deleteBook(Long id) {
		Book book=bookRepository.findById(id).orElse(null);
		if( book != null) {
			bookRepository.deleteById(id);
		}
	}
}
