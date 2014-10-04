<%@ include file="/base.jsp"%>

<h2> Propostas Realizadas </h2>
	
<table class="table">
	<thead>
		<th> Item desejado </th>
		<th> Dono do Item </th>
		<th> Lance em dinheiro </th>
		<th> Itens Oferecidos </th>
		<th> Status da Proposta</th>
		<th> </th>
	</thead>
	<tbody>
		<c:forEach items="${propostas}" var="proposta" >
			<tr>
				<td> ${proposta.produtoLeiloado.nome} </td>
				<td> ${proposta.vendedor.nome} </td>
				<td> R$ ${proposta.valor} </td>
				<td> <a href='<c:url value="/proposta/produtosDaProposta/${proposta.id}" />'> Ver </a> </td>
				<td> ${proposta.statusProposta} </td>
			</tr>		
		</c:forEach>
	</tbody>
</table>
