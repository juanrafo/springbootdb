CREATE DATABASE restapi;
USE restapi;
CREATE TABLE blog (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  content VARCHAR(5000) NOT NULL
);

CREATE TABLE Usuario (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  estado VARCHAR(500) NOT NULL,
  password VARCHAR(5000) NOT NULL,
  usuario VARCHAR(5000) NOT NULL
);

CREATE TABLE Book (
 id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 estado VARCHAR(500) NOT NULL,
 titulo VARCHAR(5000) NOT NULL,
 autor VARCHAR(5000) NOT NULL
);

insert into mysql.blog values (1,'prueba','prueba');
insert into mysql.usuario values (1,'activo','prueba','prueba');
insert into mysql.usuario values (2,'inactivo','prueba','prueba');
insert into mysql.book values (1,'activo','Don Quijote','Cervantes');
insert into mysql.book values (2,'activo','La Odisea','Homero');
insert into mysql.book values (3,'activo','Tradiciones Peruanas','Ricardo Palma');