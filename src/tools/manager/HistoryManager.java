package tools.manager;

import entity.Product;
import entity.History;
import entity.Customer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HistoryManager {
    private Scanner scanner = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private ProductManager productManager = new ProductManager();
    public History takeOnProduct(Product[] products, Customer[] customers) {
        History history = new History();
        System.out.println("|| Список пользователей ||");
        customerManager.printListCustomers(customers);
        System.out.print("Выберите номер пользователя: ");
        int readerNumber = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers[readerNumber-1];
        history.setReader(customer);
        productManager.printListProducts(products);
        this.addingBalance(history);
        System.out.println("|| Список товаров ||");
        productManager.printListProducts(products);
        System.out.print("Выберите номер товара: ");
        int bookNumber;
        bookNumber = scanner.nextInt();
        scanner.nextLine();
        Product product = products[bookNumber-1];
        history.setBook(product);
        Calendar calendar = new GregorianCalendar();
        history.setPurchaseDate(calendar.getTime());
        this.printHistory(history);
        return history;
    }

    public void addingBalance(History history) {
        int balance = 0;
        System.out.println();
        System.out.println("______________________________");
        System.out.println("Ваш баланс: " + balance + " Евро");
        System.out.println("______________________________");
        System.out.println();
        System.out.println("Желаете ли пополнить баланс?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.println("Каким способом хотите пополнить баланс?");
            System.out.println("1. Банковским переводом");
            int userBalanceWay = scanner.nextInt();
            System.out.print("Введите сумму, которую желаете пополнить: ");
            int userBalance = scanner.nextInt();
            switch (userBalanceWay) {
                case 1:
                    System.out.println("Реквизиты оплаты: ");
                    System.out.println("Получатель: Market OÜ");
                    System.out.println("Номер счёта: EE198484999489634797984");
                    System.out.println("Пояснение: PAYMENT #5235254");
            }

            balance = balance + userBalance;
            System.out.println();
            System.out.println("______________________________");
            System.out.println("Ваш баланс: " + balance + " Евро");
            System.out.println("______________________________");
        }
    }

    public void arrivedProducts(History[] histories) {
        System.out.println("--- Список прибываших товаров ---");
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && histories[i].getArrivalTime() == null){
                System.out.printf("%d. Товар \"%s\" прибыл %s %s%n"
                        ,i+1
                        ,histories[i].getProduct().getName()
                        ,histories[i].getCustomer().getFirstname()
                        ,histories[i].getCustomer().getLastname()
                );
            }
        }
    }

    public void addHistoryToArray(History history, History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if (histories[i] == null) {
                histories[i] = history;
                break;
            }
        }
    }

    private void printHistory(History history) {
        System.out.printf("Товар \"%s\" куплен покупателем %s %s%n"
                ,history.getProduct().getName()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );

    }

    public void printListReadProducts(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && histories[i].getArrivalTime()==null){
                System.out.printf("%d. Товар \"%s\" куплен покупателем %s %s%n"
                        ,i+1
                        ,histories[i].getProduct().getName()
                        ,histories[i].getCustomer().getFirstname()
                        ,histories[i].getCustomer().getLastname()
                );
            }
        }
    }
}
