CREATE TABLE `Users` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `full_name` nvarchar(127),
  `email` nvarchar(255),
  `avatar_url` nvarchar(255),
  `password` nvarchar(255)
);

CREATE TABLE `UserInfo` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `is_active` int,
  `study_at` Nvarchar(255),
  `working_at` Nvarchar(255),
  `favorites` Nvarchar(255),
  `other_info` Nvarchar(255),
  `date_of_birth` date,
  `created_at` datetime
);

CREATE TABLE `UserRelas` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `follower` BigInt,
  `follwing` BigInt,
  `status` int
);

CREATE TABLE `Posts` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `user_id` BigInt,
  `content` Nvarchar(255),
  `access_modifier` ENUM ('private', 'follower', 'public'),
  `like_count` int,
  `shared_post_id` BigInt,
  `created_at` datetime,
  `updated_at` datetime,
  `is_active` int
);

CREATE TABLE `Likes` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `user_id` BigInt,
  `post_id` BigInt,
  `comment_id` BigInt
);

CREATE TABLE `Comments` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `user_id` BigInt,
  `post_id` BigInt,
  `parent_comment_id` BigInt,
  `content` Nvarchar(255),
  `created_at` datetime,
  `updated_at` datetime,
  `like_count` int,
  `is_active` int
);

CREATE TABLE `Notifications` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `own_id` BigInt,
  `user_id` BigInt,
  `content` Nvarchar(255),
  `created_at` datetime,
  `link` Nvarchar(255)
);

CREATE TABLE `Messengers` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `user_from` BigInt,
  `user_to` BigInt,
  `content` Nvarchar(255),
  `created_at` datetime
);

CREATE TABLE `Medias` (
  `id` BigInt PRIMARY KEY AUTO_INCREMENT,
  `post_id` BigInt,
  `url` Nvarchar(255),
  `is_active` int
);

ALTER TABLE `UserInfo` ADD FOREIGN KEY (`id`) REFERENCES `Users` (`id`);

ALTER TABLE `UserRelas` ADD FOREIGN KEY (`follower`) REFERENCES `Users` (`id`);

ALTER TABLE `UserRelas` ADD FOREIGN KEY (`follwing`) REFERENCES `Users` (`id`);

ALTER TABLE `Posts` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Likes` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Likes` ADD FOREIGN KEY (`post_id`) REFERENCES `Posts` (`id`);

ALTER TABLE `Comments` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Comments` ADD FOREIGN KEY (`post_id`) REFERENCES `Posts` (`id`);

ALTER TABLE `Comments` ADD FOREIGN KEY (`parent_comment_id`) REFERENCES `Comments` (`id`);

ALTER TABLE `Likes` ADD FOREIGN KEY (`comment_id`) REFERENCES `Comments` (`id`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Notifications` ADD FOREIGN KEY (`own_id`) REFERENCES `Users` (`id`);

ALTER TABLE `Messengers` ADD FOREIGN KEY (`user_from`) REFERENCES `Users` (`id`);

ALTER TABLE `Messengers` ADD FOREIGN KEY (`user_to`) REFERENCES `Users` (`id`);

ALTER TABLE `Medias` ADD FOREIGN KEY (`post_id`) REFERENCES `Posts` (`id`);

DELIMITER $$

CREATE TRIGGER update_like_count_after_insert
AFTER INSERT ON Likes
FOR EACH ROW
BEGIN
  UPDATE Posts
  SET like_count = like_count + 1
  WHERE id = NEW.post_id;
END$$

CREATE TRIGGER update_like_count_after_delete
AFTER DELETE ON Likes
FOR EACH ROW
BEGIN
  UPDATE Posts
  SET like_count = like_count - 1
  WHERE id = OLD.post_id;
END$$

DELIMITER ;

DELIMITER $$
BEGIN
  -- Lấy thông tin người thích bài post
  SET @full_name := (SELECT full_name FROM Users WHERE id = NEW.user_id);

  -- Lấy thông tin người chủ post
  SET @post_owner_id := (SELECT user_id FROM Posts WHERE id = NEW.post_id);
  
  -- Lấy thông tin người chủ comment
  SET @comment_owner_id := (SELECT user_id FROM Comments WHERE id = NEW.comment_id);

  -- Tạo thông báo
  IF NEW.comment_id IS NOT NULL AND NEW.post_id IS NULL THEN
    INSERT INTO Notifications (own_id, user_id, content, created_at, link)
    SELECT @comment_owner_id, NEW.user_id, CONCAT(@full_name, ' liked your comment ', c.content), NOW(), ''
    FROM Comments c WHERE c.id = NEW.comment_id;
  ELSE
    INSERT INTO Notifications (own_id, user_id, content, created_at, link)
    SELECT @post_owner_id, NEW.user_id, CONCAT(@full_name, ' liked your post ', c.content), NOW(), ''
    FROM Posts c WHERE c.id = NEW.post_id;
  END IF;
END
DELIMITER ;

CREATE TRIGGER `update_count_likes_comment` AFTER INSERT ON `likes`
 FOR EACH ROW UPDATE comments
  SET like_count = like_count + 1
  WHERE id = NEW.comment_id;
  
CREATE TRIGGER `update_count_likes_comment_delete` AFTER DELETE ON `likes`
 FOR EACH ROW UPDATE comments
  SET like_count = like_count - 1
  WHERE id = OLD.comment_id;