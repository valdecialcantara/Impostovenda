<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.model.SellProduct" %>
<%@ page import="br.com.dao.SellProductDAO" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Saída de Produtos com Impostos</title>
	</head>
	
	<body>
<%  

String titulo = "<h3>Company Test</h3>";

	out.println(titulo);
	out.println("<h3>Saída de Produtos com Impostos</h3>");	
		
%>
			<table style="border:1px solid black;border-collapse:collapse;">
				<tr>
					<th style="border:1px solid blue;" align=center>INPUT</th>
					<th style="border:1px solid blue;" align=center>Quantidade</th>
					<th style="border:1px solid blue;" align=center>Nome do Produto</th>
					<th style="border:1px solid blue;" align=center>Preço com Imposto</th>
				</tr>

<%  
// retrieve your list from the request, with casting 
List<SellProduct> list = (ArrayList<SellProduct>) request.getAttribute("listSellProducts");

// print the information about every materials of the list
for(SellProduct sellProduct : list) {
		
	out.println("<tr>");

		out.println("<td align=center>");
		    out.println(sellProduct.getInput());
    	out.println("</td>");
	    out.println("<td>");
	    out.println(sellProduct.getQuantity());
	    out.println("</td>");
	    out.println("<td align=center>");
		    out.println(sellProduct.getName());
	    out.println("</td>");
	    out.println("<td align=center>");
	    	out.println(sellProduct.getPrice()+sellProduct.getDuty());
	    out.println("</td>");

    out.println("</tr>");
}
%>
				
			</table>
			
			<form method="post" action="SellProduct">
				Selecionar Entrada: <input type="number" name="imprimir" style="border:1px solid blue;" />
            	<input type="submit" value="Imprimir" />
            </form>
			
	</body>

</html>