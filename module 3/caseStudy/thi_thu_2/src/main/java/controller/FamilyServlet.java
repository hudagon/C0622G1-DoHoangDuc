package controller;

import model.service.impl.FamilyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FamilyServlet", value = "/family")
public class FamilyServlet extends HttpServlet {
    FamilyService familyService = new FamilyService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            default:
                showFamilyList(request, response);

        }
    }

    private void showFamilyList(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("familyList",familyService.getListFamily());

        try {
            request.getRequestDispatcher("view/family/family.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
