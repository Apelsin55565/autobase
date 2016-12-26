package by.bsu.kvach.autobase.dao.impl;

import by.bsu.kvach.autobase.dao.ConnectionPool;
import by.bsu.kvach.autobase.dao.interf.IAutoDAO;
import by.bsu.kvach.autobase.db.Fields;
import by.bsu.kvach.autobase.model.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by timme on 12.12.2016.
 */
public class AutoDAO implements IAutoDAO {


    private final String ALL_AUTO = "SELECT * FROM `autobase_apelsin`.`auto`;";
    private  final String REMOVE_AUTO = "DELETE FROM `autobase_apelsin`.`auto` WHERE `autobase_apelsin`.`auto`.`idAuto` = ?;";

    private  final String CREATE_NEW_AUTO = "INSERT INTO `autobase_apelsin`.`auto` (`mark`, `model`, `quantity_auto`, `users_idUsers`) VALUES (?, ?, ?, ?);";

    private final String FIND_ID_AUTO_BY_DRIVER_ID = "SELECT * FROM `autobase_apelsin`.`auto` where `users_idUsers` = ?;";


    private  final  String UPDATE_STATUS_AUTO =  "UPDATE autobase_apelsin.auto SET isOk = ? WHERE idAuto = ?;";

    //public static final String SELECT_BY_ID = "SELECT * from autobase_apelsin.auto where users_idUsers = ?";

    private ConnectionPool pool = ConnectionPool.getInstance();


    public List<Auto> getAllAuto(){

        List<Auto> autos = new ArrayList<>();
        Connection connection = null;

        try {
            connection = pool.getConnection();

            PreparedStatement statement = connection.prepareStatement(ALL_AUTO);
            ResultSet resultSet = statement.executeQuery(ALL_AUTO);

        while (resultSet.next()) {
            Auto auto = extractAuto(resultSet);
                        autos.add(auto);
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return autos;
    }

    private Auto extractAuto(ResultSet rs) throws SQLException {
        Auto auto = new Auto();
        auto.setIdAuto(rs.getInt(Fields.AUTO_ID_AUTO));
        auto.setMark(rs.getString(Fields.AUTO_MARK));
        auto.setModel(rs.getString(Fields.AUTO_MODEL));
        auto.setOk(rs.getBoolean(Fields.AUTO_ISOK));
        auto.setQuantity_auto(rs.getInt(Fields.AUTO_QUANTITY));
        auto.setIdUsers(rs.getInt(Fields.AUTO_IDUSER));
        return auto;
    }



    public void removeAuto(int id){

        Connection connection = null;
        try {

            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_AUTO);
            preparedStatement.setInt(1,id);
            int count = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }

    }

    @Override
    public boolean createNewAuto(String mark, String model, int quantity, int driver_id){

        Auto auto = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = pool.getConnection();

            preparedStatement = connection.prepareStatement(CREATE_NEW_AUTO);
            preparedStatement.setString(1, mark);
            preparedStatement.setString(2,model);
            preparedStatement.setInt(3,quantity);
            preparedStatement.setInt(4,driver_id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return false;
    }

    public Auto findAutoByIdDriver(int driver_id){
        Auto auto = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            // Запрос на получение соединения
            connection = pool.getConnection();

            preparedStatement = connection.prepareStatement(FIND_ID_AUTO_BY_DRIVER_ID);
            preparedStatement.setInt(1, driver_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Если не найдено пользователей - вернуть 0
            if (!resultSet.next()) {
                return null;
            }
            auto = new Auto();
            auto.setIdAuto(resultSet.getInt("idAuto"));
            auto.setMark(resultSet.getString("mark"));
            auto.setModel(resultSet.getString("model"));
            auto.setOk(resultSet.getBoolean("isOk"));
            auto.setQuantity_auto(resultSet.getInt("quantity_auto"));
            auto.setIdUsers(resultSet.getInt("idUsers"));
            return auto;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return auto;
    }


    public void UpdateStatusAuto(int id_auto, int status){

        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_AUTO);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id_auto);
            int count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
    }


    @Override
    public Auto selectById(int driverId) throws SQLException {
        return null;
    }
}
