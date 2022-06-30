/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcontroller;

import DAO.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author Hoang Phuc
 */
public class BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String name;
        String email;
        String phonenumber;
        String person;
        String dob;

        name = request.getParameter("name").trim();
        email = request.getParameter("email").trim();
        phonenumber = request.getParameter("phonenumber").trim();
        person = request.getParameter("person").trim();
        dob = request.getParameter("dob").trim();
        int xPerson = Integer.parseInt(person);
        java.util.Date xDob = null;
        try {
            xDob = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
        } catch (Exception e) {
        }
        BookDAO u = new BookDAO();
        Book x = new Book();
        x = new Book(1, name, email, phonenumber, xPerson, xDob);
        u.insertBook(x);
        request.getRequestDispatcher("booksuccess.jsp").forward(request, response);
    }

}
