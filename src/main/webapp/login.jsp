<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="conteiner">
		<div id="content">
			<form action="login" method="post">
				<p>
					<label for="loginUser">Login</label> 
				</p>
				<p>
					<input type="text" name="loginUser" id="loginUser"/>
				</p>
				<p>
					<label for="passwordUser">Senha</label> 
				</p>
				<p>
					<input type="password" name="passwordUser" id="passwordUser"/>
				</p>

				<input type="submit" value="Login" class="button" /> <input type="reset"
					value="Limpar" class="button" />
			</form>
		</div>
	</div>
</body>
</html>
