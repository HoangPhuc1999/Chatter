/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.DAO;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.servlet.ServletException;
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
public class signupcontrol extends HttpServlet {

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
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        
        
        String endswith = "";
        String startwith = "";
        String fileName = "";
        
        Part myloc = request.getPart("avatar");//getting the image part of the image uploaded

        String filePath = myloc.toString();//converting the part gotten from the uploaded image to string
        fileName = myloc.getSubmittedFileName();//getting the submitted file name
        Long byteSize = myloc.getSize();//getting the size of the image 
        String formfield = myloc.getName();//getting the image name 
        
        if(!"".equals(fileName)){

                if (filePath.startsWith("File name=" + fileName + ", StoreLocation=")) {
                    startwith = "File name=" + fileName + ", StoreLocation=";
                }//checking if the part starts with the particular sequence just above

                if (filePath.endsWith(", size=" + byteSize + "bytes, isFormField=false, FieldName=" + formfield + "")) {

                    endswith = ", size=" + byteSize + "bytes, isFormField=false, FieldName=" + formfield + "";
                }  //checking if the part ends with the particular sequence just above   

                int start = startwith.length();//getting the length of the starting part of the of the Path
                int end = endswith.length();//getting the length of the ending part of the of the Path
                int total = filePath.length();//getting the length of the total file path

                int offset = total - end;//getting the offsetted part of the ending part of the Path

                String image = myloc.toString();

                String imges = image;

                String filePathcopy = imges.substring(start, offset).replaceAll("\\\\", "/");//used to get the part specifically the Path of the image only and format the windows path type(\) to the java accepted part(/ or \\).


                String targetPath = "C:/Users/HP/Documents/NetBeansProjects/Image Upload/web/Images/" + fileName + "";//getting the target file path which will be inserted into the database //change accordingly

                Path source = Paths.get(filePathcopy);//the source of the image
                Path target = Paths.get(targetPath);//the Path where the image will be moved to.//change accordingly

                try {
                    Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
                } catch (IOException e) {
                  out.print("<p style='text-align:center;color:red'>Error in Uploading your image to the target Folder</p>");
                }//used to copy the image to the target folder

        if(!pass.equals(re_pass)){
            response.sendRedirect("Login.jsp");
        }else{
            DAO dao = new DAO();
            UserAccount a = dao.checkAccountExist(user); //kiem tra username trong database 
            if(a == null){
                //dc signup
               // dao.singup(user); //them user
                response.sendRedirect("home");
            }else{
                //day ve trang sign up
                response.sendRedirect("signup.jsp");
            }
        }
        //sign up
    }
    }
}

   
