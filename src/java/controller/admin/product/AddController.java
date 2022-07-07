/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Category;
import model.Product;
import model.ProductDetails;

/**
 *
 * @author Tuan Phong
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/admin/add_product"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AddController extends HttpServlet {

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
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categorys = categoryDAO.listAllCategory();
        ArrayList<ProductDetails> products = (ArrayList<ProductDetails>) productDAO.getAllProductDetailses();
        request.setAttribute("products", products);
        request.setAttribute("categorys", categorys);
        request.getRequestDispatcher("../view/admin/AddProduct.jsp").forward(request, response);
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

        ProductDetails productDetails = new ProductDetails();
        //set details
        productDetails.setName(request.getParameter("productname"));
        LocalDateTime createAt = LocalDateTime.now();
        productDetails.setCreateAt(createAt);
        productDetails.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        productDetails.setPrice(Double.parseDouble(request.getParameter("price")));
        productDetails.setTitle(request.getParameter("title"));
        productDetails.setDescription(request.getParameter("description"));
//        //set image
        Part filePart = request.getPart("formFile");
        response.getWriter().print(request.getServletContext().getRealPath("").replace('\\', '/')+'/' + "images");
//        String fileName = createAt + "_" + filePart.getSubmittedFileName();
//        for (Part part : request.getParts()) {
//            part.write("../avartar" + fileName);
//        }
//        productDetails.setImage("/avartar/" + fileName);
        //set cateid
        String[] categoryIds = request.getParameterValues("category");
        ArrayList<Category> categorys = new ArrayList<>();
        for (String categoryid : categoryIds) {
            categorys.add(new Category(Integer.parseInt(categoryid), null));
        }
        productDetails.setCategorys(categorys);

        response.getWriter().print(productDetails);

//        response.sendRedirect("../productdetail?id=1");
    }

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
               clientFileName = clientFileName.replace("\\", "/");
               int i = clientFileName.lastIndexOf('/');
               // file1.zip
               // file2.zip
               return clientFileName.substring(i + 1);
           }
       }
       return null;
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
