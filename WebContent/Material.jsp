<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.model.Material" %>
<%@ page import="br.com.model.GroupMaterial" %>
<%@ page import="br.com.dao.MaterialDAO" %>
<%@ page import="br.com.dao.GroupMaterialDAO" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Venda de Produtos</title>
	</head>
	
	<body>
<%  

String titulo = "<h3>Company Test</h3>";

	out.println(titulo);
	out.println("<h3>Venda de Produtos</h3>");	
		
%>
			<table style="border:1px solid black;border-collapse:collapse;">
				<tr>
					<th style="border:1px solid blue;" align=center>ID</th>
					<th style="border:1px solid blue;" align=center>INPUT</th>
					<th style="border:1px solid blue;" align=center>Nome do Produto</th>
					<th style="border:1px solid blue;" align=center>Grupo do Produto</th>
					<th style="border:1px solid blue;" align=center>Preço</th>
					<th style="border:1px solid blue;" align=center>Estoque</th>
				</tr>

<%  
// retrieve your list from the request, with casting 
List<Material> list = (ArrayList<Material>) request.getAttribute("listMaterials");
GroupMaterial groupMaterial = new GroupMaterial();
GroupMaterialDAO groupMaterialDAO = new GroupMaterialDAO();

// print the information about every materials of the list
for(Material material : list) {
	groupMaterial = groupMaterialDAO.getGroupMaterial(material.getIdGroup());
		
	out.println("<tr>");

		out.println("<td align=center>");
		    out.println(material.getId());
	    out.println("</td>");
	    out.println("<td>");
		    out.println(material.getInput());
    	out.println("</td>");
	    out.println("<td>");
		    out.println(material.getName());
	    out.println("</td>");
	    out.println("<td align=center>");
		    out.println(groupMaterial.getName());
	    out.println("</td>");
	    out.println("<td align=center>");
	    	out.println(material.getPrice());
	    out.println("</td>");
	    out.println("<td align=center>");
		    out.println(material.getStockQuantity());
		out.println("</td>");

    out.println("</tr>");
}
%>
				
			</table>
			
			<form method="post" action="SellProduct">
				Selecionar Entrada: <input type="number" name="input" style="border:1px solid blue;" />
            	<input type="submit" value="Vender Produtos" />
            </form>
			
	</body>

</html>