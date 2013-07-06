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
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<p>
			<a href="index">Fórum</a>
		</p>
		<%
			for (int i = 0; i < users.size(); i++) {
				String loginUser = users.get(i).getLoginUser();
				boolean typeUser = users.get(i).getTypeUser();
		%>

		<fieldset>
			<legend>
				Usuário
				<%=i + 1%></legend>
			<p>
				Login:
				<%=loginUser%>
			</p>
			<p>
				Tipo:
				<%=(typeUser == true) ? "Administrador" : "Normal"%>
			</p>

			<a href="editarUsuario?id=<%=users.get(i).getIdUser()%>" class="button edit">Editar usuário</a>
			<a href="apagarUsuario?id=<%=users.get(i).getIdUser()%>" class="button delete">Apagar usuário</a>
		</fieldset>
		<%
}
%>
	</div>
</body>
</html>