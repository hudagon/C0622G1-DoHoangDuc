-- Task 16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
create view nhan_vien_that_bai as
select nhan_vien.ma_nhan_vien 
from nhan_vien
where nhan_vien.ma_nhan_vien not in (select hop_dong.ma_nhan_vien 
									 from hop_dong
                                     where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'
                                     group by hop_dong.ma_nhan_vien);
													
delete nhan_vien from nhan_vien join nhan_vien_that_bai on nhan_vien.ma_nhan_vien = nhan_vien_that_bai.ma_nhan_vien;

-- Task 17:	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

-- Tạo View những khách hàng đã đặt phòng với tổng tiền trong năm 2021
create view tong_tien_khach_hang_nam_2021 as
select 
	khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    year(hop_dong.ngay_lam_hop_dong) as `nam_tinh_toan`,
    sum((ifnull(dich_vu.chi_phi_thue,0) + ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia,0))) as `tong_tien`
from 
	khach_hang 		join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
			   left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
               left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
               left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2021
group by khach_hang.ma_khach_hang;

-- Tiến hành update
update khach_hang join tong_tien_khach_hang_nam_2021 on khach_hang.ma_khach_hang = tong_tien_khach_hang_nam_2021.ma_khach_hang 
	   set khach_hang.ma_loai_khach = '1' where khach_hang.ma_loai_khach = '2'
										  and tong_tien_khach_hang_nam_2021.tong_tien > 10000000;

-- Task 18: Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

-- Tạo thêm cột trạng thái cho bảng khách hàng
alter table furama.khach_hang 
add column `trang_thai` bit default 1 after `dia_chi`;

-- Tiến hành thay đổi trạng thái
update khach_hang left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
	   set khach_hang.trang_thai = b'0' where extract(year from hop_dong.ngay_lam_hop_dong) < 2021
										and extract(year from hop_dong.ngay_ket_thuc) < 2021;
									
-- Task 19: Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.

-- Tạo view các dịch vụ đi kèm được sử dụng năm 2020
create view so_luong_dvdk_2020 as
select 
	dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.gia,
    extract(year from hop_dong.ngay_lam_hop_dong) as `nam_su_dung`,
    sum(hop_dong_chi_tiet.so_luong) as 'tong_so_lan_duoc_su_dung'
from dich_vu_di_kem join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
					join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
                    join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
group by hop_dong_chi_tiet.ma_dich_vu_di_kem;

-- Tiến hành update
update dich_vu_di_kem join so_luong_dvdk_2020 on dich_vu_di_kem.ma_dich_vu_di_kem = so_luong_dvdk_2020.ma_dich_vu_di_kem
set dich_vu_di_kem.gia = (dich_vu_di_kem.gia * 2) where so_luong_dvdk_2020.tong_so_lan_duoc_su_dung > 10
												  and so_luong_dvdk_2020.nam_su_dung = 2020;
                                                  
-- Task 20: Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

select 
	nhan_vien.ma_nhan_vien as `id`,
    nhan_vien.ho_ten,
    nhan_vien.email,
    nhan_vien.so_dien_thoai,
    nhan_vien.ngay_sinh,
    nhan_vien.dia_chi
from nhan_vien
union all
select 
	khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    khach_hang.email,
    khach_hang.so_dien_thoai,
    khach_hang.ngay_sinh,
    khach_hang.dia_chi
from khach_hang;


	