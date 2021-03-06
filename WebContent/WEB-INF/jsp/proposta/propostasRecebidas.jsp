<%@ include file="/base.jsp"%>

<h2> Propostas recebidas </h2>
	
<table class="table">
	<thead>
		<th> Item desejado </th>
		<th> Usu�rio Interessado </th>
		<th> Lance em dinheiro </th>
		<th> Itens da proposta </th>
		<th> Status da Proposta</th>
		<th> </th>
	</thead>
	<tbody>
		<c:forEach items="${propostas}" var="proposta" >
			<tr>
				<td> ${proposta.produtoLeiloado.nome} </td>
				<td> ${proposta.comprador.nome} </td>
				<td> R$ ${proposta.valor} </td>
				<td> <a href='<c:url value="/proposta/produtosDaProposta/${proposta.id}" />'> Ver </a> </td>
				<td> ${proposta.statusProposta} </td>
				<td> <a href='<c:url value="/proposta/aceitar/${proposta.id}"  />'class="btn btn-success"> Aceitar </a> </td>
			</tr>		
		</c:forEach>
	</tbody>
</table>
