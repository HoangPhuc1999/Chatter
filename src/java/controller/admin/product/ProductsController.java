/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.product;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ProductsSevrlet", urlPatterns = {"/admin/products"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class ProductsController extends HttpServlet {

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
        ProductDAO productDAO = new ProductDAO();
        ArrayList<ProductDetails> productDetailses = (ArrayList<ProductDetails>) productDAO.getAllProductDetailses(0,"");
//        response.getWriter().print();
        request.setAttribute("productDetailses", productDetailses);
        request.getRequestDispatcher("../view/admin/Products.jsp").forward(request, response);
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
                        response.getWriter().println('a');

//        String action = request.getParameter("action");
//
//        switch (action) {
//            case "add_product":
//                addProduct(request, response);
//                break;
//            case "delete_product":
//                deleteProduct(request, response);
//                break;
//            case "update_product":
//                updateProduct(request, response);
//                break;
//            default:
//                throw new AssertionError();
//        }
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

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductDetails productDetails = new ProductDetails();
        //set details
        productDetails.setName(request.getParameter("productname"));
        LocalDateTime createAt = LocalDateTime.now();
        productDetails.setCreateAt(createAt);
        productDetails.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        productDetails.setPrice(Double.parseDouble(request.getParameter("price")));
        productDetails.setTitle(request.getParameter("title"));
        productDetails.setDescription(request.getParameter("description"));
        //set image
        Part filePart = request.getPart("formFile");
        String fileName = createAt + "_" + filePart.getSubmittedFileName();

        for (Part part : request.getParts()) {
            part.write("../avartar" + fileName);
        }
        productDetails.setImage("/avartar/" + fileName);
        //set cateid
        String[] categoryIds = request.getParameterValues("category");
        ArrayList<Category> categorys = new ArrayList<>();
        for (String categoryid : categoryIds) {
            categorys.add(new Category(Integer.parseInt(categoryid), null));
        }
        productDetails.setCategorys(categorys);
        
        response.getWriter().print(productDetails);

//        response.sendRedirect("../ProductDetails.jsp");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
