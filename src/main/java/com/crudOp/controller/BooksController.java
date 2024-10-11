package com.crudOp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.crudOp.model.Books;
import com.crudOp.service.BooksService;



@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BooksService booksService;

	@Autowired
	private  KafkaTemplate kafkaTemplate;

	private  static final Logger logger = LoggerFactory.getLogger(BooksController.class);

	@GetMapping("/kafka")
	public  void SendMessage(@RequestParam String message ){
		kafkaTemplate.send("medicine",message);

	}
	//done
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks(){
		logger.info("get all books called..  info");
		logger.warn("get all books called..  warn");
		logger.error("get all books called..  error");
		logger.trace("get all books called..  trace");
		logger.debug("get all books called..  debug");
		return booksService.getAllBooks();		
	}
	//done
	@GetMapping("/getBookById/{bookid}")
	public Books getBooksById(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}
//	@GetMapping("/getBookById/{bookid}")
//	public ResponseEntity<CustomResponse<Books>> getBookById(@PathVariable("bookid") int bookid){
//		Books book =booksService.getBooksById(bookid);
//		if(book ==null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse<>("user not found", null));
//		}
//		CustomResponse<Books> response =new CustomResponse<>("Books Fetched Succesfully", book);
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
	
	//done
	@DeleteMapping("/deleteBook/{bookid}")
	public int deleteBookByID(@PathVariable("bookid") int bookid) {
		logger.info("delete books called..  info ID"+bookid);
		logger.warn("delete books called..  warn");
		logger.error("delete books called..  error");

		logger.debug("delete books called..  debug");
		booksService.deleteBookByID(bookid);
		return bookid;
	}


//	@DeleteMapping("/deleteBook/{bookid}")
//	public int deleteBookByID(@PathVariable("bookid") int bookid) throws BookNotFoundException {
//		if(!booksService.getBooksById(bookid).equals(null)){
//			throw  new BookNotFoundException("Book Id"+ bookid+" Not present");
//		}
//		booksService.deleteBookByID(bookid);
//		return bookid;
//	}
	//done
	@PostMapping("/saveBook")
	public Books saveBook(@RequestBody Books books) {
		booksService.saveBook(books);
		return books;
	}
	
//	@PutMapping("/updateBook")
//	public Books update(@RequestBody Books books) {
//		booksService.saveOrUpdate(books);
//		return books;
//	}

	@PutMapping("/updateBook")
	public Books updateBook(@RequestBody  Books books) {

		//remove from here1
//		Optional<Books> optionalBooks = Optional.ofNullable(booksService.getBooksById(books.getBookid()));
//		if(!optionalBooks.isEmpty()){
//			throw new BookNotFoundException("Books with Id"+books.getBookid()+"does Not Exixt");
//		}
//		Books existingBook = optionalBooks.get();
//		existingBook.setBookname(books.getBookname());
//		existingBook.setAuthor(books.getAuthor());
//		existingBook.setPrice(books.getPrice());
//		return booksService.updateBook(existingBook,existingBook.getBookid());
		// upto here1

		// unComment below code  from here2
		Books returnedBook;
        returnedBook = booksService.updateBook(books,books.getBookid());
        return returnedBook;
		// to here2
	}

}
