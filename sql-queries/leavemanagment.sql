create database leavemanagment;
use leavemanagment;
create table Employees (employee_id integer primary key not null, name varchar(200),email varchar(100),phone_number bigint,department varchar(100));
desc Employees;
select * from employees;

create table Leave_Requests (leave_request_id bigint primary key not null,employee_id bigint,start_date date,end_date date,leave_type varchar(200),reason varchar(200),status varchar(200));
desc Leave_Requests;
select * from Leave_Requests;

create table Leave_Balance(leave_balance_id  bigint,employee_id bigint,leave_type varchar(200),balance integer);
desc Leave_Balance;
select * from Leave_Balance;