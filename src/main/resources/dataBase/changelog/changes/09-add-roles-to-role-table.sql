-- liquibase formatted sql
-- changeset imelnykov:9
INSERT INTO role(role_name)
VALUES ('ROLE_USER');

INSERT INTO role(role_name)
VALUES ('ROLE_MODERATOR');

INSERT INTO role(role_name)
VALUES ('ROLE_ADMIN');