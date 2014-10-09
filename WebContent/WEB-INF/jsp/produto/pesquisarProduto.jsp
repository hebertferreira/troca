<%@ include file="/base.jsp"%>


					
<br>
<c:if test="${not empty produtos}">

	<div class="row">
		<c:forEach items="${produtos}" var="produto">
			<div class="col-md-3 lista-produto-itens">
				<h2>${produto.nome}</h2>
				<img data-src="holder.js/200x200" class="img-thumbnail" alt="200x200" style="width: 200px; height: 200px;" src="<c:url value='/produto/downloadImagem/${produto.id}' /> ">
				<p class="exibicao-produto">${produto.estado}</p>
				<p class="exibicao-produto">${produto.tipo}</p>
				<p class="exibicao-produto">${produto.descricao}</p>
				<p>
					<a class="btn btn-block btn-warning" href="<c:url value="/proposta/criarProposta/${produto.id}" />" role="button">Criar Proposta</a> 
					
			</div>
		</c:forEach>
	</div>
</c:if>
