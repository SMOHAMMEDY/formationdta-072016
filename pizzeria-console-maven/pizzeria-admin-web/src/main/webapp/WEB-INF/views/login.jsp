<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link href="../dist/css/bootstrap.min.css" rel="stylesheet">
	</head>





	<body>
	
		<form class="form-horizontal" method="post">
		<fieldset>
		
		<!-- Form Name -->
		<legend>LOGIN</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="mail">e-Mail</label>  
		  <div class="col-md-5">
		  <input id="mail" name="mail" type="text" placeholder="Saisir votre mail"  value="" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Password input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="passwordinput">Password</label>
		  <div class="col-md-5">
		    <input id="pwd" name="pwd" type="password" placeholder="saisir votre mot de passe" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="validation"></label>
		  <div class="col-md-4">
		    <button id="validation" name="validation" class="btn btn-primary">Login</button>
		  </div>
		</div>
		
		</fieldset>
		</form>
	</body>
</html>