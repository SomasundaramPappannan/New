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
 * Servlet implementation class BSWebShowCartServlet
 */
@WebServlet("/showcart")
public class BSWebShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BSWebShowCartServlet() {
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
		BookStoreRestClient restClient = new BookStoreRestClient();
		try {
			HttpSession session = request.getSession();
			List list = restClient.showCart();
			session.setAttribute("CARTLIST",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("PAGENAME","showcart.jsp");
		RequestDispatcher dispatcher  = request.getRequestDispatcher("template.jsp");
		dispatcher.forward(request, response);
	}

}
