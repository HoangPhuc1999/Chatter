/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.DAO;
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
import model.UserAccount;

/**
 *
 * @author khuat
 */
@WebServlet(name = "signupcontrol", urlPatterns = {"/signup"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class signUpControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String home_address = request.getParameter("home_address");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone_number");
        String email = request.getParameter("email");
        
        //recieeve and store avatar image        
         for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
          }       
               
         
        if(!pass.equals(re_pass)){
            response.sendRedirect("Login.jsp");
        }else{
            DAO dao = new DAO();
            UserAccount a = dao.checkAccountExist(user); //kiem tra username trong database 
            if(a == null){
                //dc signup
               UserAccount newAcc = new UserAccount(user,pass);  
               UserAddress newAccAddress newAcc = new UserAddress();  
               dao.singup(); //them user
                
                request.setAttribute("message", "Sign up Success!");
                PrintWriter out = response.getWriter(); 
                out.println("<script type=\"text/javascript\">"); 
                out.println("alert('Sign up Success!');"); 
                out.println("location='Index.jsp';"); 
                out.println("</script>"); 
                getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
                
            }else{
                //day ve trang sign up
                response.sendRedirect("signup.jsp");
            }
        }
        //sign up
        
    }
    
    
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
    File folderUpload = new File(System.getProperty("user.dir")+"\\web\\images");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
    return folderUpload;
  }
}


   
