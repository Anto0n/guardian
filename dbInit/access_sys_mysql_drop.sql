ALTER TABLE `user` DROP FOREIGN KEY `user_fk0`;

ALTER TABLE `citizenship` DROP FOREIGN KEY `citizenship_fk0`;

ALTER TABLE `city` DROP FOREIGN KEY `city_fk0`;

ALTER TABLE `department` DROP FOREIGN KEY `department_fk0`;

DROP TABLE IF EXISTS `user`;

DROP TABLE IF EXISTS `citizenship`;

DROP TABLE IF EXISTS `city`;

DROP TABLE IF EXISTS `photo`;

DROP TABLE IF EXISTS `department`;

