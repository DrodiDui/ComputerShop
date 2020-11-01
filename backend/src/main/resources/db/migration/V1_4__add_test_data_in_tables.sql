insert into roles(id, role_name, created_date, created_by) VALUES
(1, 'admin_role', '2020-10-19 15:40:02', 'dev'),
(2, 'user_role', '2020-10-19 15:40:02', 'dev');

insert into user_statuses(id, status_name, created_date, created_by) VALUES
(1, 'active', '2020-10-19 15:40:02', 'dev'),
(2, 'inactive', '2020-10-19 15:40:02', 'dev'),
(3, 'deleted', '2020-10-19 15:40:02', 'dev');

insert into genders(id, gender_name, created_date, created_by) VALUES
(1, 'male', '2020-10-19 15:40:02', 'dev'),
(2, 'female', '2020-10-19 15:40:02', 'dev'),
(3, 'no_sex', '2020-10-19 15:40:02', 'dev');

insert into product_categories(id, category_name, created_date, created_by) VALUES
(1, 'desktop pc', '2020-10-19 15:40:02', 'dev'),
(2, 'cpu', '2020-10-19 15:40:02', 'dev'),
(3, 'ram', '2020-10-19 15:40:02', 'dev'),
(4, 'video card', '2020-10-19 15:40:02', 'dev'),
(5, 'mother board', '2020-10-19 15:40:02', 'dev');

insert into product_statuses(id, status_name, created_date, created_by) VALUES
(1, 'in stock', '2020-10-19 15:40:02', 'dev'),
(2, 'out of stock', '2020-10-19 15:40:02', 'dev'),
(3, 'withdrawn form sale', '2020-10-19 15:40:02', 'dev');

insert into order_statuses(id, status_name, created_date, created_by) VALUES
(1, 'in stock', '2020-10-19 15:40:02', 'dev'),
(2, 'transferred to the courier', '2020-10-19 15:40:02', 'dev'),
(3, 'delivered', '2020-10-19 15:40:02', 'dev');

insert into secret_questions(id, secret_question_name, created_date, created_by) VALUES
(1, 'where were you born', '2020-10-19 15:40:02', 'dev'),
(2, 'name of the first pet', '2020-10-19 15:40:02', 'dev');