-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 29-Out-2018 às 06:49
-- Versão do servidor: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sischoolbd`
--
CREATE DATABASE IF NOT EXISTS `sischoolbd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sischoolbd`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `COMPROVANTERESIDENCIA` varchar(255) DEFAULT NULL,
  `FOTO3X4` varchar(255) DEFAULT NULL,
  `MAERESPONSAVEL` tinyint(1) DEFAULT '0',
  `NECESESPEC` tinyint(1) DEFAULT '0',
  `NECESESPECACOMP` tinyint(1) DEFAULT '0',
  `NOMEMAE` varchar(255) DEFAULT NULL,
  `NOMEPAI` varchar(255) DEFAULT NULL,
  `NOMERESPONSAVEL` varchar(255) DEFAULT NULL,
  `OUTRORESPONSAVEL` tinyint(1) DEFAULT '0',
  `PAIRESPONSAVEL` tinyint(1) DEFAULT '0',
  `PARENTESCORESPONSAVEL` varchar(255) DEFAULT NULL,
  `RA` varchar(255) DEFAULT NULL,
  `TRANSPPUBLICOESCOLAR` tinyint(1) DEFAULT '0',
  `escola_id` int(11) DEFAULT NULL,
  `turma_id` int(11) DEFAULT NULL,
  `aprovado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`id`, `COMPROVANTERESIDENCIA`, `FOTO3X4`, `MAERESPONSAVEL`, `NECESESPEC`, `NECESESPECACOMP`, `NOMEMAE`, `NOMEPAI`, `NOMERESPONSAVEL`, `OUTRORESPONSAVEL`, `PAIRESPONSAVEL`, `PARENTESCORESPONSAVEL`, `RA`, `TRANSPPUBLICOESCOLAR`, `escola_id`, `turma_id`, `aprovado`) VALUES
(55, 'A VER MAIS TARDE', 'TEM QUE VER ESSA FITA AÍ', 1, 0, 0, 'das', 'das', '', 0, 0, '', '123', 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_notasfaltas`
--

DROP TABLE IF EXISTS `aluno_notasfaltas`;
CREATE TABLE `aluno_notasfaltas` (
  `Aluno_ID` int(11) NOT NULL,
  `notasFaltas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno_notasfaltas`
--

INSERT INTO `aluno_notasfaltas` (`Aluno_ID`, `notasFaltas_ID`) VALUES
(55, 43),
(55, 44),
(55, 45),
(55, 46),
(55, 47),
(55, 48),
(55, 49),
(55, 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `certificado`
--

DROP TABLE IF EXISTS `certificado`;
CREATE TABLE `certificado` (
  `ID` int(11) NOT NULL,
  `DATACURSO` date DEFAULT NULL,
  `INSTITUICAO` varchar(255) DEFAULT NULL,
  `NOMECURSO` varchar(255) DEFAULT NULL,
  `PONTOS` int(11) DEFAULT NULL,
  `PROFESSOR_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `certificado`
--

INSERT INTO `certificado` (`ID`, `DATACURSO`, `INSTITUICAO`, `NOMECURSO`, `PONTOS`, `PROFESSOR_ID`) VALUES
(5, '2011-11-11', 'Instituto Massachussets', 'Alquimia', 1, 12),
(6, '2011-11-11', 'Instituto Boi Na Brasa', 'Churrasqueiro', 10, 12),
(7, '2011-11-11', 'Beco', 'Utilização de Armas Brancas', 2, 12),
(8, '2011-11-11', 'Mister M', 'Truques Mágicos', 9, 12),
(9, '2011-11-11', 'Yu gi oh', 'Duelo de Cartas', 11, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `escola`
--

DROP TABLE IF EXISTS `escola`;
CREATE TABLE `escola` (
  `ID` int(11) NOT NULL,
  `BAIRRO` varchar(255) DEFAULT NULL,
  `CNPJ` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `escola`
--

INSERT INTO `escola` (`ID`, `BAIRRO`, `CNPJ`, `ENDERECO`, `NOME`) VALUES
(1, 'sda', 'sda', 'dsa', 'ESCOLA 1'),
(2, 'das', 'das', 'das', 'ESCOLA 2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `escola_telefone`
--

DROP TABLE IF EXISTS `escola_telefone`;
CREATE TABLE `escola_telefone` (
  `Escola_ID` int(11) NOT NULL,
  `telefones_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `escola_telefone`
--

INSERT INTO `escola_telefone` (`Escola_ID`, `telefones_ID`) VALUES
(1, 1),
(1, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `ID` int(11) NOT NULL,
  `ACESSO` int(11) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `CPF` varchar(255) DEFAULT NULL,
  `MATRICULA` varchar(255) DEFAULT NULL,
  `POSSUIDEFICIENCIA` tinyint(1) DEFAULT '0',
  `SENHA` varchar(255) DEFAULT NULL,
  `USRNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`ID`, `ACESSO`, `CARGO`, `CPF`, `MATRICULA`, `POSSUIDEFICIENCIA`, `SENHA`, `USRNAME`) VALUES
(1, 3, 'Dev', '418.000.698-71', '', 0, 'dev', 'dev'),
(12, 0, 'Professor PEB I', '218.362.340-31', '', 0, 'p2', 'p2'),
(56, 0, 'Professor PEB I', '192.393.350-72', '234324', 0, 'p1', 'p1'),
(57, 0, 'Professor PEB I', '812.547.380-70', 'ewr', 0, 'p3', 'p3'),
(58, 0, 'Professor PEB I', '929.707.120-16', '', 0, 'p4', 'p4'),
(59, 0, 'Professor PEB II', '429.605.100-89', '', 0, 'pa', 'pa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `notasfaltas`
--

DROP TABLE IF EXISTS `notasfaltas`;
CREATE TABLE `notasfaltas` (
  `ID` int(11) NOT NULL,
  `ANO` varchar(255) DEFAULT NULL,
  `FALTAS` varchar(255) DEFAULT NULL,
  `MATERIA` varchar(255) DEFAULT NULL,
  `NOTA1` varchar(255) DEFAULT NULL,
  `NOTA2` varchar(255) DEFAULT NULL,
  `NOTA3` varchar(255) DEFAULT NULL,
  `NOTA4` varchar(255) DEFAULT NULL,
  `ALUNO_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `notasfaltas`
--

INSERT INTO `notasfaltas` (`ID`, `ANO`, `FALTAS`, `MATERIA`, `NOTA1`, `NOTA2`, `NOTA3`, `NOTA4`, `ALUNO_ID`) VALUES
(43, '2018', 'h4', 'História', 'h1', 'h2', 'h2', 'h3', NULL),
(44, '2018', NULL, 'Geografia', 'g1', 'g1', 'g3', 'g4', NULL),
(45, '2018', 'pf', 'Português', 'p1', 'p2', 'p3', 'p4', NULL),
(46, '2018', 'if', 'Inglês', 'i1', 'i2', 'i3', 'i4', NULL),
(47, '2018', 'ffffff', 'Educação Física', 'ff', 'fff', 'fffff', 'fffffff', NULL),
(48, '2018', NULL, 'Artes', 'a1', 'a2', 'a3', NULL, NULL),
(49, '2018', 'mf', 'Matemática', 'I', 'm2', 'm3', 'm4', NULL),
(50, '2018', 'c5', 'Ciências', 'c1', 'c2', 'c3', 'c4', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `outrocargo`
--

DROP TABLE IF EXISTS `outrocargo`;
CREATE TABLE `outrocargo` (
  `ID` int(11) NOT NULL,
  `escola_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `outrocargo`
--

INSERT INTO `outrocargo` (`ID`, `escola_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `ID` int(11) NOT NULL,
  `tipo` varchar(31) DEFAULT NULL,
  `BAIRRO` varchar(255) DEFAULT NULL,
  `CEP` varchar(255) DEFAULT NULL,
  `CIDADE` varchar(255) DEFAULT NULL,
  `DATANASC` date DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `GENERO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `OBSERVACOES` varchar(255) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`ID`, `tipo`, `BAIRRO`, `CEP`, `CIDADE`, `DATANASC`, `ENDERECO`, `GENERO`, `NOME`, `OBSERVACOES`, `ativo`) VALUES
(1, 'OutroCargo', '', '', '', '1993-08-30', '', 'Masculino', 'Davi', '', 0),
(12, 'ProfessorPebI', 'bairro tal', '', '', NULL, 'Rua tal', 'Feminino', 'Professor PEB I 2', '', 0),
(55, 'Aluno', 'Bairro das vitórias', '17', 'Avaré', '2011-11-11', 'Rua das eleições', 'Masculino', 'Jairzinho', '', 0),
(56, 'ProfessorPebI', '', '', '', NULL, 'Rua tal', 'Feminino', 'Professor PEB I 1', '', 0),
(57, 'ProfessorPebI', 'Bairro tal', '', '', NULL, 'Rua tal', 'Feminino', 'Professor PEB I 3', '', 0),
(58, 'ProfessorPebI', '', '', '', NULL, 'dasads', 'Feminino', 'Professor PEB I 4', '', 0),
(59, 'ProfessorPebII', '', '', '', NULL, '', 'Masculino', 'Prof Artes 1', '', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `ID` int(11) NOT NULL,
  `PONTOS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`ID`, `PONTOS`) VALUES
(12, 33),
(56, 0),
(57, 0),
(58, 0),
(59, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professorpebi`
--

DROP TABLE IF EXISTS `professorpebi`;
CREATE TABLE `professorpebi` (
  `ID` int(11) NOT NULL,
  `PERIODO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professorpebi`
--

INSERT INTO `professorpebi` (`ID`, `PERIODO`) VALUES
(12, 'Tarde'),
(56, 'Duplo'),
(57, 'Duplo'),
(58, 'Duplo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professorpebii`
--

DROP TABLE IF EXISTS `professorpebii`;
CREATE TABLE `professorpebii` (
  `ID` int(11) NOT NULL,
  `AULASATRIBUIDAS` int(11) DEFAULT NULL,
  `ESPECIALIDADE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professorpebii`
--

INSERT INTO `professorpebii` (`ID`, `AULASATRIBUIDAS`, `ESPECIALIDADE`) VALUES
(59, 1, 'Artes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professorpebii_turma`
--

DROP TABLE IF EXISTS `professorpebii_turma`;
CREATE TABLE `professorpebii_turma` (
  `turmas_ID` int(11) NOT NULL,
  `profPebII_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professorpebii_turma`
--

INSERT INTO `professorpebii_turma` (`turmas_ID`, `profPebII_ID`) VALUES
(1, 59);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_escola`
--

DROP TABLE IF EXISTS `professor_escola`;
CREATE TABLE `professor_escola` (
  `escola_ID` int(11) NOT NULL,
  `professor_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor_escola`
--

INSERT INTO `professor_escola` (`escola_ID`, `professor_ID`) VALUES
(1, 12),
(1, 57),
(1, 59);

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE `telefone` (
  `ID` int(11) NOT NULL,
  `NUMERO` varchar(255) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `telefone`
--

INSERT INTO `telefone` (`ID`, `NUMERO`, `pessoa_id`) VALUES
(1, '432', NULL),
(2, '312', NULL),
(3, '12', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
CREATE TABLE `transferencia` (
  `ID` int(11) NOT NULL,
  `ALUNO_ID` int(11) DEFAULT NULL,
  `ESCOLA_ID` int(11) DEFAULT NULL,
  `FUNCIONARIO_ID` int(11) DEFAULT NULL,
  `TURMA_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `transferencia`
--

INSERT INTO `transferencia` (`ID`, `ALUNO_ID`, `ESCOLA_ID`, `FUNCIONARIO_ID`, `TURMA_ID`) VALUES
(1, 55, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE `turma` (
  `ID` int(11) NOT NULL,
  `CRONOGRAMA` longblob,
  `LETRA` varchar(255) DEFAULT NULL,
  `PERIODO` varchar(255) DEFAULT NULL,
  `TURMA` varchar(255) DEFAULT NULL,
  `VAGAS` int(11) DEFAULT NULL,
  `escola_id` int(11) DEFAULT NULL,
  `PROFPEBI_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`ID`, `CRONOGRAMA`, `LETRA`, `PERIODO`, `TURMA`, `VAGAS`, `escola_id`, `PROFPEBI_ID`) VALUES
(1, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a50200007870000000050000003b0000003b0000003a0000003a0000003a7571007e0002000000050000000d0000003a0000003a0000000d0000003a7571007e0002000000050000003b0000003a0000003b0000003b0000003a7571007e0002000000050000003a0000003a0000003a0000003a0000003a7571007e0002000000050000003a0000003b0000003b0000003a0000003a, 'A', 'Manhã', 'Berçário I', 25, 1, 12),
(2, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'A', 'Manhã', '1º Ano', 22, 2, 12),
(3, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000038000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000d00000000000000000000000000000000, 'B', 'Manhã', 'Berçário I', 22, 1, 57),
(4, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'Z', 'Tarde', '2º Ano', 22, 1, NULL),
(5, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'C', 'Tarde', '5º Ano', 22, 2, NULL),
(7, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'D', 'Manhã', '4º Ano', 22, 2, NULL),
(8, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'D', 'Tarde', '2º Ano', 22, 1, NULL),
(9, 0xaced0005757200035b5b4917f7e44f198f893c020000787000000005757200025b494dba602676eab2a502000078700000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e00020000000500000000000000000000000000000000000000007571007e0002000000050000000000000000000000000000000000000000, 'X', 'Manhã', '2º Ano', 22, 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ALUNO_turma_id` (`turma_id`),
  ADD KEY `FK_ALUNO_escola_id` (`escola_id`);

--
-- Indexes for table `aluno_notasfaltas`
--
ALTER TABLE `aluno_notasfaltas`
  ADD PRIMARY KEY (`Aluno_ID`,`notasFaltas_ID`),
  ADD KEY `FK_ALUNO_NOTASFALTAS_notasFaltas_ID` (`notasFaltas_ID`);

--
-- Indexes for table `certificado`
--
ALTER TABLE `certificado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_CERTIFICADO_PROFESSOR_ID` (`PROFESSOR_ID`);

--
-- Indexes for table `escola`
--
ALTER TABLE `escola`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `escola_telefone`
--
ALTER TABLE `escola_telefone`
  ADD PRIMARY KEY (`Escola_ID`,`telefones_ID`),
  ADD KEY `FK_ESCOLA_TELEFONE_telefones_ID` (`telefones_ID`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `notasfaltas`
--
ALTER TABLE `notasfaltas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_NOTASFALTAS_ALUNO_ID` (`ALUNO_ID`);

--
-- Indexes for table `outrocargo`
--
ALTER TABLE `outrocargo`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_OUTROCARGO_escola_id` (`escola_id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `professorpebi`
--
ALTER TABLE `professorpebi`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `professorpebii`
--
ALTER TABLE `professorpebii`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `professorpebii_turma`
--
ALTER TABLE `professorpebii_turma`
  ADD PRIMARY KEY (`turmas_ID`,`profPebII_ID`),
  ADD KEY `FK_PROFESSORPEBII_TURMA_profPebII_ID` (`profPebII_ID`);

--
-- Indexes for table `professor_escola`
--
ALTER TABLE `professor_escola`
  ADD PRIMARY KEY (`escola_ID`,`professor_ID`),
  ADD KEY `FK_PROFESSOR_ESCOLA_professor_ID` (`professor_ID`);

--
-- Indexes for table `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TELEFONE_pessoa_id` (`pessoa_id`);

--
-- Indexes for table `transferencia`
--
ALTER TABLE `transferencia`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TRANSFERENCIA_ALUNO_ID` (`ALUNO_ID`),
  ADD KEY `FK_TRANSFERENCIA_ESCOLA_ID` (`ESCOLA_ID`),
  ADD KEY `FK_TRANSFERENCIA_FUNCIONARIO_ID` (`FUNCIONARIO_ID`),
  ADD KEY `FK_TRANSFERENCIA_TURMA_ID` (`TURMA_ID`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURMA_escola_id` (`escola_id`),
  ADD KEY `FK_TURMA_PROFPEBI_ID` (`PROFPEBI_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `certificado`
--
ALTER TABLE `certificado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `escola`
--
ALTER TABLE `escola`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `notasfaltas`
--
ALTER TABLE `notasfaltas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- AUTO_INCREMENT for table `telefone`
--
ALTER TABLE `telefone`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `transferencia`
--
ALTER TABLE `transferencia`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `turma`
--
ALTER TABLE `turma`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `FK_ALUNO_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`),
  ADD CONSTRAINT `FK_ALUNO_id` FOREIGN KEY (`id`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_ALUNO_turma_id` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`ID`);

--
-- Limitadores para a tabela `aluno_notasfaltas`
--
ALTER TABLE `aluno_notasfaltas`
  ADD CONSTRAINT `FK_ALUNO_NOTASFALTAS_Aluno_ID` FOREIGN KEY (`Aluno_ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_ALUNO_NOTASFALTAS_notasFaltas_ID` FOREIGN KEY (`notasFaltas_ID`) REFERENCES `notasfaltas` (`ID`);

--
-- Limitadores para a tabela `certificado`
--
ALTER TABLE `certificado`
  ADD CONSTRAINT `FK_CERTIFICADO_PROFESSOR_ID` FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `escola_telefone`
--
ALTER TABLE `escola_telefone`
  ADD CONSTRAINT `FK_ESCOLA_TELEFONE_Escola_ID` FOREIGN KEY (`Escola_ID`) REFERENCES `escola` (`ID`),
  ADD CONSTRAINT `FK_ESCOLA_TELEFONE_telefones_ID` FOREIGN KEY (`telefones_ID`) REFERENCES `telefone` (`ID`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `FK_FUNCIONARIO_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `notasfaltas`
--
ALTER TABLE `notasfaltas`
  ADD CONSTRAINT `FK_NOTASFALTAS_ALUNO_ID` FOREIGN KEY (`ALUNO_ID`) REFERENCES `notasfaltas` (`ID`);

--
-- Limitadores para a tabela `outrocargo`
--
ALTER TABLE `outrocargo`
  ADD CONSTRAINT `FK_OUTROCARGO_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_OUTROCARGO_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`);

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `FK_PROFESSOR_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `professorpebi`
--
ALTER TABLE `professorpebi`
  ADD CONSTRAINT `FK_PROFESSORPEBI_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `professorpebii`
--
ALTER TABLE `professorpebii`
  ADD CONSTRAINT `FK_PROFESSORPEBII_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `professorpebii_turma`
--
ALTER TABLE `professorpebii_turma`
  ADD CONSTRAINT `FK_PROFESSORPEBII_TURMA_profPebII_ID` FOREIGN KEY (`profPebII_ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_PROFESSORPEBII_TURMA_turmas_ID` FOREIGN KEY (`turmas_ID`) REFERENCES `turma` (`ID`);

--
-- Limitadores para a tabela `professor_escola`
--
ALTER TABLE `professor_escola`
  ADD CONSTRAINT `FK_PROFESSOR_ESCOLA_escola_ID` FOREIGN KEY (`escola_ID`) REFERENCES `escola` (`ID`),
  ADD CONSTRAINT `FK_PROFESSOR_ESCOLA_professor_ID` FOREIGN KEY (`professor_ID`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `FK_TELEFONE_pessoa_id` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`ID`);

--
-- Limitadores para a tabela `transferencia`
--
ALTER TABLE `transferencia`
  ADD CONSTRAINT `FK_TRANSFERENCIA_ALUNO_ID` FOREIGN KEY (`ALUNO_ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_TRANSFERENCIA_ESCOLA_ID` FOREIGN KEY (`ESCOLA_ID`) REFERENCES `escola` (`ID`),
  ADD CONSTRAINT `FK_TRANSFERENCIA_FUNCIONARIO_ID` FOREIGN KEY (`FUNCIONARIO_ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_TRANSFERENCIA_TURMA_ID` FOREIGN KEY (`TURMA_ID`) REFERENCES `turma` (`ID`);

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `FK_TURMA_PROFPEBI_ID` FOREIGN KEY (`PROFPEBI_ID`) REFERENCES `pessoa` (`ID`),
  ADD CONSTRAINT `FK_TURMA_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
