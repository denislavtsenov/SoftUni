CREATE DATABASE `gamebar`;
USE `gamebar`;

-- 1. Create Tables 

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE `products` (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL,
PRIMARY KEY (id)
);

-- 2. Insert Data in Tables

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 	('Pesho', 'Peshov'),
		('Tosho', 'Toshov'),
		('Gosho', 'Goshov');
        

-- 3. Alter Table

ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(50);

SELECT * FROM `employees`;


-- 4. Adding Constraints

ALTER TABLE `products` 
ADD CONSTRAINT `fk_products_categories`
FOREIGN KEY (category_id)
REFERENCES categories(id);


-- 5. Modifying Columns

ALTER TABLE `employees`
CHANGE COLUMN `middle_name` 
`middle_name` VARCHAR(100);