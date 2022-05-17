package com.villagestore.api.product.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProductDto implements Serializable {

    private Long id;
    private String name;
    private String supplierId;
    private String categoryId;
    private String supplierName;
    private String categoryName;
    private Integer price;
    private String description;
    private byte[] image;

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id.equals(that.id) && name.equals(that.name) && price.equals(that.price) && description.equals(that.description) && image.equals(that.image) && supplierId.equals(that.supplierId) && categoryId.equals(that.categoryId) && supplierName.equals(that.supplierName) && categoryName.equals(that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, image, supplierId, categoryId, supplierName, categoryName);
    }
}
