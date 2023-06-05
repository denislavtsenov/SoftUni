USE `soft_uni`;

-- 01. Employee Address

SELECT 
e.`employee_id`,
e.`job_title`,
a.`address_id`,
a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON a.`address_id` = e.`address_id`
ORDER BY a.`address_id`
LIMIT 5;


-- 02. Addresses with Towns

SELECT
e.`first_name`,
e.`last_name`,
t.`name` AS 'town',
a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a 
ON a.`address_id` = e.`address_id`
JOIN `towns` AS t
ON t.`town_id` = a.`town_id`
ORDER BY `first_name`, `last_name`
LIMIT 5;