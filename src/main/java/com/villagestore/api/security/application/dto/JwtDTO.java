package com.villagestore.api.security.application.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDTO {

    private String token;
    private String bearer = "Bearer";
    private Long id;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token,Long id, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
