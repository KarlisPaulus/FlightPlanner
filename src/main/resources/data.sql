-- Predefined flights
INSERT INTO flight (id, destination, date, departure_time, arrival_time, price) VALUES (1, 'Tallinn', '2025-04-01', '19:40', '21:00', 150);
INSERT INTO flight (id, destination, date, departure_time, arrival_time, price) VALUES (2, 'London', '2025-04-02', '10:00', '12:00', 200);

-- Predefined seats for Flight 1
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (1, '1A', true);
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (1, '2B', false);
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (1, '3C', true);

-- Predefined seats for Flight 2
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (2, '21A', false);
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (2, '17B', true);
INSERT INTO seat (flight_id, seat_number, is_available) VALUES (2, '33C', true);
