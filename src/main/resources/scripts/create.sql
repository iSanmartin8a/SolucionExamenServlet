create table IF NOT EXISTS Console(
	name varchar(25) PRIMARY KEY,
	companyId int
);
create table IF NOT EXISTS Game(
	title varchar(25) PRIMARY KEY,
	age varchar(25),
	releaseDate date,
	companyId int
);
create table IF NOT EXISTS Company(
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name varchar(25) ,
	creationDate date
);