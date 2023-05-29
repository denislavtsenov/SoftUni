CREATE DATABASE `minions`;
USE `minions`;

-- 1. Create Tables

CREATE TABLE `minions`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50),
`age` INT,
PRIMARY KEY (id)
);

CREATE TABLE `towns`(
`town_id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50),
PRIMARY KEY (town_id)
);


-- 2. Alter Minions Table

ALTER TABLE `towns`
CHANGE COLUMN `town_id`
`id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL;

ALTER TABLE `minions`
ADD CONSTRAINT
FOREIGN KEY (town_id)
REFERENCES towns(id);


-- 3. Insert Records in Both Tables

SELECT * FROM `minions`;

INSERT INTO `towns` (`id`, `name`)
VALUES (1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO `minions` (`id`, `name`,`age`, `town_id`)
VALUES (1, 'Kevin',22, 1),
 (2, 'Bob', 15, 3),
 (3, 'Steward', NULL, 2);
 
 
 -- 4. Truncate Table Minions
 
 TRUNCATE TABLE `minions`;


-- 5. Drop All Tables

DROP TABLE `minions`;
DROP TABLE `towns`;


-- 6. Create Table People

SELECT * FROM `people`;

CREATE TABLE `people`(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(10, 2),
`weight` DOUBLE(10, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT,
PRIMARY KEY(id)
);

INSERT INTO `people`(`name`, `gender`, `birthdate`)
VALUES('Pesho', 'f', DATE(NOW())),
('Gosho', 'm', DATE(NOW())),
('Tosho', 'f', DATE(NOW())),
('Misho', 'm', DATE(NOW())),
('Visho', 'f', DATE(NOW()));


-- 7. Create Table Users

SELECT * FROM `users`;

CREATE TABLE `users`(
`id` INT AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN,
PRIMARY KEY (id)
);

INSERT INTO `users`(`username`, `password`)
VALUES('gosho','gosho123'),
('tosho','tosho123'),
('misho','misho123'),
('desho','desho123'),
('resho','resho123');


-- 8. Change Primary Key

SELECT * FROM `users`;

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY users(id, username);


-- 9. Set Default Value of a Field

ALTER TABLE `users`
CHANGE COLUMN `last_login_time`
`last_login_time` DATETIME DEFAULT CURRENT_TIMESTAMP;


-- 10. Set Unique Field

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY users(id),
CHANGE COLUMN `username`
`username` VARCHAR(30) UNIQUE;


-- 11. Movies Database

CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors`(
`id` INT AUTO_INCREMENT,
`director_name` VARCHAR(100) NOT NULL,
`notes` TEXT,
PRIMARY KEY(id)
);

CREATE TABLE `genres`(
`id` INT AUTO_INCREMENT,
`genre_name` VARCHAR(100) NOT NULL,
`notes` TEXT,
PRIMARY KEY(id)
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT,
`category_name` VARCHAR(100) NOT NULL,
`notes` TEXT,
PRIMARY KEY(id)
);

CREATE TABLE `movies`(
`id` INT AUTO_INCREMENT, 
`title` VARCHAR(100) NOT NULL, 
`director_id` INT, 
`copyright_year` DATE, 
`length` INT, 
`genre_id` INT, 
`category_id` INT(100), 
`rating` DOUBLE(2,2), 
`notes` TEXT,
PRIMARY KEY(id)
);

INSERT INTO `directors`(`director_name`)
VALUES ('Gosho'),
 ('Pesho'),
 ('Tosho'),
 ('Ivan'),
 ('Dragan');
 
 
 INSERT INTO `genres`(`genre_name`)
 VALUES('Funny'),
 ('Comedy'),
 ('Action'),
 ('Erotic'),
 ('Drama');
 
 INSERT INTO `categories`(`category_name`)
 VALUES ('test'),
  ('test1'),
  ('test2'),
  ('test3'),
  ('test4');
  
  INSERT INTO `movies`(`title`)
  VALUES ('It'),
   ('It 2'),
   ('3MSC'),
   ('3MSC 2'),
   ('Alf');
 
 SELECT * FROM `movies`;
 
 
 -- 12. Car Rental Database
 
 CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
id INT PRIMARY KEY AUTO_INCREMENT, 
category VARCHAR(50), 
daily_rate DECIMAL(5,2), 
weekly_rate DECIMAL (5,2), 
monthly_rate DECIMAL(5,2),
weekend_rate DECIMAL(5,2)
);

INSERT INTO `categories`(`category`)
VALUES ('Van'), ('Jeep'), ('Car');

CREATE TABLE `cars` (
id INT PRIMARY KEY AUTO_INCREMENT, 
plate_number INT, 
make VARCHAR(20), 
model VARCHAR(20), 
car_year DATE, 
category_id INT, 
doors INT, 
picture BLOB, 
car_condition VARCHAR(200),
available BOOLEAN
);

INSERT INTO `cars` (`make`, `model`)
VALUES ('VW', 'GOLF'),
 ('VW', 'GOLF'),
 ('VW', 'GOLF');

CREATE TABLE `employees` (
id INT PRIMARY KEY AUTO_INCREMENT, 
first_name VARCHAR(50) NOT NULL, 
last_name VARCHAR(50) NOT NULL, 
title VARCHAR(100), 
notes VARCHAR(250)
);

INSERT INTO `employees`(`first_name`, `last_name`)
VALUES ('Gosho', 'Goshov'),
 ('Gosho', 'Goshov'),
 ('Gosho', 'Goshov');

CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`driver_licence_number` INT, 
`full_name` VARCHAR(100) NOT NULL, 
`address` VARCHAR(300), 
`city` VARCHAR(200) NOT NULL, 
`zip_code` INT, 
`notes` VARCHAR(500)
);

INSERT INTO `customers`(`full_name`, `city`)
VALUES ('Gosho Peshov', 'Krivodol'),
 ('Gosho Peshov', 'Krivodol'),
 ('Gosho Peshov', 'Krivodol');
 
 CREATE TABLE `rental_orders` (
 `id` INT PRIMARY KEY AUTO_INCREMENT, 
 `employee_id` INT, 
 `customer_id`INT, 
 `car_id` INT, 
 `car_condition` VARCHAR(10), 
 `tank_level` INT,
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date` DATE, 
`end_date` DATE,
`total_days` INT, 
`rate_applied` DECIMAL(4,2), 
`tax_rate` DECIMAL(10,2), 
`order_status` VARCHAR(10), 
`notes` TEXT
);

INSERT INTO `rental_orders`(`employee_id`, `car_id`)
VALUES (1, 2),
 (1, 2),
 (1, 2);

-- 13 Basic Insert

CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE `addresses`(
`id` INT AUTO_INCREMENT,
`address_text` VARCHAR(100),
`town_id` INT,
PRIMARY KEY (id)
);

CREATE TABLE departments (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50),
PRIMARY KEY (id)
);

CREATE TABLE employees (
`id` INT AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`job_title` VARCHAR(100),
`department_id` INT NOT NULL,
`hire_date` DATE,
`salary` DOUBLE(7,2),
`address_id` INT NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `towns`(`name`)
VALUES ('Sofia'),
 ('Plovdiv'),
 ('Varna'),
 ('Burgas');
 
 INSERT INTO `addresses` (`address_text`, `town_id`)
 VALUES ('Joro 1', 1),
  ('Joro 2', 2),
  ('Joro 3', 3),
  ('Joro 4', 4);
  
  INSERT INTO `departments`(`name`)
  VALUES('Engineering'),
  ('Sales'),
  ('Marketing'),
  ('Software Development'),
  ('Quality Assurance');
  
  INSERT INTO `employees`(`first_name`,`middle_name`,`last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
  VALUES('Ivan','Ivanov','Ivanov','.NET Developer', 4, DATE '2013-02-01', '3500.00'),
  ('Petar','Petrov','Petrov','Senior Engineer', 1, DATE '2004-03-02', '4000.00'),
  ('Maria','Petrova','Ivanova','Intern', 5, DATE '2016-08-28', '525.25'),
  ('Georgi','Terziev','Ivanov','CEO', 2, DATE '2007-12-09', '3000.00'),
  ('Peter','Pan','Pan','Intern', 3, DATE '2016-08-28', '599.88');
  
  
  -- 14. Basic Select All Fields
  
  SELECT * FROM `towns`;
  SELECT * FROM `departments`;
  SELECT * FROM `employees`;
  
  
  -- 15. Basic Select All Fields and Order Them
  
  SELECT * FROM `towns`
  ORDER BY `name`;
  
  SELECT * FROM `departments`
  ORDER BY `name`;
  
  SELECT * FROM `employees`
  ORDER BY `salary` DESC;
  
  
  -- 16. Basic Select Some Fields
  
  SELECT `name` 
  FROM `towns`
  ORDER BY `name`;
  
  SELECT `name` 
  FROM `departments`
  ORDER BY `name`;
  
  SELECT `first_name`, `last_name`, `job_title`, `salary` 
  FROM `employees`
  ORDER BY `salary` DESC;
  
  
  -- 17. Increase Employees Salary
  
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;
  
