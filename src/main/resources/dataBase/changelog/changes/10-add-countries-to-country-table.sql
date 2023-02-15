-- liquibase formatted sql
-- changeset imelnykov:10

INSERT INTO country(country_name, in_schengen)
VALUES ('Ukraine', false);

INSERT INTO country(country_name, in_schengen)
VALUES ('Poland', true);

INSERT INTO country(country_name, in_schengen)
VALUES ('Germany', true);

INSERT INTO country(country_name, in_schengen)
VALUES ('France', true);

INSERT INTO country(country_name, in_schengen)
VALUES ('Great Brittan', false);