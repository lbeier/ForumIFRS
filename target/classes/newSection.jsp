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
		<form action="" method="post">
			<p>
				<input type="text" id="titulo" name="titulo"
					placeholder="Insira o título da seção" />
			</p>

			<p>
				<textarea id="descricao" name="descricao"
					placeholder="Insira a descrição da seção"></textarea>
			</p>

			<input type="submit" value="Enviar" /> <input type="reset"
				value="Limpar" />
		</form>

		<p>
			<a href="index.html">Voltar</a>
		</p>
	</div>
</body>
</html>