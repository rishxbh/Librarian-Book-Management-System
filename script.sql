create database assg5;
use assg5;
drop table if exists librarian;
create table librarian(
username varchar(255) primary key,
userpassword varchar(255),
full_name varchar(255)
);
insert into librarian values ('rishabh', '123', 'Rishabh Mehta');
insert into librarian values ('chiku', '456', 'Chiku Chiku');
insert into librarian values ('vaishnavi', '789', 'Vaishnavi Rohtangi');
CREATE TABLE `author` (
  `personid` int(11) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personid`)
);
CREATE TABLE `book` (
  `book_code` int(11) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `author_personid` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_code`),
  KEY `FKioknygm4pmy2606k40a9hfct4` (`author_personid`),
  CONSTRAINT `FKioknygm4pmy2606k40a9hfct4` FOREIGN KEY (`author_personid`) REFERENCES `author` (`personid`)
  );