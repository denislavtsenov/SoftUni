USE `soft_uni`;

-- 1. Managers

SELECT 
e.`employee_id`,
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'full_name',
d.`department_id`,
d.`name`
FROM `employees` AS e
RIGHT JOIN `departments` AS d 
ON d.`manager_id` = e.`employee_id`
ORDER BY `employee_id`
LIMIT 5;


-- 2. Towns and Addresses

SELECT
t.`town_id`,
t.`name` AS 'town_name',
a.`address_text`
FROM `towns` AS t
JOIN `addresses` AS a 
ON a.`town_id` = t.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY `town_id`, `address_id`;
