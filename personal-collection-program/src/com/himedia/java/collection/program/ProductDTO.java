package com.himedia.java.collection.program;

import java.time.LocalDate;

public class ProductDTO {


    String name;
    String brand;
    String type;
    int number;
    LocalDate expirationDate;

    public ProductDTO() {}

    public ProductDTO(String name, int number, LocalDate expirationDate){
        this.name = name;
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public ProductDTO(String name, String brand, String type, int number, LocalDate expirationDate) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
