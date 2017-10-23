CREATE table IF NOT EXISTS address (
  id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  complement varchar(255) DEFAULT NULL,
  district varchar(200) DEFAULT NULL,
  number int DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  zip_code varchar(255) DEFAULT NULL,
  city_id int(11) DEFAULT NULL,
FOREIGN KEY (city_id) REFERENCES city(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE table IF NOT EXISTS user (
  id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date_of_birth datetime DEFAULT NULL,
  drug_type varchar(255) DEFAULT NULL,
  file_local varchar(255) DEFAULT NULL,
  mother_name varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  nu_cart_sus varchar(255) DEFAULT NULL,
  nu_prontuario bigint(20) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  address_id bigint, 
FOREIGN KEY (address_id) REFERENCES address(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE table IF NOT EXISTS screeningdate (
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
screening_date date not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE table IF NOT EXISTS user_screeningdate (
user_id bigint NOT NULL,
screeningdate_id bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




