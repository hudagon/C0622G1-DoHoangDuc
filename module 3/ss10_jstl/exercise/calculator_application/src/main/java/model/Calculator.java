package model;

public class Calculator {
    private float firstOperand;
    private float secondOperand;
    private int operator;

    public Calculator() {
    }

    public Calculator(float firstOperand, float secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public float calculate(float firstOperand, float secondOperand,int operator) {
        float result = 0;
        switch (operator) {
            case 1:
                result = (firstOperand + secondOperand);
                break;
            case 2:
                result = (firstOperand - secondOperand);
                break;
            case 3:
                result = (firstOperand * secondOperand);
                break;
            case 4:
                try {
                    result = (firstOperand / secondOperand);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Divided by zero!");
                }
        }
        return result;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
