package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/tinhtoan")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calculator mayTinhSo1 = new Calculator();
        float soThuNhat = Float.parseFloat(request.getParameter("soThuNhat"));
        float soThuHai = Float.parseFloat(request.getParameter("soThuHai"));
        int toanTu = Integer.parseInt(request.getParameter("toanTu"));

        float ketQua = mayTinhSo1.tinhToan(soThuNhat, soThuHai, toanTu);

        request.setAttribute("ketQua123123123123", ketQua);
        request.getRequestDispatcher("index.jsp").forward(request, response);




        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
