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
-- Table structure for table `bag_photo`
--

DROP TABLE IF EXISTS `bag_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bag_photo` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `bag_id` int DEFAULT NULL,
  `photo_title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `fk_photo_on_inform_id` (`bag_id`),
  CONSTRAINT `fk_photo_on_inform_id` FOREIGN KEY (`bag_id`) REFERENCES `bag_information` (`bag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bag_photo`
--

LOCK TABLES `bag_photo` WRITE;
/*!40000 ALTER TABLE `bag_photo` DISABLE KEYS */;
INSERT INTO `bag_photo` VALUES (107,610,'file/otherImages/0d6fc0c5-ca6e-4e3f-b94d-d84a4649e867.jpg'),(108,610,'file/otherImages/47494f63-3dd5-4f8c-8945-b5d9a036d7e0.jpg'),(109,610,'file/otherImages/fa186d82-c455-42ca-86a6-0a305015d95e.jpg'),(110,610,'file/otherImages/b4b2bbb3-2c08-44b9-a335-5c76d4d2e281.jpg'),(111,610,'file/otherImages/351c4a97-8e5e-4b59-bf3d-287049730308.jpg'),(112,610,'file/otherImages/758a8753-6f12-4f8d-81ee-76f1f95bc328.jpg'),(113,610,'file/otherImages/3979c9c7-723e-4511-9f7f-609619cf553d.jpg'),(114,610,'file/otherImages/062044f0-2ae0-4e3b-b48d-d4a104804b86.jpg'),(115,610,'file/otherImages/c7bbfa0f-e901-48bd-a079-bb9e1158f88a.jpg'),(116,611,'file/otherImages/7e30b4b1-c236-4cf4-b26d-3e52323c0245.jpg'),(117,611,'file/otherImages/5be1e559-5a1c-49b3-95b7-5b66344ac314.jpg'),(118,611,'file/otherImages/07d577b1-b943-4581-8dc2-35687eaca732.jpg'),(119,611,'file/otherImages/e7379739-482a-43f0-b6ff-6afa1048ae22.jpg'),(120,611,'file/otherImages/9248e621-7c70-4e38-8cd2-788b85113f6f.jpg'),(121,611,'file/otherImages/41e39f62-a3b2-43a7-9d51-5f8f01e485c2.jpg'),(122,612,'file/otherImages/2eebb47b-a689-430e-9e20-1637efc5931e.jpg'),(123,612,'file/otherImages/c042b645-f5b0-4d86-9e24-af5b36616f1d.jpg'),(124,612,'file/otherImages/25ea1805-998e-40a2-a481-5606741928a3.jpg'),(125,612,'file/otherImages/ed77a432-995c-4908-a3b2-0ff27d3cedf2.jpg'),(126,612,'file/otherImages/0782ccbc-3b80-48d2-89f0-9837e10f10f1.jpg'),(127,613,'file/otherImages/e710baea-6010-4172-ab8b-5432cda057d5.jpg'),(128,613,'file/otherImages/6c124df8-643c-45a6-9533-a3dada3f2981.jpg'),(129,613,'file/otherImages/c539cc8c-f1b8-465c-97d7-ed537efa3ef4.jpg'),(130,614,'file/otherImages/9ec0304a-a880-4533-99c6-1bf13b3e4d23.jpg'),(131,614,'file/otherImages/0986322f-4e11-4cdb-8e8f-74f2984e151d.jpg'),(132,614,'file/otherImages/b6d3ab03-dab8-4383-9512-7f5bd5c220d8.jpg'),(133,614,'file/otherImages/061befd4-f816-4da0-b266-1688b72cf31d.jpg'),(134,614,'file/otherImages/aee6591b-86c2-4a17-b3f1-aa0d8d862d83.jpg'),(135,614,'file/otherImages/b74b5cc6-bcfc-4d50-a399-6f2ed6d0ef20.jpg'),(136,614,'file/otherImages/7ccf599a-7ad6-4da9-85b0-c62513724b0c.jpg'),(137,615,'file/otherImages/9afcde95-df5f-462e-a10c-889a55bb58cf.jpg'),(138,615,'file/otherImages/164b0c03-936d-4601-b33f-dbda5a9cee55.jpg'),(139,615,'file/otherImages/44cebecf-fa66-4203-b191-d28dee17e8e8.jpg'),(140,615,'file/otherImages/4aecff01-0903-40c0-a7b6-c9ce6611e0aa.jpg'),(141,615,'file/otherImages/093d5882-cc8b-419f-b423-7d5ccb442779.jpg'),(142,616,'file/otherImages/68ed8de2-30d3-4864-8a9c-840df4f1138b.jpg'),(143,616,'file/otherImages/933b92c8-dce1-4106-8d4b-35676f468338.jpg'),(144,616,'file/otherImages/c017601d-4bbe-4dbd-9c01-6feb70cbbcf9.jpg'),(145,616,'file/otherImages/3fa6b138-d386-4749-b9e6-765056e30554.jpg'),(146,616,'file/otherImages/4500dae6-6437-4e7e-b89b-74933d6a0349.jpg'),(147,616,'file/otherImages/2869fbfc-f8a6-4fe9-8f80-a0bd2986301d.jpg'),(148,617,'file/otherImages/ab9739f2-644e-4f7a-9de1-c3190eeed686.jpg'),(149,617,'file/otherImages/559971aa-edc3-4af4-8cc1-f0a67f99e586.jpg'),(150,617,'file/otherImages/b4637c5c-ab8f-4de1-82b6-b41a4c9fac66.jpg'),(151,617,'file/otherImages/89f1e109-945e-46af-99dd-7bc412926ab5.jpg'),(152,617,'file/otherImages/8a5f4762-95bf-4b5f-821b-276fe30eec5f.jpg'),(153,618,'file/otherImages/d61bad8c-d5a2-462d-a740-6e1df506a62f.jpg'),(154,618,'file/otherImages/0afddf31-c760-4dea-830e-6611896ae74c.jpg'),(155,618,'file/otherImages/d3963e15-2e98-43ea-a7d1-b8722b5a3c32.jpg'),(156,618,'file/otherImages/384a91b3-a10d-4d74-bb99-d48edaf4ba08.jpg'),(157,619,'file/otherImages/4b778dd1-c353-4816-ba43-00404157ee41.jpg'),(158,619,'file/otherImages/eca90a9e-a023-4ae6-9c2e-d4571f6d5c3c.jpg'),(159,619,'file/otherImages/ef2463d9-1b49-428e-84ec-f71cac7f19b6.jpg'),(160,619,'file/otherImages/3676bd38-bc06-4812-a703-6a342dff39a5.jpg'),(161,619,'file/otherImages/f460bdae-6acf-4b1e-8757-d54a057bf65e.jpg'),(162,619,'file/otherImages/140db243-6262-43cb-9e57-1de209ecd056.jpg'),(163,619,'file/otherImages/0bccf834-6804-4178-a317-6c550106af26.jpg'),(164,619,'file/otherImages/cbb52b61-652e-4b95-86d2-65696bbf17b7.jpg'),(165,620,'file/otherImages/7a296346-ab1e-4050-a86c-1072e152c737.jpg'),(166,620,'file/otherImages/09736824-152f-4ac8-b037-a29ebae6a9c1.jpg'),(167,620,'file/otherImages/f9f4b808-fbfd-4aec-af76-0618c4d29c94.jpg'),(168,620,'file/otherImages/21275637-f6ca-401a-8786-03f4a0b9c59e.jpg'),(169,620,'file/otherImages/36a69ffa-e78d-4811-9bd6-693dce633b38.jpg'),(170,620,'file/otherImages/0532eabd-32e7-4e72-98c2-ebbc45653294.jpg'),(171,620,'file/otherImages/6c7869dd-454f-4fde-97a1-8968fe360479.jpg'),(172,621,'file/otherImages/e899d516-4950-4442-92f9-bf5adfab7e54.jpg'),(173,621,'file/otherImages/249e1a9a-9b20-40eb-bd5f-62f23c23a77c.jpg'),(174,621,'file/otherImages/3e2925c7-1e12-48ab-8f83-282f958d8edb.jpg'),(175,621,'file/otherImages/1c0e8e24-05f2-4f8a-b7e2-7b88a7d0de10.jpg'),(176,621,'file/otherImages/30b32800-2238-4d7e-bde6-1d5b72435f04.jpg'),(177,621,'file/otherImages/7efb7ac7-b7fe-44a9-bbe1-415e97bf94d9.jpg'),(178,622,'file/otherImages/81dfe9ac-0486-4fb1-8340-afcd3d6b8dc9.jpg'),(179,622,'file/otherImages/673b3497-c908-4db7-91d9-e7a455ab3d24.jpg'),(180,623,'file/otherImages/a2460434-f81a-4981-afa8-73d10d3d9297.png'),(181,623,'file/otherImages/44bc89fb-73fc-4481-b8a8-74d804c31115.png'),(182,624,'file/otherImages/fbf7a581-86ca-4c07-9d94-fe13e37f91e2.jpg'),(183,624,'file/otherImages/35619f15-b67c-49d4-b6dd-189b7be7684f.jpg'),(184,625,'file/otherImages/0339d3db-3808-4ac3-b915-d238d5232483.jpg'),(185,625,'file/otherImages/b0406ce8-6931-4834-96ae-7c5e5505e577.jpg'),(186,626,'file/otherImages/30d2489d-e721-4f61-ad85-d8f18f3b5ba4.jpg'),(187,626,'file/otherImages/a9f95eb9-2b5b-4743-a66b-a56de965ce6e.jpg');
/*!40000 ALTER TABLE `bag_photo` ENABLE KEYS */;
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
