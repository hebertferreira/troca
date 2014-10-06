<%@ include file="/base.jsp"%>

<div class="box-left">
<form action="<c:url value="/proposta/enviarProposta" />"  >

	<label class="form-elem-1">Valor</label><br>
	<input type="number" name="valor" value="0"> <br>

	<label class="form-elem-1">Produtos para Troca</label><br>
	
	<c:forEach items="${produtos}" var="produto" >
		<input type="checkbox" class="checkbox-inline" name="produtosParaTroca" value="${produto.id}">
		 <label class="form-elem-1">${produto.nome}</label><br>
	</c:forEach>
		<button type="submit">Enviar Proposta</button>
</form>
</div>