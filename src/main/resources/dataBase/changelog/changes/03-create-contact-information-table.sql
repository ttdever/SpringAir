-- liquibase formatted sql
-- changeset imelnykov:3
create table contact_information (
    id int primary key auto_increment,
    phone_number varchar(15) unique not null,
    email varchar(255) unique not null,
    address varchar(255) unique not null
);
