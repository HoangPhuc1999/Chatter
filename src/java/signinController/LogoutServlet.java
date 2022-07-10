/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoang Phuc
 */
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        Cookie y = new Cookie("user", "");
        y.setMaxAge(0);
        response.addCookie(y);
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("user_account", null);
        request.getSession().setAttribute("user_address", null);
        request.getSession().setAttribute("reviewmessage", null);
        request.getRequestDispatcher("/Index.jsp").include(request, response);
    }

}
