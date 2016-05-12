SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `estacionamiento` ;
CREATE SCHEMA IF NOT EXISTS `estacionamiento` DEFAULT CHARACTER SET utf8 ;
USE `estacionamiento` ;

-- -----------------------------------------------------
-- Table `estacionamiento`.`cajon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estacionamiento`.`cajon` ;

CREATE TABLE IF NOT EXISTS `estacionamiento`.`cajon` (
  `Numero` INT(11) NOT NULL,
  `Estado` INT(11) NOT NULL,
  PRIMARY KEY (`Numero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacionamiento`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estacionamiento`.`cliente` ;

CREATE TABLE IF NOT EXISTS `estacionamiento`.`cliente` (
  `Placa` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NULL DEFAULT NULL,
  `Marca_modelo` VARCHAR(45) NOT NULL,
  `Cajon_Numero` INT(11) NOT NULL,
  PRIMARY KEY (`Placa`),
  INDEX `fk_Cliente_Cajon1_idx` (`Cajon_Numero` ASC),
  CONSTRAINT `fk_Cliente_Cajon1`
    FOREIGN KEY (`Cajon_Numero`)
    REFERENCES `estacionamiento`.`cajon` (`Numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacionamiento`.`recibo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estacionamiento`.`recibo` ;

CREATE TABLE IF NOT EXISTS `estacionamiento`.`recibo` (
  `Folio` INT(11) NOT NULL,
  `Cliente` VARCHAR(45) NOT NULL,
  `Tiempo` INT(11) NOT NULL,
  `Importe` INT(11) NOT NULL,
  `Tipo_pago` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Folio`),
  INDEX `Cliente_idx` (`Cliente` ASC),
  CONSTRAINT `Cliente`
    FOREIGN KEY (`Cliente`)
    REFERENCES `estacionamiento`.`cliente` (`Placa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacionamiento`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estacionamiento`.`usuario` ;

CREATE TABLE IF NOT EXISTS `estacionamiento`.`usuario` (
  `idUsuario` INT(11) NOT NULL,
  `Nombre` VARCHAR(70) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `Puesto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
