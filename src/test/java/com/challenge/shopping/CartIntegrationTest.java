package com.challenge.shopping;

import com.challenge.shopping.products.ShelveItem;
import com.challenge.shopping.products.Product;
import com.challenge.shopping.taxes.BasicSalesTax;
import com.challenge.shopping.taxes.ImportDutySalesTax;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CartIntegrationTest {

    @Test
    public void getOrder_whenThreeProductsInCartAndOnlyOneWithTaxes() {
        Product book = new ShelveItem("book", new BigDecimal("12.49"));

        Product musicCd = new ShelveItem("music CD", new BigDecimal("14.99"));
        musicCd.addTaxBehavior(new BasicSalesTax());

        Product chocolateBar = new ShelveItem("chocolate bar", new BigDecimal("0.85"));

        Cart cart = new Cart();
        cart.addProduct(book);
        cart.addProduct(musicCd);
        cart.addProduct(chocolateBar);
        Order order = cart.checkout();

        assertEquals(new BigDecimal("1.50"), order.getSalesTaxes());
        assertEquals(new BigDecimal("29.83"), order.getTotal());
    }

    @Test
    public void getOrder_whenTwoProductsInCartAndDifferentTaxes() {
        Product importedChocolates = new ShelveItem("imported box of chocolates", new BigDecimal("10.00"));
        importedChocolates.addTaxBehavior(new ImportDutySalesTax());

        Product importedWater = new ShelveItem("imported bottle of perfume", new BigDecimal("47.50"));
        importedWater.addTaxBehavior(new BasicSalesTax());
        importedWater.addTaxBehavior(new ImportDutySalesTax());

        Cart cart = new Cart();
        cart.addProduct(importedChocolates);
        cart.addProduct(importedWater);
        Order order = cart.checkout();

        assertEquals(new BigDecimal("7.65"), order.getSalesTaxes());
        assertEquals(new BigDecimal("65.15"), order.getTotal());
    }

    @Test
    public void getOrder_whenFourProductsInCartWithDifferentTaxes() {
        Product importedPerfume = new ShelveItem("imported bottle of perfume", new BigDecimal("27.99"));
        importedPerfume.addTaxBehavior(new BasicSalesTax());
        importedPerfume.addTaxBehavior(new ImportDutySalesTax());

        Product localPerfume = new ShelveItem("bottle of perfume", new BigDecimal("18.99"));
        localPerfume.addTaxBehavior(new BasicSalesTax());

        Product pills = new ShelveItem("packet of headache pills", new BigDecimal("9.75"));

        Product importedChocolates = new ShelveItem("imported box of chocolates", new BigDecimal("11.25"));
        importedChocolates.addTaxBehavior(new ImportDutySalesTax());

        Cart cart = new Cart();
        cart.addProduct(importedPerfume);
        cart.addProduct(localPerfume);
        cart.addProduct(pills);
        cart.addProduct(importedChocolates);
        Order order = cart.checkout();

        assertEquals(new BigDecimal("6.70"), order.getSalesTaxes());
        assertEquals(new BigDecimal("74.68"), order.getTotal());
    }

    @Test
    public void getOrder_whenOneProductInCart() {
        Product productOne = new ShelveItem("Sony 22 TV", new BigDecimal("101.2"));
        productOne.addTaxBehavior(new BasicSalesTax());

        Cart cart = new Cart();
        cart.addProduct(productOne);
        Order order = cart.checkout();

        assertEquals(new BigDecimal("10.15"), order.getSalesTaxes());
        assertEquals(new BigDecimal("111.35"), order.getTotal());
    }

    @Test
    public void getOrder_whenOneProductsInCart() {
        Product productOne = new ShelveItem("Fridge Whirpool", new BigDecimal("101.6"));
        productOne.addTaxBehavior(new BasicSalesTax());

        Cart cart = new Cart();
        cart.addProduct(productOne);
        Order order = cart.checkout();

        assertEquals(new BigDecimal("10.20"), order.getSalesTaxes());
        assertEquals(new BigDecimal("111.80"), order.getTotal());
    }

    @Test
    public void getOrder_whenEmptyCart() {
        Cart cart = new Cart();
        Order order = cart.checkout();

        assertEquals(new BigDecimal("0"), order.getSalesTaxes());
        assertEquals(new BigDecimal("0"), order.getTotal());
    }
}
