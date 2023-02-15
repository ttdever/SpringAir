-- liquibase formatted sql
-- changeset imelnykov:7
create table user (
    id int primary key auto_increment,
    role_id int not null,
    passport_id int unique not null,
    country_id int not null,
    contact_id int unique not null,
    foreign key (role_id) references role(id),
    foreign key (passport_id) references passport_information(id),
    foreign key (country_id) references country(id),
    foreign key (contact_id) references contact_information(id)
);
