create table flight (
    id identity,
    flight_number varchar(10) not null,
    origin varchar(3) not null,
    destination varchar(3) not null,
    departure_time timestamp not null
);