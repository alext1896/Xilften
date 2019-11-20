drop database if exists xilften_test;

create database xilften_test;

use xilften_test; 

drop table if exists generos;
drop table if exists series;

CREATE TABLE generos (
	idGenero int not null auto_increment,
	nombreGenero varchar (45) not null,
	descripcionGenero varchar (45) not null,	
    primary key (idGenero)
);

CREATE TABLE series (
	idSerie int not null auto_increment,
    nombreSerie varchar (45) not null,
    descripcionSerie varchar (45),
    idGenero int references generos (idGenero),
	primary key (idSerie)
);
