-- liquibase formatted sql
-- changeset imelnykov:7
create table role (
    id int primary key auto_increment,
    role_name varchar(25) unique not null
);
