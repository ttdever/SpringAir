-- liquibase formatted sql
-- changeset imelnykov:2
create table airport (
    id int primary key auto_increment,
    country_id int,
    code_name varchar(10) unique not null
);
