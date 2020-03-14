/*
 Navicat Premium Data Transfer

 Source Server         : local5728
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mybatisplus-demo

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 02/03/2020 16:40:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
                           `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '班级名称',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='班级表';

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 id',
                             `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '姓名',
                             `age` int(10) DEFAULT NULL COMMENT '年龄',
                             `grade_id` int(11) NOT NULL COMMENT '班级 Id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL COMMENT '主键ID',
                        `name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
                        `age` int(11) DEFAULT NULL COMMENT '年龄',
                        `email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
