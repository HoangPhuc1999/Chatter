/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviewController;

import DAO.ReviewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Review;
import model.User;

/**
 *
 * @author Hoang Phuc
 */
public class ReviewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("user");
        String review = request.getParameter("reviewtext");

        String rating = request.getParameter("rate");
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        if (x == null) {

            session.setAttribute("reviewmessage", "You have to sign in to leave a review");
            response.sendRedirect("productdetail");
        } else {

            Review reviewItem = new Review();
            reviewItem.setDate(sqlDate);
            reviewItem.setUserId(x.getUsers_id());
            reviewItem.setTitle("my review");
            reviewItem.setRating(rating);
            reviewItem.setReviewContent(review);
            reviewItem.setReviewImageUrl("urla");
            reviewItem.setProductId(2);
            ReviewDAO reviewDao = new ReviewDAO();
            reviewDao.postReview(reviewItem);
            session.setAttribute("reviewmessage", "Review Submitted");
            response.sendRedirect("productdetail");

        }

    }

}
