<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="pt-br">
	<head>
		 <meta charset="utf-8">
		<title>troca</title>
		<link type="text/css" href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" />
		<link type="text/css" href="<c:url value="/css/style.css"/>" rel="stylesheet" />
		<script type="text/javascript" src="<c:url value="/js/jquery-2.1.1.min.js"/>"></script>
	</head>

	 <body>
	
		<c:if test="${not empty errors}">
			<div class="alert alert-danger" role="alert">
				<c:forEach items="${errors }" var="error">
					<strong>${error.category }</strong> - ${error.message } <br>
				</c:forEach>
			</div>
		</c:if>
	
	<div class="div-logar">
	<form class="form-signin" action="<c:url value="/login/efetuarLogin"/>" method="post" >
	    
	      
		      <label >Email:</label>  
		      <input type="text" class="form-control" name="usuario.email" placeholder="Email address">
		      
		      <label >Senha:</label>  
		      <input type="password"  class="form-control" name="usuario.senha" placeholder="Password" required>
	        <p></p>
	      	  <button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
	      	  
	      </form>
	</div>

	<div class="div-cadastrar">
		
	<b> Formulario para criação</b>
	      <form class="form-signin" action="<c:url value="/login/criar"/>" method="post" >
	      
	          <label >Nome</label>  
	          <input type="text" class="form-control" name="usuario.nome" placeholder="Nome e sobrenome" >
	      
		      <label >Email:</label>  
		      <input type="text" class="form-control" name="usuario.email" placeholder="Email address">
		      
		      <label >Senha:</label>  
		      <input type="password"  class="form-control" name="usuario.senha" placeholder="Password" required>
	        <p></p>
	      	  <button type="submit" class="btn btn-lg btn-primary btn-block">Cadastrar</button>
	      	  
	      </form>
	</div>
	
	</body>
</html>