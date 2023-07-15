package org.kainos.ea.cli;

import java.util.Date;

public class Order implements Comparable<Order> {
    public Order(int orderID, int customerID, int orderDate) {
    }

    public Order(int customerID) {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order(int orderId, int customerId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private int orderId;
    private int customerId;
    private Date orderDate;

    @Override
    public String toString(){
        return "Customer id: " + String.valueOf(this.getCustomerId());
    }
    @Override
    public int compareTo(Order o) {
        return this.getOrderDate().compareTo(o.getOrderDate());
    }
}
