create table if not exists `users`(
    `id` bigint not null auto_increment,
    `username` varchar(50) not null,
    `email` varchar(100) not null,
    `password` varchar(255) not null,
    `activation_code` varchar(255) null,
    `role_id` bigint not null,
    `status_id` bigint not null,
    `secret_question_id` bigint null,
    `secret_question_answer` varchar(100) null,
    `customer_id` bigint not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `customers`(
    `id` bigint not null auto_increment,
    `first_name` varchar(50) null,
    `last_name` varchar(50) null,
    `cell_phone` varchar(15) null ,
    `gender_id` bigint null,
    `country` varchar(50) null,
    `city` varchar(50) null,
    `street` varchar(50) null,
    `house_number` varchar(50) null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `roles`(
    `id` bigint not null auto_increment,
    `role_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `user_statuses`(
    `id` bigint not null auto_increment,
    `status_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `secret_questions`(
    `id` bigint not null auto_increment,
    `secret_question_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `genders`(
    `id` bigint not null auto_increment,
    `gender_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

alter table users add constraint user_customer foreign key (customer_id) references customers(id);
alter table users add constraint user_role foreign key (role_id) references roles(id);
alter table users add constraint user_status foreign key (status_id) references user_statuses(id);
alter table users add constraint user_secret_question foreign key (secret_question_id) references secret_questions(id);
alter table customers add constraint customer_gender foreign key (gender_id) references genders(id);
