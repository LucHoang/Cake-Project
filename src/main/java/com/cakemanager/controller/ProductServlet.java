package com.cakemanager.controller;

import com.cakemanager.model.Cart;
import com.cakemanager.model.Product;
import com.cakemanager.service.CartService;
import com.cakemanager.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    public void init() {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
//                case "edit":
////                showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteCart(request, response);
//                    break;
            case "view":
                viewProduct(request, response);
                break;
//            case "insert":
//                try {
//                    insertCart(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//                case "update":
//                    updateCart(request, response);
//                    break;
            default:
                viewProduct(request, response);
                break;
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.selectProductById(productId);
        RequestDispatcher dispatcher;

        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("shop-details.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String productName = request.getParameter("productName");
        Float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        Float priceTotal = Float.parseFloat(request.getParameter("priceTotal"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String thumbnail = request.getParameter("thumbnail");
        int userId = Integer.parseInt(request.getParameter("userId"));

        Cart newCart = new Cart(productName, productPrice, quantity, priceTotal, thumbnail, userId);

        productService.insertCart(newCart);

        CartServlet.listCarts(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "insert":
                try {
                    insertCart(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }
}
