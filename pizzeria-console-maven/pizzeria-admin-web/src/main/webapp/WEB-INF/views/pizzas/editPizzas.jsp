<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Editer les  Pizzas</title>
	<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<% Pizza pizza = (Pizza) request.getAttribute("pizza"); %>

<h2> Editer Pizza</h2>

<body>

<form class="form-horizontal" method="post" action="<%= request.getContextPath() %>/pizzas/edit?code=<%= pizza.getCode()%>">
<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="codeP">Code pizza</label>  
  <div class="col-md-4">
  <input id="codeP" name="codeP" type="text" placeholder="" value="<%= pizza.getCode() %>" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nom p">Nom pizza</label>  
  <div class="col-md-4">
  <input id="nomP" name="nomP" type="text" placeholder="" value="<%= pizza.getNom() %>" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prix p">Prix pizza</label>  
  <div class="col-md-4">
  <input id="prixP" name="prixP" type="text" placeholder="" value="<%= pizza.getPrix() %>" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cat p">Catégorie pizza</label>  
  <div class="col-md-4">
  <input id="catP" name="catP" type="text" placeholder="" value="<%= pizza.getCat() %>" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="img">Url image pizza</label>  
  <div class="col-md-4">
  <input id="urlP" name="urlP" type="text" placeholder="" value="<%=pizza.getUrl()%>" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="valider"></label>
  <div class="col-md-8">
    <button id="valider" name="valider" class="btn btn-success">Valider</button>
    <button id="annuler" name="annuler" class="btn btn-danger">Annuler</button>
  </div>
</div>

</fieldset>
</form>


</body>


</html>