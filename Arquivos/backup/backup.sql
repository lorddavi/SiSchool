-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: sischoolbd
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `sischoolbd`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sischoolbd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sischoolbd`;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `APROVADO` tinyint(1) DEFAULT '0',
  `COMPROVANTERESIDENCIA` longblob,
  `FOTO3X4` longblob,
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
  PRIMARY KEY (`id`),
  KEY `FK_ALUNO_turma_id` (`turma_id`),
  KEY `FK_ALUNO_escola_id` (`escola_id`),
  CONSTRAINT `FK_ALUNO_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`),
  CONSTRAINT `FK_ALUNO_id` FOREIGN KEY (`id`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_ALUNO_turma_id` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (122,0,'¬\í\0p','¬\í\0p',1,0,0,'dsa','dsadsa','',0,0,'','321432',0,1,1),(123,0,'¬\í\0p','¬\í\0sr\0javax.swing.ImageIconò¦5n\Þ2\0I\0heightI\0widthL\0accessibleContextt\0+Ljavax/swing/ImageIcon$AccessibleImageIcon;L\0descriptiont\0Ljava/lang/String;L\0\rimageObservert\0Ljava/awt/image/ImageObserver;xp\0\0\0u\0\0\0upppw\0\0\0u\0\0\0uur\0[IMº`&vê²¥\0\0xp\0\05yÿ¶Âžÿ´Áÿ°½™ÿ®»–ÿ­º•ÿª¶ÿª·ÿ«¹ÿ¬ºÿª¸ÿ©·ÿ©·ÿª¸ÿ©·ÿª¸ÿ©·ÿ©·ÿ¨¶ÿ¨¶Œÿ§µ‹ÿ¥³Šÿ¤²‰ÿ£°…ÿ‚‡\\ÿ}QÿTÿqrZÿ—žÿ¥°†ÿ¡®ƒÿ£±†ÿ¢²…ÿ£±‡ÿ¤²Šÿ¡³‡ÿŸ±†ÿ¡°…ÿ¡°…ÿ›¦sÿ½¿4ÿ\à\à ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\áÿ\å\ß%ÿÒ®#ÿÑ–-ÿ´Š,ÿ•—`ÿ—¤yÿ¡tÿ’ŸzÿžtÿžsÿsÿŸuÿŽžtÿ‰˜sÿŠšuÿ’¡wÿ”¢yÿ€ˆ_ÿ{|RÿwwOÿvwMÿrsOÿTT?ÿykÿ‰—sÿ‡˜sÿŒwÿžwÿx[ÿsrRÿ“‘rÿ‚~jÿl{ÿf„‘ÿ…¡¤ÿ\Ñ\í\èÿ\Ý÷ñÿ\Ûøóÿ\Ù÷óÿ\Ø÷óÿ·ÃŸÿ´Àšÿ°½—ÿ­º“ÿ«¸‘ÿ¨µÿ©·Žÿ¬ºÿ«¹Žÿ©·Œÿ¨¶Œÿ©·ÿ¨¶‹ÿ©·‹ÿª¸Œÿ©·Œÿ«¹ÿª¸Žÿ¨¶‹ÿ§µŠÿ¦´Šÿ¤²ˆÿ£°„ÿ‚‡\\ÿ}~QÿTÿqrZÿ˜ ƒÿ£²‡ÿ£°ƒÿ ­ƒÿ©}ÿ™¦{ÿ›¥{ÿ˜¦xÿ•¢uÿ”Ÿqÿ›nÿ”]ÿµ·%ÿ\à\à ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á\"ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á\"ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\áÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\á ÿ\à\áÿ\Ý\Ó ÿÌªÿÕ¬*ÿ¿ª ÿ¢¦\"ÿ©®-ÿ´¸8ÿ½\Â=ÿ\Å\Ê=ÿ\Ê\Í:ÿ\Ì\Ñ0ÿ\È\Í3ÿ\Ã\Ç8ÿ½¾>ÿ’š>ÿŸmÿ•£zÿ‰_ÿ|~RÿxyNÿwwMÿstOÿST?ÿyjÿ‹™uÿŠštÿŒžtÿžvÿx[ÿsrRÿ“‘qÿ‚}jÿk{€ÿg…’ÿ…¢¦ÿ\Ó\î\ëÿ\Ý÷óÿ\Ý÷óÿ\Ýøôÿ\Û÷ôÿ¶Âžÿ³¿™ÿ°½—ÿ­¹“ÿª·‘ÿ©¶ÿ¨¶ÿ¬ºÿ«¹Žÿª¸ÿ§µ‹ÿ§µŒÿ¨¶ÿ©·Œÿ©·ÿ«¹ÿ¬ºÿ¬ºŽÿª¸Œÿ©·Œÿ¨µŠÿ§´‰ÿ¥°„ÿ‚‡[ÿ}~Qÿ€UÿpqYÿš¢…ÿ¦´ŠÿŒ“Yÿ²´Bÿ¹¿1ÿ¼\Ã4ÿ\Ä\Å7ÿ\É\Í1ÿ\Ï\Ô&ÿ\Ò\×$ÿ\Î\Õ ÿ\Ì\Ï!ÿ\Ú\Ü!ÿ\à\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á\"ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\á ÿ\à\á ÿ\Þ\Þ ÿ\â\Ý\"ÿ\â\Þ#ÿ\à\à ÿ\à\áÿ\á\àÿ\á\àÿ\â\áÿ\â\áÿ\à\áÿ\à\áÿ\â\àÿ\ß\Õ ÿË¿#ÿ†/ÿ¡pÿ“¢yÿ‰_ÿ|~QÿyzNÿxyMÿtuNÿST?ÿz€jÿ‹™uÿ‹›sÿŽŸvÿŸvÿx€\\ÿsrSÿ“’rÿ‚}kÿjzÿg…’ÿ†¢¨ÿ\Ò\í\ìÿ\Þ÷ôÿ\ßöõÿ\Þ÷õÿ\Ýöôÿ·Âÿ²¿˜ÿ±½—ÿ­º“ÿ«¹ÿ©·ÿª¸Žÿ¬ºÿ«¹Žÿª¸Œÿ§µŠÿ¦´Œÿ©¶Œÿ«¹ÿ¬ºÿ¬ºÿ­»ÿ­»ÿª¸ÿ©·Œÿ©·Œÿ¨µŠÿ¦±…ÿ‚ˆ[ÿ}Pÿ€UÿrqZÿž£‡ÿ¨µ‹ÿ’–aÿÁ°3ÿ\ã\Ý$ÿ\à\áÿ\à\áÿ\â\áÿ\â\á ÿ\á\áÿ\á\áÿ\à\à!ÿ\à\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\áÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\á\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\à ÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\áÿ\à\áÿ\à\á!ÿ\à\àÿ\á\áÿ\â\à!ÿ\â\à!ÿ\á\áÿ\â\ß ÿ\á\Ü\"ÿ\Û\Ë%ÿÔ®\"ÿË(ÿ”0ÿ•Ÿnÿ‘¢zÿ“¤{ÿ‰_ÿ|~QÿyyOÿyxMÿtuNÿTT>ÿ{iÿ‹™tÿuÿ wÿ‘ wÿx€]ÿsrRÿ”“tÿ~mÿiy}ÿg…’ÿˆ¤¨ÿ\Ô\î\êÿ\ß÷ôÿ\ßöõÿ\ß÷õÿ\Ý÷óÿºÃÿ³À™ÿ±¾—ÿ­»“ÿ¬º‘ÿ«¹Žÿ«¹ÿ­»ÿ¬ºÿª¸Œÿ¨µŠÿ§µ‹ÿ©¶‹ÿ«¹ÿ­»ÿ­»ÿ¯¼‘ÿ°¼‘ÿ­ºÿ«¹ÿª¸Œÿ§µŠÿ¥³†ÿ‚‰[ÿ~€Oÿ€Uÿrq[ÿ¢†ÿ¨µŠÿ¦²…ÿœ…8ÿÖ¾)ÿ\ä\ß$ÿ\à\áÿ\á\á ÿ\á\á ÿ\á\áÿ\á\á ÿ\à\àÿ\á\á ÿ\á\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\áÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\á\àÿ\à\àÿ\à\à ÿ\à\à ÿ\à\à ÿ\à\àÿ\à\à!ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\á\á ÿ\à\à ÿ\à\àÿ\á\áÿ\á\á ÿ\å\ß%ÿ\â\Ñ%ÿØ¹#ÿÑ¢&ÿÐ˜)ÿÑ•.ÿ¶†/ÿ”‘[ÿ“¢yÿ‘¡zÿ“£{ÿˆ`ÿ{}QÿyyOÿzyNÿuvNÿTU=ÿ|ƒiÿŽwÿ xÿ wÿ“ wÿy€]ÿsrRÿ””uÿ€}lÿhx|ÿg…’ÿ‰¤¨ÿ\×\ï\êÿ\áöôÿ\ßöôÿ\ß÷õÿ\Ý÷ôÿ¼ÆŸÿ·Ã›ÿ´À˜ÿ±¾–ÿ¯½”ÿ®»’ÿ­»ÿ®¼‘ÿ¯¼ÿ¬ºŽÿ§µŠÿ¦´‰ÿ¨¶Šÿ­ºŽÿ®»ÿ¯¼‘ÿ¯¼‘ÿ²»‘ÿ°»‘ÿ¬¹Žÿ­ºÿ©·‹ÿ¦´ˆÿƒŠ\\ÿ~€Pÿ€€Tÿrq[ÿž£‡ÿ©µŠÿ¦µŠÿ–^ÿÀ˜7ÿ\ß\Â)ÿ\ä\ß\"ÿ\à\à ÿ\á\á ÿ\à\àÿ\á\áÿ\à\àÿ\à\àÿ\á\áÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\áÿ\à\à ÿ\à\à ÿ\à\àÿ\à\à!ÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\á\á!ÿ\à\àÿ\à\à ÿ\à\áÿ\â\ß!ÿ\ã\Ú$ÿ\Ü\Ç\"ÿÔ¬&ÿÓ™*ÿÓ•-ÿÓ•/ÿÓ•.ÿÉ’1ÿ‘>ÿ—£vÿ’£{ÿ‘¡zÿ’ yÿ†`ÿ}~Rÿz{Nÿ{zOÿuwMÿSV<ÿ†kÿ‘Ÿyÿ‘¢xÿ‘¡wÿ•¡wÿz^ÿssSÿ””uÿ~lÿhx|ÿh…’ÿ‰¤¥ÿ\Øð\êÿ\ãöóÿ\à÷ôÿ\à÷ôÿ\ßöôÿ¾Ç ÿºÅœÿ·Â˜ÿµÁ•ÿ²¿“ÿ°½’ÿ­»ÿ¯½’ÿ¯¼ÿ®»Žÿª¸Œÿ§µŠÿ¨¶‰ÿ­ºŽÿ°½‘ÿ²¾“ÿ°¼‘ÿ³¼’ÿ±¼ÿ­»ÿ¬¹ÿ«¹ÿ¨µ‰ÿ…Œ]ÿ~€Pÿ€€UÿrpZÿž¥ˆÿ§´Šÿ¦µ‰ÿ¦¯€ÿ§‡?ÿÎ›(ÿ\á\Î)ÿ\á\à ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á\"ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\â\ß!ÿ\Þ\Ñ!ÿ×·\"ÿÒ \'ÿÐ˜*ÿÓ•/ÿÓ•/ÿÓ•/ÿÓ•/ÿÒ•0ÿž{-ÿ‘˜lÿ‘ yÿ‘¡zÿ›tÿ’Ÿyÿ†`ÿ|~RÿzzNÿ{zNÿvwNÿTU=ÿ~†kÿ’Ÿyÿ’¡xÿ“¡xÿ” xÿz€]ÿtrSÿ•’uÿ}kÿgy}ÿg…’ÿ‰¥¥ÿ\Ùð\êÿ\äõòÿ\ãöôÿ\ãöóÿ\â÷òÿÁÉ ÿ¾ÇžÿºÃ™ÿ¶Á”ÿ¶À”ÿ²½‘ÿ®¼ÿ°½‘ÿ°¼ÿ¬ºŒÿ©·‹ÿ§µŠÿ¨¶‹ÿ«¹Žÿ°½‘ÿ³¿’ÿ³¾’ÿ´½‘ÿ°»ÿ®¼ÿ­»ÿ¬¹Œÿ«µŠÿ‡Š\\ÿ~~Oÿ€Vÿsq[ÿž¤‡ÿ¦´Šÿ¨¶ŠÿªµŠÿ’ŠUÿÉ”6ÿÓ¥&ÿ\ä\Ö(ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á\"ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\á ÿ\à\àÿ\×\ÑÿÈ¥ÿÑ–*ÿÓ•/ÿÓ•.ÿÓ•/ÿÓ–/ÿÓ•/ÿÓ–0ÿ¶‡-ÿ‘Xÿ‘žxÿ›wÿuÿžwÿ“ zÿ†`ÿ{}Qÿ{|MÿzzLÿxxPÿUT>ÿ…lÿ’¡yÿ‘¢xÿ“ zÿ“Ÿxÿ{€^ÿusSÿ•’tÿ~kÿgx|ÿh…’ÿ¨«ÿ\Ûð\ìÿ\æöóÿ\äöóÿ\ä÷óÿ\ã÷óÿ\ÃÊ¡ÿ¿Èÿ»Ä™ÿ¶Á”ÿ´¿“ÿ³¾“ÿ¯½ÿ²¾‘ÿ°½ÿ¬ºŒÿ¨¶Šÿ§µŠÿ©·‹ÿ­»ÿ°½‘ÿ²¾‘ÿ³½‘ÿµ¾’ÿ³¼‘ÿ°¼‘ÿ®¼Žÿ¬¹Œÿ«¶Šÿ†Š]ÿ}~NÿVÿsqZÿž¤‡ÿ§µ‰ÿ¨¶‰ÿ©¶Šÿ¢¨~ÿ­…;ÿÑ•.ÿ×±\'ÿ\æ\Ý&ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\â\à\"ÿ\á\Ò&ÿÕ®&ÿÏ˜*ÿÓ”0ÿÓ•/ÿÓ•.ÿÓ•.ÿÇ’0ÿ”?ÿš§{ÿœvÿ•¢|ÿŽžvÿ“¡zÿ”¡{ÿ~…_ÿ{|Pÿz{Lÿ{zNÿwwPÿVU>ÿ…mÿ“£zÿ’¢yÿ“ yÿ” yÿ}‚_ÿvsTÿ•’tÿ~kÿiv|ÿg„’ÿ¨«ÿ\Þð\ìÿ\çöôÿ\åöóÿ\å÷óÿ\ä÷óÿ\ÄË¢ÿ¾Çœÿ»Ä˜ÿ·Â”ÿ°¿’ÿ²À“ÿ²¿‘ÿ²¾‘ÿ²¾‘ÿ­»ÿ©·‹ÿ¨¶‹ÿ¨¶‹ÿ®»Žÿ³¾‘ÿ´¿’ÿ³À’ÿµÀ“ÿ³¾’ÿ²¾“ÿ®¼ÿ°»ÿªµ‰ÿ†‹\\ÿ}Oÿ‚Wÿsq[ÿŸ¤ˆÿ§µ‰ÿ§µˆÿ¦´ˆÿ¤´‰ÿ”‚MÿÎ•:ÿÍ˜)ÿ\Ý\Æ*ÿ\â\à\"ÿ\à\à ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á!ÿ\á\á\"ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à!ÿ\à\à!ÿ\ä\Ý$ÿ\Þ\Ç\'ÿÒ¤(ÿÐ–-ÿÒ”.ÿÐ•0ÿš{-ÿš qÿ•£{ÿ’Ÿyÿ’Ÿxÿ“ zÿ•¢|ÿ•£|ÿ†`ÿ{}PÿyzLÿ|{OÿwwOÿUU<ÿ…mÿ’¡zÿ’¢zÿwÿ•¡{ÿ~ƒ_ÿvsTÿ•’tÿ‚lÿjv|ÿg…’ÿ©«ÿ\áñ\íÿ\éöòÿ\çöóÿ\åöóÿ\ãöòÿ\ÄË¢ÿ¿Èžÿ»Ä˜ÿ¹Â–ÿ³À’ÿ³À’ÿµÀ”ÿ´¿“ÿ±½ÿ®¼Žÿ¨¶Šÿ§µŠÿ©·‹ÿ®¼Žÿ²¾‘ÿ³¿’ÿ³À’ÿµÀ“ÿ³¾’ÿ³½“ÿ®½ÿ­¼ÿª¶‰ÿ‡‹_ÿ€‚Vÿ„ƒ[ÿsq[ÿ¡¦Šÿ©¶Œÿ¦´Šÿ£±‡ÿ ¯‡ÿ’”`ÿ™}#ÿ®‡ÿ³£ÿ\ß\ß\"ÿ\à\à ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\á ÿ\à\àÿ\à\àÿ\ß\áÿ\à\àÿ\á\ß\"ÿ\ã\Ú%ÿ\ÙÀ%ÿÉœ#ÿ¨\"ÿ™—^ÿ–§|ÿ’¤zÿ“£}ÿŸxÿ“¢{ÿ–¦}ÿ–¥{ÿˆ_ÿ{~PÿyzMÿ|{OÿxxQÿVU?ÿ…nÿ’¡{ÿ‘¡zÿštÿ–¢|ÿ}‚]ÿvrSÿ”‘rÿƒ€lÿhw{ÿg…ÿŽ¨ªÿ\ãñ\íÿ\ìöóÿ\éöôÿ\çöôÿ\ãöóÿ\ÃÊ¡ÿÁÉ ÿ¼Æ™ÿºÃ–ÿ·Â’ÿ´¿”ÿ´À•ÿµÁ•ÿ±½ÿ®¼ÿ«¹Œÿ¨¶‹ÿ©·‹ÿ­»Žÿ°¾‘ÿ³¿’ÿµÁ“ÿµÀ“ÿµ¾’ÿ´½“ÿ®ºÿ©¹Žÿ©µŠÿ‰Žbÿƒ…[ÿ„…^ÿqrXÿ£…ÿ¢®‚ÿ‘dÿŽ•Qÿš >ÿ±¶,ÿ\Í\Í&ÿ\ß\Û&ÿ\à\ß\"ÿ\à\à ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á\"ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\à ÿ\à\àÿ\à\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\á\á ÿ\á\á ÿ\Þ\Üÿ\à\Ý!ÿ\â\ß ÿ\á\à!ÿ\á\à ÿ\à\áÿ\Û\Ô\"ÿ¢™ÿŽ“Jÿ—¤wÿ—¦|ÿ zÿ“£|ÿ’£zÿ”¥{ÿ“¤|ÿ}†^ÿ{~OÿyzLÿ{zNÿwxPÿUV>ÿ~†nÿ“¢|ÿŒuÿvÿ˜¥}ÿ}‚]ÿwsTÿ•’tÿ†ƒmÿhx|ÿg…’ÿŽ§¨ÿ\ãñ\íÿ\ìöóÿ\êöôÿ\æöóÿ\åöóÿ\ÄË¢ÿÁÊ ÿ½ÆšÿºÃ˜ÿ¸Â•ÿ¸Á—ÿ¶¿•ÿ·Á”ÿ¶À“ÿ²¾‘ÿ®»Žÿ«¹Žÿª¸ÿ¯¼ÿ³¿’ÿµ¿’ÿµ¿’ÿ¶À“ÿ¶¿“ÿ³½’ÿ¯»ÿ©¸Žÿ«·ÿˆŒ`ÿ„†Xÿ|zMÿql>ÿš9ÿ±µ*ÿ\Ì\Ð0ÿ\Þ\ß.ÿ\à\â!ÿ\à\âÿ\à\âÿ\à\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\áÿ\á\áÿ\á\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\àÿ\á\á ÿ\á\á!ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\à!ÿ\Ô\ÂÿÍ¤!ÿÓª%ÿÙ¸\'ÿ\ß\Ê%ÿ\â\Ù ÿ\â\ß!ÿ\ß\ß!ÿ\Ë\Ð\'ÿ™¤0ÿ‰“Xÿ•£zÿ“¤|ÿ’£zÿ’¤zÿ“£|ÿ}…]ÿy|NÿxyLÿzzNÿvwNÿUV>ÿ‡nÿ”£|ÿ†–oÿ“ zÿš§}ÿ}ƒ]ÿwsTÿ–“uÿ‡…nÿjyÿg…“ÿ§¦ÿ\âò\îÿ\íöôÿ\êöôÿ\èöóÿ\çõóÿ\ÄË¢ÿÁÉŸÿ½Ç›ÿ»Ä™ÿºÃ—ÿ¸Â—ÿ¶Á–ÿ¶Á”ÿ¶À“ÿ²¿’ÿ­»Žÿ«¹Œÿ©·Šÿ®¼Žÿ´¿’ÿµ¾’ÿ´½‘ÿµ¾’ÿµ¿’ÿ±¼ÿ¯¼‘ÿ­ºÿŸ¨yÿ†„Dÿ¡6ÿÀ¾+ÿ\Ù\Ú*ÿ\ß\âÿ\à\âÿ\à\âÿ\à\â ÿ\à\âÿ\á\á ÿ\â\á ÿ\ã\áÿ\ã\áÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á\"ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\á\á ÿ\á\á!ÿ\à\à ÿ\à\Ð\'ÿÍš%ÿÓ–,ÿÒ–.ÿÒ—+ÿÑ&ÿÔª%ÿÚ½%ÿ\ß\Ï(ÿ\â\Ü&ÿ\Æ\È\'ÿ“œ8ÿŒ˜eÿ‘£{ÿ’¤{ÿ“¢{ÿz†^ÿx|PÿyzMÿ{zNÿvwNÿVV?ÿˆnÿœxÿ…“oÿ•¢}ÿ™§{ÿ}‚]ÿwsTÿ–’tÿ‡„mÿkzÿg…•ÿŽ§¨ÿ\äñ\ïÿ\íöôÿ\ìöõÿ\êöôÿ\çõóÿ\ÅÌ¤ÿÁÊŸÿ½Æšÿ»Ä™ÿºÃ˜ÿ¹Â•ÿ·Â–ÿ¸Ã—ÿ¶Á”ÿ²¿’ÿ­»Žÿ«¹‹ÿ«¹Œÿ®¼Žÿ³¾‘ÿµ¾’ÿµ¾’ÿ¶À“ÿ¶¿“ÿ±½ÿ¯»Žÿ ­€ÿ}{AÿÆ¡?ÿÔ¬,ÿØ¶\'ÿÜ¿\'ÿ\à\Ì!ÿ\á\Ö ÿ\ä\Ü#ÿ\á\à#ÿ\â\á ÿ\á\â!ÿ\â\á\"ÿ\á\áÿ\á\áÿ\â\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\á\á!ÿ\á\à!ÿ\ä\Ý&ÿÑ¦$ÿÓ–.ÿÓ–/ÿÓ•.ÿÒ”/ÿÒ”/ÿÓ–.ÿÒ˜.ÿÒ¥(ÿÙ¹(ÿ\Ý\Î+ÿ·¸.ÿ‡’EÿŽ rÿ’£{ÿ}…_ÿz{QÿyzMÿzzMÿuuMÿWV=ÿ€…lÿ‚mÿƒnÿ•¢yÿ™¦zÿ~ƒ_ÿwtUÿ–’sÿ†ƒmÿjy~ÿf„”ÿ©©ÿ\åñðÿ\îöôÿ\ìöôÿ\ë÷óÿ\éöòÿ\ÆÍ¤ÿ\ÃÌ ÿ½Çÿ»ÄšÿºÃ˜ÿ¹Â—ÿ¸Â–ÿºÄ—ÿ·Á•ÿ±¾‘ÿ®¼ÿ¬ºŒÿ«¹‹ÿ­»ÿ³¿’ÿ¶¿“ÿµ¾’ÿ´¾’ÿµ¿’ÿ±½’ÿ®¼ÿ®»Žÿ£­ÿˆx7ÿÂ‘3ÿÒ–.ÿÓ•.ÿÐ—,ÿÑ›+ÿÕ¢)ÿÖ®\'ÿÙ½$ÿ\á\Ë)ÿ\æ\×*ÿ\å\Þ\"ÿ\â\âÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\à\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à!ÿ\à\à!ÿ\à\à ÿ\á\à#ÿØ»%ÿÑ—,ÿÓ–/ÿÓ•/ÿÓ”0ÿÓ•/ÿÒ”-ÿÒ•.ÿÒ•.ÿÒ•.ÿÑ™*ÿÔ¥+ÿÑ´2ÿ›’3ÿŽ”[ÿ€…[ÿzzNÿyzMÿxxLÿuuNÿVU<ÿ~‚lÿ}‡iÿ‡“rÿ—¥zÿ™§{ÿ~„_ÿxtUÿ•‘sÿ†ƒnÿjy|ÿf„‘ÿ‘©¬ÿ\åò\ïÿ\îöôÿ\îõôÿ\ìöóÿ\ëöóÿ\ÈÏ¦ÿ\ÂË¡ÿÀÈžÿ¼Å›ÿºÃ™ÿ¹Â—ÿ¹Â—ÿ·Â•ÿµ¿“ÿ±¾‘ÿ®¼ÿ­»ÿ«¹Œÿ®¼ÿ´À’ÿ¶À“ÿ¶À“ÿ´À’ÿ²¿‘ÿ²¼‘ÿ±½’ÿ°¼‘ÿ­¹Žÿ‰‹`ÿ~p;ÿ¯†6ÿÑ•/ÿÒ–-ÿÒ–-ÿÓ•/ÿÓ•/ÿÒ–-ÿÒ—-ÿÒ›*ÿÕ¦)ÿÙ¶*ÿ\Þ\É\'ÿ\â\Ü!ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\àÿ\á\á ÿ\à\àÿ\à\àÿ\á\á ÿ\à\àÿ\à\àÿ\à\àÿ\à\àÿ\à\à!ÿ\à\à ÿ\à\àÿ\á\á ÿ\á\á!ÿ\á\á ÿ\â\á!ÿ\â\Ð)ÿÎš\'ÿÒ•/ÿÓ”/ÿÓ•/ÿÓ•.ÿÒ•-ÿÓ•/ÿÓ•/ÿÓ•.ÿÓ–-ÿÓ–,ÿÒ•-ÿÒ›-ÿ´-ÿym2ÿ{zKÿyzMÿwvJÿvuNÿTT<ÿ|€kÿ}ˆjÿŒ˜vÿ™¦|ÿš§|ÿ~„^ÿwtTÿ”rÿ†ƒnÿjy|ÿe‚ÿ¨«ÿ\åñ\ïÿ\ïöôÿ\ïöôÿ\íõóÿ\ìöóÿ\ÉÐ§ÿ\ÃÌ¢ÿÁÉŸÿ½Æ›ÿ»Äšÿ¹Â˜ÿ¸Â–ÿ¶À”ÿ¶À“ÿ³¾’ÿ®¼ÿ­»ÿ¬ºÿ®¼ÿ´¿“ÿµ¾’ÿ´¿’ÿ´½’ÿ´¾“ÿ´½“ÿ±¼’ÿ°¼’ÿ­¸Žÿ‹Ždÿ……^ÿ}uGÿ™v,ÿÏ“3ÿÓ•.ÿÓ–-ÿÓ•/ÿÓ•/ÿÓ–/ÿÔ•/ÿÓ–/ÿÔ–.ÿÍž$ÿ\ß\Ð\"ÿ\à\á!ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\áÿ\á\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\á\áÿ\á\áÿ\à\áÿ\à\â!ÿ\à\á!ÿ\â\á!ÿ\á\á!ÿ\á\á!ÿ\â\á ÿ\à\áÿ\á\áÿ\â\àÿ\à\à ÿ\à\àÿ\à\àÿ\à\àÿ\à\à ÿ\à\à ÿ\á\á ÿ\á\á ÿ\à\á ÿ\ß\â ÿ\à\á ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\àÿ\å\Þ$ÿÐ¨#ÿÒ–.ÿÓ–/ÿÓ•/ÿÒ•.ÿÒ•.ÿÓ–.ÿÓ•-ÿÓ”/ÿÓ”/ÿÓ•/ÿÔ”.ÿÓ“-ÿÌ”1ÿŒq/ÿxvFÿyyLÿwwKÿvvOÿSS<ÿuyeÿ€‰nÿŽ›vÿ™§|ÿœ§}ÿ„_ÿvuUÿ’Žoÿ…lÿiz}ÿgƒÿª©ÿ\æñ\ïÿñöôÿðöôÿ\í÷ôÿ\ìöóÿ\ÊÑ¨ÿ\ÄÍ¤ÿ\ÂÊ ÿ¾Ç›ÿ¼Å›ÿ¹Â˜ÿ¸Á–ÿ·À•ÿ¶¿“ÿ´¿’ÿ®¼Žÿ­ºŽÿ®»ÿ¯½ÿ´Á“ÿ¶À“ÿ³¾’ÿ´½“ÿµ¾”ÿµ¿“ÿ¯¼‘ÿ­ºÿ¬¸ŽÿŒgÿ…†_ÿ‡†aÿmhHÿu<ÿÃ‘6ÿÓ•/ÿÔ”/ÿÔ–/ÿÓ–/ÿÔ•/ÿÓ–/ÿÑ™*ÿ\à\Å-ÿ\å\ß\"ÿ\à\â ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\áÿ\á\á ÿ\á\áÿ\à\á ÿ\á\á ÿ\à\á!ÿ\á\á ÿ\â\áÿ\â\áÿ\â\áÿ\â\áÿ\á\áÿ\á\àÿ\â\àÿ\à\à ÿ\à\à ÿ\à\àÿ\à\àÿ\á\á ÿ\á\á!ÿ\á\á ÿ\à\àÿ\à\Þ ÿ\Þ\Üÿ\á\à!ÿ\á\á ÿ\á\á ÿ\á\à!ÿ\â\à!ÿ\â\à\"ÿØº&ÿÑ–,ÿÓ”0ÿÓ”0ÿÓ”/ÿÒ”/ÿÓ•-ÿÒ•.ÿÓ”/ÿÓ•/ÿÓ•.ÿÔ”.ÿÃŽ2ÿ‘x7ÿ{OÿyzMÿyzMÿvwKÿvvOÿRR9ÿrubÿ‡tÿ‘Ÿxÿ˜¦{ÿœ¨~ÿ€…`ÿvtUÿ’oÿ…mÿi{}ÿgƒÿ”ªªÿ\éòðÿóöõÿòöõÿ\ïöôÿ\îõôÿ\ÊÑ¨ÿ\ÇÏ¦ÿ\ÃË¡ÿÁÉžÿ¼Å›ÿºÃ™ÿºÂ—ÿ·Á•ÿ´À“ÿ³½’ÿ®¼ÿ¬ºŒÿ­»ÿ¯½ÿ³À’ÿ´Á“ÿ³À’ÿ´¿’ÿµÀ“ÿµÁ’ÿ´¿“ÿ®»ÿ®·ÿ‹hÿ…†_ÿ‡†bÿooZÿ™›‚ÿŠ…Oÿ°‰9ÿÒ•3ÿÓ–.ÿÓ–-ÿÓ•/ÿÒ–*ÿÝ¹+ÿ\å\Þ$ÿ\á\á ÿ\á\á ÿ\à\àÿ\á\á ÿ\à\á ÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\á ÿ\à\à ÿ\ß\àÿ\×\Üÿ\È\Ïÿ³»ÿž©ÿ’Ÿÿ†‘ÿ‰” ÿ—¢\Zÿ¢­ÿ³¼ÿ\É\Ðÿ\Û\Þ\"ÿ\ß\àÿ\â\àÿ\á\à ÿ\á\á ÿ\à\àÿ\á\á ÿ\â\á ÿ\á\Ö\"ÿÎ¯ÿ\ä\Ø\'ÿ\á\á ÿ\á\á!ÿ\Ô\Èÿ\Ø\Â ÿ\â\Ú$ÿ\â\Ð+ÿÎ›&ÿÓ•/ÿÓ•/ÿÓ•/ÿÒ”/ÿÒ•.ÿÓ•-ÿÓ•-ÿÒ•-ÿÑ”2ÿ±…0ÿŒGÿ–¡vÿ{†]ÿyzPÿyzNÿuvJÿwwPÿRR8ÿrvcÿŒ•yÿ’Ÿyÿ™§|ÿ©€ÿ„_ÿvuUÿ‘Žoÿ‚jÿi{}ÿgƒÿ™¬­ÿ\ëôòÿò÷õÿóöõÿñöôÿ\ïöõÿ\ËÒ©ÿ\ÇÏ¤ÿ\ÅÌ¡ÿÀÉÿ½Æ›ÿ»Ä˜ÿ¹Â–ÿ´À•ÿ±¾’ÿ¯¼‘ÿ­»ÿ¬ºŒÿ­»Žÿ¯½ÿ³Á“ÿ´Á“ÿ³À’ÿ´¿’ÿ´À“ÿµ¿“ÿ³¾“ÿ¯¼‘ÿ­·ÿ‹hÿ…‡`ÿ‡†cÿqp\\ÿ› ‡ÿž¬‚ÿ‘bÿŸ9ÿÌ”6ÿÓ•/ÿÑ—,ÿ×­\'ÿ\æ\Ú)ÿ\á\áÿ\ã\à ÿ\â\àÿ\à\àÿ\á\á!ÿ\á\á ÿ\á\á!ÿ\á\á ÿ\á\á ÿ\á\áÿ\á\áÿ\á\áÿ\ß\áÿ\Ú\Ý!ÿ·\Âÿ‚’#ÿPjCÿ,LPÿ?Tÿ:eÿ\r:sÿ<zÿ;~ÿ;ÿ	<xÿ;qÿ:jÿ<_ÿ3SQÿdwCÿž®\"ÿ\Í\Ôÿ\ß\à ÿ\á\àÿ\á\àÿ\á\àÿ\ã\Ø$ÿÍŸÿÖ¯&ÿ\ä\Ú\'ÿ\ã\ß!ÿ×¾\"ÿÍš&ÿÏ¤\"ÿ\á¾0ÿÓ¢*ÿÓ–.ÿÓ–/ÿÓ–/ÿÒ•.ÿÓ•-ÿÓ•-ÿÓ•-ÿÌ“2ÿ˜{2ÿŒ\\ÿ’ xÿ’¡zÿ}†^ÿyzPÿyyOÿtsJÿvvPÿSS:ÿrvbÿˆ“uÿ“ {ÿ—¥{ÿœ¨}ÿ~„]ÿwuVÿmÿ‚iÿi{}ÿhƒÿ™®¯ÿ\ìõòÿôöõÿôöõÿóöõÿñöôÿ\ËÒ©ÿ\ÉÐ§ÿ\ÅÌ¢ÿÁÉÿ½Çšÿ¼Å™ÿºÃ—ÿµÀ•ÿ°½‘ÿ­»ÿ¬ºÿ«¹‹ÿ­»ÿ¯½ÿ´À’ÿ¶¿”ÿ¶À”ÿ´¾”ÿ³À”ÿ²¿“ÿ¯¼’ÿ®»‘ÿ«¶ÿ‹hÿ…ˆ`ÿ‡‡cÿrq[ÿ—ƒÿœ¬ƒÿž«ƒÿ˜ vÿ‘u4ÿÈ/ÿÑ¡\'ÿ\æ\Ñ)ÿ\ã\Ü#ÿ\Û\È ÿÑ¼\Zÿ\ä\ß#ÿ\ã\à#ÿ\Û\Ìÿ\ä\Þ$ÿ\á\á ÿ\á\á ÿ\à\âÿ\à\áÿ\ß\à ÿ¿\Êÿw&ÿ7VMÿ>^ÿ	<uÿ<~ÿ	<zÿ:sÿ:oÿ?oÿ$Htÿ+Nxÿ.R|ÿ+Nwÿ%HvÿBtÿ;rÿ\n:rÿ\n;xÿ;lÿBUÿNhFÿ˜¨\'ÿ\Ñ\Ó$ÿ\ß\ß!ÿ\â\Û%ÿÐ¢\"ÿÒ˜+ÿØ¯(ÿ\æ\Ø\'ÿ\Ý\Ë%ÿÎ˜&ÿÓ–-ÿÒ˜,ÿÔ™-ÿÓ•/ÿÓ–/ÿÓ–/ÿÒ•-ÿÓ–-ÿÒ•/ÿ¾‹0ÿx8ÿ™oÿ’¡{ÿ‘¡zÿ”¢|ÿ~†`ÿyzPÿyxOÿwuNÿwvQÿSS<ÿvzfÿ‡“sÿ•£|ÿ•£yÿ§|ÿ„]ÿwuTÿ’Žoÿƒ€jÿl{~ÿi„’ÿ˜¯®ÿ\ìõðÿôöôÿó÷ôÿôöõÿòöôÿ\ËÒ©ÿ\ÉÐ¦ÿ\ÇÎ£ÿÁÈÿ¾Åšÿ¼Å™ÿºÃ—ÿµÁ•ÿ±¾’ÿ¯¼‘ÿ­»ÿ¬ºŽÿ®¼‘ÿ°¾‘ÿ³À’ÿµÀ”ÿµÀ“ÿ´À“ÿ²¿“ÿ°¾’ÿ¯¼’ÿ®º’ÿ«¶ÿ‹’iÿ†‰bÿ††cÿrr\\ÿ–œ‚ÿž¬‡ÿ˜¢zÿ†‚Qÿœx.ÿË”.ÿ\ã¶5ÿÛº#ÿÑ¥$ÿÏ™&ÿÙ·&ÿ\æ\Þ%ÿ\Þ\É&ÿË¢ÿ\ä\Ô)ÿ\à\àÿ\à\áÿ\Ú\Þ#ÿ¬µ&ÿRj1ÿ@Yÿ\n;yÿ;{ÿ8qÿ*M|ÿXpÿ†–¥ÿ³¼\Èÿ\È\Ñ\Úÿ\Ô\Ü\áÿ\Ù\Ü\Þÿ\Ø\×\Ûÿ\×\Õ\Øÿ\Ï\Î\Ôÿ\Ç\È\Íÿ¼Á\Éÿª³Áÿ‹™¬ÿfvÿ7Qrÿ<kÿ9uÿ:mÿEQÿf{?ÿ¹¿-ÿÌ£+ÿÒ•.ÿÒ–.ÿØ®(ÿ\è\Î0ÿÍœ#ÿÓ•-ÿÓ–/ÿÓ–/ÿÓ•0ÿÓ•0ÿÓ–/ÿÌ*ÿÔ”2ÿ§€-ÿ†~Iÿ’Ÿwÿ‘¡{ÿ‘¡zÿ‘¡zÿ“¢zÿ~…`ÿ{|RÿyyMÿwvKÿwwPÿRS<ÿ}lÿŽšuÿ”¢yÿ•¢wÿ¨}ÿ…^ÿvtTÿ‘Žmÿ~iÿm|ÿj…“ÿ˜¯¯ÿ\ìõñÿôõõÿôöõÿôöõÿòöôÿ\ÌÓªÿ\ÊÑ¦ÿ\ÆÍ¢ÿ\ÄË ÿ¿Æ›ÿ¼Å™ÿ¹Ã–ÿ´Á“ÿ±¾“ÿ®¼‘ÿ­»ÿ¬ºÿ­»ÿ°¾‘ÿ²À’ÿ´Á“ÿ´Á”ÿ²À”ÿ²¿’ÿ°½’ÿ¯¼‘ÿ­ºÿ«·ÿŒ“jÿ‡Šeÿ‡†cÿqr]ÿ“™€ÿ„ˆ`ÿy8ÿÄ5ÿÒ•1ÿÓ–,ÿÒ˜*ÿÒ–*ÿÓ•-ÿÒ–(ÿ\á\Å(ÿ\ã\Ï&ÿÎ $ÿÐ™(ÿ\â\Ç*ÿ\ß\Þ\"ÿ©´ÿB`*ÿ>^ÿ=~ÿ\r;vÿ.N}ÿrŠ¤ÿ»\Æ\Ñÿ\å\í\íÿôóñÿ\å\æ\äÿ\Ä\É\Íÿ¸À\Èÿ¶»\Åÿ´¸Áÿ©ª´ÿª«·ÿµµ\Ãÿ•š£ÿ ¦°ÿ´¸\Äÿ¶¸\Åÿ´º\Âÿ±¶Áÿ ªºÿgwŽÿ+Dkÿ6pÿ8yÿ>bÿXYFÿ¬‡>ÿÐ”4ÿÒ—*ÿÛ«0ÿÕž*ÿÓ•-ÿÔ–.ÿÓ–/ÿÓ•/ÿÓ–/ÿÓ•/ÿ©rÿ†n1ÿŽ’dÿ“¡yÿ¢zÿ¡{ÿ‘¡yÿ’¢{ÿ’¡zÿ}†`ÿ{|QÿxyMÿvwKÿwwPÿSS=ÿƒmÿ’žxÿ” xÿ™£yÿ§}ÿ€„^ÿvtSÿkÿ}iÿl|€ÿk†”ÿ˜¯¯ÿ\íõñÿôöõÿõõõÿõöõÿôöõÿ\ËÒ§ÿ\ÊÑ¦ÿ\ÆÍ¢ÿ\ÄË ÿÁÇœÿ½Åšÿ»Ä˜ÿ¸Â•ÿ³¾“ÿ®¼‘ÿ®¼‘ÿ­»ÿ­»ÿ±¿’ÿ³À’ÿµÁ“ÿ²À”ÿ°¾“ÿ°¾“ÿ¯½’ÿ­»ÿ¬ºÿ«¸ŒÿŽ•nÿ‡Šfÿ…†dÿorZÿˆvÿxvLÿ›€;ÿ²‚)ÿ´ ÿÐ“-ÿÓ–-ÿÓ–-ÿÔ•/ÿÑ›(ÿ\é\É2ÿÏ§!ÿÓ–,ÿÒ–,ÿÍ²3ÿm#ÿ?Sÿ<vÿ\r:sÿ/Pyÿ”©ÿ\á\ç\ìÿòòòÿóòòÿôóóÿóôóÿ\Ç\Ê\Ðÿµº\Äÿ²¹\Äÿš ªÿdhrÿ[`jÿY]gÿikvÿY]`ÿž£¬ÿ³¸\Äÿ´¸\Åÿ²¹\Åÿ´¸\Äÿ³·\Äÿ³·\Äÿ¬±Áÿ`k~ÿ)Adÿ7lÿ9uÿ8`ÿa]Lÿ¼Ž>ÿÐ”.ÿÔ•,ÿÔ”,ÿÕ•-ÿÓ–.ÿÓ•/ÿÓ–.ÿÓ”/ÿÀ)ÿ‰Gÿ–¥|ÿ–¤|ÿ‘¡zÿ‘¡|ÿ‘¡{ÿ“£{ÿ•£{ÿ{…\\ÿz{OÿvwLÿvwLÿwxOÿST=ÿ‚‡oÿ”¡yÿ–£xÿš§zÿžª~ÿ~…^ÿutTÿlÿ€}iÿk}ÿi‡‘ÿ˜°¯ÿ\ëõòÿôöõÿõõõÿõööÿôöõÿ\ËÒ¨ÿ\ÊÑ¦ÿ\ÇÎ£ÿ\ÃÊŸÿ\ÂÉžÿ¿Èœÿ½Æšÿ»Ä˜ÿµÁ”ÿ±¾’ÿ°½’ÿ®¼‘ÿ­»ÿ°¾’ÿ´Á“ÿ¶Á”ÿ³À•ÿ®¼’ÿ­»‘ÿ®¼’ÿ­»ÿ¬ºÿ©¶‹ÿŽ–nÿ‡Šfÿ„…aÿpsZÿ•œ‚ÿžª‡ÿ˜§€ÿˆ‹\\ÿ¡v\'ÿÑ•0ÿÓ–-ÿÓ–.ÿÓ•/ÿÖ.ÿØ©*ÿÒ˜+ÿÒ”1ÿ©‚0ÿ<C6ÿ:qÿ\n<zÿ\Z=qÿh|—ÿª´\Äÿ´¸\Äÿ\è\é\ìÿóóóÿóóóÿôôôÿ\îðóÿº½\Æÿ·¸\Åÿ™¨ÿ\\blÿ–š§ÿ­±½ÿ«°ºÿ‘”ÿ…ˆŽÿ´¸\Äÿ³¸\Äÿ´¹\Åÿ´¸\Åÿµ¹\Åÿ´¹\Åÿ²º\Åÿ´¸\Äÿ˜š§ÿqt€ÿLXoÿ7cÿ\n<zÿ\n:uÿ#<Vÿˆr>ÿÊ”6ÿÒ•-ÿÔ–/ÿÓ–/ÿÓ”0ÿÓ”/ÿÓ•.ÿÑ–/ÿx0ÿ˜¥yÿ”£zÿ’¢|ÿ {ÿ‘¡zÿ’¢{ÿ•¤{ÿ{„Zÿz{OÿttJÿtuKÿxyPÿTT>ÿ‚‡oÿ•¡yÿ—¥yÿ™§zÿœ©~ÿ|ƒ[ÿusSÿnÿ~jÿl~ÿi‡‘ÿ™°¯ÿ\ìôòÿôöõÿõõõÿöööÿõõõÿ\ËÒ©ÿ\ÊÑ¦ÿ\ÇÎ£ÿ\ÅÌ¡ÿ\ÃÊŸÿÁÉÿ¾Æ›ÿ½Æšÿ¸Ä—ÿ´Á“ÿ°¾’ÿ¯½’ÿ¯½ÿ±¿’ÿ³À’ÿ·Â•ÿµÂ–ÿ²À–ÿ®¼“ÿ­º“ÿ­»‘ÿ¬ºÿ¨´Šÿ–lÿ‡Šeÿƒ„`ÿprYÿ˜žƒÿ›©ƒÿ˜¦ÿŽ€FÿÎ•6ÿÒ–.ÿÓ–.ÿÓ–.ÿÓ–-ÿÔ—,ÿÓ–*ÿÐ•,ÿ˜t.ÿ):Fÿ<xÿ;yÿ%Ivÿž²ÿ²¸\Äÿ´¹\Åÿ´¸\Äÿ\á\ã\åÿóôòÿóóóÿóóóÿ\æ\ç\ëÿ¹¹\Äÿ²²¼ÿcaiÿ—›¤ÿ¯´Àÿ•›¦ÿ•œÿ ¦­ÿ´º\Âÿ´¹\Äÿ´¹\Åÿ´¹\Åÿ´¸\Åÿµ¹\Åÿ´¹\Åÿ´¹\Åÿ²¸\Äÿ£¨·ÿtw…ÿagvÿ0Hgÿ<xÿ;|ÿ<{ÿ4gÿSMAÿ»>ÿÑ•.ÿÒ•.ÿÒ”/ÿÒ”/ÿÒ•.ÿÑ–/ÿ¨(ÿ–˜hÿ–£zÿ“¢{ÿ‘¡yÿ’¢{ÿ’£{ÿ”¥|ÿzƒYÿz|PÿstKÿssJÿxxPÿTT>ÿ…mÿ”¡xÿ•£wÿ™§zÿœ©~ÿ|‚[ÿutTÿoÿ}gÿm~€ÿi‡‘ÿ˜°¯ÿ\ëôòÿôöõÿõõõÿöööÿõõõÿ\ËÒ¨ÿ\ËÒ§ÿ\ÉÐ¥ÿ\ÆÍ¢ÿ\ÃÊŸÿ\ÂÊžÿÁÉœÿ¾Èšÿ»Ä˜ÿ¶Â•ÿ´Â”ÿ²¿’ÿ±¾‘ÿ²À“ÿ´Á”ÿ¶Â•ÿ´Á“ÿ²¿“ÿ®¼’ÿ¬ºÿ­»ÿ«¹Žÿ¨µŠÿŽ•mÿ‡‹fÿƒ„`ÿqsZÿ”›€ÿœª‚ÿ…‚Sÿ¾<ÿÒ–/ÿÒ–-ÿÓ–.ÿÓ–.ÿÓ–.ÿÒ–-ÿÑ•*ÿ™t*ÿ$8Eÿ<yÿ={ÿ.Nzÿ›§¿ÿ¬°¾ÿµ¹\Åÿ´¹\Åÿ´¹\Åÿ\Û\Ý\ãÿóôóÿóóóÿóóóÿ\Ú\Ü\ßÿ¶º\Æÿ“•£ÿns€ÿ³¸\ÄÿotÿeksÿryÿX^hÿ•¤ÿ³¹\Ãÿµ¹\Åÿ´¹\Åÿ´¸\Äÿ´¸\Äÿ³¸\Äÿ•™¦ÿª¯»ÿ¦«¹ÿqu‚ÿJN]ÿ@Plÿ\r;rÿ<|ÿ;|ÿ;zÿ$Nÿ.15ÿ«„?ÿÏ”0ÿÒ•-ÿÓ•/ÿÓ–/ÿÒ•/ÿÅ’3ÿƒHÿ˜¥zÿ“¡zÿ’¢{ÿ’¢{ÿ’¡{ÿ•¢|ÿzƒ[ÿz{PÿssJÿsrJÿwwQÿSS>ÿ†mÿ” zÿ•£zÿ™§yÿœ©}ÿ{ƒ[ÿuuUÿ‘‘qÿ~{fÿn€„ÿjˆ’ÿš²±ÿ\ëõòÿôöõÿõõõÿöööÿõõõÿ\ËÒ¦ÿ\ËÒ§ÿ\ÊÑ¦ÿ\ÈÏ¤ÿ\ÄË ÿ\ÃÊžÿ\ÂÊœÿ¿Èšÿ»Ä—ÿ¸Â–ÿ·Ã–ÿ´Á”ÿ³À’ÿ³À“ÿ·Â•ÿ¸Â•ÿµÀ“ÿ°¾‘ÿ¯½’ÿ­»ÿ­»ÿ¬ºÿ¨µŠÿŽ•nÿˆ‹hÿ„…bÿqsZÿ”›€ÿ’–mÿ§ƒ?ÿÒ–2ÿÓ–/ÿÓ–.ÿÓ–.ÿÓ–.ÿÓ–.ÿÒ•-ÿ«(ÿ(/)ÿ<tÿ	<|ÿ8oÿ‰š´ÿ”œ ÿ…ˆŠÿ´º\Çÿ´¹\Åÿ´¹\Åÿ\×\Ø\âÿóóóÿóóóÿóóóÿ\Î\Ò\Öÿµ¹\Ãÿ|~ˆÿ‡”ÿ¢§­ÿbjiÿ°¶¾ÿ²¶\ÂÿšŸ­ÿ]`oÿ°³\Âÿ´¸\Äÿ¶¸\Åÿ´¹\Åÿ³¸\Åÿ²¶\Ãÿx|‰ÿ…ˆ–ÿ¦ª¸ÿrv„ÿqtƒÿIZoÿ;nÿ<}ÿ;|ÿ\n;vÿ$PÿAÿ310ÿÁ‘AÿÒ•-ÿÒ•.ÿÓ–/ÿÒ•/ÿÏ•0ÿ”{1ÿ˜¢vÿ’¡zÿ‘¡zÿ‘¡zÿ’¡zÿ–¢|ÿ{‚]ÿzzQÿtrJÿtrLÿwvQÿQR=ÿ†lÿ” zÿ•£zÿ˜¦zÿ¨|ÿ{‚[ÿvuVÿ’‘sÿ}iÿn†ÿkˆ”ÿš³²ÿ\éõòÿóöõÿõõõÿöööÿõõõÿ\ÌÓ©ÿ\ËÒ§ÿ\ËÒ¦ÿ\ÉÐ¥ÿ\ÄË ÿ\ÃÊŸÿ\ÃÊžÿÁÇœÿ¼Å™ÿºÄ•ÿ¹Ã–ÿµÂ”ÿµÁ”ÿ´Â”ÿ¶Á“ÿ·Â•ÿ´Á”ÿ¯½’ÿ¯½’ÿ­»ÿ­»ÿ«ºÿ£°‡ÿŒ’mÿ‡‹hÿƒ†cÿosUÿ‘”|ÿ‘zFÿÎ”9ÿÓ–.ÿÓ•.ÿÓ–-ÿÓ–.ÿÓ–.ÿÓ•.ÿÂ1ÿ80ÿ2_ÿ	<|ÿ	<|ÿ7kÿŸ¬Àÿ°µ¿ÿª¯ºÿµº\Åÿ´¹\Åÿ´¹\Åÿ\Ï\Ð\Ùÿòóóÿóóóÿóóôÿ\Ã\Ç\Îÿ´¸\ÅÿuzƒÿŽ“ÿ˜¦ÿˆŒÿ³·¿ÿ¨ª¶ÿ²·\Åÿdgsÿ¡¦±ÿ´¸\Åÿµ¸\Åÿ´¹\Åÿ´¸\Åÿ«¯¼ÿsw…ÿuzˆÿ¡¤²ÿrv„ÿqv„ÿP_rÿ9jÿ<{ÿ;{ÿ9tÿ!Iÿ Bÿ7ÿ…g>ÿÐ”3ÿÓ•/ÿÓ•/ÿÒ•.ÿÒ–.ÿ®„*ÿ‘‘_ÿ‘ yÿ xÿ’£{ÿ”¢{ÿ–£|ÿ{‚\\ÿz{QÿtrJÿtrLÿywRÿQR=ÿ€„kÿ‘žxÿ“¡wÿ˜¦zÿ¨|ÿ{[ÿutTÿ‘qÿ€|jÿn…ÿkˆ”ÿš´³ÿ\èôòÿóöõÿöööÿöööÿöööÿ\ËÒ§ÿ\ËÒ§ÿ\ÊÑ¥ÿ\ÈÐ¡ÿ\ÅÌ ÿ\ÃÊŸÿ\ÃÊŸÿ\ÂÉžÿ¾Ç›ÿºÄ–ÿºÃ–ÿ·Ã•ÿµÂ”ÿµÂ•ÿµÂ”ÿ³À’ÿ±¿“ÿ°¾“ÿ®¼‘ÿ­»ÿ­»ÿ«ºÿ¡®…ÿŒ’mÿ‰jÿ†ŠgÿnpVÿ}pWÿÁ‘?ÿÒ”1ÿÓ–-ÿÓ–/ÿÓ•-ÿÔ–.ÿÓ–.ÿÑ–3ÿfNÿ\n!5ÿ\n8qÿ	<}ÿ	<|ÿ8kÿ ­\Âÿ³¸\Äÿµ¹\Æÿµ¹\Åÿ´¹\Åÿ´¹\Åÿ\Æ\È\Ñÿóóôÿóóóÿññóÿ»¾\Çÿ°´Àÿ^afÿŠÿ¦ª´ÿ_agÿ”™ ÿ[_kÿ°³Àÿw|†ÿ‘—£ÿ´¸\Åÿµ¸\Åÿµ¹\Åÿ´¸\Åÿ¡¥³ÿrv„ÿsx†ÿ™¬ÿsw…ÿqv„ÿN]oÿ:jÿ<{ÿ<|ÿ3iÿ EÿCÿCÿTE1ÿÏ”8ÿÒ”/ÿÑ•1ÿÒ”/ÿÓ–.ÿÊ”1ÿ‰}?ÿŸvÿ xÿ“¢{ÿ–£|ÿ˜¥~ÿz[ÿz{QÿtsJÿtrKÿyxRÿRR=ÿ€„lÿwÿ“¡wÿ˜¦zÿ¨|ÿy€ZÿutTÿ’‘rÿ€|iÿn…ÿk‰”ÿ¶¶ÿ\çõòÿóöõÿöööÿõõöÿööõÿ\ÌÓªÿ\ÌÓ¨ÿ\ÊÑ¦ÿ\ÈÏ£ÿ\ÅÍŸÿ\ÃÊŸÿ\ÂÉžÿ¿Èœÿ¼Æ™ÿ»Ä˜ÿ¹Ã•ÿ¶Ã•ÿ·Â•ÿ¸Â–ÿµÁ”ÿ³À’ÿ±¾‘ÿ°½’ÿ®¼‘ÿ­»ÿ­»ÿ«¹Žÿ¢¯…ÿŠ‘kÿ‹lÿŒnÿnhIÿ¥~=ÿÓ•1ÿÓ•.ÿÔ–/ÿÔ•/ÿÕ•/ÿÓ”0ÿÒ–/ÿ¯ƒ+ÿ!\Zÿ%Kÿ:wÿ	;}ÿ<|ÿ8mÿ›©¾ÿ´·\Åÿ´·\Äÿ´¸\Åÿ´¹\Åÿ´¹\Åÿ¾¿\Êÿñòôÿóóóÿ\ì\ì\ïÿµ»Áÿ†”ÿP^`ÿlp€ÿµ·\Äÿƒ‡ÿY_gÿ”žÿ³¸\ÃÿgluÿŸ£®ÿ³¸\Åÿ´¸\Åÿ¶·\Åÿµ¸\Åÿ”—¤ÿtw…ÿx|‰ÿ‘–£ÿpuƒÿhl{ÿ5ATÿ7kÿ;}ÿ	;{ÿ-`ÿ CÿBÿ @ÿI@/ÿÎ”6ÿÅ)ÿ‡eÿ’u3ÿ®ƒ,ÿÅ“4ÿ•}5ÿ’ŸuÿŸxÿ“ zÿ–¢|ÿ–¤{ÿyZÿyzPÿvtIÿtsIÿzxPÿQR;ÿ€„kÿvÿ“£wÿ˜¦{ÿœ©{ÿ|‚\\ÿvtTÿ”‘sÿ~iÿn…ÿlˆ–ÿ·¸ÿ\çôòÿóöõÿõööÿõõöÿöõõÿ\ËÒ©ÿ\ËÒ§ÿ\ÊÑ¦ÿ\ÊÒ¤ÿ\ÆÍŸÿ\ÃË ÿ\ÂÉžÿ¾Æ›ÿ¼Å™ÿ¼Å™ÿ»Å–ÿ¹Ã–ÿ¹Â–ÿ·Ä–ÿ¶Ã•ÿ´Á“ÿ²À“ÿ¯½‘ÿ®¼‘ÿ®¼‘ÿ­»ÿ¬ºŽÿ¦²‡ÿŽ•nÿ‹‘mÿ‘‘qÿl8ÿÎ•9ÿÕ”,ÿÒ•0ÿÈ’5ÿ¶‰-ÿ¡w\"ÿ²{ ÿÐ•2ÿ]Hÿ\n8ÿ(Tÿ;yÿ	<}ÿ<|ÿ\r8nÿŒ²ÿ£¨µÿ´¸\Äÿ´¸\Åÿ´¸\Åÿ´¹\Æÿ¶º\Äÿ\ì\îñÿòóóÿ\â\ã\çÿ²·¾ÿ_`eÿ§©ªÿcbmÿœ «ÿ³·\Âÿ³¸Áÿ³¸\Âÿ™Ÿ§ÿ_diÿ°´Àÿ³¸\Äÿ´¹\Åÿµ¸\Åÿµ¹\Æÿ‡Š˜ÿsv„ÿ‚ÿˆŒšÿqv„ÿptÿO\\oÿ8jÿ<|ÿ\n;zÿ\'WÿDÿBÿ>ÿNF.ÿÍ”3ÿË•3ÿŽ}@ÿ–¡tÿˆcÿxyIÿno@ÿŒ˜rÿ yÿ’¡zÿ–£|ÿ—¤}ÿyYÿxxOÿvuKÿtsJÿxwOÿPP:ÿ†mÿŒ›uÿ“¢yÿ–¤yÿš§yÿ{[ÿusSÿ–“uÿ€}hÿn€…ÿk‰–ÿœ·¸ÿ\æõñÿò÷õÿõööÿöõöÿõõõÿ\ÊÑ¨ÿ\ÊÑ§ÿ\ÊÑ¦ÿ\ËÒ¦ÿ\ÇÏ¡ÿ\ÄË ÿ\ÂÉžÿ½Åšÿ»Ä˜ÿ»Ä˜ÿºÃ—ÿ¹Ã–ÿºÃ–ÿ·Å•ÿ·Å•ÿµÂ“ÿ³Á”ÿ°¾’ÿ®¼‘ÿ¯½’ÿ­»ÿ­»ÿ¯»ÿ–nÿŒ‘mÿwvUÿŽt=ÿž{\'ÿ–|:ÿŒƒLÿ‡‹Yÿ— jÿ‘ŽWÿ¹4ÿ¿5ÿ\"#ÿBÿ\'Sÿ;yÿ;|ÿ	<|ÿ\r8sÿl|—ÿ‚Š—ÿ´·\Äÿ´¸\Åÿ´¸\Åÿµ¹\Æÿ´¸\Äÿ\á\ä\èÿñôòÿ\Ù\Ü\àÿœ¡©ÿR\\`ÿw}‚ÿ_bdÿgjqÿŠŽ™ÿ™Ÿ§ÿˆ”ÿ[aiÿ‹šÿ´¸\Æÿ´¸\Åÿµ¸\Åÿ´·\Äÿ³·\Äÿy}ŠÿsvƒÿˆŒšÿ{ÿqv„ÿpuƒÿO^sÿ8kÿ;|ÿ\n:zÿ$RÿDÿBÿ =ÿ]P0ÿÍ“2ÿÎ•2ÿ’{5ÿ—¤uÿ—¥yÿ–£yÿ•£zÿ’ zÿ‘ zÿ yÿ•¤|ÿ–£}ÿy€YÿuvMÿvwLÿttKÿwwOÿOO9ÿ†lÿœuÿ’¡vÿžrÿš§zÿ{€ZÿvsTÿ—”vÿ€}hÿo‡ÿk‰–ÿœ¸¹ÿ\æõòÿñ÷õÿõööÿõööÿõõõÿ\ËÒ¨ÿ\ËÒ¨ÿ\ËÒ§ÿ\ÊÑ¦ÿ\ÇÎ¢ÿ\ÄÌŸÿ\ÂÊÿ¾Æšÿ»Ä™ÿºÃ—ÿºÃ˜ÿºÃ—ÿ»Ä–ÿºÄ•ÿ¹Ä—ÿ´Á”ÿ±¿’ÿ´Â”ÿ³À“ÿ±¿”ÿ®¼‘ÿ­»ÿ¬ºŽÿ‘™qÿŒ‘oÿ‡‰jÿolTÿšÿ¥²Šÿ¤µ‹ÿ¨¸‹ÿ¯¼‹ÿCÿÌ—8ÿ w,ÿ)ÿ Aÿ\"Mÿ\r9vÿ	<{ÿ	<}ÿ\r9uÿp‚ ÿ¯±Àÿ´·\Åÿ´¹\Åÿ´¸\Åÿ´¹\Åÿµ¹\Åÿ\Ó\Ö\Úÿòôóÿ\Ñ\Õ\Øÿ¥ª´ÿ{‰ÿ€„Œÿƒ…ÿ~Œÿgkvÿ^bnÿeiuÿŽ’ÿµ·\Äÿµ·\Äÿµ¹\Åÿµ¹\Åÿ´¸\Åÿ¥ª¸ÿtw†ÿsv„ÿŒÿsv„ÿrvƒÿruƒÿGVmÿ:pÿ<}ÿ	:{ÿ)ZÿDÿBÿ7ÿu^5ÿÏ’1ÿÐ•.ÿ¡}+ÿ˜Ÿlÿ–¥xÿ–¤yÿ“¤{ÿ‘¡|ÿ‘ {ÿžyÿ”£{ÿ”¡zÿzZÿvwMÿxxNÿtuJÿwxOÿOO:ÿ‚‡mÿŽ›sÿ–¤yÿ–¤vÿ›©|ÿz€ZÿvsTÿ–”vÿ}ziÿo‚ˆÿlŠ—ÿ¸·ÿ\æõñÿñöõÿôöõÿõööÿõööÿ\ÊÑ¨ÿ\ËÒ¨ÿ\ËÒ§ÿ\ÊÑ¦ÿ\ÈÏ£ÿ\ÄÌžÿÁÈÿ¾Æ›ÿºÃ˜ÿºÃ—ÿºÃ—ÿºÃ—ÿºÄ•ÿ¸Å—ÿ¸Ä˜ÿµÃ–ÿ´Á”ÿ´Á”ÿµÂ•ÿ³Á“ÿ°¾‘ÿ®¼ÿ­ºÿ’šrÿ’pÿ‘sÿuu`ÿ¢†ÿ§´‹ÿ§µŠÿ¬¹‹ÿ¦®‚ÿž7ÿÒ”.ÿšw-ÿ-ÿ Bÿ Gÿ\n6kÿ	;{ÿ	<}ÿ\r;vÿ^t’ÿ²·\Äÿ´·\Äÿ´¹\Åÿ´¹\Åÿ´¹\Åÿ´¹\ÅÿÀ\Â\Ëÿ\ê\ìðÿ\Ä\Æ\Îÿµ¹\Åÿµ¹\Æÿµ¸\Åÿ¶·\Æÿµ·\Åÿµ·\Åÿ²µ\Âÿ³¶\Ãÿ³¸\Äÿ´¸\Äÿµ¸\Äÿµ¸\Åÿ¶¸\Åÿ´·\Åÿ’•¤ÿtv†ÿtv„ÿ}ÿtuƒÿrvƒÿqu‚ÿ<Ohÿ\r<tÿ<}ÿ	;|ÿ2jÿ HÿBÿ.ÿ„k:ÿÑ“1ÿÒ”.ÿµ‡,ÿ’”\\ÿ’ uÿ”¢yÿ“£{ÿ zÿŽxÿ‘žzÿ–£|ÿ•¢{ÿz‚ZÿxzNÿyzNÿtuJÿwxOÿNO;ÿ„‰pÿ‘žvÿ—¥xÿ™¦xÿœª}ÿ{[ÿwsTÿ–•vÿ~zjÿp‚ˆÿk‰˜ÿœ¸·ÿ\æôðÿñöôÿõööÿöööÿõõõÿ\ÊÐ§ÿ\ÊÑ¦ÿ\ËÒ§ÿ\ËÒ§ÿ\ÈÐ£ÿ\ÄÌžÿÁÉÿ¾Ç›ÿ»Ä˜ÿ»Ä˜ÿºÃ—ÿ¹Â–ÿºÃ—ÿ¹Æ—ÿºÅ˜ÿ·Ä—ÿ¸Â–ÿ´Á”ÿ´À’ÿ³À’ÿ²À’ÿ°¾‘ÿ®»ÿ“›sÿ’oÿ’tÿtu`ÿ¢†ÿ§¶Œÿ©¹Œÿ¬ºÿ•[ÿÄ‘>ÿÒ”/ÿšy7ÿ\'ÿ=ÿCÿ._ÿ\n;zÿ;|ÿ<xÿD`ƒÿ°¸\Çÿ´¸\Äÿ´¸\Åÿ´¸\Äÿ´¸\Åÿµ¸\Åÿ¶¸\Åÿ¹½\Èÿµ¹\Ãÿ¶¸\Âÿµ¹\Ãÿ²·Áÿ­±½ÿ¦«·ÿŸ¡­ÿ”˜£ÿ‹›ÿˆ‹”ÿ…Š’ÿ‡‹–ÿ‹šÿ“žÿ‚‰’ÿjn{ÿnqÿru‚ÿsuƒÿru‚ÿpr€ÿPQ_ÿ2Hgÿ	<xÿ<|ÿ;|ÿ9tÿ!JÿAÿ-ÿh_:ÿ¦€/ÿÉ“6ÿÅ“8ÿŒ…Lÿ’ vÿ”¥yÿ’¤yÿŸxÿ‰™tÿ‘ {ÿ’¢{ÿ“¡zÿx€Vÿz{Nÿ{{NÿuuIÿvvNÿOO:ÿ…‰rÿœuÿ—¥xÿ™§yÿ›¨{ÿzZÿvsTÿ–•wÿ}ziÿp‚ˆÿlŠ—ÿœ¸·ÿ\éôñÿóöõÿõõõÿõööÿõööÿ\ÊÑ§ÿ\ÉÏ¥ÿ\ÊÑ¦ÿ\ËÒ§ÿ\ÈÏ¤ÿ\ÄË ÿÀÉÿ½Æšÿ»Ä˜ÿºÄ˜ÿºÄ˜ÿºÄ—ÿ»Ä—ÿ¼Æ–ÿºÆ˜ÿºÅ˜ÿºÂ—ÿµ¿”ÿ²¾‘ÿ³À“ÿ±¿’ÿ°¾‘ÿ®¼Žÿ’›sÿ‹‘nÿŽ’rÿvw`ÿž£†ÿ©·Œÿ«ºŽÿ­»ÿŒƒLÿ­‡5ÿš~6ÿ‘bÿ&,ÿ7ÿAÿ%Pÿ:xÿ	;|ÿ<{ÿ+Mvÿ®·\Éÿ‘• ÿ²µÁÿµ·\Ãÿ´¸\Åÿ´¶\Ãÿ¦©¶ÿ—š¥ÿ†ˆ“ÿ|}ˆÿkpyÿ`eoÿS[hÿGTfÿBOeÿ>Lbÿ9I_ÿ8H^ÿ8H_ÿ9Hbÿ9Hbÿ9Ibÿ:H^ÿ<G\\ÿ@L^ÿJSbÿSXdÿ\\_jÿdfqÿ[bpÿ;bÿ;zÿ<|ÿ;{ÿ4lÿ GÿBÿ5ÿw‡pÿ‡’eÿ~|Lÿ…t8ÿruBÿ”£xÿ–¥zÿ“¤zÿŸyÿŠšuÿŸyÿ’¡zÿ’ yÿwVÿy{NÿzyNÿvuKÿvvOÿNO:ÿƒ‡oÿŽ›tÿ–£xÿ™¦yÿ›¨{ÿz[ÿvsUÿ–•wÿ|yiÿpƒ‰ÿkŠ—ÿœ·¶ÿ\êõñÿõöõÿõõõÿõõõÿöööÿ\ÊÑ¦ÿ\ÉÐ¥ÿ\ÊÑ¦ÿ\ÊÑ¦ÿ\ÇÎ£ÿ\ÃËŸÿÀÈœÿºÅ˜ÿ·Ä™ÿ¶Ã—ÿ¸Ã—ÿ¹Ã—ÿ¹Ä•ÿºÄ˜ÿ¼Æ™ÿ¹Ã–ÿµ¾“ÿ±»‘ÿ¯½’ÿ²À“ÿ°¾‘ÿ±¿‘ÿ®¼Žÿ’›rÿŠlÿpÿvx`ÿ ¦†ÿ«¹‹ÿ¬ºÿ¨¶‰ÿ…aÿ™¤sÿ°¿Žÿª¼’ÿ0BAÿ:ÿ>ÿ Dÿ7qÿ\n;}ÿ\n;}ÿ;nÿž·ÿrvÿ‰Œ’ÿwz…ÿio{ÿQYiÿ>L`ÿ6G_ÿ0?^ÿ\'=_ÿ9bÿ5gÿ\n6nÿ\n:tÿ9xÿ9xÿ\n:xÿ	:xÿ	;yÿ	;zÿ\n;zÿ\n:yÿ;yÿ9xÿ	8uÿ5lÿ4dÿ 9^ÿ2Sÿ :]ÿ:nÿ;|ÿ<|ÿ	;zÿ,^ÿDÿCÿ ;ÿVkZÿ‘¤vÿ‘£xÿ vÿ›rÿ•£zÿ—¥zÿ”¤{ÿ‘¡{ÿvÿŸyÿ‘¡yÿ‘ xÿ{ƒYÿxyMÿxxNÿwuLÿwwOÿOO:ÿƒˆnÿ”¡yÿ–¤yÿ˜¦yÿ™¦yÿyZÿusUÿ—–wÿzyiÿn„ŒÿjŠ—ÿœ¶¶ÿ\êõòÿõõõÿõõõÿöõöÿöööÿ\ËÒ§ÿ\ÈÐ¥ÿ\ÊÑ¦ÿ\ÊÑ¦ÿ\ÇÎ£ÿ\ÃÊŸÿ¿Ç›ÿ¹Å˜ÿ¶Ã˜ÿµÂ–ÿ¸Â–ÿºÃ—ÿ·Ä”ÿºÄ•ÿ¹Æ–ÿ¸Â•ÿ´½’ÿ¯ºÿ°¼’ÿ´Á”ÿ²À’ÿ°¾ÿ®ºÿ•tÿŠkÿ‘oÿvxaÿ¤ªŠÿ­ºÿ«¹Œÿ§´‰ÿ¨¹Šÿ§¹Šÿ«¼Œÿ©¼ÿ7LFÿ>ÿ ?ÿ Bÿ2hÿ	;|ÿ	;|ÿ\n;xÿ;eÿ*>[ÿ\'=Wÿ#9_ÿ6hÿ7nÿ\r8sÿ:uÿ=zÿ=~ÿ<zÿ;vÿ8rÿ6lÿ5iÿ\Z4gÿ5dÿ5aÿ6bÿ$7cÿ#6cÿ\"6bÿ 8cÿ7dÿ6fÿ5gÿ8rÿ	9zÿ9}ÿ;{ÿ<|ÿ\n;{ÿ\n;xÿ\n4lÿ#OÿBÿCÿ9ÿ^r^ÿ‘¢vÿ’£wÿ‘£wÿ“¤xÿ•£zÿ–¤{ÿ’¡xÿ zÿ yÿ¡yÿ‘ yÿ’ xÿ{ƒYÿvwKÿxxNÿxvLÿwwOÿPP;ÿ„ˆpÿ”¡yÿ“¡vÿ—¥yÿ—¤wÿwYÿusUÿ–•vÿzyiÿp…ÿiŠ—ÿ›µ´ÿ\éöòÿõõõÿöööÿöööÿöööÿ\ÊÑ¦ÿ\ÉÑ¦ÿ\ÊÑ¦ÿ\ÉÐ¥ÿ\ÇÎ¢ÿ\ÄË ÿ¿Æ›ÿ¹Ä˜ÿ¶Ã—ÿµÂ—ÿ·Á–ÿ¹Â–ÿ¶Ã–ÿ¹Å—ÿ»Å–ÿ¹Â–ÿ¶¿”ÿ®ºÿ®»ÿµÂ•ÿ²À’ÿ°¾ÿ¯»Žÿ–Ÿwÿ‹‘kÿŒ‘nÿxyaÿ¥«Šÿ®¼ÿ«¹Œÿ¦´‰ÿ¨¹‹ÿ©»Œÿª½ÿ£¶Œÿ+0ÿAÿ Aÿ Eÿ4lÿ	<|ÿ;|ÿ;|ÿ;xÿ<yÿ\n=wÿ	<{ÿ;yÿ\n8sÿ4iÿ)>gÿDKkÿaVoÿ|_gÿ“ghÿ¤qmÿ±xoÿ»uÿÂ…yÿÉ‰|ÿÍŒ|ÿÐ~ÿÔ’ƒÿÕ’„ÿÔƒÿÑÿÆ‰{ÿžlRÿŽb\'ÿ£x-ÿ‚h5ÿSB:ÿNEZÿ>Efÿ)9dÿ/\\ÿEÿ Aÿ@ÿCÿ4ÿxˆoÿ’£xÿ‘£vÿ’¤wÿ“¤xÿ—¥zÿ—¥zÿ’ wÿŽžwÿŽžwÿ yÿ‘Ÿyÿ’ŸxÿyXÿvwKÿxyMÿxwKÿwwOÿNO:ÿ‚‡nÿ’žwÿsÿ–£xÿ˜¥xÿx€ZÿusVÿ–•vÿyyhÿp„ŒÿiŠ—ÿ··ÿ\ëõòÿöôõÿöõöÿöööÿõõõÿ\ÊÑ¦ÿ\ÊÑ¦ÿ\ÉÐ¥ÿ\ÇÏ£ÿ\ÄÍŸÿ\ÃÊŸÿÀÇœÿ¹Ä—ÿ´Â•ÿ´Á–ÿµÁ–ÿ¶Â•ÿµÂ”ÿ¸Ã–ÿ»Å˜ÿºÂ–ÿ³¾’ÿ°ºÿ±ºÿ¸Â–ÿ²¿’ÿ¯½ÿ®»ÿ–žvÿ‹lÿŒoÿwy`ÿ¤ªŠÿ­»Žÿ«¹‹ÿ¨¶Šÿ¬ºŒÿ«¼ÿ«»ÿ °‹ÿ$-ÿ Cÿ Aÿ\"Kÿ\r9rÿ	;ÿ;}ÿ<|ÿ<zÿ7nÿ!8bÿ/:Uÿf[Fÿb.ÿ¤oQÿÔ–‚ÿæ‰ÿì¢‹ÿð¨ÿô­”ÿô°–ÿö²˜ÿø²™ÿ÷³™ÿ÷²šÿö³šÿö´šÿö³™ÿ÷³™ÿõ³™ÿô±—ÿÄ‰`ÿ¸€:ÿÅŠ4ÿ¬r,ÿ¹‚RÿÜšÿåŸ‡ÿÞ–ƒÿÔ‹|ÿ¾}pÿšhcÿRDDÿ03;ÿ+ÿ\"*.ÿ€bÿ‘£vÿ‘£vÿ•¥yÿ—¥zÿ—¦{ÿ–¦{ÿ“¤yÿ¡yÿ zÿŸzÿŽžyÿžxÿyXÿxyNÿxzMÿxyLÿwwOÿNN<ÿƒ‡oÿ’Ÿwÿ‘Ÿuÿ”¡vÿ—£xÿy€ZÿvtUÿ••vÿyxhÿm…‹ÿi‰•ÿ¸·ÿ\íôòÿõõõÿõõõÿöööÿõõõÿ\ÊÑ¦ÿ\ËÒ§ÿ\ÇÎ£ÿ\ÅÎ¢ÿ\ÃÍŸÿÁÉžÿÀÉÿºÅ™ÿ¶Â—ÿ²¿”ÿ³À•ÿ³Á•ÿ´Â”ÿµÃ•ÿ¹Ã–ÿ·Â•ÿ°½ÿ®ºÿ³½’ÿºÃ—ÿµÁ”ÿ°¾‘ÿ®¼ÿ–žvÿŒlÿnÿwy_ÿ ¦†ÿ«¹ÿª¸Šÿ¬º‹ÿ­»ÿ¬ºŒÿ®¼ÿ­»•ÿ.A?ÿ ?ÿ Cÿ$Mÿ\r3gÿ0jÿ\n*\\ÿ*7Zÿi[kÿ£wqÿÎ€ÿØ–‚ÿ¸}Wÿ®u9ÿµ}=ÿÁ‡]ÿó²•ÿö´šÿö´šÿö´šÿö´šÿ÷´›ÿ÷´›ÿ÷´šÿ÷´šÿö´šÿ÷´™ÿö´™ÿõ´™ÿñ±”ÿ¸€Xÿ®{>ÿ¤r:ÿ•fHÿ™n[ÿ°„pÿß¨‘ÿô´šÿõ³›ÿõ±šÿð«”ÿì¡Œÿ¼{[ÿÃ‘Fÿb.ÿÕ§‘ÿÁ™{ÿŽ•hÿ‘£vÿ”¢wÿ–¤yÿ—¥yÿ•¦zÿ’£xÿ xÿŸxÿ xÿŒuÿŸxÿyYÿwxNÿxyMÿxyKÿvvNÿON<ÿƒˆoÿ“ wÿ’ uÿ“ uÿ•¢wÿw}WÿvtUÿ•–vÿxxiÿl„‹ÿi‡”ÿž¸·ÿ\íõóÿõõõÿõõõÿöööÿöööÿ\ÊÑ¦ÿ\ÉÐ¥ÿ\ÇÎ£ÿ\ÅÍ¡ÿ\ÃÌ ÿÀÉÿÀÉÿ½Åšÿ·Â™ÿ³Á–ÿ³Á–ÿ³Á•ÿ³Á“ÿ´Â”ÿ´Â”ÿ´Á“ÿ³À’ÿ³À”ÿµÀ•ÿ¹Ã—ÿµÂ–ÿ²¿’ÿ¯¼ÿ–uÿŒlÿ‹nÿxz`ÿ¢¨ˆÿ«¹ÿ¨¶‰ÿ«¹‹ÿ¬ºÿ«¹Œÿ¬ºŒÿ­»ÿs†lÿ8ÿ!Dÿ ?ÿ\'1ÿE>;ÿžtpÿØ•‡ÿé¢Žÿð¬–ÿö³™ÿò²›ÿÇ”ÿ”gXÿˆ_>ÿ›o>ÿ¯yPÿé®ÿõ´›ÿõ´™ÿõ´šÿõ´šÿõ´šÿö´šÿö´šÿ÷´šÿøµ™ÿ÷´™ÿì®’ÿ©qQÿži>ÿ–dFÿP6(ÿ=61ÿPLHÿGD?ÿ2)ÿª‚pÿò´˜ÿ÷´˜ÿ÷´›ÿ÷³›ÿÌiÿÃ;ÿ¸Cÿòµ•ÿìµ”ÿ…]ÿ’£xÿ‘¢wÿ’¢vÿ’¤wÿ“¥yÿ’£yÿŸwÿŸwÿ xÿŒuÿ‘ŸxÿyYÿwxMÿwwMÿyzMÿuuMÿMM<ÿƒ‡oÿuÿ’ uÿ“¡uÿ–¢wÿv{UÿvtUÿ•“uÿvwgÿkƒŠÿh‡“ÿ ººÿ\îõóÿõõõÿõõõÿöööÿõõõÿ\ÈÏ¤ÿ\ÉÐ¥ÿ\ÆÎ¢ÿ\ÄÍ¡ÿ\ÂËŸÿ¿ÈœÿÀÈœÿ½ÆšÿµÂ˜ÿ²À•ÿ²À–ÿ³Á–ÿ³Á“ÿ´Â”ÿ´Â”ÿ´Â“ÿµÃ•ÿ´Á•ÿ³¿“ÿ¹Ã–ÿµÂ•ÿ±¾’ÿ®¼ÿ–žvÿŒlÿ‹Žnÿwy_ÿ ¦†ÿ¬ºÿª¸‹ÿª¸‹ÿ¬ºÿ¬ºÿ¬ºŒÿ­»Žÿ­ÿ#*ÿ06Eÿ-)\'ÿ«„Fÿ¸;ÿï®ÿö³˜ÿø³˜ÿõ³›ÿà¨ÿdE6ÿ:2*ÿC=>ÿ50-ÿF3&ÿ€]<ÿ‘a@ÿá¥Œÿô´›ÿö´šÿõ´šÿõ´™ÿõ´šÿõ´šÿ÷´šÿõ´˜ÿæ©ÿX<ÿ±qZÿÃ†uÿ`A9ÿz‚ÿbzÿd}“ÿ–¤®ÿ–˜–ÿ:.*ÿº~ÿô´™ÿõ´™ÿõ´šÿÙœyÿ¼‰=ÿÀ‰QÿÛ¡ˆÿ¬vbÿ«’tÿ“žuÿ¡uÿ’¢vÿ’£wÿ”¥zÿŸxÿ‹›tÿžwÿžwÿ‹›uÿwÿ{‚[ÿwxNÿwwMÿyzLÿvwOÿOM;ÿ‚ˆoÿ‘vÿ’ uÿ’ uÿ•¡vÿv|VÿvtTÿ•“uÿvwgÿk‚‰ÿf„’ÿ¡¹ºÿ\îõóÿõõõÿõõõÿöööÿõõõÿ\ÇÎ£ÿ\ÈÏ¤ÿ\ÆÍ¢ÿ\ÃÌ ÿ\ÂËŸÿÀÉÿÀÈœÿ¾Å˜ÿ¶Á˜ÿ²¾–ÿ±¾”ÿ´Â—ÿ³Á“ÿ³Á“ÿ´Á“ÿ´Â”ÿµÃ–ÿ³À“ÿ®¼ÿ¶Ã”ÿ¶Á“ÿ°¾“ÿ®»‘ÿ—žwÿŒlÿoÿxzaÿž§†ÿ«¹ÿ«¹ÿ«¹Œÿ«¹‹ÿ¬ºÿ¬ºŒÿ­»‹ÿ®¸“ÿyeÿíµŸÿÇ“rÿ¼…<ÿµ~3ÿó¶–ÿõ´™ÿöµ™ÿå«ÿU<+ÿ}ytÿ™Ÿžÿd”ÿZz”ÿOanÿK<6ÿ¦wfÿ“\\GÿÝ ‰ÿõ´™ÿõ´šÿõ´šÿõ´šÿõ´šÿõ´šÿô´™ÿÄŠuÿÎ•{ÿÛ•ƒÿ^MÿŒŠÿY|•ÿXºÿW»ÿkŠ­ÿ\Ù\Û\Ýÿ™š•ÿD0*ÿé°šÿö³šÿö´™ÿã¦„ÿ·…=ÿÅ]ÿ½‚mÿÌ‹€ÿ»yÿ‘™rÿ¡uÿ“¢vÿ•£xÿ“¥yÿ wÿŒvÿŽŸzÿ‹œvÿ‰™tÿxÿ~„\\ÿxxOÿwxMÿxzKÿvvNÿON;ÿˆmÿŽœtÿžsÿ’ uÿ’¡vÿw}XÿvuTÿ•“vÿvwfÿk‚‰ÿeƒÿ¢¸¸ÿ\ïöóÿõõõÿõõõÿöööÿõõõÿ\ÈÏ¦ÿ\ÆÍ£ÿ\ÅÎ¢ÿ\ÄÍ¡ÿ\ÂËŸÿÀÈœÿÁÈ›ÿ¾Æ™ÿ¶Â˜ÿ³À•ÿ³À•ÿ´Â•ÿ´Â”ÿ³Á–ÿ³Á“ÿ²Á“ÿµÂ”ÿ¶Á“ÿ´À’ÿ¹Ä–ÿ¸Â•ÿ±¾”ÿ±¾”ÿ˜ yÿmÿ‘pÿxzbÿ¥„ÿ¬ºŽÿ«¹Œÿ¬ºŒÿ«¹‹ÿ­»ÿ­»ÿ¬»Œÿ¥©ƒÿÐ¦Šÿò²˜ÿì¯ÿ²|7ÿ±{5ÿó¶—ÿõ´šÿõ´šÿ~SCÿyrÿ\Ñ\Ø\Öÿq¢ÿXŽ»ÿWŒ¿ÿX†®ÿ}‰”ÿnaÿâ¥Žÿë«”ÿô³™ÿ÷´šÿö´šÿ÷´šÿö´šÿõ´šÿõµšÿöµ˜ÿõ³—ÿì­™ÿœ‡yÿž°¶ÿ_Š³ÿCsŸÿS…²ÿ\\…¯ÿ\Ú\â\èÿ\×\×\Ñÿ^G@ÿî³›ÿö´™ÿ÷´˜ÿê¬Œÿ¯{=ÿË•hÿº}fÿé¤ŽÿÄ–{ÿ‘˜pÿ¡uÿ”£xÿ”£yÿ•¥{ÿ’¡yÿŸxÿŒwÿˆ˜sÿˆ˜sÿwÿ…]ÿwxOÿwwNÿxyMÿvwNÿOO;ÿ‡mÿ›tÿŸuÿ‘ tÿ tÿx~XÿutSÿ•“vÿuveÿj‚‰ÿeƒÿ£¸¸ÿðõôÿõõõÿöööÿõõõÿõõõÿ\ÉÐ¦ÿ\ÇÏ¤ÿ\ÄÌ ÿ\ÄÌ¡ÿÁÊžÿ¿ÇšÿÀÇšÿ½Åšÿ¶Â—ÿ´Á•ÿ²À”ÿ´Á”ÿ³Á”ÿ³Á”ÿ´Â”ÿµÂ”ÿ¶Ã•ÿµÁ”ÿ¶Á”ÿ»Ä˜ÿ¹Ã—ÿ´Á–ÿµÀ–ÿš¡{ÿŽ‘nÿ‘qÿxzcÿž§†ÿ­»ÿ¬ºŒÿ­»ÿ«¹Œÿª¸Œÿ®¼Žÿ¬¹Œÿš”rÿÍ ˆÿ«s]ÿñ¶™ÿ³Bÿ³~:ÿôµ—ÿõ´šÿõ´šÿfWÿ\Ë\ÅÁÿ\Ù\ä\èÿ^†¦ÿK|ªÿ#JrÿZ¸ÿ‘ª¿ÿµ£ÿï´žÿô³›ÿõ´šÿ÷´šÿö´šÿ÷´šÿ÷´›ÿõ´šÿõ´šÿö´šÿö´™ÿñ³žÿ\æ\Ò\Ìÿ§¶\Åÿ]Œ¸ÿ>m˜ÿU„³ÿ[…¯ÿ\Ó\à\çÿ\å\å\Ýÿž|kÿó´˜ÿö´˜ÿö´˜ÿï°’ÿ©t<ÿË”oÿÐ•{ÿñ±˜ÿ»”vÿ‘œrÿ¡tÿ‘ vÿžxÿ•¢|ÿ’ yÿŽŸvÿ‹œtÿ‰™tÿˆ˜sÿvÿ}„]ÿwxOÿvvOÿyyOÿxxPÿPP<ÿ‡mÿŒ›sÿŸvÿŸtÿ‘¡uÿyZÿusSÿ”“vÿsudÿi‚ˆÿdƒÿ¡·µÿðöôÿõõõÿõõõÿõõõÿöööÿ\ÉÐ¥ÿ\ÈÏ¤ÿ\ÆÍ¢ÿ\ÄÌ ÿÁÉžÿÀÇœÿÀÇœÿ½Ä™ÿ¶Â—ÿ´Á–ÿ²À•ÿ³Á–ÿ²À“ÿ²À”ÿ³Á“ÿ´Á•ÿ·Â–ÿ¹Ã–ÿ¶¿“ÿ»Ä˜ÿ»Ä™ÿ¸Â—ÿ¶À–ÿš¢zÿŒ‘lÿ‘oÿy{cÿ¡§‰ÿ«¹ÿª¸Šÿ¬ºŒÿ«¹Œÿ«¹‹ÿ¬ºÿ­ºÿ¢‘sÿµ€kÿ¹ymÿà¢’ÿÁ‡]ÿ¯zGÿôµ™ÿö´šÿõ´šÿæ®›ÿ\ï\ä\Ûÿ\Ú\ä\æÿ^ƒ¦ÿT„´ÿ=m’ÿkš¾ÿ¦»\Êÿ\î\Ý\Ùÿð¶¡ÿõ´šÿö´šÿõ´šÿ÷´šÿ÷´šÿ÷´›ÿõ´šÿõ´šÿõ´šÿ÷´šÿóµœÿø\â\Óÿ\Å\Ð\ÐÿX„£ÿXŒ¼ÿ‚³\Ùÿl‡ ÿ\ê\îðÿ\ë\á\Øÿà­™ÿô´™ÿ÷´˜ÿö´™ÿó³–ÿ¤n@ÿÅmÿÓ’ÿÎ“}ÿ¦‹mÿ‘žtÿ¡uÿ vÿ‘¡yÿ”¤{ÿ’¡xÿŸwÿŽŸyÿŒœwÿŠšuÿŒ›vÿ{ƒ\\ÿwxOÿwxNÿyxLÿwwOÿNO<ÿ~‡oÿŒœuÿžsÿžsÿ’ uÿy€ZÿutQÿ•’uÿtueÿj‚Šÿeƒ’ÿ¢¹¹ÿðöôÿõõõÿõõõÿõõöÿõõõÿ\ÉÐ¥ÿ\ÇÏ£ÿ\ÅÍ¢ÿ\ÃÌ ÿÁÉŸÿÀÆÿÀÆÿ½Å›ÿ·Â˜ÿµÁ—ÿ³Á–ÿ³Á—ÿ³Á•ÿ³Á“ÿ²Á“ÿ´Â–ÿ¶Á•ÿºÃ—ÿ·Á”ÿ»Ä˜ÿ»Ä™ÿ»Ä™ÿ·Á—ÿ›£{ÿ’mÿ’oÿy{cÿ¢§Šÿ©·Œÿ©·Šÿ«¹‹ÿ«¹Œÿ­»Žÿ¬ºÿ­¸ÿ«‘uÿÊ‹wÿÓ’|ÿ¿„kÿÓwÿ¢pGÿóµ™ÿö´šÿõ´šÿóµ›ÿù\à\Òÿ\ïôñÿw‘¡ÿ[ºÿ^Ž¾ÿ~¼ÿ\È\Ô\Ûÿõ\ã\Úÿð¶Ÿÿõ´šÿ÷´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿõ´šÿõ´šÿõ´šÿ÷´›ÿõµ›ÿö\Ô\Âÿóñ\îÿ‰§ÿ[¡ÿc„¢ÿÀ\Í\Öÿòó\íÿñ\Ö\Éÿòµœÿõµ™ÿ÷´™ÿö´šÿõµšÿ›hGÿ¾ˆoÿÑ€ÿÂ‰vÿ‡iÿŽžuÿ‘¢xÿ‘¢yÿ‘¡zÿ“¥zÿ¡yÿŽŸwÿžxÿŒwÿ‹›vÿ‹›vÿzƒ\\ÿwxOÿwxMÿxxLÿrpLÿMN=ÿ~‡nÿ‹štÿžrÿ‘Ÿtÿ’ŸsÿyZÿvuRÿ•’uÿtueÿi‚Šÿg…“ÿ¢º¹ÿðöõÿõõõÿõõõÿõööÿöööÿ\ÇÎ¥ÿ\ÇÏ¤ÿ\ÃÌ ÿ\ÃÌ¢ÿ\ÂÉ ÿÁÈžÿÀÆ›ÿ½Çÿ»Äšÿ¸Á—ÿ´Á–ÿµÁ–ÿµÁ–ÿ³Á“ÿ³Á”ÿ´Â–ÿ¶Â—ÿºÃ˜ÿ¸Á—ÿ¹Ã˜ÿ½Å›ÿ»Äšÿ¹Â˜ÿœ£{ÿ’mÿ’oÿz|dÿ¢§‰ÿª·ÿ¨¶‹ÿª¸Œÿ«¹Žÿ¬ºŽÿ­»ÿ®¶ÿ®rÿô³™ÿô°˜ÿÂˆnÿæ®’ÿ\\@ÿó´™ÿö´šÿö´šÿõµ˜ÿðÄ°ÿñ\é\ãÿ\Ó\Ü\Ýÿ~–¨ÿv“«ÿ±¾\Éÿðñòÿñ\Ö\Èÿò¶šÿõ´™ÿö´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿõ´šÿóÀ¨ÿ\ç\Ý\Óÿ\ä\è\æÿ\Î\Ò\Óÿ\Ù\Þ\Ýÿ\è\ë\èÿ¸¬¥ÿè¶¥ÿ÷´šÿõ´šÿö´›ÿ÷´™ÿõµ›ÿ­w[ÿÁ‰rÿÅˆvÿÊ”€ÿƒbÿŸuÿ¡wÿ‘¢xÿ’¢zÿ’£{ÿ’¢zÿŸwÿžxÿŒœwÿ‹œvÿ‹›vÿx€[ÿvwOÿvwLÿyxLÿqpJÿOP?ÿ}†nÿ‹›sÿŒsÿrÿžrÿzYÿvuRÿ”‘sÿtufÿk‚Šÿf‡“ÿ¡º·ÿðöôÿõõõÿõõõÿõöõÿõööÿ\ÈÏ§ÿ\ÈÏ¤ÿ\ÃÌ¡ÿ\ÂË ÿÁÊŸÿ¿Çœÿ¾Åšÿ¼ÅšÿºÄ™ÿ¸Â—ÿ¶Á—ÿ·Â–ÿ¶Â•ÿ³Á“ÿ´Á•ÿ·Ã—ÿ¹Ã˜ÿºÃ˜ÿ¼Å™ÿ¾Æšÿ¿Å›ÿ½Ä™ÿºÃ˜ÿž¤}ÿ’nÿ’pÿ|~fÿ¡¨‰ÿ¬ºŽÿª¸‹ÿ¬ºÿ­»Žÿ­»Žÿ­»Žÿ°¹ÿ±”uÿò³›ÿ×‘~ÿÈƒrÿ×œˆÿºgÿô´›ÿö´šÿö´šÿ÷´™ÿñ³šÿ¡pÿ¼ºµÿ\Â\Å\Åÿ§§¥ÿ™’Žÿ­—Œÿé·£ÿõ´™ÿõ´™ÿõ´šÿõ´šÿ÷´šÿ÷´šÿö´šÿõ´šÿõ´šÿö´šÿ÷´šÿï®“ÿë­“ÿÜ¥’ÿµ}ÿrfÿ‡i^ÿ†hYÿ»‹{ÿõ´œÿ÷´šÿö´šÿö´šÿõ´™ÿõ´™ÿá£†ÿ×šƒÿµyhÿÉ™ƒÿŠ…aÿŽŸuÿ‘¡wÿ‘£wÿ’¤xÿ“¤|ÿ’£zÿŽŸxÿžxÿ‹œwÿŒœwÿ‹›vÿvYÿvwOÿvwKÿyyMÿsrNÿQR@ÿ~†nÿŠšsÿ‹›qÿ‹œrÿŽœtÿzZÿwvTÿ•“tÿuwfÿk‚‰ÿf‡“ÿ¡º¸ÿðöôÿõõõÿõõõÿõöõÿõöõÿ\ÈÏ¨ÿ\ÈÏ¥ÿ\ÅÍ¤ÿ\ÂË¡ÿÀÉÿ¾Æšÿ¿Åšÿ½ÅšÿºÄ˜ÿ·Ã–ÿµÂ—ÿ¶Ã˜ÿ³À”ÿ³Â•ÿ´Â–ÿ¹Ä—ÿ¹Â—ÿºÃ™ÿ¼Å™ÿÀÇ›ÿ¿Æ›ÿ¿Åšÿ»Â—ÿ ¤}ÿ‘“oÿ’pÿ~€iÿ¡ª‰ÿ®¼‘ÿ¬ºŒÿ¬ºŒÿ­»Žÿ¬¼ÿ­»Žÿ®ºŽÿ¬–uÿð´ÿÀ|jÿÕ}ÿÆŠsÿò´—ÿõ´˜ÿõ´šÿõ´šÿ÷´šÿö³™ÿë®–ÿ¤veÿžzhÿÁ’}ÿàªŽÿÓ™€ÿÞž†ÿö´šÿõ´šÿõ´šÿõ´šÿ÷´šÿ÷´šÿõ´šÿõ´šÿõ´šÿö´™ÿø´šÿíªÿÅƒmÿè¡‹ÿõ¯—ÿõ´šÿõ´šÿõ³›ÿ÷³šÿ÷´šÿõ´šÿõ´™ÿõ´˜ÿö´™ÿö´™ÿô´™ÿËŽwÿ»}pÿ¿˜€ÿŒ“lÿ¢wÿ¡wÿ’£xÿ’£zÿ’£{ÿ¡xÿŽžxÿžxÿ‹vÿ‹œvÿŠšuÿu}XÿtwNÿvxLÿxzMÿuuPÿTT>ÿ†nÿŠšrÿˆšoÿ‡˜pÿœuÿy}YÿwuSÿ”’tÿtvgÿj‚‰ÿf‡”ÿ ¹·ÿñöôÿõõõÿöööÿõõõÿõõõÿ\ÉÐªÿ\ÈÏ¤ÿ\ÅÍ£ÿ\ÄÍ¢ÿ\ÂÊ ÿÀÈœÿÁÇœÿÀÇœÿ¼Å™ÿºÃ˜ÿ¸Â˜ÿ´À•ÿ³Á•ÿ¶Â–ÿµÃ—ÿ·Â–ÿ¹Â—ÿºÃ™ÿ¼Åšÿ¾ÅšÿÀÆœÿ¿Å›ÿ½Ä™ÿ ¤}ÿ“oÿ“qÿ~€iÿ¡©‰ÿ­»Žÿ­»Œÿ¬ºŒÿ­»ÿª¹ÿ¬ºÿ¬¹ÿ¡•pÿì³œÿ¼yhÿÒŽ|ÿÉ‹wÿõ´™ÿö´™ÿö´šÿõ´šÿ÷´œÿ÷´šÿö´›ÿ÷³šÿø´šÿø³šÿò°•ÿ×—~ÿô²—ÿö´™ÿö´šÿõ´šÿõ´™ÿ÷´šÿ÷´šÿö´šÿö´šÿö´šÿ÷´šÿ÷´šÿö´šÿì¨ÿë¥ÿó¯–ÿö³›ÿ÷´šÿö´šÿö´šÿö´šÿõ´šÿö´™ÿ÷´˜ÿ÷´™ÿ÷´˜ÿó²•ÿ»€kÿ´|hÿ·”wÿ“›rÿ¢vÿ¢vÿ“¥zÿ“£{ÿ“¤|ÿ‘¡zÿŸyÿwÿ‹wÿ‹vÿ‰™tÿt|WÿsvMÿvwMÿyzMÿvwOÿTU?ÿ€†oÿŠšsÿŠœrÿŠšrÿžvÿw}XÿvuSÿ“‘sÿtvfÿjˆÿgˆ•ÿ¡¹·ÿñöôÿõõõÿõõõÿöööÿõõõÿ\ÉÑ«ÿ\ÆÏ¤ÿ\ÅÍ¢ÿ\ÃË¡ÿ\ÂË ÿ¿ÉœÿÁÈÿÁÇœÿ½Å™ÿºÃ™ÿ¸Â—ÿ³¿”ÿ¶Â—ÿ·Â–ÿ·Ã—ÿ¶Ã—ÿ¸Â˜ÿºÃ™ÿ½Æ›ÿ¿Æ›ÿÀÆ›ÿ¿Åšÿ½Ä™ÿ¡¥ÿ”pÿ“rÿ~€jÿ¡©‰ÿ¬¹Œÿ«¹ÿ¬ºŒÿ­»ÿ«ºŽÿ­¼ÿª»ÿž›tÿà®—ÿ·wfÿÄqÿØ˜…ÿö´šÿ÷´™ÿ÷´šÿõ´™ÿ÷´›ÿ÷´šÿ÷´›ÿö´›ÿö´›ÿø´™ÿö´˜ÿõ´˜ÿøµ™ÿ÷´™ÿö´šÿõ´šÿõ´˜ÿ÷´šÿö´šÿö´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿì«‘ÿì«“ÿó³šÿôµšÿõ´šÿö´šÿ÷´™ÿ÷´™ÿ÷´˜ÿá¡†ÿ¯y`ÿÎ™zÿ®Žrÿ”žtÿŽ¡tÿ£vÿ’£xÿ•£{ÿ”£|ÿ yÿŸyÿ‹œwÿ‹œvÿ‹wÿŠšuÿs|WÿtvNÿwxNÿyzMÿyyRÿTT>ÿ…mÿ‰™rÿ‰›qÿŠšqÿŽtÿv|WÿuwTÿ“‘rÿtvfÿjˆÿhˆ•ÿ¡¹·ÿñöôÿõõõÿõõõÿöööÿöööÿ\ÈÐªÿ\ÅÍ¥ÿ\ÃÍ¡ÿ\ÃÌ ÿ\ÂËŸÿÀÉÿ¿ÅšÿÀÇœÿ¼Å™ÿºÃ˜ÿ·Â—ÿ¶Â˜ÿ¸Â˜ÿ´Â–ÿ¶Ã˜ÿ·Ä™ÿ¹Â™ÿ»Äšÿ¾Åšÿ½Äœÿ¾Å›ÿ¾Åšÿ»Ã™ÿ ¦~ÿ•qÿ’qÿ~‚kÿž¦‰ÿ©·Œÿ«¹‹ÿ¬ºŒÿ¬ºŒÿ¬ºŒÿ­»Žÿª»‹ÿ¨¬„ÿÄž†ÿ±taÿÃ€nÿÔ˜}ÿôµ˜ÿö´™ÿö´šÿ÷´šÿ÷´™ÿ÷´™ÿö´šÿò±œÿà ‰ÿõ´šÿõ´™ÿõ´šÿø´šÿ÷´šÿö´šÿ÷´šÿõ´›ÿ÷´šÿö´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿö´™ÿõ´šÿö´™ÿ÷´šÿ÷´šÿ÷´šÿé©ÿÕš‚ÿÏ•}ÿÍ’zÿØ›‚ÿð±—ÿõµ™ÿõ´™ÿé§ÿä¢ŒÿÓ—ÿñ´ÿœˆfÿ“¡vÿ¡wÿ‘¢wÿ’£xÿ”¢{ÿ”¡{ÿ¡yÿŸxÿ‹žwÿ‰œvÿ‰œvÿŠštÿr{VÿtuMÿwwNÿz{NÿyyQÿSU=ÿ}†mÿˆ˜sÿ‰šsÿ‹šsÿžuÿuzUÿwwSÿ‘pÿrtgÿh‰ÿg‡–ÿ ¹·ÿñõôÿõõöÿõõõÿöööÿõõõÿ\ÇÏªÿ\ÅÎ¥ÿ\ÄÍ¢ÿ\ÃË ÿ\ÃÊŸÿÁÉžÿ¿Æ›ÿÀÇœÿ¼ÅšÿºÃ™ÿ¸Â˜ÿ·Ã˜ÿ¸Â˜ÿ¶Â˜ÿ·Ä™ÿ·Ã™ÿ¹Â™ÿ»Äšÿ¾Å›ÿ¾Åœÿ¾Åšÿ½Å›ÿ»Ãšÿ ¦~ÿ‘•rÿ’qÿ€„lÿž¦ˆÿ©¸ÿ«¹‹ÿ¬ºŒÿ®¼ÿ¬ºŒÿ¬ºŒÿ«½Œÿ®ºÿ¶šyÿ³yfÿÔŽ~ÿµv^ÿó±•ÿ÷´™ÿ÷´šÿ÷´šÿõ´™ÿô³˜ÿØ›ÿÅ‹rÿâ¦Œÿõ´šÿõ´™ÿõ´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´›ÿ÷´›ÿö´›ÿö´šÿ÷´™ÿ÷´˜ÿ÷´˜ÿö´˜ÿõ´™ÿ÷´˜ÿ÷´šÿ÷´šÿö´šÿö´™ÿö³›ÿö³›ÿö´›ÿë¬’ÿÔ™}ÿÙ›€ÿò²˜ÿÙ˜ƒÿô²šÿô³šÿà®ÿŠbÿ‘ uÿ wÿŽŸvÿ’¢zÿ“¡zÿ”¡{ÿ‘¢zÿŒžxÿ‰wÿ‰vÿ‹žwÿ‹šuÿs}VÿtuLÿxxNÿz{NÿxxOÿSU>ÿ}†mÿ‡˜sÿˆ™qÿŠ™qÿžuÿv{VÿwwSÿŽpÿstfÿh‰ÿgˆ—ÿ ¸¶ÿñöôÿõööÿõõõÿõõõÿöööÿ\ÇÎ¨ÿ\ÅÏ¦ÿ\ÅÎ¥ÿ\ÃË¢ÿ\ÃÊ¡ÿÁÈÿ¿Æ›ÿÀÈÿ»Ä™ÿ¸Â˜ÿ·Á—ÿ·Ã˜ÿ¹Ã˜ÿ·Â—ÿ¹Â™ÿºÃ™ÿ¹Â˜ÿºÃ™ÿ¿Æžÿ¾Åœÿ½Äšÿ»Â™ÿ»Ãšÿ §~ÿ”qÿ’qÿƒlÿ¥‡ÿ©¸Œÿ¬»‹ÿ®¼Žÿ°¾‘ÿ­ºÿ®ºÿ­»Œÿ­º‹ÿª—sÿ×š†ÿ\ÇnÿÍ‰qÿÎŒqÿöµ™ÿ÷´™ÿö´šÿé«’ÿÈŒrÿã§ÿô´šÿõ´˜ÿõ´™ÿö´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿ÷´šÿ÷´šÿ÷¶žÿø½¢ÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿõ´˜ÿ÷´™ÿ÷´šÿö´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿë­”ÿÎ“{ÿÅ‰sÿó³›ÿï±˜ÿ•aÿ”¢vÿ‘¢uÿ wÿŒžuÿ‘¡zÿ‘¢zÿ’£{ÿ‘£{ÿ‹žwÿˆwÿŠœvÿ‹žwÿŒvÿt~WÿwxMÿxyNÿyzMÿxxQÿTV?ÿ}…nÿ‡˜sÿ‡™pÿ‰™qÿ‘žwÿv{VÿyyUÿŽoÿttfÿk‚‹ÿhˆ˜ÿ ¸¶ÿðöôÿõõöÿõõõÿöööÿöööÿ\ÉÐªÿ\ÈÐ¨ÿ\ÆÍ¤ÿ\ÃÊ¡ÿ\ÂÊŸÿÀÇÿ¾Åšÿ¿Ç›ÿ¼Å™ÿ¸Â˜ÿ¶Á˜ÿ¶Ã˜ÿ¸Ã—ÿ¶Á—ÿ¹Âšÿ»Äœÿ»Â™ÿ¼ÄšÿÀÆŸÿ½Ä›ÿ½Ä›ÿºÂ˜ÿ»Ã™ÿ¡§ÿ“pÿŽ‘qÿ€ƒkÿž¥‰ÿ©·Œÿ¬º‹ÿ­»ÿ­»ÿ®»ÿ°¼ÿ±¾ÿ°¼Žÿ¤uÿè´—ÿ½mÿÌ‰vÿÔzÿâ¢ˆÿõ´šÿå¥ŽÿÐ•|ÿð²šÿõ³›ÿ÷´šÿö´˜ÿ÷´™ÿö´™ÿ÷´™ÿö´šÿö´šÿö´™ÿ÷´™ÿö´šÿ÷ÂªÿôÄ¨ÿ÷´šÿö´›ÿö´šÿö´šÿö´šÿõ´˜ÿ÷´™ÿ÷´šÿö´šÿõ´šÿö´™ÿë«‘ÿó³šÿõ´›ÿõ´™ÿö´™ÿõ´›ÿæ©’ÿÆŒwÿî²šÿŸƒdÿ’›vÿ‘£xÿ¢vÿŽžuÿŒœuÿ‘¡zÿ‘¢yÿ“¤|ÿ‘¡{ÿŸxÿŠžwÿŠžwÿ‹wÿŒœvÿt}VÿxyOÿxyNÿyzMÿxxQÿTU?ÿ|†mÿˆ˜sÿ‰™qÿŠšsÿvÿtyUÿzzTÿ’‘qÿttgÿj‚‰ÿf‡”ÿ£¹·ÿñõôÿõõõÿõõõÿöööÿõõõÿ\ÈÐªÿ\ÇÎ¨ÿ\ÈÏ§ÿ\ÅÍ£ÿ\ÃÊŸÿÀÆžÿ¾Åšÿ½Æšÿ¼Å™ÿ¹Â˜ÿ·Â˜ÿ¶Â—ÿµÃ—ÿ¶Â˜ÿ¹ÂšÿºÃœÿ¼Ãœÿ½Ä›ÿÀÇžÿ½Ä›ÿ¼Ãšÿ¸Á™ÿ¹Â™ÿ¢¨‚ÿ‘•rÿ‘oÿƒjÿŸ¦‰ÿ¬ºÿ¬ºŒÿ¬ºŒÿ¬ºÿ­»ÿ®»ÿ®»ÿ­¹ÿ­¬„ÿÖ¨‰ÿð±“ÿµxdÿÑzÿÄ„pÿì¬’ÿä£Šÿôµšÿö´›ÿö´›ÿ÷´šÿ÷´˜ÿ÷´˜ÿõ´˜ÿ÷´˜ÿõ´šÿõ´šÿ÷µ™ÿ÷´˜ÿõ´šÿöÃ¨ÿ÷Â¦ÿö´šÿõ´šÿõ´šÿõ´šÿõ´šÿõ´˜ÿö´šÿ÷´šÿö´šÿõ´šÿõ´˜ÿæ©ÿÇ‹rÿã¥Œÿô¶™ÿõ´™ÿö´™ÿ×™~ÿ’cHÿ•^ÿ“vÿ¡yÿ xÿ wÿ¡wÿ‘¡yÿ‘¡zÿ‘¢zÿ”¥|ÿ’¢|ÿŸyÿŠžwÿ‹žwÿŒwÿ‹œvÿt{VÿxyPÿxyNÿxyMÿxxRÿTU?ÿ|†mÿ‰™sÿˆ˜qÿ‰šrÿŽœuÿtyUÿzzRÿ“’qÿutgÿiˆÿe‡’ÿ¥º·ÿñõôÿõõõÿõõõÿöööÿöööÿ\ÉÐ«ÿ\ÉÐ©ÿ\ÉÐ§ÿ\ÅÍ£ÿ\ÂÊžÿÀÆ›ÿ¾Äšÿ¾Å›ÿ¼Å™ÿ¹Â™ÿ¶Â˜ÿµÂ—ÿ´Â—ÿµÂ–ÿ·Á™ÿ¹Á›ÿ¼Äÿ½Äœÿ¾Åžÿ¼ÃšÿºÁšÿ¸À›ÿ¶¾—ÿ¡§‚ÿ’–sÿ‘pÿƒlÿ¤ˆÿ©·Žÿª¸‹ÿ¬ºŒÿ®¼ÿ®¼‘ÿª¸Œÿ«¹Œÿ®¼ÿ³¹ÿ¹™xÿô´—ÿî°”ÿÝœ†ÿÅ†sÿëª”ÿ÷´šÿõ´šÿö´šÿö´šÿ÷´›ÿæ¨ÿõ´šÿõ´šÿö´šÿö´šÿö´šÿõ´™ÿö´˜ÿõ´™ÿô²™ÿö´œÿø´œÿö²˜ÿõ²˜ÿö´šÿõ´™ÿõ´šÿõ´šÿö´šÿö´šÿ÷´™ÿ÷´˜ÿõ´šÿôµšÿÛŸ„ÿÑ—|ÿò³˜ÿõ³™ÿ¾ƒaÿ•q@ÿš›sÿ’£zÿ£xÿ‘¡xÿ wÿ‘¢wÿ’£{ÿ’¢{ÿ’¢zÿ”¦|ÿ’¢|ÿŸyÿŒžwÿ‹œvÿ‹›vÿ‹œvÿs|VÿvxOÿxxNÿxyLÿxyQÿTU?ÿ}†mÿ‰šsÿˆ™qÿŠšsÿŽœuÿtyVÿ{{Tÿ“’pÿtrfÿhˆÿe‡’ÿ¦º·ÿðöôÿõõõÿõõõÿöööÿõõõÿ\ÊÐ«ÿ\ÉÐ©ÿ\ÈÐ§ÿ\ÇÎ¤ÿ\ÂÉžÿÀÇœÿ¾Ä™ÿ¾Æ›ÿ»Ä˜ÿ¸Â˜ÿµÁ˜ÿµÂ—ÿµÂ—ÿ¶Â˜ÿ¹ÂšÿºÂÿ½Åÿ¾Åÿ½Äÿ¼ÃšÿºÂ™ÿ¸Ášÿ³¼”ÿ¢¨‚ÿ“—tÿ‘“tÿƒlÿ›£‡ÿ¨¶ÿ«¹‹ÿ­»Žÿ®¼ÿ­»ÿ«¸ÿ­ºÿ±»ÿ±½ÿ¤¢xÿ×ªÿò´™ÿõ´šÿÓ–ÿÕ•ÿö´™ÿõ´šÿõ´šÿõµšÿÕ—|ÿÙÿöµ›ÿõ´šÿõ´šÿö´šÿ÷´šÿõ´™ÿõ´˜ÿé§ÿÑ‹wÿ\à•‚ÿå›‡ÿÒ‰vÿË…qÿî©‘ÿõ´šÿõ´šÿõ´šÿö´šÿõ´šÿö´™ÿõ´˜ÿõ´šÿö´šÿô´šÿê«“ÿÊuÿê©’ÿ¯sNÿ›|;ÿ™¢uÿ’¤zÿ£yÿ’¢zÿ’£xÿ‘¢xÿ’¢{ÿ’¢|ÿ“¤|ÿ”¥|ÿ’¢|ÿŸxÿŒœwÿŠœvÿŒœwÿŒœwÿr|VÿvxPÿwwNÿyzMÿyySÿTU?ÿ~†mÿŠštÿ‰™rÿvÿvÿtyVÿ}}Vÿ•“rÿsrgÿgˆÿe‡’ÿ§»¸ÿðöôÿõõõÿõõõÿõõõÿõõõÿ\ÉÑ¬ÿ\ÈÏ©ÿ\ÆÏ¨ÿ\ÄË¥ÿÁÉŸÿÀÉžÿ¿Çšÿ¼ÇšÿºÃ™ÿ¸Á˜ÿ·Á—ÿ¶Ã˜ÿµÂ—ÿ·ÂšÿºÂÿ»Ãžÿ¼Åœÿ½Äœÿ¼Ã›ÿ»ÂšÿºÁšÿ´¼—ÿ°¸“ÿ §‚ÿ’—tÿ’–wÿ€ƒmÿ›£‡ÿ¨¶ÿª¸ÿ¬ºÿ­»Žÿ¬ºŒÿª¸Šÿ®»ÿ¯»ÿ³½’ÿ·À—ÿ££ÿ·•xÿï³›ÿë®•ÿ¸|eÿó²—ÿõ´˜ÿõ´˜ÿÕš|ÿÝ„ÿõ´šÿõ´šÿõ´šÿö´˜ÿ÷´™ÿ÷´˜ÿ÷´šÿ÷´šÿß›…ÿÁziÿÚ~ÿÛÿÓ‡xÿÓ‰vÿì§Žÿõ´šÿõ´šÿõ´šÿõ´šÿõ´šÿõ´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿõ´šÿð¯—ÿËtÿ¨sBÿ•z5ÿ–¢yÿ‘¡zÿ‘¡{ÿ xÿ‘¡yÿ yÿ‘¡zÿ’£{ÿ’¢zÿ’¢{ÿ‘¡|ÿŽŸyÿ‹œvÿ‹œwÿ‹wÿ‹›vÿt}ZÿuxRÿxyPÿxzMÿyyQÿST>ÿ~‡mÿŠštÿ‰™qÿ‹šsÿœuÿu{Uÿ}~Vÿ—–uÿsthÿg‰ÿd…ÿ¨½¹ÿñöôÿõõõÿõõõÿöööÿöööÿ\ÉÑ¬ÿ\ÉÏ«ÿ\ÆÍ¨ÿ\ÃË¥ÿÁÊ ÿÀÊŸÿ¾Æÿ»Å™ÿ»Äšÿ¹Âšÿ¶Á™ÿ¶Â™ÿ·Â™ÿ¹Ã›ÿ»Ãžÿ»ÃŸÿ¼Ãÿ½Äÿ¼Ãšÿ»Âšÿ¸À™ÿ´¼—ÿ³º•ÿ¢©„ÿ’—tÿ”—xÿ‚…oÿ¥‰ÿª¸Žÿ¬ºÿ­»ÿ¯½ÿ¬ºÿ©·‰ÿ®»ÿ°»Žÿ³¼’ÿ·À—ÿ¶À™ÿ­³ÿ›‰kÿ¿’vÿ™eFÿê§ÿ÷´šÿÖ™ÿ×€ÿõ´˜ÿõ´šÿõ´šÿõ´™ÿö´šÿö´˜ÿ÷´˜ÿö´šÿö´šÿò°—ÿÞ•‚ÿÜŽ~ÿÜŽÿÜÿæˆÿ÷³™ÿõ´šÿö´™ÿõ´šÿõ´šÿõ´šÿõ´šÿö´šÿ÷´šÿö´™ÿö´™ÿõ´™ÿö²›ÿÕ“{ÿ°{=ÿ•{6ÿ–¢xÿ‘¡zÿ yÿŸxÿ xÿŸxÿ xÿ’£{ÿ’¢{ÿ’¢|ÿ {ÿŽxÿŠvÿŠžwÿŠwÿŠœxÿt}ZÿtvPÿwxNÿxyMÿyyQÿTU>ÿˆmÿŒœuÿŠšrÿ‹šrÿœtÿv}Wÿ}}Vÿ—–uÿrtiÿhƒŠÿd„ÿ¨½¹ÿð÷ôÿõõõÿõõõÿöööÿõõõÿ\ÉÑ®ÿ\ÆÍ¨ÿ\ÆÌ§ÿ\ÃÌ¥ÿÁÊ¡ÿ¿Éžÿ½Æœÿ½Åšÿ¼Å›ÿ¸Ášÿ·Àšÿ·Àšÿ¹Âšÿ»Ãžÿ¼ÄŸÿ¼ÃŸÿ¼Ãžÿ½Äžÿ¼Ãÿ»Â™ÿ·¿—ÿ´¼—ÿµ½˜ÿ£ª…ÿ”™vÿ”˜yÿƒ†pÿž¥‰ÿ¬¹ÿ«¹ÿ¬ºÿ­»ÿ©·‹ÿ§´ˆÿ­ºŒÿ¬¹Œÿ²½’ÿ¶À—ÿµÀ˜ÿ±¿˜ÿ§±ŽÿŒq<ÿ§t3ÿØ–~ÿé¥ÿÎ’}ÿôµœÿ÷´šÿõ´šÿ÷´™ÿ÷´™ÿö´šÿö´šÿö´™ÿ÷´šÿ÷´šÿ÷´šÿõ°˜ÿäš†ÿÜ}ÿæ›†ÿ÷²—ÿ÷´˜ÿ÷´šÿ÷´˜ÿõ´šÿö´šÿ÷µ›ÿô²˜ÿõµšÿô´šÿÊrÿñ°—ÿõ´˜ÿðª‘ÿÀ~^ÿÀ‰?ÿ“<ÿ•¢zÿ‘¢|ÿ yÿŽŸwÿ‘¡zÿ yÿ‘¡zÿ’¢{ÿ’¢{ÿ’¢{ÿ {ÿŒžxÿŠžwÿŠžwÿ‹žwÿŒxÿt}ZÿuvPÿwxNÿyzMÿyzQÿTU>ÿˆmÿ‹œuÿ‹œrÿžuÿŽ›sÿu~Wÿ}~Vÿ—–tÿrvjÿh‚‰ÿcƒŽÿª¾»ÿð÷ôÿõõõÿõõõÿöööÿõõõÿ\ÈÐ­ÿ\ÆÎ©ÿ\ÆÎ©ÿ\ÄÍ¦ÿÁÊ¢ÿ¿Èžÿ¾Å›ÿ½Å›ÿ¼ÅœÿºÂœÿ¹Â›ÿºÂ›ÿºÃœÿ»Ãžÿ¼Ä ÿ½Ä ÿ¾ÄŸÿ½Ãžÿ½Ãžÿ¼Ãšÿ·¾—ÿ´¼—ÿµ½˜ÿ£©…ÿ•™wÿ–™yÿ„…pÿž£ˆÿ«¹ÿ¬ºÿ®¼ÿ¬ºŽÿ¨¶‹ÿ©µŠÿ®»ÿ¬¹ÿ®¼‘ÿ´Á–ÿ´Á˜ÿ³À—ÿ°º”ÿ–‚DÿÁŠ9ÿ¿~Zÿ\à…ÿõµœÿö´—ÿõ´—ÿê«ÿå¥Šÿö´™ÿ÷´™ÿõ´šÿö´šÿö´šÿõ´šÿö³œÿö´›ÿö³šÿò¯—ÿ÷³™ÿö´™ÿõ´™ÿõ´™ÿô´™ÿï¯–ÿÝž†ÿÆ‰pÿæ¦Œÿö´šÿö´™ÿï°”ÿÑ‘zÿô³šÿã†ÿ³rIÿÌ•@ÿ“Fÿ•¤{ÿ’¢|ÿ‘¡{ÿ‘¡yÿ wÿŸwÿ‘¡yÿ’£|ÿ“£|ÿ’¢|ÿ‘¡{ÿŽŸxÿŒŸwÿŒŸxÿŸxÿŽxÿu|XÿttNÿvvNÿxyMÿyzQÿVU?ÿ‰nÿvÿ uÿ‘ŸuÿŽ›sÿv~Wÿ~}Vÿ—”uÿsuiÿiˆÿg†Žÿ°Â¿ÿòöôÿöôöÿõõõÿöööÿõõõÿ\ÇÏ­ÿ\ÇÏªÿ\ÆÎ©ÿ\ÃÌ¤ÿÁÊ¢ÿ\ÂÉ ÿ¿Æžÿ¾Æÿ¾Çœÿ¼ÅÿºÃ›ÿºÃÿ»Äžÿ½Å ÿ¼ÄŸÿ¼ÄŸÿ½ÄŸÿ¼Âÿ¼Âÿ½Ã›ÿ·¾—ÿ³»–ÿµ¾—ÿ£¨„ÿ–™xÿ˜›zÿ……pÿŸ£ˆÿ¬¸Žÿ¬ºŒÿ®¼‘ÿ¨¶‹ÿ¤²‡ÿ«¶‹ÿ®»ÿ«¸ÿ®½‘ÿ³À”ÿ³¿—ÿ´À—ÿ±½˜ÿ—ŽZÿÆ•;ÿ³v9ÿáž†ÿ÷³›ÿ÷´˜ÿô³™ÿÏ‘yÿô³™ÿö´™ÿ÷´šÿöµ›ÿô¶›ÿòµ›ÿï²™ÿçª’ÿÚœ…ÿÍ”zÿÇvÿÇuÿÉ‘wÿË“yÿÊvÿÇŒsÿËyÿÚ ˆÿï²šÿõ´šÿ÷´šÿ÷´˜ÿõ´˜ÿé«‘ÿÐ’yÿÓzÿµw;ÿÈ”8ÿ„Lÿ”¤|ÿ“£|ÿ’¢zÿ xÿ‘¢xÿ‘¡yÿ’¢{ÿ’£|ÿ”¥}ÿ“£|ÿ’¢{ÿ xÿŸwÿžxÿžyÿžyÿv|XÿuuNÿxxQÿvwLÿyyQÿUU>ÿ‚ŠoÿŽžvÿ¡uÿ“¡vÿ’žvÿyYÿ}|Uÿ—”vÿtuiÿiˆÿh‡ÿ´\Å\Âÿóöôÿöôöÿõõõÿõõõÿõõõÿ\ÉÑ®ÿ\ÇÐªÿ\ÆÎ¨ÿ\ÄË¥ÿ\ÂÊ£ÿ\ÂÉ¡ÿ¾Å›ÿ¾Æÿ¾Çÿ¼Åœÿ½Äÿ¾Ä ÿ¾Ä ÿ¾Ä ÿ¼ÄŸÿ¼ÃŸÿ½Ãžÿ»Âœÿ»Âÿ¼Ã›ÿ·¾–ÿ¶¼˜ÿ·¾˜ÿ¤©„ÿ—šyÿš|ÿ……pÿ¡§‹ÿ¯»‘ÿ®»ÿ®¼‘ÿ§´‹ÿ¨µŠÿ®»ÿ¯¼‘ÿ¬»ÿ°½’ÿ±¾”ÿ²¾•ÿ³¼•ÿ°½—ÿ¢£vÿ·‹5ÿ¹0ÿÎ‹mÿñ®•ÿö´™ÿÚšÿè©ÿ÷´™ÿ÷´šÿõ³™ÿÑ“zÿÇuÿÌ’xÿÍ’yÿÔ˜ÿß¡‰ÿäª‘ÿë¯—ÿñ±šÿó²›ÿõ³›ÿö´œÿö´›ÿö´›ÿö´œÿö´šÿõ´˜ÿõ´˜ÿ÷´šÿö´™ÿõµ˜ÿÒ’|ÿ«pJÿÉŽ9ÿÀ2ÿŠTÿ˜¨~ÿ’£|ÿ’£{ÿ’¢{ÿ‘¢zÿ’£{ÿ“£{ÿ”¤|ÿ—¦~ÿ˜¥~ÿ•¢|ÿ‘ yÿ yÿŸzÿŸzÿžyÿu|WÿvvOÿxxQÿxxNÿzzRÿTT>ÿƒŠpÿŽžvÿ¡uÿ“¡vÿ“žvÿyYÿ|{Tÿ˜”wÿttiÿj‡ÿh‡ÿ¶\Ç\Äÿóöôÿöôöÿõõõÿõõõÿõõõÿ\ËÓ°ÿ\ÈÐ¬ÿ\ÅÍ¨ÿ\ÄË¦ÿ\ÂÊ£ÿ\ÄË£ÿÀÆÿ¿Æÿ¿Èÿ¿ÈžÿÀÆ ÿÀÅ¡ÿÀÅ¡ÿ¿Ä ÿ¼ÃŸÿ¼ÄŸÿ¾Ä ÿ½Äžÿ½Ãÿ½Ãšÿ¸¿˜ÿ¸¾™ÿ¸¾—ÿ¥ª…ÿ—šyÿšœ|ÿ††pÿ£©ÿ°¼’ÿ®¼‘ÿ­»ÿ¨¶‹ÿ­ºÿ°½’ÿ±¾’ÿ®ºÿ¯½’ÿ³À–ÿ³¿•ÿµ¾—ÿ²¿˜ÿ®µŒÿ¡~7ÿÌ“6ÿ±sDÿåœˆÿô²™ÿÛœÿö´™ÿ÷´šÿ÷´šÿö´šÿô´œÿôµÿôµ™ÿõµ™ÿõ´™ÿö´™ÿ÷´™ÿ÷´™ÿø´™ÿø´™ÿö´›ÿö´›ÿö´šÿ÷´šÿö´›ÿö´šÿõ´˜ÿõ´˜ÿö´™ÿ÷´™ÿñ¬’ÿÒŒtÿºz7ÿÒ•2ÿµ‡/ÿ——cÿ™¨€ÿ“£|ÿ’¢{ÿ‘¡zÿ’£zÿ’¢zÿ”£|ÿ—¥}ÿ˜§ÿ™¦ÿ•¡|ÿ‘ zÿ‘¡{ÿ‘¡|ÿŸzÿ‘Ÿzÿv}XÿvwPÿxxQÿyyNÿz{RÿUV?ÿ‚‰nÿuÿ‘¢vÿ•¢wÿ“Ÿvÿz€Zÿ|{Tÿ—”vÿrshÿi‡ÿh‡’ÿµ\Æ\Äÿóöôÿöôõÿõööÿõööÿõõõÿ\ÌÔ±ÿ\ÊÒ®ÿ\ÇÏªÿ\ÄÌ§ÿ\ÄË¥ÿ\ÃÊ¢ÿ¾ÅÿÁÈŸÿ\ÂÉ ÿÁÈ¡ÿ\ÂÈ¥ÿ\ÃÈ¥ÿÀÅ¤ÿÀÅ¢ÿ½Ä ÿ¿Ä¡ÿ¾Ä ÿ¼Âžÿ¼Ãÿ¼ÃšÿºÁšÿ¹À™ÿ¹À˜ÿ¥ª†ÿ™›{ÿœœ~ÿˆ‡pÿ¢¨Œÿ°¼“ÿ®¼‘ÿ®¼‘ÿ¯½’ÿ±¾’ÿ°½‘ÿ¯¼ÿ®º‘ÿ¯»“ÿµ¿•ÿ¶À–ÿµ¾–ÿ±½•ÿ®¹’ÿ”GÿÍ–5ÿ³{*ÿÌˆkÿ\àœ…ÿñ°—ÿ÷´šÿø´šÿ÷´šÿö´šÿ÷´šÿ÷´šÿø´šÿ÷´šÿ÷´šÿ÷´šÿø´šÿ÷´šÿö´šÿø´™ÿ÷´™ÿõ´šÿ÷´šÿõ´™ÿö´šÿø´šÿ÷´šÿ÷´šÿõ´˜ÿõ²—ÿß™ÿ²nGÿÎ5ÿÑ•.ÿ©‚.ÿ™¡pÿ™¦ÿ–£~ÿ’¡zÿ’¢{ÿ”¤|ÿ•¥|ÿ”¤|ÿ–¤}ÿ˜¥~ÿ˜¥~ÿ•¢}ÿ‘¡|ÿ’¢|ÿ’¡|ÿ‘ |ÿ‘žzÿu}XÿvwPÿwwNÿxyLÿzzQÿTU>ÿˆnÿŽœuÿ’ uÿ’¡vÿ’Ÿtÿ{€Yÿ|zTÿ–”xÿstgÿi‰ÿh‡“ÿ´\Æ\Äÿòöòÿõöôÿõõõÿõõõÿõõõÿ\ÌÕ³ÿ\ÊÒ¯ÿ\ÉÐ¬ÿ\ÅÍ¨ÿ\ÃÊ£ÿÁÊ¢ÿÁÇŸÿ\ÂÉ ÿ\ÃÊ£ÿ\ÃÈ¥ÿ\ÃÉ§ÿ\ÃÉ¨ÿÁÈ¥ÿ¿Å¡ÿ¾Ä¢ÿ¿Ä¡ÿ¿Ä ÿ¾Ä ÿ½Ãžÿ¼ÃÿºÀšÿ·¾˜ÿ¸À™ÿ¥ª†ÿ™œ|ÿœÿˆ‡pÿŸ¦Šÿ°¼“ÿ­»ÿ®¼‘ÿ¯½“ÿ°½“ÿ¯¼’ÿ°¼‘ÿ®»‘ÿ³½“ÿ¶¿•ÿ¶¿–ÿµ½–ÿ°¼•ÿ­·‘ÿ”Œ[ÿÆ“;ÿÍ“0ÿ©p1ÿÚ”|ÿõ°—ÿ÷´šÿ÷´šÿ÷´šÿö´šÿ÷´šÿ÷´šÿö´šÿ÷´šÿö´šÿö´šÿ÷´šÿö´šÿõ´šÿö´™ÿö´™ÿõ´šÿö´šÿõ´™ÿõ´™ÿö´™ÿö´šÿö´™ÿö´™ÿæ¡‰ÿÆfÿºz5ÿÌ1ÿ·#ÿ™v-ÿŒ’lÿ™¥€ÿ˜¥ÿ“£|ÿ”¤|ÿ—¤|ÿ–¦|ÿ–§|ÿ˜¦~ÿš§€ÿ™¦ÿ–¤}ÿ“£|ÿ’£|ÿ’¢}ÿ {ÿžyÿu|WÿttNÿxxOÿxyMÿzzQÿTU=ÿ‡mÿŽœuÿ uÿ‘ uÿ“¡vÿ|‚Yÿ{zSÿ—•yÿtvhÿiˆÿh‡“ÿ¶\Ç\Åÿòöòÿõöôÿõõõÿöõöÿõõõÿ\ÍÕ´ÿ\ÊÒ¯ÿ\ÉÐ­ÿ\ÅÍªÿ\ÃÊ¦ÿÁÊ¢ÿÀÇžÿ\ÃÊ¢ÿ\ÆÌ¨ÿ\ÅË©ÿ\ÄÊ¨ÿ\ÃÉ©ÿ¿Ç¡ÿ¾Ä ÿ¾Ä ÿ¾Ä ÿ¾Ä ÿ¾Ä ÿ»À›ÿ»Âœÿ¹Àšÿµ½—ÿ·¿˜ÿ¥«‡ÿš|ÿ›~ÿ‡†oÿŸ¥Šÿ±½”ÿ²¾“ÿ°½’ÿ±¾”ÿ®¼’ÿ°½’ÿ±¼’ÿ¯¼‘ÿ³½“ÿ¶¿•ÿµ¿—ÿ³¿˜ÿ±¼–ÿ¬¸’ÿ¢¥|ÿ¯…:ÿÑ•0ÿ¾†)ÿ°qGÿ\à˜‡ÿõ±˜ÿ÷´šÿ÷´šÿ÷´šÿö´šÿö´šÿö´šÿ÷´šÿö´šÿ÷´šÿ÷´šÿö´šÿõ´šÿõ´šÿõ´šÿõ´™ÿ÷´šÿõ´šÿö´™ÿ÷´šÿõ´šÿ÷´™ÿîªÿÕwÿ¯n;ÿÐ’6ÿ·ƒ-ÿ”h(ÿ›|;ÿ·´“ÿ‚ˆhÿ”¢|ÿ•¥ÿ–£|ÿ—¥}ÿ•¦|ÿ•§|ÿ™¨ÿ˜§€ÿ™§€ÿ˜§ÿ–¦~ÿ“¤|ÿ’£}ÿ‘¡|ÿ‘žzÿtzVÿssNÿxxPÿxyMÿzzRÿUU<ÿ~‡lÿŽœuÿ tÿ‘Ÿtÿ“¢wÿ~„Zÿ|{Sÿ˜•zÿsugÿh‡ÿg†“ÿ¶\Ç\Åÿóöòÿõöôÿõõõÿöööÿõõõÿ\ÌÕ´ÿ\ÊÒ¯ÿ\ÉÑ®ÿ\ÅÍªÿ\ÃÊ¦ÿ\ÃÊ¤ÿ\ÂÉ¢ÿ\ÄË¥ÿ\ÇÌ«ÿ\ÅË«ÿ\ÃÉ©ÿ\ÂÇ¦ÿÀÆ¡ÿ¾Å¡ÿ¾Å¢ÿ¾Ä ÿ¾Ä ÿ½ÃŸÿ»Áœÿ½Ãÿ»Á›ÿ¶½—ÿ·À—ÿ¦¬‡ÿ›ž}ÿœž~ÿ‰‡rÿ¡¥‹ÿ±»”ÿ®¼‘ÿ°½’ÿ¯¼‘ÿ±½’ÿ¯¼‘ÿ®¼‘ÿ­»ÿ±½’ÿµ¿•ÿ·À˜ÿ¶¾˜ÿ´¼–ÿ¬·“ÿ¢‚ÿn9ÿÐ”5ÿÒ–.ÿ·|)ÿ¿}]ÿÞš…ÿ÷¯™ÿø³šÿö´™ÿõ´šÿö´šÿö´šÿö´šÿö´šÿö´šÿö´šÿõ´šÿõ´šÿö´šÿö´šÿö´šÿõ´™ÿö´šÿö´™ÿ÷´šÿö´›ÿó®–ÿÚ”ÿ²pGÿËŠ5ÿÒ•/ÿ¥{/ÿœIÿ¨‹Vÿ\ÓÉ«ÿ¼·›ÿ§ªÿ™|ÿ—¥}ÿ˜¥}ÿ˜¥|ÿ—§~ÿ˜¨€ÿ™¨€ÿ›¨ÿš¨ÿ—§~ÿ”¥}ÿ“£|ÿ‘¡|ÿ‘Ÿzÿu{XÿstNÿxxPÿxyNÿzzRÿUU=ÿ‡lÿŒœtÿŽ tÿ tÿ“¡wÿz€Wÿ|{Sÿ—•xÿruhÿg…ÿe‡‘ÿ´\Ç\Äÿóöóÿöõôÿõõõÿõõõÿöööÿ\ÎÕ·ÿ\ËÒ³ÿ\ÊÒ°ÿ\ÆÎ«ÿ\ÃË§ÿ\ÄÊ§ÿ\ÄÊ¦ÿ\ÆÌ©ÿ\ÈÍ®ÿ\ÆÌ­ÿ\ÄÊªÿ\ÂÈ§ÿ\ÂÈ¤ÿ½Å ÿ»Ã ÿ½ÃŸÿ¿Ä ÿ½ÃŸÿ½ÃŸÿ¾Ãžÿ¼Áœÿ¶½—ÿ·Á—ÿ§¬ˆÿšž}ÿ›ž~ÿŠ‡sÿ£¦Œÿ±º”ÿ­»ÿ²½’ÿ±½’ÿ°¼“ÿ®»’ÿ­»ÿ¬ºÿ±¾“ÿµ¿•ÿµ¾—ÿ´¾—ÿ²º•ÿˆoÿ ¡…ÿ›‚TÿÉ“8ÿÑ”+ÿÑ•1ÿ·{1ÿ¼zWÿá—ƒÿô®—ÿö´˜ÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿõ´šÿõ´šÿõ´šÿ÷´šÿö´šÿö´šÿö´šÿö´™ÿ÷´šÿö´™ÿ÷´™ÿô±˜ÿÞ—ƒÿ·v^ÿ·|9ÿÓ”0ÿÑ•2ÿ©‰Nÿž`ÿª–kÿ\ÑÈ¨ÿ\ÙÔºÿó\ï\èÿ\Ê\Í\Âÿ˜£ˆÿ—¤|ÿš¨~ÿ˜©ÿ˜©€ÿœªÿ«€ÿœª€ÿ™§ÿ”¥}ÿ“£}ÿ’¢}ÿ’ |ÿu|XÿstNÿyyQÿwxOÿzzRÿUU=ÿ‡lÿŠ›rÿŸsÿŽŸsÿ”¢xÿzXÿ}{Tÿ—•wÿrtiÿf€†ÿd†ÿ³\Æ\Ãÿóöôÿöõõÿõõõÿõõõÿõõõÿ\Ð×¼ÿ\ÎÕ·ÿ\ÊÒ±ÿ\ÆÎ«ÿ\ÄÌªÿ\ÇÍªÿ\ÇÌªÿ\ÉÍ¬ÿ\ÇÊ¯ÿ\ÅÊ­ÿ\ÅÊ¬ÿ\ÄÊ¨ÿ\ÂÈ¤ÿÀÆ¢ÿ¿Å£ÿÀÅ¢ÿ¿Å¡ÿ½ÃŸÿ¼Áÿ¾ÂŸÿ»Àÿ·½˜ÿ¶¿˜ÿ¨­‹ÿ›Ÿ~ÿ›ž}ÿŠˆsÿ£¦ÿ±»“ÿ°½’ÿ°½‘ÿ±¾’ÿ°½‘ÿ®¼’ÿ­»’ÿ¬º‘ÿ®º’ÿ´¿—ÿ¶À—ÿ²¾˜ÿ—xÿ¨¨˜ÿ\ÑÍµÿÂ³‘ÿ¯ƒ>ÿ±z#ÿÒ•/ÿÒ–1ÿ¸|-ÿµsRÿÛ–€ÿò«”ÿ÷´™ÿ÷´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿõ´šÿõ´šÿ÷´šÿ÷´šÿ÷´˜ÿ÷´˜ÿõ´™ÿõ´šÿö´šÿ÷²™ÿå†ÿÊwÿ‡N5ÿÅ<ÿÓ•-ÿÆ/ÿ´ŸoÿŸ’oÿ©œzÿ°«Œÿ\ä\â\Ïÿ\î\í\éÿ\ìñ\ìÿ\å\ì\âÿ‹“|ÿ“}ÿ™§ÿ¬‚ÿ¬ƒÿœ¨‚ÿ›¨‚ÿ›¨ÿ”¥}ÿ“¤~ÿ“£~ÿ”¡}ÿu|XÿttNÿyyRÿvvMÿzzRÿUU?ÿ€ˆnÿŠ›tÿŽŸuÿ vÿ“¡vÿ{‚Yÿ}|Sÿ—•wÿrthÿh‚…ÿe‡ÿ²\Æ\Âÿóöôÿöôõÿöõõÿöööÿõõõÿ\ÑØ¾ÿ\Ð×»ÿ\ËÓ³ÿ\ÈÐ®ÿ\ÄËªÿ\ÉÎ­ÿ\ÈÍ¬ÿ\ÉÍ®ÿ\ÇÊ±ÿ\ÄÉ®ÿ\ÄÊ«ÿ\ÂÈ¦ÿÁÇ£ÿ¿Å¡ÿ¿Ä£ÿ¿Å¢ÿ¿Å¡ÿ¼Âžÿ¼Âžÿ¾ÂŸÿ»Áÿ´º–ÿ¶¾™ÿª®ÿœ ÿœžÿ‹‰tÿ¡¤‹ÿ±»“ÿ®»ÿ®¼’ÿ®¼“ÿ°½’ÿ­»‘ÿ¯½”ÿ¬ºÿ¯»”ÿ±½—ÿªµ‘ÿ›¢Šÿ®°©ÿ\Ü\Ú\Õÿ\ß\Ù\Æÿ\ÕÉ®ÿTÿ‡_ ÿÐ–4ÿÓ–/ÿÐ–1ÿœd&ÿ§hTÿÙ’ÿð¨“ÿø³›ÿ÷´šÿ÷´šÿ÷´šÿõ´šÿö´šÿ÷´šÿ÷´šÿ÷´šÿ÷´™ÿ÷´™ÿö´šÿõ´™ÿö³šÿäž‰ÿÏ†sÿ¯l^ÿ¬rTÿÈŽ=ÿÒ—,ÿ¯.ÿÍ¼”ÿš‘wÿ¬£‡ÿª¥Šÿ\ã\Þ\Íÿº·®ÿ\ë\ï\éÿ\Ã\Å\Åÿ\ê\í\éÿ\È\Î\Âÿ‘›~ÿª„ÿž«„ÿ©ƒÿž«„ÿš¨ÿ—¦ÿ˜¨‚ÿ—¦€ÿ–¤}ÿv}YÿuuOÿyyQÿwxMÿ{{SÿUU?ÿ€ˆnÿ‹›tÿŸuÿ¡vÿ”¡vÿy€Xÿ|{Rÿ—•wÿsuhÿg…ÿd…ÿ±\Æ\Âÿòöôÿõõõÿõõõÿöööÿõõõÿ\Ô\Ú\Âÿ\ÑØ¼ÿ\ËÒ·ÿ\ÉÐ±ÿ\ÆÍ­ÿ\ÉÏ¯ÿ\ËÐ¯ÿ\ÊÍ°ÿ\ÅÊ²ÿ\ÃÈ­ÿ\ÂÈ©ÿÁÆ¥ÿ\ÂÈ¤ÿÁÇ£ÿÀÅ¡ÿÀÅ¢ÿÀÅ¡ÿ½ÃŸÿ½Â ÿ¿Â ÿ¼Ážÿµ»—ÿ·½™ÿ©­Œÿœ ‚ÿÿŠˆuÿŸ¡Šÿ¯»“ÿ®»ÿ¬ºÿ­»ÿ­»’ÿ¬º‘ÿ¬º‘ÿ¬ºÿ®»’ÿ¨‡ÿ\ÃË¹ÿ\æ\ç\áÿóóðÿ\ê\ë\ãÿ\ÔÐ¼ÿ\ÔË¯ÿ¨švÿ‹m>ÿÌ”;ÿ¾„%ÿÑ”1ÿµ{.ÿ´zcÿœ\\NÿÌˆwÿé¢Žÿ÷±›ÿ÷´šÿ÷´šÿõ´šÿ÷´šÿ÷´šÿ÷´šÿö´šÿö´šÿ÷´šÿ÷´šÿö³šÿç ‰ÿÏ‰xÿªgVÿÖ|ÿ¶vUÿÊ=ÿÏ–1ÿšw3ÿ\ÍÄ¢ÿ¼µ—ÿ¼µšÿ²¬ÿ\ÑË¯ÿ®¨Žÿ\Ö\Ö\Äÿ\Ï\Ò\Êÿñõòÿòõ\ïÿ\Ë\Ò\Åÿ“ŸÿªƒÿžªƒÿŸ­…ÿœ©‚ÿš¨€ÿ™§€ÿ˜¥~ÿ–£|ÿv}XÿuuMÿyyPÿwwNÿ{|SÿVV@ÿ€‰nÿŽœvÿžsÿ‘ tÿ–¢wÿz~Wÿ|{Rÿ—•vÿvuhÿg†ÿd…‘ÿ°\ÆÁÿñ÷ôÿõõõÿõõõÿõõõÿõõõÿ\Ö\Û\Äÿ\ÑØ¾ÿ\ÎÔ¹ÿ\ËÑ´ÿ\ÊÐ²ÿ\ËÑ²ÿ\ÏÓ´ÿ\ËÍ²ÿ\ÅÊ²ÿ\ÄÉ­ÿ\ÃÈ©ÿÁÆ¥ÿ\ÂÇ¤ÿÁÇ£ÿÀÅ£ÿ\ÂÇ¤ÿÀÅ¢ÿ¿ÃŸÿ¿Ã ÿÀÃ ÿ¼Áÿ·¾™ÿ¸¿™ÿ©­‹ÿ €ÿžž‚ÿŠ‰uÿ¢§ÿ¯»“ÿ¯¼‘ÿ­ºÿ®¼‘ÿ­»‘ÿ®¼“ÿ­»’ÿ«¸Žÿš¤†ÿ\ÅÍ¼ÿðöðÿóó\ïÿ\ï\î\åÿ±¯Ÿÿ³¯•ÿ\ÓÌ®ÿ\ÉÀ£ÿ‹dÿ¹Ž<ÿ“k ÿº†/ÿÀˆ4ÿ»}aÿÃtÿ›]Pÿ¼{lÿÞš‰ÿó­˜ÿø³šÿö´šÿ÷´šÿö´šÿõ´šÿö´›ÿö´›ÿö´›ÿ÷²šÿåžŠÿÐˆxÿ¢`RÿÌ‰xÿÙŽ|ÿ¹wWÿÁ‰8ÿÉ–4ÿ—zFÿ\ÉÁ¤ÿ\ÏÈ©ÿÃ»Ÿÿ¼´—ÿ\ÒË­ÿ¬¤ˆÿ²¬•ÿ\Ú\×\Êÿóô\ïÿòõñÿñôñÿ ¥”ÿ›¦ÿœ©ÿŸ¬ƒÿž¬‚ÿœª€ÿœ©‚ÿ˜¥~ÿ–£|ÿv}XÿvvOÿyyPÿwwNÿz{RÿVV@ÿ‚Špÿwÿ‘Ÿtÿ”¢uÿ–¢wÿ{Xÿ||Rÿ—•wÿtugÿg€…ÿd†’ÿ°\ÅÁÿñ÷ôÿõõõÿõõõÿöööÿõõõÿ\Ö\Û\Æÿ\Ô\Ú\Äÿ\ÑÖ¼ÿ\ÍÒ¶ÿ\ËÐµÿ\ÊÎ²ÿ\ÑÓ¹ÿ\ËÎ´ÿ\ÅÊ²ÿ\ÅÊ®ÿ\ÂÈ¨ÿ\ÂÈ¦ÿ\ÃÈ¥ÿ\ÂÇ¤ÿ\ÂÇ¦ÿ\ÂÈ¦ÿÀÅ¢ÿ¾Ã ÿ¿Ã ÿ¾ÂŸÿ¼Ážÿ¼Ãœÿ¼Ã›ÿª®‹ÿŸ¡ÿž‚ÿ‡ˆtÿ¡¦Žÿ²»”ÿ®º’ÿ¬¹‘ÿ®¼‘ÿ¯¼‘ÿ­ºÿ®»’ÿ¤ªÿ\ä\é\áÿñöñÿ\îð\éÿ\ê\è\Ûÿ\ÙÒ½ÿ·°™ÿ¨¡ˆÿ\ÔÌ°ÿ\ÕË¬ÿÇº›ÿ£Eÿ¦‹Wÿž‚PÿÇ‘?ÿ±rMÿÕ}ÿ¹xkÿ£eXÿ¨i\\ÿÔÿé¢Žÿö±™ÿö´›ÿö´šÿö´šÿö´™ÿ÷´™ÿõ°—ÿäš‡ÿËƒuÿ¢aTÿ¼znÿ×~ÿÙ|ÿºy]ÿa(ÿª>ÿˆxUÿ\ÇÀ¤ÿÇ¿¡ÿ¾µÿÂº ÿ\ÓË®ÿ®¦Šÿ¹²˜ÿ\ÖÒ½ÿ\î\í\ãÿñó\ïÿóôñÿ\í\î\êÿ’š„ÿŸ¬‚ÿ ®ƒÿŸ­ƒÿª‚ÿª‚ÿ™¦ÿ–£|ÿv}XÿuvPÿyxPÿwwNÿzzRÿVU@ÿ…sÿ’Ÿyÿ“¡uÿ–¢vÿ—£wÿ|€Yÿ|{Rÿ˜–wÿtugÿh€…ÿb„ÿ¯\ÄÀÿñøóÿõõõÿõõõÿöööÿõõõÿ\Ö\Û\Çÿ\Ô\Ú\Æÿ\Ñ×¿ÿ\ÏÕ¼ÿ\ÍÒºÿ\ÌÐ·ÿ\ÍÐ¶ÿ\ÉÌ³ÿ\ÅÊ±ÿ\ÃÈ­ÿ\ÂÈ¨ÿ\ÃÉ¨ÿ\ÄÊ¦ÿ\ÂÈ¦ÿÁÆ¥ÿÁÆ¥ÿ¾Ä¡ÿ¾Ã ÿÀÃ ÿÀÃ¡ÿ½Ážÿ¼Âÿ»Âšÿ©®‹ÿž¡ƒÿœŸƒÿ‡ˆsÿ¢§ÿ²»“ÿ­¸‘ÿ¬º‘ÿ­ºÿ®¼“ÿ¨¹‘ÿš¢ˆÿ\ã\æ\ßÿóôóÿôôñÿ\Ö\Ó\Äÿ\ÐÊ²ÿ\ÔÌ¯ÿ¹²—ÿ¤œ„ÿ\ÓË±ÿ\ÔÌ¯ÿº³“ÿœeÿ¦”kÿ¾¬‰ÿµ†Hÿ¯rGÿØ~ÿÎ‡{ÿ´sfÿ­oaÿ›^PÿÀ€qÿÝ–‡ÿë¡ÿð¦“ÿñ§“ÿð§“ÿé ÿÛ“„ÿ¹sgÿ›]Qÿ³sgÿÒŠ~ÿÚŽ~ÿÛÿ¸xfÿ¥iÿxe1ÿ‰}cÿÆ¾¦ÿ¼´˜ÿ½´ÿÃº ÿ\ÔË®ÿ²«ÿ\ÑÊ­ÿ\ÓÊ¯ÿ\ÎÊ³ÿ\Ë\Í\Ãÿòöðÿóôòÿº¾³ÿ «†ÿ¡®‚ÿŸ­‚ÿœ©€ÿ›¨‚ÿ—§ÿ•£|ÿu{VÿvvQÿzyPÿwvLÿ{{RÿWV?ÿ†Žqÿ“ xÿ“¡uÿ”¡uÿ–£vÿ~„Wÿ{|Qÿ—•wÿuvhÿh‚‡ÿb‚ÿ®\ÂÀÿòöôÿõõõÿõõõÿöööÿõõõÿ\×\Ý\Êÿ\Ö\Û\Éÿ\Ô\Ù\Æÿ\Ñ\ÖÁÿ\ÏÓ½ÿ\ËÏ·ÿ\ÈË²ÿ\ÇÊ²ÿ\ÆË²ÿ\ÄÉ­ÿ\ÃÈ¨ÿ\ÂÈ§ÿ\ÄÊ¦ÿ\ÂÈ¦ÿÁÆ¥ÿÁÆ¥ÿÀÅ£ÿ¿Ä ÿÁÄ¡ÿ¾Ã¢ÿ½Á ÿ¼Âžÿ¼Ã›ÿ©®Œÿ¡„ÿŸ„ÿˆˆsÿ£¨Žÿ°º“ÿ«¸‘ÿ¬¹‘ÿ®»ÿª¸ÿ›§‰ÿ\æ\ê\ãÿ\íð\ïÿ\ä\è\àÿ\ä\á\ÔÿÁ¹¡ÿÇ¼¡ÿ\ÔË®ÿµ­“ÿ ˜€ÿ\ÓÊ±ÿ\ÔÌ°ÿ½µ˜ÿº®”ÿ¡•~ÿ\ÔÊ­ÿ ƒYÿ§pOÿÙ}ÿÚ€ÿ\Æ~rÿ³rdÿ¯seÿœcTÿŸaVÿ¼wjÿ\ÆrÿÆ€qÿ\Ä}oÿ¹sfÿž^Tÿ¡f[ÿ±rgÿÇƒwÿÔ‰|ÿÛÿÚ~ÿ·|kÿË·›ÿ{kWÿ’ŒrÿÄ¼¢ÿ¶­“ÿÂ¸¡ÿÆ¾£ÿ\ÕÌ¯ÿ«£‰ÿ\ÕË°ÿ\×Ë¯ÿ¯§–ÿ\í\ì\èÿñôðÿóôñÿ\Ö\Ù\Òÿ˜¢ÿ¡¯ÿŸ­ƒÿœ©ÿ›¨‚ÿ™§€ÿ—£|ÿuzWÿwwRÿ{{QÿvvKÿ{{RÿWU?ÿˆrÿuÿ“¡tÿ•¢uÿ–¤vÿ…Wÿ{|Rÿ–•vÿtugÿh‡ÿc‚‘ÿ¯\Â\Âÿò÷ôÿõõõÿöööÿöööÿõõõÿ\Ø\Ü\Ëÿ\Ø\Û\Ëÿ\×\Ù\Êÿ\Ñ\Ô\Äÿ\Ï\ÒÀÿ\ÊÍºÿ\ÈËµÿ\ÇË³ÿ\ÅÊ±ÿ\ÅÊ­ÿ\ÄÊ«ÿ\ÃÉªÿ\ÅË©ÿ\ÄÊ©ÿÁÇ¦ÿÁÆ¥ÿÀÅ£ÿ¿Ä¡ÿÀÅ¢ÿ¾Ã¡ÿ½Â ÿ¼Áÿ»Âœÿª¯ÿž¡…ÿŸ†ÿ‰ˆtÿ£§ÿ°¹”ÿ­¹’ÿ®»’ÿ®»‘ÿ—£ƒÿ\â\æ\ßÿòõõÿñóòÿ²µ²ÿ\ÐÍµÿÆ¼ŸÿÂ¶œÿ\ÔË°ÿ¶¯–ÿ•}ÿ\ÒÉ±ÿ\ÓË¯ÿº²•ÿ\ÒÉ¬ÿ\ÐÄ¨ÿ\ÖË¯ÿ·¬‡ÿ„\\?ÿÙ~ÿÚ~ÿØŒ€ÿ½wiÿ±qdÿ®sdÿ­rfÿ¤h\\ÿžaUÿaWÿ dZÿ©laÿ¯qgÿ±qfÿ¿znÿÙŽ€ÿ\ÂwiÿÚŽÿÚŽÿ»mÿÏ¼¥ÿ¿¹Ÿÿ™yÿÂº ÿ°§ÿ¼³šÿÇ¿¤ÿ\ÔË±ÿ¦žƒÿ\ÕË±ÿ\ÑÈ®ÿ  •ÿ\à\â\ãÿòôôÿóôôÿ\ç\é\äÿ˜yÿ¢¯„ÿ ®ƒÿ«‚ÿœ¨‚ÿ™¦€ÿ˜£}ÿv{WÿwxQÿ|{QÿvwKÿ|zRÿWU?ÿ‡ŒpÿŽ›sÿ“¡vÿ•¢vÿ–£uÿ}„Uÿ{|Rÿ—–xÿttfÿj€ˆÿd„“ÿ¯\ÂÁÿòöôÿõõöÿõõõÿöööÿõõõÿ\Ö\Ù\Ìÿ\Ù\Û\Ðÿ\Õ\Ø\Ëÿ\Ò\Õ\Èÿ\Í\ÐÀÿ\ÉÌ¼ÿ\ÈË¶ÿ\ÆÊ³ÿ\ÄÉ°ÿ\ÅÊ¯ÿ\ÄÊ¬ÿ\ÄÊ¬ÿ\ÆÌ¬ÿ\ÄÊ«ÿ\ÂÈ¨ÿÁÆ§ÿ¿Ä¤ÿ¾Ã¢ÿÀÃ¢ÿÀÃ¢ÿ¾Â¡ÿ½ÂŸÿ»Áÿª¯Žÿž …ÿž ‡ÿ‹‰wÿ¡¥ÿ¯¸“ÿ­¹‘ÿ¬º‘ÿ®º“ÿœ¥ÿòôóÿóôõÿòôòÿ\È\ÈÁÿ\ÍÆªÿ\ÏÄ§ÿÀ¶›ÿ\ÕË°ÿº±˜ÿš’zÿ\ÒÉ°ÿ\ÓË¯ÿÀ¸›ÿ\ÒÊ®ÿ\ÕË±ÿ\ÖÌ±ÿ\ÒË®ÿ’r]ÿÙ€ÿÜÿÜÿÕŠzÿºugÿ³teÿ¯sfÿ±sfÿ²sfÿ²qeÿ²rfÿ³qfÿ´qeÿ½xkÿ×Œ~ÿÙŽ~ÿ¿veÿÚŽ~ÿÛŽÿ¿qÿÀª“ÿ\ÍÅªÿ›’{ÿÁ¹ ÿª¡ˆÿ´ª“ÿÇ¿¤ÿ\ÔÊ¯ÿª¢…ÿ\ÒË°ÿ­©Žÿ\Õ\×\Ïÿñòñÿòóóÿóóóÿñó\îÿ•€ÿ£°†ÿ¡¯„ÿŸ¬ƒÿœ©‚ÿ™§€ÿ›¥~ÿyYÿxxOÿ||QÿvwJÿ{{QÿXW@ÿˆŽrÿœuÿ”¢yÿ•£wÿ•£vÿ|ƒVÿ||Qÿ™—yÿtviÿiŠÿe†•ÿ°\Å\Ãÿòöõÿõõöÿõöõÿõööÿõõõÿ\×\Ú\Ïÿ\Ø\Ú\Ðÿ\Ô\Ø\Íÿ\Ñ\Õ\Êÿ\Í\Ñ\Æÿ\ÊÍ¿ÿ\ÈË¸ÿ\ÇËµÿ\ÆË°ÿ\ÅÊ¯ÿ\ÅÊ­ÿ\ÆÌ­ÿ\ÅË¬ÿ\ÄÊªÿ\ÂÈ¨ÿÁÇ§ÿ½Ã¤ÿ½Â¢ÿÀÄ£ÿÀÃ¢ÿ¾Ã¡ÿ½Ã ÿ½Âžÿ¬°ÿŸ¡…ÿŸ ‡ÿŠzÿ¡£Žÿ¯º”ÿ­¹’ÿ«¸‘ÿ­¹”ÿ¦®›ÿòóñÿóóóÿ\è\è\æÿÀÁ¼ÿÁ»¨ÿ\ÐÈ«ÿº²•ÿ\ÕË®ÿ¾³›ÿš‘{ÿ\ÐÈ¯ÿ\ÓË¯ÿ¿·œÿ\ÓÊ®ÿ\ÏÇ©ÿ\ÓË®ÿ\ÓÊ®ÿ±‘{ÿØ‘‚ÿÝÿÝÿÝÿÔ‰{ÿ¹thÿ³sfÿ³rfÿ²qeÿ²qeÿ±qeÿ´peÿ½wjÿÖ‹}ÿÚ|ÿÑ‡uÿ\Ä{lÿÛ}ÿÚ~ÿË„vÿŠfSÿÈ¹¡ÿ±«ÿ¾¸Ÿÿ¬¤‹ÿ±¨‘ÿ\ÉÀ¦ÿ\ÖÊ®ÿª£ˆÿ¹¶˜ÿ\ÑÏ»ÿòó\ïÿóóòÿóóóÿóóóÿóôðÿŸ¤‹ÿ¥°ˆÿ£±…ÿ ­ƒÿ«ÿ™§~ÿ›¦~ÿ{WÿwyMÿ{|PÿuvIÿ|{QÿXU@ÿ‰tÿ“Ÿwÿ”¢xÿ“£wÿ•¢vÿ}ƒXÿ~}Rÿ›˜|ÿtwjÿg€‹ÿe‡–ÿ¯\Å\Ãÿòöôÿõõõÿõõõÿöööÿõõõÿ\Õ\Ù\Îÿ\Ø\Ú\Ðÿ\Õ\Ø\Íÿ\Ð\Ô\Éÿ\Ì\Ñ\Åÿ\Ê\ÎÀÿ\ÉÌ¹ÿ\ÈË¶ÿ\ÅÊ³ÿ\ÄÉ®ÿ\ÄÉ­ÿ\ÆÌ­ÿ\ÆÌ¬ÿ\ÃÉ©ÿ\ÂÈ¨ÿÀÅ¦ÿ½Ã¤ÿ½Ã¡ÿÁÄ¤ÿÁÄ£ÿ¾Â¡ÿ¼Â ÿ¼Âžÿ¬¯ÿŸ¡‡ÿž ‡ÿ‹yÿ ¤Œÿ¯»•ÿ®º“ÿ«·‘ÿ®¹”ÿ®¶£ÿòóñÿóóóÿóóñÿ³´«ÿ®©“ÿ\ÐÉ¬ÿµ­ÿ\ÕË®ÿÃ¹Ÿÿ¡˜ÿ\ÐÈ¯ÿ\ÓË¯ÿ¹±•ÿ\ÑÇ­ÿ½¶˜ÿ\ÓÌ®ÿ\ÍÄ¨ÿ˜r]ÿØÿÝŽÿÝÿÞŒÿÝ€ÿÓˆ|ÿ»uiÿ³qdÿ²qeÿ²reÿ²qeÿ\Â|oÿÖŒ~ÿÚŽ}ÿÚŽ|ÿ¿xiÿÕ‰ÿÚ}ÿÛ~ÿ×Œ}ÿ¬n_ÿ©kÿ²¢…ÿ½µ›ÿ³ª‘ÿ²©’ÿ\ËÂ©ÿ\ÕÊ®ÿ ™ƒÿ§§—ÿ\îó\ïÿóôòÿóôóÿóóóÿóóóÿóô\ïÿ› ˆÿ¦°‰ÿ¢°…ÿ ®„ÿž¬‚ÿ›ª€ÿ›¨~ÿ{VÿxyMÿ{}PÿuvJÿ{{QÿXV@ÿŠuÿ•¢zÿ“¡vÿ”¢wÿ—£xÿ~ƒXÿ~Sÿœš|ÿtwhÿh€Šÿd‡•ÿ±\Ç\Åÿóöôÿõõõÿõõõÿöööÿõõõÿ\Ó\×\Ìÿ\Ô\Ø\Ïÿ\Ô\Ø\Ïÿ\Ð\Ô\Êÿ\Ë\Ð\Æÿ\É\ÎÀÿ\ÊÍºÿ\ÉÌ·ÿ\ÅÉ´ÿ\ÃÈ®ÿ\ÄÉ­ÿ\ÆË®ÿ\ÆË­ÿ\ÃÈ«ÿ\ÃÉ©ÿÁÆ§ÿ¾Ä¤ÿ¾Ã¡ÿÁÄ¤ÿÁÄ¥ÿ¿Ã¢ÿ¼Â ÿ¼Ážÿ¬°‘ÿŸ¡‡ÿž †ÿ‹yÿ ¤ÿ¯¼–ÿ®º’ÿ­¸‘ÿ®¹”ÿ³»ªÿóóòÿóóóÿóóóÿ\ê\í\éÿ´±ÿ\ÐÉ¬ÿ¯§Šÿ\ÔË®ÿ¾¹œÿ©¢‡ÿ\ÐÈ¬ÿ\ÓË¯ÿ²ªÿ\ÎÅ«ÿ¯©ÿ\ÍÆ¨ÿ¢„oÿ«sfÿÙ€ÿÝÿÝÿÝÿÝÿÝ‚ÿØŒ~ÿÊqÿ¿ylÿ¿ymÿÌƒwÿÙŽÿÚ|ÿÛŽ|ÿÚ|ÿ»raÿÚ~ÿÛ~ÿÜ€ÿÛ€ÿ·n`ÿÓÿ°{iÿÃ­–ÿ·¯“ÿ°§ÿ\ÌÄ©ÿ\ÔË±ÿˆŠxÿÁÄ·ÿ\ïôðÿòóóÿóôóÿñòðÿòóòÿóôðÿ¡¦Žÿ¨±Šÿ¦±‡ÿ¢¯„ÿŸ¬ƒÿ›©€ÿ›¨ÿ{Vÿy{Nÿ{|PÿuvJÿ|{QÿWU@ÿ‹uÿ—£{ÿ•£wÿ•£wÿ™¥yÿƒYÿ~}Rÿ™|ÿtwgÿh‰ÿd‡•ÿ²\É\Çÿòõôÿõõõÿöööÿöööÿõõõÿ\Ó\Ö\Ðÿ\Ô\Ø\Òÿ\Ó\×\Òÿ\Ï\Ò\Îÿ\Ë\Î\Éÿ\É\ÍÁÿ\ÊÍ¼ÿ\ÈÌ¶ÿ\ÅÊ±ÿ\ÅÊ°ÿ\ÄÉ®ÿ\ÅÊ¯ÿ\ÅÊ­ÿ\ÄÉ¬ÿ\ÃÉ©ÿÁÇ§ÿÀÅ¦ÿÁÅ¥ÿ\ÂÅ¦ÿ\ÂÅ§ÿÁÄ¥ÿ¾Â¡ÿ¼ÂŸÿ¯±“ÿ  ‡ÿŸ†ÿŒŠxÿ £ÿ°º•ÿ¬¹“ÿ¬¸’ÿ­·•ÿÁÅ¶ÿóóóÿóóóÿóóóÿ\íð\êÿ¦¡ÿ\ÎÆ¬ÿ®¦‹ÿ\ÖË¯ÿ\ÑÉ«ÿ´­‘ÿ\ÏÇ«ÿ\ÕË±ÿ¶­”ÿ\ÍÅ¬ÿ›xÿ¥ƒmÿÍÿ±mbÿÚŽ€ÿÜÿÜÿÜÿÝÿÜÿÛ~ÿÚŽ~ÿÚ~ÿÚ~ÿÜŒ~ÿÛŽÿÛŽÿÝÿÔ‰zÿ¾ulÿÚÿÛŒ~ÿÛŽÿÝÿÐ†yÿ\ÈpÿÙŽ€ÿ¸qÿ¡†pÿ¨ ‡ÿ\ÈÃ¦ÿ¯®™ÿ\Ó\Ù\Çÿòõñÿðóðÿ\Ò\Ó\Ñÿóóñÿ\ß\ß\Øÿ\í\ì\æÿóó\ïÿ¦§”ÿ¦¯‰ÿ¥°†ÿ¢¯„ÿ¡®„ÿ›¨‚ÿš§€ÿy€Wÿw{Nÿ{{PÿvvJÿ}{TÿXVAÿŠtÿ—¤zÿ•£wÿ•¢vÿ–£vÿ~‚Xÿ|{Pÿœš|ÿtxkÿh‚ˆÿd‡•ÿµ\Ê\Éÿò÷óÿõööÿõõõÿöööÿõõõÿ\Ó\×\Ñÿ\Ó\×\Òÿ\Ó\×\Òÿ\Ð\Ó\Ðÿ\Ë\Î\Éÿ\Ê\Í\Âÿ\ÉÌ»ÿ\ÈÌ·ÿ\ÆË´ÿ\ÆË²ÿ\ÅÊ°ÿ\ÅÊ±ÿ\ÅÊ®ÿ\ÃÈ¬ÿ\ÃÉ©ÿ\ÂÈ¨ÿÁÅ§ÿÁÅ¦ÿ\ÂÅ§ÿ\ÃÆ¨ÿÁÄ¦ÿÁÄ¥ÿÀÃ¤ÿ¯²“ÿ  ‡ÿŸ†ÿŒŠxÿ £ÿ°º•ÿ¬¹’ÿ¬¹’ÿ«µ“ÿ\ÂÆ¸ÿóóóÿóóóÿóóóÿ\î\î\ìÿ›–‰ÿ»µŸÿ°ªÿ\ÖË¯ÿ\ÕÊ¯ÿ¶®“ÿ\ÏÇ¬ÿ\ÖÊ¯ÿ®¥ŒÿÁ¶ÿŠ`PÿÒ€ÿÙ€ÿ»rfÿÛ€ÿÛÿÜÿÜÿÝÿÛŒ~ÿÛ~ÿÛŽÿÛÿÜ~ÿÜÿÛŽÿÛŽÿÝÿÀvgÿÓ‰zÿÚŽÿÚ~ÿÛŽ~ÿÜÿÛŽÿÛ~ÿÝŒ~ÿÚŽ‚ÿ¾}oÿiVÿÅ»­ÿ­³™ÿñõ\éÿóõñÿóöñÿ\Â\ÃÁÿñð\íÿ\Õ\Õ\Ìÿ\Ø\×\Îÿôó\íÿ°±Ÿÿ£ª†ÿ¥°…ÿ¤°…ÿ£®„ÿªƒÿ›¨ÿxWÿw{Nÿ||PÿwvKÿ}{RÿXU@ÿ‹‘uÿ™¦{ÿ–¤vÿ–¢uÿ—¤wÿ}Wÿ|{Pÿ›™{ÿtwkÿh‰ÿe†•ÿµ\É\Èÿòöóÿõööÿõõõÿöööÿõõõÿ\Ó\×\Ðÿ\Ó\×\Óÿ\Ó\×\Óÿ\Ï\Ó\Ïÿ\Ë\Ï\Ëÿ\Ê\Í\Âÿ\ÊÌ»ÿ\ÆË¶ÿ\ÅÊ²ÿ\ÇÌ´ÿ\ÅÊ°ÿ\ÅÊ²ÿ\ÅÊ¯ÿ\ÃÇ­ÿ\ÃÇ«ÿ\ÂÈ©ÿÁÆ§ÿÁÄ¦ÿ\ÂÅ§ÿ\ÃÅ©ÿ\ÂÄ¨ÿ\ÂÅ§ÿÀÄ¥ÿ°²”ÿ  ˆÿžŸ†ÿŠxÿ £ÿ°»–ÿ­»’ÿ¬¸’ÿ©²’ÿ\ÄÇ¼ÿòóòÿóôòÿôõóÿóôóÿ\ï\î\îÿ›™ÿ¸²–ÿ\ÖË­ÿ\ÕË®ÿ·¯’ÿ\ÎÆ©ÿ\ÔÊ®ÿ›Œtÿ£zkÿÖŒÿÛŽÿÙÿÕ‰zÿÛŽÿÜÿÝÿÛÿÛŽÿÛŽÿÜÿÛŽÿÚŽ~ÿÛ~ÿÛŒ~ÿÚ~ÿÛŽÿÛŽ€ÿ·paÿÚŽÿÚŽ}ÿÚŽ~ÿÜŽÿÛ~ÿÛŒ~ÿÜÿÛŒ~ÿÛŒ~ÿÚŽ}ÿÉŠ|ÿ‰qfÿµµ¶ÿñóóÿóôñÿòô\ïÿ\Þ\ß\Üÿ\Û\Û\Ûÿ\á\á\Ûÿ\ÂÁ¶ÿóô\ìÿ¹ºªÿ¡¥…ÿ¨²Šÿ¦°…ÿ¦®„ÿ ­…ÿžª‚ÿy€Xÿx{Pÿ}|OÿwvJÿ~{SÿXVAÿ“wÿ›§}ÿ˜¥xÿ—£vÿ˜¥wÿ|Wÿ|{Qÿ™˜zÿuvjÿg‚Šÿe‡•ÿ´\È\Çÿòöóÿõöõÿõõõÿöööÿöööÿ\Ó\×\Òÿ\Õ\Ø\Õÿ\Ó\×\Óÿ\Ð\Ô\Ðÿ\Í\Ñ\Íÿ\É\Í\Âÿ\ËÎ½ÿ\ÆÊ¶ÿ\ÅÊ³ÿ\ÆË³ÿ\ÆË²ÿ\ÆË³ÿ\ÆË°ÿ\ÃÇ­ÿ\ÂÇ«ÿ\ÂÇ©ÿÁÆ§ÿÁÆ§ÿ\ÂÅ©ÿ\ÃÅ­ÿÁÃªÿÀÃ§ÿÁÄ¦ÿ¯²”ÿŸ ‡ÿœŸ…ÿŒ‰yÿŸ¢Œÿ±º•ÿ¯º“ÿ­º“ÿ¨±ÿ\Ê\Í\Ãÿ\ïððÿ\Ý\ß\Ýÿôõóÿóôóÿòóòÿ½»ºÿ¶¯¡ÿ\ÕË¯ÿ\ÕË®ÿÂ¹ÿ\ÏÇ«ÿ¾®•ÿ¢yeÿ×€ÿÜ€ÿÛŽÿÛŽ€ÿÜŽ€ÿÜ~ÿÛŽ}ÿÜ~ÿÜÿÛ~ÿÛ~ÿÜ~ÿÛŽÿÛŽÿÛ~ÿÛ~ÿÚŽ~ÿÛŽ}ÿÌƒtÿ\Æ}pÿÚÿÛŽ~ÿÛŽÿÜŽÿÛŽ€ÿÛÿÜÿÛÿÜ€ÿÚŽ€ÿÁˆ~ÿ\Ý\Ñ\Íÿóôôÿòóóÿóóóÿóôðÿðñ\îÿ\Ï\Ï\Ïÿ\î\î\éÿ³±¦ÿóó\éÿ\ÂÄ³ÿ›¡ÿ§²Šÿ¢¯…ÿ¤¯…ÿ ®„ÿª‚ÿxWÿz{Qÿ}}PÿwvJÿ}{Qÿ[XCÿ“wÿš§|ÿ˜¥xÿ˜¤xÿ›¦{ÿ}Xÿ}|Qÿ™™{ÿtvjÿhŠÿf‡“ÿ²\Æ\Åÿòöóÿõöõÿõõõÿöööÿööõÿ\Ó\×\Ôÿ\Õ\×\Õÿ\Ò\Õ\Óÿ\Ï\Ó\Ðÿ\Ë\Î\Ëÿ\È\Ë\Âÿ\ÉÍ¾ÿ\ÇÌºÿ\ÆÊ¶ÿ\ÇË´ÿ\ÈÌ´ÿ\ÆË³ÿ\ÆË°ÿ\ÃÈ­ÿ\ÂÆªÿÁÆ¨ÿÁÆ§ÿÁÆ¨ÿ\ÄÇ­ÿ\ÄÆ¯ÿ\ÂÄ­ÿÁÅªÿÁÅ¦ÿ°³“ÿžŸ…ÿ›ƒÿŽ‹{ÿŸ¢ÿ°¸•ÿ¯º“ÿ¯¼”ÿ¥­Œÿ\Ð\Ò\Êÿ\í\í\íÿ\Ü\Û\Ûÿôõóÿóôôÿóóôÿñò\îÿº¸°ÿ²®˜ÿ\ÒÊ®ÿ\ÔÊ¯ÿ´¡‹ÿ¬|kÿ×Ž€ÿÝŒÿÜŒ~ÿÜ~ÿÜŽÿÛŽ~ÿÛ|ÿÚ|ÿÛ~ÿÜÿÚŽ~ÿÚŽ~ÿÛ~ÿÚŽ~ÿÛÿÚŽ~ÿÛÿÚ}ÿÚ|ÿ¹s_ÿ×~ÿÛŽÿÛŽÿÚŽ~ÿÛŽÿÛŽÿÛ€ÿÜÿØŒÿ¾€vÿ°†}ÿ\à\Í\Æÿòôñÿóóóÿóóóÿóóóÿòóñÿ\í\î\éÿ\Å\ÇÁÿòó\ìÿ³°¦ÿ\ï\î\áÿ\Ò\Õ\Äÿ‘˜xÿ§³‰ÿ¢¯…ÿ ­„ÿ ®…ÿœ©‚ÿz€Yÿ{|Rÿ}}QÿxwKÿ|{RÿZXBÿ‹‘tÿ™¦zÿ˜¦yÿš§zÿœ¨{ÿ}Vÿ}|Rÿ˜˜zÿvxkÿiƒŠÿg‡’ÿ¯\Â\Ãÿñ÷òÿõöôÿõõõÿöööÿö÷õÿ\Ò\Ö\Òÿ\Ó\Ô\Óÿ\Ò\Ó\Òÿ\Í\Ð\Ïÿ\Ë\Í\Ëÿ\É\Ì\Ãÿ\ÉÍ¾ÿ\ÊÍ¼ÿ\ÇÊ¶ÿ\ÇËµÿ\ÈÌµÿ\ÆË²ÿ\ÅÊ¯ÿ\ÃÈ­ÿ\ÂÆ«ÿÁÅ©ÿÀÄ©ÿ\ÂÆ«ÿ\ÄÈ®ÿ\ÅÇ°ÿ\ÃÅ®ÿÁÄªÿ\ÃÆ§ÿ±´”ÿžŸ…ÿ›ž„ÿŒ{ÿ ¤ÿ±»—ÿ­º“ÿ¯º”ÿ¤¬‹ÿ\×\Ú\Ñÿ\ë\ê\êÿ\à\ß\ßÿôôôÿóóôÿóóôÿóóóÿóóóÿ\Þ\á\Úÿ¬¦‹ÿ¢Šsÿ¹rÿØŽ‚ÿÛŽÿÜŽÿÛŽÿÜÿÜÿÛŽÿÛ~ÿÛŽ~ÿÚ~ÿÛ~ÿÜ~ÿÛ~ÿÜÿÛŽÿÛ~ÿÛŽ~ÿÚŽ~ÿÚ~ÿÖ‰zÿÁwiÿÛ€ÿÛŽÿÛŽÿÛ~ÿÛŽÿÛÿÜ~ÿ×Žÿ»Žÿ\è\Ü\Øÿñð\îÿòóñÿòôóÿóóóÿóóóÿôôôÿóôñÿ\æ\ç\ßÿ\Ç\Ç\Ãÿóó\îÿµ²©ÿ\é\ç\Úÿ\å\å\ØÿŽ•wÿ¥°‰ÿ¡­†ÿŸ¬…ÿž«„ÿ©‚ÿyWÿ{{Qÿ~}QÿxwLÿ}{SÿZXAÿ‹sÿ™¦{ÿ˜¦xÿ˜¦xÿœ¨{ÿ}Vÿ|{Qÿ—–xÿvwkÿiƒŠÿhˆ•ÿŸ²¹ÿ\×\ß\Þÿ\î\ï\îÿóõõÿôõôÿõ÷õÿ\Ò\Ö\Òÿ\Ò\Õ\Òÿ\Ò\Ô\Óÿ\Í\Ï\Îÿ\Ì\Ï\Ìÿ\É\Í\Äÿ\ÉË¾ÿ\ÉÌ»ÿ\ÇË·ÿ\ÆÊ¶ÿ\ÆÊµÿ\ÅÊ²ÿ\ÅÊ¯ÿ\ÄÈ®ÿ\ÂÆ®ÿ¿Ä«ÿÀÅªÿ\ÃÈ­ÿ\ÄÉ¯ÿ\ÆÇ³ÿ\ÃÄ°ÿ\ÂÄ¬ÿ\ÂÅ¨ÿ°³•ÿŸ…ÿ›ž„ÿŽŒzÿŸ¢Œÿ´¼šÿ°º”ÿ¯º”ÿ¦­Žÿ\ä\ç\Ýÿ\è\è\çÿ\ß\ß\ßÿôôôÿóóôÿðñðÿ\ïð\îÿôòõÿ\ïöòÿ§¨žÿ²wÿÜŽ‚ÿÛÿÚŽÿÚ€ÿÛŽÿÝŒÿÛÿÛ~ÿÜÿÛ~ÿÚ~ÿÛ~ÿÝÿÜÿÛ~ÿÛŽÿÚŽ~ÿÜŽÿÛ~ÿÚŽ€ÿ½ulÿÕ‚ÿÜÿÛÿÛÿÚ~ÿÚŽ~ÿÙŽ~ÿÒÿ±‚oÿ\ï\â\Øÿôòòÿôóôÿóóóÿóôôÿóóóÿóóóÿôôôÿóôñÿ\â\ä\Úÿ\É\È\Äÿóò\ïÿ¼·°ÿ\å\â\Öÿ\í\ë\áÿœ„ÿ¥®‰ÿ ¬†ÿ¡­‡ÿŸ«„ÿž©ƒÿ{Yÿ||Sÿ~}QÿwvKÿ}{SÿXV@ÿŠsÿ›¦{ÿ™¦yÿ™¦yÿ›§zÿ}‚Vÿ}{Qÿ–•xÿtvjÿgŠÿb„“ÿj„‘ÿ|’›ÿ’¡¦ÿ«·¼ÿ\È\Ñ\Óÿ\Ö\Þ\ßÿ\Ô\×\Óÿ\Ó\Õ\Ôÿ\Ñ\Ó\Ôÿ\Ì\Ï\Ïÿ\Í\Ð\Îÿ\Ê\Î\Çÿ\ÉÌ¿ÿ\ÈË»ÿ\ÈË¸ÿ\ÈË·ÿ\ÇË¶ÿ\ÆÊ´ÿ\ÅÊ±ÿ\ÅÊ¯ÿ\ÂÇ®ÿÁÅ­ÿ\ÃÇ¯ÿ\ÄÉ±ÿ\ÅÈ´ÿ\ÅÆ´ÿ\ÃÄ±ÿÁÃ®ÿ\ÂÄªÿ¯²•ÿ „ÿ›ž„ÿŒ{ÿ £Žÿ³»šÿ±º•ÿ°º•ÿ¥¬‘ÿ\è\ë\âÿ\Ý\Þ\Üÿ\ã\æ\äÿòôóÿóóóÿ\Ö\Ô\Ñÿ\è\é\áÿôóóÿôôôÿ\î\î\îÿ¸¬¨ÿ´†{ÿ×ŽÿÚƒÿÙ€ÿÛÿÜÿÜŒÿÛŒ~ÿÝÿÛÿÜÿÝÿÞŒÿÛ~ÿÜÿÛŽÿÜŽÿÜÿÛÿ×}ÿ¾yhÿÚ‚ÿÚ~ÿÛ~ÿÚ}ÿÚÿÉ‡yÿ¶”‰ÿ¸©¢ÿ\Ý\Ø\Ñÿóóòÿôóóÿôóóÿôóóÿóóóÿóóóÿóóóÿôôôÿóôóÿ\á\à\×ÿ\ÆÅ½ÿð\ï\ëÿ¿»³ÿ\â\Þ\Ðÿñ\ï\çÿ¹¶£ÿŽ—tÿŸ¬…ÿ ­…ÿ ­…ÿ«‚ÿ{‚[ÿ|{Sÿ}~RÿxvKÿ}{TÿWU@ÿ’uÿœ¨}ÿ™§yÿš¨yÿž©|ÿ‚Uÿ~}Pÿ–”uÿqthÿeŒÿf‡˜ÿeˆšÿf†˜ÿg…˜ÿi„–ÿpˆ—ÿ|‘œÿ\Ô\×\Ôÿ\Ó\Õ\Ôÿ\Ð\Ò\Óÿ\Í\Ð\Ðÿ\Ì\Ï\Ìÿ\É\Ì\Çÿ\ÊÌ¾ÿ\ÈË»ÿ\ÇÊ¸ÿ\ÈË·ÿ\ÈË·ÿ\ÆË³ÿ\ÅÊ²ÿ\ÄÉ°ÿ\ÃÈ¯ÿ\ÃÈ°ÿ\ÄÉ°ÿ\ÄÈ²ÿ\ÅÆ´ÿ\ÄÅµÿ\ÂÃ²ÿ¿Ã®ÿÀÃ«ÿ°´—ÿ …ÿ›„ÿŠyÿ¢¥‘ÿ²º™ÿ±º–ÿ°¸–ÿž¤ÿ\ë\î\æÿ\Ù\Û\Øÿ\é\ë\èÿóôóÿóôóÿ¸¶®ÿ\î\î\èÿóôòÿóôóÿôôôÿóóôÿ\Ü\Í\Çÿ¤\\Bÿ\ÄhDÿ½fJÿ\Ãq[ÿÖˆwÿÛÿÛ~ÿÛÿÛ~ÿÛÿÜÿÜÿÛŽÿÛ~ÿÛÿÛŽ€ÿÜÿÛÿÚ~ÿÚŽÿÚ‚ÿÚ~ÿØÿÊˆyÿ¿…wÿÊ­¤ÿñò\ìÿñôòÿñõóÿòôòÿóóóÿôôôÿóóóÿóóóÿóóóÿóóóÿóóóÿóôòÿ\â\à\Ôÿ¿½²ÿ\é\è\äÿ\ÄÁ¹ÿ\Û\Ø\Éÿóó\çÿ\ÓÍ»ÿwfÿ˜¤…ÿŸ­…ÿ ­„ÿž«ƒÿ}‚\\ÿ|{Rÿ}|QÿxvKÿ}|TÿXVAÿŽ”wÿ©}ÿ›©yÿ›©yÿžª{ÿ~Tÿ~}PÿŽŒnÿoqbÿh|‚ÿb€Žÿ_€“ÿ_’ÿ_“ÿ`€•ÿa–ÿc„˜ÿ\Ó\×\Ôÿ\Ò\Õ\Óÿ\Ð\Ò\Óÿ\Í\Ð\Ïÿ\Ê\Í\Ëÿ\É\Ì\Æÿ\Ê\ÍÁÿ\ÈË»ÿ\ÇË¸ÿ\ÈË¸ÿ\ÈÌ¸ÿ\ÅÊ³ÿ\ÅÊ²ÿ\ÄÉ°ÿ\ÄÉ°ÿ\ÅÉ²ÿ\ÄÉ°ÿ\ÃÇ±ÿ\ÄÆ´ÿ\ÃÅ¶ÿ\ÂÃ³ÿ¿Â®ÿÀÃ«ÿ±³˜ÿŸ„ÿ›ž…ÿŒ‰wÿ¢¥ÿ´¼šÿ±¹–ÿ°¸˜ÿ£Žÿðò\ëÿ\Ü\Ý\Õÿ\î\ï\èÿóôòÿññ\ïÿ·´¨ÿðð\èÿóóóÿóôòÿóôóÿóòòÿÊ¦–ÿð|Cÿÿz8ÿü|8ÿ\ït6ÿ\Òe2ÿÀiIÿÕˆtÿÜ€ÿÛ}ÿÚ~ÿÙŽ~ÿÙŽ~ÿØ|ÿÕŒzÿÓŠyÿÕŒ|ÿÚ€ÿÚŽÿÚŒ~ÿÕÿÐÿÉ‰ÿ¾™ÿ\Þ\Ð\Êÿ\è\á\Þÿòòñÿòôóÿòôóÿòôõÿ\Û\Û\Ûÿôôôÿñññÿóóóÿóóóÿóóóÿóóóÿóóóÿôôóÿ\ã\á\Øÿ¾½®ÿ\ß\à\Ôÿ\ÊÉ¾ÿ\ÏÌ»ÿòñ\æÿ\ÓÎ¼ÿN\\]ÿ2J\\ÿ¤ˆÿž¬ƒÿŸ«„ÿ{‚Zÿ{|Pÿ~}QÿxvKÿ~}TÿXVAÿ•xÿŸ¬ÿŸ¬}ÿ ®}ÿ©|ÿ}VÿƒPÿ}|Vÿ…‚iÿ|rÿr~yÿj|}ÿe}…ÿe€Œÿbÿ^~ÿ^“ÿ\Ô\×\Õÿ\Ò\Ô\Óÿ\Ð\Ò\Óÿ\Ï\Ñ\Ñÿ\Ë\Î\Ìÿ\Ê\Í\Çÿ\Í\Ð\Âÿ\ÊÍ½ÿ\ÈË¹ÿ\ÉÌ¹ÿ\ÇÊ·ÿ\ÅÉµÿ\ÄÈ´ÿ\ÄÈ³ÿ\ÅÉ´ÿ\ÅÉ´ÿ\ÃÇ²ÿ\ÃÇ³ÿ\ÄÆ¶ÿ\ÂÄ¶ÿ\ÂÄ´ÿÁÃ°ÿÁÄ­ÿ±´šÿŸ…ÿœŸ…ÿŽ‹yÿ¤¦’ÿµ½›ÿ±¹”ÿ±¹–ÿ¢¨”ÿóô\ïÿ\â\á\Øÿ\ë\ì\âÿòòñÿ\æ\æ\âÿ¿½¯ÿòó\ëÿóôóÿóóóÿóôóÿöó\ïÿÌ†gÿý|:ÿÿz4ÿÿy6ÿÿz5ÿÿz6ÿøw8ÿ\Æf=ÿ¦hZÿ´qeÿ»iRÿÀiHÿ\Éi@ÿ\Ík;ÿ\Ïi6ÿ\Ðg4ÿ\Óh7ÿ\ÊeBÿÁr]ÿºƒuÿÄ¬£ÿÀ¸®ÿÊ¾¹ÿòñ\íÿñôñÿðõóÿóôñÿóõñÿóôóÿóóóÿ\Ù\Ø\Ùÿôóóÿ\Ò\Ò\Òÿóóóÿóóóÿóóôÿóóóÿóóóÿôôóÿ\æ\ã\ÚÿÀ½­ÿ\Ô\Ó\Äÿ\á\Þ\Ñÿµ°¡ÿ\ä\à\Öÿ\ÏÌ¶ÿ?LYÿ9kÿ@_mÿ›«‰ÿž©ƒÿz‚Zÿ}}Rÿ}RÿwvJÿ}TÿZXBÿ‘—yÿž«ÿŸ¬}ÿž¬|ÿš§yÿ|‚Xÿ…†Rÿˆ…Sÿ‰†Tÿ…Tÿ‡‚\\ÿ‹†fÿ†ˆqÿ†wÿy}ÿm|}ÿh~†ÿ\Ó\Õ\Ôÿ\Ó\Ô\Óÿ\Ñ\Ò\Ôÿ\Ð\Ñ\Ñÿ\Ì\Ï\Íÿ\Ê\Î\Çÿ\Î\Ñ\Ãÿ\ËÎ½ÿ\ÉÌ»ÿ\ÉÌ¹ÿ\ÈË·ÿ\ÅÉµÿ\ÅÉµÿ\ÅÉµÿ\ÆÊ¶ÿ\ÇÊ¶ÿ\ÃÆ³ÿ\ÃÆ´ÿ\ÂÅ¶ÿ\ÂÄ¶ÿÁÄ´ÿ\ÂÃ±ÿ\ÂÄ­ÿ±´šÿŸ†ÿŸ‡ÿŒ{ÿ¥¤’ÿ·½ÿ³»˜ÿ²¼™ÿ©®Ÿÿôôñÿ\Û\×\Íÿ\Ú\Ù\Îÿ\â\â\áÿ\ç\æ\ãÿÀ¾¯ÿóó\íÿóôóÿôôôÿóôóÿñ\ä\Ûÿ\ÒyJÿÿ{7ÿÿ{7ÿÿz6ÿÿz6ÿÿy6ÿÿy6ÿ\Þt:ÿ‹m[ÿ‰Q9ÿó{Fÿý{9ÿÿz7ÿÿz5ÿÿz3ÿÿz2ÿÿ{4ÿþ{8ÿ¹gAÿ\ë\Ú\Ñÿñóòÿðóòÿñôòÿñóñÿðò\ïÿóôòÿôõòÿ\å\å\çÿóóóÿóóóÿ\Þ\Þ\Þÿ\í\í\íÿ\Ö\Ö\Öÿñññÿóóóÿóóóÿóóóÿóóóÿóôòÿ\é\ç\Ýÿ\ÈÂ±ÿ\ÅÀ¯ÿ\ê\å\Õÿ¿·¢ÿ\ÎÇµÿ\ÅÄ«ÿ0<ÿ:oÿ;kÿ‚—Šÿ›¨ƒÿ|ƒ[ÿ~}QÿQÿwvHÿ}SÿYW?ÿ”uÿ›¨|ÿ—¨{ÿ•¤wÿ¡uÿs~Wÿ|Tÿ†…VÿˆˆSÿŒˆQÿ‰Rÿ‘‰Sÿ‹†Sÿ†Tÿ‡ƒ\\ÿ‹ˆhÿ‡‰qÿ\Ó\Ö\Ôÿ\Ò\Õ\Óÿ\Ò\Ó\Õÿ\Ð\Ñ\Òÿ\Ì\Ð\Îÿ\Ê\Í\Çÿ\Ì\Î\Ãÿ\ÊÍ½ÿ\ÊÍ¼ÿ\ÉÌ»ÿ\ÉÌºÿ\ÆÊ¶ÿ\ÆÊ¶ÿ\ÆÊ¶ÿ\ÇÊ¶ÿ\ÅÉµÿ\ÃÆ³ÿ\ÃÆ³ÿ\ÂÄµÿ\ÂÄ¶ÿÀÃ³ÿÁÃ°ÿ\ÃÄ®ÿ±³šÿž †ÿžŸ‡ÿ‹{ÿ¦¥•ÿ¸¾žÿ´½šÿ§±“ÿ´º¯ÿòñ\ìÿ\Õ\ÑÁÿ\Ë\ÊÀÿ\â\â\áÿ\ë\é\çÿ»·«ÿôõðÿóôòÿóôóÿòõòÿ\ÚÄ¹ÿ\äzFÿÿ{7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz5ÿ\Ñn5ÿ ˆƒÿ³qRÿüz8ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿÿx6ÿÿy6ÿþz7ÿ\ËyLÿ÷ò\ëÿóôòÿóóóÿòõòÿ\í\ï\ìÿ\Ð\Ò\Îÿóôðÿ\ïð\ìÿ\Ó\Ô\Òÿóóòÿóôóÿ\ê\ê\êÿ\æ\æ\æÿ\×\Ø\Øÿ\æ\æ\æÿóóóÿóóóÿóóóÿóóóÿóôòÿ\í\ë\âÿ\ÎÈ·ÿµ®œÿ\ä\Þ\Êÿ\ÌÅ«ÿ±ª’ÿŒ“„ÿ%Aÿ;sÿ:tÿ-I\\ÿžƒÿ|ƒXÿ}~NÿPÿyxLÿ~}TÿXW?ÿ‹‘sÿ•¥zÿ¢uÿ‹ŸqÿŠžqÿ…–oÿktTÿ\\aDÿklMÿyyRÿ††Xÿ‹‰Vÿ‹‰TÿŒŠRÿŽŠSÿ‰TÿŒ‡Sÿ\Ô\Ö\Õÿ\Ò\Ö\Óÿ\Ò\Ó\Ôÿ\Ð\Ñ\Óÿ\Í\Ð\Îÿ\Ë\Î\Éÿ\Ë\Î\Ãÿ\ËÎ¿ÿ\ÊÍ¼ÿ\ÉÌ»ÿ\ÉÌ»ÿ\ÉÌºÿ\ÇÊ¸ÿ\ÇÊ¹ÿ\ÆÊ·ÿ\ÄÇ´ÿ\ÃÆ³ÿ\ÂÅ³ÿÁÄ¶ÿ\ÂÄ¹ÿÁÂµÿ\ÂÄ²ÿ\ÃÅ°ÿ²´œÿž †ÿŸ ‡ÿŒ|ÿ¦¥–ÿ·¿žÿ°¼›ÿTd[ÿ\Í\Ö\Òÿð\î\æÿ\ÓÏ½ÿ\ÇÆ¾ÿ\ë\í\êÿð\ï\íÿ¹¶¬ÿôôñÿóôóÿóôóÿòõòÿÍ­›ÿò~Cÿÿ{7ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿ{6ÿÀd5ÿ¨‘ŸÿÀsOÿÿz8ÿÿz6ÿÿ{7ÿÿz6ÿÿy6ÿÿy6ÿÿx6ÿþz7ÿÐUÿöò\ìÿóóóÿóóóÿòõñÿ\ë\ì\çÿ½¾µÿòóðÿ\Ö\×\Õÿ\Ö\×\Öÿóóóÿóôòÿ\ïñ\îÿ\Ù\Ù\Ùÿ\á\â\áÿ\Ü\Ü\Üÿóóóÿóóóÿóóóÿóóóÿóôòÿñ\ï\èÿ\ÒÍ¹ÿ°©“ÿ\ÖÍµÿ\ÓË±ÿƒqÿ 3Aÿ)Sÿ;uÿ	;zÿ/gÿ2Maÿoz[ÿ|NÿPÿyxKÿ~UÿXYAÿ‰tÿ“¤yÿ sÿŠžqÿŠžqÿˆšqÿ†˜sÿ€Žnÿq}`ÿclOÿ\\bGÿ`eFÿmqMÿ|Sÿ…†VÿŒ‰UÿŠSÿ\Ó\Ö\Óÿ\Ñ\Ó\Òÿ\Ò\Ò\Õÿ\Ð\Ñ\Óÿ\Ì\Ï\Ìÿ\Ë\Î\Éÿ\Ë\Í\Ãÿ\Ì\ÎÀÿ\ÊÎ½ÿ\ÉÌ»ÿ\ÊÍ¼ÿ\ÊÍ»ÿ\ÈËºÿ\ÆÊ¹ÿ\ÆÊ¸ÿ\ÃÆ´ÿ\ÃÆ³ÿÁÄ³ÿ\ÂÄ·ÿ\ÂÄºÿÁÃ¸ÿ\ÂÅ´ÿ\ÂÅ±ÿ³µžÿž ˆÿŸ …ÿŽzÿ¤£•ÿ¸¾¢ÿq‡}ÿ8Sÿ\Þ\è\îÿ\è\ç\Ûÿ\ÔÐ¼ÿ\ÃÄ»ÿ\ïñ\îÿòôñÿ\ÅÆ½ÿòó\îÿðð\îÿôôõÿóòñÿÈ˜ÿú}>ÿÿ{6ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿþz7ÿ\ÉvOÿx}ÿ\ÊmGÿÿy7ÿÿy6ÿÿz6ÿÿy6ÿÿx6ÿÿy6ÿÿy6ÿþz8ÿØfÿõò\ìÿóóóÿóóóÿóôñÿ\è\è\ßÿ¼¼¯ÿóôñÿ\Ê\Ê\Êÿ\Ù\Ù\Øÿ\î\î\îÿóóóÿòóòÿ\Ò\Ò\Òÿ\ë\ë\ëÿ\Ø\Ø\Øÿóóóÿóóóÿóóóÿóóóÿóóóÿóñ\íÿ\ÕÏ¼ÿ§Ÿˆÿ\ÓË°ÿ\ÎÈ°ÿ(4:ÿ ?ÿ	0aÿ	;xÿ;|ÿ9wÿ\n;qÿ)GVÿuzVÿ~OÿxyJÿ~SÿXYBÿ†Žrÿ‘£zÿŒ uÿ‰tÿŠžsÿ‰›rÿ‰œsÿŠtÿ‰tÿ‡™tÿ‚rÿz…gÿgsYÿZdKÿW^Cÿ_cHÿqqMÿ\Ó\×\Ôÿ\Ó\Õ\Ôÿ\Ó\Ó\Öÿ\Ñ\Ò\Ôÿ\Î\Ð\Îÿ\Ë\Í\Éÿ\Ì\Î\Äÿ\Ì\ÏÁÿ\ËÎ½ÿ\ÉÌ»ÿ\ÊÍ¼ÿ\ÉÌ»ÿ\ÈËºÿ\ÇËºÿ\ÇÊ¹ÿ\ÃÇ´ÿ\ÄÇ´ÿ\ÂÅ´ÿ\ÃÅ¸ÿ\ÂÄºÿ\ÂÄ¸ÿÁÄ³ÿ\ÂÅ²ÿ²´žÿž ‰ÿŸ †ÿ{ÿ£¢–ÿ•¡˜ÿBeÿ9jÿ\Ù\ã\íÿ\â\ß\Òÿ\Ù\ÔÀÿ\ÂÂ¼ÿòôòÿòôòÿ\Ý\ß\Ùÿ\æ\ç\ãÿ\×\Ø\ÖÿôôôÿõóðÿÅ‡fÿû|;ÿÿ{7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿþz7ÿ«g?ÿšƒ‚ÿ\ØuFÿÿy7ÿÿy6ÿÿz6ÿÿz6ÿÿy6ÿÿy6ÿÿy6ÿþ{8ÿßžzÿôò\îÿóóóÿóóóÿóôòÿ\ê\è\ßÿ¶µ§ÿóôðÿ\Ï\Ï\Îÿ\Ù\Ù\Ùÿ\æ\æ\æÿóóóÿóóóÿ\È\É\Èÿðñðÿ\Ï\Ï\Ïÿóóóÿóóóÿóóóÿóóóÿóóóÿôò\ïÿ\×Ñ½ÿ¨ …ÿ\ÒÌ°ÿ–š†ÿ!2ÿ%Kÿ\n:sÿ;{ÿ;{ÿ;|ÿ<zÿ9qÿ9NUÿ{}WÿyzLÿ~SÿWYBÿ„qÿŽŸvÿ‹ŸtÿŠžtÿ‹Ÿtÿ‹tÿ‰›sÿˆœtÿˆœsÿ‰sÿ‰›rÿ…—oÿ†˜tÿ”qÿ{ŒlÿqcÿdkPÿ\Ó\×\Ôÿ\Õ\Õ\Õÿ\Ó\Ó\Õÿ\Ñ\Ò\Ôÿ\Ï\Ñ\Ðÿ\Ê\Í\Éÿ\Ì\Ï\Äÿ\Ì\Î\Âÿ\ËÎ¿ÿ\ÊÍ¼ÿ\ÉÍ¼ÿ\ÆÌºÿ\ÇÌºÿ\ÈËºÿ\ÇÊ¹ÿ\ÅÉ¶ÿ\ÄÇ´ÿ\ÂÅ´ÿ\ÃÅ¸ÿ\ÃÅ»ÿ\ÂÄ¹ÿ\ÂÄµÿ\ÄÅ´ÿ²³Ÿÿž ˆÿŸ †ÿŽŒzÿ’—‘ÿ1Mgÿ\n=yÿ9sÿ¦·\Éÿ\Û\Ø\Çÿ\Ý\Ù\Äÿ\Â\ÂÁÿóôóÿòôñÿñó\ïÿ\ã\ä\ßÿ\Ø\Ù\Öÿôôôÿöò\íÿ\Æ}Vÿþ{8ÿÿz6ÿÿz6ÿÿx6ÿÿy6ÿÿz6ÿû{6ÿ—d8ÿœ…uÿ\èzEÿÿz6ÿÿz6ÿÿz6ÿÿz7ÿÿz6ÿÿy6ÿÿy6ÿü{:ÿÛ¡‚ÿôòðÿóóóÿóóóÿóôòÿ\î\ë\âÿ³²£ÿóôñÿ\Ö\×\Õÿ\ê\ë\éÿ\á\â\áÿóóóÿòòòÿ\É\Ê\Èÿñññÿ\Í\Í\Îÿóôòÿóóóÿóóóÿóóóÿóóóÿôò\îÿ\×Ð»ÿ«¥ˆÿ°®›ÿ\"17ÿ\"Cÿ3cÿ	;zÿ\n;}ÿ;|ÿ<|ÿ9wÿ9yÿ8iÿS__ÿvwMÿSÿWY@ÿ„pÿŽŸuÿŒ rÿ sÿ tÿŒžrÿ‹žtÿŠtÿŠžtÿ‹ŸsÿŠžsÿ‡›qÿ‰uÿˆœsÿ‡›qÿ„šqÿ†™tÿ\Ô\×\Ôÿ\Õ\×\Öÿ\Õ\Ö\×ÿ\Ò\Ô\Ôÿ\Í\Ð\Ðÿ\É\Ì\Èÿ\Ë\Í\Äÿ\Ë\Î\Âÿ\ÊÌ¾ÿ\ÊÌ½ÿ\ÈÌ½ÿ\ÇË¼ÿ\ÈË¼ÿ\ÇÊ»ÿ\ÆÊ¹ÿ\ÅÉ¶ÿ\ÄÈ¶ÿ\ÃÆµÿ\ÄÆ¹ÿ\ÄÆ¼ÿ\ÂÄºÿ\ÂÄµÿ\ÂÄ³ÿ±²ŸÿŸ†ÿž„ÿ‡‰|ÿ5Maÿ:tÿ	<~ÿ<zÿNh‰ÿ\Ø\Ö\Êÿ\â\ß\Ìÿ¼¼·ÿòóòÿñððÿ\Ý\Ý\Üÿ\Ö\×\Ðÿ\Ñ\Ò\Ìÿóõóÿô\î\éÿ\ÆtMÿþz7ÿÿy6ÿÿy6ÿÿy6ÿÿz6ÿÿz6ÿù}:ÿ°€cÿ„hZÿ\î|Eÿÿ{5ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿú}<ÿÒ£‚ÿóóðÿóóóÿóóóÿóóóÿñ\î\èÿµ²¥ÿôôñÿ\Ì\Î\Êÿ\í\ï\ëÿ\Ò\Ó\Ñÿôôôÿóóóÿ\É\Ê\Éÿñññÿ\ä\å\äÿóôóÿóóóÿóóóÿóóóÿôòóÿóñ\ìÿ\ÕÐ¶ÿ§¤‰ÿ(11ÿ=ÿ-\\ÿ\n<vÿ<|ÿ	;|ÿ9uÿE\\…ÿ˜§ÿz†–ÿ*Bhÿ+9Qÿ`XAÿmbAÿWV?ÿ„nÿ vÿ tÿ“¢uÿ’£uÿ¡uÿ¡uÿ¢vÿ¢uÿ‘£tÿ rÿŠœpÿŽ uÿ¡uÿŽ tÿ‹žsÿŠ›qÿ\Ô\Ø\Ôÿ\Ô\×\Õÿ\Ó\Õ\Öÿ\Ñ\Ó\Ôÿ\Í\Ï\Ðÿ\Ê\Ì\Éÿ\Ë\Î\Åÿ\Ë\Ï\Ãÿ\ÉË¾ÿ\ÉË½ÿ\ÇË½ÿ\ÉË½ÿ\ÉË½ÿ\ÆÉ»ÿ\ÆÊ¹ÿ\ÅÉ·ÿ\ÄÇ¶ÿ\ÃÆµÿ\ÃÅ¸ÿ\ÅÆ¼ÿ\ÃÅ»ÿ\ÃÅ·ÿÁÃ´ÿ³²ŸÿŸˆÿ™ž†ÿG]fÿ;nÿ	<~ÿ\n<~ÿ	<|ÿ:pÿ¨®³ÿ\Þ\Û\ÎÿÁÃ¾ÿòôòÿ\îð\ïÿ\Ñ\Ñ\Ðÿ\Ï\Ï\Çÿ\Ë\Ì\Æÿóõòÿ\ì\â\Üÿ\ËsEÿÿx7ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿø|;ÿ‚T@ÿŽk]ÿó}Aÿÿ{5ÿÿz6ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿø};ÿÕ©Šÿóóñÿóóóÿóóóÿóóóÿñð\ëÿ³°¥ÿôóñÿ\Î\Ï\Ëÿ\ì\í\éÿ\Õ\Ö\Ôÿôôôÿóóóÿ\Õ\Õ\Õÿ\ë\ë\ëÿóóóÿóóóÿôôôÿóóóÿóóóÿôòôÿñ\î\èÿ\ÑÍ³ÿhn`ÿ:ÿ)Tÿ\n;tÿ<{ÿ<}ÿ\n;zÿB[‡ÿ©¥±ÿ¨š—ÿ§šœÿŸ˜–ÿKGOÿbK;ÿrP8ÿTD1ÿ‹qÿ•¤xÿ“¢uÿ•£uÿ–¦vÿ“¤wÿ’¤vÿ’¤uÿ•¦wÿ—¥wÿ•£wÿŽŸrÿ•¥xÿ•¥vÿ“¤vÿ‘¢uÿ’¡tÿ\Ô\Ö\Ôÿ\Ò\Ô\Óÿ\Ò\Ô\Ôÿ\Ñ\Ó\Ôÿ\Í\Ð\Ðÿ\Ë\Î\Ëÿ\Ê\Ì\Çÿ\Ê\Ì\Ãÿ\Ê\ÌÁÿ\ÊÌ¿ÿ\ÇË¾ÿ\ÈÊ½ÿ\ÈÊ¼ÿ\ÆÉ»ÿ\ÆÊ¹ÿ\ÆÊ·ÿ\ÄÈµÿ\ÄÈ¶ÿ\ÃÆºÿ\ÆÆ¾ÿ\ÄÄ»ÿ\ÂÄ¸ÿÀÃ´ÿ°²žÿ›Ÿ‰ÿcsmÿ:iÿ<|ÿ	<~ÿ	<}ÿ	;|ÿ:wÿ\Z1Rÿy€…ÿº¿¾ÿñôóÿ\ï\ï\ìÿ\Î\Í\Ëÿ\ÊÊ¿ÿ\Í\Ï\Èÿòõòÿ\ç\Û\Óÿ\ÏsBÿÿy7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿy6ÿó|;ÿŸxfÿ…`Nÿõ|Aÿÿ{5ÿÿz6ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿø|<ÿÛ¯’ÿóòðÿóóóÿóóóÿóóóÿòò\íÿ´±§ÿôóñÿ\Õ\Ø\Óÿ\ß\à\Úÿ\É\É\Èÿóóòÿóóóÿ\á\á\áÿ\Ú\Ú\Úÿóóóÿóóóÿóóóÿóóóÿóóóÿôóóÿ\Ù\Ú\Õÿ~…{ÿ$5ÿ\'Qÿ9oÿ	;|ÿ:zÿ;|ÿ7nÿ‘¡ÿµ¬¡ÿ\ÒÁ½ÿ\ÒÁ¿ÿÃµ°ÿ“†‚ÿbJ@ÿzUBÿfK3ÿ‰Šhÿ›¨|ÿ—¥xÿ•¤vÿ˜§yÿ–¦zÿ–¥yÿ˜¦xÿ™¨yÿ˜¦xÿ—¥yÿ•£xÿ›©}ÿ›©{ÿ™¨yÿ™§zÿ™§{ÿ\Ò\Õ\Óÿ\Ò\Ô\Óÿ\Ò\Ô\Õÿ\Ò\Ô\Õÿ\Ï\Ñ\Ñÿ\Ì\Ï\Ìÿ\È\Ë\Æÿ\È\Ë\Âÿ\Ê\Ì\Âÿ\É\ËÁÿ\ÆË¿ÿ\ÈÊ¿ÿ\ÈÊ¿ÿ\ÈÊ¼ÿ\ÇËºÿ\ÆÉ¸ÿ\ÄÈ¶ÿ\ÄÈ¶ÿ\ÅÇ»ÿ\ÆÇ¾ÿ\ÃÄ»ÿ\ÂÃ¹ÿÁÃµÿ¯³ ÿs‚zÿ<`ÿ\n<|ÿ	<~ÿ	<}ÿ;}ÿ;|ÿ	<|ÿ1fÿ9ÿŠ”šÿðôóÿ\î\î\ëÿ\Ì\Ì\Éÿ\ÅÃµÿ\Ñ\Ó\Íÿóôòÿ\â\Õ\Ëÿ\ÒrBÿÿz7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿy6ÿ\ìz9ÿ‹lZÿ–oZÿö|=ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿö{=ÿÝ´™ÿôóòÿóóóÿóóóÿóôóÿóó\ïÿµ´«ÿóòðÿ\Ü\Û\Ùÿ\Ó\Ò\Íÿ\È\È\Èÿóóõÿóóóÿ\ë\ë\ëÿ\Ï\Ï\Ïÿóóóÿóóóÿóóôÿóóóÿôóóÿ\æ\è\èÿ4AIÿ	 7ÿ\"Iÿ5kÿ	;{ÿ:rÿNdzÿ!0Iÿ5EaÿŸš–ÿ\ÐÁºÿ\ÒÂ½ÿ¿®­ÿ­žšÿµ¥¢ÿ~irÿtR@ÿxS<ÿ{sRÿŸ©ÿš§zÿ™§xÿŸ­}ÿœ«~ÿœªÿš¨{ÿ«{ÿœ©zÿ›©|ÿ™§{ÿ ®€ÿ ®ÿ¡­ÿ ¬ÿ ¬ÿ\Ò\Õ\Óÿ\Ò\Ô\Óÿ\Ó\Ô\Öÿ\Ò\Ò\Ôÿ\Ò\Ò\Òÿ\Í\Ï\Îÿ\Ë\Î\Éÿ\Ê\Î\Ãÿ\Ê\Í\Âÿ\ÆÊ¿ÿ\ÅÊ¾ÿ\Ç\ËÀÿ\Ê\ÌÁÿ\ÉË½ÿ\ÇÊ»ÿ\ÄÈ¸ÿ\ÅÉ¸ÿ\ÆÈ¹ÿ\ÆÈ»ÿ\ÅÈ¾ÿ\ÃÅ¼ÿ\ÂÂ·ÿÀÃ¶ÿ˜£›ÿ@\\ÿ\n<yÿ	<}ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ<|ÿ\n9wÿ\'Tÿ,7Oÿ\ã\ç\éÿ\ê\ê\çÿ\Ì\Ì\Æÿ¾»«ÿ\Ù\Ù\Òÿóôòÿ\á\Ô\Éÿ\ÔsCÿÿz7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿ\èw9ÿ˜{nÿ¦zeÿù{;ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿõ{>ÿÝ·ÿóóñÿóóóÿóóóÿóóóÿôóñÿ³³©ÿòñ\ïÿ\ä\ã\áÿ\Ë\ÉÁÿ\Æ\È\Äÿñòòÿóóóÿòòòÿ\Ë\Ë\Ëÿóóóÿóóôÿóóõÿóôñÿ\æ\é\êÿfp{ÿ ;ÿ!Iÿ3iÿ\n;{ÿ	9yÿ/Nÿ`L>ÿvS>ÿmWIÿ¦˜’ÿ\ÏÁ¹ÿÄ³¯ÿÄµ³ÿ\Ó\Ä\Âÿª¢–ÿ”‰ƒÿnRMÿ}UAÿlV7ÿ¡¤|ÿŸ«~ÿ©|ÿ¥®‚ÿ ®ÿ ®ÿŸ¬ÿŸ©}ÿŸ©|ÿ¤¯€ÿŸª}ÿ¦±€ÿ§²‚ÿ¥¯€ÿ¦¯€ÿ¥¯ÿ\Ó\Ö\Ôÿ\Ò\Ô\Óÿ\Ò\Ó\Õÿ\Ò\Ò\Ôÿ\Ñ\Ñ\Óÿ\Í\Ï\Îÿ\Ì\Ð\Ëÿ\Ë\Î\Åÿ\Ë\Î\Ãÿ\Ç\ËÀÿ\ÅÊ¾ÿ\Æ\ËÀÿ\É\ËÀÿ\ÉË¾ÿ\ÆÈºÿ\ÄÆ¹ÿ\ÆÉºÿ\ÇÉ»ÿ\ÇÉ½ÿ\ÆÇ¿ÿ\ÄÅ¾ÿÀÂ·ÿ°¸®ÿ6Riÿ=wÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ;|ÿ<{ÿ<{ÿ\n6pÿEÿW`uÿ\Ü\á\ãÿ\ÈÈ¿ÿ¸µ¥ÿ\Þ\Þ\Õÿóôòÿ\å\Ù\Ïÿ\ÔuEÿÿy7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿ\áu:ÿ¤‰~ÿbKÿù|;ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿÿy6ÿõ|>ÿã½£ÿòóðÿóóóÿóóóÿóóóÿôóòÿ½¼´ÿòó\ïÿ\í\î\êÿ\ÇÅ¼ÿ\É\Ê\Æÿ\ì\î\íÿóóóÿóóòÿ\È\È\Èÿóóóÿóóóÿñóòÿš¡¢ÿ(4?ÿ1ÿ!Fÿ	1eÿ;yÿ\n;{ÿ6nÿ63>ÿzTCÿ~S>ÿzUBÿ˜„}ÿ\ÐÂ¹ÿ³¤ÿÃ¼²ÿ¦œÿ¢™Šÿž’yÿd]ÿvO=ÿwS9ÿŠ†aÿ¢­€ÿ «~ÿ§°‚ÿ¥±€ÿ¦±ÿ¤­ÿ¡«~ÿ¡ª~ÿ¥¯ÿ¢­}ÿ¨²‚ÿ«¶…ÿ¢­ÿ¥°ÿ¤®~ÿ\Ó\Ö\Õÿ\Ò\Õ\Ôÿ\Ò\Ô\Õÿ\Ò\Ó\Õÿ\Ð\Ò\Ôÿ\Î\Ñ\Ðÿ\Ì\Ð\Íÿ\Ì\Î\Éÿ\Ì\Í\Æÿ\É\Ë\Ãÿ\Æ\ÊÁÿ\Ç\ÊÀÿ\É\ËÁÿ\ÉË¿ÿ\ÆÈ»ÿ\ÄÇ¹ÿ\ÄÆ¹ÿ\ÅÇ»ÿ\ÇÉ½ÿ\Æ\ÈÀÿ\ÃÄ¾ÿ½Á¹ÿReqÿ;pÿ\n<}ÿ	<}ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ;|ÿ<{ÿ;{ÿ	:|ÿ2kÿ<ÿ3APÿ¾¿¼ÿ¶²¢ÿ\â\á\Ùÿóôòÿ\é\ß\Õÿ\ÓuFÿÿz7ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿ{7ÿ\Ýr8ÿ’xoÿ™kTÿù|;ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿy6ÿö|?ÿàº¡ÿòóðÿóóóÿóóóÿóóóÿôóòÿ\È\È\Âÿòó\ïÿðñ\îÿ\Í\ÊÁÿ\Ø\×\Òÿ\â\å\âÿóôòÿóôðÿ\Æ\Ç\Çÿòôóÿðñóÿ›£§ÿ!0ÿ3ÿ Dÿ	/aÿ;zÿ;|ÿ	:{ÿ	,]ÿ3+/ÿxSAÿ~S>ÿzU?ÿ‡ndÿ\ÐÁ¼ÿ®Ÿœÿ®£¡ÿ\ÏÁ»ÿÌ½¹ÿ’}ÿy\\ÿuUEÿ}T=ÿq^?ÿ§«ƒÿ¡ªÿ§®‚ÿ¨²‚ÿª´„ÿ¤®ÿ£®€ÿ ©~ÿ¢­ÿ¤®ÿ§²ÿ¨³‚ÿŸ¬~ÿ¢¯€ÿ¤®€ÿ\Õ\Ø\Õÿ\Ó\×\Ôÿ\Ó\Ó\Õÿ\Ò\Ò\Õÿ\Ò\Ò\Õÿ\Ï\Ï\Ñÿ\Í\Ï\Ïÿ\Í\Î\Êÿ\Ì\Î\Èÿ\Ê\Ë\Ãÿ\È\Ë\Ãÿ\É\Ë\Ãÿ\Ê\Ë\Ãÿ\É\ËÀÿ\ÇÉ½ÿ\ÅÈ¼ÿ\ÆÈ¼ÿ\ÅÈ¼ÿ\ÆÉ½ÿ\ÅÇ¾ÿ\ÂÅ½ÿÿ9gÿ\n<}ÿ	<}ÿ<|ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ;|ÿ;|ÿ;|ÿ;|ÿ\n:yÿ,]ÿ7ÿ¦­°ÿ¸¶§ÿ\æ\ã\Üÿñôñÿð\è\ßÿ\ÐyJÿþ{6ÿÿ{6ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿ\ßq7ÿ¡†}ÿªyfÿù|;ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿö{>ÿ×±˜ÿóòñÿóóóÿóóóÿóóóÿóóóÿ\Þ\ß\Ùÿóôðÿóóðÿ\×\Õ\Èÿ\å\ã\Ûÿ\Õ\Ö\Ôÿóôòÿóôðÿ\Ü\Þ\âÿ\Ë\Ð\Öÿox…ÿ!8ÿ\Z5ÿAÿ	-]ÿ:wÿ;|ÿ;|ÿ;|ÿ	2cÿ(%.ÿiH9ÿ~T>ÿ}U=ÿ‚dSÿ\ÑÁ»ÿ¨™”ÿªœ—ÿ\ÒÂ½ÿ\ÐÂ»ÿ¦š™ÿ‡‰„ÿsiTÿxQ@ÿsQ8ÿ™˜sÿ¢«ÿ¨²„ÿ¨²…ÿ§±„ÿ¢®ÿ¥±ƒÿŸª}ÿž«}ÿ¢­ÿ¨³‚ÿ¤¯€ÿ¢¬ÿ¤°ÿ¢¯~ÿ\Ó\×\Óÿ\Ó\Ö\Ôÿ\Ô\Ô\Õÿ\Ó\Ó\Öÿ\Ó\Ó\Öÿ\Ð\Ð\Óÿ\Ï\Ï\Ðÿ\Ð\Ñ\Îÿ\Í\Ð\Éÿ\Ê\Í\Äÿ\É\Í\Åÿ\Ê\Ë\Äÿ\É\Ê\Ãÿ\ÈÊ¿ÿ\ÆÉ¾ÿ\ÇÉ¾ÿ\ÇÊ¾ÿ\ÅÈ½ÿ\ÆÉ¾ÿ\Ä\ÆÀÿ­´°ÿ Bdÿ\n={ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ	;|ÿ	;}ÿ	;|ÿ:uÿ%Pÿ!7Qÿ–›™ÿ\â\á\Üÿðõñÿö\ï\êÿ\ÉzNÿþz8ÿÿz7ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿ\ás:ÿ›€wÿ—fVÿù{<ÿÿz7ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿy6ÿ÷|?ÿÕ­•ÿóòòÿóóóÿóóóÿóóóÿóóóÿ\ïñ\íÿóôòÿôôðÿ\Ø\Õ\Æÿ\î\ë\áÿ\È\È\Èÿòôóÿñô\ïÿ°¸·ÿ):ÿ	:ÿ\Z9ÿBÿ.\\ÿ9uÿ;|ÿ;|ÿ;|ÿ;|ÿ\n9sÿ#;ÿT<0ÿ~T>ÿS>ÿsP<ÿÂ°¦ÿ£–‘ÿ­ž˜ÿ\ÒÂ¼ÿ\ÒÂ¼ÿÉ¹®ÿ|zÿ‰yÿmOAÿsO9ÿwiJÿª®„ÿª´…ÿª´†ÿ§°„ÿ¤­ÿ¦¯ƒÿ ¬~ÿŸ¬ÿ¢¯ƒÿ¨³„ÿ£­€ÿ¡¬ÿ¤¯ƒÿ¢¯€ÿ\Ó\Ö\Ôÿ\Ô\Ö\Õÿ\Ô\Ô\Öÿ\Ô\Ô\×ÿ\Õ\Õ\×ÿ\Ó\Ó\Õÿ\Ï\Ï\Ñÿ\Ò\Ò\Ñÿ\Ï\Ò\Êÿ\Ì\Î\Æÿ\Ê\Ì\Æÿ\Ç\Ê\Åÿ\É\Ê\Ãÿ\È\ÊÀÿ\ÆÉ½ÿ\ÆÉ¾ÿ\ÇÉ¾ÿ\ÆÈ½ÿ\ÅÈ¾ÿ\Ã\ÆÁÿVj|ÿ:vÿ	=}ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ<|ÿ	<}ÿ\n;}ÿ	<|ÿ2lÿ+Zÿ+Hÿ¯³·ÿðóñÿøò\îÿË…`ÿý{9ÿÿz7ÿÿx6ÿÿx6ÿÿx6ÿÿy6ÿ\åu<ÿœvÿšp]ÿù{=ÿÿ{5ÿÿz6ÿÿz6ÿÿy6ÿÿz6ÿÿz6ÿÿy6ÿø|?ÿÔªÿóòòÿóóóÿóôòÿóóóÿóóôÿôôôÿóôòÿóôñÿ\×\Ô\Äÿ\ì\ê\ÝÿÁ\ÃÁÿ\ïôòÿ\Ï\Õ\Öÿ&6Fÿ @ÿ\Z:ÿ Dÿ\n1bÿ\r:wÿ	;|ÿ;|ÿ;|ÿ;|ÿ<|ÿ<yÿ*Mÿ@/,ÿ{S?ÿS=ÿ{S?ÿ¥ƒÿœ‰ÿ°¢ÿÆº´ÿ‹ÿ\ÐÂ½ÿ“Š„ÿ“Œ‚ÿlWJÿU:,ÿ`I3ÿ¦¦|ÿ­µ‡ÿ¬´ˆÿª³‡ÿ¦¯ƒÿ§°„ÿ¥¯‚ÿ¤®‚ÿ¥¯ƒÿ¦°„ÿ¤®‚ÿ¡®ÿ¤¯‚ÿ¢¯‚ÿ\Ô\×\Öÿ\Ô\Ö\Õÿ\Ó\Ô\Öÿ\Ö\Ö\Øÿ\Ô\Ô\×ÿ\Ó\Ó\×ÿ\Ñ\Ñ\Ôÿ\Ó\Ó\Ôÿ\Ñ\Ò\Ïÿ\Ï\Ð\Ìÿ\Ë\Í\Êÿ\É\Ë\Èÿ\É\Ê\Åÿ\Ç\ÉÁÿ\ÅÈ¾ÿ\ÆÉ¾ÿ\È\ÊÀÿ\ÇÉ½ÿ\ÄÆ¼ÿ¤­¬ÿ=iÿ\n<|ÿ	=|ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ;|ÿ	;|ÿ<|ÿ\n;yÿ1lÿ	0cÿ0C^ÿ\Þ\å\èÿòó\ëÿÏ™zÿú{9ÿÿz6ÿÿy6ÿÿy6ÿÿy6ÿÿy6ÿ\çu<ÿ¬‡ÿ¤}kÿö}>ÿÿ{5ÿÿz5ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿù{>ÿÔ¦Œÿòòòÿóóóÿóôòÿôôòÿóôóÿóóóÿóôòÿóôñÿ\Ù\Õ\Åÿ\à\Ý\Ðÿ†ŽÿŒ˜¢ÿ\"2Hÿ>ÿ:ÿ\"Hÿ5kÿ;yÿ	:|ÿ;|ÿ;|ÿ;|ÿ;|ÿ;|ÿ<|ÿ4dÿ/)0ÿlJ:ÿ€S?ÿ~S?ÿeUÿ¦“Œÿ©š—ÿ½±¬ÿ‹‚yÿ\ÎÂ·ÿŸ”Œÿ¦™–ÿymgÿ^E1ÿlM6ÿˆ^ÿ­³‰ÿ¬³ˆÿ©³†ÿ¨±…ÿ«´‡ÿ©²ƒÿ¨²…ÿ¦¯ƒÿ¦¯ƒÿ¥¯ƒÿ¡®ÿ¢¯‚ÿ£¯‚ÿ\Ó\×\Óÿ\Ô\×\Õÿ\Ô\Õ\×ÿ\Ö\Õ\Øÿ\Ó\Ó\Øÿ\Ó\Ó\Øÿ\Ñ\Ñ\Öÿ\Ô\Ô\Ôÿ\Ó\Ó\Òÿ\Ñ\Ò\Ðÿ\Ì\Î\Ìÿ\È\Ë\Èÿ\É\Ë\Çÿ\Ç\É\Âÿ\Æ\ÈÁÿ\Ç\ÉÀÿ\É\ÊÁÿ\É\ËÀÿ\ÄÉ¾ÿawƒÿ<uÿ\n;}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	;}ÿ;|ÿ	<}ÿ\n<|ÿ8vÿ\n:xÿ1dÿJ]uÿ\ß\ã\ãÿÕ¬’ÿö}<ÿÿz5ÿÿy6ÿÿz6ÿÿz6ÿÿz7ÿ\ëv=ÿ“sjÿ†cRÿó~>ÿÿ{5ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿû|9ÿÒžÿôóðÿóóóÿóôñÿõò\ìÿ\î\ê\åÿ\ï\í\åÿ\í\í\åÿ\Ö\Ù\Ðÿ®±£ÿx}ÿ\"6ÿ ?ÿ>ÿ<ÿ%Nÿ7pÿ\n:{ÿ;|ÿ;|ÿ;|ÿ;|ÿ;|ÿ;|ÿ;|ÿ;|ÿ9uÿ \'=ÿY<3ÿ~SBÿ€R@ÿvT>ÿ“€sÿ£•“ÿÈ¸µÿˆ}vÿÈ¼¸ÿœŒÿ¡š˜ÿ“‰ÿkRBÿ}UAÿs`Cÿ¬¯‡ÿ¬´Šÿ¬µ‰ÿ«²‡ÿ¬³…ÿ«³…ÿ©³†ÿ§°„ÿ§±„ÿ§°„ÿ§°„ÿ¥¯ƒÿ£¯ƒÿ\Ò\Ö\Óÿ\Ó\Ö\Ôÿ\Ô\Ö\×ÿ\Ö\Ö\Ùÿ\Ô\Õ\Ùÿ\Ô\Ô\Úÿ\Ó\Ñ\Øÿ\Ô\Ô\Öÿ\Ò\Ò\Ôÿ\Ñ\Ñ\Ñÿ\Î\Ð\Îÿ\É\Ì\Éÿ\Ê\Ì\Èÿ\É\Ê\Äÿ\É\Ê\Ãÿ\É\Ê\Ãÿ\Ç\É\Âÿ\È\ÉÀÿ¿Å¿ÿ/Llÿ<|ÿ\n;~ÿ	<}ÿ	<}ÿ;|ÿ	<}ÿ\n;}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ\n;}ÿ	;}ÿ	<}ÿ	;}ÿ	;}ÿ<{ÿ0eÿ)@\\ÿj^Zÿ\ÚxEÿþy6ÿÿz6ÿÿz5ÿÿ{5ÿÿz7ÿò|<ÿ–scÿmUFÿò€Cÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿÿ{6ÿþ|9ÿËŽmÿöó\îÿôôðÿñð\ìÿ\Ú\Ö\Åÿ\ËÇ¯ÿÁÁ­ÿ‚‡ÿ,9ÿ\r!6ÿ<ÿ Aÿ Cÿ\"Mÿ	.`ÿ\r8tÿ\n;|ÿ	;|ÿ;|ÿ	<}ÿ;|ÿ;|ÿ;|ÿ	;|ÿ	;|ÿ	:|ÿ;{ÿ+PÿD/-ÿ|QAÿ€S?ÿqJ0ÿmUOÿ‡„ÿË»³ÿ“€zÿ®Ÿœÿ™“‘ÿ« ÿ¢”•ÿe[ÿ}SAÿpQ7ÿ œyÿ­µŒÿ­¶‹ÿ¯¶Œÿ®µŠÿ¬´Šÿ¬´‰ÿ¨²†ÿ¨±…ÿ©³‡ÿ¨²†ÿ¦²†ÿ¥°…ÿ\Ô\×\Ôÿ\Ò\Ô\Óÿ\Ó\Ô\Öÿ\Ö\Ö\Øÿ\Õ\Õ\Ùÿ\Ö\Ó\Úÿ\Ö\Ò\Úÿ\Ô\Ó\×ÿ\Ñ\Ñ\Óÿ\Ñ\Ñ\Òÿ\Ð\Ð\Ðÿ\Ë\Ë\Ëÿ\Ë\Ì\Êÿ\Ë\Ì\Æÿ\Ë\Ì\Çÿ\É\Ê\Åÿ\Æ\È\Âÿ\Å\ÇÀÿ£¬°ÿ:fÿ<~ÿ\n<~ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ\n;}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ	<}ÿ\n;}ÿ	<}ÿ\n;}ÿ	<}ÿ	<}ÿ	;}ÿ\n;}ÿ<{ÿ0dÿ7ÿƒ?!ÿðr5ÿþz8ÿÿz5ÿþz3ÿþy6ÿõ}Bÿ}TMÿzpÿ\ê~Cÿÿz6ÿÿz7ÿÿy6ÿÿz6ÿÿz6ÿÿz6ÿÿz6ÿüy7ÿ¾{Tÿ\ç\Þ\Öÿ\é\ä\Øÿ\ÉÅ¹ÿX^Tÿ&.7ÿ%7ÿ<ÿ=ÿ ?ÿ Eÿ%Nÿ\n._ÿ\r7sÿ	;{ÿ\n;ÿ	<~ÿ\n;}ÿ;|ÿ	<}ÿ;|ÿ	<}ÿ;|ÿ\n;}ÿ\n;}ÿ\n:|ÿ	;|ÿ4cÿ1*1ÿhK>ÿ{S?ÿsY>ÿdTPÿ‚€ÿ­¤¦ÿ©£—ÿš‘‚ÿ½½µÿ¡ž“ÿ±©£ÿŽtÿwSEÿ~UCÿ‚vaÿ¬±ÿ¯¶Žÿ®µÿ®µŽÿ¬²Œÿ¬´ÿ©±‹ÿ¨°‹ÿ©³‹ÿ¨²Šÿ£¯ˆÿ¢®‡x',0,0,0,'dsadsa','dsadsa','',0,1,'','34223432',0,1,1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_notasfaltas`
--

DROP TABLE IF EXISTS `aluno_notasfaltas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno_notasfaltas` (
  `Aluno_ID` int(11) NOT NULL,
  `notasFaltas_ID` int(11) NOT NULL,
  PRIMARY KEY (`Aluno_ID`,`notasFaltas_ID`),
  KEY `FK_ALUNO_NOTASFALTAS_notasFaltas_ID` (`notasFaltas_ID`),
  CONSTRAINT `FK_ALUNO_NOTASFALTAS_Aluno_ID` FOREIGN KEY (`Aluno_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_ALUNO_NOTASFALTAS_notasFaltas_ID` FOREIGN KEY (`notasFaltas_ID`) REFERENCES `notasfaltas` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_notasfaltas`
--

LOCK TABLES `aluno_notasfaltas` WRITE;
/*!40000 ALTER TABLE `aluno_notasfaltas` DISABLE KEYS */;
INSERT INTO `aluno_notasfaltas` VALUES (122,1),(122,2),(122,3),(122,4),(122,5),(122,6),(122,7),(122,8),(123,9),(123,10),(123,11),(123,12),(123,13),(123,14),(123,15),(123,16);
/*!40000 ALTER TABLE `aluno_notasfaltas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificado` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATACURSO` date DEFAULT NULL,
  `INSTITUICAO` varchar(255) DEFAULT NULL,
  `NOMECURSO` varchar(255) DEFAULT NULL,
  `PONTOS` int(11) DEFAULT NULL,
  `PROFESSOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CERTIFICADO_PROFESSOR_ID` (`PROFESSOR_ID`),
  CONSTRAINT `FK_CERTIFICADO_PROFESSOR_ID` FOREIGN KEY (`PROFESSOR_ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificado`
--

LOCK TABLES `certificado` WRITE;
/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BAIRRO` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (1,'Baiasd','Rua','EMEB Suleide');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola_telefone`
--

DROP TABLE IF EXISTS `escola_telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola_telefone` (
  `Escola_ID` int(11) NOT NULL,
  `telefones_ID` int(11) NOT NULL,
  PRIMARY KEY (`Escola_ID`,`telefones_ID`),
  KEY `FK_ESCOLA_TELEFONE_telefones_ID` (`telefones_ID`),
  CONSTRAINT `FK_ESCOLA_TELEFONE_Escola_ID` FOREIGN KEY (`Escola_ID`) REFERENCES `escola` (`ID`),
  CONSTRAINT `FK_ESCOLA_TELEFONE_telefones_ID` FOREIGN KEY (`telefones_ID`) REFERENCES `telefone` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola_telefone`
--

LOCK TABLES `escola_telefone` WRITE;
/*!40000 ALTER TABLE `escola_telefone` DISABLE KEYS */;
INSERT INTO `escola_telefone` VALUES (1,1);
/*!40000 ALTER TABLE `escola_telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `ID` int(11) NOT NULL,
  `ACESSO` int(11) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `CPF` varchar(15) DEFAULT NULL,
  `dataAdmissao` date NOT NULL,
  `POSSUIDEFICIENCIA` tinyint(1) DEFAULT '0',
  `SENHA` varchar(255) DEFAULT NULL,
  `USRNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_FUNCIONARIO_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,0,'Errado','458.872.588-29','2011-11-11',0,'ped','ped'),(12,0,'Professor PEB I','218.362.340-31','2011-11-11',0,'p2','p2'),(56,0,'Professor PEB I','192.393.350-72','2011-11-11',0,'p1','p1'),(57,0,'Professor PEB I','812.547.380-70','2011-11-11',0,'p3','p3'),(58,0,'Professor PEB I','929.707.120-16','2011-11-11',0,'p4','p4'),(59,0,'Professor PEB II','429.605.100-89','2011-11-11',0,'pa','pa'),(60,0,'Professor PEB II','359.509.848-03','2011-11-11',0,'pingles','pingles'),(85,3,'Desenvolvedor','418.000.698-71','2012-07-02',0,'dev','dev'),(96,0,'Professor PEB II','436.598.858-19','2012-11-11',0,'antonio','antCarlos'),(97,0,'Professor PEB II','482.935.978-10','2011-11-11',0,'laug','laug'),(98,0,'Professor PEB II','434.846.898-20','2011-11-11',0,'jben','jben'),(100,0,'Assistente Administrativo','742.361.838-11','2011-11-11',0,'',''),(101,0,'Professor PEB I','634.403.418-10','2011-11-11',0,'lucca','lucca'),(102,0,'Agente Administrativo','272.643.558-02','2011-11-11',0,'jairm','jairm'),(103,1,'Professor PEB II','936.267.418-18','2000-01-12',0,'gaara','GAARA'),(104,1,'Agente administrativo','808.269.188-32','2011-11-11',0,'josias','josias'),(105,0,'Professor PEB II','455.667.788-28','2006-06-06',0,'ped2','ped2'),(106,0,'Professor PEB I','890.203.498-48','2007-06-12',0,'jon','jon'),(108,0,'Professor PEB I','886.460.978-46','1999-06-14',0,'lauro','lauro'),(110,0,'Professor PEB II','543.725.268-49','2007-07-01',0,'marcos','marcos'),(111,0,'Agente Administrativo','161.258.748-85','2008-12-01',0,'jennifer','jennifer'),(112,1,'Agente administrativo','056.233.798-93','1998-04-11',0,'carminha','carminha'),(121,0,'ADI','898.289.590-62','2018-11-12',0,'','');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notasfaltas`
--

DROP TABLE IF EXISTS `notasfaltas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notasfaltas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ANO` varchar(255) DEFAULT NULL,
  `FALTAS` varchar(255) DEFAULT NULL,
  `MATERIA` varchar(255) DEFAULT NULL,
  `NOTA1` varchar(255) DEFAULT NULL,
  `NOTA2` varchar(255) DEFAULT NULL,
  `NOTA3` varchar(255) DEFAULT NULL,
  `NOTA4` varchar(255) DEFAULT NULL,
  `SITUACAO` varchar(255) DEFAULT NULL,
  `ALUNO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NOTASFALTAS_ALUNO_ID` (`ALUNO_ID`),
  CONSTRAINT `FK_NOTASFALTAS_ALUNO_ID` FOREIGN KEY (`ALUNO_ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notasfaltas`
--

LOCK TABLES `notasfaltas` WRITE;
/*!40000 ALTER TABLE `notasfaltas` DISABLE KEYS */;
INSERT INTO `notasfaltas` VALUES (1,'2018',NULL,'MatemÃ¡tica',NULL,NULL,NULL,NULL,'Reprovado',NULL),(2,'2018',NULL,'InglÃªs',NULL,NULL,NULL,NULL,'Reprovado',NULL),(3,'2018',NULL,'HistÃ³ria',NULL,NULL,NULL,NULL,'Reprovado',NULL),(4,'2018',NULL,'Artes',NULL,NULL,NULL,NULL,'Reprovado',NULL),(5,'2018',NULL,'EducaÃ§Ã£o FÃ­sica',NULL,NULL,NULL,NULL,'Reprovado',NULL),(6,'2018',NULL,'Geografia',NULL,NULL,NULL,NULL,'Reprovado',NULL),(7,'2018',NULL,'CiÃªncias',NULL,NULL,NULL,NULL,'Reprovado',NULL),(8,'2018',NULL,'PortuguÃªs',NULL,NULL,NULL,NULL,'Reprovado',NULL),(9,'2018',NULL,'MatemÃ¡tica',NULL,NULL,NULL,NULL,'Reprovado',NULL),(10,'2018',NULL,'Geografia',NULL,NULL,NULL,NULL,'Reprovado',NULL),(11,'2018',NULL,'EducaÃ§Ã£o FÃ­sica',NULL,NULL,NULL,NULL,'Reprovado',NULL),(12,'2018',NULL,'PortuguÃªs',NULL,NULL,NULL,NULL,'Reprovado',NULL),(13,'2018',NULL,'Artes',NULL,NULL,NULL,NULL,'Reprovado',NULL),(14,'2018',NULL,'InglÃªs',NULL,NULL,NULL,NULL,'Reprovado',NULL),(15,'2018',NULL,'HistÃ³ria',NULL,NULL,NULL,NULL,'Reprovado',NULL),(16,'2018',NULL,'CiÃªncias',NULL,NULL,NULL,NULL,'Reprovado',NULL);
/*!40000 ALTER TABLE `notasfaltas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outrocargo`
--

DROP TABLE IF EXISTS `outrocargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outrocargo` (
  `ID` int(11) NOT NULL,
  `escola_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_OUTROCARGO_escola_id` (`escola_id`),
  CONSTRAINT `FK_OUTROCARGO_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_OUTROCARGO_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outrocargo`
--

LOCK TABLES `outrocargo` WRITE;
/*!40000 ALTER TABLE `outrocargo` DISABLE KEYS */;
INSERT INTO `outrocargo` VALUES (102,NULL),(104,NULL),(111,NULL),(1,1),(85,1),(100,1),(112,1),(121,1);
/*!40000 ALTER TABLE `outrocargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(31) DEFAULT NULL,
  `BAIRRO` varchar(255) DEFAULT NULL,
  `CEP` varchar(255) DEFAULT NULL,
  `CIDADE` varchar(255) NOT NULL,
  `DATANASC` date DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `GENERO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) NOT NULL,
  `OBSERVACOES` varchar(255) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'OutroCargo','b','11111-111','c','1998-11-12','rua','Masculino','Prof EducaÃ§Ã£o FÃ­sica','',0),(12,'ProfessorPebI','bairro tal','11333-333','AvarÃ©','1976-11-07','Rua tal','Feminino','Professor PEB I 2','',1),(56,'ProfessorPebI','Bairro tal','21283-223','AvarÃ©','1966-05-04','Rua tal','Feminino','Professor PEB I 1','',1),(57,'ProfessorPebI','Bairro tal','18503-333','AvarÃ©','1981-01-01','Rua tal','Feminino','Professor PEB I 3','',1),(58,'ProfessorPebI','Asadas','18607-544','AvarÃ©','1991-04-14','dasads','Feminino','Professor PEB I 4','',1),(59,'ProfessorPebII','Bairro bairro','18454-334','AvarÃ©','1956-04-12','Rua rua ','Masculino','Prof Artes 1','',1),(60,'ProfessorPebII','','','','2010-10-10','','Feminino','Prof InglÃªs','',1),(85,'OutroCargo','Brabancia II','18703-530','AvarÃ©','1993-08-30','R JoÃ£o Leonor de Camargo, 1076','Masculino','Davi Evangelista da Silva','',1),(96,'ProfessorPebII','Bairro Tal','18703-640','AvarÃ©','1965-05-05','Rua  Tal','Masculino','Antonio Carlos','',1),(97,'ProfessorPebII','B','12121-212','C','1996-04-26','R','Masculino','Luiz Augusto','',1),(98,'ProfessorPebII','B','11111-111','C','1988-11-11','R','Feminino','Jurandira Benedito','',1),(100,'OutroCargo','B','12222-222','C','1992-12-12','R','Masculino','Casemiro Ruy Barbosa','',1),(101,'ProfessorPebI','B','11111-111','AvarÃ©','1955-01-01','R','Masculino','Lucca Borges','',1),(102,'OutroCargo','B','11111-111','C','1958-10-28','R','Masculino','Jair Messias','',1),(103,'ProfessorPebII','Bairro estranho','18111-111','Vila da Areia','1976-10-10','Rua estranha','Masculino','Gaara Sabakuno','',1),(104,'OutroCargo','BB','23333-333','CC','1974-12-12','RR','Masculino','Josias Nascimento Pinto','',1),(105,'ProfessorPebII','Bairro Santos Agostinho','18555-444','AvarÃ©','1993-09-08','Rua Santo Agostinho','Feminino','Prof EducaÃ§Ã£o FÃ­sica II','',1),(106,'ProfessorPebI','Brabancia II','18703-490','AvarÃ©','1959-05-11','Rua Heitor de Barros, 1032','Feminino','Jonathas','',1),(108,'ProfessorPebI','Brabancia','18704-343','AvarÃ©','1980-04-14','Rua Camilo Garcia, 3232','Masculino','Lauro Jardins da Silva Pereira','',0),(110,'ProfessorPebII','Jardim Cabide','13131-043','Ã“leo','1992-08-30','Rua Larga, 989','Masculino','Marcos Benedito','',1),(111,'OutroCargo','Jardim Paineiras','18503-322','AvarÃ©','1974-04-22','Rua CaÃ­da, 202','Feminino','Jennifer Cristina da Costa','',1),(112,'OutroCargo','Bairro bairro','18593-333','AvarÃ©','1988-04-14','Rua rua','Feminino','Carminha Romerilda','',1),(121,'OutroCargo','Itaquera','11122-121','SÃ£o Paulo','1993-09-11','Rua Itaquera','Masculino','Matheus Mathias','',1),(122,'Aluno','sdasda','11111-111','AvarÃ©','2011-11-11','dsadsa','Masculino','Kakashi Sensei','',1),(123,'Aluno','dassad','32321-321','AvarÃ©','2010-10-10','dsdsa','Masculino','sdasadas','',1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa_telefone`
--

DROP TABLE IF EXISTS `pessoa_telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa_telefone` (
  `Pessoa_ID` int(11) NOT NULL,
  `telefones_ID` int(11) NOT NULL,
  PRIMARY KEY (`Pessoa_ID`,`telefones_ID`),
  KEY `FK_PESSOA_TELEFONE_telefones_ID` (`telefones_ID`),
  CONSTRAINT `FK_PESSOA_TELEFONE_Pessoa_ID` FOREIGN KEY (`Pessoa_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_PESSOA_TELEFONE_telefones_ID` FOREIGN KEY (`telefones_ID`) REFERENCES `telefone` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_telefone`
--

LOCK TABLES `pessoa_telefone` WRITE;
/*!40000 ALTER TABLE `pessoa_telefone` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `ID` int(11) NOT NULL,
  `PONTOS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PROFESSOR_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_escola`
--

DROP TABLE IF EXISTS `professor_escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor_escola` (
  `escola_ID` int(11) NOT NULL,
  `professor_ID` int(11) NOT NULL,
  PRIMARY KEY (`escola_ID`,`professor_ID`),
  KEY `FK_PROFESSOR_ESCOLA_professor_ID` (`professor_ID`),
  CONSTRAINT `FK_PROFESSOR_ESCOLA_escola_ID` FOREIGN KEY (`escola_ID`) REFERENCES `escola` (`ID`),
  CONSTRAINT `FK_PROFESSOR_ESCOLA_professor_ID` FOREIGN KEY (`professor_ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_escola`
--

LOCK TABLES `professor_escola` WRITE;
/*!40000 ALTER TABLE `professor_escola` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor_escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professorpebi`
--

DROP TABLE IF EXISTS `professorpebi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professorpebi` (
  `ID` int(11) NOT NULL,
  `PERIODO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PROFESSORPEBI_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professorpebi`
--

LOCK TABLES `professorpebi` WRITE;
/*!40000 ALTER TABLE `professorpebi` DISABLE KEYS */;
/*!40000 ALTER TABLE `professorpebi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professorpebii`
--

DROP TABLE IF EXISTS `professorpebii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professorpebii` (
  `ID` int(11) NOT NULL,
  `AULASATRIBUIDAS` int(11) DEFAULT NULL,
  `ESPECIALIDADE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PROFESSORPEBII_ID` FOREIGN KEY (`ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professorpebii`
--

LOCK TABLES `professorpebii` WRITE;
/*!40000 ALTER TABLE `professorpebii` DISABLE KEYS */;
/*!40000 ALTER TABLE `professorpebii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professorpebii_turma`
--

DROP TABLE IF EXISTS `professorpebii_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professorpebii_turma` (
  `turmas_ID` int(11) NOT NULL,
  `profPebII_ID` int(11) NOT NULL,
  PRIMARY KEY (`turmas_ID`,`profPebII_ID`),
  KEY `FK_PROFESSORPEBII_TURMA_profPebII_ID` (`profPebII_ID`),
  CONSTRAINT `FK_PROFESSORPEBII_TURMA_profPebII_ID` FOREIGN KEY (`profPebII_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_PROFESSORPEBII_TURMA_turmas_ID` FOREIGN KEY (`turmas_ID`) REFERENCES `turma` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professorpebii_turma`
--

LOCK TABLES `professorpebii_turma` WRITE;
/*!40000 ALTER TABLE `professorpebii_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `professorpebii_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefone` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` VALUES (1,'1437334306');
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferencia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ALUNO_ID` int(11) DEFAULT NULL,
  `ESCOLA_ID` int(11) DEFAULT NULL,
  `FUNCIONARIO_ID` int(11) DEFAULT NULL,
  `TURMA_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRANSFERENCIA_ALUNO_ID` (`ALUNO_ID`),
  KEY `FK_TRANSFERENCIA_ESCOLA_ID` (`ESCOLA_ID`),
  KEY `FK_TRANSFERENCIA_FUNCIONARIO_ID` (`FUNCIONARIO_ID`),
  KEY `FK_TRANSFERENCIA_TURMA_ID` (`TURMA_ID`),
  CONSTRAINT `FK_TRANSFERENCIA_ALUNO_ID` FOREIGN KEY (`ALUNO_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_TRANSFERENCIA_ESCOLA_ID` FOREIGN KEY (`ESCOLA_ID`) REFERENCES `escola` (`ID`),
  CONSTRAINT `FK_TRANSFERENCIA_FUNCIONARIO_ID` FOREIGN KEY (`FUNCIONARIO_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_TRANSFERENCIA_TURMA_ID` FOREIGN KEY (`TURMA_ID`) REFERENCES `turma` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencia`
--

LOCK TABLES `transferencia` WRITE;
/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CRONOGRAMA` longblob,
  `LETRA` varchar(255) DEFAULT NULL,
  `PERIODO` varchar(255) DEFAULT NULL,
  `TURMA` varchar(255) DEFAULT NULL,
  `VAGAS` int(11) DEFAULT NULL,
  `escola_id` int(11) DEFAULT NULL,
  `PROFPEBI_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TURMA_escola_id` (`escola_id`),
  KEY `FK_TURMA_PROFPEBI_ID` (`PROFPEBI_ID`),
  CONSTRAINT `FK_TURMA_PROFPEBI_ID` FOREIGN KEY (`PROFPEBI_ID`) REFERENCES `pessoa` (`ID`),
  CONSTRAINT `FK_TURMA_escola_id` FOREIGN KEY (`escola_id`) REFERENCES `escola` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'¬\í\0ur\0[[I÷\äO‰<\0\0xp\0\0\0ur\0[IMº`&vê²¥\0\0xp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0uq\0~\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0uq\0~\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0uq\0~\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0uq\0~\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','A','ManhÃ£','2Âº Ano',25,1,NULL);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_outrocargo`
--

DROP TABLE IF EXISTS `turma_outrocargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma_outrocargo` (
  `Turma_ID` int(11) NOT NULL,
  `adi_ID` int(11) NOT NULL,
  PRIMARY KEY (`Turma_ID`,`adi_ID`),
  KEY `FK_TURMA_OUTROCARGO_adi_ID` (`adi_ID`),
  CONSTRAINT `FK_TURMA_OUTROCARGO_Turma_ID` FOREIGN KEY (`Turma_ID`) REFERENCES `turma` (`ID`),
  CONSTRAINT `FK_TURMA_OUTROCARGO_adi_ID` FOREIGN KEY (`adi_ID`) REFERENCES `pessoa` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_outrocargo`
--

LOCK TABLES `turma_outrocargo` WRITE;
/*!40000 ALTER TABLE `turma_outrocargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turma_outrocargo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-17 18:22:21
