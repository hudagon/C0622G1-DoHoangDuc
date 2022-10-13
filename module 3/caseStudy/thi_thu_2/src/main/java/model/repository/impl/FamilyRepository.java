package model.repository.impl;

import model.model.Family;
import model.repository.BaseRepository;
import model.repository.IFamilyRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepository implements IFamilyRepository {
    public static final String SELECT_ALL_FAMILY = "SELECT * FROM thi_thu_2.family;";


    @Override
    public List<Family> getListFamily() {
        List<Family> familyList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_FAMILY);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String hostName = rs.getString("name_host");
                String initialDate = rs.getString("initialDate");
                String address = rs.getString("address");

                familyList.add(new Family(id,hostName, initialDate, address));
            }


        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }


        return familyList;
    }
}
