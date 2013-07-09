<%@page import="java.sql.Timestamp"%>
<%@page import="Model.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, org.apache.commons.lang.WordUtils, Model.Thread, Model.Thread_Tag, Model.Tag"%>
<%
	List<Thread_Tag> threads = (List<Thread_Tag>) request.getAttribute("threads");
	Tag tag = (Tag) request.getAttribute("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F�rum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/JavaScript" src="js/jquery-1.10.2.min.js"></script> 
<script type="text/JavaScript" src="js/scripts.js"></script>
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">F�rum</a>
		</div>
		<hr />
		<h1><%= tag.getTitleTag().toUpperCase() %></h1>
		<hr />
		<%
			for (int i = 0; i < threads.size(); i++) {
			int idThread = threads.get(i).getThread().getIdThread();
			int numbersOfComments = threads.get(i).getThread().getComments().size();
			int numbersOfVisualizations = threads.get(i).getThread().getNumbersOfVisualizations();
			String descriptionThread = threads.get(i).getThread().getMessageThread();
			String titleThread = threads.get(i).getThread().getTitleThread();
			String autorThread = threads.get(i).getThread().getUser().getLoginUser();
			Timestamp dateThread = threads.get(i).getThread().getDateCreate();
		%>
		<div id="topicoConteiner<%= i %>" class="divApresentacao">
			<div id="topico<%= i %>" name="topico<%= i %>" class="tituloApresentacao">
				<a href="exibeTopico?id=<%= idThread %>">				
					<p><%= titleThread %></p>
				</a>
					<strong>Autor: </strong> <%= autorThread %>
					<strong>Data: </strong> <%= dateThread %>
			</div>

			<div id="mensagemTopico<%= i %>" name="mensagemTopico<%= i %>" class="corpoApresentacao">
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
				Visualiza��es: <%= numbersOfVisualizations %>
			</div>	
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>