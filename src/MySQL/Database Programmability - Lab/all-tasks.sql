USE `soft_uni`;

-- 1. Count Employees by Town

DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE e_count INT;
    SET e_count := (SELECT COUNT(*) AS 'count'
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON t.`town_id` = a.`town_id`
WHERE t.`name`  = town_name);
RETURN e_count;
END$$
DELIMITER ;
;


-- 2. Employees Promotion

DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
 BEGIN
	UPDATE `employees` AS e
	JOIN `departments` AS d
	ON e.`department_id` = d.`department_id`
	SET e.`salary` = e.`salary` * 1.05
	WHERE d.`name` = department_name
	ORDER BY e.`first_name`, e.`salary`;
END$$
DELIMITER ;
;

