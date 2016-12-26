package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.model.Users;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by timme on 15.12.2016.
 */
public class AllDriversCommand implements ActionCommand {
    @Override
    public  String execute(HttpServletRequest req){
        String page = ConfigurationManager.getProperty("path.page.alldrivers");
        UsersDAO usersDAO = new UsersDAO();

        List<Users> users = usersDAO.getAllUsers();
        req.setAttribute("users", users);
        return page;
    }
}
