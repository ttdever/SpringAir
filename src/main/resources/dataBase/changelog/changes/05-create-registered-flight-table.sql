-- liquibase formatted sql
-- changeset imelnykov:5
create table registered_flight (
    id int primary key auto_increment,
    user_id int not null,
    destination_id int not null
);
