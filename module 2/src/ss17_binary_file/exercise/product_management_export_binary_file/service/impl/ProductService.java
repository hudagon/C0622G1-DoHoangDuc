package ss17_binary_file.exercise.product_management_export_binary_file.service.impl;

import ss17_binary_file.exercise.product_management_export_binary_file.model.Product;
import ss17_binary_file.exercise.product_management_export_binary_file.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static final String path = "src\\ss17_binary_file\\exercise\\product_management_export_binary_file\\data\\data.dat";
    Scanner scanner = new Scanner(System.in);

    List<Product> productList = new ArrayList<>();

    public static void writeFile(String path, List<Product> productList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(productList);

        objectOutputStream.close();
    }

    public static List<Product> readFile(String path) throws IOException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>(0);
        FileInputStream fileInputStream = new FileInputStream(path);

        if (fileInputStream.available() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            productList = (List<Product>) objectInputStream.readObject();

            objectInputStream.close();

            return productList;
        }
        return productList;
    }

    @Override
    public void add() throws IOException, ClassNotFoundException {
        productList = readFile(path);
        boolean temp = true;
        while (temp) {
            System.out.println("1. Add new\n" +
                    "2. Exit");
            System.out.print("Input here: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Input product's code: ");
                    String code = scanner.nextLine();
                    System.out.print("Input product's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Input product's manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Input product's price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input description: ");
                    String description = scanner.nextLine();

                    productList.add(new Product(code, name, manufacturer, price, description));
                    System.out.println("Add successfully!");
                    break;
                case 2:
                    temp = false;
                    break;
            }
        }
        writeFile(path, productList);
    }

    @Override
    public void display() throws IOException, ClassNotFoundException {
        productList = readFile(path);
        if (productList.size() == 0) {
            System.out.println("No information to display!");
        } else {
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public void search() throws IOException, ClassNotFoundException {
        productList = readFile(path);
        System.out.print("Input product's code here: ");
        String productCodeSearch = scanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().contains(productCodeSearch)) {
                System.out.println(productList.get(i).toString());
            }
        }
    }
}
