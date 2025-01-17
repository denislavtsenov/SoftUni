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


-- 11. Min Average Salary

SELECT 
AVG(`salary`) AS 'min_average_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary`
LIMIT 1;


USE `geography`;
-- 12. Highest Peaks in Bulgaria

SELECT 
c.`country_code`,
m.`mountain_range`,
p.`peak_name`,
p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE c.`country_code` IN ('BG') AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;


-- 13. Count Mountain Ranges

SELECT
c.`country_code`,
COUNT(m.`mountain_range`) AS 'mountain_range'
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
WHERE c.`country_code` IN ('BG', 'RU', 'US')
GROUP BY c.`country_code`
ORDER BY `mountain_range` DESC;


-- 14. Countries with Rivers

SELECT 
c.`country_name`,
r.`river_name`
FROM `countries` c
LEFT JOIN `countries_rivers` AS cr
ON cr.`country_code` = c.`country_code`
LEFT JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
WHERE c.`continent_code` IN ('AF')
ORDER BY c.`country_name`
LIMIT 5;


-- 16. Countries without any Mountains

SELECT
COUNT(c.`country_name`) AS 'country_count'
FROM `countries` AS c
LEFT JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
LEFT JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
WHERE m.`mountain_range` IS NULL;


-- 17. Highest Peak and Longest River by Country

SELECT
c.`country_name`,
MAX(p.`elevation`) AS 'highest_peak_elevation',
MAX(r.`length`) AS 'longest_river_length'
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
JOIN `countries_rivers` AS cr
ON cr.`country_code` = c.`country_code`
JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
GROUP BY `country_name`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC
LIMIT 5;