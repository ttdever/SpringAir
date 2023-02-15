-- liquibase formatted sql
-- changeset imelnykov:14

INSERT INTO passport_information(full_name, country_id, passport_number, expiration_date)
VALUES ('Illia Melnykov', 1, 'UA12345', '2025-01-01');

INSERT INTO passport_information(full_name, country_id, passport_number, expiration_date)
VALUES ('Grzegorz Brzęczyszczykiewicz', 2, 'PL12345', '1970-01-01');

INSERT INTO passport_information(full_name, country_id, passport_number, expiration_date)
VALUES ('Baron Von Munchausen', 3, 'DE12345', '2024-01-01');

INSERT INTO passport_information(full_name, country_id, passport_number, expiration_date)
VALUES ('Napoleon Bonaparte', 4, 'FR12345', '1821-05-05');

INSERT INTO passport_information(full_name, country_id, passport_number, expiration_date)
VALUES ('Winston Churchill', 5, 'GB12345', '2030-01-24');


