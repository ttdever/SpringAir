-- liquibase formatted sql
-- changeset imelnykov:8
create table country (
    id int primary key auto_increment,
    country_name varchar(100) not null,
    in_schengen bool not null
);
