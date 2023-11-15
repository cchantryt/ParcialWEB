# Proyecto de filtros Libros
## Backend usando Spring-boot

Este proyecto utiliza spring-boot para generar API Rest.

## Requisitos
- Java 11.0.16
- Mysql Data Base


## Instalacion

Para iniciar el proyecto debemos crear un esquema con el nombre de **demopersona** ademas de un usuario **pruebas** con contraseña **pruebas**.

El servicio corre en MySQL al tener problemas con SQLServer

Estas propiedades las podemos cambiar en **application.properties**

	server.port=8080
	server.servlet.context-path=/api
	spring.datasource.url=jdbc:mysql://localhost:3306/demopersona?serverTimezone=America/Guayaquil
	spring.datasource.username=pruebas
	spring.datasource.password=pruebas
	spring.jpa.hibernate.ddl-auto=update


## Iniciar Proyecto

Nos dirigimos a la raiz del proyecto y en la terminal ejecutamos 
```sh
mvnw.cmd spring-boot:run
```
Nuestro proyecto se ejecutara y podremos comprobar nuestras APIs con la documentacion de Swagger
http://localhost:8080/api/swagger-ui/index.html#/

Aqui podemos observar que tenemos un servicio
http://localhost:8080/api/book/create

Nos permitira crear cuatro objetos para probar nuestro micro servicio.

Complementario a este proyecto se encuentra el cliente Angular en el repositorio:
https://github.com/psidrovo/angular-frontend-book.git

## Autor

Paul Sebastian Idrovo Berrezueta

Email:
pidrovob@ieee.org
paulsidrovob@gmail.com
