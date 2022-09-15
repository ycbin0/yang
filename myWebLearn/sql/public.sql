/*
 Navicat Premium Data Transfer

 Source Server         : PostgreSql
 Source Server Type    : PostgreSQL
 Source Server Version : 90405
 Source Host           : localhost:5432
 Source Catalog        : learnway
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90405
 File Encoding         : 65001

 Date: 01/08/2022 17:51:46
*/


-- ----------------------------
-- Sequence structure for seq_sys_login
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_sys_login";
CREATE SEQUENCE "public"."seq_sys_login" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_authority";
CREATE TABLE "public"."sys_authority" (
  "auth_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "auth_name" varchar(20) COLLATE "pg_catalog"."default",
  "auth_code" varchar(70) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "update_by" int4,
  "update_time" timestamp(6),
  "create_time" timestamp(6),
  "remark" varchar(50) COLLATE "pg_catalog"."default",
  "del_flag" int4 DEFAULT 0,
  "bak" varchar(50) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_authority"."auth_id" IS '权限主键';
COMMENT ON COLUMN "public"."sys_authority"."auth_name" IS '权限名称';
COMMENT ON COLUMN "public"."sys_authority"."auth_code" IS '权限标识符';
COMMENT ON COLUMN "public"."sys_authority"."create_by" IS '创建人id';
COMMENT ON COLUMN "public"."sys_authority"."update_by" IS '更新人id';
COMMENT ON COLUMN "public"."sys_authority"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_authority"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_authority"."remark" IS '备注';
COMMENT ON COLUMN "public"."sys_authority"."del_flag" IS '是否删除 0 否， 1 是';
COMMENT ON COLUMN "public"."sys_authority"."bak" IS '备用字段';
COMMENT ON TABLE "public"."sys_authority" IS '权限表';

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO "public"."sys_authority" VALUES ('ad8f34d8ff5a46c0a4b6a6df29276f10', '名称是：auth_admin', 'auth_admin', NULL, NULL, '2022-07-31 14:51:52.163', '2022-07-31 14:51:52.163', NULL, 0, NULL);
INSERT INTO "public"."sys_authority" VALUES ('af77a001b8ce45469b51ae4b68e50c6c', '名称是：auth_index', 'auth_index', NULL, NULL, '2022-07-31 14:51:52.167', '2022-07-31 14:51:52.167', NULL, 0, NULL);
INSERT INTO "public"."sys_authority" VALUES ('2280722801164dd98ad451c37d2047d7', '名称是：auth_test', 'auth_test', NULL, NULL, '2022-07-31 14:51:52.169', '2022-07-31 14:51:52.169', NULL, 0, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
  "role_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "role_name" varchar(20) COLLATE "pg_catalog"."default",
  "role_description" varchar(50) COLLATE "pg_catalog"."default",
  "create_by" int4,
  "update_by" int4,
  "update_time" timestamp(6),
  "create_time" timestamp(6),
  "remark" varchar(50) COLLATE "pg_catalog"."default",
  "del_flag" int4 DEFAULT 0,
  "bak" varchar(50) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_role"."role_id" IS '角色主键';
COMMENT ON COLUMN "public"."sys_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."role_description" IS '角色描述';
COMMENT ON COLUMN "public"."sys_role"."create_by" IS '创建人id';
COMMENT ON COLUMN "public"."sys_role"."update_by" IS '更新人id';
COMMENT ON COLUMN "public"."sys_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."remark" IS '备注';
COMMENT ON COLUMN "public"."sys_role"."del_flag" IS '是否删除 0 否， 1 是';
COMMENT ON COLUMN "public"."sys_role"."bak" IS '备用字段';
COMMENT ON TABLE "public"."sys_role" IS '角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES ('eba1eb9d10de4fb88f56d5d406b89b42', 'admin', '描述是：admin', NULL, NULL, '2022-07-31 14:51:52.177', '2022-07-31 14:51:52.177', NULL, 0, NULL);
INSERT INTO "public"."sys_role" VALUES ('cad54a5551424146bc38d203d1d3b7f7', 'tourist', '描述是：tourist', NULL, NULL, '2022-07-31 14:51:52.183', '2022-07-31 14:51:52.183', NULL, 0, NULL);
INSERT INTO "public"."sys_role" VALUES ('14f51ba209a14ebdb6571a10faf9bccc', 'ordinary', '描述是：ordinary', NULL, NULL, '2022-07-31 14:51:52.186', '2022-07-31 14:51:52.186', NULL, 0, NULL);

-- ----------------------------
-- Table structure for sys_role_authority
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_authority";
CREATE TABLE "public"."sys_role_authority" (
  "role_id" varchar(32) COLLATE "pg_catalog"."default",
  "auth_id" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_role_authority"."role_id" IS '角色主键';
COMMENT ON COLUMN "public"."sys_role_authority"."auth_id" IS '权限主键';
COMMENT ON TABLE "public"."sys_role_authority" IS '角色权限关联表';

-- ----------------------------
-- Records of sys_role_authority
-- ----------------------------
INSERT INTO "public"."sys_role_authority" VALUES ('eba1eb9d10de4fb88f56d5d406b89b42', 'ad8f34d8ff5a46c0a4b6a6df29276f10');
INSERT INTO "public"."sys_role_authority" VALUES ('eba1eb9d10de4fb88f56d5d406b89b42', 'af77a001b8ce45469b51ae4b68e50c6c');
INSERT INTO "public"."sys_role_authority" VALUES ('eba1eb9d10de4fb88f56d5d406b89b42', '2280722801164dd98ad451c37d2047d7');
INSERT INTO "public"."sys_role_authority" VALUES ('cad54a5551424146bc38d203d1d3b7f7', 'af77a001b8ce45469b51ae4b68e50c6c');
INSERT INTO "public"."sys_role_authority" VALUES ('14f51ba209a14ebdb6571a10faf9bccc', 'ad8f34d8ff5a46c0a4b6a6df29276f10');
INSERT INTO "public"."sys_role_authority" VALUES ('cad54a5551424146bc38d203d1d3b7f7', '2280722801164dd98ad451c37d2047d7');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
  "user_id" int4 NOT NULL DEFAULT nextval('seq_sys_login'::regclass),
  "user_name" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "nick_name" varchar(30) COLLATE "pg_catalog"."default",
  "last_login_time" timestamp(6),
  "create_by" int4,
  "create_time" timestamp(6),
  "update_by" int4,
  "update_time" timestamp(6),
  "del_flag" int4 DEFAULT 0,
  "bak" varchar(50) COLLATE "pg_catalog"."default",
  "remark" varchar(50) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user"."user_id" IS '用户主键';
COMMENT ON COLUMN "public"."sys_user"."user_name" IS '账户';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '昵称';
COMMENT ON COLUMN "public"."sys_user"."last_login_time" IS '最后登录时间';
COMMENT ON COLUMN "public"."sys_user"."create_by" IS '创建用户id';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_by" IS '修改人id';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '修改时间';
COMMENT ON COLUMN "public"."sys_user"."del_flag" IS '是否删除 0 否， 1 是';
COMMENT ON COLUMN "public"."sys_user"."bak" IS '备用字段';
COMMENT ON COLUMN "public"."sys_user"."remark" IS '备注';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES (1, 'bin', '$2a$10$JbwBUqdSG.tUTGWdqXprVuBjOVZcVolJ51mH32MaE.jnT1xA4DVli', 'bin yc', NULL, NULL, '2022-07-31 14:51:52.265', NULL, '2022-07-31 14:51:52.265', 0, NULL, NULL);
INSERT INTO "public"."sys_user" VALUES (2, 'yqy', '$2a$10$GqZN6jEv53Ff96DON2zTY.r5HJHIa3ogEGpTD7wRLqSw.5oOaNQf.', 'bin 老婆', NULL, NULL, '2022-07-31 14:51:52.355', NULL, '2022-07-31 14:51:52.355', 0, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
  "user_id" int4,
  "role_id" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user_role"."user_id" IS '用户主键';
COMMENT ON COLUMN "public"."sys_user_role"."role_id" IS '角色主键';
COMMENT ON TABLE "public"."sys_user_role" IS '用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO "public"."sys_user_role" VALUES (1, 'eba1eb9d10de4fb88f56d5d406b89b42');
INSERT INTO "public"."sys_user_role" VALUES (2, 'cad54a5551424146bc38d203d1d3b7f7');

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_sys_login"', 3, true);

-- ----------------------------
-- Primary Key structure for table sys_authority
-- ----------------------------
ALTER TABLE "public"."sys_authority" ADD CONSTRAINT "sys_authority_pkey" PRIMARY KEY ("auth_id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("user_id");
