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