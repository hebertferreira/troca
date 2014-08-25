<%@ include file="/base.jsp" %> 
<%@ taglib uri="/tags/tags" prefix="tags"%>



<body>
	<c:if test="${not empty errors}">
		<div class="alert alert-danger" role="alert">
			<c:forEach items="${errors }" var="error">
				<strong>${error.category }</strong> - ${error.message } <br>
			</c:forEach>
		</div>
	</c:if>

<div class="navbar navbar-default" id="navbar-submenu">
<button class="btn btn-primary" data-toggle="modal" data-target="#modal-1"><span class="glyphicon glyphicon-plus"></span></button>
	<div class="modal" id="modal-1" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Modal Title</h4>
				<div class="div-cadastrar-produto">

			<form class="form-signin" action="<c:url value="/login/criar"/>" method="post">

				<label class="form-elem-1">Nome do Item</label> <input type="text" class="form-control" name="usuario.nome" placeholder="nome do item">
				
				 <label class="form-elem-1">Tipo</label>
				 <select class="form-control" name="produto.tipo">
				 <option value="Action Figure">Action Figure</option>
				 <option value="Card Colecionavel">Card Colecionavel</option>
				 <option value="HQ-Quadrinho">HQ-Quadrinho</option>
				 <option value="Jogo de Video-Game">Jogo de Video-Game</option>
				 </select>
				 
				 <label class="form-elem-1">Estado:</label>
				 <select class="form-control" name="produto.estado">
				 <option value="Zero KM">Zero KM</option>
				 <option value="Semi-novo">Semi-novo</option>
				 <option value="Usado">Usado</option>
				 </select>
				 <label class="form-elem-1">Breve Descrição</label>
				 <textarea rows="3" cols="5" class="form-control" name="produto.descricao" required></textarea>
				 <p></p>
				 <button type="submit" class="btn btn-lg btn-primary btn-block">Salvar</button>

			</form>
		</div>
				
			</div>
			</div>
	</div>
</div>
<!-- 	<div class="box-left-produto"> -->
<!-- 		<div class="div-cadastrar-produto"> -->

<%-- 			<form class="form-signin" action="<c:url value="/login/criar"/>" method="post"> --%>

<!-- 				<label class="form-elem-1">Nome do Item</label> <input type="text" class="form-control" name="usuario.nome" placeholder="nome do item"> -->
				
<!-- 				 <label class="form-elem-1">Tipo</label> -->
<!-- 				 <select class="form-control" name="produto.tipo"> -->
<!-- 				 <option value="Action Figure">Action Figure</option> -->
<!-- 				 <option value="Card Colecionavel">Card Colecionavel</option> -->
<!-- 				 <option value="HQ-Quadrinho">HQ-Quadrinho</option> -->
<!-- 				 <option value="Jogo de Video-Game">Jogo de Video-Game</option> -->
<!-- 				 </select> -->
				 
<!-- 				 <label class="form-elem-1">Estado:</label> -->
<!-- 				 <select class="form-control" name="produto.estado"> -->
<!-- 				 <option value="Zero KM">Zero KM</option> -->
<!-- 				 <option value="Semi-novo">Semi-novo</option> -->
<!-- 				 <option value="Usado">Usado</option> -->
<!-- 				 </select> -->
<!-- 				 <label class="form-elem-1">Breve Descrição</label> -->
<!-- 				 <input type="text" class="form-control" name="produto.descricao" required> -->
<!-- 				 <p></p> -->
<!-- 				 <button type="submit" class="btn btn-lg btn-primary btn-block">Salvar</button> -->

<!-- 			</form> -->
<!-- 		</div> -->
	
<!-- 	</div> -->

	<div class="box-right-produto">

	</div>



</div>
</body>
</html>