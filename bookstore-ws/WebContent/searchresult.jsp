<%@page import="com.my.bookstore.core.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<table cellspacing="30" border="0">
<form action="searchBooks" method="POST">
<tr><td colspan="2"><input type="text" name="searchTerm"/></td><td><input type="submit" value="Search"/></td></tr>

	<%
		if (request.getAttribute("SEARCHRESULT") != null) {
			List list = (List) request.getAttribute("SEARCHRESULT");
			int size = list.size();
			int column = 3;
			int row = size / column;
			int remaining = size % column;
	%>

	<%
		int pos = 0;
			for (int i = 0; i < row; i++) {
	%><tr>
		<%
			for (int j = 0; j < column; j++) {
						Book book = (Book) list.get(pos);
						String bookName = book.getTitle();
		%>
		<td>
			<div>
				
				<img src="images/book.jpg" /><br>
				<%=bookName%><br>
				<a href="showbookdetails?bookId=<%=book.getBookId()%>">Buy Now</a>
			</div>
		</td>
		<%
			pos = pos + 1;
					}
		%>
	</tr>
	<%
		}
	%><tr>
		<%
			for (int k = pos; k < size; k++) {

					Book book = (Book) list.get(pos);
					String bookName = book.getTitle();
		%>

		<td>
			<div>
				 
				<img src="images/book.jpg" /><br>
				<%=bookName%><br>
				<a href="showbookdetails?bookId=<%=book.getBookId()%>">Buy Now</a>
			</div>
		</td>
		<%
			}
		%>
	</tr>
	<%
		}
	%>
</form>
</table>
