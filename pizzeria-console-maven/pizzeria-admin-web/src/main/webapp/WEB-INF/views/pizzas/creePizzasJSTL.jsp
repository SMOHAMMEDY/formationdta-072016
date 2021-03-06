<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Creer les  Pizzas</title>
	<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>



<h2> Cr�er Pizza</h2>

<body>

<form class="form-horizontal" method="post" action= "<c:url value='/pizzas/ajout'/>">
<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="codeP">Code pizza</label>  
  <div class="col-md-4">
  <input id="codeP" name="codeP" type="text" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nom p">Nom pizza</label>  
  <div class="col-md-4">
  <input id="nomP" name="nomP" type="text"  class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="prix p">Prix pizza</label>  
  <div class="col-md-4">
  <input id="prixP" name="prixP" type="text" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="catP">Select Categorie</label>
  <div class="col-md-4">
    <select id="catP" name="catP" class="form-control input-md" required="">
      <option value="VIANDE">Viande</option>
      <option value="SANS_VIANDE">Sans Viande</option>
      <option value="POISSON">Poisson</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="img">Url image pizza</label>  
  <div class="col-md-4">
  <input id="urlP" name="urlP" type="text" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="valider"></label>
  <div class="col-md-8">
    <button id="valider" name="valider" class="btn btn-success">Ajouter</button>
    
  </div>
</div>

</fieldset>
</form>


</body>


</html>