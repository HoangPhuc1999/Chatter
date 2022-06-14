/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeController;

import DAO.DAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author khuat
 */
public class ProfileControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        request.setCharacterEncoding("UTF-8");
        //get user from session and display info to profile.jsp
<<<<<<< HEAD
        HttpSession session = request.getSession();
        User a = (User) request.getSession().getAttribute("user");
        UserDAO dao = new UserDAO();
//                request.setAttribute("avapath", a.getAvatar());
//                request.setAttribute("user", a.);
//                request.setAttribute("pass", pass);
//                request.setAttribute("home", );
//                request.setAttribute("district", district);
//                request.setAttribute("city", city);
//                request.setAttribute("first", firstname);
//                request.setAttribute("last", lastname);
//                request.setAttribute("gender", gender);
//                request.setAttribute("phone", phone);
//                request.setAttribute("email", email);
            getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);     
=======
        //User a = session.getAttribute("user");
>>>>>>> ec4a164aa5dfedf16760e1c58d413d14d9b48564
        
        
        
    }

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
        String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayProfile(request, response);
		}
                else if(action.equalsIgnoreCase("edit")) {
			doGet_EditProfile(request, response);
		}
		}
        //edit profile from profile.jsp
        protected void doGet_EditProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
                HttpSession session = request.getSession();
                User a = (User) request.getSession().getAttribute("user");
                
		session.setAttribute("acc", a);
                request.setAttribute("message", "Profile updated!");
		request.getRequestDispatcher("Profile.jsp").forward(request,response);
        }
        
        //dispaly profile to profile.jsp
        protected void doGet_DisplayProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
                HttpSession session = request.getSession();
                User a = (User) request.getSession().getAttribute("user");
                
		session.setAttribute("acc", a);
                request.setAttribute("message", "Profile updated!");
		response.sendRedirect("Profile.jsp");
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
        processRequest(request, response);
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
