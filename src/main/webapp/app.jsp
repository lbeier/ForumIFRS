<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Model.Section, Model.Thread, java.util.List"%>

<%
	List<Section> sections = (List<Section>) request.getAttribute("sections");
	boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fórum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'/>
</head>
<body>
	<div id="conteiner" class="borderRounded">
		<div class="breadcrumbs">
				<a href="index">Fórum</a>
		</div>
		<hr />
		<%
			for (int i = 0; i < sections.size(); i++) {
			int idSection = sections.get(i).getIdSection();
			int numbersOfThreads = new Thread().findAllBySection(idSection).size();
		%>
		<div id="secao<%= i %>" class="divApresentacao">
			<div id="tituloSecao<%= i %>" name="tituloSecao<%= i %>" class="tituloApresentacao">
				<a href="exibeSecao?id=<%=sections.get(i).getIdSection()%>">
				<%=sections.get(i).getTitleSection()%>
				</a>
			</div>

			<div id="mensagemSecao<%= i %>" name="mensagemSecao<%= i %>" class="corpoApresentacao">
			<div id="desenhoSecao<%= i %>" name="desenhoSecao<%= i %>" class="desenhoApresentacao">
				<img alt="" src="http://cdn3.iconfinder.com/data/icons/iconic-1/32/chat_alt_fill-48.png"/>
			</div>
			<div class="mensagemApresentacao">
				<%=sections.get(i).getDescriptionSection()%>
			</div>
			<div class="contagemApresentacao">
				Tópicos: <%= numbersOfThreads%>
			</div>		
			</div>
		</div>
		<%
			}
		%>
			<%
			if (isAdmin) {
		%>
			<hr />
			<a href="novaSecao" class="button add">Nova seção</a>

			<a href="novoUsuario" class="button add">Novo usuário</a>

			<a href="listarUsuarios" class="button email">Listar
					usuários</a>
			<%
			}
		%>

			<a href="login?action=logout" class="button spark">Logout</a>
	</div>
</body>
</html>