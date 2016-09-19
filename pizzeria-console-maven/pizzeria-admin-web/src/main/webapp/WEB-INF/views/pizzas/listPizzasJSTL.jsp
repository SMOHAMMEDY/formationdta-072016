<%@page import="java.util.Collection"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


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
 ${listPizzas}
 
 <c:forEach var="pizza"  items="${listePizzas}">
	 <tr>
	 	<td> ${pizza.code}</td>
	 	<td> ${pizza.nom}</td>
	 	<td> ${pizza.prix}</td>
	 	<td> ${pizza.cat}</td>
	 	<td> 
	 		<img alt="${pizza.url}" src="../Images/Pizzas/${pizza.url}" height="100px"/>
	 	</td>
	 	<td> 
 			<form action="<c:url value='/pizzas/edit?code=${pizza.code}'/>">
               <input type="hidden" name="code" value="${pizza.code}"></input>
               <input type="submit" value="Editer" class="btn btn-primary"></input>
          	</form>
		</td>
		<td>
			<form action="<c:url value='/pizzas/supprim?code=${pizza.code}' />" method="post">
               <input type="hidden" name="code" value="${pizza.code}"></input>
               <input type="submit" value="Supprimer" class="btn btn-danger"></input>
          	</form>
	 	</td>
	 </tr> 
  </c:forEach>
 	
	</table>


</body>

</html>