package com.nexcode.project.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
			orphanRemoval = true, fetch = FetchType.LAZY) // You can specify cascade and fetch options here
    private List<Category> categories;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
			CascadeType.PERSIST},fetch = FetchType.LAZY)
	@JoinTable(
			name="book_author_map",
			joinColumns = @JoinColumn(
					name="book_id",
					referencedColumnName = "book_id"
					),
			inverseJoinColumns = @JoinColumn(
					name="author_id",
					referencedColumnName = "author_id"
					)
			)
	private List<Author> authors;
	
	
}
