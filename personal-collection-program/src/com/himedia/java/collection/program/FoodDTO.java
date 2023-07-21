package com.himedia.java.collection.program;

import java.time.LocalDate;

public class FoodDTO {

    String name;

    String brand;

    String type;

    int number;

    LocalDate purchaseDate;

    LocalDate expirationDate;

    public FoodDTO() {}

    public FoodDTO(String name, String brand, String type, int number, LocalDate purchaseDate, LocalDate expirationDate) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.number = number;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "FoodDTO{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
