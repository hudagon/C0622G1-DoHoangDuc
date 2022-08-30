package service;

import model.creature.Employee;

public interface IEmployeeService extends IService {
    void hienThiMaNhanVien();

    Employee layThongTinNhanVien();
}
