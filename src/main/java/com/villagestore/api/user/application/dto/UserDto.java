package com.villagestore.api.user.application.dto;

import com.villagestore.api.cart.application.CartDto;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String password;
    private String address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CartDto> getCart() {
        return cart;
    }

    public void setCart(List<CartDto> cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id.equals(userDto.id) && email.equals(userDto.email) && name.equals(userDto.name) && password.equals(userDto.password) && address.equals(userDto.address) && cart.equals(userDto.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, password, address, cart);
    }
}
