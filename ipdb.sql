/*
Navicat MySQL Data Transfer

Source Server         : mysql_1
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ipdb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-11 09:08:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(18) NOT NULL,
  `level` int(2) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '0000', '0');

-- ----------------------------
-- Table structure for `blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `plate_id` varchar(8) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for `business_car`
-- ----------------------------
DROP TABLE IF EXISTS `business_car`;
CREATE TABLE `business_car` (
  `plate_id` varchar(8) NOT NULL,
  `business_id` int(10) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_car
-- ----------------------------

-- ----------------------------
-- Table structure for `business_info`
-- ----------------------------
DROP TABLE IF EXISTS `business_info`;
CREATE TABLE `business_info` (
  `business_id` int(10) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(20) NOT NULL,
  `business_tel` varchar(11) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000000002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_info
-- ----------------------------
INSERT INTO `business_info` VALUES ('30000000', 'sa', '12312435', 'sxcvxv');
INSERT INTO `business_info` VALUES ('300000000', 'dc', '12545756', 'sdfs');
INSERT INTO `business_info` VALUES ('2000000000', 'dsaffd', '234656786', null);
INSERT INTO `business_info` VALUES ('2000000001', '3545', '2334546', null);

-- ----------------------------
-- Table structure for `charge_rule`
-- ----------------------------
DROP TABLE IF EXISTS `charge_rule`;
CREATE TABLE `charge_rule` (
  `customer_type` varchar(5) NOT NULL,
  `charge_rule` int(5) NOT NULL,
  PRIMARY KEY (`customer_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_rule
-- ----------------------------

-- ----------------------------
-- Table structure for `entry_exit_record`
-- ----------------------------
DROP TABLE IF EXISTS `entry_exit_record`;
CREATE TABLE `entry_exit_record` (
  `record_id` int(10) NOT NULL AUTO_INCREMENT,
  `plate_id` varchar(8) NOT NULL,
  `enter_time` datetime NOT NULL,
  `enter_img` longblob NOT NULL,
  `enter_port_id` int(2) NOT NULL,
  `exit_time` datetime DEFAULT NULL,
  `exit_img` longblob,
  `exit_port_id` int(2) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of entry_exit_record
-- ----------------------------
INSERT INTO `entry_exit_record` VALUES ('2', '川K·123fg', '2018-04-10 18:28:41', 0x0203030303, '10', '2018-04-10 19:53:34', 0x0606060606, '11', null);

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `record_id` int(10) NOT NULL,
  `pay_time` datetime NOT NULL,
  `parking_cost` int(4) NOT NULL,
  `order_state` int(2) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `port_info`
-- ----------------------------
DROP TABLE IF EXISTS `port_info`;
CREATE TABLE `port_info` (
  `port_id` int(2) NOT NULL,
  `port_name` varchar(10) NOT NULL,
  `port_type` int(1) NOT NULL,
  `usability` int(1) NOT NULL,
  PRIMARY KEY (`port_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of port_info
-- ----------------------------

-- ----------------------------
-- Table structure for `temporary_car`
-- ----------------------------
DROP TABLE IF EXISTS `temporary_car`;
CREATE TABLE `temporary_car` (
  `plate_id` varchar(8) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temporary_car
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_berth`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_berth`;
CREATE TABLE `tenant_berth` (
  `berth_id` int(5) NOT NULL,
  `tenant_id` int(10) NOT NULL,
  `position` varchar(20) NOT NULL,
  PRIMARY KEY (`berth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_berth
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_car`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_car`;
CREATE TABLE `tenant_car` (
  `plate_id` varchar(8) NOT NULL,
  `tenant_id` int(10) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_car
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_info`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `tenant_id` int(10) NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(20) NOT NULL,
  `tenant_tel` varchar(11) NOT NULL,
  `leasehold` int(2) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES ('1000000000', 'aaa', '231553415', '1', '4445');
INSERT INTO `tenant_info` VALUES ('1000000001', 'bbb', '453562323', '1', null);

-- ----------------------------
-- Table structure for `tenant_order`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_order`;
CREATE TABLE `tenant_order` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `tenant_id` int(10) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `money` int(4) NOT NULL,
  `payment_state` int(2) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_order
-- ----------------------------
