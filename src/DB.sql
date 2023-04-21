create table Employee(
employee_id varchar(10) not null primary key,
name varchar(100),
birthday varchar(10),
phone varchar(10),
address varchar(100),
department_id varchar(10),
FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

create table Department(
department_id varchar(10)not null primary key,
department_name varchar(50)
)
