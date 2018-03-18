-- -----------------------------------------------------
-- Schema guardian
-- -----------------------------------------------------
# Drop SCHEMA guardian;
CREATE SCHEMA IF NOT EXISTS `guardian`
  DEFAULT CHARACTER SET utf8;
USE `guardian`;

-- -----------------------------------------------------
-- Table `guardian`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guardian`.`user`;

CREATE TABLE `user` (
  `id`            INT         NOT NULL AUTO_INCREMENT,
  `firstName`     VARCHAR(45) NOT NULL,
  `lastName`      VARCHAR(45) NOT NULL,
  `inn`           INT         NOT NULL,
  `citizenshipId` VARCHAR(45) NOT NULL,
  `birthDate`     INT         NOT NULL,
  `cityId`        VARCHAR(45) NOT NULL,
  `tel`           INT         NOT NULL,
  `photoExists`   INT,
  `departmentId`  VARCHAR(45) NOT NULL,
  `createDate`    TIMESTAMP   NOT NULL,
  `updateDate`    TIMESTAMP   NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `guardian`.`citizenship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guardian`.`citizenship`;

CREATE TABLE `citizenship` (
  `id`          INT         NOT NULL AUTO_INCREMENT,
  `citizenship` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `guardian`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guardian`.`city`;

CREATE TABLE `city` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `guardian`.`photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guardian`.`photo`;

CREATE TABLE `photo` (
  `id`        INT         NOT NULL AUTO_INCREMENT,
  `userId`    INT         NOT NULL,
  `reference` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `guardian`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guardian`.`department`;

CREATE TABLE `department` (
  `id`         INT         NOT NULL AUTO_INCREMENT,
  `department` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

#ALTER TABLE `user` DROP FOREIGN KEY `user_fk0`;
ALTER TABLE `guardian`.`user`
  ADD CONSTRAINT `fk_userId` FOREIGN KEY (`id`) REFERENCES `guardian`.`photo` (`userId`);

#ALTER TABLE `citizenship` DROP FOREIGN KEY `citizenship_fk0`;
ALTER TABLE `citizenship`
  ADD CONSTRAINT `citizenship_fk0` FOREIGN KEY (`id`) REFERENCES `user` (`citizenshipId`);

#ALTER TABLE `city` DROP FOREIGN KEY `city_fk0`;
ALTER TABLE `city`
  ADD CONSTRAINT `city_fk0` FOREIGN KEY (`id`) REFERENCES `user` (`cityId`);

#ALTER TABLE `department` DROP FOREIGN KEY `department_fk0`;
ALTER TABLE `department`
  ADD CONSTRAINT `department_fk0` FOREIGN KEY (`id`) REFERENCES `user` (`departmentId`);

