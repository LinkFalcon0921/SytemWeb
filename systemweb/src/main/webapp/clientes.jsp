
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="/WEB-INF/desing/links/Links.jsp"></jsp:include>
<title>Control clientes</title>
</head>

<body>
<!--Navbar-->
<jsp:include page="/WEB-INF/desing/links/nabvarDefault.jsp"></jsp:include>
	
	<!-- Users -->
	<jsp:include page="/WEB-INF/info-get/clients.jsp"></jsp:include>
	
<!-- Modal cliente -->
<jsp:include page="/WEB-INF/info-get/AddClients.jsp"></jsp:include>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/desing/links/footerDefault.jsp"></jsp:include>
	
<!-- Scripts -->
<jsp:include page="WEB-INF/desing/links/scripsBoost.jsp"></jsp:include>

</body>
</html>