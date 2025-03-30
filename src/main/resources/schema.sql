CREATE TABLE flight (
    id INT PRIMARY KEY,
    destination VARCHAR(255),
    date DATE,
    departure_time TIME,
    arrival_time TIME,
    price DECIMAL(10, 2)
);

CREATE TABLE seat (
    flight_id INT,
    seat_number VARCHAR(4),
    is_available BOOLEAN,
    is_window BOOLEAN,
    is_extra_legroom BOOLEAN,
    is_close_to_exit BOOLEAN,
    FOREIGN KEY (flight_id) REFERENCES flight(id)
);