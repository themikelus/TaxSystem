package com.challenge.shopping;

import com.challenge.shopping.Order;
import com.challenge.shopping.products.Product;

import java.util.LinkedList;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Order checkout() {
        return new Order(this.products);
    }
}
