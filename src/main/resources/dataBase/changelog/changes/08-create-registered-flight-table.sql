-- liquibase formatted sql
-- changeset imelnykov:8
create table registered_flight (
    id int primary key auto_increment,
    user_id int not null,
    destination_id int not null,
    foreign key (user_id) references user(id),
    foreign key (destination_id) references destination(id)
);
