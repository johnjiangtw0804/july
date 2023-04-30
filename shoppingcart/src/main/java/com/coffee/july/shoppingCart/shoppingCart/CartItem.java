package com.coffee.july.shoppingCart.shoppingCart;

import java.util.List;

public class CartItem {
    private String UserID;
    private List<List<String>> CartItems;
    private String DeliveryAddress;
    private float Total;
    private boolean isPaid;

    public String getUserID() {
        return this.UserID;
    };

    public void setUserID(String UserID) {
        this.UserID = UserID;
    };

    public List<List<String>> getCartItems() {
        return this.CartItems;
    };

    public void setCartItems(List<List<String>> CartItems) {
        this.CartItems = CartItems;
    };

    public float getTotal() {
        return this.Total;
    };

    public void setTotal(float Total) {
        this.Total = Total;
    };

    public String getDeliveryAddress() {
        return this.DeliveryAddress;
    };

    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    };

    public boolean getPaidStatus() {
        return this.isPaid;
    };

    public void setPaidStatus(boolean isPaid) {
        this.isPaid = isPaid;
    };
}
