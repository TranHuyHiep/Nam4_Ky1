INSERT INTO Users (id, full_name, email, avatar_url, password)
VALUES 
  (1, 'John Doe', 'john.doe@example.com', 'anh1.jpg', '123'),
  (2, 'Viet Anh', 'vanh@gmail.com', 'anh2.jpg', '123'),
  (3, 'Hao The', 'hao@gmail.com', 'anh3.jpg', '123'),
  (4, 'Cong Dinh', 'dinh@gmail.com', 'anh4.jpg', '123'),
  (5, 'Hiep Tran', 'hiep@gmail.com', 'anh5.jpg', '123');

INSERT INTO UserInfo (id, is_active, study_at, working_at, favorites, other_info, date_of_birth, created_at)
VALUES 
  (1, 1, 'University of XYZ', 'ABC Corporation', 'Reading, Cooking', 'Additional info for John Doe', '1985-01-15', '2023-10-21 12:00:00'),
  (2, 1, 'University of ABC', 'DEF Company', 'Hiking, Painting', 'Additional info for Jane Doe', '1990-05-20', '2023-10-21 12:10:00'),
  (3, 1, 'University of PQR', 'GHI Industries', 'Traveling, Photography', 'Additional info for Bob Smith', '1988-11-30', '2023-10-21 12:20:00'),
  (4, 1, 'University of MNO', 'JKL Corporation', 'Swimming, Playing guitar', 'Additional info for Alice Johnson', '1992-08-10', '2023-10-21 12:30:00'),
  (5, 1, 'University of UVW', 'XYZ Labs', 'Skiing, Gardening', 'Additional info for Eve Brown', '1987-04-05', '2023-10-21 12:40:00');

INSERT INTO UserRelas (id, follower, follwing, status)
VALUES 
  (1, 1, 2, 1),
  (2, 1, 3, 1),
  (3, 2, 3, 1),
  (4, 3, 4, 1),
  (5, 4, 5, 1);

INSERT INTO Posts (id, user_id, content, access_modifier, like_count, shared_post_id, created_at, updated_at, is_active)
VALUES 
  (1, 1, 'This is John Doe''s first post.', 'public', 0, NULL, '2023-10-21 13:00:00', '2023-10-21 13:00:00', 1),
  (2, 2, 'Jane Doe here! What''s up, everyone?', 'public', 0, NULL, '2023-10-21 13:10:00', '2023-10-21 13:10:00', 1),
  (3, 3, 'Hello from Bob Smith!', 'public', 0, NULL, '2023-10-21 13:20:00', '2023-10-21 13:20:00', 1),
  (4, 4, 'Greetings from Alice!', 'public', 0, NULL, '2023-10-21 13:30:00', '2023-10-21 13:30:00', 1),
  (5, 5, 'Eve Brown says hi!', 'public', 0, NULL, '2023-10-21 13:40:00', '2023-10-21 13:40:00', 1);

INSERT INTO Likes (id, user_id, post_id, comment_id)
VALUES 
  (1, 1, 2, NULL),
  (2, 2, 1, NULL),
  (3, 3, 1, NULL),
  (4, 4, 3, NULL),
  (5, 5, 5, NULL);

INSERT INTO Comments (id, user_id, post_id, parent_comment_id, content, created_at, updated_at, like_count, is_active)
VALUES 
  (1, 1, 2, NULL, 'Great post, Jane!', '2023-10-21 13:15:00', '2023-10-21 13:15:00', 3, 1),
  (2, 2, 1, NULL, 'Thanks, John!', '2023-10-21 13:05:00', '2023-10-21 13:05:00', 2, 1),
  (3, 3, 1, NULL, 'Hello Bob!', '2023-10-21 13:25:00', '2023-10-21 13:25:00', 1, 1),
  (4, 4, 3, NULL, 'Nice to meet you, Bob!', '2023-10-21 13:35:00', '2023-10-21 13:35:00', 2, 1),
  (5, 5, 5, NULL, 'Hi Eve!', '2023-10-21 13:45:00', '2023-10-21 13:45:00', 1, 1);

INSERT INTO Notifications (id, own_id, user_id, content, created_at, link)
VALUES 
  (1, 1, 2, 'You have a new follower: Jane Doe', '2023-10-21 13:30:00', '/profile/jane_doe'),
  (2, 2, 1, 'John Doe liked your post', '2023-10-21 13:35:00', '/post/1'),
  (3, 3, 1, 'Bob Smith commented on your post', '2023-10-21 13:40:00', '/post/1');

INSERT INTO Messengers (id, user_from, user_to, content, created_at)
VALUES 
  (1, 1, 2, 'Hi Jane!', '2023-10-21 13:45:00'),
  (2, 2, 1, 'Hello John!', '2023-10-21 13:50:00'),
  (3, 3, 1, 'Hey Bob!', '2023-10-21 13:55:00');

INSERT INTO Medias (id, post_id, url, is_active)
VALUES 
  (1, 1, 'https://example.com/media1.jpg', 1),
  (2, 2, 'https://example.com/media2.jpg', 1),
  (3, 3, 'https://example.com/media3.jpg', 1);