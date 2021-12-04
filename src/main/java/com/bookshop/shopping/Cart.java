/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VODUCMINH
 */
public class Cart {
    private Map<String, CartProduct> cart;

    public Cart() {
    }

    public Cart(Map<String, CartProduct> cart) {
        this.cart = cart;
    }

    public Map<String, CartProduct> getCart() {
        return cart;
    }

    public void setCart(Map<String, CartProduct> cart) {
        this.cart = cart;
    }
    
    public void addToCart(CartProduct product) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(product.getID())) {
            int currentQuantity = this.cart.get(product.getID()).getQuantity();
            product.setQuantity(currentQuantity + product.getQuantity());
        }
        cart.put(product.getID(), product);
    }
    
    public void updateCart(String productID, CartProduct product) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(productID)) {
            this.cart.replace(productID, product);
        }
    }
    
    public void removeCart(String productID) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(productID)) {
            this.cart.remove(productID);
        }
    }
    
    public double getTotalMoney() {
        double totalMoney = 0;
        if (this.cart != null) {
            for (CartProduct product : this.cart.values()) {
                totalMoney += product.getPrice() * product.getQuantity();
            }
        }
        
        return totalMoney;
    }
    
   
}
