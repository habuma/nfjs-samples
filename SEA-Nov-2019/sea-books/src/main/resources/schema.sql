drop table if exists Book;
create table Book (

    id identity,
    isbn varchar(10) not null,
    title varchar(200) not null,
    author varchar(100) not null

);