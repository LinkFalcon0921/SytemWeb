<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
	<c:forEach var="cliente" items="${listCl}">
		<li><label> ${cliente.name} ${cliente.lname} </label></li>
	</c:forEach>
</ul>