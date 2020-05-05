package utilities;

import java.util.ResourceBundle;

public class PropertiesHandler {

    private static ResourceBundle propResourceBundle;

    public PropertiesHandler(){}

    private PropertiesHandler(String login, String password, String browser, String URL){
        prop_login = login;
        prop_password = password;
        prop_browser = browser;
        prop_URL = URL;
    }

    private static String prop_login = "login";
    private static String prop_password = "password";
    private static String prop_browser = "browser";
    private static String prop_URL = "URL";

    static {
        propResourceBundle = ResourceBundle.getBundle("prop");
    }

    public String getLogin(){
        return propResourceBundle.getString(prop_login);
    }

    public String getPassword(){
        return propResourceBundle.getString(prop_password);
    }

    public String getBrowser(){
        return propResourceBundle.getString(prop_browser);
    }

    public String getURL(){
        return propResourceBundle.getString(prop_URL);
    }
}
