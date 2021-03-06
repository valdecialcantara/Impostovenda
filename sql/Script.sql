use impostovenda;

CREATE TABLE user (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL
);

CREATE TABLE groupMaterial (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(80),
dutyFree boolean not null default 0
);

CREATE TABLE material (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
input INT,
name VARCHAR(80),
price DECIMAL(6,2) NOT NULL,
stockQuantity INT,
idGroup INT,
imported boolean not null default 0
);

CREATE TABLE sellProduct (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
input INT,
name VARCHAR(80),
price DECIMAL(6,2) NOT NULL,
duty DECIMAL(6,2) NOT NULL,
stockQuantity INT,
idMaterial INT
);

LOAD DATA LOCAL INFILE 'C:\\FileLoad\\User.txt' INTO TABLE `user` CHARACTER SET 'utf8' 
FIELDS TERMINATED BY ';' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'C:\\FileLoad\\material.txt' INTO TABLE `Material` CHARACTER SET 'utf8' 
FIELDS TERMINATED BY ';' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'C:\\FileLoad\\groupMaterial.txt' INTO TABLE `GroupMaterial` CHARACTER SET 'utf8' 
FIELDS TERMINATED BY ';' ENCLOSED BY '"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES;
