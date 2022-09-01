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

 Date: 29/07/2022 18:44:34
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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '抢单业务主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_convey
-- ----------------------------
INSERT INTO `app_convey` VALUES (1, 123, 0.06, '2022-07-11 00:00:00', '2022-07-11 00:00:00', '1', 0.01, '1', 1234, 121212, '1', '0', 1, 'UB20220719771691', 0.00, 0.00, '0', 1);
INSERT INTO `app_convey` VALUES (95, 2, 770.00, '2022-07-19 17:07:58', '2022-07-19 17:07:58', '1', 1.93, '1', 2, 26, NULL, NULL, 1, 'UB20220719771694', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (96, 2, 770.00, '2022-07-19 17:16:21', '2022-07-19 17:16:21', '1', 1.93, '1', 2, 26, NULL, NULL, 1, 'UB20220719935146', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (97, 2, 770.00, '2022-07-19 19:05:36', '2022-07-19 19:05:36', '1', 1.93, '1', 2, 26, NULL, NULL, 2, 'UB20220719980964', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (98, 2, 770.00, '2022-07-19 19:05:47', '2022-07-19 19:05:47', '1', 1.93, '1', 2, 26, NULL, NULL, 3, 'UB20220719351403', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (99, 2, 770.00, '2022-07-19 19:06:01', '2022-07-19 19:06:01', '1', 1.93, '1', 2, 26, NULL, NULL, 4, 'UB20220719944652', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (101, 11, 0.00, '2022-07-27 18:13:42', '2022-07-27 18:13:42', '1', 0.00, '1', 30, NULL, NULL, NULL, 1, 'UB20220727930765', 0.00, 0.00, NULL, 1);
INSERT INTO `app_convey` VALUES (102, 11, 0.00, '2022-07-27 18:15:43', '2022-07-27 18:15:43', '1', 0.00, '1', 30, NULL, NULL, NULL, 2, 'UB20220727755053', 0.00, 0.00, NULL, 1);

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
  `upload_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_file
-- ----------------------------
INSERT INTO `app_file` VALUES ('000b75ac-e28e-4509-bd0d-f9880580538c', 'png', '2022-07-28 11:16:08', '000b75ac-e28e-4509-bd0d-f9880580538c.png', 'pic/000b75ac-e28e-4509-bd0d-f9880580538c.png', NULL);
INSERT INTO `app_file` VALUES ('08418ffe-d246-4089-b4f0-449f3f0dfedb', 'jpg', '2022-07-25 17:11:11', '08418ffe-d246-4089-b4f0-449f3f0dfedb.jpg', 'pic/08418ffe-d246-4089-b4f0-449f3f0dfedb.jpg', NULL);
INSERT INTO `app_file` VALUES ('09347bc9-85b8-4e3b-a963-bd746f4d72cf', 'png', '2022-07-28 11:53:57', '09347bc9-85b8-4e3b-a963-bd746f4d72cf.png', 'pic/09347bc9-85b8-4e3b-a963-bd746f4d72cf.png', NULL);
INSERT INTO `app_file` VALUES ('09e7f063-ce8f-4ef1-920e-8ce021bf166a', 'png', '2022-07-28 10:51:29', '09e7f063-ce8f-4ef1-920e-8ce021bf166a.png', 'pic/09e7f063-ce8f-4ef1-920e-8ce021bf166a.png', NULL);
INSERT INTO `app_file` VALUES ('0a76581f-892a-48b4-adef-6cdf06b089c7', 'jpg', '2022-07-25 16:59:41', '0a76581f-892a-48b4-adef-6cdf06b089c7.jpg', 'pic/0a76581f-892a-48b4-adef-6cdf06b089c7.jpg', NULL);
INSERT INTO `app_file` VALUES ('0a84140d-bbe2-474f-970c-2830edc00bdb', 'jpg', '2022-07-25 17:51:32', '0a84140d-bbe2-474f-970c-2830edc00bdb.jpg', 'pic/0a84140d-bbe2-474f-970c-2830edc00bdb.jpg', NULL);
INSERT INTO `app_file` VALUES ('12b8ea30-730c-48cc-b520-c6e2a8d3a912', 'png', '2022-07-28 11:31:53', '12b8ea30-730c-48cc-b520-c6e2a8d3a912.png', 'pic/12b8ea30-730c-48cc-b520-c6e2a8d3a912.png', NULL);
INSERT INTO `app_file` VALUES ('135064df-e856-459f-8a8c-6e3ce6117ee3', 'jpg', '2022-07-25 17:21:37', '135064df-e856-459f-8a8c-6e3ce6117ee3.jpg', 'pic/135064df-e856-459f-8a8c-6e3ce6117ee3.jpg', NULL);
INSERT INTO `app_file` VALUES ('16cff18f-3393-46a7-b65a-77c3e48da449', 'png', '2022-07-28 15:55:23', '16cff18f-3393-46a7-b65a-77c3e48da449.png', 'pic/16cff18f-3393-46a7-b65a-77c3e48da449.png', NULL);
INSERT INTO `app_file` VALUES ('1c30d9c3-4c2e-46cf-bc37-522dbf6182fd', 'png', '2022-07-28 11:56:30', '1c30d9c3-4c2e-46cf-bc37-522dbf6182fd.png', 'pic/1c30d9c3-4c2e-46cf-bc37-522dbf6182fd.png', NULL);
INSERT INTO `app_file` VALUES ('227fe6eb-707e-4d6c-b799-a53f59e313a2', 'jpg', '2022-07-25 17:19:50', '227fe6eb-707e-4d6c-b799-a53f59e313a2.jpg', 'pic/227fe6eb-707e-4d6c-b799-a53f59e313a2.jpg', NULL);
INSERT INTO `app_file` VALUES ('257ee654-1793-42f9-b5b0-d4030fb3cd12', 'png', '2022-07-28 10:51:21', '257ee654-1793-42f9-b5b0-d4030fb3cd12.png', 'pic/257ee654-1793-42f9-b5b0-d4030fb3cd12.png', NULL);
INSERT INTO `app_file` VALUES ('2f82a7cf-e14d-42bb-8237-1f90d8029c74', 'png', '2022-07-28 15:12:34', '2f82a7cf-e14d-42bb-8237-1f90d8029c74.png', 'pic/2f82a7cf-e14d-42bb-8237-1f90d8029c74.png', NULL);
INSERT INTO `app_file` VALUES ('327d9785-3f28-48dd-9a3a-397accabe08b', 'png', '2022-07-28 15:19:01', '327d9785-3f28-48dd-9a3a-397accabe08b.png', 'pic/327d9785-3f28-48dd-9a3a-397accabe08b.png', NULL);
INSERT INTO `app_file` VALUES ('36f7adfd-fad3-49b0-99fc-4d02fba4c8cb', 'jpg', '2022-07-25 17:48:23', '36f7adfd-fad3-49b0-99fc-4d02fba4c8cb.jpg', 'pic/36f7adfd-fad3-49b0-99fc-4d02fba4c8cb.jpg', NULL);
INSERT INTO `app_file` VALUES ('3c239d8c-2eb7-4b6a-ac1a-f185c1c8794a', 'png', '2022-07-25 17:52:48', '3c239d8c-2eb7-4b6a-ac1a-f185c1c8794a.png', 'pic/3c239d8c-2eb7-4b6a-ac1a-f185c1c8794a.png', NULL);
INSERT INTO `app_file` VALUES ('3dc0ca2d-347a-464e-b84e-018abfbe64b4', 'png', '2022-07-26 10:30:15', '3dc0ca2d-347a-464e-b84e-018abfbe64b4.png', 'pic/3dc0ca2d-347a-464e-b84e-018abfbe64b4.png', NULL);
INSERT INTO `app_file` VALUES ('4df71d1a-5855-46fa-821a-754d1cc603a4', 'jpg', '2022-07-25 17:50:45', '4df71d1a-5855-46fa-821a-754d1cc603a4.jpg', 'pic/4df71d1a-5855-46fa-821a-754d1cc603a4.jpg', NULL);
INSERT INTO `app_file` VALUES ('51255347-19e2-464e-8a4d-8aae6c2da3c9', 'png', '2022-07-28 11:40:14', '51255347-19e2-464e-8a4d-8aae6c2da3c9.png', 'pic/51255347-19e2-464e-8a4d-8aae6c2da3c9.png', NULL);
INSERT INTO `app_file` VALUES ('51c62b74-7411-4535-b124-dbcb44b4613a', 'png', '2022-07-28 11:32:03', '51c62b74-7411-4535-b124-dbcb44b4613a.png', 'pic/51c62b74-7411-4535-b124-dbcb44b4613a.png', NULL);
INSERT INTO `app_file` VALUES ('5803b53c-7d39-4435-ade9-791099f2926f', 'jpg', '2022-07-29 15:20:18', '5803b53c-7d39-4435-ade9-791099f2926f.jpg', 'pic/5803b53c-7d39-4435-ade9-791099f2926f.jpg', NULL);
INSERT INTO `app_file` VALUES ('585a6d8c-6ddc-4235-a519-93aad367d287', 'jpg', '2022-07-29 17:36:24', '585a6d8c-6ddc-4235-a519-93aad367d287.jpg', 'pic/585a6d8c-6ddc-4235-a519-93aad367d287.jpg', NULL);
INSERT INTO `app_file` VALUES ('5db38ced-1c53-48db-9576-b364251d80a6', 'png', '2022-07-28 15:05:54', '5db38ced-1c53-48db-9576-b364251d80a6.png', 'pic/5db38ced-1c53-48db-9576-b364251d80a6.png', NULL);
INSERT INTO `app_file` VALUES ('5dd405f9-c5b5-49c6-bd0b-f108fa408910', 'jpg', '2022-07-25 17:24:00', '5dd405f9-c5b5-49c6-bd0b-f108fa408910.jpg', 'pic/5dd405f9-c5b5-49c6-bd0b-f108fa408910.jpg', NULL);
INSERT INTO `app_file` VALUES ('5f64bd93-d7fb-46d8-a9ec-17d1b26ab5b4', 'jpg', '2022-07-25 18:04:33', '5f64bd93-d7fb-46d8-a9ec-17d1b26ab5b4.jpg', 'pic/5f64bd93-d7fb-46d8-a9ec-17d1b26ab5b4.jpg', NULL);
INSERT INTO `app_file` VALUES ('61d05c04-c9a6-453b-a7c7-0e040124b101', 'jpg', '2022-07-26 10:03:51', '61d05c04-c9a6-453b-a7c7-0e040124b101.jpg', 'pic/61d05c04-c9a6-453b-a7c7-0e040124b101.jpg', NULL);
INSERT INTO `app_file` VALUES ('65b23c83-a884-4fee-b942-4de399cd6327', 'png', '2022-07-28 11:39:06', '65b23c83-a884-4fee-b942-4de399cd6327.png', 'pic/65b23c83-a884-4fee-b942-4de399cd6327.png', NULL);
INSERT INTO `app_file` VALUES ('6abe57d0-1d57-4bbb-8d9b-a5a346c291a1', 'png', '2022-07-28 11:20:47', '6abe57d0-1d57-4bbb-8d9b-a5a346c291a1.png', 'pic/6abe57d0-1d57-4bbb-8d9b-a5a346c291a1.png', NULL);
INSERT INTO `app_file` VALUES ('70c2b856-e390-4a20-89a6-287bc8a62008', 'jpg', '2022-07-25 17:22:02', '70c2b856-e390-4a20-89a6-287bc8a62008.jpg', 'pic/70c2b856-e390-4a20-89a6-287bc8a62008.jpg', NULL);
INSERT INTO `app_file` VALUES ('7a02c102-9d6a-4838-b054-227444d8a501', 'png', '2022-07-28 10:52:45', '7a02c102-9d6a-4838-b054-227444d8a501.png', 'pic/7a02c102-9d6a-4838-b054-227444d8a501.png', NULL);
INSERT INTO `app_file` VALUES ('7aefc61a-73b0-482b-a656-7298e4d5e51c', 'png', '2022-07-28 17:17:45', '7aefc61a-73b0-482b-a656-7298e4d5e51c.png', 'pic/7aefc61a-73b0-482b-a656-7298e4d5e51c.png', NULL);
INSERT INTO `app_file` VALUES ('7cade0e2-371d-4048-a1d3-861f9b0954ca', 'jpg', '2022-07-29 18:35:58', '7cade0e2-371d-4048-a1d3-861f9b0954ca.jpg', 'pic/7cade0e2-371d-4048-a1d3-861f9b0954ca.jpg', NULL);
INSERT INTO `app_file` VALUES ('7f68e7b3-3aab-44e6-ad26-eb36afc596ee', 'jpg', '2022-07-27 17:57:11', '7f68e7b3-3aab-44e6-ad26-eb36afc596ee.jpg', 'pic/7f68e7b3-3aab-44e6-ad26-eb36afc596ee.jpg', NULL);
INSERT INTO `app_file` VALUES ('834dd269-d556-4743-a5fe-72ffa30b2c42', 'png', '2022-07-25 19:01:39', '834dd269-d556-4743-a5fe-72ffa30b2c42.png', 'pic/834dd269-d556-4743-a5fe-72ffa30b2c42.png', NULL);
INSERT INTO `app_file` VALUES ('857a4157-5a45-4dda-a536-4a5a92fc4f1a', 'jpg', '2022-07-29 15:21:46', '857a4157-5a45-4dda-a536-4a5a92fc4f1a.jpg', 'pic/857a4157-5a45-4dda-a536-4a5a92fc4f1a.jpg', NULL);
INSERT INTO `app_file` VALUES ('89afd9d1-e9d2-4a6b-8291-f2036c99ae1f', 'png', '2022-07-28 15:14:48', '89afd9d1-e9d2-4a6b-8291-f2036c99ae1f.png', 'pic/89afd9d1-e9d2-4a6b-8291-f2036c99ae1f.png', NULL);
INSERT INTO `app_file` VALUES ('8d60fea9-3f0e-4c7e-b427-753653013a9b', 'png', '2022-07-28 11:55:51', '8d60fea9-3f0e-4c7e-b427-753653013a9b.png', 'pic/8d60fea9-3f0e-4c7e-b427-753653013a9b.png', NULL);
INSERT INTO `app_file` VALUES ('90442a6d-5514-4a81-b1b5-3f21ce0b2288', 'png', '2022-07-28 11:38:15', '90442a6d-5514-4a81-b1b5-3f21ce0b2288.png', 'pic/90442a6d-5514-4a81-b1b5-3f21ce0b2288.png', NULL);
INSERT INTO `app_file` VALUES ('970ace51-4ae6-48a5-b30b-2f01472c0dd2', 'png', '2022-07-27 18:15:01', '970ace51-4ae6-48a5-b30b-2f01472c0dd2.png', 'pic/970ace51-4ae6-48a5-b30b-2f01472c0dd2.png', NULL);
INSERT INTO `app_file` VALUES ('9871c8ef-de92-4499-a0d5-ec80674dbc4c', 'jpg', '2022-07-29 17:40:45', '9871c8ef-de92-4499-a0d5-ec80674dbc4c.jpg', 'pic/9871c8ef-de92-4499-a0d5-ec80674dbc4c.jpg', NULL);
INSERT INTO `app_file` VALUES ('9d4452d2-db77-4081-8966-0da118a96d0d', 'png', '2022-07-28 11:18:34', '9d4452d2-db77-4081-8966-0da118a96d0d.png', 'pic/9d4452d2-db77-4081-8966-0da118a96d0d.png', NULL);
INSERT INTO `app_file` VALUES ('9df8ba24-0f45-470e-99dc-e810b7f5f1fb', 'png', '2022-07-28 11:43:21', '9df8ba24-0f45-470e-99dc-e810b7f5f1fb.png', 'pic/9df8ba24-0f45-470e-99dc-e810b7f5f1fb.png', NULL);
INSERT INTO `app_file` VALUES ('a6142837-cccb-4750-907a-36170aa3af0b', 'png', '2022-07-28 11:16:25', 'a6142837-cccb-4750-907a-36170aa3af0b.png', 'pic/a6142837-cccb-4750-907a-36170aa3af0b.png', NULL);
INSERT INTO `app_file` VALUES ('a62d27cc-e314-4af8-9d3a-7f7022a67d19', 'png', '2022-07-28 17:29:03', 'a62d27cc-e314-4af8-9d3a-7f7022a67d19.png', 'pic/a62d27cc-e314-4af8-9d3a-7f7022a67d19.png', NULL);
INSERT INTO `app_file` VALUES ('adc88955-084f-40e0-910c-ab12e7f13464', 'png', '2022-07-28 15:52:39', 'adc88955-084f-40e0-910c-ab12e7f13464.png', 'pic/adc88955-084f-40e0-910c-ab12e7f13464.png', NULL);
INSERT INTO `app_file` VALUES ('b7b2d36a-3d97-4be5-9772-885ffeacffd7', 'jpg', '2022-07-25 17:05:46', 'b7b2d36a-3d97-4be5-9772-885ffeacffd7.jpg', 'pic/b7b2d36a-3d97-4be5-9772-885ffeacffd7.jpg', NULL);
INSERT INTO `app_file` VALUES ('bc4c2eaa-3cd1-4f75-b057-90f7b15c69c7', 'jpg', '2022-07-29 18:13:01', 'bc4c2eaa-3cd1-4f75-b057-90f7b15c69c7.jpg', 'pic/bc4c2eaa-3cd1-4f75-b057-90f7b15c69c7.jpg', NULL);
INSERT INTO `app_file` VALUES ('c35c0ab6-96cf-4bcc-99d1-852013075454', 'png', '2022-07-28 15:17:40', 'c35c0ab6-96cf-4bcc-99d1-852013075454.png', 'pic/c35c0ab6-96cf-4bcc-99d1-852013075454.png', NULL);
INSERT INTO `app_file` VALUES ('c6c01af2-b8d1-4540-81b7-ad8b12718d92', 'png', '2022-07-28 11:23:22', 'c6c01af2-b8d1-4540-81b7-ad8b12718d92.png', 'pic/c6c01af2-b8d1-4540-81b7-ad8b12718d92.png', NULL);
INSERT INTO `app_file` VALUES ('cac4bbd0-7802-4271-920b-a6a2db5f1f0f', 'png', '2022-07-28 17:19:43', 'cac4bbd0-7802-4271-920b-a6a2db5f1f0f.png', 'pic/cac4bbd0-7802-4271-920b-a6a2db5f1f0f.png', NULL);
INSERT INTO `app_file` VALUES ('ceb5bd31-9be2-450a-9c38-4b3056f6df02', 'png', '2022-07-28 11:36:04', 'ceb5bd31-9be2-450a-9c38-4b3056f6df02.png', 'pic/ceb5bd31-9be2-450a-9c38-4b3056f6df02.png', NULL);
INSERT INTO `app_file` VALUES ('d2067918-e938-4412-ab7e-977c6f36c94c', 'png', '2022-07-27 18:15:08', 'd2067918-e938-4412-ab7e-977c6f36c94c.png', 'pic/d2067918-e938-4412-ab7e-977c6f36c94c.png', NULL);
INSERT INTO `app_file` VALUES ('d46b2e28-df33-4e26-b296-941f6aa59fb8', 'png', '2022-07-28 11:32:43', 'd46b2e28-df33-4e26-b296-941f6aa59fb8.png', 'pic/d46b2e28-df33-4e26-b296-941f6aa59fb8.png', NULL);
INSERT INTO `app_file` VALUES ('d4e7147d-37b5-49ba-8b57-01a90ec4b225', 'png', '2022-07-28 11:18:49', 'd4e7147d-37b5-49ba-8b57-01a90ec4b225.png', 'pic/d4e7147d-37b5-49ba-8b57-01a90ec4b225.png', NULL);
INSERT INTO `app_file` VALUES ('d87ceaf3-6ca0-4727-ad22-700c37110437', 'png', '2022-07-28 11:32:25', 'd87ceaf3-6ca0-4727-ad22-700c37110437.png', 'pic/d87ceaf3-6ca0-4727-ad22-700c37110437.png', NULL);
INSERT INTO `app_file` VALUES ('da809239-d2db-473e-8c46-73c223184be5', 'jpg', '2022-07-25 17:49:20', 'da809239-d2db-473e-8c46-73c223184be5.jpg', 'pic/da809239-d2db-473e-8c46-73c223184be5.jpg', NULL);
INSERT INTO `app_file` VALUES ('dd4c9f8d-284c-465a-9819-41ea617ab07e', 'png', '2022-07-28 11:39:29', 'dd4c9f8d-284c-465a-9819-41ea617ab07e.png', 'pic/dd4c9f8d-284c-465a-9819-41ea617ab07e.png', NULL);
INSERT INTO `app_file` VALUES ('eadcde4a-d330-4cda-be6c-27d2e417fc66', 'jpg', '2022-07-25 19:00:21', 'eadcde4a-d330-4cda-be6c-27d2e417fc66.jpg', 'pic/eadcde4a-d330-4cda-be6c-27d2e417fc66.jpg', NULL);
INSERT INTO `app_file` VALUES ('ec7f9db7-97c2-41cb-a4c0-830b1693df74', 'jpg', '2022-07-29 15:11:34', 'ec7f9db7-97c2-41cb-a4c0-830b1693df74.jpg', 'pic/ec7f9db7-97c2-41cb-a4c0-830b1693df74.jpg', NULL);
INSERT INTO `app_file` VALUES ('efeb6147-e3a5-4f1a-8498-22cd56d810b8', 'png', '2022-07-28 15:09:32', 'efeb6147-e3a5-4f1a-8498-22cd56d810b8.png', 'pic/efeb6147-e3a5-4f1a-8498-22cd56d810b8.png', NULL);
INSERT INTO `app_file` VALUES ('f074e161-46fd-4a77-858d-b340af9e65e4', 'png', '2022-07-28 15:07:00', 'f074e161-46fd-4a77-858d-b340af9e65e4.png', 'pic/f074e161-46fd-4a77-858d-b340af9e65e4.png', NULL);
INSERT INTO `app_file` VALUES ('f4e4bfe0-cd5f-41f1-9a46-cbaee37ef1ea', 'png', '2022-07-28 17:25:26', 'f4e4bfe0-cd5f-41f1-9a46-cbaee37ef1ea.png', 'pic/f4e4bfe0-cd5f-41f1-9a46-cbaee37ef1ea.png', NULL);
INSERT INTO `app_file` VALUES ('fb2f1c16-283c-43a4-9f1b-1ad9f2409a10', 'jpg', '2022-07-25 19:00:09', 'fb2f1c16-283c-43a4-9f1b-1ad9f2409a10.jpg', 'pic/fb2f1c16-283c-43a4-9f1b-1ad9f2409a10.jpg', NULL);
INSERT INTO `app_file` VALUES ('fd3ed6e0-636b-4e9b-a0a2-0ca26cc874db', 'png', '2022-07-28 15:13:47', 'fd3ed6e0-636b-4e9b-a0a2-0ca26cc874db.png', 'pic/fd3ed6e0-636b-4e9b-a0a2-0ca26cc874db.png', NULL);
INSERT INTO `app_file` VALUES ('fdc70dc2-4563-4d7d-a593-18ed2a496420', 'png', '2022-07-28 17:18:09', 'fdc70dc2-4563-4d7d-a593-18ed2a496420.png', 'pic/fdc70dc2-4563-4d7d-a593-18ed2a496420.png', NULL);

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `task_group` int(0) DEFAULT NULL COMMENT '任务组',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_goods
-- ----------------------------
INSERT INTO `app_goods` VALUES (23, 'ggg', 'gg2111', 'ggg', 100.00, '', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (24, 'ggg', 'gg', 'ggg', 2000.00, '', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (25, 'ggg', 'gg', 'ggg', 0.00, 'ggg', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (26, 'ggg', 'gg', 'ggg', 0.00, 'ggg', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (27, 'ggg', 'gg', 'ggg', 0.00, 'ggg', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (29, '666', '666', '666', 0.00, '', NULL, 0, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (30, '666', '666', '666', 0.00, '', NULL, 0, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (31, '666', '666', '666', 0.00, '', NULL, 0, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (32, '666', '666', '666', 400.00, '', NULL, 0, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (33, 'ggg', 'gg', 'ggg', 200.00, 'ggg', '2022-07-25 08:00:00', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (34, '9999', '999', '999', 90.00, '9999', NULL, 1, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (35, '9999', '999', '999', 90.00, '9999', NULL, 1, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (36, '店铺名称', '商品名称', '商品详细内容', 10000.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/5f64bd93-d7fb-46d8-a9ec-17d1b26ab5b4.jpg', NULL, NULL, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (37, '店铺名称2', '商品名称2', '商品详细内容', 998.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/834dd269-d556-4743-a5fe-72ffa30b2c42.png', NULL, NULL, 1, NULL, NULL);
INSERT INTO `app_goods` VALUES (38, 'Amazon', 'Asgard Melt-Blown Fabric Disposable', 'qeqeqeqwqwe', 100.00, '', '2022-07-28 11:20:43', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (39, 'Amazon', 'Sirona Menstrual Cup Wash - 100 m', 'rtwrwerwerwe', 7.95, '', '2022-07-28 11:20:43', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (40, 'Amazon', 'INDIGENOUS HONEY Raw Organic', 'rtyetetw', 41295.00, '', '2022-07-28 11:21:14', 1, 1, 1, NULL);
INSERT INTO `app_goods` VALUES (41, '221212', '2121', '12211212', 122112.00, '', '2022-07-29 14:57:15', 1, NULL, 1, NULL);
INSERT INTO `app_goods` VALUES (42, '店铺名称', '商品名称1111', '商品详细内容', 1000.00, '', '2022-07-29 15:11:40', 1, 55, 1, NULL);
INSERT INTO `app_goods` VALUES (43, '店铺名称', '添加测试', '商品详细内容商品详细内容商品详细内容', 12000.00, '', '2022-07-29 15:20:23', 1, 54, 1, NULL);

-- ----------------------------
-- Table structure for app_goods_sort
-- ----------------------------
DROP TABLE IF EXISTS `app_goods_sort`;
CREATE TABLE `app_goods_sort`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `commission_rate` float DEFAULT NULL COMMENT '佣金比例',
  `sort_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名称',
  `explain_simple` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `goods_add_time` datetime(0) DEFAULT NULL COMMENT '添加时间',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `bind_ level` int(0) DEFAULT NULL COMMENT '绑定会员等级',
  `min_amount` decimal(10, 2) DEFAULT NULL COMMENT '最低金额',
  `sort_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类logo',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_goods_sort
-- ----------------------------
INSERT INTO `app_goods_sort` VALUES (1, 0.006, 'jingdong', 'lv', '2022-07-28 17:10:48', 1, 1, 600.00, '');
INSERT INTO `app_goods_sort` VALUES (2, 0.004, 'huawei', 'hm', '2022-07-28 17:11:16', 1, 1, 200.00, NULL);
INSERT INTO `app_goods_sort` VALUES (54, NULL, '分类名称', '分类简介', '2022-07-28 18:00:10', 1, 1, 600.00, NULL);
INSERT INTO `app_goods_sort` VALUES (55, NULL, '分类名称2', '分类简介1', '2022-07-28 18:00:14', 1, 1, 1000.00, NULL);
INSERT INTO `app_goods_sort` VALUES (57, 0.23, '分类名称11', '分类简介', NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_goods_sort` VALUES (58, 0, '', '', '2022-07-29 10:32:03', 1, 0, 0.00, '');
INSERT INTO `app_goods_sort` VALUES (59, 0.5, '分类名称-编辑测试', '分类简介', '2022-07-29 10:32:19', 1, 0, 100.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/857a4157-5a45-4dda-a536-4a5a92fc4f1a.jpg');

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
  `invite_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码',
  `registration_time` datetime(0) DEFAULT NULL COMMENT '会员注册时间',
  `member_status` int(0) DEFAULT NULL COMMENT '会员状态:1.真人2.假人',
  `register_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册ip',
  `register_country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册国家',
  `total_commission` decimal(16, 2) DEFAULT 0.00 COMMENT '会员个人总佣金',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member
-- ----------------------------
INSERT INTO `app_member` VALUES (2, 1, 'wx_user1', 1401.00, 700.00, 0.00, 0.00, 0.00, NULL, '123456', 2, '测试会员登录', 1, 1, 0, '2819708@qq.com', '13523532415', 1, '10.128.0.6', '2022-07-27 16:25:32', 'wx_user1', '2022-07-13 18:21:09', NULL, 'z8519UI9', '2022-07-13 18:21:09', 1, '127.0.0.1', NULL, 3000.00, 1);
INSERT INTO `app_member` VALUES (14, 2, 'qwer11', 999.00, 10.00, 0.00, 0.00, 0.00, '', '123456', 11, '', 0, 1, 1, '', '15887877878', 0, '', '2022-07-15 08:00:00', '', '2022-07-15 08:00:00', '', '', '2022-07-15 08:00:00', 1, '192.168.2.6', '', 0.00, 1);
INSERT INTO `app_member` VALUES (15, 1, 'hzb', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', NULL, NULL, 1, 1, 0, NULL, '17736609390', 1, NULL, NULL, NULL, '2022-07-19 11:59:12', NULL, 'aabbcc', '2022-07-20 11:54:20', 1, '139.156.12.14', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (20, 1, 'rrr', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', NULL, NULL, 1, 1, 0, NULL, '17736609322', 1, NULL, NULL, 'admin', '2022-07-19 11:21:45', NULL, 'X18RuFI7', '2022-07-19 11:21:45', 1, '192.168.2.3', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (26, 1, '用户名称1', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', NULL, NULL, 1, 1, 0, NULL, '17736609399', 1, NULL, NULL, 'admin', '2022-07-27 16:49:10', NULL, 'q842f528', '2022-07-27 16:49:10', 1, '192.168.2.3', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (27, 2, '用户名称loading', 1500.00, 100.00, 0.00, 0.00, 0.00, NULL, '123456', 11, 'wx_user1', 1, 1, 0, NULL, '17736619391', 1, NULL, NULL, 'admin', '2022-07-27 16:55:06', NULL, 'xQoh59Gx', '2022-07-27 16:55:06', 1, '192.168.2.3', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (28, 1, '用户名称11', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', NULL, NULL, 1, 1, 0, NULL, '17736609395', 1, NULL, NULL, 'admin', '2022-07-27 17:33:27', NULL, '33076p84', '2022-07-27 17:33:27', 1, '192.168.2.3', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (29, 1, '用户名称A', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123456', 20, 'rrr', 1, 1, 0, NULL, '17736609191', 1, NULL, NULL, 'admin', '2022-07-27 17:45:43', NULL, 'G91o1bNd', '2022-07-27 17:45:43', 1, '192.168.2.3', NULL, 0.00, 1);
INSERT INTO `app_member` VALUES (30, 1, '2123', 0.00, 0.00, 0.00, 0.00, 0.00, NULL, '123123', 14, 'qwer11', 1, 1, 0, NULL, '15252525353', 1, NULL, NULL, 'admin', '2022-07-28 15:37:13', NULL, '5f624952', '2022-07-28 15:37:13', 1, '127.0.0.1', NULL, 0.00, 1);

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `status` int(0) DEFAULT NULL COMMENT '账变状态（1正常 2异常）',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员账户变更表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_account_change
-- ----------------------------
INSERT INTO `app_member_account_change` VALUES (24, NULL, 2, NULL, 1, 196275.50, 3900.00, NULL, '111', '2022-07-13 17:40:41', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (25, NULL, 2, NULL, 1, 4275.50, 3900.00, NULL, '111', '2022-07-13 17:44:48', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (26, NULL, 2, NULL, 2, 56275.50, 3900.00, NULL, '111', '2022-07-13 17:47:50', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (27, NULL, 2, NULL, 2, 80000.00, 3900.00, 76275.50, '111', '2022-07-13 18:28:43', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (28, NULL, 2, NULL, 2, 76739.50, 3900.00, 72849.25, '111', '2022-07-14 20:22:31', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (29, NULL, 2, NULL, 2, 72849.25, 3900.00, 68959.00, '111', '2022-07-14 20:25:19', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (30, NULL, 2, NULL, 2, 68959.00, 3900.00, 65068.75, '111', '2022-07-14 20:26:29', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (31, NULL, 2, NULL, 2, 65068.75, 3900.00, 61178.50, '111', '2022-07-14 20:30:53', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (32, NULL, 2, NULL, 2, 61178.50, 3900.00, 57288.25, '111', '2022-07-14 20:31:59', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (33, NULL, 2, NULL, 2, 57288.25, 3900.00, 53398.00, '111', '2022-07-14 20:32:29', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (34, NULL, 2, NULL, 2, 53398.00, 3900.00, 49507.75, '111', '2022-07-14 20:33:14', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (35, NULL, 2, NULL, 2, 49507.75, 3900.00, 45617.50, '111', '2022-07-14 20:39:52', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (36, NULL, 2, NULL, 2, 45617.50, 3900.00, 41727.25, '123456', '2022-07-15 14:04:19', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (37, NULL, 2, NULL, 2, 41727.25, 770.00, 40959.18, '123456', '2022-07-19 16:46:20', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (38, NULL, 2, NULL, 2, 40959.18, 770.00, 40191.11, '123456', '2022-07-19 16:46:52', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (39, NULL, 2, NULL, 2, 40191.11, 770.00, 39423.04, '123456', '2022-07-19 16:48:32', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (40, NULL, 2, NULL, 2, 39423.04, 770.00, 38654.97, '123456', '2022-07-19 17:08:11', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (41, NULL, 2, NULL, 2, 38654.97, 770.00, 37886.90, '123456', '2022-07-19 17:16:22', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (42, NULL, 2, NULL, 2, 37886.90, 770.00, 37118.83, '123456', '2022-07-19 19:05:36', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (43, NULL, 2, NULL, 2, 37118.83, 770.00, 36350.76, '123456', '2022-07-19 19:05:47', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (44, NULL, 2, NULL, 2, 36350.76, 770.00, 35582.69, '123456', '2022-07-19 19:06:01', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (47, NULL, 11, NULL, 2, 1400.00, -200.00, 1600.00, 'admin', '2022-07-26 18:16:53', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (48, NULL, 11, NULL, 2, 1600.00, -200.00, 1800.00, 'admin', '2022-07-26 18:18:02', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (49, NULL, 11, NULL, 2, 2000.00, -400.00, 2400.00, 'admin', '2022-07-26 18:22:13', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (50, NULL, 11, NULL, 1, 2200.00, 200.00, 2400.00, 'admin', '2022-07-26 18:23:30', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (51, NULL, 11, NULL, 2, 2600.00, -400.00, 3000.00, 'admin', '2022-07-26 18:24:24', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (52, NULL, 27, NULL, 1, 1000.00, 1000.00, 2000.00, 'admin', '2022-07-27 16:56:14', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (53, NULL, 27, NULL, 1, 1500.00, 500.00, 2000.00, 'admin', '2022-07-27 16:58:25', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (54, NULL, 11, NULL, 3, 1600.00, 500.00, 1100.00, 'wx_user1', '2022-07-27 17:36:56', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (55, NULL, 11, NULL, 3, 1100.00, 200.00, 900.00, 'wx_user1', '2022-07-27 17:39:36', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (56, NULL, 11, NULL, 2, 900.00, 0.00, 900.00, 'wx_user1', '2022-07-27 18:13:51', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (57, NULL, 11, NULL, 2, 900.00, 0.00, 900.00, 'wx_user1', '2022-07-27 18:15:50', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `app_member_account_change` VALUES (58, NULL, 2, NULL, 3, 900.00, 0.00, 900.00, 'wx_user1', '2022-07-28 18:24:06', NULL, NULL, 1, 'wx_user1', 1, 'vv');
INSERT INTO `app_member_account_change` VALUES (59, NULL, 2, NULL, 3, 900.00, 200.00, 900.00, 'wx_user1', '2022-07-28 18:24:35', NULL, NULL, 1, 'wx_user1', 1, 'vv');
INSERT INTO `app_member_account_change` VALUES (60, NULL, 2, NULL, 3, 900.00, 200.00, 900.00, 'wx_user1', '2022-07-28 18:25:10', NULL, NULL, 1, 'wx_user1', 1, 'vv');
INSERT INTO `app_member_account_change` VALUES (61, NULL, 2, NULL, 3, 900.00, 100.00, 900.00, 'wx_user1', '2022-07-28 18:25:12', NULL, NULL, 1, 'wx_user1', 1, 'xxx');
INSERT INTO `app_member_account_change` VALUES (62, NULL, 2, NULL, 3, 700.00, 200.00, 900.00, 'wx_user1', '2022-07-28 18:25:39', NULL, NULL, 1, 'wx_user1', 1, 'vv');
INSERT INTO `app_member_account_change` VALUES (63, NULL, 2, NULL, 3, 1000.00, 100.00, 1100.00, 'wx_user1', '2022-07-28 18:25:39', NULL, NULL, 1, 'wx_user1', 1, 'xxx');
INSERT INTO `app_member_account_change` VALUES (64, NULL, 2, NULL, 3, 1000.00, 200.00, 1200.00, 'wx_user1', '2022-07-28 18:37:25', NULL, NULL, 1, 'wx_user1', 1, 'vv');
INSERT INTO `app_member_account_change` VALUES (65, NULL, 2, NULL, 1, 1401.00, 1.00, 1402.00, 'admin', '2022-07-29 16:07:16', NULL, NULL, 1, 'wx_user1', 1, 'SY20220729591844');

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_address
-- ----------------------------
INSERT INTO `app_member_address` VALUES (2, 2, 'ppp', '17736609390', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (21, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL, NULL);
INSERT INTO `app_member_address` VALUES (22, 456, 'ppp', 'ppp', 'ppp', 'ppp', NULL, NULL, NULL);
INSERT INTO `app_member_address` VALUES (23, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (24, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (25, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (26, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (27, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (28, 456, 'ppp', 'ppp', 'ppp', 'ppp', 'pppp', NULL, NULL);
INSERT INTO `app_member_address` VALUES (29, 1, '收货姓名', '17736609390', NULL, '详细地址2', NULL, NULL, NULL);
INSERT INTO `app_member_address` VALUES (30, 11, '收货姓名', '17736609390', NULL, '详细地址', NULL, NULL, 1);
INSERT INTO `app_member_address` VALUES (31, 14, '收货姓名', '17736609390', NULL, '详细地址', NULL, NULL, 1);
INSERT INTO `app_member_address` VALUES (32, 27, '收货姓名', '17736609390', NULL, '详细地址', NULL, NULL, 1);

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员银行卡信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_bank
-- ----------------------------
INSERT INTO `app_member_bank` VALUES (3, 1, '开户银行', NULL, '银行卡号', '开户人', '', NULL, '开户电话', NULL, NULL, 1);
INSERT INTO `app_member_bank` VALUES (4, 1, '开户银行', NULL, '123123123123', '开户人', '开户地址', NULL, '17736609390', NULL, NULL, NULL);
INSERT INTO `app_member_bank` VALUES (5, 0, '', '', '', '', '', '', '', 0, '', 1);
INSERT INTO `app_member_bank` VALUES (6, 2, '', '', '', '', '', '', '', 0, '', 1);
INSERT INTO `app_member_bank` VALUES (7, 3, '', '', '', '', '', '', '', 0, '', 1);
INSERT INTO `app_member_bank` VALUES (8, 11, '银行名称', '银行编号', '123123123123123', '开户名', NULL, '中国大陆', NULL, NULL, NULL, 1);
INSERT INTO `app_member_bank` VALUES (9, 20, '银行名称', '银行编号', '1231231111', '开户名', NULL, '中国', NULL, NULL, NULL, 1);
INSERT INTO `app_member_bank` VALUES (10, 27, '银行名称', 'asdasdasd123', '123123123123123123', '开户名', NULL, '中国', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for app_member_deposit
-- ----------------------------
DROP TABLE IF EXISTS `app_member_deposit`;
CREATE TABLE `app_member_deposit`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '交易订单号',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实名字',
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `opera_type` int(0) DEFAULT NULL COMMENT '操作类型【1.充值 2.减少 3.冻结 4.提取】',
  `status` int(0) DEFAULT NULL COMMENT '操作类型【1.待审核 2.审核通过 3.审核不通过 】',
  `opera_mount` decimal(10, 2) DEFAULT 0.00 COMMENT '操作金额',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `is_delete` int(0) DEFAULT NULL COMMENT '0.正常1.删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员充值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_deposit
-- ----------------------------
INSERT INTO `app_member_deposit` VALUES (1, 'SY20220726504062', 11, 'wx_user1', 'wx_user1', '13523532415', 2, 3, -200.00, 'admin', '2022-07-26 18:16:53', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (2, 'SY20220726406659', 11, 'wx_user1', 'wx_user1', '13523532415', 2, 3, -200.00, 'admin', '2022-07-26 18:18:02', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (3, 'SY20220726583068', 11, 'wx_user1', 'wx_user1', '13523532415', 2, 3, -400.00, 'admin', '2022-07-26 18:22:12', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (4, 'SY20220726990604', 11, 'wx_user1', 'wx_user1', '13523532415', 1, 3, 200.00, 'admin', '2022-07-26 18:23:30', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (5, 'SY20220726549251', 11, 'wx_user1', 'wx_user1', '13523532415', 2, 3, -400.00, 'admin', '2022-07-26 18:24:23', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (6, 'SY20220727410118', 27, '用户名称loading', '用户名称loading', '17736619391', 1, 3, 1000.00, 'admin', '2022-07-27 16:56:13', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (7, 'SY20220727656330', 27, '用户名称loading', '用户名称loading', '17736619391', 1, 3, 500.00, 'admin', '2022-07-27 16:58:25', NULL, NULL, 1, 0);
INSERT INTO `app_member_deposit` VALUES (8, 'SY20220729591844', 2, 'wx_user1', 'wx_user1', '13523532415', 1, 3, 1.00, 'admin', '2022-07-29 16:07:16', NULL, NULL, 1, 0);

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_level
-- ----------------------------
INSERT INTO `app_member_level` VALUES (1, '黄金会员2', 80, 1000.00, '2022-07-13 17:24:51', 0.0050, 2, 5, 200, 8000, 10, 10, 10, 10.00, '1111', 1);
INSERT INTO `app_member_level` VALUES (3, '222白金会员', 100, 3000.00, '2022-07-13 17:24:51', 0.0060, 3, 8, 200, 10000, 10, 10, 10, 10.00, '1111', 1);
INSERT INTO `app_member_level` VALUES (4, '钻石会员222', 120, 5000.00, '2022-07-13 17:24:51', 0.0070, 4, 10, 200, 80000, 10, 10, 10, 10.00, '1111', 1);
INSERT INTO `app_member_level` VALUES (22, '333', 0, 0.00, '2022-07-26 08:00:00', 0.0000, 0, 0, 0, 0, 0, 0, 0, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (23, '', NULL, 0.00, NULL, 0.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0.00, NULL, NULL);
INSERT INTO `app_member_level` VALUES (24, '超会', NULL, 599.00, NULL, 1.1231, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/f074e161-46fd-4a77-858d-b340af9e65e4.png', 1);
INSERT INTO `app_member_level` VALUES (25, '超级会员3', 111, 1002.00, NULL, 0.1000, 1, 111, 11, 111, 111, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/89afd9d1-e9d2-4a6b-8291-f2036c99ae1f.png', 1);
INSERT INTO `app_member_level` VALUES (26, '超级会员4', 1, 111.00, NULL, 1.0000, 1, 1, 1, 1, 1, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (27, '超级会员5', 1, 111.00, NULL, 1.0000, 1, 1, 1, 1, 1, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/c35c0ab6-96cf-4bcc-99d1-852013075454.png', 1);
INSERT INTO `app_member_level` VALUES (28, '12231', 123, 123.00, NULL, 123.0000, 1, 213, 123, 123, 123, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/327d9785-3f28-48dd-9a3a-397accabe08b.png', 1);
INSERT INTO `app_member_level` VALUES (29, '12231', 123, 123.00, NULL, 123.0000, 1, 213, 123, 123, 123, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/327d9785-3f28-48dd-9a3a-397accabe08b.png', 1);
INSERT INTO `app_member_level` VALUES (30, '1223122', 123, 123.00, NULL, 123.0000, 1, 213, 123, 123, 123, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/327d9785-3f28-48dd-9a3a-397accabe08b.png', 1);
INSERT INTO `app_member_level` VALUES (31, '123', 1231233, 12312.00, NULL, 3123.0000, 1, 31231212, 3123, 12312, 12312, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (32, '超级会员01', 11, 11.00, NULL, 11.0000, 1, 11, 11, 11, 11, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (33, '1', 1, 11.00, NULL, 1.0000, 1, 1, 1, 1, 1, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (34, '111', 11, 11.00, NULL, 11.0000, 1, 1, 1, 1, 11, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (35, '12312', 3123, 12312.00, NULL, 3123.0000, 1, 1231, 31232, 12312, 12312, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (36, '123', 21, 213.00, NULL, 21.0000, 1, 21, 21, 21, 21, NULL, NULL, 0.00, '', 1);
INSERT INTO `app_member_level` VALUES (37, '12123', 123, 12312.00, NULL, 312.0000, 1, 213, 123, 1231, 123, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/adc88955-084f-40e0-910c-ab12e7f13464.png', 1);
INSERT INTO `app_member_level` VALUES (38, '21321', 22, 213123.00, NULL, 123.0000, 1, 2, 2, 2, 213, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/adc88955-084f-40e0-910c-ab12e7f13464.png', 1);
INSERT INTO `app_member_level` VALUES (39, '1222', 213, 213.00, NULL, 213.0000, 1, 2, 2, 2, 123, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/16cff18f-3393-46a7-b65a-77c3e48da449.png', 1);
INSERT INTO `app_member_level` VALUES (41, '12', 21312, 11.00, NULL, 0.1220, 1, 213, 1223, 12, 213, NULL, NULL, 0.00, 'https://sgp1.digitaloceanspaces.com/ppp/pic/f4e4bfe0-cd5f-41f1-9a46-cbaee37ef1ea.png', 1);

-- ----------------------------
-- Table structure for app_member_withdrawal
-- ----------------------------
DROP TABLE IF EXISTS `app_member_withdrawal`;
CREATE TABLE `app_member_withdrawal`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '交易订单号',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实名字',
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `opera_type` int(0) DEFAULT NULL COMMENT '操作类型【1.充值 2.减少 3.冻结 4.提取】',
  `status` int(0) DEFAULT NULL COMMENT '操作类型【1.待审核 2.已驳回 3.已打款 】',
  `opera_mount` decimal(10, 2) DEFAULT 0.00 COMMENT '操作金额',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `deal_time` datetime(0) DEFAULT NULL COMMENT '处理时间',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `member_bank_id` bigint(0) DEFAULT NULL COMMENT '会员银行卡id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `is_delete` int(0) DEFAULT 0 COMMENT '0.正常1.删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员提现表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_member_withdrawal
-- ----------------------------
INSERT INTO `app_member_withdrawal` VALUES (1, 'vv', 2, '1245', '22', '2', 2, 2, 200.00, '2', '2022-07-04 16:43:37', '222', '2022-07-01 16:43:43', 1, 1, '丁总说拒绝提现', 1);
INSERT INTO `app_member_withdrawal` VALUES (2, 'xxx', 2, '963', '22', '2', 2, 1, 100.00, '2', '2022-07-04 16:43:37', '222', '2022-07-01 16:43:43', 1, 1, '1', 1);
INSERT INTO `app_member_withdrawal` VALUES (3, 'v', 2, '459', '22', '2', 2, 1, 50.00, '2', '2022-07-04 16:43:37', '222', '2022-07-20 16:43:43', 1, 1, '1', 1);
INSERT INTO `app_member_withdrawal` VALUES (4, 'xxgg', 2, '1235', '22', '2', 2, 1, 90.00, '2', '2022-07-04 16:43:37', '222', '2022-07-20 16:43:43', 1, 1, '备注一下驳回的原因', 0);
INSERT INTO `app_member_withdrawal` VALUES (5, 'TX20220727975528', 2, 'wx_user1', '开户名', '13523532415', 4, 1, 500.00, 'wx_user1', '2022-07-27 17:36:58', NULL, NULL, 1, 8, NULL, 0);
INSERT INTO `app_member_withdrawal` VALUES (6, 'TX20220727532151', 2, 'wx_user1', '开户名', '13523532415', 4, 1, 200.00, 'wx_user1', '2022-07-27 17:39:36', NULL, NULL, 1, 8, NULL, 0);

-- ----------------------------
-- Table structure for app_picture
-- ----------------------------
DROP TABLE IF EXISTS `app_picture`;
CREATE TABLE `app_picture`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `picture_type` int(0) DEFAULT NULL COMMENT '图片类型 1.首页banner',
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文字说明',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `last_edit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后编辑',
  `show_type` int(0) DEFAULT NULL COMMENT '展示类型',
  `picture_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片文件id',
  `picture_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片名称',
  `picture_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片路径',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_picture
-- ----------------------------
INSERT INTO `app_picture` VALUES (1, NULL, NULL, NULL, NULL, NULL, '0c6e3b60-4d80-44b0-86be-7eb227537ced', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//0c6e3b60-4d80-44b0-86be-7eb227537ced/1.jpg', NULL);
INSERT INTO `app_picture` VALUES (2, NULL, NULL, NULL, NULL, NULL, 'acc66a26-6370-411c-9238-913d9f80b5e8', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//acc66a26-6370-411c-9238-913d9f80b5e8/1.jpg', NULL);
INSERT INTO `app_picture` VALUES (3, NULL, NULL, NULL, NULL, NULL, 'ae74d977-0cfc-47d9-8888-082426355af2', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//ae74d977-0cfc-47d9-8888-082426355af2/1.jpg', NULL);
INSERT INTO `app_picture` VALUES (4, NULL, NULL, NULL, NULL, NULL, 'e8d10205-b3d0-4ecd-bf54-9dcd2fe696e6', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//e8d10205-b3d0-4ecd-bf54-9dcd2fe696e6/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (5, NULL, NULL, NULL, NULL, NULL, 'bbd6d00c-7a28-4add-925f-d13f392b32fd', NULL, '/https://sgp1.digitaloceanspaces.com/ppp//bbd6d00c-7a28-4add-925f-d13f392b32fd/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (11, NULL, NULL, NULL, NULL, NULL, '026071c4-43a5-4506-8a8a-316181fda94d', NULL, '/ppp/images/026071c4-43a5-4506-8a8a-316181fda94d/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (12, NULL, NULL, '2022-07-21 18:41:50', NULL, NULL, '32df552c-ea26-4217-a37a-721af40f6740', '2.jpg', '/ppp/images/32df552c-ea26-4217-a37a-721af40f6740/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (13, NULL, NULL, '2022-07-21 18:42:46', NULL, NULL, '14a2c232-5f27-4c55-8061-be01189ba022', '2.jpg', '/ppp/images/14a2c232-5f27-4c55-8061-be01189ba022/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (14, NULL, NULL, '2022-07-22 10:39:15', NULL, NULL, 'fde742a0-7f73-4b67-8ba2-e66dc7e00b76', '2.jpg', '/ppp/images/fde742a0-7f73-4b67-8ba2-e66dc7e00b76/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (15, NULL, NULL, '2022-07-22 10:39:19', NULL, NULL, '78700741-bd9c-4da6-ab21-cfbe6281b4a0', '2.jpg', '/ppp/images/78700741-bd9c-4da6-ab21-cfbe6281b4a0/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (16, NULL, NULL, '2022-07-22 10:39:21', NULL, NULL, '1a13aeae-82df-401b-b185-1c494badec51', '2.jpg', '/ppp/images/1a13aeae-82df-401b-b185-1c494badec51/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (17, NULL, NULL, '2022-07-22 10:39:33', NULL, NULL, '31f31d2d-68a8-4a60-9f51-492531f4f355', '2.jpg', '/ppp/images/31f31d2d-68a8-4a60-9f51-492531f4f355/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (18, NULL, NULL, '2022-07-22 10:39:38', NULL, NULL, 'f38b8b04-a146-4047-9130-0fb8cbd1c026', '2.jpg', '/ppp/images/f38b8b04-a146-4047-9130-0fb8cbd1c026/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (25, NULL, NULL, '2022-07-22 10:40:22', NULL, NULL, 'b4c29c85-b222-4a36-8c6e-7ce46471a470', '2.jpg', '/ppp/images/b4c29c85-b222-4a36-8c6e-7ce46471a470/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (26, NULL, NULL, '2022-07-22 10:40:25', NULL, NULL, '2f91eeb4-3089-435c-bd66-c8cdab5dca63', '2.jpg', '/ppp/images/2f91eeb4-3089-435c-bd66-c8cdab5dca63/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (27, NULL, NULL, '2022-07-22 10:40:27', NULL, NULL, '0d408986-7bdc-426b-8508-4c648a0346db', '2.jpg', '/ppp/images/0d408986-7bdc-426b-8508-4c648a0346db/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (28, NULL, NULL, '2022-07-22 10:40:30', NULL, NULL, 'ead2503a-79a5-4976-8b53-068a2085aeb0', '2.jpg', '/ppp/images/ead2503a-79a5-4976-8b53-068a2085aeb0/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (29, NULL, NULL, '2022-07-22 10:40:32', NULL, NULL, 'c97d3d40-93b1-47ee-a7be-390a072b2100', '2.jpg', '/ppp/images/c97d3d40-93b1-47ee-a7be-390a072b2100/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (30, NULL, NULL, '2022-07-22 10:40:36', NULL, NULL, '3541c598-32a4-4417-af1a-3957bd07af70', '2.jpg', '/ppp/images/3541c598-32a4-4417-af1a-3957bd07af70/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (31, NULL, NULL, '2022-07-22 10:40:39', NULL, NULL, '48f48f15-cd1d-48b9-8c7a-a20632f7094f', '2.jpg', '/ppp/images/48f48f15-cd1d-48b9-8c7a-a20632f7094f/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (32, NULL, NULL, '2022-07-22 10:42:04', NULL, NULL, 'b4ca4a19-c68b-48be-ab8a-89a14a4d4dfd', '2.jpg', '/ppp/images/b4ca4a19-c68b-48be-ab8a-89a14a4d4dfd/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (33, NULL, NULL, '2022-07-22 10:42:13', NULL, NULL, '92229aa0-27a1-407e-a7c5-71a0b8edbeec', '2.jpg', '/ppp/images/92229aa0-27a1-407e-a7c5-71a0b8edbeec/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (34, NULL, NULL, '2022-07-22 10:42:25', NULL, NULL, '0eda04b9-2100-43de-ad49-ec35b9e49d65', '2.jpg', '/ppp/images/0eda04b9-2100-43de-ad49-ec35b9e49d65/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (35, NULL, NULL, '2022-07-22 10:42:30', NULL, NULL, 'f137d6ec-ef32-4296-ba80-b396b4b4d60f', '2.jpg', '/ppp/images/f137d6ec-ef32-4296-ba80-b396b4b4d60f/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (36, NULL, NULL, '2022-07-22 10:48:33', NULL, NULL, '5b591335-82e0-4c97-b27b-558bf9eca1dc', '2.jpg', '/ppp/images/5b591335-82e0-4c97-b27b-558bf9eca1dc/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (37, NULL, NULL, '2022-07-22 10:48:39', NULL, NULL, '3b42588f-2a99-4887-92ed-058733850a69', '2.jpg', '/ppp/images/3b42588f-2a99-4887-92ed-058733850a69/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (38, NULL, NULL, '2022-07-22 10:48:41', NULL, NULL, '344dec64-b481-4bda-a010-e91850f1ebde', '2.jpg', '/ppp/images/344dec64-b481-4bda-a010-e91850f1ebde/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (39, NULL, NULL, '2022-07-22 10:48:42', NULL, NULL, '95df78c3-8517-437c-bba5-d368f3756ddf', '2.jpg', '/ppp/images/95df78c3-8517-437c-bba5-d368f3756ddf/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (40, NULL, NULL, '2022-07-22 10:48:44', NULL, NULL, 'b087f69e-658b-4d35-9744-7fd338d55c6c', '2.jpg', '/ppp/images/b087f69e-658b-4d35-9744-7fd338d55c6c/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (41, NULL, NULL, '2022-07-22 10:48:45', NULL, NULL, 'a8b4d950-0130-4c08-97e3-5956c7c4301d', '2.jpg', '/ppp/images/a8b4d950-0130-4c08-97e3-5956c7c4301d/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (42, NULL, NULL, '2022-07-22 10:50:54', NULL, NULL, '37eb4448-1435-468b-a057-8d06771c691c', '2.jpg', '/ppp/images/37eb4448-1435-468b-a057-8d06771c691c/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (43, NULL, NULL, '2022-07-22 10:50:56', NULL, NULL, 'b367bea3-b3a2-48b6-a9a1-9bc51e80b902', '2.jpg', '/ppp/images/b367bea3-b3a2-48b6-a9a1-9bc51e80b902/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (44, NULL, NULL, '2022-07-22 10:50:57', NULL, NULL, 'bc908562-fe4c-408c-9247-cd0bf70e0f7c', '2.jpg', '/ppp/images/bc908562-fe4c-408c-9247-cd0bf70e0f7c/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (45, NULL, NULL, '2022-07-22 10:50:59', NULL, NULL, '353b5c91-a983-4c7b-b8c1-37359b5bd995', '2.jpg', '/ppp/images/353b5c91-a983-4c7b-b8c1-37359b5bd995/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (46, NULL, NULL, '2022-07-22 11:39:16', NULL, NULL, '5e2a0f4f-0943-47a8-a138-422f0aa48c4e', '2.jpg', '/ppp/images/5e2a0f4f-0943-47a8-a138-422f0aa48c4e/2.jpg', NULL);
INSERT INTO `app_picture` VALUES (47, 1, '222222', '2022-07-22 08:00:00', '2222', 0, '222', '22222', '2222', NULL);
INSERT INTO `app_picture` VALUES (62, NULL, '21321', NULL, NULL, 1, NULL, NULL, '', 1);
INSERT INTO `app_picture` VALUES (63, NULL, '123', NULL, NULL, 1, NULL, NULL, 'https://sgp1.digitaloceanspaces.com/ppp/pic/7aefc61a-73b0-482b-a656-7298e4d5e51c.png', 1);
INSERT INTO `app_picture` VALUES (64, NULL, '234234', NULL, NULL, 2, NULL, NULL, 'https://sgp1.digitaloceanspaces.com/ppp/pic/fdc70dc2-4563-4d7d-a593-18ed2a496420.png', 1);
INSERT INTO `app_picture` VALUES (65, NULL, '测试1111', NULL, NULL, 2, NULL, NULL, 'https://sgp1.digitaloceanspaces.com/ppp/pic/cac4bbd0-7802-4271-920b-a6a2db5f1f0f.png', 1);
INSERT INTO `app_picture` VALUES (66, NULL, '222', NULL, NULL, 1, NULL, NULL, '', 1);

-- ----------------------------
-- Table structure for customer_care
-- ----------------------------
DROP TABLE IF EXISTS `customer_care`;
CREATE TABLE `customer_care`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `phone_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '链接',
  `wechat` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信',
  `qr_code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信二维码',
  `status` int(0) DEFAULT NULL COMMENT '帐号状态（0正常 1停用）',
  `begin_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上班时间',
  `end_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下班时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客服管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_care
-- ----------------------------
INSERT INTO `customer_care` VALUES (1, '用户名称', '17736609390', '2285901508', 'www.baidu.com', 'wx110', '', 0, NULL, NULL, 'admin', '2022-07-29 17:31:25', 'admin', '2022-07-29 17:31:25', NULL, 1, NULL);
INSERT INTO `customer_care` VALUES (2, '123123', '17736609390', '', '', '', '', 0, NULL, NULL, 'admin', '2022-07-29 17:37:56', 'admin', '2022-07-29 17:37:56', NULL, 1, NULL);
INSERT INTO `customer_care` VALUES (3, '用户名称111', '17736609399', '1123123', 'url', 'wx1', 'https://sgp1.digitaloceanspaces.com/ppp/pic/bc4c2eaa-3cd1-4f75-b057-90f7b15c69c7.jpg', 0, '00:00:00', '23:59:59', 'admin', '2022-07-29 18:16:34', 'admin', '2022-07-29 18:16:34', NULL, 1, '123456789');
INSERT INTO `customer_care` VALUES (4, '测试添加1', '17736609395', '1123123', 'url', 'wx12', 'https://sgp1.digitaloceanspaces.com/ppp/pic/7cade0e2-371d-4048-a1d3-861f9b0954ca.jpg', 0, '00:00:00', '23:59:59', 'admin', '2022-07-29 18:36:01', 'admin', '2022-07-29 18:36:01', NULL, 1, '1234567');
INSERT INTO `customer_care` VALUES (5, '用户名称123', '17736609392', '', '', '', '', 0, '', '', 'admin', '2022-07-29 18:40:56', 'admin', '2022-07-29 18:40:56', NULL, 1, '123456');
INSERT INTO `customer_care` VALUES (6, '用户名称', '18836609392', '123123', '123', 'wx123', '', 0, '09:00:00', '17:59:59', 'admin', '2022-07-29 18:43:16', 'admin', '2022-07-29 18:43:16', NULL, 1, '123456');

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
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代理佣金展示表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_agent_list
-- ----------------------------
INSERT INTO `sys_agent_list` VALUES (1, '2', '123456', 2.68, '1231312321.jpg', 'admin', '2022-07-18 14:30:53', NULL, NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (2, '1', '333', 3.66, NULL, 'admin', '2022-07-18 14:31:24', NULL, NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (3, '14', 'qwer', 1.29, 'wrwqwq.jpg', 'admin', '2022-07-18 14:31:57', NULL, NULL, NULL, NULL);
INSERT INTO `sys_agent_list` VALUES (4, '11', 'wx_user1', 6.79, NULL, 'admin', '2022-07-18 14:33:52', NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '渠道关联表' ROW_FORMAT = Dynamic;

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
  ` CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('1', 'sex', '性别', '1', '男', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('2', 'sex', '性别', '0', '女', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('3', 'isuse', '使用状态', '1', '使用中', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('4', 'isuse', '使用状态', '0', '已注销', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('5', 'menuType', '菜单类型', '0', '目录', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('6', 'menuType', '菜单类型', '1', '菜单', '1', 'admin', '2018-06-08', NULL);
INSERT INTO `sys_dic` VALUES ('7', 'menuType', '菜单类型', '2', '按钮', '1', 'admin', '2018-06-08', NULL);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('02395dfd2e2c4cae809bc15b00328c97', '7', '文本管理', '0', '', '', '0', 'fa-film', '6', '2022-07-22', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('0bb3a2bcd55a4af2963ea7093eda06d6', '6', '会员管理', '0', '', '', '0', 'fa-leaf', '4', '2022-07-18', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('1', '1', '商品管理', '0', '', '', '0', '&#xe6c9;', '3', NULL, NULL, NULL, '2022-07-22', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('10', '401', '用户管理', '4', '/sys/user/list', NULL, '1', '&#xe665;', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('103740af79724973a8969dc70ea24980', '40402', '修改', '404', NULL, 'org:update', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('11', '40101', '新增', '401', NULL, 'user:add', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('12', '40102', '修改', '401', NULL, 'user:update', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('13', '40103', '删除', '401', NULL, 'user:del', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('14', '40104', '重置密码', '401', NULL, 'user:resetPwd', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('15', '402', '菜单管理', '4', '/sys/menu/list', NULL, '1', '&#xe658;', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('16', '40201', '新增', '402', NULL, 'menu:add', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('17', '40202', '修改', '402', NULL, 'menu:update', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('18', '40203', '删除', '402', NULL, 'menu:del', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('2', '101', '商品列表', '1', 'action/goods/lists', '', '1', '&#xe676;', '1', NULL, NULL, NULL, '2022-07-28', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('2026ff6c77284e0093cb10e63d07da10', '40502', '修改', '405', NULL, 'dic:update', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('23fd92e72c7c498686a0f7d609ed8d99', '804', '交易控制', '8', 'action/transactionControl/lists', '', '1', 'fa-handshake-o', '4', '2022-07-29', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('387c9563ba294bcda0513019860dffdd', '702', '图片管理', '7', 'action/notice/swiper', '', '1', 'fa-photo', '2', '2022-07-27', 'admin', '1', '2022-07-27', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('415b39ea8c044b5d833430a64f38be04', '40403', '删除', '404', NULL, 'org:del', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('4334e39da6d24960bb6130e158994648', '40302', '修改', '403', NULL, 'role:update', '2', NULL, '2', '2018-07-04', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('4ae4c1e3611c4992bf087c136c4ed64b', '901', '日志查看', '9', '/action/operate/log', '', '1', 'fa-th-list', '1', '2022-07-29', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('5', '2', '解决方案', '0', NULL, NULL, '0', '&#xe702;', '2', NULL, NULL, NULL, '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('57612dd7f93745b9bfee457410d646aa', '405', '字典管理', '4', '/sys/dic/list', NULL, '1', 'fa-fire', '5', '2018-07-06', 'admin', '1', '2018-07-06', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('5e37fca116ca4eaabe3be38400980668', '8', '交易管理', '0', '', '', '0', 'fa-align-right', '5', '2022-07-28', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('5ec928362cc5477f848268be3b08c115', '1001', '客服列表', '10', 'action/customer/lists', '', '1', 'fa-github-alt', '1', '2022-07-29', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('6', '201', '方案一', '2', '/list', NULL, '1', '&#xe6b1;', '1', NULL, NULL, NULL, '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('6e47f2d97a3e49ad98d97e9d985aece8', '40501', '新增', '405', NULL, 'dic:add', '2', NULL, '1', '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('7', '202', '方案二', '2', '', NULL, '1', '&#xe66a;', '2', NULL, NULL, NULL, '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('71b57b4634f34bf39cbd2c797c94b42d', '40503', '删除', '405', NULL, 'dic:del', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('77b30d2bc73a45d6ae21e3606458b0d6', '40303', '删除', '403', NULL, 'role:del', '2', NULL, NULL, '2018-07-04', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('7c64a31e68b74bfdaf088cf4817ad5fc', '801', '订单列表', '8', 'action/convey/lists', '', '1', 'fa-asterisk', '1', '2022-07-28', 'admin', '1', '2022-07-28', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('8', '3', '发布商品', '0', '', NULL, '0', '&#xe7ae;', '8', '2018-06-21', '', '', '2018-07-06', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('859a3314b98b427d98f69f3574e953a6', '601', '会员列表', '6', 'action/member/list', '', '1', 'fa-list-ul', '1', '2022-07-20', 'admin', '1', '2022-07-25', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('85f129b57df04d3bbe34c28eb0599fec', '404', '单位管理', '4', '/sys/org/list', NULL, '1', 'fa-asterisk', '4', '2018-07-05', 'admin', '1', '2018-07-05', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('9', '4', '系统管理', '0', NULL, NULL, '0', '&#xe65d;', '1', '2018-06-21', '', '', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('987191b33a904207b58e4a7c62f770ba', '10', '客服管理', '0', '', '', '0', 'fa-flickr', '40', '2022-07-29', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('9ccf7ce73d084144ac87d1d2553ce0c4', '50101', 'add', '501', NULL, 'test:add', '2', 'fa-plus', NULL, '2018-07-02', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('a2b8f4dc3e8e403d9a91fb4f464ce96b', '602', '会员等级', '6', 'action/member/level', '', '1', 'fa-road', '11', '2022-07-22', 'admin', '1', '2022-07-25', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('a50bef14830c4327addddddd2717e41c', '40401', '新增', '404', NULL, 'org:add', '2', NULL, NULL, '2018-07-08', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('b0da5dbfc6ad460d896299bdd1eeb56a', '803', '提现管理', '8', 'action/withdrawal/lists', '', '1', 'fa-hand-peace-o', '3', '2022-07-28', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('b13bb9138c694186aa16bc018e458943', '40301', '新增', '403', NULL, 'role:add', '2', NULL, '1', '2018-07-04', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('c5d03ff0e0b24917a13451611f489e03', '5', 'test', '0', NULL, NULL, '0', '&#xe6b1;', '5', '2018-07-02', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('c69bfe4fe2b34c078c8779dece049a56', '102', '商品分类', '1', 'action/goods/classify', '', '1', 'fa-list-alt', '2', '2022-07-28', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('d73575540b1c4b0f9e88d9d4d25c5ce4', '403', '角色管理', '4', '/sys/role/list', NULL, '1', '&#xe653;', '3', '2018-07-02', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('df24b0b28e034e5f9b7192182643ce59', '9', '操作日志', '0', '', '', '0', 'fa-file-text', '7', '2022-07-29', 'admin', '1', '2022-07-29', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('e5bbc6c38c1a4eada0b45c542e74b0ac', '501', 'test1', '5', 'xxx', NULL, '1', '&#xe66c;', '1', '2018-07-02', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('e69f9d2ee1e64626a788582873a47579', '701', '公告管理', '7', 'action/notice/notice', '', '1', 'fa-snapchat-ghost', '1', '2022-07-27', 'admin', '1', '2022-07-27', 'admin', '1', NULL);
INSERT INTO `sys_menu` VALUES ('e8c31f79a8ab42bf8c05eccd4b786cd7', '802', '充值管理', '8', 'action/deposit/lists', '', '1', 'fa-bullseye', '2', '2022-07-28', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('fc65c4b0ad76432c8a4b30f852b3346f', '50102', 'del', '501', NULL, 'test:del', '2', NULL, NULL, '2018-07-05', 'admin', '1', '2018-07-08', 'admin', '1', NULL);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `member_id` bigint(0) DEFAULT NULL COMMENT '会员ID',
  `notice_classes` int(0) DEFAULT NULL COMMENT '通知类型(1.系统通知 2.个人通知 3.其他通知)',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：新版本发布啦2342342342342342342342342342342222222', '2', '我问问我我222', '0', 'admin', '2022-03-26 12:27:43', '', NULL, '管理员', 1, NULL, 1);
INSERT INTO `sys_notice` VALUES (2, '维护通知：系统凌晨维护', '1', '维护内容', '0', 'admin', '2022-03-26 12:27:43', '', NULL, '管理员', 1, NULL, 1);
INSERT INTO `sys_notice` VALUES (4, 'xxxx', '', 'xxxxx', '', '', '2022-07-18 08:00:00', '', '2022-07-18 08:00:00', '', NULL, NULL, 1);
INSERT INTO `sys_notice` VALUES (5, '666666', '', '666666', '', '', '2022-07-26 08:00:00', '', '2022-07-26 08:00:00', '', 0, 0, 1);
INSERT INTO `sys_notice` VALUES (13, '标题1', '1', '内容2', '0', 'admin', '2022-07-26 18:14:23', 'admin', '2022-07-26 18:14:23', NULL, NULL, 2, 1);
INSERT INTO `sys_notice` VALUES (14, '123123123', '1', '1231231231231', '0', 'admin', '2022-07-27 16:21:59', 'admin', '2022-07-27 16:21:59', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (15, '标题', '1', '休闲鞋', '0', 'admin', '2022-07-27 17:00:52', 'admin', '2022-07-27 17:00:52', NULL, NULL, 2, 1);
INSERT INTO `sys_notice` VALUES (18, '123123', '1', '', '0', 'admin', '2022-07-28 11:12:18', 'admin', '2022-07-28 11:12:18', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (19, '123', '1', '123123', '0', 'admin', '2022-07-28 15:20:15', 'admin', '2022-07-28 15:20:15', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (20, '123', '1', '213123213', '0', 'admin', '2022-07-28 15:36:43', 'admin', '2022-07-28 15:36:43', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (21, '123', '1', '12312', '0', 'admin', '2022-07-28 15:46:20', 'admin', '2022-07-28 15:46:20', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (22, '1', '1', '11', '0', 'admin', '2022-07-28 15:46:59', 'admin', '2022-07-28 15:46:59', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (23, '111', '1', '', '0', 'admin', '2022-07-28 15:48:14', 'admin', '2022-07-28 15:48:14', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (24, '11', '1', '', '0', 'admin', '2022-07-28 15:48:20', 'admin', '2022-07-28 15:48:20', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (25, '123123', '1', '21312', '0', 'admin', '2022-07-28 15:48:26', 'admin', '2022-07-28 15:48:26', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (26, '123', '1', '', '0', 'admin', '2022-07-28 15:48:42', 'admin', '2022-07-28 15:48:42', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (27, '12312312', '1', '312312312', '0', 'admin', '2022-07-28 15:49:24', 'admin', '2022-07-28 15:49:24', NULL, NULL, 3, 1);
INSERT INTO `sys_notice` VALUES (28, '1233333333', '1', '21312312', '0', 'admin', '2022-07-28 15:50:53', 'admin', '2022-07-28 15:50:53', NULL, NULL, 3, 1);

-- ----------------------------
-- Table structure for sys_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate_log`;
CREATE TABLE `sys_operate_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `operate_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `channel_id` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operate_log
-- ----------------------------
INSERT INTO `sys_operate_log` VALUES (1, '会员充值', '账号为：wx_user1 的会员，在Fri Jul 29 16:07:16 CST 2022充值了金额1 元。', 'admin', '2022-07-29 16:07:16', '该操作订单编号为SY20220729591844', 1);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '1', 'IT科技公司', '0', '1', NULL, NULL, NULL, NULL, '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_org` VALUES ('10', '10302', '采购部', '103', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('2', '101', '软件部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('3', '102', '技术部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('4', '103', '行政部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('5', '104', '销售部', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('6', '10101', '研发一部', '101', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('7', '10102', '研发二部', '101', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_org` VALUES ('8', '10103', '数据部', '101', '1', NULL, NULL, NULL, NULL, '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_org` VALUES ('9', '10301', '财务部', '103', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '2018-07-02', NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES ('2', '普通用户', 'user', '1', '2018-07-02', NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES ('afbeab7e44e64f1682ce3654e9785cbc', '11', '11', '1', '2018-07-06', 'admin', '1', NULL);
INSERT INTO `sys_role` VALUES ('e0f81201d9904d67826f6a0c1fa70150', 'test', 'test', '1', '2018-07-03', 'admin', '1', NULL);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('06d1522b599244fe9a62e296f47c7694', '1', '402', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('071577c7609745279b4ceedb4a1c187d', 'e0f81201d9904d67826f6a0c1fa70150', '401', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('0a745734397e458b8a812ddcfee812a4', '1', '901', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('0bea2de6b74d47198ff08fea349c99e8', '1', '804', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('0c1d96477a70409ea0a3a9f058c245d2', 'e0f81201d9904d67826f6a0c1fa70150', '4', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('0d01249d0a024d3ea215ec92429284ad', '1', '4', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('1871dde32c6a43509d91805e50dc70b2', '1', '701', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('188cbd609d754953ba4a33dc6aa695f6', '1', '102', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('1b2f0960a7c44e5eaa1cd9c0848d4a00', '1', '40502', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('2435e5c2c2cf49cb88a2acfcb36937d0', 'e0f81201d9904d67826f6a0c1fa70150', '101', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('251bc0060c3c4633801abb0097524cc5', '1', '602', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('27013a01e1c2447faf015fe8b6be6f69', '1', '40301', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('2e426d99ab6442289a4593a75bdecfa3', '1', '404', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('310616f842b642a695de607546ce302e', '2', '1', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('3819374e2e174b1f86d8b2b68bf93a39', '1', '403', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('3b7edf0f452f4b1985b7f858dd6dc609', 'e0f81201d9904d67826f6a0c1fa70150', '102', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('423987fd855a489681a78705b031dfaa', '1', '40203', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('474769387f0349ff9559f65254180ecd', 'e0f81201d9904d67826f6a0c1fa70150', '201', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('4ed90f29ad404ba090ba6648ebf7dae4', '1', '40503', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('507e64da786e45f09d5d8aec68b66fae', '1', '40402', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('52e2626f8972459195ac79018eb0f63b', '1', '601', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('54e01784980348378b867171e4b29b22', 'e0f81201d9904d67826f6a0c1fa70150', '0', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('54ee538e8163419f857b37ec81acd525', '1', '802', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('5919aadeda1e4932a206a39543a9ca74', '1', '40102', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('5fefd34abb904362ad990d656ae05df5', '1', '40401', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('63189dabccfe4f96881d61079a2fbbb1', '1', '1001', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('6548b24ba37e42fd8c2d65ac0c095769', 'e0f81201d9904d67826f6a0c1fa70150', '1', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('6c027a4b9a8849d08dd3b1d7be999218', '1', '401', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('6d2e7bce1bd84a96b64d6f7e2a65ae2a', '1', '7', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('6d8fcffb04c4478fb9b16e242dff69f4', '1', '40302', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('704a316959d74d6895ffaf7ebecec759', 'e0f81201d9904d67826f6a0c1fa70150', '202', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('711c12eaab764463847d31d7fc190f9d', '2', '4', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('73d6821fe27b4093889ac6622beacd43', '1', '101', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('7befecb5ba334aeca63aeaa13aec9c06', '1', '405', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('7d093b3ab6d64219912e883559954779', 'afbeab7e44e64f1682ce3654e9785cbc', '50101', '1', '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('80c9386f84b04d3392a9da998a36bdfe', '1', '8', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('81ecb291eca748b4a635d68b2ed2d69f', '1', '40104', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('863f875db72a4165891a075b7a58660b', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('96c435f1edd34edd8ae27cb7c8397735', 'afbeab7e44e64f1682ce3654e9785cbc', '0', '1', '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('a24c0bb0ae5147a4a005d117443284ce', '1', '9', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('a2f219fa60794d13b1d9a9012405d279', '2', '102', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('a623d7c6c11c444fa7afcaa9f4d2d8d4', '2', '40301', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('abe27c456a6a432db8652fdc8acf2a3e', '2', '403', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('b0dd70b2b82643bd9e63ed5d79e50930', '2', '401', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('b33e6e7d7c334df6acdf4501d67ecb8a', '1', '40403', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('b9657ab406fc4481b12d890669a0981e', '1', '0', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('b9ab28380a7044b4941bb4629acaadba', '1', '40201', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('c0ce18d8921c4196b816d64561e86681', 'afbeab7e44e64f1682ce3654e9785cbc', '501', '1', '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('cd065fe8b56e4657928ce8f203b621dc', '1', '40202', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('cd6e3cf3565443809329e73ed98724b3', 'e0f81201d9904d67826f6a0c1fa70150', '2', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('cdba469034784b48a86481133eb5156c', '1', '702', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('ce6472a6a9b540f180b583a2b4acb8cf', '1', '6', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('cf15a1e3eeb44c579b985bcdccf48c02', 'afbeab7e44e64f1682ce3654e9785cbc', '5', '1', '2018-07-18', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('d0f0b1bf10af4aeabba330c58b814a6c', '2', '103', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('d6519b48a5934880a2ffcc0c15ff5b3e', '2', '101', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('daf5b73e89994a7988ceeae2d4d7635d', '1', '10', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('e9b0eacdca3140f6b6b457a81427cae8', '1', '40303', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('ed6ea0b3a0a44c619282165d50308e39', '1', '40101', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f0880f75f2df4b41ae440cc1d4cea62a', 'e0f81201d9904d67826f6a0c1fa70150', '40101', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('f27a5fd195d944dda9a7d7d1a77224c6', '1', '40501', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f2fc759f90644750b01c748e76cff4d5', '1', '40103', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f3a36cdfe7ca4ff8b3d7cb1a7ba9818e', 'e0f81201d9904d67826f6a0c1fa70150', '103', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_menu` VALUES ('f66df3489bd042439b222a2b87b0e598', '1', '801', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('f6fb97ce7e564230978150792441206e', '1', '803', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('faa792c3445847108e2dc90ada5d4b2a', '2', '40101', '1', '2018-07-04', 'admin', '1', NULL);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('3c85915321a34bd3a3437f536ba8c557', '2', 'test', '1', '2018-07-04', 'admin', '1', NULL);
INSERT INTO `sys_role_user` VALUES ('4ac2842607214c61b3199a0214459ae1', 'afbeab7e44e64f1682ce3654e9785cbc', '11', '1', '2022-07-22', 'admin', '1', NULL);
INSERT INTO `sys_role_user` VALUES ('6a6d0bd0f74d4a55bb209b3f773aa007', 'e0f81201d9904d67826f6a0c1fa70150', 'test1', '1', '2022-07-22', 'admin', '1', NULL);
INSERT INTO `sys_role_user` VALUES ('84cbdb03f81b4f52a9da87602645422e', 'afbeab7e44e64f1682ce3654e9785cbc', 'test1', '1', '2022-07-22', 'admin', '1', NULL);
INSERT INTO `sys_role_user` VALUES ('9e483ac5695049f3a8f2242563e5ca4a', '1', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_user` VALUES ('c674395278fa436bbf7aee14ba493a55', 'e0f81201d9904d67826f6a0c1fa70150', 'test', '1', '2022-07-22', 'admin', '1', NULL);

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
  `CHANNEL_ID` bigint(0) DEFAULT NULL COMMENT '渠道id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', '0b0a392fb465cd948d3d94d82b25776d', 'r1S0c1Rvw9fzoUU4', '1', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('1c10c112b00a47729ab9bce1e81f4534', '123', '1123', '9c94e1730c574726037ad58c0f6210b6', 'saFYiwrYIVnNIa0S', NULL, '11111111111', '11@qq.com', '123', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('a29d4214386d4857a9233fe4c5af3638', 'test', '测试用户', '211165a317c4de5c52154e7bbfd24d5b', '2zeEU7J0H3FRvy65', '10103', '12345678911', '123456@qq.com', 'test', '1', NULL, '2018-06-25', 'admin', NULL, NULL);
INSERT INTO `sys_user` VALUES ('af0f2dac9a5c4af5bf0c8c65294f5ac8', '11', '11', '57a5158860ca791c1652e44c3f989b11', 'lHBXgZwa8oXqSyzK', '104', '11111111111', '11@qq.com', '11', '1', NULL, '2018-06-27', 'admin', NULL, NULL);
INSERT INTO `sys_user` VALUES ('e6802c17c52646479f7d1427bc6d5b48', 'test1', '测试', 'd913d97d61c423d85b813757f59b9358', 'FmYuAUYx4YRaYdXj', '10103', '11111111111', '111@qq.com', NULL, '1', NULL, '2018-07-03', 'admin', '1', NULL);

-- ----------------------------
-- Table structure for app_show
-- ----------------------------
DROP TABLE IF EXISTS `app_show`;
CREATE TABLE `app_show`  (
                             `id` bigint(0) NOT NULL AUTO_INCREMENT,
                             `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
                             `total_commission` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '今日收益',
                             `show_type` int(0) NULL DEFAULT 1 COMMENT '展示类型0:不展示1:展示',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员收入展示表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_show
-- ----------------------------
INSERT INTO `app_show` VALUES (1, 'xiaoming', 500.00, 1);
INSERT INTO `app_show` VALUES (2, 'wangwu', 1200.00, 1);
INSERT INTO `app_show` VALUES (3, 'tangsan', 1436.00, 1);
INSERT INTO `app_show` VALUES (4, 'qinadaoliu', 5689.00, 1);
INSERT INTO `app_show` VALUES (5, 'qianrenxue', 33669.00, 1);
INSERT INTO `app_show` VALUES (6, 'baigujing', 1899.00, 1);
INSERT INTO `app_show` VALUES (7, 'wangwei', 10000.00, 1);
INSERT INTO `app_show` VALUES (8, 'libai', 12000.00, 1);
INSERT INTO `app_show` VALUES (9, 'ruzhisheng', 6999.00, 1);
INSERT INTO `app_show` VALUES (10, 'caocao', 7896.00, 1);
INSERT INTO `app_show` VALUES (11, 'coco', 36.00, 1);
INSERT INTO `app_show` VALUES (12, 'baozi', 7896.00, 1);
INSERT INTO `app_show` VALUES (13, 'wangtianyi', 231.10, 1);

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
