package com.villagestore.api.product.domain;

import com.villagestore.api.category.domain.Category;
import com.villagestore.api.user.domain.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User supplier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private Integer price;
    private String description;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSupplier() {
        return supplier;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!supplier.equals(product.supplier)) return false;
        if (!category.equals(product.category)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (!description.equals(product.description)) return false;
        return image.equals(product.image);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + supplier.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + image.hashCode();
        return result;
    }
}
