DROP
DATABASE IF EXISTS car_rental_db_kk;

CREATE
DATABASE IF NOT EXISTS car_rental_db_kk;
USE
car_rental_db_kk;

--
-- Table structure for table customer
--

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id         int(11) NOT NULL AUTO_INCREMENT,
    username   varchar(50) NOT NULL,
    password   char(80)    NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    email      varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO user(username, password, first_name, last_name, email)
VALUES ('heksa', '$2a$10$KQr4Q1KUygptEtkaMUMmVuuVTSEIFsHkSdDw1R0zsnH9mul0Tpe0e', 'Heksa', 'TheDog', 'heksa@dog.com'),
       ('kamil', '$2a$10$KQr4Q1KUygptEtkaMUMmVuuVTSEIFsHkSdDw1R0zsnH9mul0Tpe0e', 'Kamil', 'Smith', 'kamil@gmail.com'),
       ('pawel', '$2a$10$KQr4Q1KUygptEtkaMUMmVuuVTSEIFsHkSdDw1R0zsnH9mul0Tpe0e', 'Paweł', 'Brick', 'pawel@gmail.com'),
       ('marian', '$2a$10$KQr4Q1KUygptEtkaMUMmVuuVTSEIFsHkSdDw1R0zsnH9mul0Tpe0e', 'Jakub', 'Butter',
        'marian@gmail.com');

--
-- Table structure for table role
--

DROP TABLE IF EXISTS role;

CREATE TABLE role
(
    id   int(11) NOT NULL AUTO_INCREMENT,
    name varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

INSERT INTO role (name)
VALUES ('ROLE_CUSTOMER'),
       ('ROLE_MANAGER');

--
-- Table structure for table users_roles
--

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles
(
    user_id int(11) NOT NULL,
    role_id int(11) NOT NULL,

    PRIMARY KEY (user_id, role_id),

    FOREIGN KEY (user_id) REFERENCES user (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    FOREIGN KEY (role_id) REFERENCES role (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO users_roles(user_id, role_id)
VALUES (1, 2),
       (2, 1),
       (3, 1),
       (4, 1);

--
-- Table structure for table city
--
DROP TABLE IF EXISTS city;

CREATE TABLE city
(
    id        int(11) NOT NULL AUTO_INCREMENT,
    city_name varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO city(city_name)
VALUES ('Gdańsk'),
       ('Warszawa'),
       ('Olsztyn'),
       ('Zakopane');

--
-- Table structure for table car
--
DROP TABLE IF EXISTS car;

CREATE TABLE car
(
    id                 int(11) NOT NULL AUTO_INCREMENT,
    city_id            int(11) NOT NULL,
    brand              varchar(50) NOT NULL,
    model              varchar(50) NOT NULL,
    manufacture_year   char(4)     NOT NULL,
    motor              varchar(50) NOT NULL,
    gearbox            varchar(50) NOT NULL,
    body_configuration varchar(50) NOT NULL,
    color              varchar(50) NOT NULL,
    PRIMARY KEY (id),

    FOREIGN KEY (city_id) REFERENCES city (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO car(city_id, brand, model, manufacture_year, motor, gearbox, body_configuration, color)
VALUES (1, 'Audi', 'RS4', '2021', '2.9 TFSI', 'Automatic', 'Sedan', 'Blue'),
       (2, 'Audi', 'RS4', '2021', '2.9 TFSI', 'Automatic', 'Sedan', 'Silver'),
       (3, 'Audi', 'RS4', '2021', '2.9 TFSI', 'Automatic', 'Sedan', 'Red'),
       (1, 'BMW', 'G20', '2020', '340i xDrive', 'Automatic', 'Sedan', 'Black'),
       (2, 'BMW', 'G20', '2020', '340i xDrive', 'Automatic', 'Sedan', 'Silver'),
       (4, 'BMW', 'G20', '2020', '340i xDrive', 'Automatic', 'Sedan', 'Red'),
       (2, 'Alfa Romeo', 'Giulia', '2021', '2.9 V6 TwinTurbo', 'Automatic', 'Sedan', 'Blue'),
       (3, 'Alfa Romeo', 'Giulia', '2021', '2.9 V6 TwinTurbo', 'Automatic', 'Sedan', 'Silver'),
       (4, 'Alfa Romeo', 'Giulia', '2021', '2.9 V6 TwinTurbo', 'Automatic', 'Sedan', 'Red'),
       (1, 'Mercedes-Benz', 'W205', '2021', 'C63 AMG', 'Automatic', 'Sedan', 'White'),
       (2, 'Mercedes-Benz', 'W205', '2021', 'C63 AMG', 'Automatic', 'Sedan', 'Silver'),
       (3, 'Mercedes-Benz', 'W205', '2021', 'C63 AMG', 'Automatic', 'Sedan', 'Red'),
       (2, 'Volvo', 'S60', '2020', 'T6 polestar', 'Automatic', 'Sedan', 'Blue'),
       (3, 'Volvo', 'S60', '2020', 'T6 polestar', 'Automatic', 'Sedan', 'Silver'),
       (4, 'Volvo', 'S60', '2020', 'T6 polestar', 'Automatic', 'Sedan', 'Red');

--
-- Table structure for table rental
--

DROP TABLE IF EXISTS rental;

CREATE TABLE rental
(
    id         int(11) NOT NULL AUTO_INCREMENT,
    user_id    int(11) NOT NULL,
    car_id     int(11) NOT NULL,
    start_date varchar(50) NOT NULL,
    end_date   varchar(50) NOT NULL,

    PRIMARY KEY (id),

    FOREIGN KEY (user_id) REFERENCES user (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,

    FOREIGN KEY (car_id) REFERENCES car (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO rental(user_id, car_id, start_date, end_date)
VALUES (2, 2, '02-02-2020', '21-03-2020'),
       (3, 1, '23-07-2020', '11-08-2020'),
       (4, 4, '21-05-2020', '12-06-2020');





















