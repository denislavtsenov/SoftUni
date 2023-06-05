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