package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.dao.impl.AutoDAO;
import by.bsu.kvach.autobase.model.Auto;
import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by timme on 15.12.2016.
 */
public class AllAutoCommand implements ActionCommand {
        @Override
        public  String execute(HttpServletRequest req){
            String page = ConfigurationManager.getProperty("path.page.allauto");
            AutoDAO autoDAO = new AutoDAO();

            List<Auto> autos = autoDAO.getAllAuto();
            req.setAttribute("autos", autos);
            return page;
        }
}
