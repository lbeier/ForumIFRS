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

			<%
			    if (canEditThread) {
			%>
			<p>
				<a href="editarTopico?id=<%=thread.getIdThread()%>">Editar
					tópico</a>
			</p>
			<p>
				<a href="apagarTopico?id=<%=thread.getIdThread()%>">Apagar tópico</a>
			</p>
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
				Comentário
				<%=i + 1%></legend>
			<%=comments.get(i).getMessageComment()%>

			<%
			    if (idUSer == comments.get(i).getUser().getIdUser() || isAdmin) {
			%>
			<p>
				<a href="editarComentario?id=<%=comments.get(i).getIdComment()%>">Editar
					comentário</a>
			</p>
			
			<p>
				<a href="apagarComentario?id=<%=comments.get(i).getIdComment()%>">Apagar
					comentário</a>
			</p>
			<%
			    }
			%>
		</fieldset>
		<%
		    }
		%>
		<p>
			<a href="novoComentario?id=<%=thread.getIdThread()%>">Novo
				comentário</a>
		</p>
	</div>
</body>
</html>