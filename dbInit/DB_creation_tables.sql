-- -----------------------------------------------------
-- Schema guardian
-- -----------------------------------------------------
# Drop SCHEMA guardian;
DROP SCHEMA IF EXISTS `guardian`;
CREATE SCHEMA IF NOT EXISTS `guardian`
  DEFAULT CHARACTER SET utf8;
USE `guardian`;

-- -----------------------------------------------------
-- Table `guardian`.`user`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `guardian`.`citizenship`;
DROP TABLE IF EXISTS `guardian`.`city`;
DROP TABLE IF EXISTS `guardian`.`department`;
DROP TABLE IF EXISTS `guardian`.`user`;
DROP TABLE IF EXISTS `guardian`.`photo`;
CREATE TABLE citizenship
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  citizenship VARCHAR(45) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE city
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  city VARCHAR(45) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE department
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  department VARCHAR(45) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE photo
(
  id        INT AUTO_INCREMENT
    PRIMARY KEY,
  userId    INT         NOT NULL,
  reference VARCHAR(45) NOT NULL
)
  ENGINE = InnoDB;

CREATE INDEX photo_user_id_fk
  ON photo (userId);

CREATE TABLE user
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  firstName     VARCHAR(45)                             ,
  lastName      VARCHAR(45)                             ,
  inn           INT                                     ,
  citizenshipId INT                                     ,
  birthDate     VARCHAR(45)                                     ,
  cityId        INT                                     ,
  tel           INT                                     ,
  departmentId  INT                                     ,
  createDate    TIMESTAMP DEFAULT CURRENT_TIMESTAMP      ON UPDATE CURRENT_TIMESTAMP,
  updateDate    TIMESTAMP DEFAULT '0000-00-00 00:00:00' ,
  CONSTRAINT user_citizenship_id_fk
  FOREIGN KEY (citizenshipId) REFERENCES citizenship (id),
  CONSTRAINT user_city_id_fk
  FOREIGN KEY (cityId) REFERENCES city (id),
  CONSTRAINT user_department_id_fk
  FOREIGN KEY (departmentId) REFERENCES department (id)
)
  ENGINE = InnoDB;

CREATE INDEX user_citizenship_id_fk
  ON user (citizenshipId);

CREATE INDEX user_city_id_fk
  ON user (cityId);

CREATE INDEX user_department_id_fk
  ON user (departmentId);

ALTER TABLE photo
  ADD CONSTRAINT photo_user_id_fk
FOREIGN KEY (userId) REFERENCES user (id) ON DELETE CASCADE;

