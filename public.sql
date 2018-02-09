/*
 Navicat Premium Data Transfer

 Source Server         : 本地postgresql
 Source Server Type    : PostgreSQL
 Source Server Version : 100001
 Source Host           : localhost:5432
 Source Catalog        : ims
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100001
 File Encoding         : 65001

 Date: 24/11/2017 09:53:17
*/


-- ----------------------------
-- Sequence structure for ims_class_class_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_class_class_id_seq";
CREATE SEQUENCE "public"."ims_class_class_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for ims_clubroom_clubroom_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_clubroom_clubroom_id_seq";
CREATE SEQUENCE "public"."ims_clubroom_clubroom_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for ims_semester_integral_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_semester_integral_id_seq";
CREATE SEQUENCE "public"."ims_semester_integral_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for ims_semester_semester_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_semester_semester_id_seq";
CREATE SEQUENCE "public"."ims_semester_semester_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for ims_student_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_student_id_seq";
CREATE SEQUENCE "public"."ims_student_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for ims_user_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ims_user_user_id_seq";
CREATE SEQUENCE "public"."ims_user_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for ims_class
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_class";
CREATE TABLE "public"."ims_class" (
  "class_id" int4 NOT NULL DEFAULT nextval('ims_class_class_id_seq'::regclass),
  "class_name" varchar(30) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_class
-- ----------------------------
INSERT INTO "public"."ims_class" VALUES (6, '通信161');
INSERT INTO "public"."ims_class" VALUES (7, '通信162');
INSERT INTO "public"."ims_class" VALUES (8, '通信163');
INSERT INTO "public"."ims_class" VALUES (9, '计科161');
INSERT INTO "public"."ims_class" VALUES (10, '计科162');
INSERT INTO "public"."ims_class" VALUES (11, '计科163');
INSERT INTO "public"."ims_class" VALUES (12, '计科164');
INSERT INTO "public"."ims_class" VALUES (13, '计科165');
INSERT INTO "public"."ims_class" VALUES (14, '计科166');
INSERT INTO "public"."ims_class" VALUES (15, '计科167');
INSERT INTO "public"."ims_class" VALUES (18, '');

-- ----------------------------
-- Table structure for ims_clubroom
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_clubroom";
CREATE TABLE "public"."ims_clubroom" (
  "clubroom_id" int4 NOT NULL DEFAULT nextval('ims_clubroom_clubroom_id_seq'::regclass),
  "clubroom_name" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_clubroom
-- ----------------------------
INSERT INTO "public"."ims_clubroom" VALUES (11, '办公室');
INSERT INTO "public"."ims_clubroom" VALUES (12, '资助中心');
INSERT INTO "public"."ims_clubroom" VALUES (13, '新闻中心');
INSERT INTO "public"."ims_clubroom" VALUES (14, '组织部');
INSERT INTO "public"."ims_clubroom" VALUES (15, '实践部');
INSERT INTO "public"."ims_clubroom" VALUES (16, '宣传部');
INSERT INTO "public"."ims_clubroom" VALUES (17, '文艺部');
INSERT INTO "public"."ims_clubroom" VALUES (18, '体育部');
INSERT INTO "public"."ims_clubroom" VALUES (19, '学习部');
INSERT INTO "public"."ims_clubroom" VALUES (20, '自律部');
INSERT INTO "public"."ims_clubroom" VALUES (21, '卫生部');
INSERT INTO "public"."ims_clubroom" VALUES (22, '创新部');
INSERT INTO "public"."ims_clubroom" VALUES (23, '生活部');

-- ----------------------------
-- Table structure for ims_integral
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_integral";
CREATE TABLE "public"."ims_integral" (
  "integral_id" int4 NOT NULL DEFAULT nextval('ims_semester_integral_id_seq'::regclass),
  "student_name" varchar(10) COLLATE "pg_catalog"."default",
  "student_id" varchar(32) COLLATE "pg_catalog"."default",
  "score" float4,
  "reason" varchar(255) COLLATE "pg_catalog"."default",
  "time" varchar(50) COLLATE "pg_catalog"."default",
  "clubroom" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "int_semester" varchar(255) COLLATE "pg_catalog"."default",
  "grades" varchar(255) COLLATE "pg_catalog"."default",
  "creatime" varchar(30) COLLATE "pg_catalog"."default",
  "update_time" varchar(30) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_integral
-- ----------------------------
INSERT INTO "public"."ims_integral" VALUES (222, '王德鹏', '20161544115', 2, '红歌比赛', '第八周', '文艺部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (223, '黄柯文', '20161544116', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (224, '黄柯文', '20161544116', 0.5, '卫生例查表扬', '第八周', '卫生部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (225, '黄柯文', '20161544116', 2.3, '红歌比赛朗诵', '第八周', '文艺部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (226, '黄柯文', '20161544116', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (227, '司鹏起', '20161544117', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (228, '司鹏起', '20161544117', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (229, '司鹏起', '20161544117', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (230, '司鹏起', '20161544117', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (231, '刘超', '20161544118', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (232, '刘超', '20161544118', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (233, '刘超', '20161544118', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (234, '刘超', '20161544118', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (235, '杨健林', '20161544119', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (236, '杨健林', '20161544119', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (237, '杨健林', '20161544119', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (238, '雷峰', '20161544120', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (239, '张皓锋', '20161544121', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (240, '李君茹', '20161544122', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (241, '李君茹', '20161544122', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (242, '孙苗', '20161544123', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (243, '孙苗', '20161544123', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (244, '王鹏', '20161544124', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (245, '张慧琳', '20161544125', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (246, '张慧琳', '20161544125', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (247, '崔玉双', '20161544126', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (248, '崔玉双', '20161544126', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (249, '李圆圆', '20161544127', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (250, '陈梦', '20161544128', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (251, '陈梦', '20161544128', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (252, '朱梦晴', '20161544129', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (253, '朱梦晴', '20161544129', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (254, '任云博', '20161544130', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (255, '任云博', '20161544130', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第二学期', '通信161', '2017-11-22', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (128, '韩振帅', '20161544101', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', '2017-11-16', '测试');
INSERT INTO "public"."ims_integral" VALUES (129, '韩振帅', '20161544101', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (130, '韩振帅', '20161544101', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (131, '杜飞', '20161544102', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (132, '丁昌旭', '20161544103', 2, '红歌比赛', '第八周', '文艺部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (133, '邵文路', '20161544104', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (134, '邵文路', '20161544104', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (135, '刘震', '20161544105', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (136, '刘震', '20161544105', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (137, '张顺海', '20161544106', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (139, '马欢', '20161544107', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (140, '马欢', '20161544107', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (143, '段艳飞', '20161544108', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (144, '郭文凯', '20161544110', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (145, '郭文凯', '20161544110', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (146, '王得位', '20161544111', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (147, '王得位', '20161544111', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (148, '王得位', '20161544111', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (149, '陈子豪', '20161544112', 2, '红歌比赛', '第八周', '文艺部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (138, '张顺海', '20161544106', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', '2017-11-19', '测试');
INSERT INTO "public"."ims_integral" VALUES (192, '段艳飞', '20161544108', -0.7, '早操迟到1次缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-19', '2017-11-23', '测试');
INSERT INTO "public"."ims_integral" VALUES (150, '陈子豪', '20161544112', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (151, '陈子豪', '20161544112', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (152, '刘闯', '20161544113', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (153, '刘闯', '20161544113', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (154, '雷鑫', '20161544114', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (159, '黄柯文', '20161544116', 0.5, '卫生例查表扬', '第八周', '卫生部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (160, '黄柯文', '20161544116', 2.3, '红歌比赛朗诵', '第八周', '文艺部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (161, '黄柯文', '20161544116', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (162, '司鹏起', '20161544117', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (163, '司鹏起', '20161544117', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (164, '司鹏起', '20161544117', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (165, '司鹏起', '20161544117', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (166, '刘超', '20161544118', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (167, '刘超', '20161544118', 1, '新生篮球赛团体第三名', '第二周', '体育部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (168, '刘超', '20161544118', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (169, '刘超', '20161544118', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (170, '杨健林', '20161544119', -0.5, '早操缺勤1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (171, '杨健林', '20161544119', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (172, '杨健林', '20161544119', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (173, '雷峰', '20161544120', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (174, '张皓锋', '20161544121', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (175, '李君茹', '20161544122', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (176, '李君茹', '20161544122', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (177, '孙苗', '20161544123', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (178, '孙苗', '20161544123', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (179, '王鹏', '20161544124', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (180, '张慧琳', '20161544125', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (181, '张慧琳', '20161544125', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (182, '崔玉双', '20161544126', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (183, '崔玉双', '20161544126', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (184, '李圆圆', '20161544127', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (185, '陈梦', '20161544128', 0.5, '早操全勤', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (186, '陈梦', '20161544128', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (187, '朱梦晴', '20161544129', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (188, '朱梦晴', '20161544129', 0.1, '招聘会服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (189, '任云博', '20161544130', -0.2, '早操迟到1次', '第六周至第十周', '自律部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');
INSERT INTO "public"."ims_integral" VALUES (190, '任云博', '20161544130', 0.1, '球类服务', '第九周', '生活部', '2015-2016学年第一学期', '通信161', '2017-11-16', NULL, '测试');

-- ----------------------------
-- Table structure for ims_semester
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_semester";
CREATE TABLE "public"."ims_semester" (
  "semester_id" int4 NOT NULL DEFAULT nextval('ims_semester_semester_id_seq'::regclass),
  "semester_name" varchar(50) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_semester
-- ----------------------------
INSERT INTO "public"."ims_semester" VALUES (12, '2015-2016学年第二学期');
INSERT INTO "public"."ims_semester" VALUES (13, '2016-2017学年第一学期');
INSERT INTO "public"."ims_semester" VALUES (14, '2016-2017学年第二学期');
INSERT INTO "public"."ims_semester" VALUES (15, '2017-2018学年第一学期');
INSERT INTO "public"."ims_semester" VALUES (16, '2017-2018学年第二学期');
INSERT INTO "public"."ims_semester" VALUES (17, '2018-2019学年第一学期');
INSERT INTO "public"."ims_semester" VALUES (11, '2015-2016学年第一学期');
INSERT INTO "public"."ims_semester" VALUES (20, '2018-2019学年第二学期');

-- ----------------------------
-- Table structure for ims_student
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_student";
CREATE TABLE "public"."ims_student" (
  "id" int4 NOT NULL DEFAULT nextval('ims_student_id_seq'::regclass),
  "name" varchar(10) COLLATE "pg_catalog"."default",
  "grades" varchar(10) COLLATE "pg_catalog"."default",
  "student_id" varchar(32) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_student
-- ----------------------------
INSERT INTO "public"."ims_student" VALUES (2, '杜飞', '通信161', '20161544102');
INSERT INTO "public"."ims_student" VALUES (3, '丁昌旭', '通信161', '20161544103');
INSERT INTO "public"."ims_student" VALUES (5, '刘震', '通信161', '20161544105');
INSERT INTO "public"."ims_student" VALUES (6, '张顺海', '通信161', '20161544106');
INSERT INTO "public"."ims_student" VALUES (7, '马欢', '通信161', '20161544107');
INSERT INTO "public"."ims_student" VALUES (8, '段艳飞', '通信161', '20161544108');
INSERT INTO "public"."ims_student" VALUES (9, '郭文凯', '通信161', '20161544110');
INSERT INTO "public"."ims_student" VALUES (10, '王得位', '通信161', '20161544111');
INSERT INTO "public"."ims_student" VALUES (11, '陈子豪', '通信161', '20161544112');
INSERT INTO "public"."ims_student" VALUES (12, '刘闯', '通信161', '20161544113');
INSERT INTO "public"."ims_student" VALUES (13, '雷鑫', '通信161', '20161544114');
INSERT INTO "public"."ims_student" VALUES (14, '王德鹏', '通信161', '20161544115');
INSERT INTO "public"."ims_student" VALUES (15, '黄柯文', '通信161', '20161544116');
INSERT INTO "public"."ims_student" VALUES (16, '司鹏起', '通信161', '20161544117');
INSERT INTO "public"."ims_student" VALUES (17, '刘超', '通信161', '20161544118');
INSERT INTO "public"."ims_student" VALUES (18, '杨健林', '通信161', '20161544119');
INSERT INTO "public"."ims_student" VALUES (19, '雷峰', '通信161', '20161544120');
INSERT INTO "public"."ims_student" VALUES (20, '张皓锋', '通信161', '20161544121');
INSERT INTO "public"."ims_student" VALUES (21, '李君茹', '通信161', '20161544122');
INSERT INTO "public"."ims_student" VALUES (22, '孙苗', '通信161', '20161544123');
INSERT INTO "public"."ims_student" VALUES (23, '王鹏', '通信161', '20161544124');
INSERT INTO "public"."ims_student" VALUES (24, '张慧琳', '通信161', '20161544125');
INSERT INTO "public"."ims_student" VALUES (25, '崔玉双', '通信161', '20161544126');
INSERT INTO "public"."ims_student" VALUES (26, '李圆圆', '通信161', '20161544127');
INSERT INTO "public"."ims_student" VALUES (27, '陈梦', '通信161', '20161544128');
INSERT INTO "public"."ims_student" VALUES (28, '朱梦晴', '通信161', '20161544129');
INSERT INTO "public"."ims_student" VALUES (29, '任云博', '通信161', '20161544130');
INSERT INTO "public"."ims_student" VALUES (30, '张顺海', '通信161', '20161544109');
INSERT INTO "public"."ims_student" VALUES (1, '韩振帅', '通信161', '20161544101');
INSERT INTO "public"."ims_student" VALUES (32, '胡航宇', '计科172', '20171514201');
INSERT INTO "public"."ims_student" VALUES (33, '王治国', '计科172', '20171514202');
INSERT INTO "public"."ims_student" VALUES (34, '申玉豪', '计科172', '20171514203');
INSERT INTO "public"."ims_student" VALUES (35, '梁正茂', '计科172', '20171514204');
INSERT INTO "public"."ims_student" VALUES (36, '韩建勋', '计科172', '20171514205');
INSERT INTO "public"."ims_student" VALUES (37, '李军鹏', '计科172', '20171514206');
INSERT INTO "public"."ims_student" VALUES (38, '张钤', '计科172', '20171514207');
INSERT INTO "public"."ims_student" VALUES (39, '樊琪瑞', '计科172', '20171514208');
INSERT INTO "public"."ims_student" VALUES (40, '王勇', '计科172', '20171514209');
INSERT INTO "public"."ims_student" VALUES (41, '邢焕涛', '计科172', '20171514210');
INSERT INTO "public"."ims_student" VALUES (42, '张新天', '计科172', '20171514211');
INSERT INTO "public"."ims_student" VALUES (43, '樊世杰', '计科172', '20171514212');
INSERT INTO "public"."ims_student" VALUES (44, '史志瀚', '计科172', '20171514213');
INSERT INTO "public"."ims_student" VALUES (45, '宋志浩', '计科172', '20171514214');
INSERT INTO "public"."ims_student" VALUES (46, '单林华', '计科172', '20171514215');
INSERT INTO "public"."ims_student" VALUES (47, '吴芷旭', '计科172', '20171514216');
INSERT INTO "public"."ims_student" VALUES (48, '齐晨阳', '计科172', '20171514217');
INSERT INTO "public"."ims_student" VALUES (49, '杨军帅', '计科172', '20171514218');
INSERT INTO "public"."ims_student" VALUES (50, '张登波', '计科172', '20171514219');
INSERT INTO "public"."ims_student" VALUES (51, '段清欣', '计科172', '20171514220');
INSERT INTO "public"."ims_student" VALUES (52, '王栋', '计科172', '20171514221');
INSERT INTO "public"."ims_student" VALUES (53, '李志斌', '计科172', '20171514222');
INSERT INTO "public"."ims_student" VALUES (54, '陈笑寒', '计科172', '20171514223');
INSERT INTO "public"."ims_student" VALUES (55, '刘文龙', '计科172', '20171514224');
INSERT INTO "public"."ims_student" VALUES (56, '陈加响', '计科172', '20171514225');
INSERT INTO "public"."ims_student" VALUES (57, '王鑫', '计科172', '20171514226');
INSERT INTO "public"."ims_student" VALUES (58, '陈星如', '计科172', '20171514227');
INSERT INTO "public"."ims_student" VALUES (59, '马晨曦', '计科172', '20171514228');
INSERT INTO "public"."ims_student" VALUES (60, '袁艺菡', '计科172', '20171514229');
INSERT INTO "public"."ims_student" VALUES (61, '张玉', '计科172', '20171514230');
INSERT INTO "public"."ims_student" VALUES (62, '宋瑞楠', '计科172', '20171514231');
INSERT INTO "public"."ims_student" VALUES (63, '杨京港', '计科173', '20171514301');
INSERT INTO "public"."ims_student" VALUES (64, '刘醒龙', '计科173', '20171514302');
INSERT INTO "public"."ims_student" VALUES (65, '马秋阳', '计科173', '20171514303');
INSERT INTO "public"."ims_student" VALUES (66, '任鹏', '计科173', '20171514304');
INSERT INTO "public"."ims_student" VALUES (67, '董玉恒', '计科173', '20171514305');
INSERT INTO "public"."ims_student" VALUES (68, '杜瑞东', '计科173', '20171514306');
INSERT INTO "public"."ims_student" VALUES (69, '豆红明', '计科173', '20171514307');
INSERT INTO "public"."ims_student" VALUES (70, '刘果', '计科173', '20171514309');
INSERT INTO "public"."ims_student" VALUES (71, '常毅飞', '计科173', '20171514310');
INSERT INTO "public"."ims_student" VALUES (72, '刘宁', '计科173', '20171514311');
INSERT INTO "public"."ims_student" VALUES (73, '程森', '计科173', '20171514312');
INSERT INTO "public"."ims_student" VALUES (74, '陈港奥', '计科173', '20171514313');
INSERT INTO "public"."ims_student" VALUES (75, '张玉涛', '计科173', '20171514314');
INSERT INTO "public"."ims_student" VALUES (76, '刘万杰', '计科173', '20171514315');
INSERT INTO "public"."ims_student" VALUES (77, '高旭', '计科173', '20171514316');
INSERT INTO "public"."ims_student" VALUES (78, '吴宝锋', '计科173', '20171514317');
INSERT INTO "public"."ims_student" VALUES (79, '高志远', '计科173', '20171514318');
INSERT INTO "public"."ims_student" VALUES (80, '范晓鹏', '计科173', '20171514319');
INSERT INTO "public"."ims_student" VALUES (81, '唐同同', '计科173', '20171514320');
INSERT INTO "public"."ims_student" VALUES (82, '凌云志', '计科173', '20171514321');
INSERT INTO "public"."ims_student" VALUES (83, '张振', '计科173', '20171514322');
INSERT INTO "public"."ims_student" VALUES (84, '袁彪', '计科173', '20171514323');
INSERT INTO "public"."ims_student" VALUES (85, '施永浩', '计科173', '20171514324');
INSERT INTO "public"."ims_student" VALUES (86, '曹松松', '计科173', '20171514325');
INSERT INTO "public"."ims_student" VALUES (87, '邹倩倩', '计科173', '20171514326');
INSERT INTO "public"."ims_student" VALUES (88, '王倩', '计科173', '20171514327');
INSERT INTO "public"."ims_student" VALUES (89, '樊亚如', '计科173', '20171514328');
INSERT INTO "public"."ims_student" VALUES (90, '王媛', '计科173', '20171514329');
INSERT INTO "public"."ims_student" VALUES (91, '王小雨', '计科173', '20171514330');
INSERT INTO "public"."ims_student" VALUES (92, '赵红娇', '计科173', '20171514331');
INSERT INTO "public"."ims_student" VALUES (93, '刘佳星', '信工171', '20171524101');
INSERT INTO "public"."ims_student" VALUES (94, '徐朝阳', '信工171', '20171524102');
INSERT INTO "public"."ims_student" VALUES (95, '张天皓', '信工171', '20171524103');
INSERT INTO "public"."ims_student" VALUES (96, '李维华', '信工171', '20171524104');
INSERT INTO "public"."ims_student" VALUES (97, '苏方林', '信工171', '20171524105');
INSERT INTO "public"."ims_student" VALUES (98, '孙振宇', '信工171', '20171524106');
INSERT INTO "public"."ims_student" VALUES (99, '张炳炳', '信工171', '20171524107');
INSERT INTO "public"."ims_student" VALUES (100, '杨晓伟', '信工171', '20171524108');
INSERT INTO "public"."ims_student" VALUES (101, '郁雪成', '信工171', '20171524109');
INSERT INTO "public"."ims_student" VALUES (102, '何致远', '信工171', '20171524110');
INSERT INTO "public"."ims_student" VALUES (103, '焦近峰', '信工171', '20171524111');
INSERT INTO "public"."ims_student" VALUES (104, '鲍志鹏', '信工171', '20171524112');
INSERT INTO "public"."ims_student" VALUES (105, '于志豪', '信工171', '20171524113');
INSERT INTO "public"."ims_student" VALUES (106, '王乐庆', '信工171', '20171524114');
INSERT INTO "public"."ims_student" VALUES (107, '杨海涛', '信工171', '20171524115');
INSERT INTO "public"."ims_student" VALUES (108, '杨坤', '信工171', '20171524116');
INSERT INTO "public"."ims_student" VALUES (109, '王永豪', '信工171', '20171524117');
INSERT INTO "public"."ims_student" VALUES (110, '代宁辉', '信工171', '20171524118');
INSERT INTO "public"."ims_student" VALUES (111, '马贺', '信工171', '20171524119');
INSERT INTO "public"."ims_student" VALUES (112, '耿鑫', '信工171', '20171524120');
INSERT INTO "public"."ims_student" VALUES (113, '楚金阁', '信工171', '20171524121');
INSERT INTO "public"."ims_student" VALUES (114, '蔡亚舟', '信工171', '20171524122');
INSERT INTO "public"."ims_student" VALUES (115, '李智', '信工171', '20171524123');
INSERT INTO "public"."ims_student" VALUES (116, '张雅丽', '信工171', '20171524124');
INSERT INTO "public"."ims_student" VALUES (117, '淡雅婷', '信工171', '20171524125');
INSERT INTO "public"."ims_student" VALUES (118, '赵亚如', '信工171', '20171524126');
INSERT INTO "public"."ims_student" VALUES (119, '姜雨荷', '信工171', '20171524127');
INSERT INTO "public"."ims_student" VALUES (120, '杜文君', '信工171', '20171524128');
INSERT INTO "public"."ims_student" VALUES (121, '袁宁宁', '信工171', '20171524129');
INSERT INTO "public"."ims_student" VALUES (122, '柯彤', '信工171', '20171524130');
INSERT INTO "public"."ims_student" VALUES (4, '邵文路', '通信162', '20161544104');

-- ----------------------------
-- Table structure for ims_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."ims_user";
CREATE TABLE "public"."ims_user" (
  "user_id" int4 NOT NULL DEFAULT nextval('ims_user_user_id_seq'::regclass),
  "name" varchar(10) COLLATE "pg_catalog"."default",
  "student_id" varchar(13) COLLATE "pg_catalog"."default",
  "password" varchar(18) COLLATE "pg_catalog"."default",
  "role" varchar(20) COLLATE "pg_catalog"."default",
  "email" varchar(30) COLLATE "pg_catalog"."default",
  "pic" varchar(255) COLLATE "pg_catalog"."default",
  "clubroom" varchar(30) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ims_user
-- ----------------------------
INSERT INTO "public"."ims_user" VALUES (8, '组织者', '2', '208495d5', 'tourists', '400@qq.com', '20171122215449805.jpg', '主席团');
INSERT INTO "public"."ims_user" VALUES (1, '测试', '0', '208495d5', 'administrator', '43240825@qq.com', '20171123184957580.png', '主席团');
INSERT INTO "public"."ims_user" VALUES (7, '啧啧啧', '1', '208495d5', 'admin', '400@163.com', '20171123193445110.jpg', '办公室');

-- ----------------------------
-- View structure for sort
-- ----------------------------
DROP VIEW IF EXISTS "public"."sort";
CREATE VIEW "public"."sort" AS  SELECT i.student_name,
    sum(i.score) AS allscore,
    i.grades,
    i.int_semester,
    i.student_id
   FROM ims_integral i
  GROUP BY i.int_semester, i.grades, i.student_name, i.student_id
  ORDER BY i.int_semester, i.grades, (sum(i.score)) DESC;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."ims_class_class_id_seq"
OWNED BY "public"."ims_class"."class_id";
SELECT setval('"public"."ims_class_class_id_seq"', 19, true);
ALTER SEQUENCE "public"."ims_clubroom_clubroom_id_seq"
OWNED BY "public"."ims_clubroom"."clubroom_id";
SELECT setval('"public"."ims_clubroom_clubroom_id_seq"', 24, true);
ALTER SEQUENCE "public"."ims_semester_integral_id_seq"
OWNED BY "public"."ims_integral"."integral_id";
SELECT setval('"public"."ims_semester_integral_id_seq"', 256, true);
ALTER SEQUENCE "public"."ims_semester_semester_id_seq"
OWNED BY "public"."ims_semester"."semester_id";
SELECT setval('"public"."ims_semester_semester_id_seq"', 28, true);
ALTER SEQUENCE "public"."ims_student_id_seq"
OWNED BY "public"."ims_student"."id";
SELECT setval('"public"."ims_student_id_seq"', 123, true);
ALTER SEQUENCE "public"."ims_user_user_id_seq"
OWNED BY "public"."ims_user"."user_id";
SELECT setval('"public"."ims_user_user_id_seq"', 9, true);

-- ----------------------------
-- Primary Key structure for table ims_class
-- ----------------------------
ALTER TABLE "public"."ims_class" ADD CONSTRAINT "ims_class_pkey" PRIMARY KEY ("class_id");

-- ----------------------------
-- Primary Key structure for table ims_integral
-- ----------------------------
ALTER TABLE "public"."ims_integral" ADD CONSTRAINT "ims_integral_pkey" PRIMARY KEY ("integral_id");
