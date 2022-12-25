CREATE DATABASE  IF NOT EXISTS `BlogPost` 
use BlogPost;

DROP TABLE IF EXISTS `User`
CREATE TABLE `User`(
`id` int auto_increment,
`name` varchar(50),
`email` varchar(50),
`password` varchar(50),
PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `post`
CREATE TABLE post (
  id SERIAL PRIMARY KEY,
  title varchar DEFAULT NULL,
  excerpt varchar DEFAULT NULL,
  content varchar DEFAULT NULL,
  author varchar DEFAULT NULL,
  published_at timestamp ,
  is_published boolean,
  created_at timestamp ,
  updated_at timestamp  
);

DROP TABLE IF EXISTS `comment`

CREATE TABLE comment (
  id int  ,
  name varchar DEFAULT NULL,
  email varchar DEFAULT NULL,
  comment varchar DEFAULT NULL,
  post_id int,
  created_at timestamp ,
  updated_at timestamp , 
  constraint fk_post foreign key (post_id) References post(id)
);
