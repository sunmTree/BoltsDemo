package com.sunm.model.strategy;

/**
 * Created by Administrator on 2017/9/30.
 */

public class MovieTicket {
    private double price;
    private Discount discount;

    public double getPrice() {
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
