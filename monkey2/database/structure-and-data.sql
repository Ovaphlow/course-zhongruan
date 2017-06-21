-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zhongruan
-- ------------------------------------------------------
-- Server version	5.5.5-10.2.6-MariaDB

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(45) DEFAULT '',
  `name` varchar(100) DEFAULT '',
  `former_name` varchar(100) DEFAULT '',
  `author` varchar(100) DEFAULT '',
  `translator` varchar(100) DEFAULT '',
  `publisher` varchar(45) DEFAULT '',
  `publication_date` date DEFAULT '1000-01-01',
  `series` varchar(100) DEFAULT '',
  `language` varchar(10) DEFAULT '',
  `pages` int(11) DEFAULT 0,
  `format` varchar(10) DEFAULT '',
  `intro` text DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'9787115428028, 7115428026','Python编程 从入门到实践','Python Crash Course: A Hands-On, Project-Based Introduction to Programming','[美]埃里克·马瑟斯','袁国忠','人民邮电出版社','2016-07-01','图灵程序设计丛书','简体中文',459,'16','本书是一本针对所有层次的Python读者而作的Python入门书。全书分两部分：首部分介绍用Python 编程所必须了解的基本概念，包括matplotlib、NumPy和Pygal等强大的Python库和工具介绍，以及列表、字典、if语句、类、文件与异常、代码测试等内容；第二部分将理论付诸实践，讲解如何开发三个项目，包括简单的Python 2D游戏开发，如何利用数据生成交互式的信息图，以及创建和定制简单的Web应用，并帮读者解决常见编程问题和困惑。'),(2,'9787115275790, 7115275793','JavaScript高级程序设计(第3版)','Prefessional JavaScript for Web Developers','泽卡斯 (Zakas. Nicholas C.)','李松峰,曹力','人民邮电出版社','2012-03-01','图灵程序设计丛书','简体中文',730,'16','《JavaScript高级程序设计(第3版)》是JavaScript超级畅销书的最新版。ECMAScript 5和HTML5在标准之争中双双胜出，使大量专有实现和客户端扩展正式进入规范，同时也为JavaScript增添了很多适应未来发展的新特性。《JavaScript高级程序设计(第3版)》这一版除增加5章全新内容外，其他章节也有较大幅度的增补和修订，新内容篇幅约占三分之一。全书从JavaScript语言实现的各个组成部分——语言核心、DOM、BOM、事件模型讲起，深入浅出地探讨了面向对象编程、Ajax与Comet服务器端通信，HTML5表单、媒体、Canvas（包括WebGL）及Web Workers、地理定位、跨文档传递消息、客户端存储（包括IndexedDB）等新API，还介绍了离线应用和与维护、性能、部署相关的开发实践。《JavaScript高级程序设计(第3版)》附录展望了未来的API和ECMAScript Harmony规范。'),(3,'9787111506904','计算机科学丛书:Java语言程序设计(基础篇)(原书第10版)','Introduction to Java Programming Comprehensive Verion Teach Edition','梁勇 (Y.Daniel Liang)','戴开宇','机械工业出版社','2015-07-01','计算机科学丛书','简体中文',654,'16','本书是Java语言的经典教材，中文版分为基础篇和进阶篇，主要介绍程序设计基础、面向对象编程、GUI程序设计、数据结构和算法、高级Java程序设计等内容。本书以示例讲解解决问题的技巧，提供大量的程序清单，每章配有大量复习题和编程练习题，帮助读者掌握编程技术，并应用所学技术解决实际应用开发中遇到的问题。您手中的这本是其中的基础篇，主要介绍了基本程序设计、语法结构、面向对象程序设计、继承和多态、异常处理和文本I/O、抽象类和接口等内容。本书可作为高等院校程序设计相关专业的基础教材，也可作为Java语言及编程开发爱好者的参考资料。'),(4,'9787111255833','Sun 公司核心技术丛书:Effective Java中文版(第2版)','Effective Java','Joshua Bloch','俞黎敏','机械工业出版社','2009-01-01','Sun 公司核心技术丛书','简体中文',287,'16','《Sun 公司核心技术丛书:Effective Java中文版(第2版)》内容简介：在Java编程中78条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么，不应该做什么才能产生清晰、健壮和高效的代码。第2版反映了Java 5中最重要的变化，并删去了过时的内容。\n《Sun 公司核心技术丛书:Effective Java中文版(第2版)》中的每条规则都以简短、独立的小文章形式出现，并通过示例代码加以进一步说明。\n《Sun 公司核心技术丛书:Effective Java中文版(第2版)》的内容包括：\n全新的泛型、枚举、注解、自动装箱、fof-each循环、可变参数、并发机制，等等。\n经典主题的全新技术和实践，包括对象．类、类库、方法和序列化。\n如何避免Java编程语言中常被误解的细微之处：陷阱和缺陷。\n');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-21 22:05:10
