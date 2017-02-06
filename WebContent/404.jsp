<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Erro 404 - Not Found</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="css/app.css" rel="stylesheet">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="well">
				<h1>ERRO 404 - PÁGINA NÃO EXISTE</h1>
				<p>Você não está perdido, está?</p>
			</div>
		</div>
		<c:import url="rodape.jsp" />
	</div>
	
</body>
</html>