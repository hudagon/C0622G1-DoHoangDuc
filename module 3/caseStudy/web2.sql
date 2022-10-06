delimiter //
create procedure getEmployeeList()
begin 

select * from employee;

end // 

delimiter ;

call getEmployeeList();

delimiter //
create procedure getCustomerList()
begin 

select * from customer;

end // 

delimiter ;

call getCustomerList();



delimiter //
create procedure addNewCustomer(
	in id int,
    in customer_type_id int,
    in name varchar(45),
    in date_of_birth date,
    in gender bit(1),
    in id_card varchar(45),
    in phone_number varchar(45),
    in email varchar(45),
    in address varchar(45)
)

begin
INSERT INTO `furamapro`.`customer` (`id`, `customer_type_id`, `name`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`) 
VALUES (id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address);

end //
delimiter ;

call addNewCustomer(11,1,'ok','2000-11-11',b'0','123123123','123123123','a@gmail.com','Vietnam');


delimiter //
create procedure deleteCustomer(
	in idDelete int
)

begin 
delete from `customer` where (`id` = idDelete);
end //

delimiter ;

call deleteCustomer(11);