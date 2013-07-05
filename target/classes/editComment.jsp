<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="Model.Comment"%>
<%
	Comment comment = (Comment) request.getAttribute("comment");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo comentário</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<form action="" method="post">
			<p>
				<textarea id="messageComment" name="messageComment"
					placeholder="Insira a mensagem"><%=comment.getMessageComment() %></textarea>
			</p>

			<input type="hidden" id="idThread" name="idThread"
				value="<%=comment.getIdComment()%>" /> <input type="submit" value="Enviar" /> <input
				type="reset" value="Limpar" />
		</form>
	</div>
</body>
</html>