CREATE DATABASE `universities_db`;
USE `universities_db`;


-- 01. Table Design

CREATE TABLE `countries`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `cities`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
`population` INT,
`country_id` INT NOT NULL,
CONSTRAINT fk_cities_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `universities`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL UNIQUE,
`address` VARCHAR(80) NOT NULL UNIQUE,
`tuition_fee` DECIMAL(19, 2) NOT NULL,
`number_of_staff` INT,
`city_id` INT,
CONSTRAINT fk_universities_cities
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`id`)
);

CREATE TABLE `students`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(40) NOT NULL,
`last_name` VARCHAR(40) NOT NULL,
`age` INT,
`phone` VARCHAR(20) NOT NULL UNIQUE,
`email` VARCHAR(255) NOT NULL UNIQUE,
`is_graduated` TINYINT(1),
`city_id` INT,
CONSTRAINT fk_students_cities
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`id`)
);

CREATE TABLE `courses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
`duration_hours` DECIMAL(19, 2),
`start_date` DATE,
`teacher_name` VARCHAR(60) NOT NULL UNIQUE,
`description` TEXT,
`university_id` INT,
CONSTRAINT fk_courses_universities
FOREIGN KEY (`university_id`)
REFERENCES `universities`(`id`)
);

CREATE TABLE `students_courses`(
`grade` DECIMAL(19, 2) NOT NULL,
`student_id` INT NOT NULL,
`course_id` INT NOT NULL,
CONSTRAINT fk_sc_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`id`),
CONSTRAINT fk_sc_courses
FOREIGN KEY (`course_id`)
REFERENCES `courses`(`id`)
);


-- 02. Insert

INSERT INTO `courses`(`name`, `duration_hours`, `start_date`, `teacher_name`, `description`, `university_id`)
SELECT
CONCAT_WS(' ', `teacher_name`, `name`),
LENGTH(`name`) / 10,
DATE_ADD(start_date, INTERVAL 5 DAY),
REVERSE(`teacher_name`),
CONCAT('Course ' + `teacher_name` + REVERSE(`description`)),
DAY(`start_date`)
FROM `courses`;


-- 03. Update

UPDATE `universities` AS u
SET u.`tuition_fee` = u.`tuition_fee` + 300
WHERE u.`id` BETWEEN 5 AND 12;


-- 04. Delete



-- 05. Cities

SELECT
`id`,
`name`,
`population`,
`country_id`
FROM `cities`
ORDER BY `population` DESC;


-- 06. Students age

SELECT
`first_name`, 
`last_name`, 
`age`, 
`phone`,
`email` 
FROM `students`
WHERE `age` >= 21
ORDER BY `first_name` DESC,
`email` ASC,
`id` ASC
LIMIT 10;


-- 07. New students

SELECT
CONCAT_WS(' ', s.`first_name`, s.`last_name`) AS 'full_name',
SUBSTRING(s.`email`, 2, 10) AS 'username',
REVERSE(s.`phone`) AS 'password'
FROM `students` AS s
LEFT JOIN `students_courses` AS sc ON s.`id` = sc.`student_id`
WHERE sc.`course_id` IS NULL
ORDER BY `password` DESC;


-- 08. Students count

SET sql_mode = '';

SELECT 
COUNT(sc.`student_id`) AS 'students_count',
u.`name` AS 'university_name'
FROM `students` AS s
JOIN `students_courses` AS sc ON s.`id` = sc.`student_id`
JOIN `courses` AS c ON sc.`course_id` = c.`id`
JOIN `universities` AS u ON u.`id` = c.`university_id`
GROUP BY u.`id`
HAVING `students_count` >= 8 
ORDER BY `students_count` DESC, `university_name` DESC;


-- 09. Price rankings

SELECT
u.`name` AS 'university_name', 
c.`name` AS 'city_name', 
u.`address`, 
CASE 
	WHEN u.`tuition_fee` < 800 THEN 'cheap'
	WHEN u.`tuition_fee` < 1200 THEN 'normal'
	WHEN u.`tuition_fee` < 2500 THEN 'high'
	ELSE 'expensive'
END AS 'price_rank',
u.`tuition_fee`
FROM `universities` AS u
JOIN `cities` AS c ON c.`id` = u.`city_id`
ORDER BY u.`tuition_fee` ASC;

-- 10. Average grades
DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60)) 
RETURNS DECIMAL(19,2)
DETERMINISTIC
		BEGIN
        DECLARE average_grade DECIMAL(19, 2);
        SET average_grade = (
			SELECT
			ROUND(AVG(sc.`grade`), 2) AS 'average_alumni_grade'
			FROM `students` AS s
			JOIN `students_courses` AS sc ON s.`id` = sc.`student_id` 
			JOIN `courses` AS c ON c.`id` = sc.`course_id`
			WHERE s.`is_graduated` = 1 AND c.`name` = course_name
			GROUP BY sc.`course_id`
            );
            RETURN average_grade;
		END$$
DELIMITER ;
;

-- 11. Graduate students

DELIMITER $$
CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
	BEGIN
		UPDATE `students` AS s
		JOIN `students_courses` AS sc ON s.`id` = sc.`student_id`
		JOIN `courses` AS c ON sc.`course_id` = c.`id`
		SET s.`is_graduated` = 1
		WHERE YEAR(c.`start_date`) = year_started;
	END$$
DELIMITER ;
;
