<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div id="conteiner" style="margin: auto; width: 500px;">
		<div id="content" style="padding: 0px; margin: auto; width: 500px;">
			<form action="login" method="post">
				<p>
					<label for="loginUser">Login</label> 
				</p>
				<p>
					<input type="text" name="loginUser" id="loginUser" style="width: 300px;"/>
				</p>
				<p>
					<label for="passwordUser">Senha</label> 
				</p>
				<p>
					<input type="password" name="passwordUser" id="passwordUser" style="width: 300px;"/>
				</p>

				<input type="submit" value="Login" class="button" /> <input type="reset"
					value="Limpar" class="button" />
			</form>
		</div>
	</div>
</body>
</html>
