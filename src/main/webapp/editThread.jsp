<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, Model.Thread, Model.Section"%>
<%
	Thread thread = (Thread) request.getAttribute("thread");
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
<script type="text/JavaScript" src="js/jquery-1.10.2.min.js"></script> 
<script type="text/JavaScript" src="js/scripts.js"></script>
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">F�rum</a>
			::
			<a href="exibeSecao?id=<%=idSection%>">Se��o: <%=titleSection%></a>
			::
			<a href="exibeTopico?id=<%=thread.getIdThread()%>">T�pico: <%=thread.getTitleThread()%></a>
		</div>
		<form action="" method="post">
			<p>
				<label for="titleThread">T�tulo do t�pico</label>
			</p>
			<p>
				<input type="text" id="titleThread" name="titleThread"
					value="<%=thread.getTitleThread()%>" />
			</p>

			<p>
				<label for="messageThread">Mensagem do t�pico</label>
			</p>
			<p>
				<textarea id="messageThread" name="messageThread"><%=thread.getMessageThread()%></textarea>
			</p>

			<input type="hidden" id="idThread" name="idThread"
				value="<%=thread.getIdThread()%>" /> <input type="submit"
				value="Enviar" class="button" /> <input type="reset" value="Limpar"
				class="button" />
		</form>
	</div>
</body>
</html>