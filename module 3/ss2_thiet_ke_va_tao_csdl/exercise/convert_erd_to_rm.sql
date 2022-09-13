CREATE DATABASE learn_2;
USE learn_2;
create table phieu_nhap (
	so_pn int primary key,
    ngay_nhap date
);

create table nha_cc (
	ma_ncc int primary key,
    ten_ncc varchar(45),
    dia_chi varchar(45),
    sdt int
);

create table phieu_xuat (
	so_px int primary key,
    ngay_xuat date
);

create table chi_tiet_phieu_xuat (
	so_px int,
    ma_vtu int,
    dg_xuat double,
    sl_xuat int,
    primary key (so_px, ma_vtu),
    foreign key (so_px) references phieu_xuat(so_px),
    foreign key (ma_vtu) references vat_tu(ma_vtu) 
);

create table vat_tu (
	ma_vtu int primary key,
    ten_vtu varchar(45)
);

create table chi_tiet_phieu_nhap (
	ma_vtu int,
    so_pn int,
    dg_nhap double,
    sl_nhap int,
    primary key (ma_vtu, so_pn),
    foreign key (ma_vtu) references vat_tu(ma_vtu),
    foreign key (so_pn) references phieu_nhap(so_pn)
);

create table chi_tiet_don_dat_hang (
	so_dh int,
    ma_vtu int,
    primary key (so_dh, ma_vtu),
    foreign key (so_dh) references don_dh(so_dh),
    foreign key (ma_vtu) references vat_tu(ma_vtu)
);

create table don_dh (
	so_dh int primary key,
    ngay_dh date
);

alter table don_dh
add foreign key (ma_ncc) references nha_cc(ma_ncc);

alter table don_dh 
add ma_ncc int;

create table sdt (
	sdt int primary key
);

alter table nha_cc
add foreign key (sdt) references sdt(sdt);