/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 15/10/2022 17:59:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `questionID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `optionA` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `optionB` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `optionC` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `optionD` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`questionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '2+3=？', '5', '6', '4', '10', 'A');
INSERT INTO `question` VALUES (3, '2*5=？', '14', '15', '10', '3', 'C');
INSERT INTO `question` VALUES (4, '20-8=？', '12', '6', '10', '5', 'A');
INSERT INTO `question` VALUES (5, '6*9=？', '123', '54', '67', '68', 'B');
INSERT INTO `question` VALUES (6, '30-15=？', '5', '6', '15', '3', 'C');
INSERT INTO `question` VALUES (7, '12*9=？', '108', '109', '118', '128', 'A');
INSERT INTO `question` VALUES (8, '2-2=？', '4', '0', '-2', '-4', 'B');
INSERT INTO `question` VALUES (9, '17-9=？', '5', '15', '4', '8', 'D');
INSERT INTO `question` VALUES (10, '-5+（-3）=？', '5', '2', '-8', '10', 'C');
INSERT INTO `question` VALUES (11, '22*4=？', '22', '44', '66', '88', 'D');
INSERT INTO `question` VALUES (12, '100-0=？', '10', '109', '67', '100', 'D');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (3, 'admin', '000000', '男', 'mike@123.com');
INSERT INTO `users` VALUES (19, 'admin', '123456', '男', 'admin@123.com');
INSERT INTO `users` VALUES (20, 'li', '123456', '男', 'liming@123.com');
INSERT INTO `users` VALUES (21, 'huahua', '123456', '女', 'huahua@123.com');

SET FOREIGN_KEY_CHECKS = 1;
