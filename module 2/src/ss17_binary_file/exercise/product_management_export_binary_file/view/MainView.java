package ss17_binary_file.exercise.product_management_export_binary_file.view;

import ss17_binary_file.exercise.product_management_export_binary_file.controller.Main;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main mainController = new Main();
        mainController.menu();
    }
}
