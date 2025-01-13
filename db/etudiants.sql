-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           9.1.0 - MySQL Community Server - GPL
-- SE du serveur:                Linux
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour etudiants
CREATE DATABASE IF NOT EXISTS `etudiants` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `etudiants`;

-- Listage de la structure de table etudiants. info
CREATE TABLE IF NOT EXISTS `info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  KEY `Index 1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table etudiants.info : ~15 rows (environ)
INSERT INTO `info` (`id`, `firstname`, `lastname`, `age`, `image`) VALUES
	(1, 'AIZAC', 'Etini', '19/03/2004', 'http://michael.moser.free.fr/img/2024/AIZAC.jpg'),
	(2, 'AUDRIN', 'Galen', '12/05/2005', 'http://michael.moser.free.fr/img/2024/AUDRIN.jpg'),
	(3, 'AULAGNIER', 'Romain', '29/12/2005', 'http://michael.moser.free.fr/img/2024/AULAGNIER.jpg'),
	(4, 'BEDEL', 'Evan', '27/10/2005', 'http://michael.moser.free.fr/img/2024/BEDEL.jpg'),
	(5, 'BILLET', 'Nicolas', '23/01/1992', 'http://michael.moser.free.fr/img/2024/BILLET.jpg'),
	(6, 'BOUYER', 'Corentin', '13/11/2003', 'http://michael.moser.free.fr/img/2024/BOUYER.jpg'),
	(7, 'DELOCHE', 'Baptiste', '09/09/2004', 'http://michael.moser.free.fr/img/2024/DELOCHE.jpg'),
	(8, 'GOISOT', 'Hugo', '22/06/2005', 'http://michael.moser.free.fr/img/2024/GOISOT.jpg'),
	(9, 'MENUT', 'Maël', '21/07/2001', 'http://michael.moser.free.fr/img/2024/MENUT.jpg'),
	(10, 'MOIRENC', 'Arthur', '07/07/2005', 'http://michael.moser.free.fr/img/2024/MOIRENC.jpg'),
	(11, 'PARLIER', 'Robin', '23/10/2004', 'http://michael.moser.free.fr/img/2024/PARLIER.jpg'),
	(12, 'PIRGARI', 'Sorin', '04/10/2004', 'http://michael.moser.free.fr/img/2024/PIRGARI.jpg'),
	(13, 'QUIRIN', 'Robin', '22/10/2004', 'http://michael.moser.free.fr/img/2024/QUIRIN.jpg'),
	(14, 'RICHARDSON', 'Joël', '29/03/2006', 'http://michael.moser.free.fr/img/2024/RICHARDSON.jpg'),
	(15, 'ROCHE', 'Oceane', '22/01/2003', 'http://michael.moser.free.fr/img/2024/ROCHE.jpg'),
	(16, 'ROMANENKO', 'Pavlo', '05/10/2004', 'http://michael.moser.free.fr/img/2024/ROMANENKO.jpg'),
	(17, 'SAN GEROTEO', 'Lucas', '18/01/2002', 'http://michael.moser.free.fr/img/2024/SAN_GEROTEO.jpg'),
	(18, 'ZAYANI', 'Souleyman', '13/09/2004', 'http://michael.moser.free.fr/img/2024/ZAYANI.jpg');

-- Listage de la structure de table etudiants. user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table etudiants.user : ~2 rows (environ)
INSERT INTO `user` (`id_user`, `role`, `username`, `password`) VALUES
	(1, 'admin', 'admin', 'Admin07!'),
	(2, 'user', 'user', 'User07!!');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
