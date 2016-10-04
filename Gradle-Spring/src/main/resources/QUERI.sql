select ADRRESS, count(id) ammount from employee group by ADRRESS;

select * from employee;

select * from department;

select employee.NAME, employee.ADRRESS, department.NAME from employee inner join department on employee.DEPARTMENT_ID = department.id;

select employee.NAME, employee.ADRRESS, department.NAME from employee inner join department on employee.DEPARTMENT_ID = department.id
where department.NAME like 'Finance';

select employee.NAME, employee.ADRRESS, department.NAME from employee inner join department on employee.DEPARTMENT_ID = department.id
where department.NAME like 'I%';

select employee.NAME, employee.ADRRESS, department.NAME from employee right join department on employee.DEPARTMENT_ID = department.id;

