CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `status` int DEFAULT '1',
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `wallet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(50) DEFAULT NULL,
  `status` int DEFAULT '1',
  `user_id` bigint DEFAULT NULL,
  `id_parent` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ffrpnxaflomhdh0qfk2jcndo` (`user_id`),
  KEY `FK_idx` (`id_parent`),
  KEY `FK_idx1` (`id_parent`),
  CONSTRAINT `FK1` FOREIGN KEY (`id_parent`) REFERENCES `category` (`id`),
  CONSTRAINT `FK7ffrpnxaflomhdh0qfk2jcndo` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `money_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `wallet_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrvywh3noeo11kqky0fr1si7mx` (`wallet_id`),
  CONSTRAINT `FKrvywh3noeo11kqky0fr1si7mx` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `period` (
  `id` bigint NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `id_parent` bigint DEFAULT NULL,
	`start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idx` (`id_parent`),
  CONSTRAINT `FK` FOREIGN KEY (`id_parent`) REFERENCES `period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `plan` (
  `id` bigint NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `period_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Plan_User_idx` (`user_id`),
  KEY `FK_Plan_Period_idx` (`period_id`),
  CONSTRAINT `FK_Plan_Period` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
  CONSTRAINT `FK_Plan_User` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `plan_category` (
  `id` bigint NOT NULL,
  `plan_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `ammount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Plan_idx` (`plan_id`),
  KEY `FK_Category_idx` (`category_id`),
  CONSTRAINT `FK_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_Plan` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `time` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `wallet_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtfwlfspv2h4wcgc9rjd1658a6` (`wallet_id`),
  KEY `FK_Transaction_Category_idx` (`category_id`),
  CONSTRAINT `FK_Transaction_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKtfwlfspv2h4wcgc9rjd1658a6` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





