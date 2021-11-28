DROP DATABASE  IF EXISTS `ecommerce`;

CREATE DATABASE  IF NOT EXISTS `ecommerce`;
USE `ecommerce`;

--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `purchase_details`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;

CREATE TABLE auth_role (
  auth_role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  role_desc varchar(255) DEFAULT NULL,
  PRIMARY KEY (auth_role_id)
);

INSERT INTO auth_role VALUES (1,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO auth_role VALUES (2,'SITE_USER','This user has access to site, after login - normal user');

DROP TABLE IF EXISTS `shoe`;
CREATE TABLE `shoe` (
  `id` bigint primary key auto_increment,
  `brand` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `shoe_size` int(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `image` varchar(50) NULL
  
 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `shoe` 
VALUES 
(1,'Nike','Mx40-R','Best for Jogging','7','Men',20,49.99,''),
(2,'Addidas','45T-Model','Made for the best','7','Women',20,29.99,''),
(3,'Nike','YB500','Your perfect Match as a winner','3','kids',40,20.99,'');

CREATE TABLE auth_user (
  auth_user_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  status varchar(255),
  role_id int,
  PRIMARY KEY (auth_user_id)
);

CREATE TABLE auth_user_role (
  auth_user_id int(11) NOT NULL,
  auth_role_id int(11) NOT NULL,
  PRIMARY KEY (auth_user_id,auth_role_id),
  KEY FK_user_role (auth_role_id),
  CONSTRAINT FK_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_user (auth_user_id),
  CONSTRAINT FK_auth_user_role FOREIGN KEY (auth_role_id) REFERENCES auth_role (auth_role_id)
) ;

insert into auth_user (auth_user_id,first_name,last_name,email,password,status,role_id) values (1,'Jonathan','Mabiala','admin@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED',1);
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','1');







CREATE TABLE purchase_details ( 
	id bigint primary key auto_increment, 
	username varchar(100), 
    shoe_brand varchar(100),
    shoe_name varchar(100),
    unit int,
    email varchar(100) DEFAULT NULL,
	price decimal(10,2), 
    category varchar(100) DEFAULT NULL,
	date_added timestamp default now()
  
 )engine=innodb; 
