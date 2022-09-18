-- Task 17:	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

-- Tạo View những khách hàng đã đặt phòng với tổng tiền trong năm 2021
create view tong_tien_khach_hang_nam_2021 as
select 
	khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    extract(year from hop_dong.ngay_lam_hop_dong) as `nam_tinh_toan`,
    (ifnull(dich_vu.chi_phi_thue,0) + ifnull(hop_dong_chi_tiet.so_luong,0) * ifnull(dich_vu_di_kem.gia,0)) as `tong_tien`
from 
	khach_hang 		join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
			   left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
               left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
               left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where extract(year from hop_dong.ngay_lam_hop_dong) = 2021
group by khach_hang.ma_khach_hang, hop_dong.ma_hop_dong;

-- Tiến hành update
update khach_hang join tong_tien_khach_hang_nam_2021 on khach_hang.ma_khach_hang = tong_tien_khach_hang_nam_2021.ma_khach_hang 
	   set khach_hang.ma_loai_khach = '1' where khach_hang.ma_loai_khach = '2'
										  and tong_tien_khach_hang_nam_2021.tong_tien > 10000000;

-- Task 18: Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

-- Tạo thêm cột trạng thái cho bảng khách hàng
alter table furama.khach_hang 
add column `trang_thai` bit default 1 AFTER `dia_chi`;

-- Tiến hành thay đổi trạng thái
update khach_hang left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
	   set khach_hang.trang_thai = b'0' where extract(year from hop_dong.ngay_lam_hop_dong) < 2021
										and extract(year from hop_dong.ngay_ket_thuc) < 2021;
									

       
       



  



