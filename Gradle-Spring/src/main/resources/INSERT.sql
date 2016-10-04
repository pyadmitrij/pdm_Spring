insert into employee values 
(1, 'Paul', 32, 'California', 20000.0, '2001-07-13'),
(2, 'Allen', 25, 'Texas', null, '2007-12-13'),
(3, 'Teddy', 23, 'Norway', 20000.0, null),
(4, 'Mark', 25, 'Rich-Mond', 65000.0, '2007-12-13'),
(5, 'David', 27, 'Texas', 85000.0, '2007-12-13'),
(6, 'Kim', 22, 'South-Hall', 45000.0, '2007-06-13'),
(7, 'James', 24, 'Huston', 20000.0, '2006-05-13');

insert into employee value
(8, 'Kate', 23, 'Huston', 15000, '2016-04-22', 4);

insert into department values 
(1, 'Engineering'),
(2, 'IT'),
(3, 'Finance');

insert into department value (4, 'HR') ;

update employee set DEPARTMENT_ID = 1 where id < 4;
update employee set DEPARTMENT_ID = 2 where id >= 4 and id < 6;
update employee set DEPARTMENT_ID = 3 where id >= 6;