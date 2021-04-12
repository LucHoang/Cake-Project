package com.cakemanager.model;

import java.util.Date;

public class Orders {
    private int orderId;
    private Date orderDate;
    private int userId;
    private boolean status;

    public Orders() {

    }

    public Orders(int orderId, Date orderDate, int userId, boolean status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.userId = userId;
        this.status = status;
    }

    public Orders(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
