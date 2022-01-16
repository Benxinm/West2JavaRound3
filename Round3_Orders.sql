USE round3;

CREATE TABLE orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
good_id INT, 
order_time DATETIME
);

INSERT INTO orders 
	VALUES(NULL,8,NOW())

SELECT * FROM orders