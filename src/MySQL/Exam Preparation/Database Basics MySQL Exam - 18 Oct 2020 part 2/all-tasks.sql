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

INSERT INTO `products_stores`(`product_id`, `store_id`)
SELECT p.`id`, 1
FROM `products` AS p
LEFT JOIN `products_stores` AS ps ON ps.`product_id` = p.`id`
WHERE ps.`product_id` IS NULL;

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
AND RIGHT(e.`last_name`, 1) = 'n';


-- 09. Find all information of stores

SELECT
REVERSE(s.`name`) AS 'reversed_name',
CONCAT_WS('-', UPPER(t.`name`), a.`name`) AS 'full_address',
COUNT(e.`id`)
FROM `stores` AS s
JOIN `addresses` AS a ON a.`id` = s.`address_id`
JOIN `towns` AS t ON t.`id` = a.`town_id`
JOIN `employees` AS e ON e.`store_id` = s.`id`
GROUP BY s.`id`
ORDER BY `full_address`;


-- 10. Find name of top paid employee by store name

DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(1000)
DETERMINISTIC
		BEGIN
        DECLARE full_store_info VARCHAR(1000);
        SET full_store_info := (
			SELECT  
			CONCAT_WS(' ', e.`first_name`, CONCAT(e.`middle_name`, '.'), e.`last_name`,
			'works in store for',  YEAR('2020-10-18') - YEAR(`hire_date`), 'years')   
			AS 'full_info'
			FROM `employees` AS e
			JOIN `stores` AS s ON s.`id` = e.`store_id`
			WHERE s.`name` = store_name
			ORDER BY `salary` DESC
			LIMIT 1);
		RETURN full_store_info;
		END$$
DELIMITER ;
;


-- 11. Update product price by address

DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
	UPDATE `products` AS p
	JOIN `products_stores` AS ps ON p.`id` = ps.`product_id`
	JOIN `stores` AS s ON s.`id` = ps.`store_id`
	JOIN `addresses` AS a ON a.`id` = s.`address_id`
	SET `price` = (
		CASE 
			WHEN LEFT(address_name, 1) = 0 THEN `price` + 100
			WHEN LEFT(address_name, 1) != 0 THEN `price` + 200
			ELSE `price` = `price`
		END
	)
	WHERE a.`name` = address_name;
	END$$
DELIMITER ;
; 


UPDATE `products` AS p
JOIN `product_stores` AS ps ON p.`id` = ps.`product_id`
JOIN `stores` AS s ON s.`id` = ps.`store_id`
JOIN `addresses` AS a ON a.`id` = s.`address.id`
SET `price` = (
	CASE 
		WHEN LEFT(address_name, 1) = 0 THEN `price` + 100
		WHEN LEFT(address_name, 1) != 0 THEN `price` + 200
        ELSE `price` = `price`
	END
)
WHERE a.`name` = address_name;