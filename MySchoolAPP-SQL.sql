-- MySQL Script generated by MySQL Workbench
-- Thu Jan 11 00:53:40 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema myschooldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myschooldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myschooldb` DEFAULT CHARACTER SET utf8mb4 ;
USE `myschooldb` ;

-- -----------------------------------------------------
-- Table `myschooldb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`curso` (
  `id_curso` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`genero` (
  `id_genero` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_genero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`institucion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`institucion` (
  `id_institucion` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `web` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_institucion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`rol` (
  `id_rol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`tipo_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`tipo_documento` (
  `id_tipo_documento` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_tipo_documento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`persona` (
  `id_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `apellido` VARCHAR(80) NOT NULL,
  `numero_documento` INT(11) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `rol_id` INT(11) NOT NULL,
  `genero_id` INT(11) NOT NULL,
  `tipo_documento_id` INT(11) NOT NULL,
  `institucion_id` INT(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `fk_personas_genero`
    FOREIGN KEY (`genero_id`)
    REFERENCES `myschooldb`.`genero` (`id_genero`),
  CONSTRAINT `fk_personas_intitucion`
    FOREIGN KEY (`institucion_id`)
    REFERENCES `myschooldb`.`institucion` (`id_institucion`),
  CONSTRAINT `fk_personas_rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `myschooldb`.`rol` (`id_rol`),
  CONSTRAINT `fk_personas_tipo_documento`
    FOREIGN KEY (`tipo_documento_id`)
    REFERENCES `myschooldb`.`tipo_documento` (`id_tipo_documento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`notas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`notas` (
  `id_notas` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `puntaje` INT(11) NOT NULL,
  `curso_id` INT(11) NOT NULL,
  `persona_id` INT(11) NOT NULL,
  PRIMARY KEY (`id_notas`),
  CONSTRAINT `fknotas_curso`
    FOREIGN KEY (`curso_id`)
    REFERENCES `myschooldb`.`curso` (`id_curso`),
  CONSTRAINT `fk_notas_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `myschooldb`.`persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `myschooldb`.`personas_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myschooldb`.`personas_cursos` (
  `curso_id` INT(11) NOT NULL,
  `persona_id` INT(11) NOT NULL,
  PRIMARY KEY (`curso_id`, `persona_id`),
  CONSTRAINT `fkcurso_persona_curso`
    FOREIGN KEY (`curso_id`)
    REFERENCES `myschooldb`.`curso` (`id_curso`),
  CONSTRAINT `fkpersona_curso_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `myschooldb`.`persona` (`id_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
