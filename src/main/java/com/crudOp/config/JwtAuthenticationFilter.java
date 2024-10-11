package com.crudOp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     final String autherazationHeader = request.getHeader("Authorization");

    String jwtToken=null;
    String username=null;

    if(autherazationHeader != null && autherazationHeader.startsWith("Bearer ")){
        jwtToken =autherazationHeader.substring(7);
        username =jwtUtil.extractUsername(jwtToken);
    }
    if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
        if(jwtUtil.validateToken(jwtToken,username)){
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(username,null,null)
            );
        }
    }
    filterChain.doFilter(request,response);

    }
}
