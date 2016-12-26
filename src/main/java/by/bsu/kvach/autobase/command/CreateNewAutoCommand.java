package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.AutoDAO;
import by.bsu.kvach.autobase.dao.impl.UsersDAO;
import by.bsu.kvach.autobase.dao.interf.IAutoDAO;
import by.bsu.kvach.autobase.dao.interf.IUsersDAO;
import by.bsu.kvach.autobase.model.Auto;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 16.12.2016.
 */
public class CreateNewAutoCommand implements ActionCommand {

    private static final String MARK = "mark";
    private static final String MODEL = "model";
    private static final String QUANTITY = "quantity";
    private static final String DRIVER_ID = "driver_id";

    private static IAutoDAO autoDAO = new AutoDAO();
    private static IUsersDAO usersDAO = new UsersDAO();


    @Override
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty("path.page.createnewauto");
        String mark = request.getParameter(MARK);
        String model = request.getParameter(MODEL);
        String quantityStr = request.getParameter(QUANTITY);
        String driverStr = request.getParameter(DRIVER_ID);
        int quantity = Integer.parseInt(quantityStr);
        int driver = Integer.parseInt(driverStr);

        if (autoDAO.createNewAuto(mark,model,quantity,driver)) {
                request.getSession().setAttribute("autos", autoDAO.getAllAuto());

            Auto auto = new Auto();
            auto = autoDAO.findAutoByIdDriver(driver);
            int idAuto = auto.getIdAuto();
            usersDAO.updateIdAuto(driver, idAuto);
                page = ConfigurationManager.getProperty("path.page.allauto");

            } else {
                request.setAttribute("errorAutoIsNotCreated", MessageManager.getProperty("message.autoisnotcreated"));
            }
        return page;
    }
}
