package com.crudOp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.crudOp.model.Books;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Integer> {
	@Override
	Optional<Books> findById(Integer integer);
	Books findByUsername(String username);
	//Books findById(int i);

}
