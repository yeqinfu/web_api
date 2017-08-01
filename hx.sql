/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.5.28-log : Database - talktome
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`talktome` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `talktome`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(40) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `hxid` varchar(40) NOT NULL,
  `hxpassword` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_name`,`hxid`,`hxpassword`,`password`) values ('350ecfad-f9d7-4ba2-8807-609b85e67db5','鬼谷子','c4f70c88dd8149c3894604f02ad16b47','f93f1dd6-0d8b-4d46-9893-76577faa6568','123456'),('84bf63cf-c9bd-460a-b4df-e7992c70441d','牛奶咖啡','bc6a0c3935e54f66802fe03affd469e9','696e0f95-9a7c-4dfd-b1ac-71c9555749da','123456'),('ae0127bb-903f-4ea0-ba17-857b95dbce75','老王','17f0128800a245c8928bfc7f12370825','bb4d8635-34b3-4407-9953-942fda5685b0','123456'),('b251b037-f124-40b3-87fd-d91c590fdbca','老李','f3f5543e64b54a56a2490c87e8e82ced','d8fafa71-3c57-4727-aa07-e91e180f23bd','123456'),('b8898422-bf3b-4f54-9d8d-398fbaff993e','牛二','2308ab4677ac4ad78abcfc6a2e2122b0','ad36205c-b273-4491-8445-d4b69fbd8d48','123456'),('ea043b8d-9347-4c41-95a7-0bd0c2a2d7f1','詹姆斯','5b0a670fdffd416fa464b06e721f1208','c8d68ff3-264f-4f6d-8217-4bae0ef261bd','123456'),('edccb479-fca1-41d5-aaa7-2fb6eb8e8c8e','二妞','a497eb341bc347f0af661cdd7d9fd8f0','3f88b511-d580-485e-a350-55d0b2d30c29','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
