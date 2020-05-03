/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : db_dormmanage

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-04-13 16:18:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `AdminId` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AdminId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_dorm
-- ----------------------------
DROP TABLE IF EXISTS `t_dorm`;
CREATE TABLE `t_dorm` (
  `dormId` int(11) NOT NULL AUTO_INCREMENT,
  `dormName` varchar(255) NOT NULL,
  `hygiene` varchar(255) DEFAULT NULL,
  `electric` double(255,2) DEFAULT NULL,
  PRIMARY KEY (`dormId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dorm
-- ----------------------------
INSERT INTO `t_dorm` VALUES ('1', '202', '良好', '51.26');
INSERT INTO `t_dorm` VALUES ('2', '303', '优秀', '25.34');

-- ----------------------------
-- Table structure for t_dormbuild
-- ----------------------------
DROP TABLE IF EXISTS `t_dormbuild`;
CREATE TABLE `t_dormbuild` (
  `dormBuildId` int(11) NOT NULL AUTO_INCREMENT,
  `dormBuildName` varchar(20) DEFAULT NULL,
  `dormBuildDetail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dormBuildId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dormbuild
-- ----------------------------
INSERT INTO `t_dormbuild` VALUES ('1', '1栋', '这是一栋。。。');
INSERT INTO `t_dormbuild` VALUES ('2', '2栋', '这是2栋');
INSERT INTO `t_dormbuild` VALUES ('3', '3栋', '');
INSERT INTO `t_dormbuild` VALUES ('4', '4栋', '');
INSERT INTO `t_dormbuild` VALUES ('5', '5栋', '');
INSERT INTO `t_dormbuild` VALUES ('6', '6栋', '');

-- ----------------------------
-- Table structure for t_dormmanager
-- ----------------------------
DROP TABLE IF EXISTS `t_dormmanager`;
CREATE TABLE `t_dormmanager` (
  `dormManagerId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dormBuildId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dormManagerId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dormmanager
-- ----------------------------
INSERT INTO `t_dormmanager` VALUES ('3', 'manager3', '123', '1', '小李', '女', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('4', 'manager4', '123', '5', '小陈', '男', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('5', 'manager5', '123', null, '小宋', '男', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('7', 'manager6', '123', null, '呵呵 ', '女', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('9', 'manager7', '123', '7', '哈哈', '女', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('13', 'manager1', '123', null, '小明', '女', '18212344231');
INSERT INTO `t_dormmanager` VALUES ('14', 'manager2', '123', null, 'tom', '男', '18212344231');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `dormBuildName` int(11) DEFAULT NULL,
  `dormName` varchar(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '002', '123', '李四', '4', '120', '男', '18212344231');
INSERT INTO `t_student` VALUES ('4', '004', '123', '李进', '1', '220', '女', '18212344231');
INSERT INTO `t_student` VALUES ('5', '005', '123', '赵起', '4', '220', '女', '18212344231');
INSERT INTO `t_student` VALUES ('6', '006', '123', '王珂珂', '4', '111', '女', '18212344231');
INSERT INTO `t_student` VALUES ('31', '010', '123', '小强', '4', '222', '男', '18212344231');
INSERT INTO `t_student` VALUES ('32', '003', '123', '张三', '0', '505', '男', '18212344231');
INSERT INTO `t_student` VALUES ('33', '001', '123', '小李', '0', '222', '女', '18212344231');
