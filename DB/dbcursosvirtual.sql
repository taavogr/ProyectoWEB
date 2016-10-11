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
-- Table `dbcursosvirtual`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
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
AUTO_INCREMENT = 5
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
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`inscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`inscripcion` (
  `idInscripcion` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha_inscripcion` DATETIME NULL DEFAULT NULL,
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


-- -----------------------------------------------------
-- Table `dbcursosvirtual`.`temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcursosvirtual`.`temas` (
  `idTemas` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_tema` VARCHAR(45) NULL DEFAULT NULL,
  `id_curso` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idTemas`),
  INDEX `fk_curso_idx` (`id_curso` ASC),
  CONSTRAINT `fk_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `dbcursosvirtual`.`curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

USE `dbcursosvirtual` ;

-- -----------------------------------------------------
-- procedure sp_autenticar_usuario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_autenticar_usuario`(
	p_Usuario varchar(50),
	p_Clave varchar(50)
)
BEGIN
	select idUsuario,Nombre,DNI,Correo,Usuario,AES_DECRYPT(Clave,'llave') as Clave, Rol
    from usuario
    where Usuario=p_Usuario
    and Clave=p_clave;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_delete_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_categoria`(
	out p_estado varchar(200),
	p_idCategoria int
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	DELETE FROM categoria WHERE idCategoria=p_idCategoria;
	set p_estado='ok';
	commit;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_delete_curso
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_curso`(
	out p_estado varchar(200),
	p_idCurso int
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	DELETE FROM curso WHERE idCurso=p_idCurso;
	set p_estado='ok';
	commit;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_delete_inscripcion
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_inscripcion`(
	out p_estado varchar(200),
	p_idInscripcion int
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	DELETE FROM inscripcion WHERE idInscripcion=p_idInscripcion;
	set p_estado='ok';
	commit;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_get_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_categoria`(
p_idCategoria int
)
BEGIN
	select idCategoria,Nombre
    from categoria
    where idCategoria=p_idCategoria;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_get_curso
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_curso`(
p_idCurso int
)
BEGIN
	select c.idCurso,c.Nombre,c.idCategoria,ca.Nombre,Monto
    from curso c inner join categoria ca where c.idCategoria=ca.idCategoria and idCurso=p_idCurso;
    
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_get_inscripcion
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_inscripcion`(
p_idInscripcion int
)
BEGIN
	select Fecha_inscripcion,idUsuario,idCurso
    from inscripcion
    where idIncripcion=p_idInscripcion;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_get_temario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_temario`(
p_idTemas int
)
BEGIN
	select t.idTemas,t.nombre_tema,t.id_curso,c.nombre
    from temas t inner join curso c
    where idTemas=p_idTemas and c.idCurso=t.id_curso;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_get_usuario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_get_usuario`(
p_idUsuario int
)
BEGIN
	select Nombre,DNI,Correo,Usuario,Clave,Rol
	FROM usuario
    where idUsuario=p_idUsuario;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insert_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_categoria`(
	out p_estado varchar(200),
    p_Nombre varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='Error reinicie su modem :v';
END;
	start transaction;
	set p_estado=null;
	insert into categoria (Nombre)
	values (p_Nombre);
	set p_estado ='ok';
	commit;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insert_curso
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_curso`(
	out p_estado varchar(200),
    p_Nombre varchar(50),
    p_idCategoria int,
    p_Monto varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='error';
END;
	start transaction;
	set p_estado=null;
	insert into curso (Nombre,idCategoria,Monto)
    values (p_Nombre,p_idCategoria,p_Monto);
    set p_estado='ok';
	commit;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insert_inscripcion
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_inscripcion`(
	out p_estado varchar(200),
    p_Fecha_inscripcion varchar(50),
    p_idUsuario int,
    p_idCurso int
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
	BEGIN
	rollback;
	set p_estado='error';
END;
	start transaction;
	set p_estado=null;
	insert into inscripcion (Fecha_inscripcion,idUsuario,idCurso)
    value (now(),p_idUsuario,p_idCurso);
    set p_estado='ok';
	commit;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_insert_temario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_temario`(
	out p_estado varchar(200),
    p_nombre_tema varchar(50),
    p_id_curso int
)
BEGIN
	start transaction;
	set p_estado=null;
	insert into temas (nombre_tema,id_curso)
    value (p_nombre_tema,p_id_curso);
    set p_estado='ok';
	commit;
END$$

DELIMITER ;

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

-- -----------------------------------------------------
-- procedure sp_list_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_list_categoria`()
BEGIN
	select idCategoria,Nombre
    from categoria;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_list_curso
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_list_curso`()
BEGIN
	select c.idCurso,c.Nombre,ca.idCategoria,ca.Nombre,c.Monto
    from curso c inner join categoria ca where c.idCategoria=ca.idCategoria;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_list_temario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_list_temario`()
BEGIN
	select t.idTemas, t.nombre_tema, t.id_curso,c.nombre
    from temas t inner join curso c where t.id_curso=c.idCurso;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_update_categoria
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_categoria`(
	out p_estado varchar(200),
    p_idCategoria int,
    p_Nombre varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	UPDATE categoria
    set Nombre=p_Nombre
    where idCategoria=p_idCategoria;
    set p_estado='ok';
    commit;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_update_curso
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_curso`(
	out p_estado varchar(200),
    p_idCurso int,
    p_Nombre varchar(200),
    p_idCategoria int,
    p_Monto varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	UPDATE curso
    set Nombre=p_Nombre,
    idCategoria=p_idCategoria,
    Monto=p_Monto
    where idCurso=p_idCurso;
    set p_estado='ok';
    commit;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_update_temario
-- -----------------------------------------------------

DELIMITER $$
USE `dbcursosvirtual`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_temario`(
	out p_estado varchar(200),
    p_idTemas int,
    p_nombre_tema varchar(50)
)
BEGIN
	DECLARE EXIT handler for sqlexception,sqlwarning,not found
BEGIN
	rollback;
	set p_estado='error';
	END;
	start transaction;
	set p_estado=null;
	UPDATE temas
    set nombre_tema=p_nombre_tema
    where idTemas=p_idTemas;
    set p_estado='ok';
    commit;

END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
