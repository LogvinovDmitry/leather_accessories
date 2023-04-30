
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_bag_id` int NOT NULL,
  `order_quantity` int DEFAULT NULL,
  `order_client_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_on_order_client_id` (`order_client_id`),
  CONSTRAINT `fk_order_on_order_client_id` FOREIGN KEY (`order_client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
