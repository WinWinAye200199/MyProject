package com.nexcode.project.model.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
	private String name;
	private List<Long> authorIds;
	private List<Long> categoryIds;
}
