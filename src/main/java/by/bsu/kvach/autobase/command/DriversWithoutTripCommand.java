package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 16.12.2016.
 */
public class DriversWithoutTripCommand implements ActionCommand {

    private static IUsersDAO usersDAO = new UsersDAO();

    @Override
    public String execute(HttpServletRequest request) {


        request.getSession().setAttribute("users",usersDAO.DriversWithoutTrip());


        return ConfigurationManager.getProperty("path.page.createnewtrip");
    }
}
