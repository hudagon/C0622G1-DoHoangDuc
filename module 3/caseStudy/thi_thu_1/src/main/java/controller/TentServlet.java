package controller;

import model.model.Tent;
import model.service.impl.TentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TentServlet", value = "/tent")
public class TentServlet extends HttpServlet {
    TentService tentService = new TentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addNewTent(request, response);
                break;
            case "delete":
                deleteTent(request, response);
                break;
            case "search":
                searchTent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "reallyEdit":
                reallyEdit(request, response);
                break;
        }
    }

    private void reallyEdit(HttpServletRequest request, HttpServletResponse response) {
        int idTent = Integer.parseInt(request.getParameter("idTent"));
        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        int payMethodId = Integer.parseInt(request.getParameter("payMethodId"));
        String description = request.getParameter("description");

        Tent editTent = new Tent(idTent,tenantName,phoneNumber,startDate,
                payMethodId,description);

        String mess = "Edit Successfully!";
        if(!tentService.editTent(editTent)) {
            mess = "Edit failed!";
        };

        request.setAttribute("mess",mess);
        request.setAttribute("tentList", tentService.getListTent());
        request.setAttribute("payMethodList", tentService.getListPayMethod());

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void searchTent(HttpServletRequest request, HttpServletResponse response) {
        String tentIdSearch = (request.getParameter("tentIdSearch"));
        String tenantNameSearch = request.getParameter("tenantNameSearch");
        String phoneNumberSearch = request.getParameter("phoneNumberSearch");


       List<Tent> foundTent = tentService.search(tentIdSearch, tenantNameSearch, phoneNumberSearch);
       request.setAttribute("tentList", foundTent);
       request.setAttribute("payMethodList", tentService.getListPayMethod());

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteTent(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));

        String mess = "Delete Successfully!";
        if (tentService.findById(idDelete) == null) {
            mess = "Can't found tent";
        } else {
            tentService.deleteTent(idDelete);
        }


        request.setAttribute("mess", mess);
        request.setAttribute("tentList", tentService.getListTent());
        request.setAttribute("listCheck", 0);

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void addNewTent(HttpServletRequest request, HttpServletResponse response) {
        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        int payMethodId = Integer.parseInt(request.getParameter("payMethodId"));
        String description = request.getParameter("description");

        Tent newTent = new Tent(tenantName, phoneNumber, startDate, payMethodId, description);
        String mess = "Adding Successfully!";
        if (!tentService.addNewTent(newTent)) {
            mess = "Adding Failure!";
        }
        ;

        request.setAttribute("mess", mess);
        request.setAttribute("tentList", tentService.getListTent());
        request.setAttribute("listCheck", 0);
        request.setAttribute("payMethodList", tentService.getListPayMethod());

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
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
            case "add":
                showAddingForm(request, response);
                break;
            default:
                showTentList(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String idTent = request.getParameter("idTenant");
        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        String payMethodId = request.getParameter("payMethodId");
        String description = request.getParameter("description");

        Tent editTent = new Tent(Integer.parseInt(idTent),tenantName,phoneNumber,startDate,
                Integer.parseInt(payMethodId),description);

        request.setAttribute("editTent",editTent);

        try {
            request.getRequestDispatcher("view/tent/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showAddingForm(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("listCheck", -1);

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showTentList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("tentList", tentService.getListTent());
        request.setAttribute("payMethodList", tentService.getListPayMethod());

        try {
            request.getRequestDispatcher("view/tent/tent.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}