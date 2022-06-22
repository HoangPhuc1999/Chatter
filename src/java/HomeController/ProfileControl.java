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
        //get user from session and display info to profile.jsp

        User a = (User) request.getSession().getAttribute("user");
        UserAccount acc = (UserAccount) request.getSession().getAttribute("user_account");
        UserAddress adr = (UserAddress) request.getSession().getAttribute("user_address");
        UserDAO dao = new UserDAO();
        try{
                request.setAttribute("avapath", a.getAvatar());
                request.setAttribute("user", acc.getUsername());
                request.setAttribute("pass", acc.getPassword());
                request.setAttribute("home", adr.getHome_address());
                request.setAttribute("district", adr.getDistrict());
                request.setAttribute("city", adr.getCity());
                request.setAttribute("first", a.getFirstname());
                request.setAttribute("last", a.getLastname());
                request.setAttribute("gender", a.getGender());
                request.setAttribute("phone", a.getPhonenumber());
                request.setAttribute("email", a.getEmail());
                
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        
        getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);     

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
                HttpSession session = request.getSession();
                User a = (User) request.getSession().getAttribute("user");
                
                request.setAttribute("message", "Profile updated!");
		request.getRequestDispatcher("Profile.jsp").forward(request,response);
        }
        
        //dispaly profile to profile.jsp
        protected void doGet_DisplayProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

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
