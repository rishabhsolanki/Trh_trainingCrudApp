package com.crudOp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudOp.model.Books;
import com.crudOp.repository.BooksRepository;

@SpringBootTest
public class BooksServiceTest {
	
	@Autowired
	BooksRepository booksRepository;
	
	@Disabled
	@Test
	public void getBooksByIdTest() {
		
		 assertNotNull(  booksRepository.findById(1));
	}
	@Disabled
	@Test
	public void getBooksByIduserTest() {
		Books book = booksRepository.findById(1);
		 assertTrue(!book.getBookname().isEmpty());
	}
	@Disabled
	@ParameterizedTest
	@ValueSource(ints={
			1,
		   52,
		   53,
		    2,
		   54
	})
	public void getBooksByIduserTest(int id) {
		Books book = booksRepository.findById(id);
		 assertTrue(!book.getBookname().isEmpty());
		 assertThat(!book.getBookname().isEmpty()).isTrue();
		 assertNotNull(book);
	}
	
	
	//save method test
	@Disabled
	@CsvSource({
        "1, 'Data Structures in C', 'Author A', 700",
        "2, 'Algorithms', 'Author B', 500",
        "3, 'Java Programming', 'Author C', 900"
    })
		public void saveOrUpdateTest(Books books) {
			// Books book =booksRepository.save(books);
		Books book =booksRepository.save(books);
			// assertThat(books.getBookname()isNotNull());
			 assertNotEquals(null,book);
			 assertTrue(book.equals(null));			 
		}
	
	//delete  Test method
		@ParameterizedTest
		@ValueSource(ints={
				1,
			   52,
			   53,
			    2,
			   54
		})
		public void deleteTest(int id) {
			booksRepository.deleteById(id);
			Books book = booksRepository.findById(id);
			assertNull(book);
		}
	
	
	
	

}
