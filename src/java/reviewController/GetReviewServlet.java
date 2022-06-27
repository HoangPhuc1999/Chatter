/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviewController;

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
import model.Review;

/**
 *
 * @author Hoang Phuc
 */
public class GetReviewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        ReviewDAO dao = new ReviewDAO();
        List<Review> list = new ArrayList<>();
        list = dao.getAllReviews();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRating());
        }
        request.setAttribute("reviewlist", list);
        request.getRequestDispatcher("Review.jsp").forward(request, response);
    }

}
