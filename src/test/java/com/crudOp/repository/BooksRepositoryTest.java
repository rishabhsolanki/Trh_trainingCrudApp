package com.crudOp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudOp.model.Books;
//@DataJpaTest
import com.crudOp.service.BooksService;
public class BooksRepositoryTest {
	
		
	
	
	
//	@Autowired
//	private BooksRepository booksRepository;
//	//Books findById(int i);
//	
//	@Test
//	public void testSaveBooks() {
//		Books book =new Books( "Ramayan", "Valmiki", 100000);
//		Books saveBook = booksRepository.save(book);
//		
//		assertNotNull(saveBook);
//		assertNotNull(saveBook.getBookid());
//		assertEquals("Ramayan", saveBook.getBookname());
//		assertEquals("Valmiki", saveBook.getAuthor());
//		//assertTrue(booksRepository.existsById(saveBook.getBookid()));
//		
//	}
//	
	
	
	
	
	
	
	/*
	 * @ParameterizedTest
	@ValueSource(ints={
			1,
		   52,
		   53,
		    2,
		   54
	})
	public void isfindByIdTest(int id) {
		Boolean actualResult = booksRepository.existsById(id);
		assertThat(actualResult).isTrue();
	}
	 */

}
