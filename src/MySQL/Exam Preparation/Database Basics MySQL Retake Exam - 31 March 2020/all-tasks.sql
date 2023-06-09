CREATE DATABASE `instd`;
USE `instd`;

-- 01. Table Design

CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
`views` INT NOT NULL DEFAULT 0
);

CREATE TABLE `comments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_comments_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `likes`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`photo_id` INT,
`user_id` INT,
CONSTRAINT fk_likes_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`),
CONSTRAINT fk_likes_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `users_photos`(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_up_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT fk_up_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);


-- 02. Insert

INSERT INTO `addresses`(`address`, `town`, `country`, `user_id`)
SELECT `username`, `password`, `ip`, `age` FROM `users`
WHERE `gender` IN ('M');


-- 03. Update

UPDATE `addresses`
SET `country` = 
	CASE
		WHEN `country` LIKE ('B%') THEN 'Blocked'
        WHEN `country` LIKE ('T%') THEN 'Test'
        WHEN `country` LIKE ('P%') THEN 'In Progress'
        ELSE `country` = `country`
	END;


-- 04. Delete

DELETE FROM `addresses`
WHERE `id` % 3 = 0;


-- 05. Users

SELECT 
`username`,
`gender`,
`age`
FROM `users`
ORDER BY `age` DESC, `username` ASC;


-- 06. Extract 5 most commented photos

SELECT 
p.`id`,
p.`date` AS 'date_and_time',
p.`description`,
COUNT(c.`photo_id`) AS 'commentsCount'
FROM `photos` AS p
JOIN `comments` AS c
ON c.`photo_id` = p.`id`
GROUP BY c.`photo_id`
ORDER BY `commentsCount` DESC, p.`id` ASC
LIMIT 5;


-- 07. Lucky users

-- SELECT
-- CONCAT_WS(' ', u.`id`, u.`username`) AS 'id_username',
-- u.`email`
-- FROM `users` AS u
-- JOIN `users_photos` AS up ON up.`user_id` = u.`id`
-- WHERE up.`user_id` = up.`photo_id`
-- ORDER BY `id_username`;


-- 08. Count likes and comments

-- 09. The photo on the tenth day of the month

-- 10. Get user’s photos count

DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
	BEGIN
		DECLARE photos_count INT;
		SET photos_count = (
		SELECT COUNT(u.`id`) AS 'photosCount'
		FROM `users` AS u
		JOIN `users_photos` AS up ON up.`user_id` = u.`id`
		JOIN `photos` AS p ON p.`id` = up.`photo_id`
		WHERE u.`username` = username
		GROUP BY u.`id`);
	RETURN photos_count;
	END $$
DELIMITER ;
;


-- 11. Increase user age

DELIMITER $$
CREATE PROCEDURE udp_modify_user (address VARCHAR(30), town VARCHAR(30))
	BEGIN
UPDATE `users` AS u
JOIN `addresses` AS a ON a.`user_id` = u.`id`
SET `age` = `age` + 10
WHERE a.`address` = address
AND a.`town` = town;
	END$$
DELIMITER ;
;