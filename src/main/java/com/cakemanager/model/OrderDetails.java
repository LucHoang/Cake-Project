package com.cakemanager.model;

public class OrderDetails {
    private int productId;
    private int orderId;
    private float salePrice;
    private int quantityProduct;
    private String productName;

    public OrderDetails() {

    }

    public OrderDetails(int productId, int orderId, float salePrice, int quantityProduct) {
        this.productId = productId;
        this.orderId = orderId;
        this.salePrice = salePrice;
        this.quantityProduct = quantityProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
