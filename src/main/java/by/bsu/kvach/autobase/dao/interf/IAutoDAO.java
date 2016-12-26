package by.bsu.kvach.autobase.dao.interf;

import by.bsu.kvach.autobase.model.Auto;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by timme on 12.12.2016.
 */
public interface IAutoDAO {
    public List<Auto> getAllAuto();
    public void removeAuto(int id);
    public Auto selectById(int driverId) throws SQLException;
    public boolean createNewAuto(String mark, String model, int quantity, int driver_id);
    public Auto findAutoByIdDriver(int driver_id);

    public void UpdateStatusAuto(int id_auto, int status);
}
