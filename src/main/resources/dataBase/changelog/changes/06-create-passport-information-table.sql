-- liquibase formatted sql
-- changeset imelnykov:6
create table passport_information (
    id int primary key auto_increment,
    full_name varchar(255) not null,
    passport_number varchar(20) not null,
    expiration_date datetime not null
);
