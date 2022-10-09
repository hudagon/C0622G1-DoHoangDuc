package model.repository.impl;

import model.customerDto.CustomerDto;
import model.customerDto.CustomerDtoAttachService;
import model.model.human.customer.Customer;
import model.repository.BaseRepository;
import model.repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
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
            cs.setInt(1, newCustomer.getId());
            cs.setInt(2, newCustomer.getCustomerTypeId());
            cs.setString(3, newCustomer.getName());
            cs.setString(4, newCustomer.getDateOfBirth());
            cs.setBoolean(5, newCustomer.isGender());
            cs.setString(6, newCustomer.getIdCard());
            cs.setString(7, newCustomer.getPhoneNumber());
            cs.setString(8, newCustomer.getEmail());
            cs.setString(9, newCustomer.getAddress());

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
        boolean check = false;
        Connection connection = BaseRepository.getConnectDB();

        int gender = 0;
        if (editCustomer.isGender()) {
            gender = 1;
        }

        try {
            CallableStatement cs = connection.prepareCall("{call editCustomer(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, String.valueOf(editCustomer.getId()));
            cs.setString(2, String.valueOf(editCustomer.getCustomerTypeId()));
            cs.setString(3, editCustomer.getName());
            cs.setString(4, editCustomer.getDateOfBirth());
            cs.setInt(5, gender);
            cs.setString(6, editCustomer.getIdCard());
            cs.setString(7, editCustomer.getPhoneNumber());
            cs.setString(8, editCustomer.getEmail());
            cs.setString(9, editCustomer.getAddress());

            cs.executeUpdate();

            check = true;
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return check;
    }

    @Override
    public List<CustomerDto> getListCustomerWhoAreUsingService() {
        List<CustomerDto> listCustomerWhoHasUsedService = new ArrayList<>();
        String getListCustomerWhoHasUsedServiceSql = "select \n" +
                "\tcustomer.*,\n" +
                "    facility.name\n" +
                "from \n" +
                "\tcustomer join contract on customer.id = contract.customer_id\n" +
                "\t\t\t left join contract_detail on contract.id = contract_detail.contract_id\n" +
                "             left join attach_facility on attach_facility.id = contract_detail.attach_facility_id\n" +
                "             left join facility on facility.id = contract.facility_id\n" +
                "where end_date > now()\n" +
                "group by customer.id;";

        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(getListCustomerWhoHasUsedServiceSql);

            ResultSet rs = ps.executeQuery();

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
                String serviceName = rs.getString("facility.name");

                listCustomerWhoHasUsedService.add(new CustomerDto(id, name, dateOfBirth, gender,
                        idCard, phoneNumber, email, customerTypeId, address, serviceName));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCustomerWhoHasUsedService;
    }

    @Override
    public List<CustomerDto> searchCustomerWAUSByName(String name) {
        List<CustomerDto> listCustomerWhoAreUsingService = getListCustomerWhoAreUsingService();
        List<CustomerDto> listCustomerWAUSFounded = new ArrayList<>();

        for (CustomerDto x : listCustomerWhoAreUsingService) {
            if (x.getName().contains(name)) {
                listCustomerWAUSFounded.add(x);
            }
        }

        return listCustomerWAUSFounded;
    }

    @Override
    public List<CustomerDtoAttachService> getlistAttachService() {
        List<CustomerDtoAttachService> listAttachService = new ArrayList<>();

        String getListAttachServiceSql = "select \n" +
                "\tcustomer.id as `customer_id`,\n" +
                "    contract.id as `contract_id`,\n" +
                "    attach_facility.name\n" +
                "from customer join contract on contract.customer_id = customer.id\n" +
                "\t\t\t  join contract_detail on contract.id = contract_detail.contract_id\n" +
                "\t\t\t  join attach_facility on contract_detail.attach_facility_id = attach_facility.id\n" +
                "where end_date > now();";

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(getListAttachServiceSql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                int contractId = rs.getInt("contract_id");
                String attachServiceName = rs.getString("name");

                listAttachService.add(new CustomerDtoAttachService(customerId, contractId, attachServiceName));

            }


        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return listAttachService;
    }
}
