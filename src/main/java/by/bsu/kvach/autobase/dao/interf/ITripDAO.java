package by.bsu.kvach.autobase.dao.interf;

import by.bsu.kvach.autobase.model.Trip;

import java.util.List;

/**
 * Created by timme on 15.12.2016.
 */
public interface ITripDAO {

    public List<Trip> getAllTrip();
    public void removeTrip(int id);
    public boolean createNewTrip(String date, int quantity, String from, String to, int id_driver);
    public int findIdTripByDriver(int id_driver);
    public Trip getTripById(int id_user);
    public void UpdateStatusTrip(int id, int status);
}
