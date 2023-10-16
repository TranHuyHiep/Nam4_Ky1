CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `status` int(11) DEFAULT 1,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT 1,
  `id_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT 1,
  `user_id` bigint(20) DEFAULT NULL,
  `id_parent` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ffrpnxaflomhdh0qfk2jcndo` (`user_id`),
  KEY `FK_idx` (`id_parent`),
  KEY `FK_idx1` (`id_parent`),
  CONSTRAINT `FK1` FOREIGN KEY (`id_parent`) REFERENCES `category` (`id`),
  CONSTRAINT `FK7ffrpnxaflomhdh0qfk2jcndo` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `period` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `id_parent` bigint(20) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idx` (`id_parent`),
  CONSTRAINT `FK` FOREIGN KEY (`id_parent`) REFERENCES `period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `plan` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `period_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Plan_User_idx` (`user_id`),
  KEY `FK_Plan_Period_idx` (`period_id`),
  CONSTRAINT `FK_Plan_Period` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
  CONSTRAINT `FK_Plan_User` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `plan_category` (
  `id` bigint(20) NOT NULL,
  `plan_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Plan_idx` (`plan_id`),
  KEY `FK_Category_idx` (`category_id`),
  CONSTRAINT `FK_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_Plan` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `qr_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `wallet_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `id_qr` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtfwlfspv2h4wcgc9rjd1658a6` (`wallet_id`),
  KEY `FK_Transaction_Category_idx` (`category_id`),
  KEY `id_qr` (`id_qr`),
  CONSTRAINT `FK_Transaction_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKtfwlfspv2h4wcgc9rjd1658a6` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`id_qr`) REFERENCES `qr_code` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


