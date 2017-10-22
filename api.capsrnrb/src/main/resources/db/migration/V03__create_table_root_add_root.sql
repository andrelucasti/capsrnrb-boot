CREATE table IF NOT EXISTS token (
token varchar(200) PRIMARY KEY,
datetoexpire datetime,
datecreated datetime,
enable char
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE table IF NOT EXISTS root (
ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100)  NOT NULL UNIQUE,
email VARCHAR(150)  NOT NULL UNIQUE,
password VARCHAR(150)  NOT NULL,
token VARCHAR(100),
FOREIGN KEY (token) REFERENCES token(token)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO root(id, email, password, username, token) 
VALUES 
(1, 
'desenv@desenv.com',
'0e987a0b24a97910beba6a5621f5b71dcc48dc9378df33f6705974540568f23b',
'desenv',
null);


INSERT INTO root(id, email, password, username, token) 
VALUES 
(2, 
'andrelucastic@gmail.com',
'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',
'andrelucastic',
null);


