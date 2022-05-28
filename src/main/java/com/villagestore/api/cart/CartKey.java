package com.villagestore.api.cart;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartKey implements Serializable {

    @Column(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long userId;

    @Column(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long productId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartKey cartKey = (CartKey) o;
        return userId.equals(cartKey.userId) && productId.equals(cartKey.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }
}
