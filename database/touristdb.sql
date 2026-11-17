CREATE DATABASE IF NOT EXISTS touristdb;
USE touristdb;

CREATE TABLE IF NOT EXISTS tourists (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);

INSERT INTO tourists (name, country, email) VALUES
('Rahul', 'India', 'rahul@example.com'),
('Surya', 'India', 'surya@example.com'),
('John', 'United States', 'john@example.com');
