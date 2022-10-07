package controller;

import model.model.facility.Facility;
import model.service.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    FacilityService facilityService = new FacilityService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addNewService(request, response);
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
        String standardRoom = request.getParameter("standardRoom");
        String desriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");

        Facility newFacility = new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId,
                standardRoom, desriptionOtherConvenience, poolArea,
                numberOfFloors, facilityFree);

        String mess = "Adding successfully!";

        if(!facilityService.addNewFacility(newFacility)) {
            mess = "Adding failed!";
        }

        request.setAttribute("mess",mess);
        request.setAttribute("serviceList",facilityService.getFacilityList());

        try {
            request.getRequestDispatcher("view/service/service.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
