package com.my.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.bookstore.client.BookStoreRestClient;

/**
 * Servlet implementation class BSWebAddToCartServlet
 */
@WebServlet("/addtocart")
public class BSWebAddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BSWebAddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		String quantity = request.getParameter("quantity");
		BookStoreRestClient restClient = new BookStoreRestClient();
		try {
			List booksInCartList =restClient.addBookToCart(Integer.valueOf(bookId), Integer.valueOf(quantity));
			HttpSession session  =request.getSession();
			session.setAttribute("CARTSIZE",booksInCartList.size());
			request.setAttribute("PAGENAME","messages.jsp");
			request.setAttribute("MESSAGES", "Added  book(s) to the cart successfully");
			RequestDispatcher dispatcher  = request.getRequestDispatcher("template.jsp");
			dispatcher.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
