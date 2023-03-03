

-- Create Account Table --

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `lock_status` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Role Table --

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Account Role Table -- 

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1f8y4iy71kb1arff79s71j0dh` (`account_id`),
  KEY `FKrs2s3m3039h0xt8d5yhwbuyam` (`role_id`),
  CONSTRAINT `FK1f8y4iy71kb1arff79s71j0dh` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKrs2s3m3039h0xt8d5yhwbuyam` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Category Table --

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Brand Table --

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_img_url` varchar(255) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin_place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Product Table --

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `description` longtext,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `register_day` varchar(255) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Guitar Table --

DROP TABLE IF EXISTS `guitar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guitar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `body_color` varchar(255) DEFAULT NULL,
  `body_wood` varchar(255) DEFAULT NULL,
  `delete_status` int DEFAULT NULL,
  `guitar_bag` varchar(255) DEFAULT NULL,
  `guitar_bridge` varchar(255) DEFAULT NULL,
  `guitar_nut` varchar(255) DEFAULT NULL,
  `guitar_pick_guards` varchar(255) DEFAULT NULL,
  `guitar_pickups` varchar(255) DEFAULT NULL,
  `guitar_string` varchar(255) DEFAULT NULL,
  `hardware_finish` varchar(255) DEFAULT NULL,
  `neck_curvature` varchar(255) DEFAULT NULL,
  `neck_inlay` varchar(255) DEFAULT NULL,
  `neck_material` varchar(255) DEFAULT NULL,
  `number_of_frets` varchar(255) DEFAULT NULL,
  `scale_length` varchar(255) DEFAULT NULL,
  `tuning_machine` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa8sgxcimp10bkf7pri1kc3osv` (`product_id`),
  CONSTRAINT `FKa8sgxcimp10bkf7pri1kc3osv` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Piano Table -- 

DROP TABLE IF EXISTS `piano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piano` (
  `id` int NOT NULL AUTO_INCREMENT,
  `connect_method` varchar(255) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `energy_consumption` varchar(255) DEFAULT NULL,
  `key_sensitivity` varchar(255) DEFAULT NULL,
  `max_polyphony` varchar(255) DEFAULT NULL,
  `number_of_keys` varchar(255) DEFAULT NULL,
  `number_of_sounds` varchar(255) DEFAULT NULL,
  `piano_accessories` varchar(255) DEFAULT NULL,
  `piano_amp` varchar(255) DEFAULT NULL,
  `piano_effect` varchar(255) DEFAULT NULL,
  `piano_function` varchar(255) DEFAULT NULL,
  `piano_metronome` varchar(255) DEFAULT NULL,
  `piano_size` varchar(255) DEFAULT NULL,
  `piano_sound` varchar(255) DEFAULT NULL,
  `piano_speaker` varchar(255) DEFAULT NULL,
  `piano_transpose` varchar(255) DEFAULT NULL,
  `piano_tuning` varchar(255) DEFAULT NULL,
  `piano_weight` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96igc4ta99e1ghin8vjs1uror` (`product_id`),
  CONSTRAINT `FK96igc4ta99e1ghin8vjs1uror` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create IMG URL Product Table -- 

DROP TABLE IF EXISTS `img_url_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img_url_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc13lysifshopiiqcfhpmgoabu` (`product_id`),
  CONSTRAINT `FKc13lysifshopiiqcfhpmgoabu` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Guide Table --

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guide` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `delete_status` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create IMG URL Guide Table --

DROP TABLE IF EXISTS `img_url_guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img_url_guide` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `guide_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9icx146si3pxpdemftkcym9v2` (`guide_id`),
  CONSTRAINT `FK9icx146si3pxpdemftkcym9v2` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create User Type Table -- 

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Address Table --

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address_detail` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `delete_status` int DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create User Table --

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `delete_status` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  `user_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc3b4xfbq6rbkkrddsdum8t5f0` (`account_id`),
  KEY `FKlrk9xrdps0emd6d5rx5x3ib6h` (`user_type_id`),
  CONSTRAINT `FKc3b4xfbq6rbkkrddsdum8t5f0` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKlrk9xrdps0emd6d5rx5x3ib6h` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Product Order Table --

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `payment_status` int DEFAULT NULL,
  `total_money` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9own0mc8gwle8cckiij9ubsl` (`user_id`),
  CONSTRAINT `FKa9own0mc8gwle8cckiij9ubsl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Create Product Order Detail Table --

DROP TABLE IF EXISTS `product_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delete_status` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `product_order_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg5s1ykclxle4tb3uuhefhapf8` (`product_id`),
  KEY `FKbf5d0t42sdrsnjmdhy5utm756` (`product_order_id`),
  CONSTRAINT `FKbf5d0t42sdrsnjmdhy5utm756` FOREIGN KEY (`product_order_id`) REFERENCES `product_order` (`id`),
  CONSTRAINT `FKg5s1ykclxle4tb3uuhefhapf8` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;









