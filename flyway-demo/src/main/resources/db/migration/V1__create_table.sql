create table user_sql(
 user_id int(4) not null primary key auto_increment,
 name char(20) not null,
 sex int(4) not null default '0',
 degree double(16,2));