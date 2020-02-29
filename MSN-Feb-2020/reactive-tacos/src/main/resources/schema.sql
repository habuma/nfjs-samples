drop table if exists Taco;
create table Taco (

	id identity,
	name varchar(50) not null,
	wrap varchar(20) not null,
	filling varchar(20) not null

);