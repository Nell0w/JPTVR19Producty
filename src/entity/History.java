package entity;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable{
    private Product product;
    private Customer customer;
    private Date purchaseDate;
    private Date arrivalTime;

    public History() {
    }

    public History(Product product, Customer customer, Date purchaseDate, Date arrivalTime) {
        this.product = product;
        this.customer = customer;
        this.purchaseDate = purchaseDate;
        this.arrivalTime = arrivalTime;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setBook(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setReader(Customer customer) {
        this.customer = customer;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Товар: " + product.getName()
                + ", пользователь: " + customer.getLastname()
                + ", дата оплаты: " + purchaseDate
                + ", дата прибытия: " + arrivalTime;
    }
}
