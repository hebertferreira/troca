<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML>
<html lang="pt-br">
	<head>
		 <meta charset="utf-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1">		 
		<link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" />
		<link type="text/css" href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" />
		<link type="text/css" href="<c:url value="/css/bootstrap-theme.min.css"/>" rel="stylesheet" />		
		<link type="text/css" href="<c:url value="/css/style.css"/>" rel="stylesheet" />
		<script type="text/javascript" src="<c:url value="/js/jquery-2.1.1.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>

		<title>troca</title>
	</head>

	 <body>
		<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container-fluid">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       <li><a href="<c:url value="/produto/acessarProduto" />" > Meus produtos </a></li>
        <li><a href="<c:url value="/proposta/propostasRecebidas" />" > Propostas Recebidas </a></li>
        <li><a href="<c:url value="/produto/pesquisarProduto" />" > Pesquisar Produtos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-align-justify"></span></a>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#">Editar Perfil</a></li>
            <li class="divider"></li>
            <li><a href="#">Sair</a></li>
          </ul>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>	

	<c:if test="${not empty errors}">
		<div class="alert alert-danger" role="alert">
			<c:forEach items="${errors }" var="error">
				<strong>${error.category }</strong> - ${error.message } <br>
			</c:forEach>
		</div>
	</c:if>
