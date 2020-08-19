CREATE TABLE student (
	s_id INT PRIMARY KEY AUTO_INCREMENT,
	s_name VARCHAR(20) NOT NULL,
	s_tel VARCHAR(20) NOT NULL,
	s_grade INT NOT NULL,
	s_class INT NOT NULL
);

DROP TABLE student;

DESC student;

SELECT * FROM student;

SELECT count(*) FROM student;

INSERT INTO student (s_name, s_tel, s_grade, s_class) VALUES ("Han in yong","010-2222-6666",3,2);

DELETE FROM student WHERE s_id = 2;

SELECT * FROM student WHERE s_name LIKE '%w%' ORDER BY s_id ASC;

UPDATE student SET s_grade = 4 WHERE s_id = 7;

SELECT * FROM student WHERE s_id = 5; 

SELECT * FROM student where s_class like '%3%';