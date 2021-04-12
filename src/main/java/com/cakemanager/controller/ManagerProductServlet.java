package com.cakemanager.controller;

import com.cakemanager.model.Account;
import com.cakemanager.model.Cart;
import com.cakemanager.model.Category;
import com.cakemanager.model.Product;
import com.cakemanager.service.LoginService;
import com.cakemanager.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagerProductServlet", value = "/ManagerProductServlet")
public class ManagerProductServlet extends HttpServlet {
    private ProductService productService;
    private LoginService loginService;

    public void init() {
        loginService = new LoginService();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        if(!account.isRoll()){
            response.sendRedirect("/index");
        }
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "delete":
                deleteProduct(request,response);
                break;
            case "viewPageCreateOrEdit":
                viewPageCreateOrEdit(request,response);
                break;
            default:
                viewAllProduct(request, response);
                break;
        }

    }

    private void viewAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listPro = this.productService.get20Product();
        RequestDispatcher dispatcher;
        request.setAttribute("listPro", listPro);
        dispatcher = request.getRequestDispatcher("managerProduct.jsp");
        dispatcher.forward(request, response);

    }
    private void viewPageCreateOrEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = this.productService.getAllCategory();
        request.setAttribute("listCategory",listCategory);
        System.out.println(listCategory);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editInsertPro.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        RequestDispatcher dispatcher = null;
        if(this.productService.deleteProductSV(productId)){
            System.out.println("aaa");
            response.sendRedirect("/ManagerProductServlet");
        }else{
            dispatcher = request.getRequestDispatcher("/ManagerProductServlet?message=error");
        }
    }
    //Test trên local
    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float unitPrice = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String thumbnail = request.getParameter("thumbnail");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int PRODUCTID_FAKE = 0;
        Category CATEGORY_FAKE = new Category(0,"");
        Product product = new Product(PRODUCTID_FAKE,name,unitPrice,quantity,description,thumbnail,categoryId,CATEGORY_FAKE);
        this.productService.insertProduct(product);
        response.sendRedirect("/ManagerProductServlet");
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
            case "create":
                insertProduct(request,response);
                break;
            case "edit":
                break;
            case "delete":
                deleteProduct(request,response);
            default:
                viewAllProduct(request, response);
                break;
        }
    }
}
