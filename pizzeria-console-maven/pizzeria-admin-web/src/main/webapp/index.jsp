<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<html>
<body>
<h2>Hello World!</h2>

	<% 
		Date dateDuJour = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String dateFormat =df.format(dateDuJour);
	%>
<h2><%= dateFormat %></h2>
</body>
</html>
