package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.TripDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.ITripDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.model.Users;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 16.12.2016.
 */
public class UpdateTripStatusCommand implements ActionCommand {

    private static ITripDAO tripDAO = new TripDAO();
    private static IUsersDAO usersDAO = new UsersDAO();
    private static final String  ID = "idTrip";
    private static final String STATUS = "status";
    private static final String ID_USER = "idUser";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.parseInt(request.getParameter(ID));
        int status = Integer.parseInt(request.getParameter(STATUS));
        int user_id = Integer.parseInt(request.getParameter(ID_USER));

        tripDAO.UpdateStatusTrip(id, status);

        Users user_now = usersDAO.findUserById(user_id);
        if (user_now !=null) {
            String username = user_now.getUsername();

            request.getSession().setAttribute("currentUser", user_now);

            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("trips", tripDAO.getTripById(user_id));

            page = ConfigurationManager.getProperty("path.page.user");
        }
        else {
            request.setAttribute("errorLoginOrPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.logination");
        }

        return page;
    }
}
