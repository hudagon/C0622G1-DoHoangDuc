package ss8_clean_code_and_refactoring.exercise.refactoring.controller;

import ss8_clean_code_and_refactoring.exercise.refactoring.models.TennisGame;

public class MainController {

    public static void main(String[] args) {
        TennisGame game1 = new TennisGame();
        System.out.println(game1.getScore(3,3));
    }
}
