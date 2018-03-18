package com.skip.api.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public CustomUserDetails(Long id, String email, String password, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(String role) {
        return getAuthorities().contains(new SimpleGrantedAuthority(role));
    }
}
