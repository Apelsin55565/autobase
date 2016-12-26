package by.bsu.kvach.autobase.factory;

import by.bsu.kvach.autobase.command.ActionCommand;
import by.bsu.kvach.autobase.command.CommandEnum;
import by.bsu.kvach.autobase.command.EmptyCommand;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timme on 13.12.2016.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand current = new EmptyCommand();

        // Извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()){

            // Если команда не задана в текущем запросе
            return current;
        }

        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException ex) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
