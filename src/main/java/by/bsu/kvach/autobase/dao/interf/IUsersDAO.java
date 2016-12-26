package by.bsu.kvach.autobase.dao.interf;

import by.bsu.kvach.autobase.model.Users;

import java.util.List;

/**
 * Created by timme on 13.12.2016.
 */
public interface IUsersDAO {
    public Users checkLogin(String enterUsername, String enterPass);
    public boolean registrateUser(String username, String password, String name, String surname);
    public List<Users> getAllUsers();
    public void removeUser(int id);
    public void updateIdAuto(int idUsers, int idAuto);
    public void updateIdTrip(int idUsers, int idTrip);

    public Users findUserById(int id_user);
    public void removeIdAuto(int idAuto);
    public void removeIdTrip(int idTrip);
    public  List<Users> DriversWithoutAuto();
    public  List<Users> DriversWithoutTrip();
}

