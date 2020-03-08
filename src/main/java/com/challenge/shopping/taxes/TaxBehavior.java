package com.challenge.shopping.taxes;

import java.math.BigDecimal;

public interface TaxBehavior {

    BigDecimal getTaxAmount(BigDecimal basePrice);

}
