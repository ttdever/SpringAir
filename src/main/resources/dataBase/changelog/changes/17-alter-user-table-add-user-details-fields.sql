-- liquibase formatted sql
-- changeset imelnykov:17

alter table user add column password varchar(255);
alter table user add column account_non_expired bool not null default false;
alter table user add column account_non_locked bool not null default false;
alter table user add column credentials_non_expired bool not null default false;
alter table user add column enabled bool not null default false;
