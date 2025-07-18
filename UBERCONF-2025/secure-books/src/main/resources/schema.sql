create table Book (
  id identity,
  isbn varchar(20) not null,
  title varchar(100) not null,
  author varchar(100) not null,
  reader varchar(100) not null
);