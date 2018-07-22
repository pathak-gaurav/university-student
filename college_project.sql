-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: college_project
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `college` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'University of Manchester',' Oxford Rd, Manchester M13 9PL, UK','Manchester','Manchester','+44 161 306 6000'),(2,'University of Nottingham','Nottingham NG7 2RD, UK','Nottingham','Nottingham','+44 115 951 5151'),(4,'Birmingham City University','The Parkside Building, 5 Cardigan St, Birmingham B4 7BD, UK','Birmingham','Birmingham','+44 121 331 50000'),(6,'University of Cambridge','The Old Schools, Trinity Ln, Cambridge CB2 1TN, UK','Cambridge','Cambridge','+44 1223 337733'),(7,'University of Edinburgh','Old College, South Bridge, Edinburgh EH8 9YL, UK','Edinburgh, Scotland','Edinburgh','+44 131 650 1000'),(8,'Durham University','Durham, UK','Durham','Durham','+44 191 334 2000'),(9,'University of Glasgow','University Avenue, Glasgow G12 8QQ, UK','Glasgow, Scotland','Glasgow','+44 141 330 2000'),(10,'University of Sussex','Falmer, Brighton BN1 9RH, UK','Brighton, England','Brighton','+44 1273 606755'),(11,'Warrington','Hendricks','Claifornia','Los Angeles','1234567890');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marksheet`
--

DROP TABLE IF EXISTS `marksheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marksheet` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `rollno` varchar(30) NOT NULL,
  `studentId` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `physics` int(11) DEFAULT NULL,
  `chemistry` int(11) DEFAULT NULL,
  `maths` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `studentId_fk_idx` (`studentId`),
  CONSTRAINT `studentId_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marksheet`
--

LOCK TABLES `marksheet` WRITE;
/*!40000 ALTER TABLE `marksheet` DISABLE KEYS */;
INSERT INTO `marksheet` VALUES (1,'1000A1',4,'Donald',77,81,93),(2,'1000A2',5,'Melenia',56,58,53),(3,'1000B1',13,'Barak',88,94,96),(6,'0207CS1026',18,'Jeremy',77,84,56);
/*!40000 ALTER TABLE `marksheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` int(11) NOT NULL DEFAULT '1',
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_STUDENT'),(4,'ROLE_KIOSK'),(5,'ROLE_COLLEGE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `studentId` int(1) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `collegeId` int(11) NOT NULL,
  `collegeName` varchar(45) NOT NULL DEFAULT 'Identified By College Id',
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4,'Donald','Trump',NULL,'65677','donald@trumptowers.com',4,'Identified By College Id'),(5,'Melenia','Trump',NULL,'76575','melenia@trumptowers.com',2,'Identified By College Id'),(13,'Barak','Obama',NULL,'6575757','barak@whitehouse.com',7,'Identified By College Id'),(14,'Zack','Effron',NULL,'57657','zack@effron.com',2,'Identified By College Id'),(15,'Anne Marie','Morris',NULL,'+44 7911 123451','anne@morris.com',2,'Identified By College Id'),(16,'Kelvin','Hopkins',NULL,'+44 7900 123426','kevin@hopkins.com',2,'Identified By College Id'),(17,'Ivan','Lewis',NULL,'+44 7911 123433','ivan@lewis.com',2,'Identified By College Id'),(18,'Jeremy','Corbyn',NULL,'+44 7911 103686','jeremy@corbyn.com',4,'Identified By College Id'),(19,'Theresa','May',NULL,'+44 7911 126390','theresa@may.com',4,'Identified By College Id'),(20,'Boris','Johnson',NULL,'+44 7911 124328','boris@johnson.com',4,'Identified By College Id'),(21,'David','Cameron','2018-07-10 00:00:00','+44 7911 120968','david@cameron.com',4,'Identified By College Id');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `userId` int(1) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `confirmPassword` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `roleId` int(1) NOT NULL DEFAULT '2',
  `gender` varchar(45) DEFAULT NULL,
  `lock` int(1) DEFAULT '1',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_roleid_idx` (`roleId`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Gaurav','Pathak','gaurav','gaurav','gaurav','1990-01-11','123',1,'M',1),(3,'Bill','Gates','bill','bill','bill',NULL,'2345',3,'M',1),(7,'Elon','Musk','elon','elon','elon',NULL,'65666',3,'M',1),(8,'Donald','Trump','donald','donald','donald',NULL,'76575',3,'M',1),(10,'University of Nottingham','N/A','nottingham','nottingham','nottingham',NULL,'+44 121 331 50000',5,'N/A',1),(11,'Melenia','Trump','melenia','melenia','melenia',NULL,'+12125018853',2,'F',1),(12,'Birmingham City University','N/A','birmingham','birmingham','birmingham',NULL,'55555',5,'N/A',1),(13,'Alfie','Days','alfie','alfie','alfie','2018-01-07','+44-7675670',2,'M',1),(17,'University of Edinburgh','N/A','edinburgh','edinburgh','edinburgh',NULL,'+44 131 650 1000',5,'N/A',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-22 18:50:20
