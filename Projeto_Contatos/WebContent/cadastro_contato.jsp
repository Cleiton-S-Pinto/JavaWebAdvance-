<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Contatos</title>

</head>

<script type="text/javascript">
	
	function sucesso() { 
	  alert("Contato Cadastrado com Sucesso!") 
	}

</script>


<body action="listar">
	
	<br/>
		<div class="container" style="border: solid 1px #c1c1c1; border-radius: 5px;">
		<div class="row">
            <div class="col-sm-8">

                <h2 id="title">Cadastrado de Contatos</h2>
                <form role="form" action="ContatoController" method="post" class="form-group">
                
                    <div class="form-group float-label-control">
                        <label for="">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" placeholder="nome"/>
                    </div>
                    
                    <div class="form-group float-label-control">
                        <label for="">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="email"/>
                    </div>
                    
                    <div class="form-group float-label-control">
                        <label for="">Telefone</label>
                        <input class="form-control" type="text" name="telefone" id="telefone" placeholder="Telefone"/>
                    </div>
                   
                    <div class="form-group float-label-control">
                        <button type="submit" class="btn btn-info btn-lg" onclick="sucesso()" style="box-shadow: 3px 3px 30px gray;">Enviar</button>
                    </div>
                    
                    
                </form>
         </div>
      </div>
		
		<br/>
		
		<div class="container" id="divcontainer">
			<h2 id="title">Contatos Cadastrados</h2>
				<table class="table table-hover" >
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Telefone</th>
						</tr>
					</thead>
						<tbody>
							<c:forEach items="${contatos}" var="contatos">
								<tr>
									<td class="blacks"><c:out value="${contatos.id}" /></td>
									<td class="blacks"><c:out value="${contatos.nome}" /></td>
									<td class="blacks"><c:out value="${contatos.email}" /></td>
									<td class="blacks"><c:out value="${contatos.telefone}" /></td>
									<td><a href="ContatoController?action=buscar&id=<c:out value='${contatos.id}'/>" class="btn btn-info" style="box-shadow: 3px 3px 30px gray;" class="blacks">Editar</a>
										<a href="ContatoController?action=deletar&id=<c:out value='${contatos.id}' />" class="btn btn-info" style="box-shadow: 3px 3px 30px gray;" class="blacks">Remover</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			<br/>
		</div>
	</div>
</body>
</html>