# 🛒 ecom – API de E-commerce com Spring Boot

Este projeto consiste em uma API RESTful para um sistema de e-commerce, desenvolvida com tecnologias modernas do ecossistema Spring, incluindo recursos de autenticação e autorização. A aplicação foi construída durante o curso **Java Spring Professional**, oferecido pela plataforma [DevSuperior](https://devsuperior.com.br/), aplicando na prática todos os conhecimentos adquiridos ao longo da formação.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **JWT Token / oAuth 2**
- **H2 Database**
- **MapStruct**
- **Maven**

## ⚙️ Como Executar Localmente

### Pré-requisitos
- Java 21
- Maven
### Passos
1)  Close o projeto:
```
git clone https://github.com/vBaggio/ecom.git
```
2) Execute o projeto:
```
./mvnw spring-boot:run
```

## 📐 Estrutura do Projeto

    src
    └── main
	    └── java
		    └── com.vbaggio.ecom
		        ├── configs       # Configurações (security, auth server, beans)
		        ├── controllers   # Endpoints REST
		        ├── dto           # Data Transfer Objects
		        ├── entities      # Entidades JPA
		        ├── mappers       # Diretrizes de mapeamento entre entity e dto
		        ├── repositories  # Repositorios JPA
		        ├── services      # Lógica de negócio
		        └── EcomApplication.java
	    └── resources
		    ├── application.properties # Configurações da aplicação
		    └── import.sql             # Seeding de dados com Hibernate

## 📦 Principais Endpoints 

- `POST   /oauth2/token   # Login (obter token JWT)`
- `GET    /products/{id}  # Dados do produto específico`
- `GET    /products       # Lista paginada de produtos`
- `POST   /products       # Inserir produto (admin)`
- `PUT    /products/{id}  # Atualizar dados produto (admin)`
- `DELETE /products       # Excluir produto (admin)`
- `GET    /orders/{id}    # Dados do pedido (admin e dono do pedido)`
- `POST   /orders         # Inserir pedido`
- `GET    /users/me       # Dados do usuário logado`

## 📄Roles

- Nesta aplicação existem as roles: `ADMIN` e `USER`;
- Usuários têm uma ou mais roles;
- Os endpoints de login, listagem de produtos e dados de produto específico são públicos;
- `USER` pode acessar os endpoints de inclusão de pedido, dados do pedido (apenas pedidos próprios) e dados do usuário logado;
- `ADMIN` pode acessar os endpoints de inclusão/alteração/exclusão de produtos e ver pedidos de outros usuários.

## 🔐 Autenticação

A autenticação é feita seguindo o protocolo **oAuth 2** + token **JWT**.

Para obter o token de acesso, deverá ser enviada uma requisição para o **endpoint de login**, fornecendo o seguinte **authorization header**:
```
Basic <{CLIENT_ID} + {CLIENT_SECRET} (Base64 encoded)>
```
*CLIENT_ID e CLIENT_SECRET são variáveis de ambiente, possuem valores padrão definidos no arquivo application.properties*

Além do seguinte **request body**, no formato **x-www-form-urlencoded**:
```
username: {USERNAME}
password: {PASSWORD}
grant_type: password
```
*USERNAME e PASSWORD são as informações de login do usuário, nesta aplicação existem 2 usuários previamente cadastrados que podem ser utilizados para teste:*
- maria@gmail.com | senha: 123456 | USER
- alex@gmail.com    | senha: 123456 | USER, ADMIN

Uma vez que o token de acesso foi obtido, os endpoints privados podem ser acessados passando o seguinte **authorization header**:
```
Bearer {TOKEN}
```

O Token tem duração de 24h, que pode ser alterada no arquivo application.properties.