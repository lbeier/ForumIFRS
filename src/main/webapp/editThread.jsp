<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, Model.Thread"%>
<%
	Thread thread = (Thread) request.getAttribute("thread");
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
		<form action="" method="post">
			<p>
				<input type="text" id="titleThread" name="titleThread" 
				placeholder="Insira o título do tópico" value="<%= thread.getTitleThread() %>"/>
			</p>

			<p>
				<textarea id="messageThread" name="messageThread"
					placeholder="Insira a descrição do tópico"><%= thread.getMessageThread() %></textarea>
			</p>

			<input type="hidden" id="idThread" name="idThread"
				value="<%=thread.getIdThread() %>" /> <input type="submit" value="Enviar" /> <input
				type="reset" value="Limpar" />
		</form>

		<p>
			<a href="">Voltar</a>
		</p>
	</div>

</body>
</html>