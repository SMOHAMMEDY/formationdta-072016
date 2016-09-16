<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Hello JSTL SS
<br><br>
${listPizza}
<br><br>

${unePizza.code}
<br><br>

<c:forEach var="pizzaCourante" items="${listPizza}">
    
    ${pizzaCourante.code} - ${pizzaCourante.nom} <br>

</c:forEach>