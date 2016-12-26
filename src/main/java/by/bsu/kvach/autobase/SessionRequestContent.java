package by.bsu.kvach.autobase;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by timme on 13.12.2016.
 */
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public void extractValues(HttpServletRequest req){
        //
    }

    public void insertAttributes(HttpServletRequest req){
        //
    }
}
