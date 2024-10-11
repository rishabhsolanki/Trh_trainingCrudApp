package com.crudOp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.crudOp.controller.BooksController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crudOp.model.Books;
import com.crudOp.repository.BooksRepository;

@Service
public class BooksService {

	private  static final Logger logger = LoggerFactory.getLogger(BooksService.class);
	@Autowired
	BooksRepository booksRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@KafkaListener(topics = {"medicine"},groupId = "abc")
	public void consumeMessage(String message){
		logger.info(message);
	}
	//getAll method done
	public List<Books> getAllBooks()  {
		List<Books>books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}
	
	//getById method done
	public Books getBooksById(int bookId) {
		return booksRepository.findById(bookId).orElseThrow(()-> new NoSuchElementException("user not exist"));
		
	}
	//save method done
	public Books saveBook(Books books) {
		String latestPassword= passwordEncoder.encode(books.getPassword());
		books.setPassword(latestPassword);
		return booksRepository.save(books);
	}
	
	//delete method done
	public int deleteBookByID(int id) {
		booksRepository.deleteById(id);
		return id;
	}
	//update method
	public Books updateBook(Books books,int bookId) {
		return booksRepository.save(books);
		//return booksRepository.findById(bookId);

	}

}
