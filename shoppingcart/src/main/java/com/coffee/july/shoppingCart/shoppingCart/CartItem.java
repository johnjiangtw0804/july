package com.coffee.july.shoppingCart.shoppingCart;

import java.util.Map;

public class CartItem {
    private int UserID;
    private Map<String, String> CartItems;
    private String DeliveryAddress;
    private float Total;
    private boolean isPaid;

    public int getUserID() {
        return this.UserID;
    };

    public void setUserID(int UserID) {
        this.UserID = UserID;
    };

    public Map<String, String> getCartItems() {
        return this.CartItems;
    };

    public void setCartItems(Map<String, String> CartItems) {
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
