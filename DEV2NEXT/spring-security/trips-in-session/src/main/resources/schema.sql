CREATE TABLE Trip (
    id SERIAL PRIMARY KEY,
    traveler VARCHAR(255) NOT NULL,
    origin VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    departure_date DATE NOT NULL,
    return_date DATE NOT NULL
);