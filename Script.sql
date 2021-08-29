CREATE TABLE login_user(
	user_id INT NOT NULL,
	login_id VARCHAR(50) NOT NULL ,
	passsword VARCHAR(40) NOT NULL,
	PRIMARY KEY (user_id) 
);

ALTER TABLE login_user 
	MODIFY user_id INT AUTO_INCREMENT
;

CREATE TABLE culc_date(
	culc_id VARCHAR(20) NOT NULL ,
	culc_num_year INT DEFAULT 0 ,
	culc_num_month INT DEFAULT 0 ,
	culc_num_day INT DEFAULT 0 
);

CREATE TABLE result_date(
	result_id INT AUTO_INCREMENT ,
	result_date DATE ,
	PRIMARY KEY (result_id)	
);

ALTER TABLE culc_date 
	MODIFY culc_id VARCHAR(20) NOT NULL PRIMARY KEY;


ALTER TABLE result_date 
	ADD culc_id VARCHAR(20) NOT NULL;

ALTER TABLE result_date 
	ADD FOREIGN KEY (culc_id) REFERENCES culc_date (culc_id);
	

INSERT INTO culc_date　　