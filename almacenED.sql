-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema almacened
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema almacened
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almacened` DEFAULT CHARACTER SET utf8 COLLATE utf8_lithuanian_ci ;
USE `almacened` ;

-- -----------------------------------------------------
-- Table `almacened`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`persona` (
  `idpersona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(20) NOT NULL,
  `amaterno` VARCHAR(20) NOT NULL,
  `tipo_documento` VARCHAR(20) NOT NULL,
  `num_documento` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(100) NULL DEFAULT NULL,
  `telefono` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idpersona`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`cliente` (
  `idpersona` INT(11) NOT NULL,
  `codigo_cliente` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE INDEX `codigo_cliente_UNIQUE` (`codigo_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_persona_cliente`
    FOREIGN KEY (`idpersona`)
    REFERENCES `almacened`.`persona` (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`producto` (
  `idproducto` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `caracteristicas` VARCHAR(512) NULL DEFAULT NULL,
  `stock` INT(11) NOT NULL,
  `precio_venta` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB
AUTO_INCREMENT = 17403
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`trabajador` (
  `idpersona` INT(11) NOT NULL,
  `sueldo` DECIMAL(7,2) NOT NULL,
  `acceso` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpersona`),
  CONSTRAINT `fk_persona_trabajador`
    FOREIGN KEY (`idpersona`)
    REFERENCES `almacened`.`persona` (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`venta` (
  `idventa` INT(11) NOT NULL AUTO_INCREMENT,
  `idcliente` INT(11) NULL DEFAULT NULL,
  `idtrabajador` INT(11) NOT NULL,
  `fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idventa`),
  INDEX `fk_venta_cliente_idx` (`idcliente` ASC) VISIBLE,
  INDEX `fk_venta_trabajador_idx` (`idtrabajador` ASC) VISIBLE,
  CONSTRAINT `fk_venta_cliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `almacened`.`cliente` (`idpersona`),
  CONSTRAINT `fk_venta_trabajador`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `almacened`.`trabajador` (`idpersona`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`consumo` (
  `idconsumo` INT(11) NOT NULL AUTO_INCREMENT,
  `idventa` INT(11) NULL DEFAULT NULL,
  `idproducto` INT(11) NULL DEFAULT NULL,
  `cantidad` DECIMAL(7,2) NULL DEFAULT NULL,
  `precio_venta` DECIMAL(7,2) NULL DEFAULT NULL,
  PRIMARY KEY (`idconsumo`),
  INDEX `fk_consumo_producto_idx` (`idproducto` ASC) VISIBLE,
  INDEX `fk_consumo_venta_idx` (`idventa` ASC) VISIBLE,
  CONSTRAINT `fk_consumo_producto`
    FOREIGN KEY (`idproducto`)
    REFERENCES `almacened`.`producto` (`idproducto`),
  CONSTRAINT `fk_consumo_venta`
    FOREIGN KEY (`idventa`)
    REFERENCES `almacened`.`venta` (`idventa`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


-- -----------------------------------------------------
-- Table `almacened`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacened`.`pago` (
  `idpago` INT(11) NOT NULL AUTO_INCREMENT,
  `idventa` INT(11) NOT NULL,
  `tipo_comprobante` VARCHAR(20) NOT NULL,
  `num_comprobante` VARCHAR(20) NOT NULL,
  `igv` DECIMAL(4,2) NOT NULL,
  `total_pago` DECIMAL(7,2) NOT NULL,
  `fecha_emision` DATE NOT NULL,
  PRIMARY KEY (`idpago`),
  INDEX `fk_pago_venta_idx` (`idventa` ASC) VISIBLE,
  CONSTRAINT `fk_pago_venta`
    FOREIGN KEY (`idventa`)
    REFERENCES `almacened`.`venta` (`idventa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_lithuanian_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
