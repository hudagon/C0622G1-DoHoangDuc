package views;

import controllers.FuramaController;

public class MainView {
    public static void main(String[] args) {
        FuramaController controller = new FuramaController();
        controller.displayMainMenu();
    }
}
