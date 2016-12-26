package by.bsu.kvach.autobase.dao.impl;

import by.bsu.kvach.autobase.dao.ConnectionPool;
import by.bsu.kvach.autobase.dao.DatabaseConnection;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.db.Fields;
import by.bsu.kvach.autobase.model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timme on 13.12.2016.
 */
public class UsersDAO implements IUsersDAO {

    private static final String REGISTER_NEW_USER = "INSERT INTO `autobase_apelsin`.`users` (`username`, `password`, `name`, `surname`) VALUES (?, ?, ?, ?);";

    private static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM `autobase_apelsin`.`users`" + " WHERE`autobase_apelsin`.`users`.`username` = ?" + " AND `autobase_apelsin`.`users`.`password` = ?;";

    private  static  final String FIND_USER_BY_ID = "SELECT * FROM users WHERE idUsers = ?;";

    private static final String ALL_USERS = "SELECT * FROM `autobase_apelsin`.`users`;";

    private static final String REMOVE_USER = "DELETE FROM users WHERE idUsers = ?;";

    private static final String DRIVERS_WHITHOUT_AUTO = "SELECT * FROM users WHERE auto_idauto = 0;";

    private static final String DRIVERS_WHITHOUT_TRIP = "SELECT * FROM users WHERE trip_idtrip = 0 AND auto_idauto != 0;";

    private static final String UPDATE_ID_AUTO = "update users set auto_idauto = ? where idUsers = ?;";

    private static final String UPDATE_ID_TRIP = "update users set trip_idtrip = ? where idUsers = ?;";


    private static final String REMOVE_ID_AUTO = "update users set auto_idauto = 0 where auto_idauto = ?;";

    private static final String REMOVE_ID_TRIP = "update users set trip_idtrip = 0 where trip_idtrip = ?;";


    private ConnectionPool pool = ConnectionPool.getInstance();


    @Override
    public Users checkLogin(String enterUsername, String enterPass) {

        Users user = null;

        // Подготовка ссылок на объекты
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            // Запрос на получение соединения
            connection = pool.getConnection();

            // Добавление в запрос параметров username и password
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, enterUsername);
            preparedStatement.setString(2, enterPass);


            ResultSet resultSet = preparedStatement.executeQuery();

            // Если не найдено пользователей - вернуть null
            if (!resultSet.next()) {
                return user;
            }
            user = new Users();
            user.setIdUsers(resultSet.getInt("idUsers"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setRole(resultSet.getInt("Role_idRole"));

            //Еще что-нибудь создать
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(connection);
        }
        return user;
    }


    @Override
    public boolean registrateUser(String username, String password, String name, String surname) {


        Users user = null;

        // Подготовка ссылок на объекты
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            // Запрос на получение соединения
            connection = pool.getConnection();

            // Добавление в запрос параметров username и password
            connection = DatabaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(REGISTER_NEW_USER);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(connection);
        }
        return false;
    }




    @Override
    public List<Users> getAllUsers() {

        List<Users> users = new ArrayList<>();


        Connection connection = null;

        try {

            // Запрос на получение соединения
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery(ALL_USERS);
            while (rs.next()) {
                Users user = extractUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        pool.releaseConnection(connection);
    }
    return users;
    }

    @Override
    public List<Users> DriversWithoutAuto(){

        List<Users> users = new ArrayList<>();
        Connection connection = null;

        try {
            // Запрос на получение соединения
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVERS_WHITHOUT_AUTO);
            ResultSet rs = preparedStatement.executeQuery(DRIVERS_WHITHOUT_AUTO);
            while (rs.next()) {
                Users user = extractUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(connection);
        }
        return users;
    }

    @Override
    public  List<Users> DriversWithoutTrip(){
        List<Users> users = new ArrayList<>();
        Connection connection = null;
        try {
            // Запрос на получение соединения
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVERS_WHITHOUT_TRIP);
            ResultSet resultSet = preparedStatement.executeQuery(DRIVERS_WHITHOUT_TRIP);
            while (resultSet.next()) {
                Users user = extractUser(resultSet);
                users.add(user);
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return users;
        }




    public Users findUserById(int id_user){
        Users users = null;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return users;
            }
            users = extractUser(resultSet);
    } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        return users;
        }


    @Override
    public void removeUser(int id){

        Connection connection = null;
        try {

            // Запрос на получение соединения
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER);
            preparedStatement.setInt(1,id);
            int count = preparedStatement.executeUpdate();

        }
          catch(SQLException e){
                e.printStackTrace();
            }
                finally {
            pool.releaseConnection(connection);
        }

    }


    public void updateIdTrip(int idUsers, int idTrip){
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID_TRIP);
            preparedStatement.setInt(1, idTrip);
            preparedStatement.setInt(2, idUsers);
            int count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
        }



    public void removeIdTrip(int idTrip){
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ID_TRIP);
            preparedStatement.setInt(1, idTrip);
            int count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            pool.releaseConnection(connection);
        }
    }





    public void updateIdAuto(int idUsers, int idAuto){
        Connection connection = null;
        try {
            connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID_AUTO);
            preparedStatement.setInt(1, idAuto);
            preparedStatement.setInt(2,idUsers);
            int count = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pool.releaseConnection(connection);
        }
    }

    public void removeIdAuto(int idAuto){
        Connection connection = null;
        try {
        connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ID_AUTO);
            preparedStatement.setInt(1, idAuto);
        int count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            pool.releaseConnection(connection);
        }
    }

    private Users extractUser(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setIdUsers(rs.getInt(Fields.USERS_ID_USERS));
        user.setUsername(rs.getString(Fields.USERS_USERNAME));
        user.setPassword(rs.getString(Fields.USERS_PASSWORD));
        user.setName(rs.getString(Fields.USERS_NAME));
        user.setSurname(rs.getString(Fields.USERS_SURNAME));
        //user.setRoleId(rs.getInt(Fields.USERS_ROLE_ID));
        return user;
    }
}
