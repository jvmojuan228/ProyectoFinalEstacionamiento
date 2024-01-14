-- MySQL dump 10.13  Distrib 8.1.0, for Linux (x86_64)
--
-- Host: localhost    Database: Estacionamiento
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `Estacionamiento`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `Estacionamiento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `Estacionamiento`;

--
-- Table structure for table `Entrada`
--

DROP TABLE IF EXISTS `Entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Entrada` (
  `idEntrada` bigint NOT NULL AUTO_INCREMENT,
  `fechahora` date NOT NULL,
  `idMoto` bigint DEFAULT NULL,
  `idSistemaControl` bigint DEFAULT NULL,
  PRIMARY KEY (`idEntrada`),
  KEY `FKjagc7hiksgtjju3y44owi186b` (`idMoto`),
  KEY `FKl7c5mghofrelx4ey94xwk1fhg` (`idSistemaControl`),
  CONSTRAINT `FKjagc7hiksgtjju3y44owi186b` FOREIGN KEY (`idMoto`) REFERENCES `Moto` (`idMoto`),
  CONSTRAINT `FKl7c5mghofrelx4ey94xwk1fhg` FOREIGN KEY (`idSistemaControl`) REFERENCES `SistemaControl` (`idSistemaControl`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Moto`
--

DROP TABLE IF EXISTS `Moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Moto` (
  `idMoto` bigint NOT NULL AUTO_INCREMENT,
  `marcaMoto` varchar(45) NOT NULL,
  `modeloMoto` varchar(45) NOT NULL,
  `placas` varchar(10) NOT NULL,
  `serieMoto` varchar(45) NOT NULL,
  `idUsuario` bigint DEFAULT NULL,
  PRIMARY KEY (`idMoto`),
  KEY `FKfon91tgbg7quu1cwcfcsvd3ps` (`idUsuario`),
  CONSTRAINT `FKfon91tgbg7quu1cwcfcsvd3ps` FOREIGN KEY (`idUsuario`) REFERENCES `Usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Salida`
--

DROP TABLE IF EXISTS `Salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Salida` (
  `idSalida` bigint NOT NULL AUTO_INCREMENT,
  `fechahora` date NOT NULL,
  `idMoto` bigint DEFAULT NULL,
  `idSistemaControl` bigint DEFAULT NULL,
  PRIMARY KEY (`idSalida`),
  KEY `FKsmt00nbjvo6m7tyiagbixkyc5` (`idMoto`),
  KEY `FKgg39u0cj6ju4nsdor3qs66hj5` (`idSistemaControl`),
  CONSTRAINT `FKgg39u0cj6ju4nsdor3qs66hj5` FOREIGN KEY (`idSistemaControl`) REFERENCES `SistemaControl` (`idSistemaControl`),
  CONSTRAINT `FKsmt00nbjvo6m7tyiagbixkyc5` FOREIGN KEY (`idMoto`) REFERENCES `Moto` (`idMoto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SistemaControl`
--

DROP TABLE IF EXISTS `SistemaControl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SistemaControl` (
  `idSistemaControl` bigint NOT NULL AUTO_INCREMENT,
  `acceso` varchar(50) NOT NULL,
  PRIMARY KEY (`idSistemaControl`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuarios` (
  `idUsuario` bigint NOT NULL AUTO_INCREMENT,
  `maternoUsuario` varchar(50) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `paternoUsuario` varchar(50) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-14  1:22:34
