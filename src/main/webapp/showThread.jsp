<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Comment, Model.Thread"%>
<%
    List<Comment> comments = (List<Comment>) request
            .getAttribute("comments");
    Thread thread = (Thread) request.getAttribute("thread");
    boolean canEditThread = (Boolean) request
            .getAttribute("canEditThread");
    boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
    int idUSer = (Integer) request.getAttribute("idUSer");
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
		<fieldset>
			<legend>
				<%=thread.getTitleThread()%>
				</a>
			</legend>
			<%=thread.getMessageThread()%>
			<ul>
				<%
			    if (canEditThread) {
			%>
				<li><a href="editarTopico?id=<%=thread.getIdThread()%>"
					class="button edit">Editar tópico</a></li>
				<li><a href="apagarTopico?id=<%=thread.getIdThread()%>"
					class="button delete">Apagar tópico</a></li>
				<%
			    }
			%>
			</ul>
		</fieldset>
		<hr />

		<%
		    for (int i = 0; i < comments.size(); i++) {
		%>
		<fieldset>
			<legend>
				Comentário
				<%=i + 1%></legend>
			<%=comments.get(i).getMessageComment()%>
			<ul>
				<%
			    if (idUSer == comments.get(i).getUser().getIdUser() || isAdmin) {
			%>
				<li><a
					href="editarComentario?id=<%=comments.get(i).getIdComment()%>"
					class="button edit">Editar comentário</a></li>

				<li><a
					href="apagarComentario?id=<%=comments.get(i).getIdComment()%>"
					class="button delete">Apagar comentário</a></li>
				<%
			    }
			%>
			</ul>
		</fieldset>
		<%
		    }
		%>
		<p>
			<a href="novoComentario?id=<%=thread.getIdThread()%>"
				class="button add">Novo comentário</a>
		</p>
	</div>
</body>
</html>