/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.*;
import model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author khuat
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100, // 100 MB
        location = "")

public class SignUpServlet extends HttpServlet {
    
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        //String re_pass = request.getParameter("repassword");
        String home_address = request.getParameter("home_address");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String avapath="";
        
//        String saveFolder = System.getProperty("user.dir")+ File.separator +"web"+File.separator +"avatar";
//        //Part part = request.getPart("avatar");
//                
//        File fileUploadDirectory = new File(saveFolder + part.getSubmittedFileName());        
//        if (!fileUploadDirectory.exists()) {
//            fileUploadDirectory.mkdirs();
//        }

//        Part filePart = request.getPart("avatar"); 
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//            InputStream fileContent = filePart.getInputStream();
//            avapath = "avatar"+File.separator + fileName;
//            
//        if (ServletFileUpload.isMultipartContent(request)) {
//
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            factory.setRepository(new File(System.getProperty("user.dir")));
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            String uploadPath = System.getProperty("user.dir")+ File.separator +"web"+File.separator +"avatar";
//            File uploadDir = new File(uploadPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }  
//            try{
//            List<FileItem> formItems = upload.parseRequest(request);
//            if (formItems != null && formItems.size() > 0) {
//                for (FileItem item : formItems) {
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
//                        item.write(storeFile);
//                    }
//            }
//            }
//            
//            }
//            catch(Exception e){
//                
//            }
//        }

//        
//        String savePath = saveFolder + File.separator + fileName;
//        part.write(savePath + File.separator);
//        
// 
//        //upload image to project 's avatar under web folder and save path to avapath
//        try{
//            Part part = request.getPart("file");
//            part.write(extractFileName(part));
//            avapath=("avatar\\"+extractFileName(part)).toString();
//
//            }
//            catch (Exception e) {
//                System.out.println(e.getClass());
//                
//            }
//              

        // Create path components to save the file
        final String path = "avatar";
        final Part filePart = request.getPart("avatar");
        final String fileName = getFileName(filePart);
        avapath = "avatar/" + fileName;//path saveto database 
        
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            if(gender.equals(1)){
                avapath="avatar/male.jpg";
            }
            else{
                avapath="avatar/female.jpg";
            }
        }

           

        try{
            if(!user.matches("[a-zA-Z0-9 ]*")) throw new IOException("username is invalid");
            if(!pass.matches("[a-zA-Z0-9]*")) throw new IOException("password is invalid");
            //if(!pass.matches(re_pass)) throw new IOException("password does not match");
            if(!phone.matches("[0-9]+")) throw new IOException("phone number is invalid");
            
            UserDAO dao = new UserDAO();
            UserAccount a = dao.checkAccountExist(user); //kiem tra username trong database 
            if (a == null) {
                //dc signup
                UserAccount newAcc = new UserAccount(user, pass);
                UserAddress newAccAddress = new UserAddress(home_address, district, city);
                User newUser = new User(firstname, lastname, phone, email, gender, avapath);
                dao.singup(newUser, newAcc, newAccAddress); //them user

                request.setAttribute("message", "Sign up Success!");

                
                request.setAttribute("avapath", avapath);
                request.setAttribute("user", user);
                request.setAttribute("pass", pass);
                request.setAttribute("home", home_address);
                request.setAttribute("district", district);
                request.setAttribute("city", city);
                request.setAttribute("first", firstname);
                request.setAttribute("last", lastname);
                request.setAttribute("gender", gender);
                request.setAttribute("phone", phone);
                request.setAttribute("email", email);

                getServletContext().getRequestDispatcher("/SignUpResult.jsp").forward(request, response);

            } else {
                System.out.println(a.getUsername() + "checking");
                System.out.println(a.getPassword() + "checking");
                System.out.println(a.getUsers_id() + "checking");
                throw new IOException("Username already exist");
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Sign up failed error code: " + ex.toString());
            request.setAttribute("message", "Sign up failed error code: ");
            request.setAttribute("avapath", avapath);
            request.setAttribute("user", user);
            request.setAttribute("pass", pass);
            request.setAttribute("home", home_address);
            request.setAttribute("district", district);
            request.setAttribute("city", city);
            request.setAttribute("first", firstname);
            request.setAttribute("last", lastname);
            request.setAttribute("gender", gender);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);
        }
    }

    //end sign up
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
    return "";
  }
    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
    
   //upload image to folder 
  public File getFolderUpload() {
    File folderUpload = new File(System.getProperty("user.dir")+File.separator +"web\\avatar");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
}
