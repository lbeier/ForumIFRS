<%@page import="Model.Section"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Section section = (Section) request.getAttribute("section");
%>
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
				<label for="titleSection">Título da seção</label>
			</p>
			<p>
				<input type="text" id="titleSection" name="titleSection"
					value="<%=section.getTitleSection()%>" />
			</p>

			<p>
				<label for="descriptionSection">Descrição da seção</label>
			</p>
			<p>
				<textarea id="descriptionSection" name="descriptionSection"><%=section.getDescriptionSection()%></textarea>
			</p>

			<input type="hidden" id="idSection" name="idSection"
				value="<%=section.getIdSection()%>" /> <input type="submit"
				value="Enviar" class="button" /> <input type="reset" value="Limpar"
				class="button" />
		</form>

		<p>
			<a href="index.html">Voltar</a>
		</p>
	</div>
</body>
</html>