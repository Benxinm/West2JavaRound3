CREATE DATABASE round3;

CREATE TABLE goods(
id INT PRIMARY KEY AUTO_INCREMENT,
good_name VARCHAR(32),
good_price DOUBLE
);

INSERT INTO goods
	VALUES 
	(NULL,'罗技G903',699.00),
	(NULL,'Cherry MX3.0S Wireless',1249.00),
	(NULL,'Cherry MX8.0',1549.00),
	(NULL,'Sony WH-1000XM4',2099.00),
	(NULL,'Sony WH-1000XM3',1399.00),
	(NULL,'Bose QC35',1299.00),
	(NULL,'MacBook Air',7999.00),
	(NULL,'MacBook Pro',9999.00);

SELECT * FROM goods;
INSERT INTO goods VALUES (NULL,'1',1);


