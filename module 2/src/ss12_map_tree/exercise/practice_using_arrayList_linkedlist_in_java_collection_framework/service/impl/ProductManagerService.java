package ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.service.impl;

import ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.model.Product;
import ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.service.IProductManagerService;
import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models._interface.Colorable;

import java.util.*;

public class ProductManagerService implements IProductManagerService {
    Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    static {
        Product product1 = new Product("A", 1, 53.2);
        Product product2 = new Product("B", 2, 73.2);
        Product product3 = new Product("C", 3, 33.2);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    public Product getProductInfo() {
        System.out.print("Input product name: ");
        String name = scanner.nextLine();
        System.out.print("Input produc ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Input product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new Product(name, id, price);
    }

    @Override
    public void add() {
        productList.add(this.getProductInfo());
        System.out.println("Adding successfully!");
    }

    @Override
    public void edit() {
        System.out.print("Input the id of the product you want to process: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        Product productEdit = null;

        for (Product product : productList) {
            if (product.getId() == idDelete) {
                productEdit = product;
            }
        }

        if (productEdit == null) {
            System.out.println("404 not found!");
        } else {
            while (true) {
                int positionEdit = productList.indexOf(productEdit);
                System.out.print("What information of the product you want to change??\n" +
                        "1. Name\n" +
                        "2. Id\n" +
                        "3. Price\n" +
                        "4. Exit\n" +
                        "--> Input here: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.print("New name?: ");
                        String newName = scanner.nextLine();
                        productList.get(positionEdit).setName(newName);
                        System.out.println("Successfully!");
                        break;
                    case 2:
                        System.out.print("New id?: ");
                        int newId = Integer.parseInt(scanner.nextLine());
                        productList.get(positionEdit).setId(newId);
                        System.out.println("Successfully!");
                        break;
                    case 3:
                        System.out.print("New price?: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        productList.get(positionEdit).setPrice(newPrice);
                        System.out.println("Successfully!");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Incorrect input!");
                }
            }
        }
    }

    @Override
    public void delete() {
        System.out.print("Input the id of the product you want to delete: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        Product productDeleted = null;

        for (Product product : productList) {
            if (product.getId() == (idDelete)) {
                productDeleted = product;
            }
        }

        if (productDeleted == null) {
            System.out.println("Can't find the product you want to delete");
        } else {
            System.out.print("Do you really want to delete this product? 1. Yes 2. No: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                productList.remove(productDeleted);
                System.out.println("Product deleted successfully");
            }
        }
    }

    @Override
    public void display() {
        if (productList.size() == 0) {
            System.out.println("Nothing to display");
        }

        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void sort() {
        System.out.print("Do you want to sort in descending order or in ascending order based on price" +
                "? 1. descending 2. ascending: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Collections.sort(productList, new ProductComparator());
                System.out.println("Sort successfully!");
                break;
            case 2:
                Collections.sort(productList, new ProductComparator().reversed());
                System.out.println("Sort successfully!");
                break;
        }
    }

    @Override
    public void search() {
        System.out.print("Input product's name: ");
        String nameDelete = scanner.nextLine();

        for (Product product : productList) {
            if (product.getName().equals(nameDelete)) {
                System.out.println(product.toString());
            }
        }
    }
}
