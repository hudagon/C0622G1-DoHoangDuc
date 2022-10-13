package controller;

import model.model.Product;
import model.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String productNameSearch = (request.getParameter("productNameSearch"));
        String priceSearch = request.getParameter("priceSearch");

        String mess = "Found!";

        if (productService.searchProduct(productNameSearch, priceSearch).size() == 0) {
            mess = "Not Found!";
        }

        List<Product> foundProduct = productService.searchProduct(productNameSearch, priceSearch);

        request.setAttribute("productList", foundProduct);
        request.setAttribute("categoryList", productService.getListCategory());
        request.setAttribute("mess", mess);

        try {
            request.getRequestDispatcher("view/product/product.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {

        String productName = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("price"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Product newProduct = new Product(productName, price, quantity, color, description, category_id);


        String mess = "Adding Successfully!";

        if (!productService.addProduct(newProduct)) {
            mess = "Adding Failed!";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("productList", productService.getListProduct());
        request.setAttribute("categoryList", productService.getListCategory());

        try {
            request.getRequestDispatcher("view/product/product.jsp").forward(request, response);
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
                showProductList(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));

        String mess = "Delete Successfully!";

        if (!productService.deleteProduct(idDelete)) {
            mess = "Delete Failed!";
        }
        ;


        request.setAttribute("mess", mess);
        request.setAttribute("productList", productService.getListProduct());
        request.setAttribute("categoryList", productService.getListCategory());
        try {
            request.getRequestDispatcher("view/product/product.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("productList", productService.getListProduct());
        request.setAttribute("categoryList", productService.getListCategory());

        try {
            request.getRequestDispatcher("view/product/product.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
}
