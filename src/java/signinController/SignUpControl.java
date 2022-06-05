/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.*;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import model.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author khuat
 */
@WebServlet(name = "signupcontrol", urlPatterns = {"/signup"})
@MultipartConfig(
                 fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100,      // 100 MB
                 location="")


public class SignUpControl extends HttpServlet {     
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String re_pass = request.getParameter("repassword");
        String home_address = request.getParameter("home_address");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String avapath="";
        
        //upload image to project 's avatar under web folder and save path to avapath
        try{
            Part part = request.getPart("file");
            part.write(extractFileName(part));
            avapath=(System.getProperty("user.dir")+File.separator+"web\\avatar"+extractFileName(part)).toString();
        
        
            UserDAO dao = new UserDAO();
            UserAccount a = dao.checkAccountExist(user); //kiem tra username trong database 
            if(a == null){
                //dc signup
               UserAccount newAcc = new UserAccount(user,pass);  
               UserAddress newAccAddress = new UserAddress(home_address,district,city);  
               User newUser = new User(firstname,lastname,phone,email,gender,avapath);
               dao.singup(newUser,newAcc,newAccAddress); //them user
                
                
                request.setAttribute("message", "Sign up Success!");
                PrintWriter out = response.getWriter(); 
                out.println("<script type=\"text/javascript\">"); 
                out.println("alert('Sign up Success!');"); 
                out.println("</script>");
                
                
                request.setAttribute("user", user);
                request.setAttribute("pass", pass);
                request.setAttribute("home", home_address);
                request.setAttribute("district", district);
                request.setAttribute("city", city);
                request.setAttribute("firstname", firstname);
                request.setAttribute("lastname", lastname);
                request.setAttribute("gender", gender);
                request.setAttribute("phone", phone);
                request.setAttribute("email", email);
               
                getServletContext().getRequestDispatcher("/SignUpSuccess.jsp").forward(request, response);
                
                }
            else{
                    //day ve trang sign up
                    response.sendRedirect("signup.jsp");
                }
        }
        catch(Exception e){
            request.setAttribute("message", "Sign up failed");
            getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);

            
        }
        }
        //sign up
        
 
    
    private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length() - 1);
      }
    }
    return "";
  }
    
   //upload image to folder 
  public File getFolderUpload() {
    File folderUpload = new File(System.getProperty("user.dir")+File.separator +"web\\avatar");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
    return folderUpload;
  }
}


   
