-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_racoon_brothers
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_role` int DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,NULL,'administrador','probando',1,_binary '',1,'2024-04-18 15:02:10.000','2024-05-10 03:37:08.775'),(2,'J240501194055','jesusthiago@gmail.com','J240501194055',2,_binary '\0',1,'2024-05-01 19:40:55.854','2024-05-01 19:40:55.854'),(3,'G240501202652','gerardojose@gmail.com','G240501202652',3,_binary '\0',1,'2024-05-01 20:26:52.782','2024-05-01 20:26:52.782'),(4,'y240507235308','yanpiercavero@gmail.com','y240507235308',4,_binary '\0',1,'2024-05-07 23:53:08.883','2024-05-07 23:53:08.883'),(5,'G240508162307','gonzalo@gmail.com','G240508162307',4,_binary '\0',1,'2024-05-08 16:23:07.675','2024-05-08 16:23:07.675'),(6,'P1715234495406','pablo@gmail.com','P1715234495406',3,_binary '\0',1,'2024-05-09 01:01:35.406','2024-05-09 01:01:35.406'),(7,'L1715305705925','caveroporroluis@gmail.com','L1715305705925',3,_binary '\0',1,'2024-05-09 20:48:25.925','2024-05-09 20:48:25.925'),(8,'L1715305959580','caveroporrolu@gmail.com','L1715305959580',3,_binary '\0',1,'2024-05-09 20:52:39.580','2024-05-09 20:52:39.580');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_attendances`
--

DROP TABLE IF EXISTS `history_attendances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `history_attendances` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_account` bigint DEFAULT NULL,
  `entry_time` datetime(3) DEFAULT NULL,
  `departure_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_attendances`
--

LOCK TABLES `history_attendances` WRITE;
/*!40000 ALTER TABLE `history_attendances` DISABLE KEYS */;
INSERT INTO `history_attendances` VALUES (12,4,'2024-05-06 00:47:48.064','2024-05-06 15:55:54.245'),(13,4,'2024-05-07 16:17:41.840','2024-05-07 16:17:47.659'),(14,4,'2024-05-08 16:18:29.720','2024-05-08 16:19:16.257'),(16,5,'2024-05-08 17:22:47.369','2024-05-08 17:22:48.971');
/*!40000 ALTER TABLE `history_attendances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_stock`
--

DROP TABLE IF EXISTS `history_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `history_stock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_stock` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `price_unit` double(6,2) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_stock`
--

LOCK TABLES `history_stock` WRITE;
/*!40000 ALTER TABLE `history_stock` DISABLE KEYS */;
INSERT INTO `history_stock` VALUES (1,12,'PAPA BLANCA','KG',3.70,100,'2024-05-09 01:38:08.062'),(2,12,'PAPA BLANCA','KG',3.70,100,'2024-05-09 01:39:55.301'),(3,1,'pan','100 unidades',20.00,0,'2024-05-09 02:11:18.572'),(4,1,'PAN','100 UNIDADES',20.00,0,'2024-05-09 02:31:34.506'),(5,1,'PAN','100 UNIDADES',20.00,0,'2024-05-09 02:31:55.135'),(8,15,'PAPA AMARILLA','KG',3.50,0,'2024-05-09 02:37:16.139'),(9,15,'PAPA AMARILLA','5KG',17.50,0,'2024-05-09 02:38:05.615'),(10,15,'PAPA AMARILLA','5KG',17.50,0,'2024-05-09 02:38:07.074'),(11,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:38:24.883'),(12,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:38:32.880'),(13,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:39:50.829'),(14,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:41:08.726'),(15,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:42:37.419'),(16,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:44:56.236'),(17,15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:45:47.571');
/*!40000 ALTER TABLE `history_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `new_table` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_account` bigint DEFAULT NULL,
  `id_person` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `read` bit(1) DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_products`
--

DROP TABLE IF EXISTS `order_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `order_products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_record_orders` bigint DEFAULT NULL,
  `product_code` varchar(45) DEFAULT NULL,
  `amount_product` int DEFAULT NULL,
  `price_products` double(6,2) DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_products`
--

LOCK TABLES `order_products` WRITE;
/*!40000 ALTER TABLE `order_products` DISABLE KEYS */;
INSERT INTO `order_products` VALUES (13,7,'H20000',2,7.00,'2024-05-07 12:35:57.157','2024-05-07 12:35:57.157'),(14,7,'H200001',1,2.50,'2024-05-07 12:35:57.201','2024-05-07 12:35:57.201'),(15,7,'H200002',3,7.50,'2024-05-07 12:35:57.211','2024-05-07 12:35:57.211'),(16,8,'H20000',2,7.00,'2024-05-07 12:36:20.036','2024-05-07 12:36:20.036'),(17,8,'H200001',1,2.50,'2024-05-07 12:36:20.043','2024-05-07 12:36:20.043'),(18,8,'H200002',3,7.50,'2024-05-07 12:36:20.046','2024-05-07 12:36:20.046'),(19,12,'H20000',2,7.00,'2024-05-07 19:57:40.999','2024-05-07 19:57:40.999'),(20,12,'H200001',1,2.50,'2024-05-07 19:57:41.018','2024-05-07 19:57:41.018'),(21,12,'H200002',3,7.50,'2024-05-07 19:57:41.023','2024-05-07 19:57:41.023'),(22,13,'H20000',2,7.00,'2024-05-07 21:03:47.327','2024-05-07 21:03:47.327'),(23,13,'H200001',1,2.50,'2024-05-07 21:03:47.347','2024-05-07 21:03:47.347'),(24,13,'H200002',3,7.50,'2024-05-07 21:03:47.352','2024-05-07 21:03:47.352');
/*!40000 ALTER TABLE `order_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp`
--

DROP TABLE IF EXISTS `otp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `otp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_account` bigint DEFAULT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `expiration_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp`
--

LOCK TABLES `otp` WRITE;
/*!40000 ALTER TABLE `otp` DISABLE KEYS */;
INSERT INTO `otp` VALUES (1,1,'$2a$10$4vLeK1lBkA4Jcq2w1.QC8eMA/M3XwbR1k.jQIMgSU3C/S.zb3UJSW','2024-04-24 00:07:11.296','2024-04-25 00:07:11.296');
/*!40000 ALTER TABLE `otp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `mother_lastname` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cellphone` varchar(9) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `id_account` bigint DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'LUIS YANPIER','CAVERO','PORRO','caveroporroluis@gmail.com','950793719','99999999',1,NULL,'2024-05-10 03:33:56.648'),(2,'JESUS','THIAGO','TORRES','jesusthiago@gmail.com','999777888','99988877',2,'2024-05-01 19:40:55.809',NULL),(3,'GERARDO','JOSE','ALVAREX','gerardojose@gmail.com','999777887','99988876',3,'2024-05-01 20:26:52.780',NULL),(4,'YANPIER','CAVERO','PORRO','yanpiercavero@gmail.com','99977788','99988874',4,'2024-05-07 23:53:08.880','2024-05-09 01:04:55.647'),(5,'GONZALO','GONZALEZ','GARCIA','gonzalo@gmail.com','99977785','99988879',5,'2024-05-08 16:23:07.674','2024-05-08 16:23:07.674'),(6,'PABLO','PEREZ','PONTE','pablo@gmail.com','99977787','99988878',6,'2024-05-09 01:01:35.404','2024-05-09 01:01:35.404'),(7,'LUIS','CAVERO','PORRO','caveroporrol@gmail.com','950793717','73941627',7,'2024-05-09 20:48:25.922','2024-05-09 20:48:25.922'),(8,'LUI','CAVER','PORR','caveroporrolu@gmail.com','95079371','7394162',8,'2024-05-09 20:52:39.580','2024-05-09 20:52:39.580');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` double(6,2) DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'H20000','hamburguesa con doble carne',3.50,'2024-05-01 21:39:45.019','2024-05-01 21:39:45.019'),(2,'H200001','hamburguesa con queso',2.50,'2024-05-07 02:00:31.350','2024-05-07 02:00:31.350'),(3,'H200002','hamburguesa con pollo',2.50,'2024-05-07 02:06:47.667','2024-05-07 02:06:47.667');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_notices`
--

DROP TABLE IF EXISTS `record_notices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `record_notices` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_account` bigint DEFAULT NULL,
  `id_person` bigint DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `read_boss` int DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_notices`
--

LOCK TABLES `record_notices` WRITE;
/*!40000 ALTER TABLE `record_notices` DISABLE KEYS */;
INSERT INTO `record_notices` VALUES (1,4,4,'Me olvidé la contraseña, por favor restablezcala',NULL,'2024-05-10 09:20:42.489','2024-05-10 09:20:42.489'),(2,4,4,'Me olvidé la contraseña, por favor restablezcala',0,'2024-05-10 09:21:26.988','2024-05-10 09:21:26.988');
/*!40000 ALTER TABLE `record_notices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_orders`
--

DROP TABLE IF EXISTS `record_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `record_orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_code` varchar(45) DEFAULT NULL,
  `client_name` varchar(100) DEFAULT NULL,
  `id_account` bigint DEFAULT NULL,
  `order_price` double(6,2) DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_orders`
--

LOCK TABLES `record_orders` WRITE;
/*!40000 ALTER TABLE `record_orders` DISABLE KEYS */;
INSERT INTO `record_orders` VALUES (7,'RBRO202405071','John Doe',2,17.00,'2024-05-07 12:35:57.216'),(8,'RBRO202405072','John Doe',2,17.00,'2024-05-07 12:36:20.057'),(9,'RBRO202405073','John Doe',2,17.00,NULL),(10,'RBRO202405074','John Doe',2,17.00,NULL),(11,'RBRO202405075','John Doe',2,17.00,NULL),(12,'RBRO202405076','John Doe',3,17.00,'2024-05-07 19:57:41.029'),(13,'RBRO202405077','John Doe',3,17.00,'2024-05-07 21:03:47.359');
/*!40000 ALTER TABLE `record_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `requests` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `details` varchar(500) DEFAULT NULL,
  `read_request` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` enum('SUPERADMIN','JEFE','GERENTE','EMPLEADO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'SUPERADMIN'),(2,'JEFE'),(3,'GERENTE'),(4,'EMPLEADO');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `price_unit` double(6,2) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,'PAN','100 UNIDADES',20.00,0,'2024-05-09 00:07:20.966','2024-05-09 02:31:55.135'),(12,'PAPA BLANCA','KG',3.70,100,'2024-05-09 00:39:05.627','2024-05-09 01:39:55.295'),(13,'PAPAS AL HILO','KG',3.70,0,'2024-05-09 00:39:16.570','2024-05-09 00:39:16.570'),(15,'PAPA AMARILLA','5KG',17.50,100,'2024-05-09 02:37:16.143','2024-05-09 02:45:47.571');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-15  1:06:15
