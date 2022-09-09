package view;

import controllers.MainController;

import java.text.ParseException;

public class MainView {
    public static void main(String[] args) throws ParseException {
        MainController controller = new MainController();
        controller.MainMenu();
    }
}
