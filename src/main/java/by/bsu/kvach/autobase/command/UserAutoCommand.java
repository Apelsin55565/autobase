package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.AutoDAO;
import by.bsu.kvach.autobase.dao.interf.IAutoDAO;
import by.bsu.kvach.autobase.model.Auto;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 17.12.2016.
 */
public class UserAutoCommand implements ActionCommand {

    private static final String ID_USER = "idUser";
    private static IAutoDAO autoDAO = new AutoDAO();
    Auto auto  = new Auto();

    @Override
    public  String execute(HttpServletRequest request){
        String page = null;
        int user_id = Integer.parseInt(request.getParameter(ID_USER));
        page = ConfigurationManager.getProperty("path.page.userauto");

        auto = autoDAO.findAutoByIdDriver(user_id);

        request.setAttribute("autos", auto);
        return page;
    }
}
