create table person (
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

insert into person (id, name, location, birth_date) values (10001, 'David Ferreira', 'Porto', CURRENT_DATE);
insert into person (id, name, location, birth_date) values (10002, 'Paula Santos', 'Porto', CURRENT_DATE);
insert into person (id, name, location, birth_date) values (10003, 'Matheus Souza', 'LP City', CURRENT_DATE);
insert into person (id, name, location, birth_date) values (10004, 'Luiza Souza', 'Cana City', CURRENT_DATE);
insert into person (id, name, location, birth_date) values (10005, 'Jorge Pixuleco', 'Lordelo Douro', CURRENT_DATE);