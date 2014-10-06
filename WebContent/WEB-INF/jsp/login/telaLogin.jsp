<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>troca</title>
<link type="text/css" href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/css/style.css"/>" rel="stylesheet" />
<script type="text/javascript" 	src="<c:url value="/js/jquery-2.1.1.min.js"/>"></script>
<style>
body {
	background: url("img/Market.jpg");
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>

<body>

	<c:if test="${not empty errors}">
		<div class="alert alert-danger" role="alert">
			<c:forEach items="${errors }" var="error">
				<label class="form-elem-1" id="msg-style">${error.category } - ${error.message }</label> <br>
			</c:forEach>
		</div>
	</c:if>


	<div class="box-left"></div>

	<div class="box-right">
		<div class="div-logar">
			<form class="form-signin"
				action="<c:url value="/login/efetuarLogin"/>" method="post">

				<label class="form-elem-1">Email:</label> 
				<input type="text" class="form-control"	name="usuario.email" placeholder="Email address"> 
				
				<label class="form-elem-1">Senha:</label>
				<input type="password" class="form-control" name="usuario.senha" placeholder="Password" required>
				<p></p>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
			</form>
			<ul class="nav nav-pills">
				<li><a href="#">Esqueceu a senha ?</a></li>
			</ul>
		</div>
		<br>
		<div class="div-cadastrar">		
			<b>Você possui algum item para trocar ? <small>   Cadastre-se agora</small></b>
			<form class="form-signin" action="<c:url value="/login/criar"/>"method="post">

				<label class="form-elem-1">Nome:</label> 
				<input type="text" class="form-control"
					name="usuario.nome" placeholder="Nome e sobrenome">
				
				 <label class="form-elem-1">Email:</label>
				<input type="text" class="form-control" name="usuario.email" placeholder="Email address">
				 <label class="form-elem-1">Senha:</label> <input
					type="password" class="form-control" name="usuario.senha" placeholder="Password" required>
				<p></p>
				<button type="submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>

			</form>
		</div>

	</div>

</body>
</html>