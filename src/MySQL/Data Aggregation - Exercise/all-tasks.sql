-- 01. Records’ Count
USE `gringotts`;

SELECT COUNT(*)
FROM `wizzard_deposits`;


-- 02. Longest Magic Wand

SELECT MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM `wizzard_deposits`;