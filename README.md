# Quarkus
Desenvolver uma aplicação web responsiva para administrar alunos, professores e
cursos. Soluções parciais serão aceitas.

● Visão de administrador

○ Incluir, excluir, atualizar e visualizar usuários.

● Visão de coordenador de cursos

○ Incluir, excluir, atualizar e visualizar os semestres, cursos e disciplinas;

○ Realizar a montagem da matriz curricular.

● Visão de professor e aluno

○ Visualizar a matriz curricular.

Criação do sql
Definição das estrutura das tabelas e relacionamento.

application.properties
quarkus.hibernate-orm.sql-load-script=import.sql
quarkus.hibernate-orm.database.generation=update

Criação do Projeto inicial
https://code.quarkus.io/?g=tech.trimed&e=rest&e=hibernate-orm-panache&e=jdbc-mysql&e=rest-jackson&e=keycloak-admin-resteasy-cliente

Selected Extensions Clear
REST
STARTER-CODE
Hibernate ORM with Panache
STARTER-CODE
JDBC Driver - MySQL
REST Jackson
Keycloak Admin RESTEasy Client

Configuração:
Java: graalvm-jdk-21_windows-x64_bin 
Maven: apache-maven-3.9.9

