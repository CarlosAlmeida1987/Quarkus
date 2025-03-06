-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 03-Mar-2025 às 19:44
-- Versão do servidor: 9.1.0
-- versão do PHP: 8.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `faculdade`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_curso`
--

DROP TABLE IF EXISTS `tb_curso`;
CREATE TABLE `tb_curso` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nome_curso` VARCHAR(250) NOT NULL,
  `duracao` INT NOT NULL,
  `dia` VARCHAR(10) DEFAULT NULL,
  `hora` VARCHAR(10) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluno`
--

DROP TABLE IF EXISTS `tb_aluno`;
CREATE TABLE `tb_aluno` (
  `id_aluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NOT NULL,
  `matricula` VARCHAR(20) NOT NULL UNIQUE,
  `id_curso` INT DEFAULT NULL,
  `email` VARCHAR(155) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  CONSTRAINT `fk_aluno_curso` FOREIGN KEY (`id_curso`) REFERENCES `tb_curso` (`id_curso`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professor`
--

DROP TABLE IF EXISTS `tb_professor`;
CREATE TABLE `tb_professor` (
  `id_professor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL UNIQUE,
  `especialidade` VARCHAR(250) DEFAULT NULL,
  `telefone` VARCHAR(14) DEFAULT NULL,
  PRIMARY KEY (`id_professor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_disciplina`
--

DROP TABLE IF EXISTS `tb_disciplina`;
CREATE TABLE `tb_disciplina` (
  `id_disciplina` INT NOT NULL AUTO_INCREMENT,
  `nome_disciplina` VARCHAR(250) NOT NULL,
  `carga_horaria` INT NOT NULL,
  `id_curso` INT DEFAULT NULL,
  `tipo` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id_disciplina`),
  CONSTRAINT `fk_disciplina_curso` FOREIGN KEY (`id_curso`) REFERENCES `tb_curso` (`id_curso`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_docencia`
--

DROP TABLE IF EXISTS `tb_docencia`;
CREATE TABLE `tb_docencia` (
  `id_docencia` INT NOT NULL AUTO_INCREMENT,
  `id_professor` INT NOT NULL,
  `id_disciplina` INT NOT NULL,
  PRIMARY KEY (`id_docencia`),
  CONSTRAINT `fk_docencia_professor` FOREIGN KEY (`id_professor`) REFERENCES `tb_professor` (`id_professor`) ON DELETE CASCADE,
  CONSTRAINT `fk_docencia_disciplina` FOREIGN KEY (`id_disciplina`) REFERENCES `tb_disciplina` (`id_disciplina`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
CREATE TABLE `tb_usuarios` (
  `id_login` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT DEFAULT NULL,
  `tipo_usuario` ENUM('aluno','professor','administrador','coordenador') NOT NULL,
  `login` VARCHAR(100) NOT NULL UNIQUE,
  `senha` VARCHAR(100) NOT NULL,
  `data_criacao` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `ultimo_acesso` DATETIME DEFAULT NULL,
  `status` ENUM('ativo','inativo') DEFAULT 'ativo',
  PRIMARY KEY (`id_login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_matricula`
--

DROP TABLE IF EXISTS `tb_matricula`;
CREATE TABLE `tb_matricula` (
  `id_matricula` INT NOT NULL AUTO_INCREMENT,
  `id_aluno` INT NOT NULL,
  `id_disciplina` INT NOT NULL,
  PRIMARY KEY (`id_matricula`),
  CONSTRAINT `fk_matricula_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `tb_aluno` (`id_aluno`) ON DELETE CASCADE,
  CONSTRAINT `fk_matricula_disciplina` FOREIGN KEY (`id_disciplina`) REFERENCES `tb_disciplina` (`id_disciplina`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_semestre`
--

DROP TABLE IF EXISTS `tb_semestre`;
CREATE TABLE `tb_semestre` (
  `id_semestre` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `ano` INT NOT NULL,
  `id_curso` INT DEFAULT NULL,
  `periodo` VARCHAR(10) DEFAULT NULL,
  PRIMARY KEY (`id_semestre`),
  CONSTRAINT `fk_semestre_curso` FOREIGN KEY (`id_curso`) REFERENCES `tb_curso` (`id_curso`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
