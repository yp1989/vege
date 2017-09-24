
CREATE TABLE `crm_contract_file` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `file_type` tinyint(4) NOT NULL COMMENT '附件类型 0 合同附件',
  `target_id` bigint(32) NOT NULL COMMENT '目标ID，根据file_type 附件类型有所不同',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件真实名称',
  `file_name_random` varchar(255) DEFAULT NULL COMMENT '文件随机名称（防止文件名重复）',
  `created_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

----单文件上传改为多文件上传迁移脚本
DROP PROCEDURE IF EXISTS contractPaths;

DELIMITER //
CREATE PROCEDURE contractPaths()
BEGIN
	DECLARE contractId INT;
	DECLARE accessoryName VARCHAR(255);

	DECLARE done INT DEFAULT FALSE;
	DECLARE clue_cur CURSOR FOR SELECT cc.id,cc.cont_accessory_name FROM crm_contract cc WHERE cc.cont_accessory_name IS NOT NULL;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

	OPEN clue_cur;
			emp_loop: LOOP
				IF done THEN
					SELECT '更新成功';
					LEAVE emp_loop;
				END IF;
				FETCH clue_cur INTO contractId,accessoryName;
				INSERT INTO crm_contract_file(file_type,target_id,file_name,created_at,updated_at)VALUES(0,contractId,accessoryName,NOW(),NOW());
				UPDATE crm_contract SET cont_accessory_name = NULL WHERE id = contractId;
			END LOOP;
	CLOSE clue_cur;
END//
DELIMITER ;

CALL contractPaths();

DROP PROCEDURE IF EXISTS contractPaths;