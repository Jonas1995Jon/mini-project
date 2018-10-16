/*
Navicat MySQL Data Transfer

Source Server         : 127.0.01
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       :  demo

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-10-16 15:42:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL auto_increment,
  `area_name` varchar(200) collate utf8_unicode_ci NOT NULL,
  `priority` int(2) NOT NULL default '0',
  `create_time` datetime default NULL,
  `last_edit_time` datetime default NULL,
  PRIMARY KEY  (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('1', '东苑', '1', null, null);
INSERT INTO `tb_area` VALUES ('2', '北苑', '2', null, null);
