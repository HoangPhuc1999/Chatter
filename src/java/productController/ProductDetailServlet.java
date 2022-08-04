/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productController;

import DAO.ProductDAO;
import DAO.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.ProductDetails;
import model.Review;
import model.User;

/**
 *
 * @author Hoang Phuc
 */
public class ProductDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        ProductDAO d = new ProductDAO();
        
        String [] strings = new String[6];
        strings[0] = id;
        ProductDetails pd = ((ProductDetails) d.getAllProductDetailses(0, strings, 0, 1).get(0));
        Product x = pd;
        
        ReviewDAO dao = new ReviewDAO();
        List<Review> list = new ArrayList<>();
        list = dao.getAllReviewsFromId(id);
        double totalRating = 0;
        double averageRating = 0;
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                totalRating = totalRating + Double.parseDouble(list.get(i).getRating());
                String name = dao.getReviewAuthor(list.get(i).getUserId());
                list.get(i).setName(name);
            }
            averageRating = (totalRating / list.size());
        }
        
        request.setAttribute("product_detail", x);
        request.setAttribute("reviewproductlist", list);
        request.setAttribute("ratting", averageRating);
        response.getWriter().println(x);
        request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("user");

    }

}
