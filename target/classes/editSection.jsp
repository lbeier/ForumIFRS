<%@page import="Model.Section"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Section section = (Section) request.getAttribute("section");
	int idSection = section.getIdSection();
	String titleSection = section.getTitleSection();
%>
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
			::
			<a href="exibeSecao?id=<%=idSection%>">Seção: <%=titleSection%></a>
		</div>
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
	</div>
</body>
</html>