package model.repository.impl;

import model.model.PayMethod;
import model.model.Tent;
import model.repository.BaseRepository;
import model.repository.ITentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TentRepository implements ITentRepository {
    private static final String SELECT_ALL_TENT = "SELECT * FROM thi_thu_1.tent";
    private static final String INSERT_NEW_TENT = "INSERT INTO `thi_thu_1`.`tent` " +
            "(`tenant_name`, `phone_number`, `start_date`, `pay_method_id`, `description`) \n" +
            "VALUES (?,?,?,?,?);";
    private static final String DELETE_TENT = "DELETE FROM `thi_thu_1`.`tent` WHERE (`id` =?);";
    private static final String SEARCH_TENT = "select * from tent\n" +
            "where \n" +
            "\tid like ? and\n" +
            "\ttenant_name like ? and\n" +
            "    phone_number like ?;";
    private static final String SELECT_ALL_PAY_METHOD = "select * from pay_method;";

    @Override
    public List<Tent> getListTent() {
        List<Tent> listTent = new ArrayList<>();

        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_TENT);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idTent = rs.getInt("id");
                String tenantName = rs.getString("tenant_name");
                String phoneNumber = rs.getString("phone_number");
                String startDate = rs.getString("start_date");
                int payMethodId = Integer.parseInt(rs.getString("pay_method_id"));
                String description = rs.getString("description");

                listTent.add(new Tent(idTent, tenantName, phoneNumber, startDate, payMethodId, description));
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return listTent;
    }

    @Override
    public boolean addNewTent(Tent newTent) {
        Connection connection = BaseRepository.getConnectDB();
        boolean check = false;

        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_TENT);

            ps.setString(1, newTent.getTenantName());
            ps.setString(2, newTent.getPhoneNumber());
            ps.setString(3, newTent.getStartDate());
            ps.setInt(4, newTent.getPayMethodId());
            ps.setString(5, newTent.getDescription());

            ps.executeUpdate();

            check = true;

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean deleteTent(int idDelete) {
        Connection connection = BaseRepository.getConnectDB();
        boolean check = false;

        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_TENT);

            ps.setInt(1,idDelete);

            ps.executeUpdate();

            check = true;

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return check;
    }

    @Override
    public List<Tent> search(String tentIdSearch, String tenantNameSearch, String phoneNumberSearch) {
        Connection connection = BaseRepository.getConnectDB();
        List<Tent> foundTent = new ArrayList<>();


        try {
            PreparedStatement ps = connection.prepareStatement(SEARCH_TENT);

            ps.setString(1, "%"+tentIdSearch+"%");
            ps.setString(2, "%"+tenantNameSearch+"%");
            ps.setString(3, "%"+phoneNumberSearch+"%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idTent = rs.getInt("id");
                String tenantName = rs.getString("tenant_name");
                String phoneNumber = rs.getString("phone_number");
                String startDate = rs.getString("start_date");
                int payMethodId = Integer.parseInt(rs.getString("pay_method_id"));
                String description = rs.getString("description");

                foundTent.add(new Tent(idTent, tenantName, phoneNumber, startDate, payMethodId, description));
            }

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


       return foundTent;
    }

    @Override
    public List<PayMethod> getListPayMethod() {
        List<PayMethod> listPayMethod = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PAY_METHOD);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name_pay_method");

                listPayMethod.add(new PayMethod(id, name));
            }

        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

        return listPayMethod;
    }
}
