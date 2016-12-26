package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.AutoDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IAutoDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.model.Users;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 17.12.2016.
 */
public class UpdateAutoStatusCommand implements ActionCommand {

    private static IUsersDAO usersDAO = new UsersDAO();
    private static IAutoDAO autoDAO = new AutoDAO();
    private static final String  ID_AUTO = "idAuto";
    private static final String STATUS = "status";
    private static final String ID_USER = "idUser";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int id_auto = Integer.parseInt(request.getParameter(ID_AUTO));
        int status  = Integer.parseInt(request.getParameter(STATUS));
        int id_user = Integer.parseInt(request.getParameter(ID_USER));

        autoDAO.UpdateStatusAuto(id_auto, status);

        Users user_now = usersDAO.findUserById(id_user);

        if (user_now !=null) {
            String username = user_now.getUsername();

            request.getSession().setAttribute("currentUser", user_now);

            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("autos", autoDAO.findAutoByIdDriver(id_user));

            page = ConfigurationManager.getProperty("path.page.userauto");
        }
        else {
            request.setAttribute("errorLoginOrPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.logination");
        }


        return page;
    }
}
