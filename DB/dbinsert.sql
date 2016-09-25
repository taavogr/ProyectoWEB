-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbcursosvirtual
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbcursosvirtual
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbcursosvirtual` DEFAULT CHARACTER SET utf8 ;
USE `dbcursosvirtual` ;

-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`Temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`Temas` (
  `idTemas` INT(11) NOT NULL,
  `nombre_tema` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTemas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`curso` (
  `idCurso` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `idCategoria` INT(11) NOT NULL,
  `Monto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCurso`),
  INDEX `idCategoria_idx` (`idCategoria` ASC),
  CONSTRAINT `idCategoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `dbcursosvirtual`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NULL DEFAULT NULL,
  `DNI` VARCHAR(50) NULL DEFAULT NULL,
  `Correo` VARCHAR(50) NULL DEFAULT NULL,
  `Usuario` VARCHAR(50) NULL DEFAULT NULL,
  `Clave` VARCHAR(50) NULL DEFAULT NULL,
  `Rol` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`inscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`inscripcion` (
  `idInscripcion` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha_inscripcion` VARCHAR(45) NULL DEFAULT NULL,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  `idCurso` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idInscripcion`),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  INDEX `idCurso_idx` (`idCurso` ASC),
  CONSTRAINT `idCurso`
    FOREIGN KEY (`idCurso`)
    REFERENCES `dbcursosvirtual`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `dbcursosvirtual`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `dbcursosvirtual` ;

-- -----------------------------------------------------
-- procedure sp_insert_usuario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_usuario`(out p_estado varchar(200),
p_Nombre varchar(50), p_DNI varchar(50), p_Correo varchar(50),p_Usuario varchar(50),p_Clave varchar(50),
p_Rol varchar(50))
BEGIN
DECLARE EXIT handler for sqlexception,sqlwarning,not found
BEGIN
rollback;
set p_estado='Error en el proceso de insercion';
END;
start transaction;
set p_estado=null;
insert into usuario (Nombre,DNI,Correo,Usuario,Clave,Rol)
values (p_Nombre,p_DNI,p_Correo,p_Usuario,p_Clave,p_Rol);
set p_estado ='ok';
commit;




END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
