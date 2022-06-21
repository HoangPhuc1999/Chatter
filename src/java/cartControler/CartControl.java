/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartControler;

import DAO.CartDAO;
import DAO.DAO;
import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.User;

/**
 *
 * @author khuat
 */
@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
                        else if(action.equalsIgnoreCase("add")){
                            doGet_Add(request, response);
                        }
                        else if(action.equalsIgnoreCase("discard")){
                            doGet_Discard(request, response);
                        }
		}
	}
        
        //trigger when user click on cart icon after signing in 
        //get user 's id and load previous cart items 
        //author: an 
        //20/6
	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                CartDAO cdao = new CartDAO();
                User a = (User) request.getSession().getAttribute("user");
                ArrayList<Item> cart = (ArrayList<Item>) cdao.getCart(a.getUsers_id()); //get cart of user in database
                a.setCart(cart);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}
        
        //xoa item do trong cart 
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                User a = (User) request.getSession().getAttribute("user");
                if(a==null){
                    request.setAttribute("thongbao","Ban chua dang nhap!");
                    response.sendRedirect("home");
                }   
		ArrayList<Item> cart = (ArrayList<Item>) a.getCart();
		int index = isExisting(request.getParameter("id"), cart);
		//cart.remove(index);
                cart.get(index).setQuantity(0); //dat so luong do dinh xoa = 0
                updateCartInDatabase(a); //update in db
                a.setCart(cart);
                doGet_DisplayCart(request, response);
		//response.sendRedirect("Cart.jsp");
	}
        
        
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		//HttpSession session = request.getSession();
                User a = (User) request.getSession().getAttribute("user");
                //neu chua dang nhap ma an mua hang
                if(a==null){
                    request.setAttribute("message","Ban chua dang nhap!");
                    request.getRequestDispatcher("Login.jsp").forward(request,response);
                }
                
                //neu day la mon hang dau tien -> tao cart va gan vao acc session
		if (a.getCart() == null) {
			ArrayList<Item> cart = new ArrayList<Item>();
			cart.add(new Item(dao.getProductById(request.getParameter("id")), 1));
			a.setCart(cart);
                        
                        //update cart in database
                        CartDAO cdao = new CartDAO();
                        cdao.updateCartInDB(a.getUsers_id(),
                                Integer.parseInt(request.getParameter("id")),
                                Integer.parseInt(request.getParameter("quantity")));
                        
                        request.setAttribute("message","Items added to cart! ");
		}
                else {
                    ArrayList<Item> cart = (ArrayList<Item>) a.getCart();
                    int index = isExisting(request.getParameter("id"), cart);
                    int ammount = Integer.parseInt(request.getParameter("quantity"));
                    //neu product chua co trong cart -> tao item ms +1 
                    if (index == -1) {                                                   
                        cart.add(new Item(dao.getProductById(request.getParameter("id")), 1));
                    }
                        //neu product da co tromg cart --> + amount 
                    else{
			int quantity = cart.get(index).getQuantity() + ammount;
			cart.get(index).setQuantity(quantity);
                    }
                    a.setCart(cart);
                    updateCartInDatabase(a); //update in db
                    request.setAttribute("message","Items added to cart! ");
                    //added to cart alert to home      
		}
		request.getRequestDispatcher("home").forward(request,response);
	}

        //kiem tra item id da co trong gio hang chua 
	private int isExisting(String id, ArrayList<Item> cart) {
            int Id = Integer.parseInt(id);
		for (int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId()==Id) {
				return i;
			}
		}
		return -1;
	}
        //tang so luong item trong cart 
        protected void doGet_Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                User a = (User) request.getSession().getAttribute("user");
		ArrayList<Item> cart = (ArrayList<Item>) a.getCart();
		int index = isExisting(request.getParameter("id"), cart);
		int quantity = cart.get(index).getQuantity() + 1;
		cart.get(index).setQuantity(quantity);
                a.setCart(cart);
                updateCartInDatabase(a); //update in db
		response.sendRedirect("Cart.jsp");
        }
        //giam so item trong cart
        protected void doGet_Discard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                User a = (User) request.getSession().getAttribute("user");
		ArrayList<Item> cart = (ArrayList<Item>) a.getCart();
		int index = isExisting(request.getParameter("id"), cart);
                if(cart.get(index).getQuantity()>=2){    // neu dg = 1 => bo
                    int quantity = cart.get(index).getQuantity() - 1;
                    cart.get(index).setQuantity(quantity);
                }
                else{
                        cart.remove(index);
                }
                a.setCart(cart);
                updateCartInDatabase(a); //update in db
		response.sendRedirect("Cart.jsp");
        }
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
        
        //update database sau khi update(them.sua,xoa) 
        protected void updateCartInDatabase(User a){
	    ArrayList<Item> cart = (ArrayList<Item>) a.getCart();
            CartDAO cdao = new CartDAO();
            for(Item item : cart){
                cdao.updateCartInDB(a.getUsers_id(),
                                item.getProduct().getId(),
                                item.getQuantity());
                        
            }
            
	}
        
}

