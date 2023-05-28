-- *1. Find Book Titles

SELECT `title` FROM `books`
WHERE `title` LIKE 'The%';


-- *2. Replace Titles

SELECT REPLACE(`title`, 'The', '***') AS 'title'
FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;


-- *3. Sum Cost of All Books

SELECT FORMAT(SUM(`cost`), 2) 
FROM `books`;


-- *4. Days Lived

SELECT concat_ws(' ', `first_name`, `last_name`) AS 'Full Name',
abs(datediff(`born`, `died`)) AS 'Days Lived'
FROM `authors`;


-- 5. Harry Potter Books

SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%';
