package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calculator calculatorNumberOne = new Calculator();
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        int operator = Integer.parseInt(request.getParameter("operator"));
        String operatorString = "";
        switch (operator) {
            case 1:
                operatorString = "+";
                break;
            case 2:
                operatorString = "-";
            case 3:
                operatorString = "*";
            case 4:
                operatorString = "/";
        }
        String resultString = firstOperand + " " + operatorString + " " + secondOperand + " = ";

        float result = calculatorNumberOne.calculate(firstOperand, secondOperand, operator);


        request.setAttribute("resultServlet", result);
        request.setAttribute("resultStringServlet", resultString);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
