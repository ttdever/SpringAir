-- liquibase formatted sql
-- changeset imelnykov:13

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (1, 2, '2023-05-05 12:00:00', '2023-05-05 13:00:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (2, 3, '2023-05-06 14:00:00', '2023-05-06 15:00:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (3, 4, '2023-05-07 12:00:00', '2023-05-07 13:00:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (5, 6, '2023-05-08 23:30:00', '2023-05-09 01:30:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (6, 7, '2023-06-01 12:30:00', '2023-06-01 13:30:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (7, 8, '2023-06-02 12:30:00', '2023-06-02 13:30:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (8, 9, '2023-06-02 12:30:00', '2023-06-02 13:30:00');

INSERT INTO destination(from_id, to_id, departure_time, arrival_time)
VALUES (9, 10, '2023-06-03 08:00:00', '2023-06-03 10:30:00');
