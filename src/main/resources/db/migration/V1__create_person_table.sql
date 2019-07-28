CREATE TABLE IF NOT EXISTS person (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age int NOT NULL,
    date_of_birth timestamp

);
INSERT INTO person VALUES (1, 'Federico', 'von Wernich', 29, '1990-06-03');