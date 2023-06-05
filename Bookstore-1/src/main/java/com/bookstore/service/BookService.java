package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo bookrepo ;
	
	public Book save(Book book) {
		return bookrepo.save(book);  //jpa repository have all functions
	}
	
	public List<Book> allBooks(){
		return bookrepo.findAll();
	}
	
	public Book getBook(int id) {
		return bookrepo.findById(id).orElse(new Book());
	}
	public void deleteBook(int id) {
		bookrepo.deleteById(id);
	}
	
	public List<Book> searchBook(String title){
		return bookrepo.getBookByTitleContains(title);
	}
}
