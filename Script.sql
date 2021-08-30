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
	

INSERT INTO culc_date (culc_id , culc_num_year , culc_num_month , culc_num_day )
	VALUES ( 'Y1M1' , 1 , 1 , 0 );　
	
SELECT * FROM culc_date  ;

SELECT 
  *
FROM
 culc_date
;
	

INSERT INTO result_date  ( result_date , culc_id )
	VALUES ( '2022-09-29' , 'Y1M1' );

SHOW CREATE TABLE result_date ;

ALTER TABLE result_date DROP FOREIGN KEY result_date_ibfk_1; 

ALTER TABLE culc_date DROP PRIMARY KEY;

ALTER TABLE culc_date 
	ADD result_id INT AUTO_INCREMENT PRIMARY KEY FIRST;



