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
							action="<c:url value="/produto/salvar"/>" method="post" enctype="multipart/form-data" >

							<label class="form-elem-1">Nome do Item</label> <input
								type="text" class="form-control" name="produto.nome"
								placeholder="nome do item"> <label class="form-elem-1">Tipo</label>
							<select class="form-control" name="produto.tipo">
								<option value="actionFigure">Action Figure</option>
								<option value="cardColecionavel">Card Colecionavel / Figurinhas</option>
								<option value="hqQuadrinho">HQ-Quadrinho / Álbum</option>
								<option value="jogoVideoGame">Jogo de Video-Game</option>
								<option value="numismatica">Medalha / Moeda</option>
							</select> <label class="form-elem-1">Estado:</label> <select
								class="form-control" name="produto.estado">
								<option value="Zero KM">Novo na caixa</option>
								<option value="Semi-novo">Semi-novo</option>
								<option value="Usado">Usado</option>
							</select> <label class="form-elem-1">Breve Descrição</label>
							<textarea rows="3" cols="5" class="form-control"
								name="produto.descricao" required></textarea>
								
							<label class="form-elem-1">Imagem</label> 
							<input type="file" name="imagem" >	
								
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
			<div class="col-lg-11 lista-produto-itens">
				<h2  data-toggle="tooltip" data-placement="top" title="${produto.nome}">${produto.nome}</h2>
				<img data-src="holder.js/200x200" class="img-thumbnail" alt="200x200" style="width: 200px; height: 200px;" src="<c:url value='/produto/downloadImagem/${produto.id}' /> ">
				<label class="form-elem-1">Estado do Item:</label>${produto.estado}<br>
				<label class="form-elem-1">Tipo de Item:</label>${produto.tipo}<br>
				<label class="form-elem-1">Breve Descrição:</label>${produto.descricao}<br>
				<a class="btn btn-default" href="#" role="button"> <span class="glyphicon glyphicon-search"></span></a> 
				<a class="btn btn-default"href="#"><span class="glyphicon glyphicon-wrench"></span></a> 
				<a class="btn btn-danger botao-fire" href="<c:url value="/produto/deletarProduto/${produto.id}" /> " role="button"><span class="glyphicon glyphicon-trash"></span></a>
			</div>
			</div>
		</c:forEach>
	</div>
</c:if>
