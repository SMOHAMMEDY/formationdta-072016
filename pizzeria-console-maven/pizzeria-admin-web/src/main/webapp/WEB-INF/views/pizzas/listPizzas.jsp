<%@page import="java.util.Collection"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Liste des Pizzas</title>
	<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>


<body>
	<h2>**************************<br/>
	    ****** Nos Pizzas *****<br>
	    ************************** </h2>
	
	<table border="1" bordercolor="Green">
		<thead>
			<td>Code</td>
			<td>Nom</td>
			<td>Prix</td>
			<td>Categorie</td>
			<td>Image</td>
			<td>Editer</td>
			<td>Supprimer</td>
		</thead>
		
<!-- récupéré la liste de pizza du get de la servlet listerPizzaController -->

  <% Collection<Pizza> pizzas = (Collection<Pizza>) request.getAttribute("listePizzas");

  for(Pizza pizza: pizzas){
	 %> 
	 <tr>
	 	<td> <%= pizza.getCode() %> </td>
	 	<td> <%= pizza.getNom() %> </td>
	 	<td> <%= pizza.getPrix() %> </td>
	 	<td> <%= pizza.getCat() %> </td>
	 	<td> <%= pizza.getUrl() %> </td>
	 	<td> <div class="form-group">
 				 <a class="btn btn-primary" href="<%= request.getContextPath() %>/pizzas/edit?code=<%= pizza.getCode()%>">Editer</a>
 			</div>
		</td>
		<td><div class="form-group">
    			<a class="btn btn-danger" href="<%= request.getContextPath() %>/pizzas/supprim?code=<%= pizza.getCode()%>">Supprimer</a>
  			</div>
	 	</td>
	 </tr> 
  <%}%>
 	
	</table>


</body>

</html>