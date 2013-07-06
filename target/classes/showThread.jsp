<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Comment, Model.Thread, Model.Section"%>
<%
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    Thread thread = (Thread) request.getAttribute("thread");
    boolean canEditThread = (Boolean) request.getAttribute("canEditThread");
    boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
    int idUSer = (Integer) request.getAttribute("idUSer");
    Section section = (Section) request.getAttribute("section");
    int idSection = section.getIdSection();
    String titleSection = section.getTitleSection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F�rum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
	<div class="breadcrumbs">
		<a href="index">F�rum</a>
		::
		<a href="exibeSecao?id=<%=idSection %>">Se��o: <%=titleSection %></a>
	</div>
	<hr />
		<fieldset>
			<legend>
				<%=thread.getTitleThread()%>
				</a>
			</legend>
			<p>
			<%=thread.getMessageThread()%>
			</p>
				<%
			    if (canEditThread) {
			%>
				<hr />
				<a href="editarTopico?id=<%=thread.getIdThread()%>"
					class="button edit">Editar t�pico</a>
				<a href="apagarTopico?id=<%=thread.getIdThread()%>"
					class="button delete">Apagar t�pico</a>
				<%
			    }
			%>
		</fieldset>
		<hr />

		<%
		    for (int i = 0; i < comments.size(); i++) {
		%>
		<fieldset>
			<legend>
				Coment�rio
				<%=i + 1%></legend>
			<p><%=comments.get(i).getMessageComment()%></p>
				<%
			    if (idUSer == comments.get(i).getUser().getIdUser() || isAdmin) {
			%>
				<hr />
				<a href="editarComentario?id=<%=comments.get(i).getIdComment()%>" class="button edit">Editar coment�rio</a>
				<a href="apagarComentario?id=<%=comments.get(i).getIdComment()%>" class="button delete">Apagar coment�rio</a>
				<%
			    }
			%>
		</fieldset>
		<%
		    }
		%>
		<p>
			<a href="novoComentario?id=<%=thread.getIdThread()%>"
				class="button add">Novo coment�rio</a>
		</p>
	</div>
</body>
</html>