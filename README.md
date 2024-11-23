
# LiterAlura - Administración de Libros y Autores

Este proyecto es una aplicación de consola desarrollada en Java y Spring que consume una API pública para consultar libros disponibles en varios idiomas, años y autores. Permite buscar libros por título y almacenar tanto libros como autores en una base de datos PostgreSQL, lo que facilita la manipulación y consulta de la información guardada.



## Características

- **Consulta de Libros:** Utiliza la API para buscar libros electrónicos y devuelve una lista de títulos que coinciden con el nombre ingresado. Aunque se obtienen varios resultados, la aplicación retorna únicamente el primer libro encontrado. 
- **Persistencia de Datos:** El libro obtenido guarda información como título, autor, idioma y número de descargas. La entidad autor almacena su nombre, fecha de nacimiento y fallecimiento. Todos los datos se gestionan mediante JPA y una base de datos PostgreSQL, por lo que las dependencias están orientadas a este gestor. 
- **Manipulacion de datos:** Una vez almacenados, los datos pueden listarse y realizarse consultas personalizadas, como filtrar autores vivos en un rango de tiempo específico o listar libros por idioma.
- **Gestión de duplicados:** a estructura de la base de datos impide la duplicación de libros con el mismo ID, ya que este se obtiene directamente de la API. Tampoco se permiten autores con el mismo nombre, garantizando la integridad y normalización de los datos.


## Referencia de la API

#### API Gutendex

Es una API web JSON para metadatos de libros electrónicos del Proyecto Gutenberg. Permite consultar libros de forma rápida y sencilla sin necesidad de una API key. Aunque ofrece varias funcionalidades, en este proyecto se utiliza únicamente la búsqueda de títulos.
 

#### Obtener libro segun titulo

```http
GET https://gutendex.com/books/?search=
```

| Parameter | Type     | Descripcion                |
| :-------- | :------- | :------------------------- |
| `/books` | `string` | **Required**. Catálogo de Libros devueltos|

| Parameter | Type     | Descripcion                |
| :-------- | :------- | :------------------------- |
| `/search=` | `string` |**Required**. Para Buscar el Título Deseado |

| Parameter | Type     | Descripcion                |
| :-------- | :------- | :------------------------- |
| `%20` | `string` | Formato de URL codificado para espacio |


## Uso/Ejemplos
#### Buscar El título *"Don Quijote"*
```http
GET https://gutendex.com/books/?search=don%20quijote
```
#### Primera respuesta esperada
```json
 "results": [
        {
            "id": 2000,
            "title": "Don Quijote",
            "authors": [
                {
                    "name": "Cervantes Saavedra, Miguel de",
                    "birth_year": 1547,
                    "death_year": 1616
                }
            ],
            "translators": [],
            "subjects": [
                "Knights and knighthood -- Spain -- Fiction",
                "Picaresque literature",
                "Romances",
                "Spain -- Social life and customs -- 16th century -- Fiction"
            ],
            "bookshelves": [
                "6 Best Loved Spanish Literary Classics",
                "Best Books Ever Listings",
                "Browsing: Culture/Civilization/Society",
                "Browsing: Fiction",
                "Browsing: Literature",
                "Harvard Classics"
            ],
            "languages": [
                "es"
            ],
            "copyright": false,
            "media_type": "Text",
            "formats": {
                "text/html": "https://www.gutenberg.org/ebooks/2000.html.images",
                "text/html; charset=utf-8": "https://www.gutenberg.org/files/2000/2000-h/2000-h.htm",
                "application/epub+zip": "https://www.gutenberg.org/ebooks/2000.epub3.images",
                "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/2000.kf8.images",
                "text/plain; charset=utf-8": "https://www.gutenberg.org/files/2000/2000-0.txt",
                "application/rdf+xml": "https://www.gutenberg.org/ebooks/2000.rdf",
                "image/jpeg": "https://www.gutenberg.org/cache/epub/2000/pg2000.cover.medium.jpg",
                "application/octet-stream": "https://www.gutenberg.org/cache/epub/2000/pg2000-h.zip",
                "text/plain; charset=us-ascii": "https://www.gutenberg.org/ebooks/2000.txt.utf-8"
            },
            "download_count": 12877
        },
```



## Ejecución del proyecto

Para ejecutar el proyecto, es necesario realizar configuraciones en el archivo `application.properties`, ubicado en la carpeta resources, que preferiblemente deben ser las siguientes:

```bash
spring.application.name = LiterAlura
spring.datasource.url = jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username = ${DB_USER}
spring.datasource.password = ${DB_PASSWORD}
spring.datasource.driver-class-name = org.postgresql.Driver
hibernate.dialect = org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto = update
spring.jpa.show-sql = true
spring.jpa.format--sql= true
```
    
## Variables de Entorno

Para ejecutar este proyecto, es necesario configurar las siguientes variables de entorno, utilizadas para garantizar la seguridad del mismo:

**`DB_HOST`:** Servidor donde se ejecutará el datasource del proyecto. 

**`DB_NAME`:** Nombre de la base de datos a utilizar.

**`DB_USER`:** Usuario para autenticar en PostgreSQL.

**`DB_PASSWORD`:** Contraseña para autenticar el usuario.

## Componentes y Documentación

 - [JDK 23](https://docs.oracle.com/en/java/javase/23/)
  - [Spring Framework](https://spring.io/)
 - [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.18.1)
 - [Gutendex](https://gutendex.com/)


## Autor

- [@DevLuis](https://github.com/info-luisdev)


## Licencia

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


