create table Book(
    id identity,
    isbn varchar(13) not null,
    title varchar(255) not null,
    author varchar(255) not null,
    reader varchar(255) not null
);