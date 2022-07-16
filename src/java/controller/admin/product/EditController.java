/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import java.io.File;
import java.io.IOException;
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
import model.ProductDetails;

/**
 *
 * @author Tuan Phong
 */
@WebServlet(name = "EditProductController", urlPatterns = {"/admin/edit_product"})
@MultipartConfig(
        location = "F:\\FPTU\\FPT class\\Semester 5\\SWP391\\Week 8\\Code\\Chatter\\web\\images",
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EditController extends HttpServlet {
ProductDAO productDAO = new ProductDAO();
    /**
     * *
     * //
     * <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     * /**
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
        
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categorys = categoryDAO.listAllCategory();
        String [] str = {request.getParameter("productid")};
        ArrayList<ProductDetails> productDetailses = (ArrayList<ProductDetails>) productDAO.getAllProductDetailsesWithCategorys(0,str ,0,1);
        request.setAttribute("product", productDetailses.get(0));
        request.setAttribute("categorys", categorys);
        request.getRequestDispatcher("../view/admin/EditProduct.jsp").forward(request, response);
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
        productDetails.setId(Integer.parseInt(request.getParameter("productid")));
        productDetails.setName(request.getParameter("productname"));
        LocalDateTime modifyAt = LocalDateTime.now();
        productDetails.setModifyAt(modifyAt);
        productDetails.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        productDetails.setPrice(Double.parseDouble(request.getParameter("price")));
        productDetails.setTitle(request.getParameter("title"));
        productDetails.setDescription(request.getParameter("description"));

        //set cateid
        String[] categoryIds = request.getParameterValues("category");
        ArrayList<Category> categorys = new ArrayList<>();
        for (String categoryid : categoryIds) {
            categorys.add(new Category(Integer.parseInt(categoryid), null));
        }
        productDetails.setCategorys(categorys);


        //set image
//        String fullPath = request.getServletContext().getRealPath("").replace("\\", File.separator) + File.separator + "images";
//        response.getWriter().println("Write attachment to file: " + fullPath);
        String fileName;
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);

            if (fileName != null && fileName.length() > 0) {
                String extension = fileName.substring(fileName.lastIndexOf('.'));
                String filePath = File.separator + "product" + productDetails.getId() + '_' + productDetails.getName() + extension;

                // Ghi vào file.
                part.write(filePath);
                productDetails.setImageUrl("images/" + "product" + productDetails.getId() + '_' + productDetails.getName() + extension);
            }
        }
        
        log(productDAO.updateProductDetails(productDetails));
//        try {
//            TimeUnit.MILLISECONDS.sleep(500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        response.sendRedirect("../productdetail?id=" + productDetails.getId());
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
                clientFileName = clientFileName.replace("\\", File.separator);
                int i = clientFileName.lastIndexOf(File.separator);
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
