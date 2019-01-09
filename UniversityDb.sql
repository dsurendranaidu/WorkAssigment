CREATE DATABASE  IF NOT EXISTS `university`;

USE `university`;

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`(
   `department_id` int NOT NULL aAUTO_INCREMENT PRIMARY KEY,
   `department_name` varchar(255) not null,
   `department_head` varchar(255)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO department (department_id, department_name, department_head) VALUES ("165", "Science", "SomePerson");
INSERT INTO department (department_id, department_name, department_head) VALUES ("123", "Social", "SomeXPerson");

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`(
   `course_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `course_name` varchar(255) NOT NULL,
   `department_id` int,
    CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO course (course_id, course_name, department_id) VALUES (986, "Physcis", 165);
INSERT INTO course (course_id, course_name, department_id) VALUES (323, "History", 123);

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `student_name` varchar(45) NOT NULL,
  `student_age` int,
  `department_id` int,
   CONSTRAINT `fk_student_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  `course_id` int NOT NULL,
  CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
