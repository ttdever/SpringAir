-- liquibase formatted sql
-- changeset imelnykov:18

update user set
password = '$2a$12$jWWxpFLzRBRYRGBwLRsFoeTcXY198ujIMv6Ciw4MDGgkAjYJn7oZK',
account_non_expired = 1,
account_non_locked = 1,
credentials_non_expired = 1,
enabled = 1
where id between 1 and 5;