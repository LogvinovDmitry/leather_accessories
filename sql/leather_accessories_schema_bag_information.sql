-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: leather_accessories_schema
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bag_information`
--

DROP TABLE IF EXISTS `bag_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bag_information`
--

LOCK TABLES `bag_information` WRITE;
/*!40000 ALTER TABLE `bag_information` DISABLE KEYS */;
INSERT INTO `bag_information` VALUES (610,'Glasses case M1',3,'dcdcdcdc','2023-03-03',50,'file/mainPhotoTitle/ba96977c-a9ec-46a9-b649-94ec16a2240f.jpg'),(611,'Glasses case M2',3,'hyhyhyhy','2023-03-03',40,'file/mainPhotoTitle/f17bf636-6293-42f1-b828-d93d664c520f.jpg'),(612,'Glasses case M3',3,'fvfvfvfvf','2023-03-03',40,'file/mainPhotoTitle/b976bf37-802c-40e2-b5ad-73ca5ad3a962.jpg'),(613,'Key holder M1',3,'jujujuju','2023-03-03',30,'file/mainPhotoTitle/bdbebf1e-143e-4715-bd29-d2793c0d3638.jpg'),(614,'Wallet M1',1,'dhdhdhdhdh','2023-03-03',90,'file/mainPhotoTitle/cd880486-db7a-4f22-808b-3a6c5ccb6048.jpg'),(615,'Wallet M2',2,'tbgdfvdfv','2023-03-03',70,'file/mainPhotoTitle/76ce22ee-5ee1-40ea-9b5e-fc997f1978ad.jpg'),(616,'Wallet M3',1,'vbbvbvbvbvb','2023-03-03',70,'file/mainPhotoTitle/9adb0536-2237-44a8-bfd6-1bbd01ce09d1.jpg'),(617,'Wallet M4',1,'gttgtg','2023-03-03',40,'file/mainPhotoTitle/a0e135e0-aff9-4cd8-8b06-959985c94aab.jpg'),(618,'Wallet-cardholder green',1,'ikikikki','2023-03-03',45,'file/mainPhotoTitle/49b3cfc7-fcbd-4aff-a1b3-e58dce8b60e8.jpg'),(619,'Wallet-cardholder red',1,'The Traveler Cross-body bag is a timeless unisex design that anyone can appreciate and enjoy. It truly is a luxuriously rugged hybrid. \\n It features an exterior pocket for quick access to your cell phone or other items. It also has an interior pocket to store loose items and a large main section for everything else. It also comes with an adjustable strap for that perfect carry length. Use it as an every day carry bag, small camera bag or whatever else your little heart \\n desires.','2023-03-03',45,'file/mainPhotoTitle/f166f2c4-4f1d-450f-88d2-ebf104944c9e.jpg'),(620,'Watch band M1',3,'tyttytytyty','2023-03-03',30,'file/mainPhotoTitle/ff6f1ef6-09b1-4136-a3ed-d49592e77eca.jpg'),(621,'Watch band M2',3,'bnbnbnbnb','2023-03-03',30,'file/mainPhotoTitle/b433a001-6655-4275-8d7b-7f87649bc7b7.jpg'),(622,'rrrrr',2,'The Market Tote is a gorgeous everyday tote. It can handle your everyday tasks with ease. It is fully handcrafted right from the first cut. It features an inside pocket for all of your valuables. It\'s perfect for the person who needs all of her things at their finger tips. It measures 16\" wide <p><li>(at mouth)<li>, 13.5\" tall,</li> and 6\" <li>deep at the  base.</li></p>','2023-03-11',25.36,'file/mainPhotoTitle/fd96bb9e-b6f1-46e6-b14f-f4dd0a185420.jpg'),(623,'nnnn',2,'<p>The Long Wallet is a unisex leather wallet for the person who carries everything. Whether itâs cash, coins, cards, or receipts, the Long Wallet has got you covered. Made from the finest leathers and highest quality hardware, this wallet will age beautifully and only get better with time. Built for life.{/p}\r\n\r\n<p>Features:{/p}\r\n\r\n<ul>\r\n\r\n<li>100% handcrafted by a single craftsman{/li}\r\n<li> Fairtrade made - Ethnically sourced materials{/li}\r\n<li> 6 Card Pockets (holds 2-3 cards each){/li}\r\n<li> 3 Large bill/receipt pockets{/li}\r\n<li> 1 Large zippered pocket for coins and other things{/li}\r\n<li> Machine Stitched with bonded nylon thread{/li}\r\n{/ul}\r\n\r\n<p>Additional paragraph. (If necessary, you can add paragraphs by framing them with brackets){/p}','2023-03-14',23.63,'file/mainPhotoTitle/703df2a2-a47e-4b7e-9075-469922d4b9e2.jpg'),(624,'ooooo',1,'{p}The Long Wallet is a unisex leather wallet for the person who carries everything. Whether itâs cash, coins, cards, or receipts, the Long Wallet has got you covered. Made from the finest leathers and highest quality hardware, this wallet will age beautifully and only get better with time. Built for life.{/p}\r\n\r\n{p}Features:{/p}\r\n\r\n{ul}\r\n\r\n{li}100% handcrafted by a single craftsman{/li}\r\n{li} Fairtrade made - Ethnically sourced materials{/li}\r\n{li} 6 Card Pockets (holds 2-3 cards each){/li}\r\n{li} 3 Large bill/receipt pockets{/li}\r\n{li} 1 Large zippered pocket for coins and other things{/li}\r\n{li} Machine Stitched with bonded nylon thread{/li}\r\n{/ul}\r\n\r\n{p}Additional paragraph. (If necessary, you can add paragraphs by framing them with brackets){/p}','2023-03-14',41.36,'file/mainPhotoTitle/ff9655c6-f199-40c0-86ba-5b6e3ca303d6.jpg'),(625,'nnnnnn',3,'{p}The Long Wallet is a unisex leather wallet for the person who carries everything. Whether itâs cash, coins, cards, or receipts, the Long Wallet has got you covered. Made from the finest leathers and highest quality hardware, this wallet will age beautifully and only get better with time. Built for life.{/p}\r\n\r\n{p}Features:{/p}\r\n\r\n{ul}\r\n\r\n{li}100% handcrafted by a single craftsman{/li}\r\n{li} Fairtrade made - Ethnically sourced materials{/li}\r\n{li} 6 Card Pockets (holds 2-3 cards each){/li}\r\n{li} 3 Large bill/receipt pockets{/li}\r\n{li} 1 Large zippered pocket for coins and other things{/li}\r\n{li} Machine Stitched with bonded nylon thread{/li}\r\n{/ul}\r\n\r\n{p}Additional paragraph. (If necessary, you can add paragraphs by framing them with brackets){/p}','2023-03-15',23.36,'file/mainPhotoTitle/6b9ac3f9-c24a-4982-84a2-b7cae9e6bd22.jpg'),(626,'cvcvcvc',1,'{p}The Long Wallet is a unisex leather wallet for the person who carries everything. Whether itâs cash, coins, cards, or receipts, the Long Wallet has got you covered. Made from the finest leathers and highest quality hardware, this wallet will age beautifully and only get better with time. Built for life.{/p}\r\n\r\n{p}Features:{/p}\r\n\r\n{ul}\r\n\r\n{li}100% handcrafted by a single craftsman{/li}\r\n{li} Fairtrade made - Ethnically sourced materials{/li}\r\n{li} 6 Card Pockets (holds 2-3 cards each){/li}\r\n{li} 3 Large bill/receipt pockets{/li}\r\n{li} 1 Large zippered pocket for coins and other things{/li}\r\n{li} Machine Stitched with bonded nylon thread{/li}\r\n{/ul}\r\n\r\n{p}Additional paragraph. (If necessary, you can add paragraphs by framing them with brackets){/p}','2023-03-15',52.36,'file/mainPhotoTitle/adf7f3fe-438f-4d47-9325-08594b44bea6.jpg');
/*!40000 ALTER TABLE `bag_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-16 23:15:42
