
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(100) DEFAULT NULL,
  `client_phone` varchar(45) DEFAULT NULL,
  `client_network` varchar(1900) DEFAULT NULL,
  `client_address` varchar(1900) DEFAULT NULL,
  `client_comment` varchar(1900) DEFAULT NULL,
  `client_number` varchar(45) DEFAULT NULL,
  `client_date_added` datetime DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
