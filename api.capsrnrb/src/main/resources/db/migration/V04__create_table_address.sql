CREATE table IF NOT EXISTS address (
id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
street VARCHAR(100), 
zipcode VARCHAR(50),
district VARCHAR(50),
complement varchar(100),
id_city INT NOT NULL, 
FOREIGN KEY (id_city) REFERENCES city(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE table IF NOT EXISTS user (
id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(200), 
mother_name VARCHAR(200),
nu_prontuario INTEGER,
nu_cart_sus varchar(100),
file_local varchar(10),
drug_type varchar(50),
phone varchar(50),
date_of_birth date,
id_addresss INT NOT NULL, 
FOREIGN KEY (id_addresss) REFERENCES address(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE table IF NOT EXISTS screeningdate (
id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
screening_date date not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE table IF NOT EXISTS user_screeningdate (
id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id INTEGER NOT NULL,
screeningdate_id INTEGER NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




