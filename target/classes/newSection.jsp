<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form action="" method="post">
			<p>
				<label for="titulo">Título da seção</label>
			</p>
			<p>
				<input type="text" id="titulo" name="titulo" class="notNull"/>
			</p>
			<p>
				<label for="descricao">Descrição da seção</label>
			</p>
			<p>
				<textarea id="descricao" name="descricao" class="notNull"></textarea>
			</p>

			<input type="submit" value="Enviar" class="button" /> <input
				type="reset" value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>