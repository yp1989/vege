TRUNCATE TABLE crm_role;
INSERT INTO crm_role(role_code, role_name, role_desc, role_type, is_del, create_time, update_time)
    VALUE (1,'超级管理员',NULL ,0,0,now(),now());

TRUNCATE TABLE crm_dep;
INSERT INTO crm_dep(parent_id, dep_code, dep_name, dep_desc, dep_isleaf, is_del, create_time, update_time)
  VALUE (0,1,'菜场管理公司',NULL ,0,0,now(),now());