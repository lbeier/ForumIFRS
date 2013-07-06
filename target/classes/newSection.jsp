<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<p>
			<a href="index">Fórum</a>
		</p>
		<form action="" method="post">
			<p>
				<label for="titulo">Título da seção</label>
			</p>
			<p>
				<input type="text" id="titulo" name="titulo" />
			</p>
			<p>
				<label for="descricao">Descrição da seção</label>
			</p>
			<p>
				<textarea id="descricao" name="descricao"></textarea>
			</p>

			<input type="submit" value="Enviar" class="button" /> <input
				type="reset" value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>