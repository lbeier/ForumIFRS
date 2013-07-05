<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Section, Model.Thread"%>
<%
    List<Thread> threads = (List<Thread>) request
            .getAttribute("threads");
    int idSection = (Integer) request.getAttribute("idSection");
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
			<a href="novoTopico?idSection=<%=idSection%>">Novo tópico</a>
		</p>
		<%
		    if (isAdmin) {
		%>
		<p>
			<a href="apagarSecao?id=<%=idSection%>">Apagar seção</a>
		</p>
		<p>
			<a href="editarSecao?id=<%=idSection%>">Editar seção</a>
		</p>
		<%
		    }
		%>
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