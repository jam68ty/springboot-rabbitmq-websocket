CREATE TABLE IF NOT EXISTS `dialogues` (
  `dialogue_serial` int NOT NULL AUTO_INCREMENT,
  `chatroom_id` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) NOT NULL,
  `dialogue_id` varchar(255) NOT NULL,
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
  `sender_user_id` varchar(255) NOT NULL,
  `receive_user_id` varchar(255) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `latest_dialogue_id` varchar(255),
  `trigger_by` varchar(255) NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
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



ALTER TABLE `merchantchat`.`chatroom`
CHANGE COLUMN `latest_dialogue_id` `latest_dialogue_id` VARCHAR(255) NULL ;


CREATE TABLE IF NOT EXISTS `cases` (
  `case_serial` int NOT NULL,
  `case_id` varchar(45) NOT NULL,
  `BU` varchar(45) NOT NULL,
  `case_type` varchar(45) NOT NULL,
  `reference_no` varchar(45) NOT NULL,
  `attachment` varchar(200),
  `description` varchar(200),
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  PRIMARY KEY (`case_serial`),
  UNIQUE KEY `case_id_UNIQUE` (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
