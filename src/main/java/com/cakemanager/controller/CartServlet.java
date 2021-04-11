package com.cakemanager.controller;

import com.cakemanager.model.Cart;
import com.cakemanager.model.Product;
import com.cakemanager.service.CartService;
import com.cakemanager.service.IndexService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartService cartService;

    public void init() {
        cartService = new CartService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action) {
                case "edit":
//                showEditForm(request, response);
                    break;
                case "delete":
                    deleteCart(request, response);
                    break;
                case "view":
                    //viewProduct(request, response);
                    break;
                case "insert":
                    insertCart(request, response);
                    break;
                default:
                    listCarts(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCarts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int userId = Integer.parseInt(request.getParameter("id"));

        List<Cart> carts = this.cartService.selectCart(1);

        request.setAttribute("carts", carts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shoping-cart.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String productName = request.getParameter("productName");
        Float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        Float priceTotal = Float.parseFloat(request.getParameter("priceTotal"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String thumbnail = request.getParameter("thumbnail");

        Cart newCart = new Cart(productName, productPrice, priceTotal, thumbnail, userId);

        cartService.insertCart(newCart);

        listCarts(request, response);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("shoping-cart.jsp");
//        dispatcher.forward(request, response);
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        cartService.deleteCart(cartId);

//        List<Cart> listCart = cartService.selectCart(1);
//        request.setAttribute("listCart", listCart);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
//        dispatcher.forward(request, response);
        listCarts(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
