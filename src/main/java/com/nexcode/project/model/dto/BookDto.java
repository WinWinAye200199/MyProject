package com.nexcode.project.model.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	private Long id;
	private String bookName;
	private List<Long> cate_ids;
	private List<CategoryDto> categories;
	private List<AuthorDto> authors;
	private List<Long> author_ids;
	
	
}
