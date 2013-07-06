<%@page import="Model.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, org.apache.commons.lang.WordUtils, Model.Section, Model.Thread"%>
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
<title>Fórum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/JavaScript" src="js/jquery-1.10.2.min.js"></script> 
<script type="text/JavaScript" src="js/scripts.js"></script>
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">Fórum</a>
		</div>
		<h1><%=titleSection%></h1>
		<hr />
		<%
			for (int i = 0; i < threads.size(); i++) {
			int idThread = threads.get(i).getIdThread();
			int numbersOfComments = new Comment().findAllByThread(idThread).size();
			int numbersOfVisualizations = threads.get(i).getNumbersOfVisualizations();
			String descriptionThread = threads.get(i).getMessageThread();
		%>
		<div id="topico<%= i %>" class="divApresentacao">
			<div id="topico<%= i %>" name="topico<%= i %>" class="tituloApresentacao">
				<a href="exibeTopico?id=<%=threads.get(i).getIdThread()%>">
					<%=threads.get(i).getTitleThread()%>
				</a>
			</div>

			<div id="mensagemTopico<%= i %>" name="mensagemTopico i %>" class="corpoApresentacao">
			<div id="desenhoTopico<%= i %>" name="desenhoTopico<%= i %>" class="desenhoApresentacao">
				<img alt="" src="images/thread.png"/>
			</div>			
			<div class="mensagemApresentacao">
				<%
					if(descriptionThread.length() < 160) {
						out.println(descriptionThread);
					} else {
						out.println(descriptionThread.substring(1, 155)+"(...)");
					}
				%>				
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
			<hr />
				<a href="novoTopico?idSection=<%=idSection%>"
				class="button add">Novo tópico</a>
			<%
				if (isAdmin) {
			%>
			<a href="editarSecao?id=<%=idSection%>" class="button edit">Editar
					seção</a>
			<a href="apagarSecao?id=<%=idSection%>"
				class="button delete">Apagar seção</a>
			<%
				}
			%>
	</div>
</body>
</html>