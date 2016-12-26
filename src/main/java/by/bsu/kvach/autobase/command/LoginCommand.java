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
 * Created by timme on 13.12.2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String ID_USER = "idUsers";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    //private static final String NAME = "name";
    //private static final String SURNAME = "surname";
    private static final String ROLE = "Role_idRole";
    private static final String IS_SIGNED = "isSignedIn";

    private static IUsersDAO userdao = new UsersDAO();
    private static ITripDAO tripDAO = new TripDAO();
    @Override
    public String execute(HttpServletRequest req) {

        String page = null;
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);


        Users user_now = userdao.checkLogin(username,password);


        if (user_now != null) {

            req.setAttribute("user", username);
            req.getSession().setAttribute("currentUser", user_now);
            req.getSession().setAttribute(IS_SIGNED, true);
            req.getSession().setAttribute(ROLE, user_now.getRole());
            int user_id = user_now.getIdUsers();

            if (user_now.getRole() > 1) {
                req.getSession().setAttribute("trips",tripDAO.getTripById(user_id));
                page = ConfigurationManager.getProperty("path.page.user");

            } else {
                req.getSession().setAttribute("trips",tripDAO.getAllTrip());
                page = ConfigurationManager.getProperty("path.page.admin");
            }

        } else {
            req.setAttribute("errorLoginOrPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.logination");

        }
        return page;
    }
}
