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


-- 03. Sales Employee

SELECT 
e.`employee_id`,
e.`first_name`,
e.`last_name`,
d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE d.`name` IN ('Sales')
ORDER BY `employee_id` DESC;


-- 04. Employee Departments

SELECT 
e.`employee_id`,
e.`first_name`,
e.`salary`,
d.`name` AS 'department_name'
FROM `employees` AS e 
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;


-- 05. Employees Without Project

SELECT 
e.`employee_id`,
e.`first_name`
FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON ep.`employee_id` = e.`employee_id`
WHERE `project_id` IS NULL
ORDER BY `employee_id` DESC 
LIMIT 3;


