/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.user;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserAccount;
import model.UserDetails;

/**
 *
 * @author Tuan Phong
 */
@WebServlet(name = "UserController", urlPatterns = {"/admin/users", "/admin/list_users"})

public class UsersController extends HttpServlet {

    public static final String GENDER = "male";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String[] searchValue = new String[6];
        int type = 0;
        int page = 1;
        int pagesize = 20;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        if (request.getParameter("pagesize") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int numberentries = userDAO.countproducts(type, searchValue);

        ArrayList<UserDetails> userDetails = (ArrayList<UserDetails>) userDAO.getAllUserDetailsesWithOrders(0, null, 0, 10);

        request.setAttribute("numberentries", numberentries);
        request.setAttribute("totalpage", numberentries / pagesize + 1);
        request.setAttribute("currentpage", page);
        request.setAttribute("users", userDetails);
        request.getRequestDispatcher("../view/admin/Users.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add_user":
                addUser(request, response);
                break;
            case "delete_user":
                deleteUser(request, response);
                break;
            case "update_user":
                updateUser(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        int userid = userDAO.addUser(new User(
                request.getParameter("firstname"),
                request.getParameter("lastname"),
                request.getParameter("phonenumber"),
                request.getParameter("email"),
                request.getParameter("role"),
                GENDER));
        log("\nInsert to users_account: " + String.valueOf(userDAO.addAccount(
                new UserAccount(userid,
                        request.getParameter("username"),
                        request.getParameter("password"))
        )));

        response.sendRedirect("user?user_id=" + userid);
    }

    protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("username");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
