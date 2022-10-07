package model.repository.impl;

import model.model.facility.Facility;
import model.repository.BaseRepository;
import model.repository.IFacilityRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {

    @Override
    public List<Facility> getFacilityList() {
        List<Facility> facilityList = new ArrayList<Facility>();

        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall("{call getFacilityList()}");

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int facilityTypeId = rs.getInt("facility_type_id");
                String standardRoom = rs.getString("standard_room");
                String desriptionOtherConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                String facilityFree = rs.getString("facility_free");

                facilityList.add(new Facility(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId,
                        standardRoom, desriptionOtherConvenience, poolArea,
                        numberOfFloors, facilityFree));
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public boolean addNewFacility(Facility newFacility) {
        boolean check = false;
        Connection connection = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = connection.prepareCall("{call addNewFacility(?,?,?,?,?,?,?,?,?,?,?,?)}");

            cs.setInt(1, newFacility.getId());
            cs.setString(2, newFacility.getName());
            cs.setInt(3, newFacility.getArea());
            cs.setDouble(4, newFacility.getCost());
            cs.setInt(5, newFacility.getMaxPeople());
            cs.setInt(6, newFacility.getRentTypeId());
            cs.setInt(7, newFacility.getFacilityTypeId());
            cs.setString(8, newFacility.getStandardRoom());
            cs.setString(9, newFacility.getDesriptionOtherConvenience());
            cs.setDouble(10, newFacility.getPoolArea());
            cs.setString(11, newFacility.getFacilityFree());

            cs.executeUpdate();

            check = true;
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return check;
    }
}
