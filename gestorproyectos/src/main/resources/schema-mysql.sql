create table IF NOT EXISTS personas(
                         idunicpersona char(250) not null unique primary key,
                         dsnombre char(250) not null,
                         fenacimiento datetime null,
                         role char(250) null,
                         idproyecto char(250)
);

create table IF NOT EXISTS  proyectos(
                          idunicproyecto char(250) not null primary key,
                          dsproyecto char(250) not null,
                          descripcion char(250) null
);

create table IF NOT EXISTS usuarios(
                         idunicuser char(250) not null primary key,
                         user char(250) not null UNIQUE ,
                         password char(250) not null UNIQUE,
                         idpersona char(250) not null UNIQUE,
                         correo char(250) not null unique
);
