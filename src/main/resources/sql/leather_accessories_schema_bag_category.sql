
CREATE TABLE `bag_category` (
  `category_id` int NOT NULL,
  `bag_category_inf` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `bag_category` (`category_id`, `bag_category_inf`) VALUES (1, 'Men''s bag'),(2, 'Lady''s bag'),(3, 'Accessories');
