<%@ include file="/base.jsp"%>


<div class="navbar navbar-default" id="navbar-submenu">
	<button class="btn btn-primary" data-toggle="modal"
		data-target="#modal-1">
		<span class="glyphicon glyphicon-plus"></span>
	</button>
	<div class="modal" id="modal-1" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Title</h4>
					<div class="div-cadastrar-produto">

						<form class="form-signin"
							action="<c:url value="/produto/salvar"/>" method="post">

							<label class="form-elem-1">Nome do Item</label> <input
								type="text" class="form-control" name="produto.nome"
								placeholder="nome do item"> <label class="form-elem-1">Tipo</label>
							<select class="form-control" name="produto.tipo">
								<option value="Action Figure">Action Figure</option>
								<option value="Card Colecionavel">Card Colecionavel</option>
								<option value="HQ-Quadrinho">HQ-Quadrinho</option>
								<option value="Jogo de Video-Game">Jogo de Video-Game</option>
							</select> <label class="form-elem-1">Estado:</label> <select
								class="form-control" name="produto.estado">
								<option value="Zero KM">Zero KM</option>
								<option value="Semi-novo">Semi-novo</option>
								<option value="Usado">Usado</option>
							</select> <label class="form-elem-1">Breve Descrição</label>
							<textarea rows="3" cols="5" class="form-control"
								name="produto.descricao" required></textarea>
							<p></p>
							<button type="submit" class="btn btn-lg btn-primary btn-block">Salvar</button>

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>


<c:if test="${not empty produtos}">

	<div class="row">
		<c:forEach items="${produtos}" var="produto">
			<div class="col-md-3 lista-produto-itens">
				<h2>${produto.nome}</h2>
				<p class="exibicao-produto">${produto.estado}</p>
				<p class="exibicao-produto">${produto.tipo}</p>
				<p class="exibicao-produto">${produto.descricao}</p>
				<p>
					<a class="btn btn-default" href="#" role="button"> <span class="glyphicon glyphicon-search"></span></a> 
					<a class="btn btn-default"href="#"><span class="glyphicon glyphicon-wrench"></span></a> 
					<a class="btn btn-danger botao-fire" href="<c:url value="/produto/deletarProduto/${produto.id}" /> " role="button"><span class="glyphicon glyphicon-trash"></span></a>
			</div>
		</c:forEach>
	</div>
</c:if>
