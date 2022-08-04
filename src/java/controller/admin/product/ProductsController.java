/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin.product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import java.io.IOException;
import java.sql.Timestamp;
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
@WebServlet(name = "ProductsSevrlet", urlPatterns = {"/admin/products","/admin/view_products","/admin/list_products"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
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
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categorys = categoryDAO.listAllCategory();
        String[] searchValue = new String[6];
        int type;
        int page = 1;
        int pagesize = 10;
        
        if (request.getParameter("searchtype") == null) {
            type = 0;
        } else {
            type = Integer.parseInt(request.getParameter("searchtype"));
            request.setAttribute("searchtype", type);
        }
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        if (request.getParameter("pagesize") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        switch (type) {
            case 0:
                searchValue[0] = request.getParameter("productid");
                request.setAttribute("productid", searchValue[0]);
//                log("\n\n\n??????????"+searchValue[0].trim().length());
                break;
            case 1:
                searchValue[0] = request.getParameter("productname");
                request.setAttribute("productname", searchValue[0]);
                break;
            case 2:
                searchValue[0] = request.getParameter("minprice");
                searchValue[1] = request.getParameter("maxprice");
                request.setAttribute("minprice", searchValue[0]);
                request.setAttribute("maxprice", searchValue[1]);
                searchValue[0] = searchValue[0].length() == 0 ? "0" : searchValue[0];
                searchValue[1] = searchValue[1].length() == 0 ? "65536" : searchValue[1];
                break;
            case 3:
                searchValue[0] = request.getParameter("startdate") + " 00:00:00.000";
                searchValue[1] = request.getParameter("enddate") + " 23:59:59.999";
                request.setAttribute("startdate", request.getParameter("startdate"));
                request.setAttribute("enddate", request.getParameter("enddate"));
                searchValue[0] = searchValue[0].length() == 0 ? "2018-06-07" : searchValue[0];
                searchValue[1] = searchValue[1].length() == 0 ? "2218-06-07" : searchValue[1];
                break;
            default:
                break;
        }

        ArrayList<ProductDetails> productDetailses = (ArrayList<ProductDetails>) productDAO.getAllProductDetailsesWithCategorys(type, searchValue, (page - 1) * pagesize, pagesize);

        int numberentries = productDAO.countproducts(type, searchValue);
        request.setAttribute("categorys", categorys);
        request.setAttribute("productDetailses", productDetailses);
        request.setAttribute("numberentries", numberentries);
        request.setAttribute("totalpage", (numberentries-1) / pagesize + 1);
        request.setAttribute("currentpage", page);
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
