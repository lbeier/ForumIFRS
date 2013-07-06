<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fórum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">Fórum</a>
		</div>
		<form action="" method="post">
			<p>
				<label for="">Login do usuário</label>
				<%=user.getLoginUser()%>
			</p>

			<p>
				<label for="">Tipo de usuário</label>
			</p>

			<%
				if (user.getTypeUser()) {
			%>
			<p>
				<input type="radio" name="tipo" value="true" checked="checked">Administrador
			</p>
			<p>
				<input type="radio" name="tipo" value="false">Normal
			</p>
			<%
				} else {
			%>
			<p>
				<input type="radio" name="tipo" value="true">Administrador
			</p>
			<p>
				<input type="radio" name="tipo" value="false" checked="checked">Normal
			</p>
			<%
				}
			%>

			<input type="hidden" name="idUser" id="idUser"
				value="<%=user.getIdUser()%>" /> <input type="submit"
				value="Editar usuario" class="button" /> <input type="reset"
				value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>