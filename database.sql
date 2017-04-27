drop database jamaica;
create database jamaica;

use jamaica;

create table cliente(
  cliente_num int PRIMARY KEY,
  nombre varchar(60) NOT NULL,
  email varchar(70) NOT NULL,
  fecha_r DATE NOT NULL,
  primera_c DATE,
  ultima_c DATE,
  num_com int NOT NULL DEFAULT 0,
  total_com FLOAT(10,3) NOT NULL DEFAULT 0.0,
  clase char(1) NOT NULL DEFAULT 'D'
);

create index email_cliente on cliente(email);

create table dir_envio(
  cliente_num int,
  dir_num int,
  nombre varchar(15) NOT NULL,
  calle varchar(60) NOT NULL,
  colonia varchar(20) NOT NULL,
  cod_post char(5) NOT NULL,
  contacto varchar(30) NOT NULL,
  telefono varchar(20) NOT NULL,
  estatus char(1) NOT NULL DEFAULT 'A',
  observaciones varchar(100) NULL,
  PRIMARY KEY(cliente_num, dir_num),
  FOREIGN KEY(cliente_num) REFERENCES cliente(cliente_num)
);

create table producto(
  prod_num char(15) PRIMARY KEY,
  nombre varchar(20) UNIQUE NOT NULL,
  desc_p varchar(50) NOT NULL,
  fecha_c DATE NOT NULL,
  estatus char(1) NOT NULL DEFAULT 'A',
  image_1 BLOB NOT NULL,
  image_2 BLOB NOT NULL,
  image_3 BLOB NOT NULL,
  precio FLOAT(7,2) NOT NULL,
  iva FLOAT(3,2) NOT NULL,
  piezas int NOT NULL DEFAULT 0
);

create table producto_info(
  prod_num char(15),
  campo varchar(10),
  desc_c varchar(25) NOT NULL,
  PRIMARY KEY (prod_num, campo),
  FOREIGN KEY (prod_num) REFERENCES producto(prod_num)
);

create index campo_prod_info on producto_info(campo);

create table categoria (
  cate_num char(10) PRIMARY KEY,
  nombre varchar(15) UNIQUE NOT NULL,
  desc_c varchar(20) NOT NULL,
  estatus char(1) NOT NULL DEFAULT 'A',
  fecha_c DATE NOT NULL
);

create table catalogo (
  prod_num char(15),
  cate_num char(10),
  PRIMARY KEY(prod_num, cate_num),
  FOREIGN KEY(prod_num) REFERENCES producto(prod_num),
  FOREIGN KEY(cate_num) REFERENCES categoria(cate_num)
);

create table pedido_enc (
  pedido_num int PRIMARY KEY,
  cliente_num int NOT NULL,
  dir_num int NOT NULL,
  fecha DATE NOT NULL ,
  pedido_clase char(1) NOT NULL DEFAULT 'N',
  observaciones varchar(20) NULL,
  importe FLOAT(10,3) NOT NULL DEFAULT 0.0,
  iva FLOAT(8,2) NOT NULL DEFAULT 0.0,
  estatus char(1) NOT NULL DEFAULT 'R',
  est_envio char(1) NOT NULL DEFAULT 'E',
  tipo_entrega char(1) NOT NULL DEFAULT 'N',
  FOREIGN KEY(cliente_num, dir_num) REFERENCES dir_envio(cliente_num, dir_num)
);
create index cli_dir_pedido on pedido_enc(cliente_num, dir_num);
create index cliente_pedido on pedido_enc(cliente_num);

create table pedido_det(
  pedido_num int,
  prod_num char(15),
  cantidad int,
  precio FLOAT(7,2) NOT NULL,
  iva FLOAT(5,2) NOT NULL,
  PRIMARY KEY(pedido_num, prod_num),
  FOREIGN KEY(pedido_num) REFERENCES pedido_enc(pedido_num)
);
create index producto_pedido on pedido_det(prod_num);
