/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Hoang Phuc
 */
public class LoginServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        User x = (User) request.getSession().getAttribute("currUser");

        if (x == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("currUser", x);
            request.getRequestDispatcher("successlogin.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xName = request.getParameter("name");
        String xPass = request.getParameter("pass");
        User x = null;
//        UserDAO t;
//
//        t = new UserDAO();
//        x = t.getUser(xName, xPass);
//
//        if (x == null) {
//            request.getRequestDispatcher("/faillogin.jsp").include(request, response);
//        }  else {
//            request.getSession().setAttribute("currUser", x);
//            request.getRequestDispatcher("/successlogin.jsp").include(request, response);
//        }

    }

}
