<%@ include file="/base.jsp"%>

<form action="<c:url value="/produto/enviarProposta" />"  >

	<label>Valor</label><br>
	<input type="number" name="valor"> <br>
	<label>Produtos para Troca</label><br>
	
	<c:forEach items="${produtos}" var="produto" >
		<input type="checkbox" name="produtosParaTroca" value="${produto.id}">
		 <label>${produto.nome}</label><br>
	</c:forEach>
		<button type="submit">Enviar Proposta</button>
</form>