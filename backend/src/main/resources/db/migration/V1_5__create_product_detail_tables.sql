create table if not exists cpus(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `socket_id` bigint not null,
    `count_of_core` int not null,
    `max_count_of_thread` int not null,
    `clock_frequency` int not null,
    `max_clock_frequency` int not null,
    `technical_process` varchar(10) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists motherboards(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `socket_id` bigint not null,
    `form_factor_id` bigint not null,
    `type_of_memory_id` bigint not null,
    `number_of_memory_slot` int not null,
    `maximum_memory_size` int not null,
    `maximum_memory_frequency` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists rams(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `memory_type_id` bigint not null,
    `size` int not null,
    `frequency` int not null,
    `cooling` boolean not null,
    `backlight` boolean not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists hard_disks(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `disk_size` int not null,
    `spindle_speed` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `solid_state_drives` (
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `size` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key (id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `video_cards`(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `video_memory_type_id` bigint not null,
    `video_memory` int not null,
    `frequency` int not null,
    `max_frequency` int not null,
    `memory_bus_width` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `power_supplies` (
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `power_supply_category_id` bigint not null,
    `power` int not null,
    `certificate` varchar(100) not null,
    `module_power_cable_connection` boolean not null,
    `width` int not null,
    `depth` int not null,
    `height` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `computer_cases` (
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `computer_case_type_id` bigint not null,
    `max_motherboard_size_id` bigint not null,
    `color` varchar(50) not null,
    `window_material` varchar(50) not null,
    `width` int not null,
    `depth` int not null,
    `height` int not null,
    `weight` int not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `sockets` (
    `id` bigint not null auto_increment,
    `socket_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `ram_memory_types` (
    `id` bigint not null auto_increment,
    `memory_type_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `motherboard_form_factors` (
    `id` bigint not null auto_increment,
    `form_factor_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `cooling_systems`(
    `id` bigint not null auto_increment,
    `product_id` bigint not null,
    `socket_id` bigint not null,
    `power_dissipation` int not null,
    `radiator_material` varchar(50) not null,
    `number_of_heat_pipes` int not null,
    `fan_diameter` int not null,
    `count_of_fan` int not null,
    `max_rotation_speed` int not null,
    `backlight` boolean not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    `width` int not null,
    `depth` int not null,
    `height` int not null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `video_memory_types` (
    `id` bigint not null auto_increment,
    `memory_type_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `power_supply_categories` (
    `id` bigint not null auto_increment,
    `category_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

create table if not exists `computer_case_types` (
    `id` bigint not null auto_increment,
    `case_type_name` varchar(50) not null,
    `created_date` timestamp not null,
    `created_by` varchar(100) not null,
    `updated_date` timestamp null,
    `updated_by` varchar(100) null,
    primary key(id)
)engine=InnoDB default CHARSET=utf8;

alter table cpus add constraint cpu_product foreign key(product_id) references products(id);
alter table cpus add constraint cpu_socket foreign key(socket_id) references sockets(id);

alter table motherboards add constraint motherboard_product foreign key(product_id) references products(id);
alter table motherboards add constraint motherboard_socket foreign key(socket_id) references sockets(id);
alter table motherboards add constraint motherboard_form_factor foreign key(form_factor_id) references motherboard_form_factors(id);
alter table motherboards add constraint motherboard_ram_memory_type foreign key(type_of_memory_id) references ram_memory_types(id);

alter table rams add constraint ram_product foreign key(product_id) references products(id);
alter table rams add constraint ram_memory_type foreign key(memory_type_id) references ram_memory_types(id);

alter table hard_disks add constraint hard_disks_product foreign key(product_id) references products(id);

alter table power_supplies add constraint power_supply_product foreign key(product_id) references products(id);
alter table power_supplies add constraint power_supply_category foreign key(power_supply_category_id) references power_supply_categories(id);

alter table computer_cases add constraint computer_case_product foreign key(product_id) references products(id);
alter table computer_cases add constraint computer_case_type foreign key(computer_case_type_id) references computer_case_types(id);
alter table computer_cases add constraint computer_case_motherboard_form_factor foreign key (max_motherboard_size_id) references motherboard_form_factors(id);

alter table cooling_systems add constraint cooling_system_product foreign key(product_id) references products(id);
alter table cooling_systems add constraint cooling_system_socket foreign key(socket_id) references sockets(id);

alter table video_cards add constraint video_card_product foreign key(product_id) references products(id);
alter table video_cards add constraint video_card_video_memory_type foreign key (video_memory_type_id) references video_memory_types(id);