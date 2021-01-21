/*
 Navicat MySQL Data Transfer

 Source Server         : java_mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : simonshop

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 21/01/2021 12:25:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类别标识符',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '饮品');
INSERT INTO `t_category` VALUES (2, '甜品');
INSERT INTO `t_category` VALUES (3, '蛋糕');
INSERT INTO `t_category` VALUES (4, '冰淇淋');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单标识符',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `total_price` double NULL DEFAULT NULL COMMENT '总金额',
  `delivery_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送货地址',
  `order_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, '小明', '11231331230', 54, '佛山市禅城区', '2021-01-21 12:23:43');
INSERT INTO `t_order` VALUES (2, '小芳', '13180313123', 57, '湖北市', '2021-01-21 12:23:54');
INSERT INTO `t_order` VALUES (3, '李华', '13123129331', 207, '深圳市', '2021-01-21 12:24:11');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品标识符',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` double NULL DEFAULT NULL COMMENT '商品单价',
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `category_id` int(11) NULL DEFAULT NULL COMMENT '商品类别标识符',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, '沉香焙茶波波', 28, '2020-12-19 21:15:08', 1);
INSERT INTO `t_product` VALUES (2, '豆豆波波茶', 27, '2020-12-19 21:29:14', 1);
INSERT INTO `t_product` VALUES (3, '草莓蛋糕', 112, '2020-12-19 21:22:26', 3);
INSERT INTO `t_product` VALUES (4, '多肉芒芒甘露', 27, '2020-12-19 21:29:18', 1);
INSERT INTO `t_product` VALUES (5, '多肉葡萄', 29, '2020-12-19 21:29:23', 1);
INSERT INTO `t_product` VALUES (6, '满杯橙橙', 25, '2020-12-19 21:29:33', 1);
INSERT INTO `t_product` VALUES (7, '草莓魔法棒', 22, '2020-12-19 21:30:11', 2);
INSERT INTO `t_product` VALUES (8, '草莓冰沙', 36, '2020-12-19 10:00:11', 4);
INSERT INTO `t_product` VALUES (9, '草莓奶油可颂', 26, '2020-12-19 21:30:16', 2);
INSERT INTO `t_product` VALUES (10, '草莓派', 24, '2020-12-19 21:30:39', 2);
INSERT INTO `t_product` VALUES (11, '豆乳蛋糕 ', 98, '2020-12-19 21:23:13', 3);
INSERT INTO `t_product` VALUES (12, '蓝莓蛋糕', 112, '2020-12-19 21:31:06', 3);
INSERT INTO `t_product` VALUES (13, '芒果蛋糕', 108, '2020-12-19 21:31:25', 3);
INSERT INTO `t_product` VALUES (14, '满杯红柚', 25, '2020-12-19 21:29:40', 1);
INSERT INTO `t_product` VALUES (15, '鲷鱼烧冰淇淋', 28, '2020-12-18 10:01:14', 4);
INSERT INTO `t_product` VALUES (16, '芒芒甘露椰椰冻', 29, '2020-12-19 21:29:44', 1);
INSERT INTO `t_product` VALUES (17, '雪山莓莓桂花冻', 33, '2020-12-19 21:29:51', 1);
INSERT INTO `t_product` VALUES (18, '超大芝士', 45, '2020-12-19 21:19:39', 2);
INSERT INTO `t_product` VALUES (19, '焦糖布丁', 24, '2020-12-19 21:19:55', 2);
INSERT INTO `t_product` VALUES (20, '蓝莓奶油泡芙', 25, '2020-12-19 21:20:17', 2);
INSERT INTO `t_product` VALUES (21, '莓莓鲜奶吐司', 24, '2020-12-18 21:20:41', 2);
INSERT INTO `t_product` VALUES (22, '香葱芝士蛋卷', 32, '2020-12-16 21:21:27', 2);
INSERT INTO `t_product` VALUES (23, '抹茶水果多多蛋糕', 120, '2020-12-19 21:24:01', 3);
INSERT INTO `t_product` VALUES (24, '南瓜芝士蛋糕', 112, '2020-12-19 21:24:22', 3);
INSERT INTO `t_product` VALUES (25, '鲜奶油蛋糕', 85, '2020-12-19 21:24:45', 3);
INSERT INTO `t_product` VALUES (26, '樱桃蛋糕', 108, '2020-12-22 21:25:03', 3);
INSERT INTO `t_product` VALUES (27, '怪兽爆米花冰淇淋', 24, '2020-12-19 21:26:50', 4);
INSERT INTO `t_product` VALUES (28, '芒芒雪糕杯', 24, '2020-12-19 21:27:20', 4);
INSERT INTO `t_product` VALUES (29, '玫瑰甜筒', 32, '2020-12-19 21:27:40', 4);
INSERT INTO `t_product` VALUES (30, '抹茶红豆冰淇淋', 24, '2020-12-19 21:27:59', 4);
INSERT INTO `t_product` VALUES (31, '抹茶红豆冰沙', 32, '2020-12-17 21:28:17', 4);
INSERT INTO `t_product` VALUES (32, '心冻角', 15, '2020-12-19 21:47:53', 4);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `register_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `popedom` int(11) NULL DEFAULT NULL COMMENT '0：管理员；1：普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '小芳', 'shabi', '13180313123', '2021-01-21 12:25:12', 0);
INSERT INTO `t_user` VALUES (2, '小芳', 'dashabi', '13180313123', '2021-01-21 12:25:14', 1);

SET FOREIGN_KEY_CHECKS = 1;
