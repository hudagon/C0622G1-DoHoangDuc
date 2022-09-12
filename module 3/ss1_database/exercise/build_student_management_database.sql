CREATE DATABASE student_management;

CREATE TABLE student_management.student (
	id INT,
    name VARCHAR(30),
    age INT,
    country VARCHAR(50),
    primary key(id)
);

CREATE TABLE student_management.class (
	id INT,
    name VARCHAR(30)
);

CREATE TABLE student_management.teacher (
	id INT,
    name VARCHAR(30),
    age INT(10),
    country VARCHAR(30)
);