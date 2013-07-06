Projeto para a cadeira de Java do IFRS.

Este projeto utiliza as seguintes tecnologias:

Maven: http://maven.apache.org/
Hibernate: http://www.hibernate.org/
LessCSS: http://lesscss.org/
CoffeeScript: http://coffeescript.org/
MySQL: http://www.mysql.com/
Tomcat: http://tomcat.apache.org/

Instalação:
1) Baixe ou clone o projeto.
2) Na pasta do projeto execute "mvn clean install".
3) Acesse o MySQL e crie um schema chamado "Forum".
	3.1) Configure o arquivo "persistence.xml" com os dados do MySQL.
4) Após isso execute o Tomcat e acesse o projeto pelo navegador.
5) Deverá ser exibida a tela de login. Clique em logar sem preencher nada. Desta forma o Hibernate criará as tabelas no banco de dados. Após isso a tela de login sera atualizada.
6) Acesse o MySQL, schema Forum e table User e adicione um usuário admin com os seguintes critérios:
	id	login	senha	type
	1	admin	admin	1
7) Execute o comando de insert.
8) Após isso é possível logar no Fórum com o usuário administrador.
