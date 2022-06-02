package com.villagestore.api.order.application;

import com.villagestore.api.productLine.application.ProductLineDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {

    private Long id;
    private Long userId;
    private Date date;
    private String state;
    private String payment;
    private List<ProductLineDTO> productLine;

    public OrderDTO() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<ProductLineDTO> getProductLine() {
        return productLine;
    }

    public void setProductLine(List<ProductLineDTO> productLine) {
        this.productLine = productLine;
    }
}
