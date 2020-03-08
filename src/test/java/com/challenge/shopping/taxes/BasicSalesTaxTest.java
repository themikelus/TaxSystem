package com.challenge.shopping.taxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class BasicSalesTaxTest {
    @Test
    public void getTaxAmount_whePriceHasToBeRoundedUpTo05() {
        TaxBehavior basicTax = new BasicSalesTax();

        assertEquals("1.05", basicTax.getTaxAmount(new BigDecimal("10.13")).toString());
    }

    @Test
    public void getTaxAmount_whePriceHasToBeRoundedUpTo0() {
        TaxBehavior basicTax = new BasicSalesTax();

        assertEquals("1.00", basicTax.getTaxAmount(new BigDecimal("9.99")).toString());
    }

    @Test
    public void getTaxAmount_whePriceIs0() {
        TaxBehavior basicTax = new BasicSalesTax();

        assertEquals("0.00", basicTax.getTaxAmount(new BigDecimal("0")).toString());
    }
}
