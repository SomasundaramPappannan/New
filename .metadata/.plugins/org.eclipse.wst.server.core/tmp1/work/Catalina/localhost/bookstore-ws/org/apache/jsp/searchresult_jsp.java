/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-08-24 20:11:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.my.bookstore.core.Book;
import java.util.List;

public final class searchresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table cellspacing=\"30\" border=\"0\">\r\n");
      out.write("<form action=\"searchBooks\" method=\"POST\">\r\n");
      out.write("<tr><td colspan=\"2\"><input type=\"text\" name=\"searchTerm\"/></td><td><input type=\"submit\" value=\"Search\"/></td></tr>\r\n");
      out.write("\r\n");
      out.write("\t");

		if (request.getAttribute("SEARCHRESULT") != null) {
			List list = (List) request.getAttribute("SEARCHRESULT");
			int size = list.size();
			int column = 3;
			int row = size / column;
			int remaining = size % column;
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		int pos = 0;
			for (int i = 0; i < row; i++) {
	
      out.write("<tr>\r\n");
      out.write("\t\t");

			for (int j = 0; j < column; j++) {
						Book book = (Book) list.get(pos);
						String bookName = book.getTitle();
		
      out.write("\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<img src=\"images/book.jpg\" /><br>\r\n");
      out.write("\t\t\t\t");
      out.print(bookName);
      out.write("<br>\r\n");
      out.write("\t\t\t\t<a href=\"showbookdetails?bookId=");
      out.print(book.getBookId());
      out.write("\">Buy Now</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t");

			pos = pos + 1;
					}
		
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

		}
	
      out.write("<tr>\r\n");
      out.write("\t\t");

			for (int k = pos; k < size; k++) {

					Book book = (Book) list.get(pos);
					String bookName = book.getTitle();
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t<img src=\"images/book.jpg\" /><br>\r\n");
      out.write("\t\t\t\t");
      out.print(bookName);
      out.write("<br>\r\n");
      out.write("\t\t\t\t<a href=\"showbookdetails?bookId=");
      out.print(book.getBookId());
      out.write("\">Buy Now</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</table>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
