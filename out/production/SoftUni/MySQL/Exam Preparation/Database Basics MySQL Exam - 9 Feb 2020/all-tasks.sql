CREATE DATABASE `fsd`;
USE `fsd`;

CREATE TABLE `coaches`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT NOT NULL DEFAULT 0
);

CREATE TABLE `countries`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`capacity` INT NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_stadiums_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT(20) NOT NULL DEFAULT 0,
`stadium_id` INT NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`) 
);

CREATE TABLE `skills_data`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`dribbling` INT DEFAULT 0,
`pace` INT DEFAULT 0,
`passing` INT DEFAULT 0,
`shooting` INT DEFAULT 0,
`speed` INT DEFAULT 0,
`strength` INT DEFAULT 0
);

CREATE TABLE `players`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL DEFAULT 0,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) DEFAULT 0,
`hire_date` DATETIME,
`skills_data_id` INT NOT NULL,
`team_id` INT,
CONSTRAINT fk_players_skills_data
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(`id`),
CONSTRAINT fk_players_teams
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `players_coaches`(
`player_id` INT,
`coach_id` INT,
CONSTRAINT fk_pc_players
FOREIGN KEY (`player_id`)
REFERENCES `players`(`id`),
CONSTRAINT fk_pc_coaches
FOREIGN KEY (`coach_id`)
REFERENCES `coaches`(`id`)
);


-- 02. Insert

INSERT INTO `coaches`(`first_name`, `last_name`, `salary`, `coach_level`)
SELECT 
p.`first_name`,
p.`last_name`,
p.`salary` * 2,
LENGTH(p.`first_name`)
FROM `players` AS p
WHERE p.`age` >= 45;


-- 03. Update

UPDATE `coaches` AS c
JOIN `players_coaches` AS pc ON pc.`coach_id` = c.`id`
SET c.`coach_level` = c.`coach_level` + 1
WHERE c.`first_name` LIKE ('A%')
AND pc.`coach_id` IN (
SELECT pc.`coach_id` FROM `players_coaches` AS pc
GROUP BY pc.`coach_id`
HAVING COUNT(pc.`coach_id`) > 0);

-- 04. Delete

DELETE FROM `players`
WHERE `age` >= 45;


-- 05. Players

SELECT
`first_name`,
`age`,
`salary`
FROM `players`
ORDER BY `salary` DESC;


-- 06. Young offense players without contract

SELECT 
p.`id`,
CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS 'full_name',
p.`age`,
p.`position`,
p.`hire_date`
FROM `players` AS p
JOIN `skills_data` AS sd
ON sd.`id` = p.`skills_data_id`
WHERE p.`age` < 23 
AND p.`position` IN ('A')
AND p.`hire_date` IS NULL
AND sd.`strength` > 50 
ORDER BY `salary` ASC, `age` ASC;


-- 07. Detail info for all teams

SELECT 
t.`name`,
t.`established`,
t.`fan_base`,
COUNT(p.`team_id`) AS 'players_count'
FROM `teams` AS t
LEFT JOIN `players` AS p
ON p.`team_id` = t.`id`
GROUP BY t.`name`
ORDER BY `players_count` DESC, t.`fan_base` DESC;


-- 08. The fastest player by towns

SELECT
MAX(sd.`speed`) AS 'max_speed',
tw.`name` AS 'town_name' 
FROM `towns` AS tw
LEFT JOIN `stadiums` AS s ON s.`town_id` = tw.`id`
LEFT JOIN `teams` AS t ON t.`stadium_id` = s.`id`
LEFT JOIN `players` AS p ON t.`id` = p.`team_id`
LEFT JOIN `skills_data` AS sd ON sd.`id` = p.`skills_data_id`
WHERE t.`name` NOT IN ('Devify')
GROUP BY tw.`name`
ORDER BY `max_speed` DESC, `town_name` ASC;


-- 09. Total salaries and players by country

SELECT 
c.`name`,
COUNT(p.`id`) AS 'total_count_of_players',
SUM(p.`salary`) AS 'total_sum_of_salaries'
FROM `players` AS p
JOIN `teams` AS t ON t.`id` = p.`team_id`
JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
JOIN `towns` AS tw ON tw.`id` = s.`town_id`
RIGHT JOIN `countries` AS c ON c.`id` = tw.`country_id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC, c.`name` ASC;


-- 10. Find all players that play on stadium

DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
	BEGIN 
		DECLARE count INT;
        SET count = (
SELECT 
COUNT(p.`id`) AS 'count'
FROM `players` AS p
JOIN `teams` AS t ON p.`team_id` = t.`id`
JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
WHERE s.`name` = stadium_name
);
	RETURN count;
	END$$
DELIMITER ;
;


-- 11. Find good playmaker by teams

DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
SELECT
CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS 'full_name',
p.`age`,
p.`salary`,
sd.`dribbling`,
sd.`speed`,
t.`name`
FROM `players` AS p
JOIN `skills_data` AS sd ON p.`skills_data_id` = sd.`id`
JOIN `teams` AS t ON t.`id` = p.`team_id`
WHERE t.`name` = team_name 
AND sd.`dribbling` > min_dribble_points
AND sd.`speed` > ( SELECT AVG(speed)
					FROM `skills_data`)
ORDER BY sd.`speed` DESC
LIMIT 1;
END $$
DELIMITER ;
;