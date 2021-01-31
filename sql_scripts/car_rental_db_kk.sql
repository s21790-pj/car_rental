DROP DATABASE IF EXISTS car_rental_db_kk;

CREATE DATABASE IF NOT EXISTS car_rental_db_kk;
USE car_rental_db_kk;

--
-- Table structure for table customer
--

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id         int(11)     NOT NULL AUTO_INCREMENT,
    username   varchar(50) NOT NULL,
    password   char(80)    NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    email      varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

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
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');


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

DROP TABLE IF EXISTS car;

CREATE TABLE car
(
    id                 int(11)     NOT NULL AUTO_INCREMENT,
    brand              varchar(50) NOT NULL,
    model              varchar(50) NOT NULL,
    manufacture_year   char(4)     NOT NULL,
    motor              varchar(50) NOT NULL,
    gearbox            varchar(50) NOT NULL,
    body_configuration varchar(50) NOT NULL,
    color              varchar(50) NOT NULL,
    PRIMARY KEY (id)
);


















