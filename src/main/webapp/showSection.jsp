<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Section, Model.Thread"%>
<%
    List<Thread> threads = (List<Thread>) request.getAttribute("threads");
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
		<a href="index">F�rum</a>
		>>
		<a href="exibeSecao?id=<%=idSection %>"><%=titleSection %></a>
	</p>
	<h1><%=titleSection %></h1>
		<ul>
			<li><a href="novoTopico?idSection=<%=idSection%>"
				class="button add">Novo t�pico</a></li>
			<%
		    if (isAdmin) {
		%>
			<li><a href="editarSecao?id=<%=idSection%>" class="button edit">Editar
					se��o</a></li>
			<li><a href="apagarSecao?id=<%=idSection%>"
				class="button delete">Apagar se��o</a></li>
			<%
		    }
		%>
		</ul>
		<%
		    for (int i = 0; i < threads.size(); i++) {
		%>
		<fieldset>
			<legend>
				<a href="exibeTopico?id=<%=threads.get(i).getIdThread()%>"> <%=threads.get(i).getTitleThread()%>
				</a>
			</legend>
			<%=threads.get(i).getMessageThread()%>
		</fieldset>
		<%
		    }
		%>

	</div>
</body>
</html>