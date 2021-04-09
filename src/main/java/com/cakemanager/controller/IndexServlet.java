package com.cakemanager.controller;

import com.cakemanager.service.IndexService;
import com.cakemanager.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IndexService indexService;

    public void init() {
        indexService = new IndexService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
                //viewProduct(request, response);
                break;
            case "find":
                //findByName(request, response);
                break;
            case "showProductCategory":
                try {
                    showProductCategory(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<Product> products = this.indexService.selectAllUsers();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cakeUI/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));

        Product existingUser = indexService.selectUser(categoryId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cakeUI/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
}
