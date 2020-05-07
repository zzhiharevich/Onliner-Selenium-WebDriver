package utilities;

import java.util.ResourceBundle;

/**
 * Класс выполняющий чтение и обработку данных из properties файлов.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class PropertiesHandler {

    /**
     * Приватный объект класса ResourceBundle, предоставляющий функционал для работы с properties файлом.
     */
    private static ResourceBundle propResourceBundle;

    /**
     * Конструктор без параметров.
     */
    public PropertiesHandler(){}

    /**
     * Конструктор с параметрами, выполняющий инициализацию полей класса.
     * @param login Логин типа String.
     * @param password Пароль типа String.
     * @param browser Имя браузера типа String.
     * @param URL URL сайта типа String.
     */
    private PropertiesHandler(String login, String password, String browser, String URL){
        prop_login = login;
        prop_password = password;
        prop_browser = browser;
        prop_URL = URL;
    }

    /**
     * Приватное поле, хранящее ключ для поиска логина в файле.
     */
    private static String prop_login = "login";
    /**
     * Приватное поле, хранящее ключ для поиска пароля в файле.
     */
    private static String prop_password = "password";
    /**
     * Приватное поле, хранящее ключ для поиска имя браузера в файле.
     */
    private static String prop_browser = "browser";
    /**
     * Приватное поле, хранящее ключ для поиска URL сайта в файле.
     */
    private static String prop_URL = "URL";

    /**
     * Инициализация поля propResourceBundle.
     */
    static {
        propResourceBundle = ResourceBundle.getBundle("prop");
    }

    /**
     * Метод для получения значенния логина из файла по ключу.
     * @return Логин типа String.
     */
    public String getLogin(){
        return propResourceBundle.getString(prop_login);
    }

    /**
     * Метод для получения значенния пароля из файла по ключу.
     * @return Пароль типа String.
     */
    public String getPassword(){
        return propResourceBundle.getString(prop_password);
    }

    /**
     * Метод для получения значенния имени браузера из файла по ключу.
     * @return Имя браузера типа String.
     */
    public String getBrowser(){
        return propResourceBundle.getString(prop_browser);
    }

    /**
     * Метод для получения значенния URL сайта из файла по ключу.
     * @return URL сайта типа String.
     */
    public String getURL(){
        return propResourceBundle.getString(prop_URL);
    }
}
