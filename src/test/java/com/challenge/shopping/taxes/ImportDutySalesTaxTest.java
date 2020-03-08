package com.challenge.shopping.taxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ImportDutySalesTaxTest {
    @Test
    public void getTaxAmount_whePriceHasToBeRoundedUpTo05() {
        TaxBehavior basicTax = new ImportDutySalesTax();

        assertEquals("0.55", basicTax.getTaxAmount(new BigDecimal("10.13")).toString());
    }

    @Test
    public void getTaxAmount_whePriceHasToBeRoundedUpTo0() {
        TaxBehavior basicTax = new ImportDutySalesTax();

        assertEquals("0.50", basicTax.getTaxAmount(new BigDecimal("9.80")).toString());
    }

    @Test
    public void getTaxAmount_whePriceIs0() {
        TaxBehavior basicTax = new ImportDutySalesTax();

        assertEquals("0.00", basicTax.getTaxAmount(new BigDecimal("0")).toString());
    }
}
