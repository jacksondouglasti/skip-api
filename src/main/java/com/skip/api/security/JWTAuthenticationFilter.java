package com.skip.api.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skip.api.dto.CredentialsDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    private ObjectMapper mapper;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, ObjectMapper mapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
        this.setFilterProcessesUrl("/Customer/auth");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            CredentialsDTO credentialsDTO = mapper.readValue(request.getInputStream(), CredentialsDTO.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credentialsDTO.getEmail(), credentialsDTO.getPassword(), new ArrayList<>());

            Authentication authenticate = authenticationManager.authenticate(authToken);
            return authenticate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((CustomUserDetails) authResult.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(username);
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        SecurityContextHolder.clearContext();

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        if (e instanceof BadCredentialsException) {
            mapper.writeValue(response.getWriter(), new AuthenticationFailed(HttpStatus.UNAUTHORIZED.value(), "Invalid username or password", System.currentTimeMillis(), e.getMessage(), request.getRequestURI()));
        } else  {
            mapper.writeValue(response.getWriter(), new AuthenticationFailed(HttpStatus.UNAUTHORIZED.value(), "Authentication Failed: Bad credentials", System.currentTimeMillis(), e.getMessage(), request.getRequestURI()));
        }

    }
}
