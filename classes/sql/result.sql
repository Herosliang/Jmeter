create table resulte(
id int primary key auto_increment COMMENT '自增列id',
jmx_name varchar(22) NOT NULL COMMENT '执行脚本名称',
lable varchar(22) NOT NULL COMMENT '测试接口名称',
total_num int NOT NULL COMMENT '接口总个数',
success_num int NOT NULL COMMENT '成功接口个数',
tail_num int NOT NULL COMMENT '失败接口个数',
resulte int NOT NULL COMMENT '用例成功失败',
create_at Datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间'
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=UTF8
