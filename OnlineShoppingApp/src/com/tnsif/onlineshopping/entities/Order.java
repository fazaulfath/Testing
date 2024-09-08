package com.tnsif.onlineshopping.entities;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private String status;
    private List<ProductQuantityPair> products;

    // Constructor
    public Order(int orderId, Customer customer, String status, List<ProductQuantityPair> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.status = status;
        this.products = products;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductQuantityPair> getProducts() {
        return products;
    }

    public void setProducts(List<ProductQuantityPair> products) {
        this.products = products;
    }
}
