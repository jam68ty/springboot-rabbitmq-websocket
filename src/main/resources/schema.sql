CREATE TABLE IF NOT EXISTS `dialogues` (
  `dialogue_serial` int NOT NULL AUTO_INCREMENT,
  `dialogue_id` varchar(45) NOT NULL,
  `send_user_id` varchar(45) NOT NULL,
  `receive_user_id` varchar(45) NOT NULL,
  `sender_readed` tinyint NOT NULL,
  `receiver_readed` tinyint NOT NULL,
  `sender_deleted` tinyint NOT NULL,
  `receiver_deleted` tinyint NOT NULL,
  `type` varchar(45) NOT NULL,
  `content` varchar(50) NOT NULL,
  `show` tinyint NOT NULL,
  `created_date` date NOT NULL,
  `last_modified_date` date NOT NULL,
  PRIMARY KEY (`dialogue_serial`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci KEY_BLOCK_SIZE=16;
