<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Livros</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="css/app.css" rel="stylesheet">
	<script src="js/jquery-3.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container">
		<div class="row padding-bottom">
			<div class="well">
				<h1 class="title">Livros Verity TI</h1>
				
				<table class="table table-hover table-responsive">
					<thead>
						<tr>
							<th>Titulo</th>
							<th>Qtd. páginas</th>
							<th>Data publicação</th>
							<th>Alterar</th>
							<th>Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="livro" items="${livros}">
							<tr>
								<td>${livro.titulo}</td>
								<td>${livro.qtdPaginas}</td>
								<td><fmt:formatDate value="${livro.dataPublicacao.time}" pattern="dd/MM/yyyy" /></td>
								<td>
									<a href="alterar-livro?id=${livro.id}"><span class="glyphicon glyphicon-pencil"></span></a>
								</td>
								<td>
									<a href="remover-livro?id=${livro.id}"><span class="glyphicon glyphicon-trash text-danger"></span></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<c:if test="${totalRegistros > 0}">
					    		<td colspan="5">Total de registros: ${totalRegistros}</td>
					    	</c:if>
					    	<c:if test="${totalRegistros == 0}">
					    		<td colspan="5">Nenhum livro cadastrado</td>
					    	</c:if>
					    </tr>
					</tfoot>
				</table>
				<a class="btn btn-primary" href="adicionar-livro">
					<span class="glyphicon glyphicon-plus"></span>Adicionar
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<c:import url="rodape.jsp" />
			</div>
		</div>
	</div>
	
	
</body>
</html>