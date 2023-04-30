
CREATE TABLE `bag_information` (
  `bag_id` int NOT NULL AUTO_INCREMENT,
  `bag_name` varchar(45) NOT NULL,
  `bag_category` int NOT NULL,
  `bag_description` text,
  `bag_date_added` date NOT NULL,
  `bag_price` double NOT NULL,
  `main_photo_title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`bag_id`),
  KEY `fk_bag_category` (`bag_category`),
  CONSTRAINT `fk_bag_category` FOREIGN KEY (`bag_category`) REFERENCES `bag_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=627 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
