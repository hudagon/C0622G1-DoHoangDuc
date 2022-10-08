package model.repository.impl;

import model.model.facility.Facility;
import model.repository.BaseRepository;
import model.repository.IFacilityRepository;

import java.sql.*;
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
        String addNewFacilitySql = "INSERT INTO `furamapro`.`facility` " +
                "(`id`, `name`, `area`, `cost`, `max_people`, `rent_type_id`, " +
                "`facility_type_id`, `standard_room`, `description_other_convenience`, " +
                "`pool_area`, `number_of_floors`, `facility_free`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        boolean check = false;
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(addNewFacilitySql);

            ps.setInt(1, newFacility.getId());
            ps.setString(2, newFacility.getName());
            ps.setInt(3, newFacility.getArea());
            ps.setDouble(4, newFacility.getCost());
            ps.setInt(5, newFacility.getMaxPeople());
            ps.setInt(6, newFacility.getRentTypeId());
            ps.setInt(7, newFacility.getFacilityTypeId());
            ps.setString(8, newFacility.getStandardRoom());
            ps.setString(9, newFacility.getDesriptionOtherConvenience());
            ps.setDouble(10, newFacility.getPoolArea());
            ps.setInt(11, newFacility.getNumberOfFloors());
            ps.setString(12, newFacility.getFacilityFree());

            ps.executeUpdate();

            check = true;
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Facility> searchByName(String searchName) {
        List<Facility> facilityList = getFacilityList();
        List<Facility> foundedFacilityList = new ArrayList<>();

        for (Facility x : facilityList) {
            if (x.getName().contains(searchName)) {
                foundedFacilityList.add(x);
            }
        }

        return foundedFacilityList;
    }

    @Override
    public boolean editFacility(Facility editFacility) {
        boolean check = false;
        String editFacilitySql = "UPDATE `furamapro`.`facility` SET `name` = ?, `area` = ?, `cost` = ?, " +
                "`max_people` = ?,`rent_type_id` = ?, `facility_type_id` = ?, `standard_room` = ?, " +
                "`description_other_convenience` = ?,`pool_area` = ?,`facility_free` = ?, " +
                "`number_of_floors` = ? WHERE (`id` = ?);";


        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(editFacilitySql);

            ps.setString(1, editFacility.getName());
            ps.setInt(2, editFacility.getArea());
            ps.setDouble(3, editFacility.getCost());
            ps.setInt(4, editFacility.getMaxPeople());
            ps.setInt(5, editFacility.getRentTypeId());
            ps.setInt(6, editFacility.getFacilityTypeId());
            ps.setString(7, editFacility.getStandardRoom());
            ps.setString(8, editFacility.getDesriptionOtherConvenience());
            ps.setDouble(9, editFacility.getPoolArea());
            ps.setString(10, editFacility.getFacilityFree());
            ps.setInt(11, editFacility.getNumberOfFloors());
            ps.setString(12, String.valueOf(editFacility.getId()));

            ps.executeUpdate();

            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return check;
    }

    @Override
    public boolean deleteFacility(int deleteId) {
        boolean check = false;
        String deleteFacilitySql = "DELETE FROM `furamapro`.`facility` WHERE (`id` = ?);";
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(deleteFacilitySql);

            ps.setInt(1, deleteId);

            ps.executeUpdate();

            check = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return check;
    }
}
