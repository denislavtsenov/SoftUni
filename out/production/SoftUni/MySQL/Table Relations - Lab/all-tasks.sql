USE `camp`;
-- 1. Mountains and Peaks

CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200)
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200),
`mountain_id` INT,
CONSTRAINT fk_peaks_mountains
FOREIGN KEY (`mountain_id`) REFERENCES `mountains`(id)
);


-- 2. Trip Organization

SELECT 
    `driver_id`,
    `vehicle_type`,
    CONCAT_WS(' ', `first_name`, `last_name`) AS 'driver_name'
FROM
    `vehicles`
        JOIN
    campers ON driver_id = campers.id;
    

-- 3. SoftUni Hiking

SELECT 
r.`starting_point` AS 'route_starting_point',
r.`end_point` AS 'route_ending_point',
r.`leader_id`,
CONCAT_WS(' ', c.`first_name`, c.`last_name`) AS 'leader_name'
FROM `routes` as r
JOIN `campers` as c ON r.`leader_id` = c.id;


-- 4. Delete Mountains

CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200)
);

CREATE TABLE `peaks` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200),
    `mountain_id` INT,
    CONSTRAINT fk_peaks_mountains FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (id)
        ON DELETE CASCADE
);
