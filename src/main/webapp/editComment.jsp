<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Model.Comment, Model.Thread"%>
<%
	Comment comment = (Comment) request.getAttribute("comment");

	Thread thread = (Thread) request.getAttribute("thread");
	int idThread = thread.getIdThread();
	String titleThread = thread.getTitleThread();
	String messageThread = thread.getMessageThread();
	String titleSection = thread.getSection().getTitleSection();
	int idSection = thread.getSection().getIdSection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F�rum - IFRS - Lucas Falk Beier</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<div class="breadcrumbs">
			<a href="index">
			F�rum
			</a>
			::
			<a href="exibeSecao?id=<%=idSection%>">
			Se��o: <%=titleSection%>
			</a>
			::
			<a href="exibeTopico?id=<%=idThread%>">
			T�pico: <%=titleThread%>
			</a>
		</div>

		<fieldset>
			<legend>
				Respondendo ao t�pico
				<%=titleThread%>
			</legend>
			<%=messageThread%>
		</fieldset>
		<form action="" method="post">
			<p>
				<label for="messageComment">Mensagem do coment�rio</label>
			</p>
			<p>
				<textarea id="messageComment" name="messageComment"><%=comment.getMessageComment()%></textarea>
			</p>

			<input type="hidden" id="idThread" name="idThread"
				value="<%=comment.getIdComment()%>" /> <input type="submit"
				value="Enviar" class="button" /> <input type="reset" value="Limpar"
				class="button" />
		</form>
	</div>
</body>
</html>