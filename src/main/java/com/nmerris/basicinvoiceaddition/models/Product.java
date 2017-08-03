package com.nmerris.basicinvoiceaddition.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// this is a MODEL
// below: needed for db stuff
@Entity
public class Product {
    // itemCode is my id, which will be the database key

    // validate with annotations
    @NotNull
    @Min(1) // characters do not count here
    @Id // this tell the db what to use as it's key/id
    private double itemCode;

    @Size(min=5, max=30)
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
