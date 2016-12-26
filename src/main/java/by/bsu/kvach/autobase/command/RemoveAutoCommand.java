package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.AutoDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IAutoDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 15.12.2016.
 */
public class RemoveAutoCommand implements ActionCommand {
    private static IAutoDAO autoDAO = new AutoDAO();
    private static IUsersDAO usersDAO = new UsersDAO();

    private static final String ID = "id";
    @Override
    public String execute(HttpServletRequest request){

        int id = Integer.parseInt(request.getParameter(ID));

        autoDAO.removeAuto(id);

        usersDAO.removeIdAuto(id);


        request.getSession().setAttribute("autos", autoDAO.getAllAuto());


        return ConfigurationManager.getProperty("path.page.allauto");

}
}
