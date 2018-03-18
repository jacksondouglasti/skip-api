package com.skip.api.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.skip.api.services.exception.AuthorizationException;

public class Authentication {

	public static CustomUserDetails authenticated() {
        try {
            return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new AuthorizationException("Access denied");
        }
    }
}
