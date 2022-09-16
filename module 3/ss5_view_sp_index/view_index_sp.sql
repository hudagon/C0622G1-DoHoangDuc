-- Bước 1:
create database demo;
use demo;

-- Bước 2:
create table products(
	id int primary key,
    product_code varchar(45),
    product_name varchar(45),
    product_price double,
    product_amount int,
    product_description text,
    produc_status bit
);

insert into `demo`.`products` (`id`, `product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `produc_status`) 
values ('1', 'ABC001', 'Fan', '15000', '2', 'None', b'1'),
	   ('2', 'JKL002', 'Car', '20000', '3', 'None', b'1'),
	   ('3', 'EFG', 'Ship', '100000', '1', 'None', b'1');
       
-- Bước 3:
create unique index i_product_code on products(product_code);

create unique index i_product_name_price on products(product_name, product_price);

explain select products.id, products.product_code, products.product_name 
from products
where products.product_code = 'ABC001';

-- Bước 4:
create view product_code_view as 
select products.product_code
from products;

create view product_name_view as 
select products.product_name
from products;

create view product_price_view as 
select products.product_price
from products;

create view product_status_view as 
select products.produc_status
from products;

create or replace view product_status_view as
select products.produc_status, products.id
from products;

drop view product_price_view;

-- Bước 5 

-- Lấy thông tin sản phẩm
delimiter // 
create procedure get_all_product ()
begin
	select *
    from product;
end//
delimiter ;

-- Thêm mới sản phẩm
delimiter // 
create procedure add_new_product (
	in id int,
	in product_code varchar(45),
    in product_name varchar(45),
    in product_price double,
    in product_amount int,
    in product_description text,
    in product_status bit
)
begin
	insert into products
    values (id,product_code,product_name,product_price,product_amount,product_description,product_status);
end//
delimiter ;

-- Sửa thông tin sản phẩm
delimiter // 
create procedure edit_product (
	in id int,
	in product_code varchar(45),
    in product_name varchar(45),
    in product_price double,
    in product_amount int,
    in product_description text,
    in product_status bit
)
begin
	update products set products.product_code = product_code,
						products.product_name = product_name,
                        products.product_price = product_price,
                        products.product_amount = product_amount,
                        products.product_description = product_description,
                        products.produc_status = product_status
    where (products.id = id);
end//
delimiter ;

-- Xóa sản phẩm
delimiter //
create procedure delete_product (in id int)
begin 
	delete from products where (products.id = id);
end//
delimiter ;

call demo.get_all_product();
call demo.delete_product(1);
call demo.edit_product(2,'alo123','alo321',333,2,'none',b'1');
call demo.add_new_product(1,'abc001','house',1000000,1,'none',b'1');
