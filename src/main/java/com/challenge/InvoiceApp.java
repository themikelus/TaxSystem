package com.challenge;

import com.challenge.shopping.Cart;
import com.challenge.shopping.Order;
import com.challenge.shopping.products.Product;
import com.challenge.shopping.products.ShelveItem;
import com.challenge.shopping.taxes.BasicSalesTax;
import com.challenge.shopping.taxes.ImportDutySalesTax;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class InvoiceApp
{
    public static void main( String[] args )
    {
        InvoiceApp invoice = new InvoiceApp();
        invoice.invoice1();
        invoice.invoice2();
        invoice.invoice3();
    }

    private void invoice1() {
        Product book = new ShelveItem("book", new BigDecimal("12.49"));

        Product musicCd = new ShelveItem("music CD", new BigDecimal("14.99"));
        musicCd.addTaxBehavior(new BasicSalesTax());

        Product chocolateBar = new ShelveItem("chocolate bar", new BigDecimal("0.85"));

        Cart cart = new Cart();
        cart.addProduct(book);
        cart.addProduct(musicCd);
        cart.addProduct(chocolateBar);
        Order order = cart.checkout();

        printOrder(order);
    }

    private void invoice2() {
        Product importedChocolates = new ShelveItem("imported box of chocolates", new BigDecimal("10.00"));
        importedChocolates.addTaxBehavior(new ImportDutySalesTax());

        Product importedWater = new ShelveItem("imported bottle of perfume", new BigDecimal("47.50"));
        importedWater.addTaxBehavior(new BasicSalesTax());
        importedWater.addTaxBehavior(new ImportDutySalesTax());

        Cart cart = new Cart();
        cart.addProduct(importedChocolates);
        cart.addProduct(importedWater);
        Order order = cart.checkout();

        printOrder(order);
    }

    private void invoice3() {
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

        printOrder(order);

    }

    private void printOrder(Order order) {
        for(Product product: order.getProducts()) {
            System.out.println(
                    String.format("%s:  %.2f", product.getName(), product.getBasePrice()));
        }
        System.out.println(
                String.format("Sales taxes %.2f", order.getSalesTaxes()));
        System.out.println(
                String.format("Total %.2f\n\n", order.getTotal()));

    }
}
