create table if not exists `orders`
(
    `id`              bigint       not null auto_increment,
    `user_id`         bigint       not null,
    `order_status_id` bigint       not null,
    `created_date`    timestamp    not null,
    `created_by`      varchar(100) not null,
    `updated_date`    timestamp    null,
    `updated_by`      varchar(100) null,
    primary key (id)
) engine = InnoDB
  default CHARSET = utf8;

create table if not exists `order_products`
(
    `order_id`   bigint not null,
    `product_id` bigint not null,
    primary key (order_id, product_id)
) engine = InnoDB
  default CHARSET = utf8;

create table if not exists `order_statuses`
(
    `id`           bigint       not null auto_increment,
    `status_name`  varchar(50)  not null,
    `created_date` timestamp    not null,
    `created_by`   varchar(100) not null,
    `updated_date` timestamp    null,
    `updated_by`   varchar(100) null,
    primary key (id)
) engine = InnoDB
  default CHARSET = utf8;

alter table order_products
    add constraint order_products_order foreign key (order_id) references orders (id);
alter table order_products
    add constraint order_products_product foreign key (product_id) references products (id);
alter table orders
    add constraint order_status foreign key (order_status_id) references order_statuses (id);