/*
Navicat MySQL Data Transfer

Source Server         : Tang
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ipdb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-09 15:34:55
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Table structure for `business_car_info`
-- ----------------------------
DROP TABLE IF EXISTS `business_car_info`;
CREATE TABLE `business_car_info` (
  `plate_id` varchar(8) NOT NULL,
  `business_id` int(10) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_car_info
-- ----------------------------

-- ----------------------------
-- Table structure for `business_info`
-- ----------------------------
DROP TABLE IF EXISTS `business_info`;
CREATE TABLE `business_info` (
  `business_id` int(10) NOT NULL,
  `business_name` varchar(20) NOT NULL,
  `business_tel` varchar(11) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_info
-- ----------------------------

-- ----------------------------
-- Table structure for `charge_rules`
-- ----------------------------
DROP TABLE IF EXISTS `charge_rules`;
CREATE TABLE `charge_rules` (
  `customer_type` varchar(5) NOT NULL,
  `charge_rule` int(5) NOT NULL,
  PRIMARY KEY (`customer_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_rules
-- ----------------------------

-- ----------------------------
-- Table structure for `entry_exit_records`
-- ----------------------------
DROP TABLE IF EXISTS `entry_exit_records`;
CREATE TABLE `entry_exit_records` (
  `record_id` int(10) NOT NULL,
  `plate_id` varchar(8) NOT NULL,
  `enter_time` datetime NOT NULL,
  `enter_img` longblob NOT NULL,
  `enter_port_id` int(2) NOT NULL,
  `exit_time` datetime DEFAULT NULL,
  `exit_img` longblob,
  `exit_port_id` int(2) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of entry_exit_records
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(10) NOT NULL,
  `record_id` int(10) NOT NULL,
  `pay_time` datetime NOT NULL,
  `parking_cost` int(4) NOT NULL,
  `order_state` int(2) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
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
-- Table structure for `temporary_car_info`
-- ----------------------------
DROP TABLE IF EXISTS `temporary_car_info`;
CREATE TABLE `temporary_car_info` (
  `plate_id` varchar(8) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temporary_car_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_berth_info`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_berth_info`;
CREATE TABLE `tenant_berth_info` (
  `berth_id` int(5) NOT NULL,
  `tenant_id` int(10) NOT NULL,
  `position` varchar(20) NOT NULL,
  PRIMARY KEY (`berth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_berth_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_car_info`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_car_info`;
CREATE TABLE `tenant_car_info` (
  `plate_id` varchar(8) NOT NULL,
  `tenant_id` int(10) NOT NULL,
  `car_type` varchar(4) NOT NULL,
  `car_color` varchar(4) NOT NULL,
  PRIMARY KEY (`plate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_car_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_info`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `tenant_id` int(10) NOT NULL,
  `tenant_name` varchar(20) NOT NULL,
  `tenant_tel` varchar(11) NOT NULL,
  `leasehold` int(2) NOT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tenant_order`
-- ----------------------------
DROP TABLE IF EXISTS `tenant_order`;
CREATE TABLE `tenant_order` (
  `order_id` int(10) NOT NULL,
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

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user` varchar(10) NOT NULL,
  `password` varchar(18) NOT NULL,
  `level` int(2) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
