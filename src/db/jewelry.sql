CREATE DATABASE  IF NOT EXISTS `store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `store`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: store
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `user_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `is_sold` tinyint DEFAULT NULL,
  `is_payed` tinyint DEFAULT NULL,
  `total` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_CART_ID_FK_idx` (`product_id`),
  KEY `USER_CART_ID_FK_idx` (`user_id`),
  CONSTRAINT `PRODUCT_CART_ID_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `USER_CART_ID_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (5,3,2,1,6800,1,1,6800),(149,3,2,1,6800,0,0,6800),(150,3,2,1,6800,1,1,6800),(151,3,2,1,6800,0,0,6800),(152,1,2,1,6800,0,0,6800),(153,2,2,1,7200,0,0,7200),(154,1,2,1,6800,0,0,6800),(155,1,2,9,6800,0,0,61200),(156,1,2,1,6800,0,0,6800),(157,1,2,1,6800,0,0,6800),(158,3,2,1,6800,0,0,6800);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cart_BEFORE_INSERT` BEFORE INSERT ON `cart` FOR EACH ROW BEGIN
set new.total = new.price * new.quantity;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cart_BEFORE_UPDATE` BEFORE UPDATE ON `cart` FOR EACH ROW BEGIN
set new.total = new.price * new.quantity;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Ring'),(2,'Bracelet'),(3,'Earring'),(4,'Necklace & Pendant'),(5,'Charm'),(6,'Watch'),(7,'Accessories');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gemstone`
--

DROP TABLE IF EXISTS `gemstone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gemstone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gemstone`
--

LOCK TABLES `gemstone` WRITE;
/*!40000 ALTER TABLE `gemstone` DISABLE KEYS */;
INSERT INTO `gemstone` VALUES (1,'Diamond'),(2,'Rubie'),(3,'Tiger\'s eye'),(4,'Opal'),(5,'No gemstone'),(6,'Yellow diamond'),(7,'Pearl');
/*!40000 ALTER TABLE `gemstone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Women'),(2,'Men'),(3,'Other');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Gold'),(2,'Sterling Silver'),(3,'Rose Gold'),(4,'White Gold'),(5,'Platinum'),(6,'Steel');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CATEGORY_ID_FK_idx` (`category_id`),
  KEY `GENDER_ID_FK_idx` (`gender_id`),
  CONSTRAINT `CATEGORY_ID_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `GENDER_ID_FK` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Diamond Vine Circle Pendant',4,6800.00,1,'With an intensity that rivals the night sky, we celebrate the blazing briliance of our diamonds.',' Mixed-cut diamonds add dimension to the fluid fronts of this striking pendant. 18k rose gold with round brilliant and marquise diamonds, size large.',30),(2,'Pearl and Diamond Earrings',3,7200.00,1,'Inspired by the fire and radiance of our superlative diamonds, we use a unique combination of cuts for a distinctly romantic sensibility. Platinum with South Sea cultured pearls and round brilliant diamonds.',' Pearls, 11-12 mm. Diamonds, carat total weight .57.',46),(3,'Makers 1.D. Tag Pendant  ',4,2100.00,2,'This rectangular I.D. tag pendant is designed is sterling silver and 18k gold for a sleek style statement. Crafted with a makers symbol inspired by the renowned Tiffany hollowware shop. Personalize this contemporary tag pendant with custom engraving.',' Sterling silver and 18k gold. Tag, 13x.7. On a 24\" chain.',48),(4,'Diamond and Pink Opal Circle Pendant',4,2550.00,1,'Traced with scintillating diamonds, this circle pendant features pink opal, a highly covetes stone found in nature. The luminous pink hue of the stone beautifully accents the radiant 18k rose gold design.','18k rose gold with pink opal and round brilliant diamonds. Circle, 16 mm diameter. Carat total weight 05.',50),(5,'Makers Bar Pendnt in 18k Gold',4,2800.00,2,'This pendant\'s statement-making vertical bar, designed in warm 18k gold, is accented with a makers symbol. Style this bar pendant on its own or mix and  match with other jewelry.','18k gold. Bar, 1.4\" long. On a 24\" chain.',50),(6,'Markers 27 mm Square Watch',6,3400.00,2,'Watch in stainless steel with a dark gray dial. 27 x 27 mm case. Self-winding mechanical movement.','Power reserve 38 hours. Water resistant to 50 meters/ 160 feet/5 ATM. Swiss-made.',50),(7,'Chronograpg 42 MM',6,5900.00,2,'Men\'s chronograph watch in stainless steel. White soleil dial features silver poudre numerals.','42 mm case. Self-winding mechanical movement. Power reserve 42 hours. Water resistant to 100 meters/ 330 feet/ 10 ATM. Swiss-made.',50),(8,'25 mm Round Watch',6,2500.00,1,'Watch in stainless steel, in a limited series of 5. 25 mm case with round briliant diamonds.','Carat total weight .03. Quartz movement. Water resistant to 30 meters/ 100 feet/ 3 ATM. Swiss-made',50),(9,'Tennis Bracelet',2,15500.00,1,'Inspired by the fire and radiance of our superlative diamonds, we use a unique combination of cuts for a distinctly romantic sesibility.','Platinum with diamonds. Marquise diamonds, carat total weight .18. Round brilliant diamonds, carat total weight2.90.',50),(10,'Olive Leaf Climber Earrings',3,325.00,1,'Inspired by the olive branch, a symbol of peace and abundance.','Original designs copyrighted by Paloma Picasso. Sterling silver.',50),(11,'Elephant Charm',5,275.00,1,'We always had a powerful relationship with nature and a long history of supporting wildlife conservation.','Sterling silver. Size mini.',50),(12,'Heartlocket pendant',4,2550.00,1,'Locket in 18k gold.','Size large. ',50),(13,'Engagement Ring in 18k Gold',1,24800.00,1,'A true design masterpiece, this ring is the most iconic engagement ring. Flawlessly engineered, the six-prong setting virtually disappears and alloes the brilliant diamond to float above the warm 18k yellow gold band into the light.','18k yellow gold with diamonds.',50),(14,'Bangle',2,66000.00,1,'The lyrical Paloma\'s Medoly collection is crafted from interloching bands that gently shift shape as they glide with the body, always falling back together as a whole.','18k withe gold. Size large. Round brilliant diamonds, carat total weight 13.96.',50),(15,'Color by the Yard Earrings',3,1100.00,1,'Earrings in 18k gold with two round rubies','Carat total weight .22. Original design copyrighted by Elsa Peretti',50),(16,'Five-row Ring',1,7400.00,1,'Streamlined and moder, the Tiffany Metro collection twinkles like a nighttime city skyline. five rows of dazzling diamonds make this ring a stunning statement piece','18k white gold with round brilliant diamonds. Carat total weight .90.',50),(17,'Cabochon Ring',1,2300.00,1,'A smooth, tactile cabochon in a fluid setting that is signature Peretti.','18k gold and tiger\'s eye. Size mini, 15.5 mm wide. ',50),(18,'Open Heart Pendant',4,1550.00,1,'The simple, evocative shape of Elsa Peretti Open Heart designs celebrates the spirit of love. A row of brilliant yellow diamonds accentuates the sensual curves of this pendant.','18k gold with five round yellow diamonds. 16 mm wide. Carat total weight .04',50),(19,'Diamond and Tiger\'sEye Circle Pendant',4,2550.00,1,'Traced with scintillating diamonds, this circle pendant features tiger\'s eye - a unique variety of quartz found in nature - resulting in a striking design with a silky finish.','18k gold tiger\'s eye and round brilliant diamonda. Circle, 16 mm diameter. Carat total weight .05.',50),(20,'Pearls by the Yard Bracelet',2,500.00,1,'Luminous pearls scattered along a delicate chain.','18k gold with five freshwater cultured pearls. Size medium. Pearls 6-6.5 mm.',50),(21,'Mother-of-pearl Wire Bracelet',2,1850.00,1,'This modern bracelet is emhanced with luminous mother-of-pearl a natural, iridescent material found is oyster shells-creating a bold design with high shine and elegant luster.','18k rise gold with mother-of-pearl. Size medium.',50),(22,'Makers 27 mm Square Watch',6,17000.00,2,'Watch in 18k rose gold with a rose gold soleil dial and applied gray numerals in a limited edition of 3.','On a gray alogator strap. 27 x 27 mm square case. Power reserve 42 hours. Water resistant to 50 meters/ 165 feet/5 ATM.',50),(23,'Hand 46.5 x 27.5 mm Watch',6,4100.00,2,'Watch in stainless steel. Blue guilloche dial features silver poudre numerals. On a blue aligator strap.','46.5 x 27.5 mm case. Self winding mechanical movement. Water resistant to 30 meter/ 100 feet/ 3 ATM.',50),(24,'Makers Wide Chain Bracelet',2,900.00,2,'Features sterling silver and 18k gold, this mixed metal wide chain bracelet captures the utilitarian spirit of classic American design.','Sterling silver and 18k gold. Size medium.',50),(25,'Cat Eye Sunglasses',7,367.00,1,'Graphic angles and clean lines blend to create the beautiful clarity of the Tiffany T eyewear collection. Designed with a sleek \"T\" motif, these bold cat eye frames add a touch of sophistication to any look.','Blue-gray with silver-colored metal accents',50),(34,'Freshwater Pearl Lock Bracelet in Sterling Silver',2,1600.00,1,'Tiffany HardWear is elegantly subversive and captures the spirit of the women of New York City. Bold sterling silver links are offset with lustrous pearls in this lock bracelet design.','Sterling silver with freshwater cultured pearls. Pearls, 7-8 mm each. Designed to be comfortable and easy to wear.',50),(35,'Pearl Triple Link Earrings in Sterling Silver',3,1100.00,1,'Tiffany HardWear is elegantly subversive and captures the spirit of the women of New York City. Dressed up or down, these earrings feature bold sterling silver links and sophisticated pearls.','Sterling silver with freshwater cultured pearls Pearls, 9.5-10 mm each Designed to be comfortable and easy to wear.',50),(36,'Makers Bar Cuff Links in 18k Gold',7,3800.00,3,'These statement-making cuff links feature a contemporary bar silhouette with a beveled edge. Crafted with a makers symbol inspired by the renowned Tiffany hollowware shop, the Tiffany 1837® Makers collection honors Tiffany\'s legacy of expert craftsmanship through a modern lens. Add these sleek cuff links to your favorite dress shirt for an elevated look.','18k gold. 21 mm long each',50),(37,'Venetian Link I.D. Bracelet',2,350.00,2,'Inspired by ancient Roman arches.','Men\'s bracelet in sterling silver. 7.5\" long.',50),(38,'2-Hand 25.6 x 42.4 mm Watch',6,17000.00,1,'Women\'s watch in 18k rose gold. White guilloché dial. On a black satin strap with a diamond buckle. 25.6 x 42.4 mm case set with round brilliant diamonds. Quartz movement. ','Water resistant to 30 meters/100 feet/3 ATM. Swiss-made. Carat total weight 1.53.',50),(39,'Crown Charm',5,175.00,1,'Royally appointed. Charm in sterling silver.','You can secure your charm to a bracelet with a clasping link, which is sold separately.',50),(40,'Ring',1,9500.00,1,'Ring in platinum with a ruby and a double row of round brilliant diamonds. 5.5 mm diameter. Round ruby, carat weight .50.','Round brilliant diamonds, carat total weight .36.',50),(41,'Pendant',5,5700.00,1,'Pendant in platinum with a ruby and a single row of round brilliant diamonds. 5 mm diameter. On a 16\" chain. Round ruby, carat weight .40.','Round brilliant diamonds, carat total weight .09.',50),(42,'Necklace',4,155000.00,1,'Diamonds and rubies in a variety of sizes are snugly set together in a precious path of dazzling cobblestones.','Platinum with diamonds and rubies. 30\" long. Round brilliant diamonds, carat total weight 9.08. Round rubies, carat total weight 15.51.',5),(43,'Heart Minaudière',7,2750.00,3,'Inspired by the iconic key ring first introduced in 1969, the Return to Tiffany collection is a classic reinvented. Crafted from sterling silver on a stainless steel chain, this compact minaudière adds an unexpected twist to any outfit.','Sterling silver on a stainless steel chain. 52\" long chain. .70\"H x 3.3\"L x 3.5\"W.',10),(44,'Snake Belt',7,7000.00,1,'The serpentine form carries streamlined modernity. Belt in sterling silver may also be worn as a necklace. The tail can be threaded through the snake-head clasp to adjust its length.',' 40\" long. Original designs copyrighted by Elsa Peretti.',5),(45,'Diamond Cluster Drop Necklace',4,12000.00,1,'Inspired by the idea of abstract flower petals, the Tiffany Paper Flowers collection is a balance of refined femininity and industrial modernity. Expertly crafted with stunning mixed-cut diamonds, this necklace embraces the effortless beauty found in nature.','Platinum with round brilliant and cushion-cut diamonds. Mini flower cluster, 12.5 x 12 mm. Small flower cluster, 14.5 x 14 mm. Carat total weight 1.40.',50),(46,'Oval Yellow Diamond Double Halo Engagement Ring in Platinum',1,60000.00,1,' With a scintillating halo of bead-set brilliant diamonds and a striking, masterfully cut oval center stone, light is gathered and mirrored throughout the design, resulting in an unrivaled display of brilliance. The oval center diamond is striking on its own, and made even more stately by a row of diamonds.','Designed to be comfortable and easy to wear',10),(47,'Sixteen Stone Ring',1,9800.00,1,'Jean Schlumberger’s visionary creations are among the world’s most intricate designs. Brilliant diamonds alternate with golden X\'s to create this dazzling design.','Jean Schlumberger’s visionary creations are among the world’s most intricate designs. Brilliant diamonds alternate with golden X\'s to create this dazzling design. Carat total weight 1.14',20),(48,'Elephant Brooch',7,35000.00,1,'Limited quantities available','18k white gold with round brilliant diamonds. Carat total weight 7.19',30),(49,'Wire Ring',1,950.00,1,'Featuring a bold \"T\" motif, this ring is stunning in its simplicity.','18k rose gold',50),(50,'Bracelet',2,850.00,1,'Tiffany Infinity is a powerful symbol of continuous connection, energy and vitality. The addition of endlessly looped double chains echoes the infinite nature of the design','18k rose gold. Medium, 6.75\" long',50),(51,'Ball Pendant',5,1800.00,1,'Tiffany HardWear is elegantly subversive and captures the spirit of the women of New York City. This simple and elegant pendant is a timeless design.','Designed to be comfortable and easy to wear. 18k rose gold. Adjustable, 18-20\"',50),(52,'Love charm and chain',5,1975.00,1,'Charm in 18k white and rose gold with round brilliant diamonds. On an 18k white gold chain. Carat total weight .12. Charm and chain sold separately.','Designed to be comfortable and easy to wear',25);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_gemstone`
--

DROP TABLE IF EXISTS `product_gemstone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_gemstone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `gemstone_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PG_GEMSTONE_ID_FK_idx` (`gemstone_id`),
  KEY `PG_PRODUCT_ID_FK_idx` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_gemstone`
--

LOCK TABLES `product_gemstone` WRITE;
/*!40000 ALTER TABLE `product_gemstone` DISABLE KEYS */;
INSERT INTO `product_gemstone` VALUES (1,1,1),(2,2,7),(3,3,5),(4,4,4),(5,5,4),(6,6,5),(7,7,5),(8,8,1),(9,9,1),(10,10,5),(11,11,5),(12,12,5),(13,13,1),(14,14,1),(15,15,2),(16,16,1),(17,17,3),(18,18,6),(19,19,3),(20,20,7),(21,21,7),(22,22,5),(23,23,5),(24,24,5),(25,25,5),(26,2,1),(27,34,7),(28,35,7),(29,36,5),(30,37,5),(55,38,1),(56,39,5),(57,40,1),(58,40,2),(59,41,1),(60,41,2),(61,42,1),(62,42,2),(63,43,5),(64,44,5),(65,45,1),(66,46,1),(67,46,6),(68,47,1),(69,48,1),(70,49,5),(71,50,5),(72,51,5),(73,52,1);
/*!40000 ALTER TABLE `product_gemstone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_material`
--

DROP TABLE IF EXISTS `product_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `material_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_ID_FK_idx` (`product_id`),
  KEY `MATERIAL_ID_FK_idx` (`material_id`),
  KEY `PM_PRODUCT_ID_FK_idx` (`product_id`),
  KEY `PM_MATERIAL_ID_FK_idx` (`material_id`),
  CONSTRAINT `PM_MATERIAL_ID_FK` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `PM_PRODUCT_ID_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_material`
--

LOCK TABLES `product_material` WRITE;
/*!40000 ALTER TABLE `product_material` DISABLE KEYS */;
INSERT INTO `product_material` VALUES (1,1,3),(2,2,5),(3,3,1),(4,4,3),(5,5,1),(6,6,6),(7,7,6),(8,8,6),(9,9,5),(10,10,2),(11,11,2),(12,12,1),(13,13,1),(14,14,4),(15,15,1),(16,16,4),(17,17,1),(18,18,1),(19,19,1),(20,20,1),(21,21,3),(22,22,3),(23,23,6),(24,24,2),(25,25,2),(26,3,2),(27,34,2),(28,35,2),(29,36,1),(30,37,2),(31,38,1),(32,39,2),(33,40,5),(34,41,5),(35,42,5),(36,43,2),(37,43,6),(38,44,2),(39,45,5),(40,46,5),(41,47,1),(42,48,4),(43,49,3),(44,50,3),(45,51,3),(46,52,3),(47,52,4);
/*!40000 ALTER TABLE `product_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `is_administrator` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'andreea','12345','Andreea','Adam','0784192326','andreea.adam21@yahoo.com',1),(2,'user','0000','Elena','Popa','0754268953','elena.popa@yahoo.com',0),(3,'mirela','9999','Mirela','Enache','0775268955','mirelaenache@yahoo.com',0),(4,'lavinia','1234','Lavinia','Adam','0785536201','adam.lavinia96@yahoo.com',1),(5,'alina','0000','Alina','Popa','0784526598','alinapopa@yahoo.com',0);
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

-- Dump completed on 2020-10-12 19:54:25
