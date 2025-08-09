create table topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo varchar(100) not null,
    mensaje TEXT not null,
    fecha_de_creacion DATE not null,
    status tinyint DEFAULT 1,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);