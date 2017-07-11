-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: testrecorddatabase
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` mediumtext,
  `parent_category_id` bigint(20) DEFAULT NULL,
  `can_store_here` bit(1) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `parent_category_id` (`parent_category_id`),
  KEY `user_id_key2` (`user_id`),
  CONSTRAINT `parent_category_id` FOREIGN KEY (`parent_category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `user_id_key2` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `composer`
--

DROP TABLE IF EXISTS `composer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `composer` (
  `composer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(100) NOT NULL,
  `first_names` varchar(200) DEFAULT NULL,
  `description` mediumtext,
  `year_of_birth` int(11) DEFAULT NULL,
  `year_of_death` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`composer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductor` (
  `conductor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(100) NOT NULL,
  `first_names` varchar(200) DEFAULT NULL,
  `description` mediumtext,
  `year_of_birth` int(11) DEFAULT NULL,
  `year_of_death` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`conductor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `musicalwork`
--

DROP TABLE IF EXISTS `musicalwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musicalwork` (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `composer_id` bigint(20) NOT NULL,
  `order_number` int(11) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`work_id`),
  KEY `category_id` (`category_id`),
  KEY `composer_id` (`composer_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `composer_id` FOREIGN KEY (`composer_id`) REFERENCES `composer` (`composer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` mediumtext,
  `storage_id` bigint(20) DEFAULT NULL,
  `main_composer_id` bigint(20) DEFAULT NULL,
  `sub_storage_place` varchar(50) DEFAULT NULL,
  `record_condition` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `record_label` varchar(100) DEFAULT NULL,
  `record_type` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `extra_info` mediumtext,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `storage_id` (`storage_id`),
  KEY `main_composer_id` (`main_composer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `main_composer_id` FOREIGN KEY (`main_composer_id`) REFERENCES `composer` (`composer_id`),
  CONSTRAINT `storage_id` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`storage_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `record_rendition`
--

DROP TABLE IF EXISTS `record_rendition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record_rendition` (
  `record_id` bigint(20) NOT NULL,
  `rendition_id` bigint(20) NOT NULL,
  `order_number` tinyint(4) NOT NULL,
  PRIMARY KEY (`rendition_id`),
  UNIQUE KEY `record_id_2` (`record_id`,`order_number`),
  KEY `record_id` (`record_id`),
  KEY `rendition_id` (`rendition_id`),
  CONSTRAINT `record_id` FOREIGN KEY (`record_id`) REFERENCES `record` (`record_id`),
  CONSTRAINT `rendition_id` FOREIGN KEY (`rendition_id`) REFERENCES `rendition` (`rendition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rendition`
--

DROP TABLE IF EXISTS `rendition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rendition` (
  `rendition_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `work_id` bigint(20) NOT NULL,
  `soloist_id` bigint(20) DEFAULT NULL,
  `conductor_id` bigint(20) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`rendition_id`),
  KEY `work_id` (`work_id`),
  KEY `soloist_id` (`soloist_id`),
  KEY `conductor_id` (`conductor_id`),
  CONSTRAINT `conductor_id` FOREIGN KEY (`conductor_id`) REFERENCES `conductor` (`conductor_id`),
  CONSTRAINT `soloist_id` FOREIGN KEY (`soloist_id`) REFERENCES `soloist` (`soloist_id`),
  CONSTRAINT `work_id` FOREIGN KEY (`work_id`) REFERENCES `musicalwork` (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `soloist`
--

DROP TABLE IF EXISTS `soloist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soloist` (
  `soloist_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(100) NOT NULL,
  `first_names` varchar(200) DEFAULT NULL,
  `description` mediumtext,
  `year_of_birth` int(11) DEFAULT NULL,
  `year_of_death` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`soloist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `storage_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` mediumtext,
  `parent_storage_id` bigint(20) DEFAULT NULL,
  `can_store_here` tinyint(4) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`storage_id`),
  KEY `parent_storage_id` (`parent_storage_id`),
  KEY `user_id_key` (`user_id`),
  CONSTRAINT `parent_storage_id` FOREIGN KEY (`parent_storage_id`) REFERENCES `storage` (`storage_id`),
  CONSTRAINT `user_id_key` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-11 18:20:09
