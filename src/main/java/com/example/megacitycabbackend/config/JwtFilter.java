package com.example.megacitycabbackend.config;

import com.example.megacitycabbackend.service.JwtService;
import com.example.megacitycabbackend.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@CrossOrigin
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        String token  = null;
        String username = null;
        System.out.println(authHeader);
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token =authHeader.substring(7);

            username = jwtService.extractUsername(token);

            if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
                if(!jwtService.validateToken(token , username)){
                    UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities());
                    authToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }else{
                    System.out.println("Validation Error!");
                }
            }else{
                System.out.println("Username Null");
            }
        }else{
            System.out.println("Errror");
        }

        filterChain.doFilter(request ,response);
    }
}
