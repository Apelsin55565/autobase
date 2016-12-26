package by.bsu.kvach.autobase.resources;

import java.util.ResourceBundle;

/**
 * Created by timme on 13.12.2016.
 */
public class ConfigurationManager {
    private static final  ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager() {}

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}