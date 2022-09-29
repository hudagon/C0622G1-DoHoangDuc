package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = new ArrayList<>();

        String ok = "ok";

        request.setAttribute("ok", ok);
        request.getRequestDispatcher("index.jsp").forward(request, response);

        listCustomer.add(new Customer(1, "Mai Văn Hoàn", "1983-08-20", "Hà Nội"));
        listCustomer.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21", "Bắc Giang"));
        listCustomer.add(new Customer(3, "Nguyễn Thái Hòa", "1983-08-22", "Nam Định"));
        listCustomer.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17", "Hà Tây"));
        listCustomer.add(new Customer(5, "Nguyễn  Đình Thi", "1983-08-19", "Hà Nội"));

//        request.setAttribute("customerListServlet", listCustomer);
//        request.getRequestDispatcher("index.jsp").forward(request, response);

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
