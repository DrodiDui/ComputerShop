create table if not exists `products`(
    `id` bigint not null auto_increment,
    `product_name` varchar(50) not null,
    `description` varchar(255) not null,
    `price` int not null,
    `model` varchar(100) not null,
    `brand` varchar(100) not null,
    `age_of_release` varchar(10) not null,
    `count_in_stock` int not null,
    `product_category_id` bigint not null,
    `status_id` bigint not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;


create table if not exists `product_categories`(
    `id` bigint not null auto_increment,
    `category_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `product_statuses`(
    `id` bigint not null auto_increment,
    `status_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `reviews`(
    `id` bigint not null auto_increment,
    `message` varchar(255) not null,
    `advantages` varchar(255) not null,
    `disadvantages` varchar(255) not null,
    `product_id` bigint null,
    `user_id` bigint not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;


alter table products add constraint product_category foreign key(product_category_id) references product_categories(id);
alter table products add constraint product_status foreign key (status_id) references product_statuses(id);
alter table reviews add constraint review_product foreign key (product_id) references products(id);
alter table reviews add constraint review_user foreign key (user_id) references users(id);