package entity;

import java.io.Serializable;

public class Customer implements Serializable{
    private String firstname;
    private String lastname;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String phone, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Имя: " + firstname
                + ", фамилия: " + lastname
                + ", номер телефона: " + phone
                + ", адрес: " + address;
    }
}