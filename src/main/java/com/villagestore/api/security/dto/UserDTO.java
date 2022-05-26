package com.villagestore.api.security.dto;

import com.villagestore.api.cart.application.CartDto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String password;
    private List<CartDto> cart;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CartDto> getCart() {
        return cart;
    }

    public void setCart(List<CartDto> cart) {
        this.cart = cart;
    }
}
