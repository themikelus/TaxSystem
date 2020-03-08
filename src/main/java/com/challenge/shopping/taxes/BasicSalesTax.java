package com.challenge.shopping.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicSalesTax implements TaxBehavior {

    private final BigDecimal ROUNDING_RULE = new BigDecimal(20); //nearest up 0.05
    private final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private BigDecimal taxRate;

    public BasicSalesTax() {
        taxRate = new BigDecimal(10); //% value
    }

    @Override
    public BigDecimal getTaxAmount(BigDecimal basePrice) {
        BigDecimal taxAmount = basePrice.multiply(taxRate).divide(ONE_HUNDRED);

        //Keep only two decimals
        taxAmount = customRound(taxAmount).setScale(2, RoundingMode.FLOOR);

        return taxAmount;
    }

    private BigDecimal customRound(BigDecimal value) {
        return value.multiply(ROUNDING_RULE).setScale(0, RoundingMode.CEILING).divide(ROUNDING_RULE);
    }
}
