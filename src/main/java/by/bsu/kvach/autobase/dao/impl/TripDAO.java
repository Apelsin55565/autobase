package by.bsu.kvach.autobase.dao.impl;

import by.bsu.kvach.autobase.dao.ConnectionPool;
import by.bsu.kvach.autobase.dao.interf.ITripDAO;
import by.bsu.kvach.autobase.db.Fields;
import by.bsu.kvach.autobase.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timme on 15.12.2016.
 */
public class TripDAO implements ITripDAO{

    private static final String FIND_TRIP_BY_ID_DRIVER = "SELECT * FROM trip WHERE idDriver_Users = ?;";
    private static final String FIND_ALL_TRIP = "SELECT * FROM trip;";
    private static final String REMOVE_TRIP = "DELETE FROM trip WHERE idTrip = ?;";
    private static final String CREATE_NEW_TRIP = "INSERT INTO `autobase_apelsin`.`trip`(`date`, `idDriver_Users`, `quantity_trip`, `departure_from`, `destination_to`) VALUES (?,?,?,?,?);";
    private static final String FIND_ID_TRIP_BY_DRIVER_ID = "SELECT * FROM `autobase_apelsin`.`trip` where `idDriver_Users` = ?;";

    private static final String UPDATE_STATUS_TRIP = "UPDATE trip SET status_idstatus = ? WHERE idTrip = ?;";

    private ConnectionPool pool = ConnectionPool.getInstance();

    public List<Trip> getAllTrip(){

        List<Trip> trips = new ArrayList<>();
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TRIP);
            ResultSet resultSet = preparedStatement.executeQuery(FIND_ALL_TRIP);
            while (resultSet.next()){
                Trip trip = extractTrip(resultSet);
                trips.add(trip);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return trips;
    }


    public Trip getTripById(int id_user) {
        Trip trips = null;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_TRIP_BY_ID_DRIVER);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return trips;
            }

            trips = extractTrip(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return trips;
    }


    public void removeTrip(int id){
            Connection connection = null;
        try {

            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_TRIP);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
        }catch (SQLException e) {
        e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
    }

    public void UpdateStatusTrip(int id, int status){
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_TRIP);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);
            int count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
    }



    private Trip extractTrip(ResultSet resultSet) throws SQLException{
        Trip trip = new Trip();
        trip.setIdTrip(resultSet.getInt(Fields.TRIP_ID_TRIP));
        trip.setDate(resultSet.getDate(Fields.TRIP_DATE));
        trip.setIdDriver_Users(resultSet.getInt(Fields.TRIP_IDDRIVER_USERS));
        trip.setDeparture_from(resultSet.getString(Fields.TRIP_FROM));
        trip.setDestination_to(resultSet.getString(Fields.TRIP_TO));
        trip.setQuantity_trip(resultSet.getInt(Fields.TRIP_QUANTITY));
        trip.setIdStatus(resultSet.getInt(Fields.TRIP_STATUS_IDSTATUS));
        return trip;
    }


    public boolean createNewTrip(String date, int quantity, String from, String to, int id_driver){
     Trip trip = null;
     Connection connection = null;
     PreparedStatement preparedStatement = null;


        try {
        connection = pool.getConnection();

        preparedStatement = connection.prepareStatement(CREATE_NEW_TRIP);
        preparedStatement.setString(1, date);
        preparedStatement.setInt(2,id_driver);
        preparedStatement.setInt(3, quantity);
        preparedStatement.setString(4, from);
        preparedStatement.setString(5,to);
        preparedStatement.executeUpdate();
        return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return false;
        }

    public int findIdTripByDriver(int id_driver) {

        Trip trip = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            // Запрос на получение соединения
            connection = pool.getConnection();

            preparedStatement = connection.prepareStatement(FIND_ID_TRIP_BY_DRIVER_ID);
            preparedStatement.setInt(1, id_driver);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return 0;
            }
            trip = new Trip();
            trip.setIdTrip(resultSet.getInt("idTrip"));
            trip.setIdDriver_Users(resultSet.getInt("idDriver_Users"));
            trip.setQuantity_trip(resultSet.getInt("quantity_trip"));
            trip.setDeparture_from(resultSet.getString("departure_from"));
            trip.setDestination_to(resultSet.getString("destination_to"));
            trip.setIdStatus(resultSet.getInt("idStatus"));
            return trip.getIdTrip();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return trip.getIdTrip();
    }
}
