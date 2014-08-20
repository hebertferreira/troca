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
			<div class="alert alert-error">
				<c:forEach items="${errors }" var="error">
					<strong>${error.category }</strong> - ${error.message } <br>
				</c:forEach>
			</div>
		</c:if>
	
	<b> Formulario para criação</b>
	      <form class="form-signin" action="<c:url value="/login/criar"/>" method="post" >
	      
	          <label >Nome</label>  
	          <input type="text" name="usuario.nome" >
	      
		      <label >Email:</label>  
		      <input type="text" name="usuario.email" >
		      
		      <label >Senha:</label>  
		      <input type="password" name="usuario.senha" >
	        
	      	  <button type="submit" class="btn btn-default" >Salvar</button>
	      	  
	      </form>

		
	</body>
</html>