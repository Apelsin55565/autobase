package by.bsu.kvach.autobase.command;

import by.bsu.kvach.autobase.resources.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 13.12.2016.
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.index");
        req.getSession().invalidate();
        return page;
    }
}
