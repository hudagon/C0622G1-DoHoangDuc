-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select `order`.oID, `order`.oDate, product.pPrice
from `order_detail` join `order` on `order_detail`.oID = `order`.oID
					join product on `order_detail`.pID = product.pID;
                    
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách                   
select customer.`name`
from customer left join `order` on customer.cID = `order`.cID
where `order`.cID is null;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select `order`.oID , `order`.oDate , sum(product.pPrice * order_detail.odQTY) as total_price 
from `order` join order_detail on `order`.oID = order_detail.oID
			 join product on product.pID = order_detail.pID 
group by `order`.oID;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán 
-- của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select customer.`name`, product.pName as product
from customer join `order` on customer.cID = `order`.cID
			  join `order_detail` on `order`.oID = `order_detail`.oID
              join product on product.pID = `order_detail`.pID;