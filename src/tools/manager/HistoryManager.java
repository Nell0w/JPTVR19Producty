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
        System.out.println("--- Список читателей ---");
        customerManager.printListCustomers(customers);
        System.out.print("Выберите номер читателя: ");
        int readerNumber = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers[readerNumber-1];
        history.setReader(customer);
        productManager.printListProducts(products);
        this.addingBalance(history);
        System.out.println("--- Список товаров ---");
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
        System.out.println("------------------------------");
        System.out.println("Ваш баланс: " + balance + " евро");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("Желаете ли Вы пополнить баланс?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.println("Выберите способ пополнения баланса: ");
            System.out.println("1. Банковским переводом");
            System.out.println("2. СМС пополнение");
            int userBalanceWay = scanner.nextInt();
            System.out.print("Введите сумму, которую желаете пополнить: ");
            int userBalance = scanner.nextInt();
            switch (userBalanceWay) {
                case 1:
                    System.out.println("Реквизиты оплаты: ");
                    System.out.println("Получатель: LapShop OÜ");
                    System.out.println("Номер счёта: EE89754389135454967313");
                    System.out.println("Пояснение: PAYMENT #5235254");

                case 2:
                    System.out.println("Для пополнения баланса на " + userBalance + " евро:");
                    System.out.println("Отправтье СМС сообщение на номер: +37254736578");
                    System.out.println("с текстом: 52364");
            }

            balance = balance + userBalance;
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("Ваш баланс: " + balance + " евро");
            System.out.println("------------------------------");
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
        System.out.printf("Товар \"%s\" куплен пользователем %s %s%n"
                ,history.getProduct().getName()
                ,history.getCustomer().getFirstname()
                ,history.getCustomer().getLastname()
        );

    }

    public void printListReadProducts(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null && histories[i].getArrivalTime()==null){
                System.out.printf("%d. Товар \"%s\" куплен пользователем %s %s%n"
                        ,i+1
                        ,histories[i].getProduct().getName()
                        ,histories[i].getCustomer().getFirstname()
                        ,histories[i].getCustomer().getLastname()
                );
            }
        }
    }
}
