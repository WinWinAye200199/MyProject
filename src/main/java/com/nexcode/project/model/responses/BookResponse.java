package com.nexcode.project.model.responses;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
	
	private Long id;
	private String bookName;
	private List<CategoryResponse> categories;
	private List<AuthorResponse> authors;
}
