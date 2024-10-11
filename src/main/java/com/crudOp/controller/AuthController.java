package com.crudOp.controller;

import com.crudOp.service.CustomUserAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

        @Autowired
        CustomUserAuthService customUserAuthService;

        @PostMapping("/login")
        public ResponseEntity<Map<String,String>> login(@RequestParam("username") String username, @RequestParam("password") String password){
        String token = customUserAuthService.loginUser(username,password);
        Map<String,String> response = new HashMap<>() ;
        response.put("Token ",token);
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }
}
