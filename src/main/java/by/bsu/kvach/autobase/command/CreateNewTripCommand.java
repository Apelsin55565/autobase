package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.TripDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.ITripDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 16.12.2016.
 */
public class CreateNewTripCommand implements ActionCommand{

    private static final String DATE = "date";
    private static final String QUANTITY ="quantity";
    private static final String FROM ="from";
    private static final String TO ="to";
    private static final String DRIVER ="driver_id";

    private static ITripDAO tripDAO = new TripDAO();
    private static IUsersDAO usersDAO = new UsersDAO();



    @Override
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty("path.page.createnewtrip");
        String  date = request.getParameter(DATE);
        String quantityStr = request.getParameter(QUANTITY);
        String from = request.getParameter(FROM);
        String to = request.getParameter(TO);
        String driverStr = request.getParameter(DRIVER);
        int quantity = Integer.parseInt(quantityStr);
        int driver = Integer.parseInt(driverStr);

        if(date!=null && quantityStr!= null && from!= null && to!=null && driverStr!=null) {
            if (tripDAO.createNewTrip(date, quantity, from, to, driver)) {
                request.getSession().setAttribute("trips", tripDAO.getAllTrip());

                int idTrip = tripDAO.findIdTripByDriver(driver);

                usersDAO.updateIdTrip(driver, idTrip);

                page = ConfigurationManager.getProperty("path.page.admin");

            } else {
                request.setAttribute("errorTripIsNotCreated", MessageManager.getProperty("message.tripisnotcreated"));
            }
        }
        else {
            request.setAttribute("errorTripIsNotCreated", MessageManager.getProperty("message.tripisnotcreated"));
        }

        return page;
        }
}
