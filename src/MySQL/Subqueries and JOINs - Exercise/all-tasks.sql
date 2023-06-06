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


-- 06. Employees Hired After

SELECT
`first_name`,
`last_name`,
`hire_date`,
d.`name` AS 'dept_name'
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE `hire_date` > '1999-01-01' 
AND d.`name` IN ('Sales', 'Finance')
ORDER BY `hire_date`;


-- 07. Employees with Project

SET sql_mode = '';

SELECT 
e.`employee_id`,
e.`first_name`,
p.`name` AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON ep.`employee_id` = e.`employee_id`
JOIN `projects` AS p
ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13' 
AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;


-- 08. Employee 24

SELECT
e.`employee_id`,
e.`first_name`,
CASE
WHEN YEAR(p.`start_date`) >= '2005' THEN NULL
ELSE p.`name`
END AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON ep.`employee_id` = e.`employee_id`
JOIN `projects` AS p
ON ep.`project_id` = p.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `project_name`;

 
-- 09. Employee Manager

SELECT
e.`employee_id`,
e.`first_name`,
e.`manager_id`,
m.`first_name`
FROM `employees` AS e
JOIN `employees` AS m
ON e.`manager_id` = m.`employee_id`
WHERE e.`manager_id` IN (3, 7)
ORDER BY e.`first_name`;


-- 10. Employee Summary

SELECT
e.`employee_id`,
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'employee_name',
CONCAT_WS(' ', m.`first_name`, m.`last_name`) AS 'manager_name',
d.`name` AS `department_name`
FROM `employees` AS e
JOIN `employees` AS m
ON e.`manager_id` = m.`employee_id`
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NOT NULL
ORDER BY e.`employee_id`
LIMIT 5;

