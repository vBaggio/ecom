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