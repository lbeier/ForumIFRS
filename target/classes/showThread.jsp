<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Comment, Model.Thread, Model.Section, Model.Thread_Tag, Model.Tag"%>
<%
	List<Comment> comments = (List<Comment>) request
			.getAttribute("comments");
	Thread thread = (Thread) request.getAttribute("thread");
	boolean canEditThread = (Boolean) request
			.getAttribute("canEditThread");
	boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
	int idUSer = (Integer) request.getAttribute("idUSer");
	Section section = (Section) request.getAttribute("section");
	int idSection = section.getIdSection();
	String titleSection = section.getTitleSection();
	List<Thread_Tag> tags = (List<Thread_Tag>) request
			.getAttribute("tags");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fórum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/JavaScript" src="jquery-1.10.2.min.js"></script>
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">Fórum</a> :: <a href="exibeSecao?id=<%=idSection%>">Seção:
				<%=titleSection%></a>
		</div>
		<hr />
		<div id="topicoConteiner" class="divApresentacao"
			style="height: auto;">
			<div id="topico" name="topico" class="tituloTopico">
				<p><%=thread.getTitleThread()%></p>
					<strong>Autor: </strong> <%= thread.getUser().getLoginUser() %>
					<strong>Data: </strong> <%= thread.getDateCreate() %>
			</div>

			<div id="mensagemTopico" class="corpoApresentacao"
				style="padding: 10px; height: auto;">

				<%=thread.getMessageThread().replaceAll("(\r\n|\n)",
					"<br />")%>
				<hr />
				<%
					for (int i = 0; i < tags.size(); i++) {
				%>
				<span class="tag"><%=tags.get(i).getTag().getTitleTag()%></span>
				<%
					}
				%>
				<%
					if (canEditThread) {
				%>
				<hr />
				<a href="editarTopico?id=<%=thread.getIdThread()%>">
					<img src="./images/edit.png" alt="Editar tópico" title="Editar tópico"/>
				</a>
				<a href="apagarTopico?id=<%=thread.getIdThread()%>">
					<img src="./images/delete.png" alt="Deletar tópico" title="Deletar tópico"/>
				</a>
				<%
					}
				%>
			</div>
		</div>

		<%
			for (int i = 0; i < comments.size(); i++) {
		%>
		<div id="comentárioConteiner<%=i%>" class="divApresentacao"
			style="height: auto;">
			<div id="mensagem<%=i%>" class="tituloMensagem">
				<strong>Autor:</strong> <%= comments.get(i).getUser().getLoginUser() %>
				<strong>Data:</strong> <%= comments.get(i).getDateCreate() %>
			</div>
			<div id="mensagemcomentário<%=i%>" class="corpoApresentacao"
				style="padding: 10px; height: auto;">
				<%=comments.get(i).getMessageComment()
						.replaceAll("(\r\n|\n)", "<br />")%>
				<%
					if (idUSer == comments.get(i).getUser().getIdUser() || isAdmin) {
				%>
				<hr />
				<a href="editarComentario?id=<%=comments.get(i).getIdComment()%>">
					<img src="./images/edit.png" alt="Editar comentário" title="Editar comentário"/>
				</a>
				<a href="apagarComentario?id=<%=comments.get(i).getIdComment()%>">
					<img src="./images/delete.png" alt="Deletar comentário" title="Deletar comentário"/>
				</a>
				<%
					}
				%>
			</div>
		</div>
		<%
			}
		%>
		<p>
			<a href="novoComentario?id=<%=thread.getIdThread()%>">
				<img src="./images/add.png" alt="Adicionar comentário" title="Adicionar comentário"/>
			</a>
		</p>
	</div>
</body>
</html>