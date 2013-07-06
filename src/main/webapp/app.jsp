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
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'/>
</head>
<body>
	<div id="conteiner" class="borderRounded">
		<p>
			<a href="index">Fórum</a>
		</p>
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
		<ul>
			<%
			if (isAdmin) {
		%>
			<li><a href="novaSecao" class="button add">Nova seção</a></li>

			<li><a href="novoUsuario" class="button add">Novo usuário</a></li>

			<li><a href="listarUsuarios" class="button email">Listar
					usuários</a></li>
			<%
			}
		%>

			<li><a href="login?action=logout" class="button spark">Logout</a>
			</li>
		</ul>
	</div>
</body>
</html>