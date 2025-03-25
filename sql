DROP DATABASE if EXISTS quiz1;
CREATE DATABASE if not exists quiz1;
USE quiz1;
DROP TABLE if EXISTS usuario;
CREATE TABLE if NOT exists usuario(
id INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT primary KEY,
contraseña VARCHAR(250),
nombre VARCHAR(40),
email VARCHAR(30)
);

 DROP TABLE if EXISTS motocicleta;
CREATE TABLE if NOT exists motocicleta(
id VARCHAR(10)  NOT NULL   primary KEY,
marca VARCHAR(20),
cilindraje INT(7) UNSIGNED,
precio FLOAT(10) UNSIGNED,
color VARCHAR(20)
);
