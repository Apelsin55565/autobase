package by.bsu.kvach.autobase.command;


import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.model.Users;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 13.12.2016.
 */
public class SignInCommand implements ActionCommand {



    //private static final String ID_USER = "idUsers";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "passwordRepeat";
    private static final String ERROR_IN_PASSWORD = "errorInPass";

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String IS_ADMIN = "isAdmin";


    private static final String ERROR_IN_USERNAME = "errorInLogin";
    private static final String ERROR_IN_SIGNIN = "errorSIGNIN";


    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.signin");
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        String repeatPassword = req.getParameter(REPEAT_PASSWORD);

        //Client client = new ClientDAO().checkLogin(login, password, req);
        // rebuild here

        if (password != null && password.equals(repeatPassword)){
            IUsersDAO usersDAO = new UsersDAO();
            Users user = usersDAO.checkLogin(username,password);
            if (user == null){
                if (usersDAO.registrateUser(username, password, name, surname)){

                    req.setAttribute("name",name);
                    req.setAttribute("surname",surname);
                    req.setAttribute("username", username);
                    req.getSession().setAttribute("currentUser",user);

                    page = ConfigurationManager.getProperty("path.page.success");
                }
                else {
                    req.setAttribute(ERROR_IN_SIGNIN, "Error in signin");
                }
            }
            else {
                req.setAttribute(ERROR_IN_USERNAME, MessageManager.getProperty("message.onlyloginerror"));
            }
        }
        else {
            req.setAttribute(ERROR_IN_PASSWORD, MessageManager.getProperty("message.onlypassworderror"));
        }
        return page;
    }
}
