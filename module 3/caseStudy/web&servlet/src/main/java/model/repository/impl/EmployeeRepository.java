package model.repository.impl;

import model.model.human.employee.Employee;
import model.repository.BaseRepository;
import model.repository.IEmployeeRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall("{call getEmployeeList()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");
                String address = rs.getString("address");
                int educationDegreeId = rs.getInt("education_degree_id");
                int positionId = rs.getInt("position_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");

                employeeList.add(new Employee(id, name, dateOfBirth, idCard,
                        phoneNumber, email, salary, address, educationDegreeId, positionId, divisionId, username));
            }


        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


        return employeeList;
    }
}
