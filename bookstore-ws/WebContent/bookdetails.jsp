
<%@page import="com.my.bookstore.core.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%

if(request.getAttribute("SHOWBOOKDETAIL")!=null){
Book book = (Book)request.getAttribute("SHOWBOOKDETAIL");
%>
<form action="addtocart" method="POST">
<table>
<tr><td><img src="images/book.jpg"/></td><td><table>
<tr><td colspan="2"><h1><%=book.getTitle()%></h1></td></tr>
<tr><td>Author</td><td><%=book.getAuthor()%></td></tr>
<tr><td>Price</td><td><%=book.getPrice()%></td></tr>
<tr><td>Available stock</td><td><%=book.getAvailableStock()%></td></tr>
<tr><td>Quantity</td><td><input type="text" name="quantity"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Add to Cart"/></td></tr>
</table></td></tr>
</table>
<input type="hidden" name="bookId" value="<%=book.getBookId()%>"/>
<form>
<%
}
%>