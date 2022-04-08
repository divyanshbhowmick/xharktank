/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.25 : Database - xharktank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xharktank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `xharktank`;

/*Table structure for table `offer` */

DROP TABLE IF EXISTS `offer`;

CREATE TABLE `offer` (
  `offer_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `comment` text NOT NULL,
  `equity` float NOT NULL,
  `investor` varchar(255) NOT NULL,
  `fk_pitch_id` bigint NOT NULL,
  PRIMARY KEY (`offer_id`),
  UNIQUE KEY `idx_pitchId_offerId` (`fk_pitch_id`,`offer_id`),
  CONSTRAINT `FKdc0m7rxtrk95m2m1gx1a5p2gn` FOREIGN KEY (`fk_pitch_id`) REFERENCES `pitch` (`pitch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `pitch` */

DROP TABLE IF EXISTS `pitch`;

CREATE TABLE `pitch` (
  `pitch_id` bigint NOT NULL AUTO_INCREMENT,
  `ask_amount` float NOT NULL,
  `entrepreneur` varchar(255) NOT NULL,
  `equity` float NOT NULL,
  `pitch_idea` text NOT NULL,
  `pitch_title` varchar(255) NOT NULL,
  PRIMARY KEY (`pitch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
