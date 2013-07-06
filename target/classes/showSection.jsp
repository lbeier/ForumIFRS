<%@page import="Model.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Section, Model.Thread"%>
<%
	List<Thread> threads = (List<Thread>) request
			.getAttribute("threads");
	Section section = (Section) request.getAttribute("section");
	int idSection = section.getIdSection();
	String titleSection = section.getTitleSection();
	boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<p>
			<a href="index">Fórum</a>
		</p>
		<h1><%=titleSection%></h1>
		<ul>
			<li><a href="novoTopico?idSection=<%=idSection%>"
				class="button add">Novo tópico</a></li>
			<%
				if (isAdmin) {
			%>
			<li><a href="editarSecao?id=<%=idSection%>" class="button edit">Editar
					seção</a></li>
			<li><a href="apagarSecao?id=<%=idSection%>"
				class="button delete">Apagar seção</a></li>
			<%
				}
			%>
		</ul>
		<%
			for (int i = 0; i < threads.size(); i++) {
			int idThread = threads.get(i).getIdThread();
			int numbersOfComments = new Comment().findAllByThread(idThread).size();
			int numbersOfVisualizations = threads.get(i).getNumbersOfVisualizations();
		%>
		<div id="topico<%= i %>" class="divApresentacao">
			<div id="topico<%= i %>" name="topico<%= i %>" class="tituloApresentacao">
				<a href="exibeTopico?id=<%=threads.get(i).getIdThread()%>">
					<%=threads.get(i).getTitleThread()%>
				</a>
			</div>

			<div id="mensagemTopico<%= i %>" name="mensagemTopico i %>" class="corpoApresentacao">
			<div id="desenhoTopico<%= i %>" name="desenhoTopico<%= i %>" class="desenhoApresentacao">
				<img alt="" src="http://cdn3.iconfinder.com/data/icons/iconic-1/32/chat_alt_stroke-48.png"/>
			</div>
			<div class="mensagemApresentacao">
				<%=threads.get(i).getMessageThread()%>
			</div>
			<div class="contagemApresentacao">
				Respostas: <%= numbersOfComments %>
				Visualizações: <%= numbersOfVisualizations %>
			</div>	
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>