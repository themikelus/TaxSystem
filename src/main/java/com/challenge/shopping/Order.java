package com.challenge.shopping;

import com.challenge.shopping.products.Product;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getSalesTaxes() {
        BigDecimal salesTaxes = BigDecimal.ZERO;

        for (Product product : this.products) {
            salesTaxes = salesTaxes.add(product.getTaxAmount());
        }

        return salesTaxes;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Product product : this.products) {
            total = total.add(product.getTaxIncludedPrice());
        }

        return total;
    }

    public List<Product> getProducts() {
        return products;
    }
}
