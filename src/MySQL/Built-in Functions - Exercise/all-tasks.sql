-- 1. Find Names of All Employees by First Name
USE `soft_uni`;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE left(`first_name`, 2) LIKE 'Sa'
ORDER BY `employee_id`;


-- 2. Find Names of All Employees by Last Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;


-- 3. Find First Names of All Employess

SELECT 
    `first_name`
FROM
    `employees`
WHERE
    (YEAR(`hire_date`) BETWEEN 1995 AND 2005)
        AND `department_id` IN (3 , 10)
ORDER BY `employee_id`;


-- 4. Find All Employees Except Engineers

SELECT `first_name`, `last_name`
FROM `employees`
WHERE lower(`job_title`) NOT LIKE '%engineer%'
ORDER BY `employee_id`;


-- 5. Find Towns with Name Length

SELECT `name`
FROM `towns`
WHERE length(`name`) IN (5,6)
ORDER BY `name` ASC;


-- 6. Find Towns Starting With

SELECT `town_id`, `name`
FROM `towns`
WHERE left(lower(`name`), 1) IN ('m', 'k','b','e')
ORDER BY `name`;


-- 7. Find Towns Not Starting With

SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    LEFT(LOWER(`name`), 1) != 'r'
        AND LEFT(LOWER(`name`), 1) != 'b'
        AND LEFT(LOWER(`name`), 1) != 'd'
ORDER BY `name`;


-- 8. Create View Employees Hired After

CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;


-- 9. Length of Last Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE length(`last_name`) = 5;


-- 10. Countries Holding 'A'
USE `geography`;

SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`; 