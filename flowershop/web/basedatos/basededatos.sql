drop database jamaica;
create database jamaica;

use jamaica;

create table cliente(
	cliente_num int NOT NULL AUTO_INCREMENT,
	nombre varchar(70) NOT NULL, 
	email varchar(60) NOT NULL UNIQUE,
	password varchar(20) NOT NULL,
	fecha_ingreso date NOT NULL,
	telefono char(10) NOT NULL, 
	mobile char(10), 
	PRIMARY KEY (cliente_num)
);

create table producto(
	prod_num char(15) NOT NULL, 
	nombre varchar(45) NOT NULL,
	dsc varchar(100) NOT NULL,
	fecha_creacion date NOT NULL,
	piezas int NOT NULL DEFAULT 0,
	estatus char(1) NOT NULL DEFAULT 'A',
	precio FLOAT(10, 2) NOT NULL DEFAULT 0.0,
	iva FLOAT(5, 2) NOT NULL DEFAULT 0.16,
	PRIMARY KEY(prod_num)
);
create index producto_nombre on producto(nombre);

create table imagen(
	prod_num char(15) NOT NULL,
	img_num int NOT NULL,
	url longblob NOT NULL,
	FOREIGN KEY(prod_num) REFERENCES producto(prod_num),
	PRIMARY KEY(prod_num, img_num)
);

create table direccion(
	cliente_num int NOT NULL,
	dir_num int NOT NULL,
	calle varchar(75) NOT NULL,
	colonia varchar(30) NOT NULL,
	cod_pos char(6) NOT NULL,
	ciudad varchar(25) NOT NULL,
	estado varchar(25) NOT NULL,
	contacto varchar(50) NOT NULL,
	telefono char(10) NOT NULL,
	dsc varchar(250) NOT NULL,
	FOREIGN KEY(cliente_num) REFERENCES cliente(cliente_num),
	PRIMARY KEY(cliente_num, dir_num)
);

create table categoria(
	cate_num char(15) NOT NULL,
	nombre varchar(50) NOT NULL,
	dsc varchar(100) NOT NULL,
	estatus char(1) NOT NULL DEFAULT 'A',
	fecha_creacion date NOT NULL,
	PRIMARY KEY(cate_num)
);

create table catalogo(
	cate_num char(15) NOT NULL,
	prod_num char(15) NOT NULL,
	FOREIGN KEY(cate_num) REFERENCES categoria(cate_num),
	FOREIGN KEY(prod_num) REFERENCES producto(prod_num),
	PRIMARY KEY(cate_num, prod_num)
);

create table pedido(
	pedido_num int NOT NULL AUTO_INCREMENT,
	cliente_num int NOT NULL,
	dir_num int NOT NULL, 
	estatus char(1) NOT NULL DEFAULT 'R',
	estatus_envio char(1) NOT NULL DEFAULT 'A',
	fecha_pedido date NOT NULL,
	fecha_entrega date NOT NULL,
	tipo char(10) NOT NULL DEFAULT 'normal',
	total FLOAT(10, 2) NOT NULL DEFAULT 0.00,
	iva FLOAT(8,2) NOT NULL DEFAULT 0.00,
	FOREIGN KEY(cliente_num, dir_num) REFERENCES direccion(cliente_num, dir_num),
	PRIMARY KEY(pedido_num)
);

create table pedido_detalle(
	pedido_num int NOT NULL,
	prod_num char(15) NOT NULL,
	piezas int NOT NULL,
	precio FLOAT(7,2) NOT NULL,
	iva FLOAT(5,2) NOT NULL,
	FOREIGN KEY(pedido_num) REFERENCES pedido(pedido_num),
	FOREIGN KEY(prod_num) REFERENCES producto(prod_num),
	PRIMARY KEY(pedido_num, prod_num)
);

create table empleado(
	empleado_num int NOT NULL AUTO_INCREMENT,
	nombre varchar(70) NOT NULL, 
	email varchar(60) NOT NULL UNIQUE,
	password varchar(20) NOT NULL,
	fecha_ingreso date NOT NULL,
	telefono char(10) NOT NULL, 
	mobile char(11) NOT NULL,
	estatus char(1) NOT NULL DEFAULT 'A',
	rol char(1) NOT NULL DEFAULT 'V',
	PRIMARY KEY (empleado_num)
);

create table ruta(
	empleado_num int NOT NULL,
	pedido_num int NOT NULL,
	estatus char(1) NOT NULL DEFAULT 'P',
	latitud varchar(20) NOT NULL DEFAULT '0.0',
	longitud varchar(20) NOT NULL DEFAULT '0.0',
	FOREIGN KEY(empleado_num) REFERENCES empleado(empleado_num),
	FOREIGN KEY(pedido_num) REFERENCES pedido(pedido_num),
	PRIMARY KEY(empleado_num, pedido_num)
);