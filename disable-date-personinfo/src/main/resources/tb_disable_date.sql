/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : tb_disable_date

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/08/2022 22:56:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_disable_bgm
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_bgm`;
CREATE TABLE `tb_disable_bgm`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'bgmID',
  `bgm_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'bgm作者',
  `bgm_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'bgm名字',
  `bgm_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '播放地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_bgm
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_admin_user`;
CREATE TABLE `tb_disable_date_admin_user`  (
  `admin_user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆名称',
  `login_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员显示昵称',
  `locked` tinyint(0) NULL DEFAULT 0 COMMENT '是否锁定 1-未锁定 2-已锁定无法登陆',
  `level` tinyint(0) NULL DEFAULT 0 COMMENT '管理员权限  1-超级管理员 2-普通管理员 3-审批员',
  PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_admin_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_carousel
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_carousel`;
CREATE TABLE `tb_disable_date_carousel`  (
  `carousel_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '首页轮播图主键id',
  `carousel_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '轮播图',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '\'##\'' COMMENT '点击后的跳转地址(默认不跳转)',
  `carousel_rank` int(0) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(0) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_user` int(0) NOT NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`carousel_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_carousel
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_chat_friends
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_chat_friends`;
CREATE TABLE `tb_disable_date_chat_friends`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `fuser_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '好友id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_chat_friends
-- ----------------------------
INSERT INTO `tb_disable_date_chat_friends` VALUES (1, '1', '2', '2022-07-19 22:41:49');
INSERT INTO `tb_disable_date_chat_friends` VALUES (2, '2', '1', '2022-07-20 23:10:42');
INSERT INTO `tb_disable_date_chat_friends` VALUES (3, '1', '3', '2022-07-21 16:26:25');
INSERT INTO `tb_disable_date_chat_friends` VALUES (4, '3', '1', '2022-07-21 16:26:30');

-- ----------------------------
-- Table structure for tb_disable_date_diary
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary`;
CREATE TABLE `tb_disable_date_diary`  (
  `diary_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '朋友圈记录主键id',
  `diary_user_id` bigint(0) NOT NULL COMMENT '发表朋友圈的用户id',
  `diary_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朋友圈标题',
  `diary_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朋友圈内容',
  `diary_category_id` int(0) NOT NULL COMMENT '朋友圈分类id',
  `diary_category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朋友圈分类(冗余字段)',
  `diary_tags` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朋友圈标签',
  `diary_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '1-草稿 2-发布',
  `diary_views` bigint(0) NOT NULL DEFAULT 0 COMMENT '阅读量',
  `diary_love` bigint(0) NOT NULL DEFAULT 0 COMMENT '点赞量',
  `enable_comment` tinyint(0) NOT NULL DEFAULT 0 COMMENT '1-允许评论 2-不允许评论',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除 1-否 2-是',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '朋友圈添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '朋友圈修改时间',
  PRIMARY KEY (`diary_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_diary_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary_category`;
CREATE TABLE `tb_disable_date_diary_category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的名称',
  `category_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类的图标',
  `category_rank` int(0) NOT NULL DEFAULT 1 COMMENT '分类的排序值 被使用的次数越多数值越大',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除 1-否 2-是',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_diary_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary_comment`;
CREATE TABLE `tb_disable_date_diary_comment`  (
  `comment_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
  `diary_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '关联的diary主键',
  `commentator_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论者昵称',
  `comment_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评论提交时间',
  `commentator_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '评论时的ip地址',
  `reply_body` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '回复内容',
  `reply_create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '回复时间',
  `comment_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否审核通过 1-未审核 2-审核通过',
  `is_deleted` tinyint(0) NULL DEFAULT 0 COMMENT '是否删除 1-未删除 2-已删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_diary_loved
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary_loved`;
CREATE TABLE `tb_disable_date_diary_loved`  (
  `diary_id` bigint(0) NOT NULL COMMENT '朋友圈主键id',
  `user_id` bigint(0) NOT NULL COMMENT '作者id',
  `loved_user_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '点赞的人的id',
  `loved_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '点赞时间',
  `images_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '点赞的人的头像路径',
  PRIMARY KEY (`diary_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary_loved
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_diary_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary_tag`;
CREATE TABLE `tb_disable_date_diary_tag`  (
  `tag_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
  `tag_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除 1-否 2-是',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary_tag
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_diary_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_diary_tag_relation`;
CREATE TABLE `tb_disable_date_diary_tag_relation`  (
  `relation_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `diary_id` bigint(0) NOT NULL COMMENT '朋友圈id',
  `tag_id` int(0) NOT NULL COMMENT '标签id',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_diary_tag_relation
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_dislike
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_dislike`;
CREATE TABLE `tb_disable_date_dislike`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '操作记录id',
  `user_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '用户id',
  `dislike_user_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '拉黑的人的id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_fans
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_fans`;
CREATE TABLE `tb_disable_date_fans`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '关注记录id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `follower` bigint(0) NOT NULL DEFAULT 0 COMMENT '粉丝',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '关注状态 1-未关注 2-关注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_fans
-- ----------------------------
INSERT INTO `tb_disable_date_fans` VALUES (19, 7, 5, 2, '2022-07-31 20:01:24', '2022-07-31 20:05:14');
INSERT INTO `tb_disable_date_fans` VALUES (20, 8, 5, 2, '2022-07-31 20:02:42', '2022-07-31 20:04:56');

-- ----------------------------
-- Table structure for tb_disable_date_follow
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_follow`;
CREATE TABLE `tb_disable_date_follow`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '关注记录id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `followed_user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '关注的人的id',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '关注状态 1-未关注 2-关注 3-拉黑',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '关系更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_follow
-- ----------------------------
INSERT INTO `tb_disable_date_follow` VALUES (19, 5, 7, 2, '2022-07-31 20:01:24', '2022-07-31 20:05:14');
INSERT INTO `tb_disable_date_follow` VALUES (20, 5, 8, 2, '2022-07-31 20:02:42', '2022-07-31 20:04:56');

-- ----------------------------
-- Table structure for tb_disable_date_index_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_index_config`;
CREATE TABLE `tb_disable_date_index_config`  (
  `config_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '首页配置项主键id',
  `config_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示字符(配置搜索时不可为空，其他可为空)',
  `config_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热门推荐 4-(首页)新品上线 5-(首页)为你推荐',
  `recommend_id` int(0) NOT NULL DEFAULT 0 COMMENT '推荐用户id规定使用正数 广告id规定使用负数 ',
  `background_color_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '1-酷炫黑 2-活力紫黄 3-小清新淡蓝 4-window10-light ',
  `background_image_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '背景图片路径',
  `redirect_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '##' COMMENT '点击后的跳转地址(默认不跳转)',
  `config_rank` int(0) NOT NULL DEFAULT 0 COMMENT '排序值(字段越大越靠前)',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标识字段(0-未删除 1-已删除)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_user` int(0) NOT NULL DEFAULT 0 COMMENT '创建者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  `update_user` int(0) NULL DEFAULT 0 COMMENT '修改者id',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_index_config
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_message`;
CREATE TABLE `tb_disable_date_message`  (
  `id` bigint(0) NOT NULL COMMENT '消息id',
  `sender_id` bigint(0) NOT NULL COMMENT '发送者id',
  `receiver_id` bigint(0) NOT NULL COMMENT '接收者id',
  `send_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '发送内容',
  `send_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发送时间',
  `message_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_message
-- ----------------------------
INSERT INTO `tb_disable_date_message` VALUES (1, 1, 2, 'xxx', '2022-07-23 22:32:15', '0');
INSERT INTO `tb_disable_date_message` VALUES (2, 2, 1, 'yyy', '2022-07-23 22:32:26', '0');

-- ----------------------------
-- Table structure for tb_disable_date_payment_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_payment_info`;
CREATE TABLE `tb_disable_date_payment_info`  (
  `order_id` bigint(0) NOT NULL COMMENT '订单id',
  `order_sn` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号（对外业务号）',
  `trade_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝交易流水号',
  `total_amount` decimal(18, 4) NULL DEFAULT NULL COMMENT '支付总金额',
  `subject` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `payment_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态 1-未支付 2-已支付',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '确认时间',
  `callback_content` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回调内容',
  `callback_time` datetime(0) NULL DEFAULT NULL COMMENT '回调时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  UNIQUE INDEX `order_sn`(`order_sn`) USING BTREE,
  UNIQUE INDEX `alipay_trade_no`(`trade_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_payment_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_person_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_person_basic_info`;
CREATE TABLE `tb_disable_date_person_basic_info`  (
  `person_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户基本信息表主键id',
  `person_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` tinyint(0) NULL DEFAULT 1 COMMENT '性别 1-男 2-女',
  `age` int(0) NULL DEFAULT 1 COMMENT '年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '手机',
  `work_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '工作地区',
  `household_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '户籍地区',
  `marital_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '婚姻情况',
  `height` int(0) NULL DEFAULT 1 COMMENT '身高',
  `weight` int(0) NULL DEFAULT 1 COMMENT '体重',
  `degree` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最高学历',
  `income` int(0) NULL DEFAULT 1 COMMENT '年收入',
  `occupation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '职业',
  `housing_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '住房情况',
  `car_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '购车情况 ',
  `expected_marry_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '期待结婚时间',
  `person_intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '自我介绍',
  `person_sign` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '爱情宣言',
  `longitude` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '经度',
  `latitude` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '纬度',
  `wechat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '微信号 ',
  `wechat_code_images_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '微信二维码上传路径',
  `qq` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT 'QQ账号 ',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '邮箱',
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_person_basic_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_person_detail_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_person_detail_info`;
CREATE TABLE `tb_disable_date_person_detail_info`  (
  `person_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `disable_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '残疾类别',
  `disable_level` tinyint(0) NULL DEFAULT 1 COMMENT '残疾等级 1-健康 2-轻度残疾 3-中度残疾 4-重度残疾 5-极重度残疾',
  `is_provide` tinyint(0) NULL DEFAULT 1 COMMENT '能否自理 1-完全自理，并能照顾对方 2-不能自理',
  `auxiliary_tool` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '辅助工具',
  `cause` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '健康状况原因',
  `is_genetic` tinyint(0) NULL DEFAULT 1 COMMENT '子女是否遗传 1-不遗传 2-遗传',
  `parent_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '父母状况',
  `brother_number` tinyint(0) NULL DEFAULT 0 COMMENT '兄弟姐妹个数',
  `living_will` tinyint(0) NULL DEFAULT 1 COMMENT '未来居住意愿 1-与自己父母同住 2-与Ta父母同住 3-两个人同居',
  `is_smoking` tinyint(0) NULL DEFAULT 1 COMMENT '是否吸烟 1-吸烟 2-不吸烟',
  `marry_form` tinyint(0) NULL DEFAULT 1 COMMENT '嫁娶形式 1-两头顾 2-男方家庭为主 3-女方家庭为主',
  `is_drinking` tinyint(0) NULL DEFAULT 1 COMMENT '是否饮酒 1-经常喝酒 2-有时喝一些 3-不喝酒',
  `fertility_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生育情况',
  `keeping_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '养宠物情况',
  `hobby` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '兴趣爱好 ',
  `blood_type` tinyint(0) NULL DEFAULT 1 COMMENT '血型 1-A型 2-B型 3-AB型 4-O型',
  `habit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '作息习惯 ',
  `company_type` tinyint(0) NULL DEFAULT 1 COMMENT '单位类型 1-国有企业工作 2-民营企业工作 3-体制内',
  `company_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '工作单位 ',
  `work_industry` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '工作行业 ',
  `housing_location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '房产位置',
  `person_tag` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '我的标签',
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14203 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_person_detail_info
-- ----------------------------
INSERT INTO `tb_disable_date_person_detail_info` VALUES (2, '2', 1, 1, '0', '0', 1, '健康', 2, 1, 1, 1, 1, '0', '0', '0', 1, '0', 1, '0', '0', '', NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (3, '1', 1, 1, '0', '0', 1, '健康', 0, 1, 1, 1, 1, '0', '0', '0', 1, '0', 1, '0', '0', '', NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (4, NULL, NULL, NULL, '批量测试0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (5, NULL, NULL, NULL, '批量测试1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (6, NULL, NULL, NULL, '批量测试2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (7, NULL, NULL, NULL, '批量测试3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_disable_date_person_detail_info` VALUES (1000, '视觉障碍', 2, 1, '导盲犬', '事故', 1, '父母健在', 2, 3, 2, 2, 3, '未婚', '养狗', '听音乐', 4, '早睡早起', 1, '暂无工作', '暂无工作', '青海省 黄南藏族自治州 尖扎县', '除持反第光得二或但般划构包队气。');
INSERT INTO `tb_disable_date_person_detail_info` VALUES (8876, '听力障碍', 3, 2, '助听器', '发烧', 1, '父母健在', 1, 2, 1, 2, 1, '未育', '养猫', '跑步', 2, '早睡早起', 2, '网络公司', 'IT', '青海省 海北藏族自治州 海晏县', 'osrk');
INSERT INTO `tb_disable_date_person_detail_info` VALUES (14199, '视觉障碍', 4, 1, '导盲犬', '事故', 1, '父母健在', 2, 1, 1, 1, 1, '未婚', '养狗', '听音乐', 1, '早睡早起', 2, '暂无工作', '暂无工作', '云南省 德宏傣族景颇族自治州 陇川县', '力报头第用原是适务那目包整技天义种。');
INSERT INTO `tb_disable_date_person_detail_info` VALUES (14200, '视觉障碍', 4, 1, '导盲犬', '事故', 1, '父母健在', 2, 2, 1, 2, 1, '未婚', '养狗', '听音乐', 4, '早睡早起', 1, '暂无工作', '暂无工作', '贵州省 贵阳市 云岩区', '照开各研非研线石九子始派常标花选米。');
INSERT INTO `tb_disable_date_person_detail_info` VALUES (14201, '视觉障碍', 2, 2, '导盲犬', '事故', 1, '父母健在', 2, 2, 2, 1, 1, '未婚', '养狗', '听音乐', 3, '早睡早起', 3, '暂无工作', '暂无工作', '山东省 威海市 乳山市', '参受派选资理百他给广义持至什。');
INSERT INTO `tb_disable_date_person_detail_info` VALUES (14202, '视觉障碍', 1, 2, '导盲犬', '事故', 1, '父母健在', 2, 1, 1, 2, 2, '未婚', '养狗', '听音乐', 4, '早睡早起', 3, '暂无工作', '暂无工作', '贵州省 黔东南苗族侗族自治州 三穗县', '道比马以据二报义我些连式务认。');

-- ----------------------------
-- Table structure for tb_disable_date_refund_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_refund_info`;
CREATE TABLE `tb_disable_date_refund_info`  (
  `refund_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '退款id号',
  `order_return_id` bigint(0) NULL DEFAULT NULL COMMENT '退款的订单',
  `refund` decimal(18, 4) NULL DEFAULT NULL COMMENT '退款金额',
  `refund_sn` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款交易流水号',
  `refund_status` tinyint(1) NULL DEFAULT NULL COMMENT '退款状态 1-未处理 2-处理中 3-退款完毕',
  `refund_channel` tinyint(0) NULL DEFAULT NULL COMMENT '退款渠道 1-支付宝，2-微信，3-银联',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '确认时间',
  `refund_content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`refund_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '退款信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_refund_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_date_requirements
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_requirements`;
CREATE TABLE `tb_disable_date_requirements`  (
  `person_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `age_range` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '年龄范围',
  `height_range` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '身高范围',
  `marry_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '婚姻情况',
  `education_background` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '教育背景要求',
  `income` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收入要求',
  `housing_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '房子',
  `car_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '车子',
  `other_requirements` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '其他要求',
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_requirements
-- ----------------------------
INSERT INTO `tb_disable_date_requirements` VALUES (2, '29', '155~160', '未婚', '0', '5000~7000', '无要求', '修改无车', '温柔');
INSERT INTO `tb_disable_date_requirements` VALUES (3, '25', '160~165', '未婚', '0', '6000~8000', '无要求', '无要求', '体贴');
INSERT INTO `tb_disable_date_requirements` VALUES (4, '29', '170~180', '未婚', '学士学位', '5000~7000', '无要求', '修改无车', '温柔');
INSERT INTO `tb_disable_date_requirements` VALUES (5, '18~25', '', '', '0', '', '', '', '0');
INSERT INTO `tb_disable_date_requirements` VALUES (6, NULL, NULL, NULL, '批量插入', NULL, NULL, NULL, NULL);
INSERT INTO `tb_disable_date_requirements` VALUES (7, '22~30', '165~175', '未婚', '本科毕业', '15000', '有车', '无要求', '脾气好');
INSERT INTO `tb_disable_date_requirements` VALUES (1000, '25~30岁', '', '', '修改异步调用', '', '', '', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1001, '25~30', '170~175', '未婚', '', '10000以上', '有房', '有车', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1002, '25~30', '170~175', '未婚', '', '10000以上', '有房', '有车', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1003, '25~30', '170~175', '未婚', '新增异步调用', '10000以上', '有房', '有车', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1004, '25~30', '170~175', '未婚', '新增异步调用', '10000以上', '有房', '有车', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1005, '25~30', '170~175', '未婚', '新增异步调用', '10000以上', '有房', '有车', '');
INSERT INTO `tb_disable_date_requirements` VALUES (1006, '25~30', '170~175', '未婚', '新增异步调用', '10000以上', '有房', '有车', '');

-- ----------------------------
-- Table structure for tb_disable_date_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_user`;
CREATE TABLE `tb_disable_date_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `login_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名称(默认为手机号)',
  `password_md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5加密后的密码',
  `sex` tinyint(0) NULL DEFAULT 1 COMMENT '性别 1-男 2-女',
  `age` int(0) NULL DEFAULT 1 COMMENT '年龄',
  `is_vip` tinyint(0) NOT NULL COMMENT '是否是会员 1-非会员 2-会员',
  `sorts` int(0) NULL DEFAULT 0 COMMENT '积分',
  `disable_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '残疾证号码',
  `head_pic_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `online_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上网时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '注销标识字段(1-正常 2-未认证 3-已注销)',
  `locked_flag` tinyint(0) NOT NULL DEFAULT 0 COMMENT '锁定标识字段(1-未锁定 2-已锁定)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '最近一次签到时间',
  `expiration_time` datetime(0) NULL DEFAULT NULL COMMENT '会员过期时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_user
-- ----------------------------
INSERT INTO `tb_disable_date_user` VALUES (1, 'xxx', '123456', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, 1, 10, '0', NULL, NULL, 0, 0, '2022-07-31 20:55:38', '2022-07-31 20:55:38', '2022-08-01 10:48:19', '2023-05-01 15:33:56');
INSERT INTO `tb_disable_date_user` VALUES (2, 'yyy', '123457', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, 0, 65, '0', NULL, NULL, 0, 0, '2022-07-31 20:55:57', '2022-07-31 20:55:57', '2022-08-01 12:28:22', '2022-07-13 15:51:25');
INSERT INTO `tb_disable_date_user` VALUES (3, 'zzz', '123458', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, 0, 0, '0', NULL, NULL, 0, 0, '2022-08-02 20:48:58', '2022-08-02 20:48:58', NULL, NULL);

-- ----------------------------
-- Table structure for tb_disable_date_vip_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_date_vip_permissions`;
CREATE TABLE `tb_disable_date_vip_permissions`  (
  `config_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '权限配置记录id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `is_view` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否可见谁喜欢你 1-不可见 2-可见',
  `likes` int(0) NOT NULL DEFAULT 0 COMMENT '每日超级喜欢数',
  `album_count` int(0) NOT NULL DEFAULT 0 COMMENT '个人相册限制图片数 ',
  `diary_pic_count` int(0) NOT NULL DEFAULT 0 COMMENT '个人动态限制图片数 ',
  `is_back` tinyint(0) NOT NULL DEFAULT 0 COMMENT '能否滑错随时反悔 1-不可以 2-可以',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最新修改时间',
  `update_admin` int(0) NULL DEFAULT 0 COMMENT '修改者管理员id',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_date_vip_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_picture_album
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_picture_album`;
CREATE TABLE `tb_disable_picture_album`  (
  `id` bigint(0) NOT NULL COMMENT '图片id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `pic_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片描述',
  `pic_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片存放的路径',
  `like_counts` bigint(0) NOT NULL DEFAULT 0 COMMENT '喜欢/赞美的数量',
  `status` int(0) NOT NULL COMMENT '视频状态：1-发布成功 2-未过审，管理员操作',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_picture_album
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_pictures
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_pictures`;
CREATE TABLE `tb_disable_pictures`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `user_id` bigint(0) NOT NULL COMMENT '发布者id',
  `pic_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频存放的路径',
  `pic_width` int(0) NULL DEFAULT NULL COMMENT '图片宽度',
  `pic_height` int(0) NULL DEFAULT NULL COMMENT '图片高度',
  `like_counts` bigint(0) NOT NULL DEFAULT 0 COMMENT '喜欢/赞美的数量',
  `status` int(0) NOT NULL COMMENT '视频状态：1-发布成功 2-未过审，管理员操作',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_pictures
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_users_like_videos
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_users_like_videos`;
CREATE TABLE `tb_disable_users_like_videos`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id号',
  `video_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频id号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_video_rel`(`user_id`, `video_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户喜欢的/赞过的视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_users_like_videos
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_users_report
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_users_report`;
CREATE TABLE `tb_disable_users_report`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deal_user_id` bigint(0) NOT NULL COMMENT '被举报用户id',
  `deal_video_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '被举报的视频id',
  `title` tinyint(0) NOT NULL COMMENT '类型标题 1-恐怖血腥 2-色情低俗 3-封面恶心 4-标题党/封面党',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `user_id` bigint(0) NOT NULL COMMENT '举报人的id',
  `create_time` datetime(0) NOT NULL COMMENT '举报时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '举报信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_users_report
-- ----------------------------

-- ----------------------------
-- Table structure for tb_disable_videos
-- ----------------------------
DROP TABLE IF EXISTS `tb_disable_videos`;
CREATE TABLE `tb_disable_videos`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` bigint(0) NOT NULL COMMENT '发布者id',
  `audio_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户使用音频的信息',
  `video_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频描述',
  `video_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频存放的路径',
  `video_seconds` float(6, 2) NULL DEFAULT NULL COMMENT '视频秒数',
  `video_width` int(0) NULL DEFAULT NULL COMMENT '视频宽度',
  `video_height` int(0) NULL DEFAULT NULL COMMENT '视频高度',
  `cover_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频封面图',
  `like_counts` bigint(0) NOT NULL DEFAULT 0 COMMENT '喜欢/赞美的数量',
  `status` int(0) NOT NULL COMMENT '视频状态：1-发布成功 2-未过审，管理员操作',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '视频信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_disable_videos
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
