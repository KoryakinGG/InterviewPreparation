drop table if exists students cascade;
create table students (id bigserial, name varchar(255), age int, primary key(id));
insert into students
(name, age) values
('Batman', 45),
('Superman', 35),
('Aquaman', 27);
