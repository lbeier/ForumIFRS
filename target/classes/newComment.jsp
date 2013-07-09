<%@page
	import="java.util.List, Model.Thread, Model.Thread_Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Thread thread = (Thread) request.getAttribute("thread");
	int idThread = thread.getIdThread();
	String titleThread = thread.getTitleThread();
	String messageThread = thread.getMessageThread();
	String titleSection = thread.getSection().getTitleSection();
	int idSection = thread.getSection().getIdSection();
	List<Thread_Tag> tags = (List<Thread_Tag>) request
			.getAttribute("tags");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fórum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/JavaScript" src="js/jquery-1.10.2.min.js"></script> 
<script type="text/JavaScript" src="js/scripts.js"></script>
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">Fórum</a>
			::
			<a href="exibeSecao?id=<%=idSection%>">Seção: <%=titleSection%></a>
			::
			<a href="exibeTopico?id=<%=idThread%>">Tópico: <%=titleThread%></a>
		</div>
		
		<div id="topicoConteiner" class="divApresentacao"
			style="height: auto;">
			<div id="topico" name="topico" class="tituloTopico">
				<p><%=thread.getTitleThread()%></p>
				<p>
					<strong>Autor: </strong> <%= thread.getUser().getLoginUser() %>
					<strong>Data: </strong> <%= thread.getDateCreate() %>
				</p>
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
			</div>
		</div>
		<form action="" method="post">
			<p>
				<label for="messageComment">Mensagem do comentário</label>
			</p>
			<p>
				<textarea id="messageComment" name="messageComment"></textarea>
			</p>

			<input type="hidden" id="idThread" name="idThread"
				value="<%=idThread%>" /> <input type="submit" value="Enviar"
				class="button" /> <input type="reset" value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>