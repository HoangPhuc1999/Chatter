/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.DAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserAccount;

/**
 *
 * @author khuat
 */
@WebServlet(name = "resetpasswordcontrol", urlPatterns = {"/resetpassword"})
public class ResetPasswordControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        UserDAO dao = new UserDAO();
        UserAccount user = dao.checkAccountExist(username);
        if(user == null){
                //send error message\
                String message="oops, this username does not exsit";
                request.setAttribute("message", message);
                 request.setAttribute("warning", message);

                
            }else{
                if(dao.checkAccountAndEmailMatch(username,email)){
                    dao.resetPassword(username);
                    String message="password reset completed, new password is 12345";
                     request.setAttribute("warning", message);
                }
                else{
                    String message="username and email does not match";
                     request.setAttribute("message", "Reset password fail");
                     request.setAttribute("warning", message);
                }
            }
        
        request.getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
            
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
