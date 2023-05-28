CREATE DATABASE `gamebar`;
USE `gamebar`;

CREATE TABLE `employees`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50),
`last_name` VARCHAR(50)
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE `products`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`category_id` INT,
PRIMARY KEY (id),
CONSTRAINT `fk_products_categories`
FOREIGN KEY (category_id) REFERENCES categories(id)
);

SELECT * FROM `employees`;

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES ('Pesho', 'Peshov'),
 ('Gosho', 'Goshov'),
('Tosho', 'Toshov'),
('Misho', 'Mishov');

SELECT * FROM `employees`;

DELETE FROM `employees`
WHERE `id` = 1;

DROP TABLE `employees`;

DROP DATABASE `gamebar`;