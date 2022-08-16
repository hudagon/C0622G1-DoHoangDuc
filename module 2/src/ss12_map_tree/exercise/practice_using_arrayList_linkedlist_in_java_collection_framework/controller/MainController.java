package ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.controller;


import ss12_map_tree.exercise.practice_using_arrayList_linkedlist_in_java_collection_framework.service.impl.ProductManagerService;

import java.util.Scanner;

public class MainController {
    public void menuManagement() {
        Scanner scanner = new Scanner(System.in);
        ProductManagerService productManagerService = new ProductManagerService();

        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Add new");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Search");
            System.out.println("6. Sort");
            System.out.println("7. Ext");
            System.out.print("Input (1->7): ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    productManagerService.add();
                    break;
                case 2:
                    productManagerService.edit();
                    break;
                case 3:
                    productManagerService.delete();
                    break;
                case 4:
                    productManagerService.display();
                    break;
                case 5:
                    productManagerService.search();
                    break;
                case 6:
                    productManagerService.sort();
                    break;
                default:
                    System.out.println("Quý khách nhập không hợp lệ");
            }
        }
    }
}
