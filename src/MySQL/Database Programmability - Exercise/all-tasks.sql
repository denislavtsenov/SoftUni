USE `soft_uni`;

01. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
		SELECT `first_name`, `last_name`
        FROM `employees`
        WHERE `salary` > 35000
        ORDER BY `first_name`, `last_name`, `employee_id`;
END$$
DELIMITER ;
;


-- 02. Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(needed_salary DECIMAL(19,4))
BEGIN
		SELECT `first_name`, `last_name`
        FROM `employees`
        WHERE `salary` >= needed_salary
        ORDER BY `first_name`, `last_name`, `employee_id`;
END$$
DELIMITER ;
;


-- 03. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(starting_letter VARCHAR(50))
BEGIN
	SELECT `name`
	FROM `towns`
	WHERE `name` LIKE (CONCAT(starting_letter, '%'))
	ORDER BY `name`;
END$$
DELIMITER ;
;

