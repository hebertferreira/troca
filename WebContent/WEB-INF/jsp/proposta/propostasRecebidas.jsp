<%@ include file="/base.jsp"%>

<h2> Propostas recebidas </h2>
	
<table class="table">
	<thead>
		<th> Comprador </th>
		<th> Produto desejado </th>
		<th> Lance em dinheiro </th>
		<th> Produtos da proposta </th>
	</thead>
	<tbody>
		<c:forEach items="${propostas}" var="proposta" >
			<tr>
				<td> ${proposta.comprador.nome} </td>
				<td> ${proposta.produtoLeiloado.nome} </td>
				<td> ${proposta.valor} </td>
				<td> <a href='<c:url value="/proposta/produtosDaProposta/${proposta.id}" />'> Ver </a> </td>									
			</tr>		
		</c:forEach>
	</tbody>
</table>
