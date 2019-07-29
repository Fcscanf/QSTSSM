/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/07/2019 20:33:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 'class_a', 1);
INSERT INTO `class` VALUES (2, 'class_b', 2);

-- ----------------------------
-- Table structure for m_users
-- ----------------------------
DROP TABLE IF EXISTS `m_users`;
CREATE TABLE `m_users`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_users
-- ----------------------------
INSERT INTO `m_users` VALUES (1, '张三', 28);
INSERT INTO `m_users` VALUES (2, '李四', 26);
INSERT INTO `m_users` VALUES (3, 'test001', 22);
INSERT INTO `m_users` VALUES (4, 'test001', 22);
INSERT INTO `m_users` VALUES (5, 'test001', 22);
INSERT INTO `m_users` VALUES (6, 'test001', 22);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `order_price` float DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 'aaaa', 23);
INSERT INTO `orders` VALUES (2, 'bbbb', 33);
INSERT INTO `orders` VALUES (3, 'cccc', 22);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'student_A', 1);
INSERT INTO `student` VALUES (2, 'student_B', 1);
INSERT INTO `student` VALUES (3, 'student_C', 1);
INSERT INTO `student` VALUES (4, 'student_D', 2);
INSERT INTO `student` VALUES (5, 'student_E', 2);
INSERT INTO `student` VALUES (6, 'student_F', 2);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (3, '赵乾坤', '309219094@qq.com', '17826263680', '30239480');
INSERT INTO `t_student` VALUES (7, '古赛昆', '348945073@qq.com', '17837286777', '542389754');
INSERT INTO `t_student` VALUES (8, '戴维超', '918437501@qq.com', '2398743278', '945397');
INSERT INTO `t_student` VALUES (9, '龚柄瑞', '498075439@fox.com', '4879524395', '984573297');
INSERT INTO `t_student` VALUES (10, '王震', '8908435@qq.com', '17843260432', '8917955');
INSERT INTO `t_student` VALUES (11, '宋金程', '528424355@qq.com', '17749598136', '15366109706');
INSERT INTO `t_student` VALUES (12, '赵乾坤', '373020024@qq.com', '13814519076', '54382');
INSERT INTO `t_student` VALUES (15, 'ChengCheng Fan', 'fcscanf@126.com', '17826260016', '49508725234');
INSERT INTO `t_student` VALUES (16, '刘庆', 'lq@qq.com', '17824032401', '4532987543');
INSERT INTO `t_student` VALUES (17, 'Tom', 'jfkds@gmail.com', '17873443990', '99495785');
INSERT INTO `t_student` VALUES (18, 'ChengCheng Fan324432', 'fcscanf@outlook.com', '17826260016', 'er56437');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Fcant', '123456');
INSERT INTO `t_user` VALUES (2, 'Fc', '123456');
INSERT INTO `t_user` VALUES (11, 'Fcant132', '123456');
INSERT INTO `t_user` VALUES (12, 'Fcant132', '123456');
INSERT INTO `t_user` VALUES (13, 'Fcant132', '123456');
INSERT INTO `t_user` VALUES (14, 'Fcant234', '123456');
INSERT INTO `t_user` VALUES (15, 'Fcant1', '123456');
INSERT INTO `t_user` VALUES (16, 'Fcant2', '123456');
INSERT INTO `t_user` VALUES (17, 'Fcant4', '123456');
INSERT INTO `t_user` VALUES (18, 'Fcant5', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'teacher1');
INSERT INTO `teacher` VALUES (2, 'teacher2');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, '小诗', '女');
INSERT INTO `users` VALUES (3, '小月', '女');
INSERT INTO `users` VALUES (4, '小依', '女');
INSERT INTO `users` VALUES (5, '小泽', '男');
INSERT INTO `users` VALUES (6, '张起灵', '男');

SET FOREIGN_KEY_CHECKS = 1;
