package com.chemix.models.BusinessOpportunity;

/**
 * Created by chenshijue on 2017/9/11.
 */
public class Good {
    private String goodName;

    private String quantity;

    private String price;

    public Good() {
    }

    public Good(String goodName, String quantity, String price) {
        this.goodName = goodName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
