-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * 
from `subject`
where `subject`.credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subject.SubID, subject.SubName, subject.Credit, subject.Status
from `subject` join mark on `subject`.SubId = mark.SubId
where mark.mark =  (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark) as 'Điểm trung bình'
from student left join mark on student.StudentID = mark.StudentId
group by (student.StudentId)
order by mark.mark desc;