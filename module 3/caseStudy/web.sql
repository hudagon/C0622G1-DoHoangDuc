create database furamapro;

create table position (
	id int,
    name varchar(45),
    primary key (id)
);


create table education_degree (
	id int,
    name varchar(45),
    primary key (id)
);

create table division (
	id int,
    name varchar(45),
    primary key (id)
);

create table employee (
	id int,
    name varchar(45),
    date_of_birth date,
    id_card varchar(45),
    salary double,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(45),
    primary key (id),
    foreign key (position_id) references `position`(id)  ON DELETE CASCADE,
    foreign key (education_degree_id) references `education_degree`(id)  ON DELETE CASCADE,
    foreign key (division_id) references `division`(id)  ON DELETE CASCADE,
    foreign key (username) references `user`(username)  ON DELETE CASCADE
);

create table `role` (
	role_id int,
    role_name varchar(45),
    primary key (role_id)
);

create table customer (
	id int,
    customer_type_id int,
    name varchar(45),
    date_of_birth date,
    gender bit(1),
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    primary key (id),
    foreign key (customer_type_id) references `customer_type`(id)  ON DELETE CASCADE
);

create table customer_type (
	id int,
    name varchar(45),
    primary key (id)
);

create table user_role (
	role_id int,
    username varchar(255),
    primary key (role_id,username),
    foreign key (role_id) references `role`(role_id)  ON DELETE CASCADE,
    foreign key (username) references `user`(username)  ON DELETE CASCADE
);

create table user (
	username varchar(255),
    password varchar(255),
    primary key (username)
);

create table facility (
	id int,
    name varchar(45),
    area int,
    cost double,
    max_people int,
    rent_type_id int,
    facility_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    facility_free text,
    primary key (id),
    foreign key (rent_type_id) references `rent_type`(id)  ON DELETE CASCADE,
    foreign key (facility_type_id) references `facility_type`(id)  ON DELETE CASCADE
);

create table rent_type (
	id int,
    name varchar(45),
    primary key (id)
);

create table facility_type (
	id int,
    name varchar(45),
    primary key (id)
);

create table attach_facility (
	id int,
    name varchar(45),
    cost double,
    unit varchar(10),
    status varchar(45),
    primary key (id)
);

create table contract_detail (
	id int,
    contract_id int,
    attach_facility_id int,
    quantity int,
    primary key (id),
    foreign key (contract_id) references `contract`(id)  ON DELETE CASCADE,
    foreign key (attach_facility_id) references `attach_facility`(id)  ON DELETE CASCADE
);

create table contract (
	id int,
    start_date datetime,
    end_date datetime,
    deposit double,
    employee_id int,
    customer_id int,
    facility_id int,
    primary key (id),
    foreign key (employee_id) references `employee`(id)  ON DELETE CASCADE,
    foreign key (customer_id) references `customer`(id)  ON DELETE CASCADE,
    foreign key (facility_id) references `facility`(id)  ON DELETE CASCADE
);

drop database furamapro;
