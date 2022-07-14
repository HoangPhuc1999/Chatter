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
                    response.setContentType("text/html;charset=UTF-8");

                User a = (User) request.getSession().getAttribute("user");
                
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                String home_address = request.getParameter("home_address");
                String district = request.getParameter("district");
                String city = request.getParameter("city");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phonenumber");
                String email = request.getParameter("email");
                String gender = request.getParameter("gender");
                String avapath=request.getParameter("avatar");
                
                PrintWriter pr = response.getWriter();
                pr.print("u"+user);
                pr.print(pass);
                pr.print(home_address);
                pr.print(district);
                pr.print(city);
                pr.print(firstname);
                pr.print(lastname);
                pr.print(phone);
                pr.print(email);
                pr.print(gender);
                pr.print(avapath);
                request.getRequestDispatcher("Profile.jsp").include(request, response);

                
                
//                UserDAO udao = new UserDAO();
//                UserAccount editAcc = new UserAccount(user, pass);
//                UserAddress editAccAddress = new UserAddress(home_address, district, city);
//                User editUser = new User(firstname, lastname, phone, email, gender, avapath);
//                
//                udao.editProfile(a.getUsers_id(), editUser, editAcc, editAccAddress);
//                
//                request.setAttribute("message", "Profile updated!");
//		request.getRequestDispatcher("Profile.jsp").forward(request,response);
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
            response.setContentType("text/html;charset=UTF-8");
            User a = (User) request.getSession().getAttribute("user");
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                String home_address = request.getParameter("home_address");
                String district = request.getParameter("district");
                String city = request.getParameter("city");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phonenumber");
                String email = request.getParameter("email");
                String gender = request.getParameter("gender");
                String avapath=request.getParameter("avatar");
                     
                
                try{
                    if(!user.matches("[a-zA-Z0-9 ]*")) throw new IOException("username is invalid");
                    if(!pass.matches("[a-zA-Z0-9]*")) throw new IOException("password is invalid");
                    if(!phone.matches("^(?=\\+?(?:\\d-?){9,13}$)\\+?\\d+(?:-\\d+)*$")) throw new IOException("phone number is invalid");
            
                //edit account profile
                UserDAO udao = new UserDAO();
                UserAccount editAcc = new UserAccount(user, pass);
                UserAddress editAccAddress = new UserAddress(home_address, district, city);
                
                User editUser = new User(firstname, lastname, phone, email, gender, avapath,99);//constructor conflicts
                
                udao.editProfile(a.getUsers_id(), editUser, editAcc, editAccAddress);
                
                //get newly edited profile
                UserAccount newEditAcc = udao.getUserAccountById(a.getUsers_id());
                UserAddress newEditAddress = udao.getUserAddressById(a.getUsers_id());
                User newEditUser = udao.getUserFromId(a.getUsers_id());
                
                //update session account profile
                HttpSession session = request.getSession();
                session.setAttribute("user", newEditUser);
                session.setAttribute("user_address", newEditAddress);
                session.setAttribute("user_account", newEditAcc);

                
                //print to profile screen new values 
                request.setAttribute("avapath", newEditUser.getAvatar());
                request.setAttribute("user", newEditAcc.getUsername());
                request.setAttribute("pass", newEditAcc.getPassword());
                request.setAttribute("home", newEditAddress.getHome_address());
                request.setAttribute("district", newEditAddress.getDistrict());
                request.setAttribute("city", newEditAddress.getCity());
                request.setAttribute("first", newEditUser.getFirstname());
                request.setAttribute("last", newEditUser.getLastname());
                request.setAttribute("gender", newEditUser.getGender());
                request.setAttribute("phone", newEditUser.getPhonenumber());
                request.setAttribute("email", newEditUser.getEmail());
                request.setAttribute("message", "Profile updated!");
                }
                catch (Exception ex) {
                    request.setAttribute("message", "Update profile faield because: " + ex.toString());
                    User u = (User) request.getSession().getAttribute("user");
                    UserAccount acc = (UserAccount) request.getSession().getAttribute("user_account");
                    UserAddress adr = (UserAddress) request.getSession().getAttribute("user_address");
                    request.setAttribute("avapath", u.getAvatar());
                    request.setAttribute("user", acc.getUsername());
                    request.setAttribute("pass", acc.getPassword());
                    request.setAttribute("home", adr.getHome_address());
                    request.setAttribute("district", adr.getDistrict());
                    request.setAttribute("city", adr.getCity());
                    request.setAttribute("first", u.getFirstname());
                    request.setAttribute("last", u.getLastname());
                    request.setAttribute("gender", u.getGender());
                    request.setAttribute("phone", u.getPhonenumber());
                    request.setAttribute("email", u.getEmail());
                }
                finally{
                    request.getRequestDispatcher("Profile.jsp").include(request,response);

                }
                
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
