package com.villagestore.api.cart.domain;

import com.villagestore.api.cart.CartKey;
import com.villagestore.api.product.domain.Product;
import com.villagestore.api.security.domain.entity.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Cart {

    @EmbeddedId
    private CartKey id;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @MapsId("productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;

    public Cart() {
    }

    public CartKey getId() {
        return id;
    }

    public void setId(CartKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass() || id == null) return false;
        Cart cart = (Cart) obj;
        return id.equals(cart.id);
    }
}
