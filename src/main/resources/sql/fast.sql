/*
 Navicat Premium Data Transfer

 Source Server         : 李跃飞
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.2.4:3306
 Source Schema         : fast

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 22/07/2022 17:15:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_convey
-- ----------------------------
DROP TABLE IF EXISTS `app_convey`;
CREATE TABLE `app_convey`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `amount` decimal(10, 2) DEFAULT 0.00 COMMENT '交易金额',
  `addtime` datetime(0) DEFAULT NULL COMMENT '下单时间',
  `endtime` datetime(0) DEFAULT NULL COMMENT '完成交易时间',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结',
  `commission` decimal(10, 2) DEFAULT 0.00 COMMENT '佣金',
  `c_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '佣金发放状态 0未发放 1已发放 2账号冻结',
  `add_id` bigint(0) DEFAULT NULL COMMENT '会员收货地址id',
  `goods_id` bigint(0) DEFAULT NULL COMMENT '商品ID',
  `goods_count` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品数量',
  `hid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0显示1隐藏',
  `qiang` bigint(0) DEFAULT NULL COMMENT '抢单数',
  `lno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  `min` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '最小价',
  `max` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '最大价',
  `sign` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0不卡卡1卡单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '抢单业务主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_convey
-- ----------------------------
INSERT INTO `app_convey` VALUES (1, 123, 0.06, '2022-07-11 00:00:00', '2022-07-11 00:00:00', '1', 0.01, '1', 1234, 121212, '1', '0', 1, NULL, 0.00, 0.00, '0');
INSERT INTO `app_convey` VALUES (21, 111111, 0.08, '2022-07-11 00:00:00', NULL, '1', 0.01, '1', 123123, 121212, '1', '0', 1, '', 0.00, 100.00, '0');
INSERT INTO `app_convey` VALUES (22, 111111, 0.06, '2022-07-11 00:00:00', NULL, '1', 0.01, '1', 123123, 121212, '1', '0', 1, '', 0.00, 100.00, '0');
INSERT INTO `app_convey` VALUES (23, NULL, 0.00, '2022-07-13 08:00:00', NULL, NULL, 0.00, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220713978436', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (24, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220713131934', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (25, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220713330231', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (26, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220713744395', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (27, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220713624015', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (28, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714849524', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (29, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714314777', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (30, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714803901', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (31, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714239814', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (32, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714830108', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (33, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714770111', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (34, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 9.75, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220714747934', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (35, 0, 0.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (37, 0, 0.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (88, 0, 0.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (89, 0, 9.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (90, 0, 9.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (91, 0, 9.00, '2022-07-15 08:00:00', '2022-07-15 08:00:00', '', 0.00, '', 0, 0, '', '', 0, '', 0.00, 0.00, '');
INSERT INTO `app_convey` VALUES (92, NULL, 770.00, NULL, NULL, NULL, 1.93, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220719233689', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (93, NULL, 770.00, NULL, NULL, NULL, 1.93, NULL, NULL, NULL, NULL, NULL, 1, 'UB20220719390070', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (94, NULL, 770.00, NULL, NULL, NULL, 1.93, NULL, NULL, 26, NULL, NULL, 1, 'UB20220719740045', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (95, 2, 770.00, '2022-07-19 17:07:58', '2022-07-19 17:07:58', '1', 1.93, '1', 2, 26, NULL, NULL, 1, 'UB20220719771694', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (96, 2, 770.00, '2022-07-19 17:16:21', '2022-07-19 17:16:21', '1', 1.93, '1', 2, 26, NULL, NULL, 1, 'UB20220719935146', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (97, 2, 770.00, '2022-07-19 19:05:36', '2022-07-19 19:05:36', '1', 1.93, '1', 2, 26, NULL, NULL, 2, 'UB20220719980964', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (98, 2, 770.00, '2022-07-19 19:05:47', '2022-07-19 19:05:47', '1', 1.93, '1', 2, 26, NULL, NULL, 3, 'UB20220719351403', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (99, 2, 770.00, '2022-07-19 19:06:01', '2022-07-19 19:06:01', '1', 1.93, '1', 2, 26, NULL, NULL, 4, 'UB20220719944652', 0.00, 0.00, NULL);

-- ----------------------------
-- Table structure for app_file
-- ----------------------------
DROP TABLE IF EXISTS `app_file`;
CREATE TABLE `app_file`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file_format` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件格式',
  `upload_time` datetime(0) DEFAULT NULL COMMENT '上传时间',
  `file_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件名称',
  `file_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_file
-- ----------------------------
INSERT INTO `app_file` VALUES ('34f84af2-079c-469e-901a-70446cc58c68', 'jpg', '2022-07-22 16:10:44', '34f84af2-079c-469e-901a-70446cc58c68.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('41ce7930-41db-44fb-bf4c-0a85a4580471', 'jpg', '2022-07-22 16:10:31', '41ce7930-41db-44fb-bf4c-0a85a4580471.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('89c7b952-5f36-4cd6-ab53-bc116c0a1e81', 'jpg', '2022-07-22 16:09:31', '89c7b952-5f36-4cd6-ab53-bc116c0a1e81.jpg', 'pic/1.jpg');
INSERT INTO `app_file` VALUES ('8afb115d-10bc-4de4-93b0-4f1fddc5ad3d', 'jpg', '2022-07-22 16:10:49', '8afb115d-10bc-4de4-93b0-4f1fddc5ad3d.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('8bfe6131-d8bc-42ca-9c8f-e8d970c24396', 'jpg', '2022-07-22 16:08:19', '8bfe6131-d8bc-42ca-9c8f-e8d970c24396jpg', 'pic/1.jpg');
INSERT INTO `app_file` VALUES ('b91c3fc3-801d-4d7f-a6c2-7757d8fdcf33', 'jpg', '2022-07-22 16:10:47', 'b91c3fc3-801d-4d7f-a6c2-7757d8fdcf33.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('c17da18c-fcf4-4b89-88f0-efb2159ebc84', 'jpg', '2022-07-22 16:10:55', 'c17da18c-fcf4-4b89-88f0-efb2159ebc84.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('cb0209aa-113c-436a-bd96-8572baad92f5', 'jpg', '2022-07-22 16:10:45', 'cb0209aa-113c-436a-bd96-8572baad92f5.jpg', 'pic/2.jpg');
INSERT INTO `app_file` VALUES ('edac80cf-5118-4e80-938e-c9c42b530a1a', 'jpg', '2022-07-22 16:10:51', 'edac80cf-5118-4e80-938e-c9c42b530a1a.jpg', 'pic/2.jpg');

-- ----------------------------
-- Table structure for app_goods
-- ----------------------------
DROP TABLE IF EXISTS `app_goods`;
CREATE TABLE `app_goods`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商店名称',
  `goods_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `goods_info` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品描述',
  `goods_price` decimal(10, 2) DEFAULT 0.00 COMMENT '商品价格',
  `goods_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品展示图片',
  `goods_add_time` datetime(0) DEFAULT NULL COMMENT '商品添加时间',
  `status` int(0) DEFAULT NULL COMMENT '上架状态 0不上架 1上架',
  `goods_sort_id` bigint(0) DEFAULT NULL COMMENT '商品分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_goods
-- ----------------------------
INSERT INTO `app_goods` VALUES (22, '4', '555', '2222', 100.00, '5556', '2022-07-16 15:19:22', 1, NULL);
INSERT INTO `app_goods` VALUES (23, '666', '666', '666', 0.00, '', '2022-07-16 15:19:22', 0, NULL);
INSERT INTO `app_goods` VALUES (24, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (25, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (26, '777777', '777', '777', 770.00, '22222', NULL, 1, NULL);
INSERT INTO `app_goods` VALUES (27, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (28, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (29, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (30, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (31, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (32, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (33, '666', '666', '666', 0.00, '', NULL, 0, NULL);
INSERT INTO `app_goods` VALUES (34, '9999', '999', '999', 90.00, '9999', NULL, 1, 44444);
INSERT INTO `app_goods` VALUES (35, '9999', '999', '999', 90.00, '9999', NULL, 1, 44444);

-- ----------------------------
-- Table structure for app_goods_sort
-- ----------------------------
DROP TABLE IF EXISTS `app_goods_sort`;
CREATE TABLE `app_goods_sort`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `commission` float DEFAULT NULL COMMENT '佣金比例',
  `goods_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `shop_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商店名称',
  `goods_info` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品描述',
  `goods_pic` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '商品展示图片',
  `goods_add_time` datetime(0) DEFAULT NULL COMMENT '商品添加时间',
  `min` decimal(10, 2) DEFAULT 0.00 COMMENT '最小金额限制',
  `level_id` bigint(0) DEFAULT NULL COMMENT '等级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_goods_sort
-- ----------------------------
INSERT INTO `app_goods_sort` VALUES (54, 0.01, '商品名称1', '商店名称', '商品描述1', 'qewrwerqertSasqe', '2022-07-12 08:00:00', 0.00, 12341234);
INSERT INTO `app_goods_sort` VALUES (55, 0.01, '商品名称3', '商店名称', '商品描述1', 'qewrwerqertSasqe', '2022-07-12 08:00:00', 0.00, 12341234);

-- ----------------------------
-- Table structure for app_member
-- ----------------------------
DROP TABLE IF EXISTS `app_member`;
CREATE TABLE `app_member`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(0) DEFAULT NULL COMMENT '会员等级id',
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `balance` decimal(10, 2) DEFAULT 0.00 COMMENT '账户余额',
  `freeze_balance` decimal(10, 2) DEFAULT 0.00 COMMENT '账号冻结金额',
  `recharge_num` decimal(10, 2) DEFAULT 0.00 COMMENT '日充值金额',
  `deposit_num` decimal(10, 2) DEFAULT 0.00 COMMENT '日提现金额',
  `deduction_num` decimal(10, 2) DEFAULT 0.00 COMMENT '扣除金额',
  `matching` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'JSON下单规则',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `parent_user_id` bigint(0) DEFAULT NULL COMMENT '上级关联ID(如果该用户不是可登录后台的真代理,该项必填)',
  `parent_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级伪代理用户名称或上级真实代理用户昵称',
  `is_agent` int(0) DEFAULT NULL COMMENT '代理账号标识（0代理账号[新增时候维护tb_app_user和sys_user] 1普通管理员账号[新增时候维护sys_user]）【0:真实代理 1:伪代理,不可登录后台】',
  `agent_level` int(0) DEFAULT NULL COMMENT '字典项 代理等级',
  `status` int(0) DEFAULT NULL COMMENT '帐号状态（0正常 1停用）',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `del_flag` int(0) DEFAULT NULL COMMENT '删除标志（1代表存在 2代表删除）',
  `login_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登录IP',
  `login_date` datetime(0) DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `company_id` bigint(0) DEFAULT NULL COMMENT '机构id',
  `invite_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码',
  `registration_time` datetime(0) DEFAULT NULL COMMENT '会员注册时间',
  `member_status` int(0) DEFAULT NULL COMMENT '会员状态:1.真人2.假人',
  `register_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册ip',
  `register_country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册国家',
  `total_commission` decimal(16, 2) DEFAULT 0.00 COMMENT '会员个人总佣金',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member
-- ----------------------------
INSERT INTO `app_member` VALUES (11, 1, 'wx_user1', NULL, 0.00, 0.00, 0.00, 0.00, NULL, '123456', 2, '测试会员登录', 1, 1, 1, '2819708@qq.com', '13523532415', 1, NULL, NULL, 'wx_user1', '2022-07-13 18:21:09', NULL, 1, 'z8519UI9', '2022-07-13 18:21:09', 1, NULL, NULL, 3000.00);
INSERT INTO `app_member` VALUES (14, 2, 'qwer11', 0.00, 0.00, 0.00, 0.00, 0.00, '', '123456', 11, '', 0, 1, 1, '', '15887877878', 0, '', '2022-07-15 08:00:00', '', '2022-07-15 08:00:00', '', NULL, '', '2022-07-15 08:00:00', 0, '', '', 0.00);
INSERT INTO `app_member` VALUES (15, NULL, 'hzb', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', NULL, NULL, NULL, NULL, NULL, NULL, '17736609390', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'aabbcc', NULL, NULL, NULL, NULL, 0.00);

-- ----------------------------
-- Table structure for app_member_account_change
-- ----------------------------
DROP TABLE IF EXISTS `app_member_account_change`;
CREATE TABLE `app_member_account_change`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(0) DEFAULT NULL COMMENT '账户ID',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `currency_type` int(0) DEFAULT NULL COMMENT '充值类型 1.USDT',
  `opera_type` int(0) DEFAULT NULL COMMENT '操作类型【1.充值 2.减少 3.冻结 4.提取】',
  `pre_opera_mount` decimal(10, 2) DEFAULT 0.00 COMMENT '操作前余额',
  `opera_mount` decimal(10, 2) DEFAULT 0.00 COMMENT '操作金额',
  `total_mount` decimal(10, 2) DEFAULT 0.00 COMMENT '当前总计余额',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员账户变更表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_account_change
-- ----------------------------
INSERT INTO `app_member_account_change` VALUES (21, 111111, 12341234, 1, 1, 100.00, 50.00, 150.00, '123123', '2022-07-12 08:00:00', '111', '2022-07-12 08:00:00');
INSERT INTO `app_member_account_change` VALUES (22, 12341234, 12341234, 1, 1, 100.00, 50.00, 150.00, '123123', '2022-07-12 08:00:00', '111', '2022-07-12 08:00:00');
INSERT INTO `app_member_account_change` VALUES (23, NULL, 2, NULL, 1, 600.00, 0.00, NULL, '111', '2022-07-13 17:30:50', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (24, NULL, 2, NULL, 1, 196275.50, 3900.00, NULL, '111', '2022-07-13 17:40:41', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (25, NULL, 2, NULL, 1, 4275.50, 3900.00, NULL, '111', '2022-07-13 17:44:48', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (26, NULL, 2, NULL, 2, 56275.50, 3900.00, NULL, '111', '2022-07-13 17:47:50', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (27, NULL, 2, NULL, 2, 80000.00, 3900.00, 76275.50, '111', '2022-07-13 18:28:43', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (28, NULL, 2, NULL, 2, 76739.50, 3900.00, 72849.25, '111', '2022-07-14 20:22:31', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (29, NULL, 2, NULL, 2, 72849.25, 3900.00, 68959.00, '111', '2022-07-14 20:25:19', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (30, NULL, 2, NULL, 2, 68959.00, 3900.00, 65068.75, '111', '2022-07-14 20:26:29', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (31, NULL, 2, NULL, 2, 65068.75, 3900.00, 61178.50, '111', '2022-07-14 20:30:53', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (32, NULL, 2, NULL, 2, 61178.50, 3900.00, 57288.25, '111', '2022-07-14 20:31:59', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (33, NULL, 2, NULL, 2, 57288.25, 3900.00, 53398.00, '111', '2022-07-14 20:32:29', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (34, NULL, 2, NULL, 2, 53398.00, 3900.00, 49507.75, '111', '2022-07-14 20:33:14', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (35, NULL, 2, NULL, 2, 49507.75, 3900.00, 45617.50, '111', '2022-07-14 20:39:52', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (36, NULL, 2, NULL, 2, 45617.50, 3900.00, 41727.25, '123456', '2022-07-15 14:04:19', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (37, NULL, 2, NULL, 2, 41727.25, 770.00, 40959.18, '123456', '2022-07-19 16:46:20', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (38, NULL, 2, NULL, 2, 40959.18, 770.00, 40191.11, '123456', '2022-07-19 16:46:52', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (39, NULL, 2, NULL, 2, 40191.11, 770.00, 39423.04, '123456', '2022-07-19 16:48:32', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (40, NULL, 2, NULL, 2, 39423.04, 770.00, 38654.97, '123456', '2022-07-19 17:08:11', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (41, NULL, 2, NULL, 2, 38654.97, 770.00, 37886.90, '123456', '2022-07-19 17:16:22', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (42, NULL, 2, NULL, 2, 37886.90, 770.00, 37118.83, '123456', '2022-07-19 19:05:36', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (43, NULL, 2, NULL, 2, 37118.83, 770.00, 36350.76, '123456', '2022-07-19 19:05:47', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (44, NULL, 2, NULL, 2, 36350.76, 770.00, 35582.69, '123456', '2022-07-19 19:06:01', NULL, NULL);

-- ----------------------------
-- Table structure for app_member_address
-- ----------------------------
DROP TABLE IF EXISTS `app_member_address`;
CREATE TABLE `app_member_address`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货姓名',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货手机',
  `area` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址-详情',
  `default_addr` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '默认地址',
  `finish_time` datetime(0) DEFAULT NULL COMMENT '完成交易时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_address
-- ----------------------------
INSERT INTO `app_member_address` VALUES (2, 2, 'ppp', '17736609390', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (21, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (22, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (23, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (24, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (25, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (26, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (27, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (28, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (29, 1, '收货姓名', '17736609390', NULL, '详细地址2', NULL, NULL);

-- ----------------------------
-- Table structure for app_member_bank
-- ----------------------------
DROP TABLE IF EXISTS `app_member_bank`;
CREATE TABLE `app_member_bank`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `bank_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行名称',
  `bank_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行编号',
  `card_num` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行卡号',
  `account_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开户名',
  `site` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开户行地址或者IFSC',
  `bank_country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行所在国家',
  `tel` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行所在国家',
  `status` int(0) DEFAULT NULL COMMENT '状态，1启用，0禁用',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开户行地址或者IFSC',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员银行卡信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_bank
-- ----------------------------
INSERT INTO `app_member_bank` VALUES (2, 12356, 'uuu', 'uuu', 'uuu', 'uuu', 'u', 'u', 'uuu', 0, 'uuu');
INSERT INTO `app_member_bank` VALUES (3, 1, '开户银行', NULL, '银行卡号', '开户人', '', NULL, '开户电话', NULL, NULL);
INSERT INTO `app_member_bank` VALUES (4, 1, '开户银行', NULL, '123123123123', '开户人', '开户地址', NULL, '17736609390', NULL, NULL);

-- ----------------------------
-- Table structure for app_member_level
-- ----------------------------
DROP TABLE IF EXISTS `app_member_level`;
CREATE TABLE `app_member_level`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `members_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员名称',
  `order_num` int(0) DEFAULT NULL COMMENT '接单限制',
  `member_price` decimal(18, 2) DEFAULT 0.00 COMMENT '会员价格',
  `register_time` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `commission` decimal(18, 4) DEFAULT 0.0000 COMMENT '佣金比例',
  `members_level` int(0) DEFAULT 1 COMMENT '会员等级',
  `withdrawal_times` int(0) DEFAULT NULL COMMENT '提现次数',
  `withdrawal_min` int(0) DEFAULT NULL COMMENT '提现最小金额',
  `withdrawal_max` int(0) DEFAULT NULL COMMENT '提现最大金额',
  `num_min` int(0) DEFAULT NULL COMMENT '最小余额',
  `withdrawal_nim_order` int(0) DEFAULT NULL COMMENT '提现最少完成订单数',
  `auto_vip_xu_num` int(0) DEFAULT NULL COMMENT '自动升级vip需要邀请的人数',
  `service_charge` decimal(18, 2) DEFAULT 0.00 COMMENT '提现手续费',
  `pic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_level
-- ----------------------------
INSERT INTO `app_member_level` VALUES (2, '黄金会员', 80, 1000.00, '2022-07-13 17:24:51', 0.0050, 2, 5, 200, 8000, 10, 10, 10, 10.00, '1111');
INSERT INTO `app_member_level` VALUES (3, '222白金会员', 100, 3000.00, '2022-07-13 17:24:51', 0.0060, 3, 8, 200, 10000, 10, 10, 10, 10.00, '1111');
INSERT INTO `app_member_level` VALUES (4, '钻石会员222', 120, 5000.00, '2022-07-13 17:24:51', 0.0070, 4, 10, 200, 80000, 10, 10, 10, 10.00, '1111');
INSERT INTO `app_member_level` VALUES (12, '123', 1231, 123.00, NULL, 12312.0000, 1, 123, 312312, 3123, 3, NULL, NULL, 0.00, NULL);

-- ----------------------------
-- Table structure for app_member_order
-- ----------------------------
DROP TABLE IF EXISTS `app_member_order`;
CREATE TABLE `app_member_order`  (
  `id` bigint(0) NOT NULL COMMENT 'id',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货姓名',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货手机',
  `area` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址-详情',
  `default_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '默认地址',
  `createtime` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '完成交易时间',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for app_picture
-- ----------------------------
DROP TABLE IF EXISTS `app_picture`;
CREATE TABLE `app_picture`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `picture_type` int(0) DEFAULT NULL COMMENT '图片类型 1.正文 2.头像3.公告',
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文字说明',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `last_edit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后编辑',
  `show_type` int(0) DEFAULT NULL COMMENT '展示类型 1.app展示 2.app不展示',
  `picture_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片文件id',
  `picture_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片名称',
  `picture_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_picture
-- ----------------------------
INSERT INTO `app_picture` VALUES (1, NULL, NULL, NULL, NULL, NULL, '0c6e3b60-4d80-44b0-86be-7eb227537ced', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//0c6e3b60-4d80-44b0-86be-7eb227537ced/1.jpg');
INSERT INTO `app_picture` VALUES (2, NULL, NULL, NULL, NULL, NULL, 'acc66a26-6370-411c-9238-913d9f80b5e8', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//acc66a26-6370-411c-9238-913d9f80b5e8/1.jpg');
INSERT INTO `app_picture` VALUES (3, NULL, NULL, NULL, NULL, NULL, 'ae74d977-0cfc-47d9-8888-082426355af2', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//ae74d977-0cfc-47d9-8888-082426355af2/1.jpg');
INSERT INTO `app_picture` VALUES (4, NULL, NULL, NULL, NULL, NULL, 'e8d10205-b3d0-4ecd-bf54-9dcd2fe696e6', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//e8d10205-b3d0-4ecd-bf54-9dcd2fe696e6/2.jpg');
INSERT INTO `app_picture` VALUES (5, NULL, NULL, NULL, NULL, NULL, 'bbd6d00c-7a28-4add-925f-d13f392b32fd', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//bbd6d00c-7a28-4add-925f-d13f392b32fd/2.jpg');
INSERT INTO `app_picture` VALUES (11, NULL, NULL, NULL, NULL, NULL, '026071c4-43a5-4506-8a8a-316181fda94d', NULL, '/ppp/images/026071c4-43a5-4506-8a8a-316181fda94d/2.jpg');
INSERT INTO `app_picture` VALUES (12, NULL, NULL, '2022-07-21 18:41:50', NULL, NULL, '32df552c-ea26-4217-a37a-721af40f6740', '2.jpg', '/ppp/images/32df552c-ea26-4217-a37a-721af40f6740/2.jpg');
INSERT INTO `app_picture` VALUES (13, NULL, NULL, '2022-07-21 18:42:46', NULL, NULL, '14a2c232-5f27-4c55-8061-be01189ba022', '2.jpg', '/ppp/images/14a2c232-5f27-4c55-8061-be01189ba022/2.jpg');
INSERT INTO `app_picture` VALUES (14, NULL, NULL, '2022-07-22 10:39:15', NULL, NULL, 'fde742a0-7f73-4b67-8ba2-e66dc7e00b76', '2.jpg', '/ppp/images/fde742a0-7f73-4b67-8ba2-e66dc7e00b76/2.jpg');
INSERT INTO `app_picture` VALUES (15, NULL, NULL, '2022-07-22 10:39:19', NULL, NULL, '78700741-bd9c-4da6-ab21-cfbe6281b4a0', '2.jpg', '/ppp/images/78700741-bd9c-4da6-ab21-cfbe6281b4a0/2.jpg');
INSERT INTO `app_picture` VALUES (16, NULL, NULL, '2022-07-22 10:39:21', NULL, NULL, '1a13aeae-82df-401b-b185-1c494badec51', '2.jpg', '/ppp/images/1a13aeae-82df-401b-b185-1c494badec51/2.jpg');
INSERT INTO `app_picture` VALUES (17, NULL, NULL, '2022-07-22 10:39:33', NULL, NULL, '31f31d2d-68a8-4a60-9f51-492531f4f355', '2.jpg', '/ppp/images/31f31d2d-68a8-4a60-9f51-492531f4f355/2.jpg');
INSERT INTO `app_picture` VALUES (18, NULL, NULL, '2022-07-22 10:39:38', NULL, NULL, 'f38b8b04-a146-4047-9130-0fb8cbd1c026', '2.jpg', '/ppp/images/f38b8b04-a146-4047-9130-0fb8cbd1c026/2.jpg');
INSERT INTO `app_picture` VALUES (19, NULL, NULL, '2022-07-22 10:39:42', NULL, NULL, 'e5fa84ea-1715-4405-8562-dde96af641fd', '2.jpg', '/ppp/images/e5fa84ea-1715-4405-8562-dde96af641fd/2.jpg');
INSERT INTO `app_picture` VALUES (20, NULL, NULL, '2022-07-22 10:39:44', NULL, NULL, '63872fff-7247-41f0-bb2e-17a4f3bb0559', '2.jpg', '/ppp/images/63872fff-7247-41f0-bb2e-17a4f3bb0559/2.jpg');
INSERT INTO `app_picture` VALUES (21, NULL, NULL, '2022-07-22 10:39:45', NULL, NULL, 'e059538d-6b92-4f51-b744-a337c84ffc80', '2.jpg', '/ppp/images/e059538d-6b92-4f51-b744-a337c84ffc80/2.jpg');
INSERT INTO `app_picture` VALUES (22, NULL, NULL, '2022-07-22 10:39:47', NULL, NULL, '4daf8fb6-3ccf-46da-86ed-efdec77439c7', '2.jpg', '/ppp/images/4daf8fb6-3ccf-46da-86ed-efdec77439c7/2.jpg');
INSERT INTO `app_picture` VALUES (23, NULL, NULL, '2022-07-22 10:39:49', NULL, NULL, 'a627eb9d-b2fc-42e6-9e34-319f6e01e305', '2.jpg', '/ppp/images/a627eb9d-b2fc-42e6-9e34-319f6e01e305/2.jpg');
INSERT INTO `app_picture` VALUES (24, NULL, NULL, '2022-07-22 10:39:55', NULL, NULL, 'fe1b4527-89fb-4d08-83d9-1084f624418e', '2.jpg', '/ppp/images/fe1b4527-89fb-4d08-83d9-1084f624418e/2.jpg');
INSERT INTO `app_picture` VALUES (25, NULL, NULL, '2022-07-22 10:40:22', NULL, NULL, 'b4c29c85-b222-4a36-8c6e-7ce46471a470', '2.jpg', '/ppp/images/b4c29c85-b222-4a36-8c6e-7ce46471a470/2.jpg');
INSERT INTO `app_picture` VALUES (26, NULL, NULL, '2022-07-22 10:40:25', NULL, NULL, '2f91eeb4-3089-435c-bd66-c8cdab5dca63', '2.jpg', '/ppp/images/2f91eeb4-3089-435c-bd66-c8cdab5dca63/2.jpg');
INSERT INTO `app_picture` VALUES (27, NULL, NULL, '2022-07-22 10:40:27', NULL, NULL, '0d408986-7bdc-426b-8508-4c648a0346db', '2.jpg', '/ppp/images/0d408986-7bdc-426b-8508-4c648a0346db/2.jpg');
INSERT INTO `app_picture` VALUES (28, NULL, NULL, '2022-07-22 10:40:30', NULL, NULL, 'ead2503a-79a5-4976-8b53-068a2085aeb0', '2.jpg', '/ppp/images/ead2503a-79a5-4976-8b53-068a2085aeb0/2.jpg');
INSERT INTO `app_picture` VALUES (29, NULL, NULL, '2022-07-22 10:40:32', NULL, NULL, 'c97d3d40-93b1-47ee-a7be-390a072b2100', '2.jpg', '/ppp/images/c97d3d40-93b1-47ee-a7be-390a072b2100/2.jpg');
INSERT INTO `app_picture` VALUES (30, NULL, NULL, '2022-07-22 10:40:36', NULL, NULL, '3541c598-32a4-4417-af1a-3957bd07af70', '2.jpg', '/ppp/images/3541c598-32a4-4417-af1a-3957bd07af70/2.jpg');
INSERT INTO `app_picture` VALUES (31, NULL, NULL, '2022-07-22 10:40:39', NULL, NULL, '48f48f15-cd1d-48b9-8c7a-a20632f7094f', '2.jpg', '/ppp/images/48f48f15-cd1d-48b9-8c7a-a20632f7094f/2.jpg');
INSERT INTO `app_picture` VALUES (32, NULL, NULL, '2022-07-22 10:42:04', NULL, NULL, 'b4ca4a19-c68b-48be-ab8a-89a14a4d4dfd', '2.jpg', '/ppp/images/b4ca4a19-c68b-48be-ab8a-89a14a4d4dfd/2.jpg');
INSERT INTO `app_picture` VALUES (33, NULL, NULL, '2022-07-22 10:42:13', NULL, NULL, '92229aa0-27a1-407e-a7c5-71a0b8edbeec', '2.jpg', '/ppp/images/92229aa0-27a1-407e-a7c5-71a0b8edbeec/2.jpg');
INSERT INTO `app_picture` VALUES (34, NULL, NULL, '2022-07-22 10:42:25', NULL, NULL, '0eda04b9-2100-43de-ad49-ec35b9e49d65', '2.jpg', '/ppp/images/0eda04b9-2100-43de-ad49-ec35b9e49d65/2.jpg');
INSERT INTO `app_picture` VALUES (35, NULL, NULL, '2022-07-22 10:42:30', NULL, NULL, 'f137d6ec-ef32-4296-ba80-b396b4b4d60f', '2.jpg', '/ppp/images/f137d6ec-ef32-4296-ba80-b396b4b4d60f/2.jpg');
INSERT INTO `app_picture` VALUES (36, NULL, NULL, '2022-07-22 10:48:33', NULL, NULL, '5b591335-82e0-4c97-b27b-558bf9eca1dc', '2.jpg', '/ppp/images/5b591335-82e0-4c97-b27b-558bf9eca1dc/2.jpg');
INSERT INTO `app_picture` VALUES (37, NULL, NULL, '2022-07-22 10:48:39', NULL, NULL, '3b42588f-2a99-4887-92ed-058733850a69', '2.jpg', '/ppp/images/3b42588f-2a99-4887-92ed-058733850a69/2.jpg');
INSERT INTO `app_picture` VALUES (38, NULL, NULL, '2022-07-22 10:48:41', NULL, NULL, '344dec64-b481-4bda-a010-e91850f1ebde', '2.jpg', '/ppp/images/344dec64-b481-4bda-a010-e91850f1ebde/2.jpg');
INSERT INTO `app_picture` VALUES (39, NULL, NULL, '2022-07-22 10:48:42', NULL, NULL, '95df78c3-8517-437c-bba5-d368f3756ddf', '2.jpg', '/ppp/images/95df78c3-8517-437c-bba5-d368f3756ddf/2.jpg');
INSERT INTO `app_picture` VALUES (40, NULL, NULL, '2022-07-22 10:48:44', NULL, NULL, 'b087f69e-658b-4d35-9744-7fd338d55c6c', '2.jpg', '/ppp/images/b087f69e-658b-4d35-9744-7fd338d55c6c/2.jpg');
INSERT INTO `app_picture` VALUES (41, NULL, NULL, '2022-07-22 10:48:45', NULL, NULL, 'a8b4d950-0130-4c08-97e3-5956c7c4301d', '2.jpg', '/ppp/images/a8b4d950-0130-4c08-97e3-5956c7c4301d/2.jpg');
INSERT INTO `app_picture` VALUES (42, NULL, NULL, '2022-07-22 10:50:54', NULL, NULL, '37eb4448-1435-468b-a057-8d06771c691c', '2.jpg', '/ppp/images/37eb4448-1435-468b-a057-8d06771c691c/2.jpg');
INSERT INTO `app_picture` VALUES (43, NULL, NULL, '2022-07-22 10:50:56', NULL, NULL, 'b367bea3-b3a2-48b6-a9a1-9bc51e80b902', '2.jpg', '/ppp/images/b367bea3-b3a2-48b6-a9a1-9bc51e80b902/2.jpg');
INSERT INTO `app_picture` VALUES (44, NULL, NULL, '2022-07-22 10:50:57', NULL, NULL, 'bc908562-fe4c-408c-9247-cd0bf70e0f7c', '2.jpg', '/ppp/images/bc908562-fe4c-408c-9247-cd0bf70e0f7c/2.jpg');
INSERT INTO `app_picture` VALUES (45, NULL, NULL, '2022-07-22 10:50:59', NULL, NULL, '353b5c91-a983-4c7b-b8c1-37359b5bd995', '2.jpg', '/ppp/images/353b5c91-a983-4c7b-b8c1-37359b5bd995/2.jpg');
INSERT INTO `app_picture` VALUES (46, NULL, NULL, '2022-07-22 11:39:16', NULL, NULL, '5e2a0f4f-0943-47a8-a138-422f0aa48c4e', '2.jpg', '/ppp/images/5e2a0f4f-0943-47a8-a138-422f0aa48c4e/2.jpg');
INSERT INTO `app_picture` VALUES (47, 1, '222222', '2022-07-22 08:00:00', '2222', 0, '222', '22222', '2222');

-- ----------------------------
-- Table structure for sys_agent_list
-- ----------------------------
DROP TABLE IF EXISTS `sys_agent_list`;
CREATE TABLE `sys_agent_list`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员ID',
  `user_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户名称',
  `commission` decimal(16, 2) DEFAULT 0.00 COMMENT '佣金',
  `user_pic` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '代理用户头像',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代理佣金展示表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_agent_list
-- ----------------------------
INSERT INTO `sys_agent_list` VALUES (1, '2', '123456', 2.68, '1231312321.jpg', 'admin', '2022-07-18 14:30:53', NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (2, '1', '333', 3.66, NULL, 'admin', '2022-07-18 14:31:24', NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (3, '14', 'qwer', 1.29, 'wrwqwq.jpg', 'admin', '2022-07-18 14:31:57', NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (4, '11', 'wx_user1', 6.79, NULL, 'admin', '2022-07-18 14:33:52', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_channel
-- ----------------------------
DROP TABLE IF EXISTS `sys_channel`;
CREATE TABLE `sys_channel`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `channel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `front_dns` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT 'dns',
  `backstage_dns` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT 'dns',
  `app_dns` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'dns',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '状态',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `channel_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '渠道关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_channel
-- ----------------------------
INSERT INTO `sys_channel` VALUES (1, 'rulai', 'http://localhost:8080/', 'http://localhost:8080/', 'http://localhost:8080/', '0', '', '2022-07-18 16:30:38', '', NULL, NULL, '1');

-- ----------------------------
-- Table structure for sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典表编号',
  `DICDEFINE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典定义',
  `DICDESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典描述',
  `DICCODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典编码',
  `DICNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典名称',
  `ISUSE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用状态',
  `CRT_USER` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('1', 'sex', '性别', '1', '男', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('2', 'sex', '性别', '0', '女', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('3', 'isuse', '使用状态', '1', '使用中', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('4', 'isuse', '使用状态', '0', '已注销', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('5', 'menuType', '菜单类型', '0', '目录', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('6', 'menuType', '菜单类型', '1', '菜单', '1', 'admin', '2018-06-08');
INSERT INTO `sys_dic` VALUES ('7', 'menuType', '菜单类型', '2', '按钮', '1', 'admin', '2018-06-08');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `MENU_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单ID',
  `MENU_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `MENU_PID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单父级ID',
  `MENU_URL` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单地址',
  `MENU_PARM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限值',
  `MENU_TYPE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单类型',
  `MENU_ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图片',
  `MENU_SORT` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单排序',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  `UPDATE_TIME` date DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `UPDATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改单位',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0bb3a2bcd55a4af2963ea7093eda06d6', '6', '会员管理', '0', '', '', '0', 'fa-leaf', '12', '2022-07-18', 'admin', '1', '2022-07-19', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('1', '1', '商品列表', '0', NULL, NULL, '0', '&#xe6c9;', '3', NULL, NULL, NULL, '2018-07-04', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('10', '401', '用户管理', '4', '/sys/user/list', NULL, '1', '&#xe665;', '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('103740af79724973a8969dc70ea24980', '40402', '修改', '404', NULL, 'org:update', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('11', '40101', '新增', '401', NULL, 'user:add', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('12', '40102', '修改', '401', NULL, 'user:update', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('13', '40103', '删除', '401', NULL, 'user:del', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('14', '40104', '重置密码', '401', NULL, 'user:resetPwd', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('15', '402', '菜单管理', '4', '/sys/menu/list', NULL, '1', '&#xe658;', '2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('16', '40201', '新增', '402', NULL, 'menu:add', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('17', '40202', '修改', '402', NULL, 'menu:update', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('18', '40203', '删除', '402', NULL, 'menu:del', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('2', '101', '列表一', '1', NULL, NULL, '1', '&#xe676;', '10', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('2026ff6c77284e0093cb10e63d07da10', '40502', '修改', '405', NULL, 'dic:update', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('3', '102', '列表二', '1', NULL, NULL, '1', '&#xe66b;', '2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('4', '103', '列表三', '1', NULL, NULL, '1', '&#xe66e;', '3', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('415b39ea8c044b5d833430a64f38be04', '40403', '删除', '404', NULL, 'org:del', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('4334e39da6d24960bb6130e158994648', '40302', '修改', '403', NULL, 'role:update', '2', NULL, '2', '2018-07-04', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('5', '2', '解决方案', '0', NULL, NULL, '0', '&#xe702;', '2', NULL, NULL, NULL, '2018-07-18', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('57612dd7f93745b9bfee457410d646aa', '405', '字典管理', '4', '/sys/dic/list', NULL, '1', 'fa-fire', '5', '2018-07-06', 'admin', '1', '2018-07-06', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('6', '201', '方案一', '2', '/list', NULL, '1', '&#xe6b1;', '1', NULL, NULL, NULL, '2018-07-18', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('6e47f2d97a3e49ad98d97e9d985aece8', '40501', '新增', '405', NULL, 'dic:add', '2', NULL, '1', '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('7', '202', '方案二', '2', '', NULL, '1', '&#xe66a;', '2', NULL, NULL, NULL, '2018-07-18', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('71b57b4634f34bf39cbd2c797c94b42d', '40503', '删除', '405', NULL, 'dic:del', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('77b30d2bc73a45d6ae21e3606458b0d6', '40303', '删除', '403', NULL, 'role:del', '2', NULL, NULL, '2018-07-04', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('8', '3', '发布商品', '0', '', NULL, '0', '&#xe7ae;', '8', '2018-06-21', '', '', '2018-07-06', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('859a3314b98b427d98f69f3574e953a6', '601', '会员列表', '6', 'memberaction/list', '', '1', 'fa-list-ul', '1', '2022-07-20', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('85f129b57df04d3bbe34c28eb0599fec', '404', '单位管理', '4', '/sys/org/list', NULL, '1', 'fa-asterisk', '4', '2018-07-05', 'admin', '1', '2018-07-05', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('9', '4', '系统管理', '0', NULL, NULL, '0', '&#xe65d;', '1', '2018-06-21', '', '', '2018-07-04', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('9ccf7ce73d084144ac87d1d2553ce0c4', '50101', 'add', '501', NULL, 'test:add', '2', 'fa-plus', NULL, '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('a2b8f4dc3e8e403d9a91fb4f464ce96b', '602', '会员等级', '6', 'level/list', '', '1', 'fa-road', '11', '2022-07-22', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('a50bef14830c4327addddddd2717e41c', '40401', '新增', '404', NULL, 'org:add', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('b13bb9138c694186aa16bc018e458943', '40301', '新增', '403', NULL, 'role:add', '2', NULL, '1', '2018-07-04', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('c5d03ff0e0b24917a13451611f489e03', '5', 'test', '0', NULL, NULL, '0', '&#xe6b1;', '5', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('d73575540b1c4b0f9e88d9d4d25c5ce4', '403', '角色管理', '4', '/sys/role/list', NULL, '1', '&#xe653;', '3', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('e5bbc6c38c1a4eada0b45c542e74b0ac', '501', 'test1', '5', 'xxx', NULL, '1', '&#xe66c;', '1', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('fc65c4b0ad76432c8a4b30f852b3346f', '50102', 'del', '501', NULL, 'test:del', '2', NULL, NULL, '2018-07-05', 'admin', '1', '2018-07-08', 'admin', '1');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `notice_classes` int(0) DEFAULT NULL COMMENT '通知类型(1.系统通知 2.个人通知 3.其他通知)',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-03-26 12:27:43', '', NULL, '管理员', 1, NULL);
INSERT INTO `sys_notice` VALUES (2, '维护通知：系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-03-26 12:27:43', '', NULL, '管理员', 1, NULL);
INSERT INTO `sys_notice` VALUES (4, 'xxxx', '', 0x00, '', '', '2022-07-18 08:00:00', '', '2022-07-18 08:00:00', '', NULL, NULL);
INSERT INTO `sys_notice` VALUES (5, 'xxxx', '', 0x00, '', '', '2022-07-18 08:00:00', '', '2022-07-18 08:00:00', '', NULL, NULL);
INSERT INTO `sys_notice` VALUES (7, 'xxxx1', '', 0x00, '', '', '2022-07-18 08:00:00', '', '2022-07-18 08:00:00', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `ORG_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位编码',
  `ORG_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称',
  `ORG_PID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父ID',
  `STATUE` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用状态',
  `MEMO` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  `UPDATE_TIME` date DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `UPDATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改单位',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '1', 'IT科技公司', '0', '1', NULL, NULL, NULL, NULL, '2018-07-18', 'admin', '1');
INSERT INTO `sys_org` VALUES ('10', '10302', '采购部', '103', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('2', '101', '软件部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('3', '102', '技术部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('4', '103', '行政部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('5', '104', '销售部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('6', '10101', '研发一部', '101', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('7', '10102', '研发二部', '101', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('8', '10103', '数据部', '101', '1', NULL, NULL, NULL, NULL, '2018-07-18', 'admin', '1');
INSERT INTO `sys_org` VALUES ('9', '10301', '财务部', '103', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `ROLE_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编码',
  `ROLE_STATUS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用状态',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '2018-07-02', NULL, NULL);
INSERT INTO `sys_role` VALUES ('2', '普通用户', 'user', '1', '2018-07-02', NULL, NULL);
INSERT INTO `sys_role` VALUES ('afbeab7e44e64f1682ce3654e9785cbc', '11', '11', '1', '2018-07-06', 'admin', '1');
INSERT INTO `sys_role` VALUES ('e0f81201d9904d67826f6a0c1fa70150', 'test', 'test', '1', '2018-07-03', 'admin', '1');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `MENU_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `STATUES` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '使用状态',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('05b74af595cc493a89411fcf7d106e9f', '1', '404', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('071577c7609745279b4ceedb4a1c187d', 'e0f81201d9904d67826f6a0c1fa70150', '401', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('0c1d96477a70409ea0a3a9f058c245d2', 'e0f81201d9904d67826f6a0c1fa70150', '4', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('0c820a658f8a4021ac3ab2e683022ce4', '1', '101', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('14a7860661364caa8ca04fd57a1f4728', '1', '40101', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('1628da84d00642ed9d450dcaf36edb1e', '1', '501', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('17c4635ca31a41778904fdcad7d0b814', '1', '2', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('1ded0206bf4d4d15962db245630ea84e', '1', '40503', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('210bcbff400c49b589ebfbd41fc6a169', '1', '50101', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('2435e5c2c2cf49cb88a2acfcb36937d0', 'e0f81201d9904d67826f6a0c1fa70150', '101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('2d296e4f731f435b9b9c355d411a3235', '1', '601', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('310616f842b642a695de607546ce302e', '2', '1', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('3482ad333c06412ea5e718725281f25b', '1', '40502', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('3b7edf0f452f4b1985b7f858dd6dc609', 'e0f81201d9904d67826f6a0c1fa70150', '102', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('411e6772a618404daf3cd222f2e13e97', '1', '50102', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('4348e892cdf843c097eccfd0afa0ff15', '1', '202', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('474769387f0349ff9559f65254180ecd', 'e0f81201d9904d67826f6a0c1fa70150', '201', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('474ac479dd2b47af819c51f0f21a23d1', '1', '405', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('49a1f49147cd4ab299c6644d89d99f76', '1', '40403', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('4ad0b568b5e3403fb17b02e7b7e95335', '1', '102', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('4af03dc486d848d5a6754b20e31dc645', '1', '201', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('54e01784980348378b867171e4b29b22', 'e0f81201d9904d67826f6a0c1fa70150', '0', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('5e409f1813cb4685aa69c291966a89c7', '1', '40203', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('63df9783ed834e0ab8aa7470264fa31f', '1', '6', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('6548b24ba37e42fd8c2d65ac0c095769', 'e0f81201d9904d67826f6a0c1fa70150', '1', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('704a316959d74d6895ffaf7ebecec759', 'e0f81201d9904d67826f6a0c1fa70150', '202', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('711c12eaab764463847d31d7fc190f9d', '2', '4', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('77776b5700fd454aba742dce54228854', '1', '3', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('7b56d365087a4ade88cbda832a7bd1b3', '1', '40201', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('7b717d66178945f4b2c5998ccb3a0aa8', '1', '103', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('7d093b3ab6d64219912e883559954779', 'afbeab7e44e64f1682ce3654e9785cbc', '50101', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('7ddf780958434aa19f0184dc4530e878', '1', '40301', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('83dd65f4b8924f27ad39c7495560bb52', '1', '40103', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('8c5d7257b79846bea7427338264b218d', '1', '401', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('91734ea96ef4439c9b466aaac6b9a85b', '1', '40501', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('950caab1e4044570ba2653912d476796', '1', '40202', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('96c435f1edd34edd8ae27cb7c8397735', 'afbeab7e44e64f1682ce3654e9785cbc', '0', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a2f219fa60794d13b1d9a9012405d279', '2', '102', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a623d7c6c11c444fa7afcaa9f4d2d8d4', '2', '40301', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('abe27c456a6a432db8652fdc8acf2a3e', '2', '403', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('ad8f92525c6b430282a0a25ec3ec8054', '1', '40401', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('b0dd70b2b82643bd9e63ed5d79e50930', '2', '401', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('bf9095f77a3145d0b13689909230143c', '1', '40104', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('c0ce18d8921c4196b816d64561e86681', 'afbeab7e44e64f1682ce3654e9785cbc', '501', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('cd6e3cf3565443809329e73ed98724b3', 'e0f81201d9904d67826f6a0c1fa70150', '2', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('cf15a1e3eeb44c579b985bcdccf48c02', 'afbeab7e44e64f1682ce3654e9785cbc', '5', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d0f0b1bf10af4aeabba330c58b814a6c', '2', '103', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d27bbf8c73e34a4bb82079135a79144d', '1', '1', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('d3058fad97134879a520a9e7fa074b9b', '1', '40402', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('d40643ab3b774cb58ce412ee361bdd63', '1', '40302', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('d6519b48a5934880a2ffcc0c15ff5b3e', '2', '101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('e019ea1b43a245c6b8811d27245f1d0f', '1', '0', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('e041eeb5682042a8aa8bbc180cbfdeed', '1', '403', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('e39236d606d04eed8bcd1dc9a89ce4af', '1', '40102', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('e4010b848f8740e1811e11ce07253ef7', '1', '5', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('ee7e72212db84a9e9b782fa2a7aa443e', '1', '402', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f0880f75f2df4b41ae440cc1d4cea62a', 'e0f81201d9904d67826f6a0c1fa70150', '40101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('f267a25466e846a6a9a55cdfa613da87', '1', '4', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f3a36cdfe7ca4ff8b3d7cb1a7ba9818e', 'e0f81201d9904d67826f6a0c1fa70150', '103', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('f97af66ca3d34bcfa8bd9ead643c9e1e', '1', '40303', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('faa792c3445847108e2dc90ada5d4b2a', '2', '40101', '1', '2018-07-04', 'admin', '1');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `STATUES` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('2833512184b94ca7b9c1aff7c12ffb6c', '1', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_role_user` VALUES ('3c85915321a34bd3a3437f536ba8c557', '2', 'test', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('4ac2842607214c61b3199a0214459ae1', 'afbeab7e44e64f1682ce3654e9785cbc', '11', '1', '2022-07-22', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('6a6d0bd0f74d4a55bb209b3f773aa007', 'e0f81201d9904d67826f6a0c1fa70150', 'test1', '1', '2022-07-22', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('84cbdb03f81b4f52a9da87602645422e', 'afbeab7e44e64f1682ce3654e9785cbc', 'test1', '1', '2022-07-22', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('c674395278fa436bbf7aee14ba493a55', 'e0f81201d9904d67826f6a0c1fa70150', 'test', '1', '2022-07-22', 'admin', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `LOGINID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `SALT` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码盐',
  `ORGID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位ID',
  `TELPHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `ADDR` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `STATUE` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `MEMO` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` date DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_ORG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建单位',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', '0b0a392fb465cd948d3d94d82b25776d', 'r1S0c1Rvw9fzoUU4', '1', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('1c10c112b00a47729ab9bce1e81f4534', '123', '1123', '9c94e1730c574726037ad58c0f6210b6', 'saFYiwrYIVnNIa0S', NULL, '11111111111', '11@qq.com', '123', '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('a29d4214386d4857a9233fe4c5af3638', 'test', '测试用户', '211165a317c4de5c52154e7bbfd24d5b', '2zeEU7J0H3FRvy65', '10103', '12345678911', '123456@qq.com', 'test', '1', NULL, '2018-06-25', 'admin', NULL);
INSERT INTO `sys_user` VALUES ('af0f2dac9a5c4af5bf0c8c65294f5ac8', '11', '11', '57a5158860ca791c1652e44c3f989b11', 'lHBXgZwa8oXqSyzK', '104', '11111111111', '11@qq.com', '11', '1', NULL, '2018-06-27', 'admin', NULL);
INSERT INTO `sys_user` VALUES ('e6802c17c52646479f7d1427bc6d5b48', 'test1', '测试', 'd913d97d61c423d85b813757f59b9358', 'FmYuAUYx4YRaYdXj', '10103', '11111111111', '111@qq.com', NULL, '1', NULL, '2018-07-03', 'admin', '1');

-- ----------------------------
-- Function structure for getDicText
-- ----------------------------
DROP FUNCTION IF EXISTS `getDicText`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getDicText`(define VARCHAR(255),code VARCHAR(255)) RETURNS varchar(255) CHARSET utf8mb3
    DETERMINISTIC
begin  
        DECLARE dicText VARCHAR(255) DEFAULT '';  
         
        SELECT DICNAME INTO dicText FROM sys_dic WHERE DICDEFINE = define and DICCODE = `code`;  
       
        RETURN dicText;  
      end
;;
delimiter ;

-- ----------------------------
-- Function structure for getOrgName
-- ----------------------------
DROP FUNCTION IF EXISTS `getOrgName`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getOrgName`(`code` VARCHAR(255)) RETURNS varchar(255) CHARSET utf8mb3
BEGIN
	DECLARE orgName VARCHAR(255) DEFAULT '';

	SELECT ORG_NAME INTO orgName FROM sys_org WHERE ORG_CODE = `code`;  

	RETURN orgName;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for getPar
-- ----------------------------
DROP FUNCTION IF EXISTS `getPar`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getPar`() RETURNS varchar(255) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
BEGIN
  DECLARE sub VARCHAR(255) DEFAULT '';
	
  SELECT (@id := GROUP_CONCAT( parent_user_id SEPARATOR ',' )) INTO sub FROM app_member ;
	
	RETURN sub;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
