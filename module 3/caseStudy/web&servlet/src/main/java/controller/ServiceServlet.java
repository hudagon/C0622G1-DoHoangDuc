package controller;

import model.model.facility.Facility;
import model.service.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    FacilityService facilityService = new FacilityService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addNewService(request, response);
                break;
            case "searchByName":
                searchByName(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("idDelete"));

        String mess = "Delete Successfully!";

        if (!facilityService.deleteFacility(deleteId)) {
            mess = "Delete Failed";
        }
        ;

        request.setAttribute("mess", mess);
        request.setAttribute("serviceList", facilityService.getFacilityList());

        try {
            request.getRequestDispatcher("view/service/service.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        Facility editFacility;
        if (facilityTypeId == 1) {
            String standardRoom = request.getParameter("standardRoom");
            String desriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            double poolArea = Double.parseDouble(request.getParameter("poolArea"));
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            String facilityFree = request.getParameter("facilityFree");
            editFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId,
                    standardRoom, desriptionOtherConvenience, poolArea,
                    numberOfFloors, facilityFree);
        } else if (facilityTypeId == 2) {
            String facilityFree = request.getParameter("facilityFree");
            editFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId,
                    facilityFree, facilityTypeId);
        } else {
            String standardRoom = request.getParameter("standardRoom");
            String desriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            editFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId,
                    standardRoom, desriptionOtherConvenience,
                    numberOfFloors, facilityTypeId);
        }
        String mess = "Edit Successfully!";

        if (!facilityService.editFacility(editFacility)) {
            mess = "Edit Failed!";
        }
        ;

        request.setAttribute("mess", mess);
        request.setAttribute("serviceList", facilityService.getFacilityList());

        try {
            request.getRequestDispatcher("view/service/service.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");

        List<Facility> foundedFacilityList = facilityService.searchByName(searchName);
        String mess = "Founded!";
        if (foundedFacilityList.size() == 0) {
            mess = "Not founded!";
        }
        request.setAttribute("mess", mess);
        request.setAttribute("serviceList", facilityService.searchByName(searchName));

        try {
            request.getRequestDispatcher("/view/service/service.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void addNewService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));

        Facility newFacility;
        if (facilityTypeId == 1) {
            String standardRoom = request.getParameter("standardRoom");
            String desriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            double poolArea = Double.parseDouble(request.getParameter("poolArea"));
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            String facilityFree = request.getParameter("facilityFree");
            newFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId,
                    standardRoom, desriptionOtherConvenience, poolArea,
                    numberOfFloors, facilityFree);
        } else if (facilityTypeId == 2) {
            String facilityFree = request.getParameter("facilityFree");
            newFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId,
                    facilityFree, facilityTypeId);
        } else {
            String standardRoom = request.getParameter("standardRoom");
            String desriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            newFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId,
                    standardRoom, desriptionOtherConvenience,
                    numberOfFloors, facilityTypeId);
        }


        String mess = "Adding successfully!";

        if (!facilityService.addNewFacility(newFacility)) {
            mess = "Adding failed!";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("serviceList", facilityService.getFacilityList());

        try {
            request.getRequestDispatcher("view/service/service.jsp").forward(request, response);
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
            default:
                showService(request, response);
        }
    }

    private void showService(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceList", facilityService.getFacilityList());
        try {
            request.getRequestDispatcher("view/service/service.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
