CREATE DATABASE  IF NOT EXISTS `dbeducation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbeducation`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: dbeducation
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `aluassig`
--

DROP TABLE IF EXISTS `aluassig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluassig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idalumne` int(11) NOT NULL,
  `idassignatura` int(11) NOT NULL,
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idalumne_idx` (`idalumne`),
  KEY `idassignatura_idx` (`idassignatura`),
  CONSTRAINT `idalumne` FOREIGN KEY (`idalumne`) REFERENCES `alumne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idassignatura` FOREIGN KEY (`idassignatura`) REFERENCES `assignatura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluassig`
--

LOCK TABLES `aluassig` WRITE;
/*!40000 ALTER TABLE `aluassig` DISABLE KEYS */;
INSERT INTO `aluassig` VALUES (1,1,1,NULL),(2,1,2,NULL),(3,2,3,NULL),(4,2,4,NULL),(5,2,2,NULL),(6,3,2,NULL),(7,4,1,NULL),(8,4,2,NULL),(9,4,3,NULL);
/*!40000 ALTER TABLE `aluassig` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-14  8:22:16
