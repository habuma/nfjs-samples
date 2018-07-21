drop table if exists books;
create table books (
	isbn varchar(10) not null,
	title varchar(100) not null,
	author varchar(100) not null
);