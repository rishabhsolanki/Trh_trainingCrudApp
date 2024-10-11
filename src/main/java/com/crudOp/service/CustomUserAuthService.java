package com.crudOp.service;

import com.crudOp.config.JwtUtil;
import com.crudOp.model.Books;
import com.crudOp.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.NoSuchElementException;
@Service
public class CustomUserAuthService implements UserDetailsService {

        @Autowired
        BooksRepository booksRepository;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Books books = booksRepository.findByUsername(username);
        if(books == null){
            throw new NoSuchElementException("User Not Found!!!");
        }
        return new org.springframework.security.core.userdetails.User(books.getUsername(),books.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(books.getRole())));
    }

    public String loginUser(String username ,String password){
        UserDetails userDetails = loadUserByUsername(username);
        if(userDetails !=null && passwordEncoder.matches(password,userDetails.getPassword())){
                return jwtUtil.generateToken(username);
        }
        throw  new RuntimeException("Invalid Credentials !!");
    }
}
