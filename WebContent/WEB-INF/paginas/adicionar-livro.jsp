<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="verity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Contatos</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="css/app.css" rel="stylesheet">
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<script src="js/jquery-3.1.1.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<div class="container">
		<div class="row padding-bottom">
			<div class="col-md-6">
				<div class="well">
					<h1 class="title">${title}</h1>
					<p>Informe os dados abaixo:</p>
					<form action="${action}" method="POST">
						<input type="hidden" name="id" value="${livro.id}">
						<div class="form-group">
							<label for="titulo">Título:</label>
							
							<input class="form-control" type="text" id="titulo" name="titulo" value="${livro.titulo}" required="required" />
						</div>
						<div class="form-group">
							<label for="qtdPaginas">Quantidade de páginas:</label>
							<input class="form-control" type="text" id="qtdPaginas" name="qtdPaginas" value="${livro.qtdPaginas}" />
						</div>
						<div class="form-group">
							<label for="dataPublicacao">Data publicação:</label>
							<input id="dataPublicacao" name="dataPublicacao" type="text" class="form-control" value="<fmt:formatDate value='${livro.dataPublicacao.time}' pattern='dd/MM/yyyy' />">
						</div>
						<button type="reset" class="btn btn-danger">
							<span class="glyphicon glyphicon-remove"></span>
							Limpar
						</button>
						<button type="submit" class="btn btn-success">
							<span class="glyphicon glyphicon-floppy-disk"></span>
							Gravar
						</button>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<c:import url="rodape.jsp" />
			</div>
		</div>
		<script>
			$("#dataPublicacao").datepicker({
				dateFormat: "dd/mm/yy",
		        changeYear: true,
		        changeMonth: true,
		        yearRange: "1940:*",
		        dayNamesMin: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
		        monthNamesShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]
			});
			$("#${id}").mask("99/99/9999");
		</script>
	</div>
</body>
</html>