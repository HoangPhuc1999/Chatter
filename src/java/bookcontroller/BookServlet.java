/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcontroller;

import DAO.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        Date date;
        int xPerson = 0;
        name = request.getParameter("name").trim();
        email = request.getParameter("email").trim();
        phonenumber = request.getParameter("phonenumber").trim();
        dob = request.getParameter("dob");
        person = request.getParameter("person");
        if (person == null || person.isEmpty()) {
            xPerson = 1;
        } else {
            xPerson = Integer.parseInt(person);
        }
        if (dob == null || dob.isEmpty()) {
            long millis = System.currentTimeMillis();
            date = new java.sql.Date(millis);
        } else {
            date = Date.valueOf(dob);
        }
        BookDAO u = new BookDAO();
        if (name == null || email == null || phonenumber == null || person == null || dob == null) {
            request.setAttribute("bookingmessage", "Please enter all information");
            request.getRequestDispatcher("Book.jsp").forward(request, response);
        } else if (!name.matches("[a-zA-Z0-9 ]*") || !phonenumber.matches("[0-9]+")) {
            request.setAttribute("bookingmessage", "Booking Fail, Name or Phone number invalid");
            request.getRequestDispatcher("Book.jsp").forward(request, response);
        } else {
            Book x = new Book();
            x = new Book(1, name, email, phonenumber, xPerson, date);
            u.insertBook(x);
            request.setAttribute("bookingmessage", "Booking Success");
            request.getRequestDispatcher("Book.jsp").forward(request, response);
        }

    }

}
