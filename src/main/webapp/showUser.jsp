<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, Model.User"%>
<%
	List<User> users = (List<User>) request.getAttribute("users");
	Thread thread = (Thread) request.getAttribute("thread");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F�rum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/JavaScript" src="js/jquery-1.10.2.min.js"></script> 
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">F�rum</a>
		</div>
		<%
			for (int i = 0; i < users.size(); i++) {
				String loginUser = users.get(i).getLoginUser();
				boolean typeUser = users.get(i).getTypeUser();
		%>

		<fieldset>
			<legend>
				Usu�rio
				<%=i + 1%></legend>
			<p>
				Login:
				<%=loginUser%>
			</p>
			<p>
				Tipo:
				<%=(typeUser == true) ? "Administrador" : "Normal"%>
			</p>

			<a href="editarUsuario?id=<%=users.get(i).getIdUser()%>" class="button edit">Editar usu�rio</a>
			<a href="apagarUsuario?id=<%=users.get(i).getIdUser()%>" class="button delete">Apagar usu�rio</a>
		</fieldset>
		<%
}
%>
	</div>
</body>
</html>