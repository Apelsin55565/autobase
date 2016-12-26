package by.bsu.kvach.autobase.resources;

import java.util.ResourceBundle;

/**
 * Created by timme on 13.12.2016.
 */
public class MessageManager {
   private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
    private MessageManager(){}

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}