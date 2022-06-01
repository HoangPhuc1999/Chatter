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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserAccount;

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
        UserAccount x = null;
        UserDAO t;

        t = new UserDAO();
        x = t.getUser(xName, xPass);

        if (x == null) {
            System.out.println("Error hahahaha");
        } else {
            System.out.println("Success");
        }

    }

}
