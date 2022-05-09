CREATE TABLE IF NOT EXISTS `dialogues` (
  `dialogue_serial` int NOT NULL AUTO_INCREMENT,
  `dialogue_id` varchar(255) NOT NULL,
  `chatroom_id` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `receive_user_id` varchar(255) NOT NULL,
  `receiver_deleted` tinyint NOT NULL DEFAULT '0',
  `receiver_readed` tinyint NOT NULL DEFAULT '0',
  `send_user_id` varchar(255) NOT NULL,
  `sender_deleted` tinyint NOT NULL DEFAULT '0',
  `sender_readed` tinyint NOT NULL DEFAULT '1',
  `show` tinyint NOT NULL DEFAULT '1',
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`dialogue_serial`),
  UNIQUE KEY `dialogue_id_UNIQUE` (`dialogue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `chatroom` (
  `chatroom_id` varchar(255) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `created_user_id` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `latest_dialogue_id` varchar(255) DEFAULT NULL,
  `receive_user_id` varchar(255) NOT NULL,
  `status` varchar(225) NOT NULL,
  `trigger_by` varchar(255) NOT NULL,
  `BU_type` varchar(45) NOT NULL,
  `close` bit(1) NOT NULL DEFAULT b'0',
  `chatroomcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`chatroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `default_message` (
  `default_message_serial` int NOT NULL,
  `default_message_id` varchar(45) NOT NULL,
  `merchant_id` varchar(45) NOT NULL,
  `default_message_type` varchar(45) NOT NULL,
  `BU` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `message` varchar(200) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  PRIMARY KEY (`default_message_serial`),
  UNIQUE KEY `default_message_id_UNIQUE` (`default_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cases` (
  `case_id` varchar(45) NOT NULL,
  `slaesforce_case_id` varchar(45) NOT NULL,
  `BU` varchar(45) NOT NULL,
  `case_type` varchar(45) NOT NULL,
  `reference_no` varchar(45) NOT NULL,
  `attachment` text,
  `description` text,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  PRIMARY KEY (`case_id`),
  UNIQUE KEY `case_id_UNIQUE` (`slaesforce_case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `merchantchat`.`chatroom`
CHANGE COLUMN `latest_dialogue_id` `latest_dialogue_id` VARCHAR(255) NULL ;


CREATE TABLE IF NOT EXISTS `user_profile` (
  `user_id` int NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `user_type` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `trigger` (
  `trigger_serial` int NOT NULL AUTO_INCREMENT,
  `trigger_id` varchar(255) NOT NULL,
  `store_id` varchar(45) NOT NULL,
  `order_id` varchar(45) DEFAULT NULL,
  `sku_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trigger_serial`),
  UNIQUE KEY `trigger_id_UNIQUE` (`trigger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
