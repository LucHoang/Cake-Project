package com.cakemanager.controller;

import com.cakemanager.model.Category;
import com.cakemanager.model.Product;
import com.cakemanager.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product p = productService.getProductByCateId(productId);
        List<Category> listCategory = productService.selectAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listC", listCategory);
        request.getRequestDispatcher("shop-details.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
