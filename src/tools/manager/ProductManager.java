package tools.manager;

import entity.Product;
import java.util.Scanner;

public class ProductManager {

    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("--- Создание книги ---");
        System.out.print("Введите название товара: ");
        product.setName(scanner.nextLine());
        System.out.print("Введите цену товара: ");
        product.setPrice(scanner.nextInt());
        System.out.print("Введите код товара: ");
        product.setProductNumber(scanner.nextInt());
        System.out.println("Добавлен товар: " + product.getName());
        return product;
    }

    public void addProductToArray(Product product, Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null){
                products[i] = product;
                break;
            }
        }
    }

    public void printListProducts(Product[] books) {
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                System.out.println(i+1+". " + books[i].toString());
            }
        }
    }

}