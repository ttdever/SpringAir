-- liquibase formatted sql
-- changeset imelnykov:4
create table destination (
    id int primary key auto_increment,
    from_id int not null,
    to_id int not null,
    departure_time datetime not null,
    arrival_time datetime not null
);
