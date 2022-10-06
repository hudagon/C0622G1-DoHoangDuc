package model.repository.impl;

import model.model.human.customer.Customer;
import model.repository.BaseRepository;
import model.repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall("{call getCustomerList()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = String.valueOf(rs.getDate("date_of_birth"));
                boolean gender = rs.getBoolean("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                int customerTypeId = rs.getInt("customer_type_id");
                String address = rs.getString("address");

                customerList.add(new Customer(id, name, dateOfBirth, gender,
                        idCard, phoneNumber, email, customerTypeId, address));
            }


        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


        return customerList;
    }

    @Override
    public boolean addCustomer(Customer newCustomer) {
        boolean check = false;

        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall("{call addNewCustomer(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,newCustomer.getId());
            cs.setInt(2,newCustomer.getCustomerTypeId());
            cs.setString(3,newCustomer.getName());
            cs.setString(4, newCustomer.getDateOfBirth());
            cs.setBoolean(5,newCustomer.isGender());
            cs.setString(6,newCustomer.getIdCard());
            cs.setString(7,newCustomer.getPhoneNumber());
            cs.setString(8,newCustomer.getEmail());
            cs.setString(9,newCustomer.getAddress());

            cs.executeUpdate();

            check = true;
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return check;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = getCustomerList();
        List<Customer> foundedCustomerList = new ArrayList<Customer>();

        for (Customer x : customerList) {
            if (x.getName().contains(name)) {
                foundedCustomerList.add(x);
            }
        }

        return foundedCustomerList;
    }

    @Override
    public boolean deleteCustomer(String idDelete) {
        Connection connection = BaseRepository.getConnectDB();
        boolean check = false;


        try {
            CallableStatement cs = connection.prepareCall("{call deleteCustomer(?)}");

            cs.setString(1, idDelete);

            cs.executeUpdate();

            check = true;
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean editCustomer(Customer editCustomer) {
        String UPDATE = "update employee set employee_name = ?, employee_birthday = ?, " +
                "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, " +
                "employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? where employee_id = ? and " +
                "is_delete = 0;";
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement cs = connection.prepareStatement(UPDATE);
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


    }
}
