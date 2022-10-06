package controller;

import model.model.human.customer.Customer;
import model.service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")

public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "searchByName":
                searchByName(request, response);
                break;
            case "edit":
                edit(request, response);
                break;

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeID"));
        String address = request.getParameter("address");

        Customer editCustomer = new Customer(id, name, dateOfBirth, gender,
                idCard, phoneNumber, email, customerTypeId, address);

        customerService.editCustomer(editCustomer);

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");

        List<Customer> foundedCustomerList = customerService.searchByName(searchName);
        String mess = "Founded!";
        if (foundedCustomerList.size() == 0) {
            mess = "Not founded!";
        }
        request.setAttribute("mess",mess);
        request.setAttribute("customerList", customerService.searchByName(searchName));

        try {
            request.getRequestDispatcher("/view/customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeID"));
        String address = request.getParameter("address");

        Customer newCustomer = new Customer(id, name, dateOfBirth, gender,
                idCard, phoneNumber, email, customerTypeId, address);
        String mess = "Adding new customer successfully!";
        if (!customerService.addCustomer(newCustomer)) {
            mess = "Adding new customer failed";
        }

        request.setAttribute("customerList", customerService.getCustomerList());
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showCustomer(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String idDelete = request.getParameter("id");
        String mess = "Delete Successfully!";

        if(!customerService.deleteCustomer(idDelete)) {
            mess = "Delete Failed!";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("customerList", customerService.getCustomerList());

        try {
            request.getRequestDispatcher("/view/customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.getCustomerList());
        try {
            request.getRequestDispatcher("view/customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
