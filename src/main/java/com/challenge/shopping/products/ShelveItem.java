package com.challenge.shopping.products;

import com.challenge.shopping.taxes.TaxBehavior;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShelveItem implements Product {

    private String name;
    private BigDecimal basePrice;
    private List<TaxBehavior> taxBases;

    public ShelveItem(String name, BigDecimal basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxBases = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    @Override
    public BigDecimal getTaxAmount() {
        BigDecimal taxAmount = BigDecimal.ZERO;

        if (!this.taxBases.isEmpty()) {
            for (TaxBehavior taxBase : this.taxBases) {
                taxAmount = taxAmount.add(taxBase.getTaxAmount(getBasePrice()));
            }
        }

        return taxAmount;
    }

    @Override
    public BigDecimal getTaxIncludedPrice() {
        return getBasePrice().add(getTaxAmount());
    }

    @Override
    public void addTaxBehavior(TaxBehavior taxBase) {
        this.taxBases.add(taxBase);
    }
}
