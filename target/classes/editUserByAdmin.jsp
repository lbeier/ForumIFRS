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
<title>Novo usuário</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<form action="" method="post">
			<p>
				Usuário:
				<%=user.getLoginUser()%>
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
				value="Criar usuario" /> <input type="reset" value="Limpar" />
		</form>
	</div>
</body>
</html>