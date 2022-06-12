/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productController;

import DAO.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductImage;

/**
 *
 * @author Hoang Phuc
 */
public class ProductDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
//        String id = request.getParameter("id");
        String id = "1";
        ProductDao d = new ProductDao();
        ProductImage pd = d.getProductImageById(id);
        Product x = d.getProductById(id);
        String imageUrl = pd.getImageUrl();
        x.setImage(imageUrl);
        System.out.println(x.getImage());
        request.setAttribute("product_detail", x);
        request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
    }

}
