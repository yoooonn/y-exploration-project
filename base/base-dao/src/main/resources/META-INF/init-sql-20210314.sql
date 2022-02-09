/*
 Navicat Premium Data Transfer

 Source Server         : local-3307
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3307
 Source Schema         : ssm_explore

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 28/05/2021 12:28:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT,
    `code`        varchar(50)   NOT NULL DEFAULT '' COMMENT '编号',
    `name`        varchar(200)  NOT NULL DEFAULT '' COMMENT '姓名',
    `age`         int(11)       NOT NULL DEFAULT '0' COMMENT '年龄',
    `gender`      tinyint(4)    NOT NULL DEFAULT '1' COMMENT '1 female, 2 mail',
    `birthday`    date                   DEFAULT NULL COMMENT '生日',
    `memo`        varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `was_delete`  tinyint(1)    NOT NULL DEFAULT '0' COMMENT '已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4 COMMENT ='演员表';

-- ----------------------------
-- Records of actor
-- ----------------------------
BEGIN;
INSERT INTO `actor`
VALUES (1, 'AC00001', '吴京', 47, 1, '1974-04-03', '电影家协会副主席', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (2, 'AC00002', '贾玲', 39, 2, '1982-04-29', '喜剧女演员', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (3, 'AC00003', '徐峥', 49, 1, '1972-04-18', '金马奖影帝', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (4, 'AC00004', '周一围', 39, 1, '1982-08-24', '演技派', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (5, 'AC00005', '王传君', 36, 1, '1985-10-18', '爱情公寓关谷神奇', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (6, 'AC00006', '谭卓', 38, 2, '1983-09-25', '标致时尚的美女', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (7, 'AC00007', '吴刚', 59, 1, '1962-12-09', '金鸡奖影帝', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (8, 'AC00008', '沈腾', 42, 1, '1979-10-23', '喜剧男演员, 军艺校草', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (9, 'AC00009', '张瀚', 35, 1, '1986-10-06', '一起来看流星雨', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor`
VALUES (10, 'AC00010', '马丽', 39, 2, '1982-06-28', '喜剧女演员', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
COMMIT;

-- ----------------------------
-- Table structure for actor_country
-- ----------------------------
DROP TABLE IF EXISTS `actor_country`;
CREATE TABLE `actor_country`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT,
    `actor_id`    bigint(20)    NOT NULL DEFAULT '0' COMMENT '演员id',
    `country_id`  int(11)       NOT NULL DEFAULT '0' COMMENT '国家id',
    `memo`        varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `was_delete`  tinyint(4)    NOT NULL DEFAULT '0' COMMENT '记录是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4 COMMENT ='演员国家关系表';

-- ----------------------------
-- Records of actor_country
-- ----------------------------
BEGIN;
INSERT INTO `actor_country`
VALUES (1, 1, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (2, 2, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (3, 3, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (4, 4, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (5, 5, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (6, 6, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (7, 7, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (8, 8, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (9, 9, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_country`
VALUES (10, 10, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
COMMIT;

-- ----------------------------
-- Table structure for actor_movie
-- ----------------------------
DROP TABLE IF EXISTS `actor_movie`;
CREATE TABLE `actor_movie`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT,
    `actor_id`    bigint(20)    NOT NULL DEFAULT '0' COMMENT '演员id',
    `movie_id`    bigint(20)    NOT NULL DEFAULT '0' COMMENT '电影id',
    `memo`        varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `was_delete`  tinyint(1)    NOT NULL DEFAULT '0' COMMENT '已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8mb4 COMMENT ='演员电影关系表';

-- ----------------------------
-- Records of actor_movie
-- ----------------------------
BEGIN;
INSERT INTO `actor_movie`
VALUES (1, 1, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (2, 7, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (3, 9, 1, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (4, 3, 3, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (5, 4, 3, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (6, 5, 3, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (7, 6, 3, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (8, 2, 4, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (9, 8, 4, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (10, 8, 5, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `actor_movie`
VALUES (11, 10, 5, '', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
COMMIT;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`
(
    `id`               int(11)       NOT NULL AUTO_INCREMENT,
    `code`             varchar(50)   NOT NULL DEFAULT '' COMMENT '编码',
    `language`         varchar(50)   NOT NULL DEFAULT '' COMMENT '使用语言',
    `capital`          varchar(200)  NOT NULL DEFAULT '' COMMENT '首都',
    `universal_region` varchar(100)  NOT NULL DEFAULT '' COMMENT '世界地理区域',
    `memo`             varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time`      datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time`      datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `was_delete`       tinyint(1)    NOT NULL DEFAULT '0' COMMENT '已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 27
  DEFAULT CHARSET = utf8mb4 COMMENT ='国家表';

-- ----------------------------
-- Records of country
-- ----------------------------
BEGIN;
INSERT INTO `country`
VALUES (1, 'CN', 'chinese', '北京', 'East Asia', '中国', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
COMMIT;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT,
    `code`             varchar(50)  NOT NULL DEFAULT '' COMMENT '电影编码',
    `name`             varchar(200) NOT NULL DEFAULT '' COMMENT '电影名称',
    `alias`            varchar(200) NOT NULL DEFAULT '' COMMENT '别名',
    `director`         varchar(200) NOT NULL DEFAULT '' COMMENT '导演',
    `type`             varchar(100) NOT NULL DEFAULT '' COMMENT '电影类型',
    `memo`             text         NOT NULL COMMENT '描述',
    `release_datetime` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上映时间',
    `post_date`        date                  DEFAULT NULL COMMENT '发布时间',
    `create_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `update_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `was_delete`       tinyint(1)   NOT NULL DEFAULT '0' COMMENT '已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4 COMMENT ='电影表';

-- ----------------------------
-- Records of movie
-- ----------------------------
BEGIN;
INSERT INTO `movie`
VALUES (1, 'MO001', '战狼2', 'Wolf Warriors 2', '吴京', '1,4', '中国电影票房之最', '2017-07-27 00:00:00', '2017-07-27',
        '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `movie`
VALUES (2, 'MO002', '哪吒之魔童降世', 'Nezha: Birth of the Demon Child', '饺子', '5,6', '中国动画之最', '2019-07-26 00:00:00',
        '2019-07-26', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `movie`
VALUES (3, 'MO003', '我不是药神', 'Dying to Survive', '文牧野', '5', '改编自慢粒白血病患者陆勇代购抗癌药的真实事迹', '2018-07-05 00:00:00',
        '2018-07-05', '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `movie`
VALUES (4, 'MO004', '你好，李焕英', 'Hi, Mom', '贾玲', '5,7', '贾玲处女作；票房最高女导演', '2021-02-12 00:00:00', '2021-02-12',
        '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
INSERT INTO `movie`
VALUES (5, 'MO005', '夏洛特烦恼', 'Goodbye Mr. Loser', '闫非/彭大魔', '5,7', '', '2015-09-30 00:00:00', '2015-09-30',
        '2021-03-14 20:28:50', '2021-03-14 20:28:50', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
