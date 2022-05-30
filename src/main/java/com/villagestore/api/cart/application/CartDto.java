package com.villagestore.api.cart.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class CartDto implements Serializable {

    private Long id;
    private Long userId;
    private Long productId;
    private String productName;
    private Integer productPrice;
    private byte[] productImage;
    private Integer quantity;

    public CartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productprice) {
        this.productPrice = productprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Arrays.equals(productImage, cartDto.productImage) && productName.equals(cartDto.productName) && productPrice.equals(cartDto.productPrice) && quantity.equals(cartDto.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(productImage), productName, productPrice, quantity);
    }

}
