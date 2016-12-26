package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.TripDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.ITripDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 16.12.2016.
 */
public class RemoveTripCommand implements ActionCommand {
    private static ITripDAO tripDAO = new TripDAO();
    private static IUsersDAO usersDAO = new UsersDAO();
    private static final String ID = "id";
    @Override
    public String execute(HttpServletRequest request){

        int id = Integer.parseInt(request.getParameter(ID));

        tripDAO.removeTrip(id);

        usersDAO.removeIdTrip(id);

        request.getSession().setAttribute("trips", tripDAO.getAllTrip());


        return ConfigurationManager.getProperty("path.page.admin");

    }
}