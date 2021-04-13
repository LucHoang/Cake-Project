package com.cakemanager.controller;

import com.cakemanager.model.Category;
import com.cakemanager.model.Product;
import com.cakemanager.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textSearch = request.getParameter("text");
        List<Product> list = productService.searchByName(textSearch);
        List<Category> listCategory = productService.selectAllCategory();

        request.setAttribute("listP", list);
        request.setAttribute("listC", listCategory);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}