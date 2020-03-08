package com.challenge.shopping.products;

import com.challenge.shopping.taxes.BasicSalesTax;
import com.challenge.shopping.taxes.ImportDutySalesTax;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShelveItemTest {

    @Test
    public void getNameAndPrices_whenProductWithBasicAndImportTaxes() {
        String productName = "imported bottle of perfume";
        String price = "27.99";
        Product perfume = new ShelveItem(productName, new BigDecimal(price));
        perfume.addTaxBehavior(new BasicSalesTax());
        perfume.addTaxBehavior(new ImportDutySalesTax());

        assertEquals(productName, perfume.getName());
        assertEquals(price, perfume.getBasePrice().toString());
        assertEquals("4.20", perfume.getTaxAmount().toString());
        assertEquals("32.19", perfume.getTaxIncludedPrice().toString());

    }

    @Test
    public void getNameAndPrices_whenProductWithBasic() {
        String productName = "imported bottle of perfume";
        String price = "27.99";
        Product perfume = new ShelveItem(productName, new BigDecimal(price));
        perfume.addTaxBehavior(new BasicSalesTax());

        assertEquals(productName, perfume.getName());
        assertEquals(price, perfume.getBasePrice().toString());
        assertEquals("2.80", perfume.getTaxAmount().toString());
        assertEquals("30.79", perfume.getTaxIncludedPrice().toString());
    }

    @Test
    public void getNameAndPrices_whenProductWithImportTaxes() {
        String productName = "imported bottle of perfume";
        String price = "27.99";
        Product perfume = new ShelveItem(productName, new BigDecimal(price));
        perfume.addTaxBehavior(new ImportDutySalesTax());

        assertEquals(productName, perfume.getName());
        assertEquals(price, perfume.getBasePrice().toString());
        assertEquals("1.40", perfume.getTaxAmount().toString());
        assertEquals("29.39", perfume.getTaxIncludedPrice().toString());
    }

    @Test
    public void getNameAndPrices_whenProductWithNoTaxes() {
        String productName = "imported bottle of perfume";
        String price = "27.99";
        Product perfume = new ShelveItem(productName, new BigDecimal(price));

        assertEquals(productName, perfume.getName());
        assertEquals(price, perfume.getBasePrice().toString());
        assertEquals("0", perfume.getTaxAmount().toString());
        assertEquals(price, perfume.getTaxIncludedPrice().toString());
    }

}
