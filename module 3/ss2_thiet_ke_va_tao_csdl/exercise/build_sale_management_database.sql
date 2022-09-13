create database QuanLyBanHang;
use QuanLyBanHang;

create table customer (
	cID int primary key,
    cName varchar(45),
    cAge int
);

create table `order` (
	oID int primary key,
    cID int,
    oDate date,
    oTotalPrice double,
    foreign key (cID) references customer(cID)
);

create table order_detail (
	oID int,
    pID int,
    odQTY int,
    primary key (oID, pID),
    foreign key (oID) references `order`(oID),
    foreign key (pID) references product(pID)
);

create table product (
	pID int primary key,
    pName varchar(45),
    pPrice double
);