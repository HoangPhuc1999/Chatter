/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartControler;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khuat
 */
@WebServlet(name = "CouponControl", urlPatterns = {"/coupon"})
public class CouponControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CouponControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CouponControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xCode = request.getParameter("couponCode");
        ProductDAO dao = new ProductDAO();
        int Discount = dao.couponCheck(xCode);
        if(Discount==0){
            request.setAttribute("message", "Wrong discount code or expired");
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Success");
            request.setAttribute("Discount", Discount);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
        
        
        
        
    }


}
