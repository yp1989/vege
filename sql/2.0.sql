### 分配代理商 线索表新增字段
ALTER TABLE `crm_clue` ADD COLUMN `owner_type` tinyint(4) NULL DEFAULT 0  COMMENT '线索归属类型 0 归属用户 1 归属代理商' AFTER `owner_name`;


INSERT INTO crm_auth (`auth_code`,`auth_name`,`auth_type`,`auth_url`,`is_del`,`create_time`,`update_time`)VALUES(0,'获取代理商',3,'/callcenter/getAgent',0,NOW(),NOW());

INSERT INTO crm_auth (`auth_code`,`auth_name`,`auth_type`,`auth_url`,`is_del`,`create_time`,`update_time`)VALUES(0,'分配线索给代理商',3,'/callcenter/addClueToAgent',0,NOW(),NOW());


#### 部门查询多级子部门数据 modify by 2015-10-12

 DELIMITER $$
CREATE DEFINER=`vcooline`@`%` FUNCTION `getChildList`(rootId BIGINT(32)) RETURNS varchar(1000) CHARSET utf8
BEGIN
    DECLARE sTemp VARCHAR(1000);
    DECLARE sTempChd VARCHAR(1000);

    SET sTemp = '$';
	SELECT ca.admin_dep INTO sTempChd FROM crm_admin ca WHERE ca.id = rootId;

    WHILE sTempChd IS NOT NULL DO
      SET sTemp = CONCAT(sTemp, ',', sTempChd);
      SELECT
        GROUP_CONCAT(id)
      INTO sTempChd
      FROM crm_dep
      WHERE FIND_IN_SET(CAST(parent_id AS CHAR), sTempChd) > 0;
    END WHILE;
    RETURN sTemp;
  END$$
DELIMITER ;