CREATE DATABASE `softuni_stores_system`;
USE `softuni_stores_system`;

-- 01. Table Design

CREATE TABLE `pictures`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
`best_before` DATE,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
`picture_id` INT NOT NULL,
CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
CONSTRAINT fk_products_pictures
FOREIGN KEY (`picture_id`)
REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL UNIQUE,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT(1) DEFAULT FALSE,
`address_id` INT NOT NULL,
CONSTRAINT fk_stores_addresses
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT NOT NULL,
`store_id` INT NOT NULL,
CONSTRAINT pk
PRIMARY KEY (`product_id`, `store_id`),
CONSTRAINT fk_ps_products
FOREIGN KEY (`product_id`)
REFERENCES `products`(`id`),
CONSTRAINT fk_ps_stores
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`)
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) DEFAULT 0,
`hire_date` DATE NOT NULL,
`manager_id` INT,
`store_id` INT NOT NULL,
CONSTRAINT fk_employees_stores
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`),
CONSTRAINT sr_fk_employees_manager 
FOREIGN KEY (manager_id) 
REFERENCES `employees`(`id`)
);


-- 02. Insert

-- 03. Update

SET FOREIGN_KEY_CHECKS=0;

 UPDATE `employees`
SET `manager_id` = '3'
AND `salary` = `salary` - 500
WHERE YEAR(`hire_date`) > 2003 
AND `store_id` NOT IN (5, 14);


-- 04. Delete

DELETE FROM `employees`
WHERE `manager_id` IS NOT NULL AND `salary` >= 6000;


-- 05. Employees

SELECT
`first_name`,
`middle_name`,
`last_name`,
`salary`,
`hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;


-- 06. Products with old pictures

SELECT
p.`name`,
p.`price`,
p.`best_before`,
(SELECT CONCAT(LEFT(p.`description`, 10), '...')) AS 'short_description',
pi.`url`
FROM `products` AS p
JOIN `pictures` AS pi ON pi.`id` = p.`picture_id`
WHERE LENGTH(p.`description`) > 100 
AND YEAR(pi.`added_on`) < 2019
AND p.`price` > 20
ORDER BY p.`price` DESC;


-- 07. Counts of products in stores

SET sql_mode = '';

SELECT 
s.`name`,
CASE
WHEN p.`id` IS NULL THEN s.`id` = 0
ELSE COUNT(s.`id`)
END AS 'product_count',
ROUND(AVG(p.`price`), 2) AS 'avg'
FROM `stores` AS s
LEFT JOIN `products_stores` AS ps ON ps.`store_id` = s.`id`
LEFT JOIN `products` AS p ON ps.`product_id` = p.`id`
GROUP BY s.`id`
ORDER BY `product_count` DESC, `avg` DESC, s.`id` ASC;


-- 08. Specific employee

SELECT
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'Full_name',
s.`name` AS 'Store_name',
a.`name` AS 'address',
e.`salary`
FROM `employees` AS e
JOIN `stores` AS s ON s.`id` = e.`store_id`
JOIN `addresses` AS a ON a.`id` = s.`address_id`
WHERE e.`salary` < 4000
AND a.`name` LIKE ('%5%')
AND LENGTH(s.`name`) > 8
AND RIGHT(e.`last_name`, 1) = 'n' 


-- 09. Find all information of stores