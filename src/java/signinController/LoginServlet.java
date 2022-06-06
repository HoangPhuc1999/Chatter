/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Hoang Phuc
 */
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xName = request.getParameter("name");
        String xPass = request.getParameter("pass");
        String xRem = request.getParameter("remember");
        
        UserAccount x = null;
        UserDAO t;

        t = new UserDAO();
        x = t.getUser(xName, xPass);
        User user = t.getUserFromId(x.getUsers_id());
        
        if (x == null) {
            System.out.println("Error hahahaha");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(10000);
            if(xRem != null) {
            String namePass = xName.trim() + "|" + xPass.trim();
            Cookie y = new Cookie("currUser",namePass);
            y.setMaxAge(60*60*24); // 1 day
            response.addCookie(y);
            System.out.println("Success");
        }

    }

}
}
