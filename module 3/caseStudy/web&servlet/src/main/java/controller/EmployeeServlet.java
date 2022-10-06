package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
//            case "add":
//                showAddingPage(request, response);
//                break;
//            case "delete":
//                showDeletePage(request, response);
//                break;
//            case "edit":
//                showEditPage(request, response);
//                break;
//            case "find":
//                showFindForm(request, response);
//                break;
//            case "view":
//                showDetailsPage(request, response);
//                break;
            default:
                showEmployee(request, response);
        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/employee/employee.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

