-- liquibase formatted sql
-- changeset imelnykov:1
create table user (
    id int primary key auto_increment,
    role_id int not null,
    passport_id int unique not null,
    country_id int not null,
    contact_id int unique not null
);
