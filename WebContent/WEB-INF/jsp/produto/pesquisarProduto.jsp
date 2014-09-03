<%@ include file="/base.jsp"%>


					<form action="<c:url value="/produto/pesquisarProduto"/>" method="post">
 					<input type="text" name="pesquisa" placeholder="pesquisa"> 
					<button type="submit"><span class="glyphicon glyphicon-search"></span></button>
					</form>

<c:if test="${not empty produtos}">

	<div class="row">
		<c:forEach items="${produtos}" var="produto">
			<div class="col-md-3 lista-produto-itens">
				<h2>${produto.nome}</h2>
				<p class="exibicao-produto">${produto.estado}</p>
				<p class="exibicao-produto">${produto.tipo}</p>
				<p class="exibicao-produto">${produto.descricao}</p>
				<p>
					<a class="btn btn-default" href="#" role="button"> <span
						class="glyphicon glyphicon-search"></span></a> <a
						class="btn btn-default" ><span
						class="glyphicon glyphicon-wrench"></span></a> <a
						class="btn btn-danger botao-fire" href="#" role="button">
						<span class="glyphicon glyphicon-trash"></span>
					</a>
			</div>
		</c:forEach>
	</div>
</c:if>
