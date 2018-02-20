create table IF NOT EXISTS Console(
	name varchar(25) PRIMARY KEY,
	company varchar(25)
);
create table IF NOT EXISTS Game(
	title varchar(25) PRIMARY KEY,
	age varchar(25),
	releaseDate date
);
create table IF NOT EXISTS COMPANY(
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name varchar(25) ,
	creationDate date
);