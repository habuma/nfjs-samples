drop table if exists Books;

create table Books (
	isbn varchar(10) not null,
	title varchar(200) not null,
	author varchar(100) not null
);