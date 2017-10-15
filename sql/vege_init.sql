TRUNCATE TABLE crm_role;
INSERT INTO crm_role(role_code, role_name, role_desc, role_type, is_del, create_time, update_time)
    VALUE (1,'超级管理员',NULL ,0,0,now(),now());

TRUNCATE TABLE crm_dep;
INSERT INTO crm_dep(parent_id, dep_code, dep_name, dep_desc, dep_isleaf, is_del, create_time, update_time)
  VALUE (0,1,'菜场管理公司',NULL ,0,0,now(),now());

INSERT INTO crm_auth(auth_code, parent_id, auth_name, auth_type, auth_desc, auth_url, auth_img, auth_sort, is_del, create_time, update_time)
  VALUE(0,NULL ,'机器码管理',1,NULL ,'/machine/index','fa-database',2,0,now(),now());
INSERT INTO crm_role_auth(role_id, auth_id, is_del, create_time, update_time) VALUE (1,101,0,now(),now());