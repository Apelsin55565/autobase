package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.TripDAO;
import by.bsu.kvach.autobase.model.Trip;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by timme on 16.12.2016.
 */
public class AllTripCommand implements ActionCommand {
    @Override
    public  String execute(HttpServletRequest req){
        String page = ConfigurationManager.getProperty("path.page.admin");
        TripDAO tripDAO = new TripDAO();

        List<Trip> trips = tripDAO.getAllTrip();
        req.setAttribute("trips", trips);
        return page;
    }
}
