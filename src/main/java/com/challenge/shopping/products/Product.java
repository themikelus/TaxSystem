package com.challenge.shopping.products;

import com.challenge.shopping.taxes.TaxBehavior;

import java.math.BigDecimal;

public interface Product {

    String getName();

    BigDecimal getBasePrice();

    BigDecimal getTaxAmount();

    BigDecimal getTaxIncludedPrice();

    void addTaxBehavior(TaxBehavior taxBase);
}
