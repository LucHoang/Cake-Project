package com.cakemanager.controller;

import com.cakemanager.model.Cart;
import com.cakemanager.model.OrderDetails;
import com.cakemanager.model.Orders;
import com.cakemanager.service.CheckoutService;
import com.cakemanager.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    private CheckoutService checkoutService;

    public void init() {
        checkoutService = new CheckoutService();
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
//                case "update":
//                    updateCart(request, response);
//                    break;
            default:
                viewCheckout(request, response);
                break;
        }
    }

    private void viewCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        List<Cart> carts = checkoutService.selectCart(userId);

        request.setAttribute("carts", carts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
        dispatcher.forward(request, response);
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
                case "insertOrder":
                    insertOrder(request, response);
                    break;
        }
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("userId"));

        Orders orders = new Orders(userId);

        checkoutService.insertOrder(orders);

        insertOrderDetail(request, response);
    }

    private void insertOrderDetail(HttpServletRequest request, HttpServletResponse response) {
//        int userId = Integer.parseInt(request.getParameter("userId"));
//
//        List<Cart> carts = checkoutService.selectCart(userId);
//        for (int i=0; i<carts.size(); i++) {
//            String productName = carts.get(i).getProductName();
//            int id = carts.get(i).getUserId();
//            float salePrice = carts.get(i).getProductPrice();
//            int quantityProduct = carts.get(i).getQuantity();
//            for (int j=) {
//                if (cart1.getProductId() = cart.getProductId()) {
//                    quantityProduct = quantityProduct + cart1.getQuantity();
//                }
//            }

//            OrderDetails orderDetails = new OrderDetails(productName, id, salePrice, quantityProduct);
//            checkoutService.insertOrderDetail(orderDetails);
//        }
//
//        request.setAttribute("carts", carts);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
//        dispatcher.forward(request, response);
    }
}
