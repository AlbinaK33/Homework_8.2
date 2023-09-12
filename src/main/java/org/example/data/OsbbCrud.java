package org.example.data;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import java.util.LinkedList;
import java.util.List;

import static org.example.data.OsbbConnection.*;

public class OsbbCrud {

    private static final Logger logger = Logger.getLogger(OsbbCrud.class);
    private static final String SQL_QUERY = "SELECT osbb_example.resident.id, osbb_example.building.adress_building, osbb_example.flat.number_flat, osbb_example.flat.square, \n" +
            "osbb_example.resident.resident_data, osbb_example.resident.contact_data\n" +
            "FROM osbb_example.resident \n" +
            "INNER JOIN osbb_example.flat ON osbb_example.resident.flat_id = osbb_example.flat.id \n" +
            "INNER JOIN osbb_example.building ON osbb_example.flat.building_id = osbb_example.building.id \n" +
            "INNER JOIN osbb_example.charter ON osbb_example.charter.resident_id = osbb_example.resident.id \n" +
            "WHERE osbb_example.resident.residence = ?\n" +
            "AND osbb_example.charter.autopark = ?\n" +
            "AND osbb_example.charter.ownership = ?\n" +
            "ORDER BY osbb_example.resident.id ASC;";

    private static final File file = new File("osbb.txt");

    public void getResultConnection() {
        try ( OsbbConnection osbbConnection = new OsbbConnection().jdbcConnection();
              FileWriter writer = new FileWriter(file)) {
            OsbbCrud osbbCrud = new OsbbCrud();

            for (OsbbMembers osbbMembers : osbbCrud.getMembersQuery("1", "0", 1)) {
                String line = osbbMembers.toString();
                if (line != null) {
                    writer.write(line);
                    writer.flush();
                }
                System.out.println(line);
            }
        } catch (SQLException | IOException e) {
            logger.fatal(e);
        }
    }

    private List<OsbbMembers> getMembersQuery(String residence, String autopark, int ownership) {
        logger.trace("Call getting members by query");

        final List<OsbbMembers> result = new LinkedList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, residence);
            preparedStatement.setString(2, autopark);
            preparedStatement.setInt(3, ownership);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new OsbbMembers()
                                .setId(resultSet.getInt("id"))
                                .setAdress(resultSet.getString("adress_building"))
                                .setNumberFlat(resultSet.getShort("number_flat"))
                                .setSquare(resultSet.getFloat("square"))
                                .setName(resultSet.getString("resident_data"))
                                .setContact(resultSet.getString("contact_data"))
                );
            }
        } catch (SQLException e) {
            logger.fatal(e);
        }
        return result;
    }
}
