package com.villagestore.api.security.application.dto;

import com.villagestore.api.cart.application.CartDto;
import com.villagestore.api.order.application.OrderDTO;

import java.util.List;

public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String password;
    private List<CartDto> cart;
    private List<OrderDTO> order;

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

    public List<OrderDTO> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDTO> order) {
        this.order = order;
    }
}
