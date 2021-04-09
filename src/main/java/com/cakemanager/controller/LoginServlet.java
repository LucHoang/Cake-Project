package com.cakemanager.controller;

import com.cakemanager.service.IndexService;
import com.cakemanager.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    public void init() {
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cakeUI/index.jsp");
        if(!this.loginService.checkLogin(userName,passWord)){
            request.getRequestDispatcher("cakeUI/login.jsp");
        }
        requestDispatcher.forward(request,response);
    }

}
