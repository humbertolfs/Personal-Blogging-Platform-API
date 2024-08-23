# Personal Blogging Platform API
Java RESTful API for learning purposes.

## Habilidades e Tecnologias Utilizadas
- Java
- Spring Boot
- CRUD
- Banco de Dados (PostgreSQL e H2)
- Server-side RESTful API
- Railway

## Diagrama de Classes
```mermaid

classDiagram
    class BlogPost {
        +String title
        +Author author
        +Date publishDate
        +Date modifyDate
        +String content
        +int likes
    }
    class Author {
        +String name
        +String description
    }

    BlogPost "1..*" *--> "1" Author

```
