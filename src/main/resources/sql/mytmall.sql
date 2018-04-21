drop database if exists mytmalldb;
create database mytmalldb;
use mytmalldb;

create table t_category
(
  category_id int(11) not null auto_increment,
  category_name varchar(255) not null,

  primary key(category_id)
)engine = InnoDB default charset=utf8;

create table t_product
(
  product_id int(11) not null auto_increment,
  category_id int(11) not null,
  title varchar(255) not null,
  subTitle varchar(255),
  initial_price float not null,
  discount_price float not null,
  review_num int(11) not null,
  vol int(11) not null,
  stock int(11) not null,

  primary key(product_id),
  constraint fk_product_category foreign key(category_id)
  references t_category(category_id)
)engine = InnoDB default charset = utf8;

create table t_property
(
  property_id int(11) not null auto_increment,
  category_id int(11) not null,
  property_name varchar(255) not NULL,

  primary key(property_id),
  constraint fk_property_category foreign key(category_id)
  references t_category(category_id)
)engine = InnoDB default charset = utf8;

create table t_property_value
(
  property_value_id int(11) not null auto_increment,
  property_id int(11) not null,
  product_id int(11) not null,
  property_value varchar(255),

  primary key(property_value_id),
  constraint fk_property_value_property foreign key(property_id)
  references t_property(property_id),
  constraint fk_property_value_product foreign key(product_id)
  references t_product(product_id)
)engine = InnoDB default charset = utf8;

create table t_picture
(
  pricture_id int(11) not null auto_increment,
  product_id int(11) not null,
  type int not null,

  primary key(pricture_id),
  constraint fk_picture_product foreign key(product_id)
  references t_product(product_id)
)engine = InnoDB default charset = utf8;

create table t_user
(
  user_id int(11) not null auto_increment,
  user_name varchar(255) not null,
  password varchar(255) not null,

  primary key(user_id)
)engine = InnoDB default charset = utf8;

create table t_order
(
  order_id int(11) not null auto_increment,
  user_id int(11) not null,
  address varchar(255),
  tele_num varchar(255),
  reciver varchar(255),
  post varchar(255),
  orderCode varchar(255) not null,
  total_num int not null,
  total_price float not null,
  state int not null,
  create_time datetime default null,
  pay_time datetime default null,
  deliver_time datetime default null,
  comfirm_time datetime default null,
  user_message varchar(255) default null,

  primary key(order_id),
  constraint fk_order_user foreign key(user_id)
  references t_user(user_id)
)engine = InnoDB default charset = utf8;

create table t_order_item
(
  order_item_id int(11) not null auto_increment,
  product_id int(11) not null,
  order_id int(11) not null,
  user_id int(11) not null,
  total_num int(11) not null,
  total_price float not null,

  primary key(order_item_id),
  constraint fk_order_item_product foreign key(product_id)
  references t_product(product_id),
  constraint fk_order_item_order foreign key(order_id)
  references t_order(order_id),
  constraint fk_order_item_user foreign key(user_id)
  references t_user(user_id)
)engine = InnoDB default charset = utf8;

create table t_review
(
  review_id int(11) not null auto_increment,
  user_id int(11) not null,
  product_id int(11) not null,
  content varchar(255) not null,
  create_time datetime not null,

  primary key(review_id),
  constraint fk_review_user foreign key(user_id)
  references t_user(user_id),
  constraint fk_review_product foreign key(product_id)
  references t_product(product_id)
)engine = InnoDB default charset = utf8;



