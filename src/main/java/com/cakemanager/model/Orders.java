package com.cakemanager.model;

import java.util.Date;

public class Orders {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private boolean status;

    public Orders() {

    }

    public Orders(int orderId, Date orderDate, int customerId, boolean status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
