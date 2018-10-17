-- MySQL Workbench Forward Engineering
DROP SCHEMA IF EXISTS legohus;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `legohus` DEFAULT CHARACTER SET latin1 ;
USE `legohus` ;

-- -----------------------------------------------------
-- Table `legohus`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohus`.`user` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `legohus`.`house_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legohus`.`house_order` (
  `idOrder` INT(11) NOT NULL AUTO_INCREMENT,
  `user_Id` INT(11) NOT NULL,
  `isShipped` TINYINT(1) NULL DEFAULT NULL,
  `hLength` INT(11) NOT NULL,
  `hWidth` INT(11) NOT NULL,
  `hHeight` INT(11) NOT NULL,
  `windowDoor` TINYINT(1) NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_User1_idx` (`User_Id` ASC),
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `legohus`.`user` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `user`
VALUES
(1, 'jeger@admin.com', '123', 'employee'),
(2, 'jens@somewhere.com', 'jensen', 'customer'),
(3, 'Customer@lego.com', 'lego', 'customer');

INSERT INTO `house_order`
VALUES
(1, 1, 0, 16, 6, 4, 0),
(2, 3, 0, 30, 30, 30, 1),
(3, 3, 1, 30, 30, 30, 1),
(4, 3, 0, 30, 10, 10, 1);