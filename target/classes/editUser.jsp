<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo usuário</title>
</head>
<body>
	<div id="conteiner">
		<form action="" method="post">
			<p>
				Login do usuário:
				<%=user.getLoginUser()%>
			</p>
			<p>
				<label for="senhaAntiga">Senha antiga</label>
			</p>
			<p>
				<input type="password" name="senhaAntiga" id="senhaAntiga"
					placeholder="Insira sua senha antiga" value="" />
			</p>
			<p>
				<input type="password" name="senhaAntigaConfirma"
					id="senhaAntigaConfirma" placeholder="Repita sua senha antiga"
					value="" />
			</p>

			<p>
				<label for="senhaNova">Senha nova</label>
			</p>
			<p>
				<input type="password" name="senhaNova" id="senhaNova"
					placeholder="Insira sua nova senha" value="" />
			</p>
			<p>
				<input type="password" name="senhaNovaConfirma"
					id="senhaNovaConfirma" placeholder="Repita sua nova senha" value="" />
			</p>

			<input type="hidden" id="idUser" name="idUser"
				value="<%=user.getIdUser()%>" /> <input type="submit"
				value="Atualizar perfil" class="button" /> <input type="reset"
				value="Limpar" class="button" />
		</form>
	</div>
</body>
</html>