
CREATE TABLE `bag_photo` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `bag_id` int DEFAULT NULL,
  `photo_title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `fk_photo_on_inform_id` (`bag_id`),
  CONSTRAINT `fk_photo_on_inform_id` FOREIGN KEY (`bag_id`) REFERENCES `bag_information` (`bag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
