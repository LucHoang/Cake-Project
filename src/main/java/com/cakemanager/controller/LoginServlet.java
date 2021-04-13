package com.cakemanager.controller;

import com.cakemanager.model.Account;
import com.cakemanager.service.IndexService;
import com.cakemanager.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

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
        String email = request.getParameter("email");
        String passWord = request.getParameter("passWord");
        Account account = this.loginService.checkLogin(email,passWord);
        response.sendRedirect("/login.jsp");

        System.out.println(account.getName());
        //        if(false) {
//            HttpSession session = request.getSession();
//            session.setAttribute("account",account);
////            session.setMaxInactiveInterval(10);
//            response.sendRedirect("/index");
//        }

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//        requestDispatcher.forward(request,response);

    }

}
