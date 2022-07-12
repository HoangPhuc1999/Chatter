/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.user;

import DAO.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.UserDetails;

/**
 *
 * @author Tuan Phong
 */
@WebServlet(name = "EditUserDetailsController", urlPatterns = {"/admin/edit_user"})
@MultipartConfig(
        location = "F:\\FPTU\\FPT class\\Semester 5\\SWP391\\Week 8\\Code\\Chatter\\web\\avatar",
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EditController extends HttpServlet {

    UserDAO userDAO = new UserDAO();

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

        UserDetails userDetails = new UserDetails();
        userDetails.setUsers_id(Integer.parseInt(request.getParameter("userid")));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        userDetails.setFirstname(firstName == null || firstName.trim().isEmpty() ? "First name" : firstName);
        userDetails.setLastname(lastName == null || lastName.trim().isEmpty() ? "Last name" : lastName);
        userDetails.setGender(request.getParameter("gender"));
        userDetails.setRole(request.getParameter("role"));
        userDetails.setPhonenumber(request.getParameter("phonenumber"));
        userDetails.setEmail(request.getParameter("email"));

        userDetails.setHome_address(request.getParameter("homeAddress"));
        userDetails.setDistrict(request.getParameter("district"));
        userDetails.setCity(request.getParameter("city"));

        String fileName;
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);

            if (fileName != null && fileName.length() > 0) {
                String extension = fileName.substring(fileName.lastIndexOf('.'));

                String filePath = File.separator + "user" + userDetails.getUsers_id() + '_' + request.getParameter("username") + extension;

                // Ghi vào file.
                part.write(filePath);
                userDetails.setAvatar("avatar/" + "user" + userDetails.getUsers_id() + '_' + request.getParameter("username") + extension);
            }
        }
        log(String.valueOf(userDAO.updateUserDetailsTousers(userDetails)));
        log(String.valueOf(userDAO.updateUserDetailsTousersRole(userDetails)));
        log(String.valueOf(userDAO.updateUserDetailsTousersaddress(userDetails)));

        response.sendRedirect("user?user_id=" + userDetails.getUsers_id());
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

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", File.separator);
                int i = clientFileName.lastIndexOf(File.separator);
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
}
