<%@ include file="/base.jsp"%>

<h2> Produtos da proposta </h2>
	
<table class="table">
	<thead>
		<th> Nome </th>
		<th> Descrição </th>
	</thead>
	<tbody>
		<c:forEach items="${produtosDaProposta}" var="produto" >
			<tr>
				<td> ${produto.nome} </td>
				<td> ${produto.descricao} </td>					
			</tr>		
		</c:forEach>
	</tbody>
</table>
