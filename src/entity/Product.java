package entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Integer price;
    private Integer productNumber;

    public Product() {
    }

    public Product(String name, Integer price, Integer productNumber) {
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return ""
                + "Товар: " + name
                + ", цена: " + price
                + ", номер товара: " + productNumber;
    }
}