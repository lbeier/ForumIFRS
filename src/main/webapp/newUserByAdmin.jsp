<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo usuário</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<form action="" method="post">
			<p>
				<input type="text" name="login" id="login"
					placeholder="Insira seu login" />
			</p>
			<p>
				<input type="password" name="senha" id="senha"
					placeholder="Insira sua senha" />
			</p>
			<p>
				<input type="password" name="senhaConfirma" id="senhaConfirma"
					placeholder="Insira sua senha novamente" />
			</p>

			<p>
				<input type="radio" name="tipo" value="true">Administrador
			</p>
			<p>
				<input type="radio" name="tipo" value="false">Normal
			</p>

			<input type="submit" value="Criar usuario" /> <input type="reset"
				value="Limpar" />
		</form>

		<p>
			<a href="index.html">Voltar</a>
		</p>
	</div>
</body>
</html>