# ForoHub
Descripción
ForoHub es una aplicación backend desarrollada con Spring Boot que permite la gestión de tópicos y usuarios. Incluye autenticación y autorización mediante Spring Security, con contraseñas almacenadas usando BCrypt.

## Tecnologías
• Java 17+

• Spring Boot 3.5.4

• Spring Security

• Spring Data JPA

• Hibernate

• Base de datos MySQL

• Maven

## Características principales
• CRUD de tópicos con paginación y filtros

• Gestión de usuarios con roles y seguridad

• Autenticación JWT

• Contraseñas seguras con encriptación BCrypt

• API REST con validación de datos

## Requisitos
• Java 17 o superior instalado

• Base de datos MySQL

• Maven

## Endpoints principales
`POST /login` - Autenticación de usuario

`GET /topicos` - Listar tópicos con paginación

`GET /topicos/{id}` - Obtener tópico por ID

`POST /topicos` - Crear un nuevo tópico

`PUT /topicos` - Actualizar tópico

`DELETE /topicos/{id}` - Eliminar tópico
> Nota: No es un Hard Delete, solo se esta desactivando su status.

## METODOS EN INSOMNIA
```javascript
LOGIN

{
	"login":"usuario a colocar",
	"contrasena":"contrasena del usuario"
}

CREACION DE TOPICOS

{
	"titulo":"titulo del topico",
	"mensaje":"mensaje del topico",
	"fecha_de_creacion":"fecha de creacion del topico",
	"autor":"autor del topico",
	"curso":"curso del topico"
}

ACTUALIZAR TOPICO

{
	"id": id que se desea eliminar,
  "titulo": "titulo que deseas cambiar",
  "mensaje": "mensaje que deseas cambiar",
	"curso": "curso que deseas cambiar",

}

```

## Seguridad
• Las contraseñas se almacenan cifradas con BCrypt.

• Spring Security está configurado para usar autenticación sin estado (stateless) y tokens JWT.

• Solo "/login" está disponible sin autenticación, el resto requiere token válido.

# AUTOR

FRANK GERAL CALIXTO TORRES
