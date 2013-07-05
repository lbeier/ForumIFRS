<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Model.Section, java.util.List"%>

<%
	List<Section> sections = (List<Section>) request
			.getAttribute("sections");
	boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
</head>
<body>
	<div id="conteiner" class="borderRounded">
	<h3>Seções</h3>
		<%
			for (int i = 0; i < sections.size(); i++) {
		%>
		<fieldset class="borderRounded">
			<legend>
				<a href="exibeSecao?id=<%=sections.get(i).getIdSection()%>"> <%=sections.get(i).getTitleSection()%>
				</a>
			</legend>
			<%=sections.get(i).getDescriptionSection()%>
		</fieldset>
		<%
			}
		%>

		<%
			if (isAdmin) {
		%>
		<p>
			<a href="novaSecao">Nova seção</a>
		</p>

		<p>
			<a href="novoUsuario">Novo usuário</a>
		</p>
		
		<p>
			<a href="listarUsuarios">Listar usuários</a>
		</p>
		<%
			}
		%>

		<p>
			<a href="login?action=logout">Logout</a>
		</p>
	</div>
</body>
</html>