package ss17_binary_file.exercise.product_management_export_binary_file.controller;

import ss17_binary_file.exercise.product_management_export_binary_file.model.Product;
import ss17_binary_file.exercise.product_management_export_binary_file.service.impl.ProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();

    public void menu() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("----Welcome----");
            System.out.println("1. Add\n" +
                    "2. Display\n" +
                    "3. Search\n" +
                    "4. Exit");
            System.out.print("Input your choice here: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.search();
                    break;
                case 4:
                    return;
            }
        }

    }
}
