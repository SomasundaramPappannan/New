<script type="text/javascript">
function AlertIt() {
var cart =session.getAttribute("CARTSIZE");
		if(cart==0){
		alert('There is no books in cart !. Please add books to purchase!');
	}

}
</script>




<table>

	<tr>
		<td><a href="displaystock">Book Store</a></td>
	</tr>
	
	<%
	if(session.getAttribute("CARTSIZE")==null){
			%>
		
		 <tr>
		<td><a href="showcart">My Cart</a></td>
	</tr>
		<%
	}else{
		int cart = (Integer)session.getAttribute("CARTSIZE");
	
	%>
	
	 <tr>
		<td><a href="showcart">My Cart(<%=cart %>)</a></td>
		
	
	</tr>
	<%
		request.getSession().removeAttribute("CARTSIZE");
	}
	%>

	<td><a href="logout">Logout</a></td>
	 
</table>
