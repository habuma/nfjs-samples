create table food_truck (
	id identity,
	name varchar(100) not null,
	category varchar(15) not null
);

create table food_truck_event (
	id identity,
	name varchar(100) not null,
	food_truck_id number not null
);

alter table food_truck_event add foreign key (food_truck_id) 
	references public.food_truck(id);
