create database Employee_Managment_System;
use Employee_Managment_System;
create table Employee(Employee_Id integer  primary key not null, Employee_Name varchar(200),Date_Of_Birth date);
desc Employee;
insert into Employee values(1001,'Naresh','1998-08-31');
insert into Employee values(1002,'Mahesh','2000-06-14'),(1003,'Nandan','1999-02-17');
select * from Employee;