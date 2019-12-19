-- 测试
select sysdate from dual;
/*
  创建菜单表
 */
create table sys_menu(
   id number primary key,
   pid number,-- 父id
   title varchar2(50),-- 菜单名称
   href varchar2(50),-- 跳转地址
   target varchar2(30),-- 打开方式
   icon varchar2(30), -- 图标
   available number -- 0 不可用 1可用
);
/*
  交友模块:
    好友表
    好友关系表
    信息表:发消息表 接收消息表
 */
drop table exam_users;
create table exam_users(
  User_id number(5) primary key ,
  User_name  varchar2(20) ,
  User_pwd   varchar2(32),
  User_sex   number(2), -- 0女 1男
  User_phone varchar2(20),
  User_head_portrait varchar2(50), -- 头像的url地址
  User_role number(2),
  User_create_date DATE,-- 创建时间
  available number(2) -- 是否可用:0不可用 1可用
);
alter table exam_users drop column User_role;
alter table exam_users modify (User_head_portrait varchar2(100));
-- 权限表
create table exam_role(
  rid number(5) primary key,
  rname varchar2(20),
  roledesc varchar2(100),
  available number(2)
);
-- 修改字段类型
alter table exam_role modify (available number(2));
--
drop table exam_role_user;
create table exam_role_user(
   user_id number(2),
   rid number(2)
);

create sequence seq_user;
select seq_user.nextval
from dual;




