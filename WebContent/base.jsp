<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
		
		<c:if test="${not empty sucesso}">
			<div class="alert alert-success">
				${sucesso}
			</div>
		</c:if>
		
		<c:if test="${not empty alerta}">
			<div class="alert alert-alerta">
				${alerta}
			</div>
		</c:if>
		
		<c:if test="${not empty errors}">
			<div class="alert alert-error">
				<c:forEach items="${errors }" var="error">
					<strong>${error.category }</strong> - ${error.message } <br>
				</c:forEach>
			</div>
		</c:if>
		
 		<br>
