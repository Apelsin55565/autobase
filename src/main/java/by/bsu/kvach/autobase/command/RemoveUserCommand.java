package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.model.Users;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by timme on 15.12.2016.
 */
public class RemoveUserCommand implements ActionCommand {


    private static IUsersDAO userDAO = new UsersDAO();

    private static final String ID = "id";

    @Override
    public String execute(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter(ID));


        userDAO.removeUser(id);

        // Обновление списка пользователей

        List<Users> users = userDAO.getAllUsers();

        request.getSession().setAttribute("users",users);

        // Перенаправление на страницу со списком
        return ConfigurationManager.getProperty("path.page.alldrivers");
    }
}
