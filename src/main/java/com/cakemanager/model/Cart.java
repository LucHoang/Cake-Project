package com.cakemanager.model;

public class Cart {
    private int cartId;
    private String productName;
    private float productPrice;
    private int quantity;
    private float priceTotal;
    private String thumbnail;
    private int userId;

    public Cart() {

    }

    public Cart(int cartId, String productName, float productPrice, int quantity, float priceTotal, String thumbnail, int userId) {
        this.cartId = cartId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.priceTotal = priceTotal;
        this.thumbnail = thumbnail;
        this.userId = userId;
    }

    public Cart(String productName, float productPrice, float priceTotal, String thumbnail, int userId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.priceTotal = priceTotal;
        this.thumbnail = thumbnail;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }
}
