create table if not exists `images`
(
    `id`                  bigint       not null auto_increment,
    `image_path`          varchar(255) not null,
    `image_name`          varchar(255) not null,
    `image_original_name` varchar(255) not null,
    `created_date`        timestamp    not null,
    `created_by`          varchar(100) not null,
    `updated_date`        timestamp    null,
    `updated_by`          varchar(100) null,
    primary key (id)
) engine = InnoDB
  default CHARSET = utf8;

create table if not exists `product_images`
(
    `product_id` bigint not null,
    `image_id`   bigint not null,
    primary key (product_id, image_id)
) engine = InnoDB
  default CHARACTER SET = utf8;

create table if not exists `payment_methods`
(
    `id`           bigint       not null,
    `payment_name` varchar(50)  not null,
    `created_date` timestamp    not null,
    `created_by`   varchar(100) not null,
    `updated_date` timestamp    null,
    `updated_by`   varchar(100) null,
    primary key (id)
) engine = InnoDB
  default CHARACTER SET = utf8;

alter table users
    add `photo_id` bigint null;
alter table orders
    add `payment_id` bigint not null;
alter table products
    add `preview_image_id` bigint not null;

alter table users
    add constraint `user_image` foreign key (photo_id) references images (id);
alter table product_images
    add constraint product_images_product foreign key (product_id) references products (id);
alter table product_images
    add constraint product_images_image foreign key (image_id) references images (id);
alter table orders
    add constraint order_payment_method foreign key (payment_id) references payment_methods (id);
alter table products
    add constraint product_preview_image foreign key (preview_image_id) references images (id);