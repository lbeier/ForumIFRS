<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a href="index">F�rum</a>
		</div>
		<form action="" method="post">
			<p>
				<label for="login"> Login do usu�rio </label>
			</p>
			<p>
				<input type="text" name="login" id="login" />
			</p>

			<p>
				<label for="senha"> Senha do usu�rio </label>
			</p>
			<p>
				<input type="password" name="senha" id="senha" />
			</p>
			<p>
				<input type="password" name="senhaConfirma" id="senhaConfirma" />
			</p>

			<input type="submit" value="Criar usu�rio" class="button" /> <input
				type="reset" value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>
