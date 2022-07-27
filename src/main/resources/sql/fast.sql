/*
 Navicat Premium Data Transfer

 Source Server         : 测试服务器
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 119.3.204.184:3306
 Source Schema         : fast

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 27/07/2022 18:13:06
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
  `amount` decimal(10, 2) DEFAULT NULL COMMENT '交易金额',
  `addtime` datetime(0) DEFAULT NULL COMMENT '下单时间',
  `endtime` datetime(0) DEFAULT NULL COMMENT '完成交易时间',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态 0待付款 1交易完成 2用户取消 3强制完成 4强制取消 5交易冻结',
  `commission` decimal(10, 2) DEFAULT NULL COMMENT '佣金',
  `c_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '佣金发放状态 0未发放 1已发放 2账号冻结',
  `add_id` bigint(0) DEFAULT NULL COMMENT '会员收货地址id',
  `goods_id` bigint(0) DEFAULT NULL COMMENT '商品ID',
  `goods_count` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品数量',
  `hid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0显示1隐藏',
  `san` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qiang` bigint(0) DEFAULT NULL COMMENT '抢单数',
  `liandanno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isliandan` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  `min` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '最小价',
  `max` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '最大价',
  `sign` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0不卡卡1卡单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '抢单业务主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_convey
-- ----------------------------
INSERT INTO `app_convey` VALUES (1, 123, 0.06, '2022-07-11 00:00:00', '2022-07-11 00:00:00', '1', 0.01, '1', 1234, 121212, '1', '0', NULL, 1, NULL, NULL, NULL, NULL, 0.00, 0.00, '0');
INSERT INTO `app_convey` VALUES (21, 111111, 0.08, '2022-07-11 00:00:00', NULL, '1', 0.01, '1', 123123, 121212, '1', '0', '', 1, '', '', '', '', 0.00, 100.00, '0');
INSERT INTO `app_convey` VALUES (22, 111111, 0.06, '2022-07-11 00:00:00', NULL, '1', 0.01, '1', 123123, 121212, '1', '0', '', 1, '', '', '', '', 0.00, 100.00, '0');
INSERT INTO `app_convey` VALUES (23, NULL, 0.00, '2022-07-13 08:00:00', NULL, NULL, 0.00, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'UB20220713978436', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (24, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'UB20220713131934', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (25, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'UB20220713330231', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (26, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'UB20220713744395', 0.00, 0.00, NULL);
INSERT INTO `app_convey` VALUES (27, NULL, 3900.00, '2022-07-13 08:00:00', NULL, NULL, 175.50, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 'UB20220713624015', 0.00, 0.00, NULL);

-- ----------------------------
-- Table structure for app_goods
-- ----------------------------
DROP TABLE IF EXISTS `app_goods`;
CREATE TABLE `app_goods`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商店名称',
  `goods_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `goods_info` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品描述',
  `goods_price` decimal(10, 2) DEFAULT NULL COMMENT '商品价格',
  `goods_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品展示图片',
  `goods_add_time` datetime(0) DEFAULT NULL COMMENT '商品添加时间',
  `status` int(0) DEFAULT NULL COMMENT '上架状态 0不上架 1上架',
  `goods_sort_id` bigint(0) DEFAULT NULL COMMENT '商品分类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

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
  `min` decimal(10, 2) DEFAULT NULL COMMENT '最小金额限制',
  `level_id` bigint(0) DEFAULT NULL COMMENT '等级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

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
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `id_card_num` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号码',
  `id_status` int(0) DEFAULT NULL COMMENT '实名认证状态，0未审核，1审核通过，2审核不通过',
  `balance` decimal(10, 2) DEFAULT NULL COMMENT '账户余额',
  `freeze_balance` decimal(10, 2) DEFAULT NULL COMMENT '账号冻结金额',
  `recharge_num` decimal(10, 2) DEFAULT NULL COMMENT '日充值金额',
  `deposit_num` decimal(10, 2) DEFAULT NULL COMMENT '日提现金额',
  `deduction_num` decimal(10, 2) DEFAULT NULL COMMENT '扣除金额',
  `top_pic` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '身份证正面图',
  `bot_pic` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '身份证正面图',
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
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `company_id` bigint(0) DEFAULT NULL COMMENT '机构id',
  `invite_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码',
  `deal_status` int(0) DEFAULT NULL COMMENT '交易状态:交易冻结1停止交易2等待交易3交易中',
  `deal_error` int(0) DEFAULT NULL COMMENT '违规次数',
  `deal_reward_count` int(0) DEFAULT NULL COMMENT '奖励交易次数',
  `deal_count` int(0) DEFAULT NULL COMMENT '当日交易次数',
  `deal_time` datetime(0) DEFAULT NULL COMMENT '最后交易日期(年月日)',
  `active` int(0) DEFAULT NULL COMMENT '激活状态，0未激活(首次充值发放推广奖励)，1已激活',
  `match_min` int(0) DEFAULT NULL COMMENT '最小匹配',
  `match_max` int(0) DEFAULT NULL COMMENT '最大匹配',
  `registration_time` datetime(0) DEFAULT NULL COMMENT '会员注册时间',
  `member_status` int(0) DEFAULT NULL COMMENT '会员状态:1.真人2.假人',
  `register_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册ip',
  `register_country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册国家',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member
-- ----------------------------
INSERT INTO `app_member` VALUES (1, 4, '333', '11', '111', '111', 1, 802.00, 1.00, 1.00, 1.00, 1.00, '1', '1', '1', '1', 1, '1', 1, 1, 1, '1', '1', 1, '2022-07-05 15:52:55', '2022-07-05 15:53:01', '111', '2022-07-12 15:53:07', '1', '2022-07-12 15:53:11', '1', 1, '1', 1, 1, 1, 1, '2022-07-13 15:53:21', 1, 1, 1, '2022-07-14 15:53:30', 1, '1', '1');
INSERT INTO `app_member` VALUES (2, 1, '123456', '测试会员登录', '111', '111', 1, 76279.50, 1.00, 1.00, 1.00, 1.00, '1', '1', '1', '123456', 1, '1', 1, 1, 1, '1', '15778761099', 1, '2022-07-05 15:52:55', '2022-07-13 17:32:20', '111', '2022-07-12 15:53:07', '1', '2022-07-12 15:53:11', '1', 1, '123qwe12', 1, 1, 1, 1, '2022-07-13 15:53:21', 1, 1, 1, '2022-07-14 15:53:30', 1, '1', '1');
INSERT INTO `app_member` VALUES (11, 1, 'wx_user1', 'a注册新用户', NULL, NULL, NULL, NULL, 0.00, 0.00, 0.00, 0.00, NULL, NULL, NULL, '123456', 2, '测试会员登录', 1, 1, 0, '2819708@qq.com', '13523532415', 1, NULL, NULL, 'wx_user1', '2022-07-13 18:21:09', NULL, NULL, NULL, 1, 'z8519UI9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-07-13 18:21:09', 1, NULL, NULL);

-- ----------------------------
-- Table structure for app_member_account_change
-- ----------------------------
DROP TABLE IF EXISTS `app_member_account_change`;
CREATE TABLE `app_member_account_change`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(0) DEFAULT NULL COMMENT '账户ID',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `currency_type` int(0) DEFAULT NULL COMMENT '充值类型 1.USDT',
  `opera_type` int(0) DEFAULT NULL COMMENT '操作类型【1.充值 2.减少 3.冻结】',
  `pre_opera_mount` decimal(10, 2) DEFAULT NULL COMMENT '操作前余额',
  `opera_mount` decimal(10, 2) DEFAULT NULL COMMENT '操作金额',
  `total_mount` decimal(10, 2) DEFAULT NULL COMMENT '当前总计余额',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员账户变更表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_account_change
-- ----------------------------
INSERT INTO `app_member_account_change` VALUES (21, 111111, 12341234, 1, 1, 100.00, 50.00, 150.00, '123123', '2022-07-12 08:00:00', '111', '2022-07-12 08:00:00');
INSERT INTO `app_member_account_change` VALUES (22, 12341234, 12341234, 1, 1, 100.00, 50.00, 150.00, '123123', '2022-07-12 08:00:00', '111', '2022-07-12 08:00:00');
INSERT INTO `app_member_account_change` VALUES (23, NULL, 2, NULL, 2, 600.00, 0.00, NULL, '111', '2022-07-13 17:30:50', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (24, NULL, 2, NULL, 2, 196275.50, 3900.00, NULL, '111', '2022-07-13 17:40:41', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (25, NULL, 2, NULL, 2, 4275.50, 3900.00, NULL, '111', '2022-07-13 17:44:48', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (26, NULL, 2, NULL, 2, 56275.50, 3900.00, NULL, '111', '2022-07-13 17:47:50', NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (27, NULL, 2, NULL, 2, 80000.00, 3900.00, 76275.50, '111', '2022-07-13 18:28:43', NULL, NULL);

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
INSERT INTO `app_member_address` VALUES (1, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (21, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (22, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (23, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (24, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (25, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (26, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (27, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);
INSERT INTO `app_member_address` VALUES (28, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员银行卡信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_bank
-- ----------------------------
INSERT INTO `app_member_bank` VALUES (2, 12356, 'uuu', 'uuu', 'uuu', 'uuu', 'u', 'u', 'uuu', 0, 'uuu');

-- ----------------------------
-- Table structure for app_member_level
-- ----------------------------
DROP TABLE IF EXISTS `app_member_level`;
CREATE TABLE `app_member_level`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `members_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员名称',
  `order_num` int(0) DEFAULT NULL COMMENT '接单限制',
  `member_price` decimal(18, 2) DEFAULT NULL COMMENT '会员价格',
  `register_time` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `commission` decimal(18, 4) DEFAULT NULL COMMENT '佣金比例',
  `members_level` int(0) DEFAULT 1 COMMENT '会员等级',
  `withdrawal_times` int(0) DEFAULT NULL COMMENT '提现次数',
  `withdrawal_min` int(0) DEFAULT NULL COMMENT '提现最小金额',
  `withdrawal_max` int(0) DEFAULT NULL COMMENT '提现最大金额',
  `num_min` int(0) DEFAULT NULL COMMENT '最小余额',
  `withdrawal_nim_order` int(0) DEFAULT NULL COMMENT '提现最少完成订单数',
  `auto_vip_xu_num` int(0) DEFAULT NULL COMMENT '自动升级vip需要邀请的人数',
  `service_charge` decimal(18, 2) DEFAULT NULL COMMENT '提现手续费',
  `pic` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_level
-- ----------------------------
INSERT INTO `app_member_level` VALUES (1, '黄金会员', 10, 1000.00, '2022-07-13 17:24:51', 0.0450, 3, 5, 200, 8000, 10, 10, 10, 10.00, '1111');

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
INSERT INTO `sys_menu` VALUES ('85f129b57df04d3bbe34c28eb0599fec', '404', '单位管理', '4', '/sys/org/list', NULL, '1', 'fa-asterisk', '4', '2018-07-05', 'admin', '1', '2018-07-05', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('9', '4', '系统管理', '0', NULL, NULL, '0', '&#xe65d;', '1', '2018-06-21', '', '', '2018-07-04', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('9ccf7ce73d084144ac87d1d2553ce0c4', '50101', 'add', '501', NULL, 'test:add', '2', 'fa-plus', NULL, '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('a50bef14830c4327addddddd2717e41c', '40401', '新增', '404', NULL, 'org:add', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('b13bb9138c694186aa16bc018e458943', '40301', '新增', '403', NULL, 'role:add', '2', NULL, '1', '2018-07-04', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('c5d03ff0e0b24917a13451611f489e03', '5', 'test', '0', NULL, NULL, '0', '&#xe6b1;', '5', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('d73575540b1c4b0f9e88d9d4d25c5ce4', '403', '角色管理', '4', '/sys/role/list', NULL, '1', '&#xe653;', '3', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('e5bbc6c38c1a4eada0b45c542e74b0ac', '501', 'test1', '5', 'xxx', NULL, '1', '&#xe66c;', '1', '2018-07-02', 'admin', '1', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('fc65c4b0ad76432c8a4b30f852b3346f', '50102', 'del', '501', NULL, 'test:del', '2', NULL, NULL, '2018-07-05', 'admin', '1', '2018-07-08', 'admin', '1');

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
INSERT INTO `sys_role_menu` VALUES ('03df78f0082045d1a3b2570295810246', '1', '40203', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('03f8d644c24046579eb6fa644f3f4a04', '1', '40401', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('048d051b46ae4f03a3a7594f0579e0c3', '1', '40503', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('071577c7609745279b4ceedb4a1c187d', 'e0f81201d9904d67826f6a0c1fa70150', '401', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('0c1d96477a70409ea0a3a9f058c245d2', 'e0f81201d9904d67826f6a0c1fa70150', '4', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('1cf0761b8b164d8597693885b4de926a', '1', '40502', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('1e61ea030d2b421c826f04ff7237c4a6', '1', '404', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('1ff9a2cecff845a9b6401e7b592ab867', '1', '3', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('2435e5c2c2cf49cb88a2acfcb36937d0', 'e0f81201d9904d67826f6a0c1fa70150', '101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('310616f842b642a695de607546ce302e', '2', '1', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('340956f332c340d68095e911777d31a7', '1', '40103', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('3b7edf0f452f4b1985b7f858dd6dc609', 'e0f81201d9904d67826f6a0c1fa70150', '102', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('474769387f0349ff9559f65254180ecd', 'e0f81201d9904d67826f6a0c1fa70150', '201', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('54e01784980348378b867171e4b29b22', 'e0f81201d9904d67826f6a0c1fa70150', '0', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('63323effb0d0468b9385ce029f37cb22', '1', '40403', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('633e184bf65e4d2cbf3bfee5ca8f10c5', '1', '40501', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('6548b24ba37e42fd8c2d65ac0c095769', 'e0f81201d9904d67826f6a0c1fa70150', '1', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('6cc781856ba54a50b26bfeec73e424f1', '1', '40101', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('704a316959d74d6895ffaf7ebecec759', 'e0f81201d9904d67826f6a0c1fa70150', '202', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('711c12eaab764463847d31d7fc190f9d', '2', '4', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('78848e0652f9420d81fb5c1c7827ef6d', '1', '40302', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('7d093b3ab6d64219912e883559954779', 'afbeab7e44e64f1682ce3654e9785cbc', '50101', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('80f4306fb4fd451b995667cdac1f7a22', '1', '1', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('856cd23142b249238bd170e54a94d1f9', '1', '201', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('859a808a78d14321bed27d0e3add6de3', '1', '0', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('8ec446f758a14f93a11808fddfad0d0e', '1', '202', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('8eda5af323cd403b9c51012f33ef9b6f', '1', '405', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('942d41c23a3a4248939eb38b6374aa47', '1', '102', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('96c435f1edd34edd8ae27cb7c8397735', 'afbeab7e44e64f1682ce3654e9785cbc', '0', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('98d768515fcc4d6d9850982e1799254a', '1', '101', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a18a6c14f6524ecfa916c8595e30f551', '1', '40303', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a2f219fa60794d13b1d9a9012405d279', '2', '102', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a609656240e048e2934545af2068d198', '1', '40301', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('a623d7c6c11c444fa7afcaa9f4d2d8d4', '2', '40301', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('abe27c456a6a432db8652fdc8acf2a3e', '2', '403', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('af94eff45faa429b87109414b520c9bd', '1', '403', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('b0dd70b2b82643bd9e63ed5d79e50930', '2', '401', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('b8eae2c5ca78467b9abfb0c712582fc7', '1', '40104', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('ba87097a511d402a8fdda420cc396619', '1', '103', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('c0ce18d8921c4196b816d64561e86681', 'afbeab7e44e64f1682ce3654e9785cbc', '501', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('cd6e3cf3565443809329e73ed98724b3', 'e0f81201d9904d67826f6a0c1fa70150', '2', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('cf114e50491a4265aeacc888d60c59d0', '1', '4', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('cf15a1e3eeb44c579b985bcdccf48c02', 'afbeab7e44e64f1682ce3654e9785cbc', '5', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d0f0b1bf10af4aeabba330c58b814a6c', '2', '103', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d46d5ea3d0394697ae7736ce08edeb60', '1', '40201', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d51ed7e9bd474784b29db4b1940b632a', '1', '40202', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('d6519b48a5934880a2ffcc0c15ff5b3e', '2', '101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('e22568868baa41a4beb02494723590f5', '1', '2', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('e7204489f736411abdc6e68e1eb61589', '1', '401', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('eb13d97a689749158ccec4cdd40c0ccf', '1', '40402', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('efee85ab210d4704a3bd12bcd516be38', '1', '40102', '1', '2018-07-08', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('f0880f75f2df4b41ae440cc1d4cea62a', 'e0f81201d9904d67826f6a0c1fa70150', '40101', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('f3a36cdfe7ca4ff8b3d7cb1a7ba9818e', 'e0f81201d9904d67826f6a0c1fa70150', '103', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_menu` VALUES ('f5aa9ed25b1d4d95b5ca3ad175bca019', '1', '402', '1', '2018-07-08', 'admin', '1');
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
INSERT INTO `sys_role_user` VALUES ('3c85915321a34bd3a3437f536ba8c557', '2', 'test', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('57925ebca6cb43ec99485db8ee799884', '1', 'admin', '1', '2018-07-04', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('6245d3982cf84b478171254c0ab5b941', 'afbeab7e44e64f1682ce3654e9785cbc', '11', '1', '2018-07-18', 'admin', '1');
INSERT INTO `sys_role_user` VALUES ('fe23381a286f4847bde61936e0b0d659', 'e0f81201d9904d67826f6a0c1fa70150', 'test', '1', '2018-07-04', 'admin', '1');

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

SET FOREIGN_KEY_CHECKS = 1;
