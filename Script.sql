CREATE TABLE login_user(
	user_id INT NOT NULL,
	login_id VARCHAR(50) NOT NULL ,
	passsword VARCHAR(40) NOT NULL,
	PRIMARY KEY (user_id) 
);

ALTER TABLE login_user 
	MODIFY user_id INT AUTO_INCREMENT
;

CREATE TABLE calc_date(
	calc_id VARCHAR(20) NOT NULL ,
	calc_num_year INT DEFAULT 0 ,
	calc_num_month INT DEFAULT 0 ,
	calc_num_day INT DEFAULT 0 
);

CREATE TABLE result_date(
	result_id INT AUTO_INCREMENT ,
	result_date DATE ,
	PRIMARY KEY (result_id)	
);

ALTER TABLE calc_date 
	MODIFY calc_id VARCHAR(20) NOT NULL PRIMARY KEY;


ALTER TABLE result_date 
	ADD calc_id VARCHAR(20) NOT NULL;

ALTER TABLE result_date 
	ADD FOREIGN KEY (calc_id) REFERENCES calc_date (calc_id);
	

INSERT INTO calc_date (calc_id , calc_num_year , calc_num_month , calc_num_day )
	VALUES ( 'Y1M1' , 1 , 1 , 0 );　
	
SELECT * FROM calc_date  ;

SELECT 
  *
FROM
 calc_date
;
	

INSERT INTO result_date  ( result_date , calc_id )
	VALUES ( '2022-09-29' , 'Y1M1' );

SHOW CREATE TABLE result_date ;

ALTER TABLE result_date DROP FOREIGN KEY result_date_ibfk_1; 

ALTER TABLE calc_date DROP PRIMARY KEY;

ALTER TABLE calc_date 
	ADD result_id INT AUTO_INCREMENT PRIMARY KEY FIRST;



