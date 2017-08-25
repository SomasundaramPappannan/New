package com.my.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.bookstore.client.BookStoreRestClient;

/**
 * Servlet implementation class SearchBooksServlet
 */
@WebServlet(name = "searchBooks", urlPatterns = { "/searchBooks" })
public class BSWebSearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BSWebSearchBookServlet() {
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
		String searchTerm = request.getParameter("searchTerm");
		
		BookStoreRestClient restClient = new BookStoreRestClient();
		try {
			List bookList = null;
			
			if(!searchTerm.isEmpty()){
                bookList = (List) restClient.search(searchTerm);
			}else{
				bookList = restClient.displayAll();
			}
			request.setAttribute("SEARCHRESULT",bookList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("template.jsp");
		dispatcher.forward(request, response);
	}

}
