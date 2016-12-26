package by.bsu.kvach.autobase.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 13.12.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest req);
}
