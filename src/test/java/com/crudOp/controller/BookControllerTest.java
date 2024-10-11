package com.crudOp.controller;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crudOp.model.Books;
import com.crudOp.service.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest  // Only load the Web layer
public class BookControllerTest {

	@Mock
	private BooksService booksService;

	@InjectMocks
	private BooksController booksController;

	private MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	Books book1 = new Books(6, "Kitab6", "Kitab6Writer", 600);
	Books book2 = new Books(7, "Kitab7", "Kitab7Writer", 700);
	Books book3 = new Books(8, "Kitab8", "Kitab8Writer", 800);
	Books book4 = new Books(9, "Kitab9", "Kitab9Writer", 900);

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
	}

	@Test
	public void getAllBooksTest() throws Exception {
		List<Books> records = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));

		Mockito.when(booksService.getAllBooks()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders // Perform the GET request and verify the result
						.get("/books/getAllBooks")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(4)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].bookname").value("Kitab6"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].bookname").value("Kitab7"));
	}
@Test
public void getBookByIdTest()throws Exception {
	Mockito.when(booksService.getBooksById(book1.getBookid())).thenReturn(book1);
	mockMvc.perform(MockMvcRequestBuilders
			.get("/books/getBookById/6")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",notNullValue()))
			.andExpect(jsonPath("$.bookname").value("Kitab6"));
}

	@Test
	public void saveBookTest() throws  Exception {
		Books book = Books.builder()
				.bookid(2)
				.bookname("myBook")
				.password("Rishabh")
				.price(333)
				.build();
		Mockito.when(booksService.saveBook(book)).thenReturn(book);

		String content =objectWriter.writeValueAsString(book);

	MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
			.post("/books/saveBook")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(content);

	mockMvc.perform(mockRequest)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$",notNullValue()))
			.andExpect(jsonPath("$.bookname").value("myBook"));

}
	@Test
	public void updateBookTest() throws  Exception {
		Books updatedBook = Books.builder()
				.bookid(7)
				.bookname("Apni book")
				.password("Rishabh")
				.price(334)
				.build();

		Mockito.when(booksService.getBooksById(book2.getBookid())).thenReturn(book2);
		Mockito.when(booksService.saveBook(updatedBook)).thenReturn(updatedBook);

		String updateContent = objectWriter.writeValueAsString(updatedBook);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.put("/books/updateBook/7")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(updateContent);
		mockMvc.perform(mockRequest)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",notNullValue()))
				.andExpect(jsonPath("$.author").value("Rishabh"));
	}

	@Test
	public void deleteBookTest() throws  Exception {
		Mockito.when(booksService.getBooksById(book1.getBookid())).thenReturn(book1);
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/books/deleteBook/6")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
