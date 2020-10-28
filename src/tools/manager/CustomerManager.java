package tools.manager;

import entity.Customer;
import java.util.Scanner;

public class CustomerManager {
    public Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("--- Регистрация нового пользователя ---");
        System.out.print("Введите имя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        customer.setPhone(scanner.nextLine());
        System.out.print("Введите адрес: ");
        customer.setAddress(scanner.nextLine());
        this.printCustomer(customer);
        return customer;
    }

    public void addCustomerToArray(Customer customer, Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] == null){
                customers[i] = customer;
                break;
            }
        }
    }

    public void printCustomer(Customer customer) {
        System.out.println("Добавлен читатель: "
                + customer.getFirstname()
                + " "
                + customer.getLastname()
        );
    }

    public void printListCustomers(Customer[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] != null){
                System.out.println(i+1+". " + readers[i].toString());
            }
        }
    }

}