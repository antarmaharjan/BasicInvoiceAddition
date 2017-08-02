package com.nmerris.basicinvoiceaddition;


public class Product {
    private double itemCode;
    private String description;
    private double price;

    public double getItemCode() {
        return itemCode;
    }

    public void setItemCode(double itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
