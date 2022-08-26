-- MySQL Script generated by MySQL Workbench
-- Sun Aug 21 20:30:49 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eshopdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eshopdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eshopdb` DEFAULT CHARACTER SET utf8 ;
USE `eshopdb` ;

-- -----------------------------------------------------
-- Table `eshopdb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eshopdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `users_role` INT NOT NULL,
  `FIO` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8' NULL,
  `address` VARCHAR(45) CHARACTER SET 'utf8' NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `users_role_idx` (`users_role` ASC) VISIBLE,
  CONSTRAINT `users_role`
    FOREIGN KEY (`users_role`)
    REFERENCES `eshopdb`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eshopdb`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `item_info` VARCHAR(255) CHARACTER SET 'utf8' NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eshopdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_status` TINYINT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `eshopdb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eshopdb`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`payments` (
  `payment_sum` DOUBLE NOT NULL,
  `orders_id` INT NOT NULL,
  `bank_card_num` VARCHAR(45) CHARACTER SET 'utf8' NULL,
  `expiring_date` VARCHAR(45) CHARACTER SET 'utf8' NULL,
  PRIMARY KEY (`orders_id`),
  CONSTRAINT `fk_payments_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `eshopdb`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eshopdb`.`orders_has_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshopdb`.`orders_has_items` (
  `orders_id` INT NOT NULL,
  `items_id` INT NOT NULL,
  INDEX `fk_orders_has_items_items1_idx` (`items_id` ASC) VISIBLE,
  INDEX `fk_orders_has_items_orders1_idx` (`orders_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_items_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `eshopdb`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_items_items1`
    FOREIGN KEY (`items_id`)
    REFERENCES `eshopdb`.`items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
