insert into `product_categories`(id, category_name, created_date, created_by)
values (6, 'hard disk', '2020-10-19 15:40:02', 'dev'),
       (7, 'cooling system', '2020-10-19 15:40:02', 'dev'),
       (8, 'computer case', '2020-10-19 15:40:02', 'dev'),
       (9, 'power supply', '2020-10-19 15:40:02', 'dev'),
       (10, 'solid state drive', '2020-10-19 15:40:02', 'dev');

insert into `computer_case_types`(id, case_type_name, created_date, created_by)
values (1, 'Super tower', '2020-11-09 10:19:00', 'dev'),
       (2, 'Full tower', '2020-11-09 10:19:00', 'dev'),
       (3, 'Midi tower', '2020-11-09 10:19:00', 'dev'),
       (4, 'Mini tower', '2020-11-09 10:19:00', 'dev');

insert into `motherboard_form_factors`(id, form_factor_name, created_date, created_by)
values (1, 'ATX', '2020-11-09 10:19:00', 'dev'),
       (2, 'mATX', '2020-11-09 10:19:00', 'dev'),
       (3, 'eATX', '2020-11-09 10:19:00', 'dev'),
       (4, 'Mini-ITX', '2020-11-09 10:19:00', 'dev'),
       (5, 'Mini STX', '2020-11-09 10:19:00', 'dev');

insert into `power_supply_categories`(id, category_name, created_date, created_by)
values (1, 'standard', '2020-11-09 10:19:00', 'dev'),
       (2, 'gaming', '2020-11-09 10:19:00', 'dev'),
       (3, 'server', '2020-11-09 10:19:00', 'dev');

insert into `ram_memory_types`(id, memory_type_name, created_date, created_by)
values (1, 'DDR3', '2020-11-09 10:19:00', 'dev'),
       (2, 'DDR4', '2020-11-09 10:19:00', 'dev');

insert into `video_memory_types`(id, memory_type_name, created_date, created_by)
values (1, 'DDR4', '2020-11-09 10:19:00', 'dev'),
       (2, 'GDDR3', '2020-11-09 10:19:00', 'dev'),
       (3, 'GDDR5', '2020-11-09 10:19:00', 'dev'),
       (4, 'GDDR5X', '2020-11-09 10:19:00', 'dev'),
       (5, 'GDDR6', '2020-11-09 10:19:00', 'dev'),
       (6, 'GDDR6X', '2020-11-09 10:19:00', 'dev');