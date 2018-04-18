<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${contato.nome}"/></title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	
	<br/>
		<div class="container">
		<div class="row">
            <div class="col-sm-8">

                <h2 id="title">Atualizar Contato</h2>
                <form role="form" action="ContatoController" method="get" class="form-group">
                
                	<input type="hidden"  readonly="readonly" name="id" id="id" value="<c:out value="${contato.id}" />" />
                	<input type="hidden"  readonly="readonly" name="action" id="action" value="editar" />
                
                    <div class="form-group float-label-control">
                        <label for="">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" placeholder="nome" value="<c:out value="${contato.nome}"/>">
                    </div>
                    <div class="form-group float-label-control">
                        <label for="">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="email" value="<c:out value="${contato.email}"/>">
                    </div>
                    <div class="form-group float-label-control">
                        <label for="">Telefone</label>
                        <input class="form-control" type="text" name="telefone" id="telefone" placeholder="Telefone" value="<c:out value="${contato.telefone}"/>">
                    </div>
                    <div class="form-group float-label-control">
                    	<input type="submit" value="Atualizar Contato" class="btn btn-info" style="box-shadow: 3px 3px 30px gray;">      
                    </div>
                    
                    
                </form>
         </div>
		
		<br/>
	</div>
</body>
</html>