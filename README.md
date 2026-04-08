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

Angular 19
npm start
Quarkus
mvn quarkus:dev

Criação do sql
Definição das estrutura das tabelas e relacionamento.

application.properties

quarkus.oidc.auth-server-url=http://localhost:8180/realms/quarkus
quarkus.oidc.client-id=backend-service
quarkus.oidc.credentials.secret=secret
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

keycloak
docker run -p 8543:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.1.3 start-dev
Create realm
developer

Client ID
app_universidade

Create role
user
manager
curso

User
user_universidade
Senha: users
admin_universidade
admins
curso_universidade
cursos

grant_type:password

Verificar aporta
http://localhost:59951/realms/developer/protocol/openid-connect/token

Modificando porta Aplicação Java
server:
port:8081

