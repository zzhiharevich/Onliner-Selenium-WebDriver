import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.PropertiesHandler;

import java.util.concurrent.TimeUnit;

/**
 * Класс, используемый для тестирования веб-сайта Onliner
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerTest {

    /**
     * Приватное поле, хранящее в себе значение логина пользователя для авторизации.
     */
    private String login;
    /**
     * Приватное поле, хранящее в себе значение пароля пользователя для авторизации.
     */
    private String password;
    /**
     * Приватное поле, хранящее в себе URL тестируемого сайта - Onliner.
     */
    private String URL;
    /**
     * Приватный объект класса OnlinerAuthorizedUserMainPage. Используется для взаимодействия с главной
     * страницей сайта, когда пользователь ещё не авторизован.
     */
    private OnlinerAuthorizedUserMainPage onlinerAuthorizedUserMainPage = new OnlinerAuthorizedUserMainPage();
    /**
     * Приватный объект класса OnlinerNotAuthorizedUserMainPage. Используется для взаимодействия с главной
     * страницей сайта, когда пользователь уже авторизован.
     */
    private OnlinerNotAuthorizedUserMainPage onlinerNotAuthorizedUserMainPage = new OnlinerNotAuthorizedUserMainPage();
    /**
     * Приватный объект класс OnlinerLoginPage. Используется для взаимодействия со страницей авторизации,
     * для ввода пользователем данных для авторизации.
     */
    private OnlinerLoginPage onlinerLoginPage = new OnlinerLoginPage();
    /**
     * Приватный объект класс OnlinerProfileTab. Используется для взаимодействия с открывающемся окном профиля,
     * для выхода пользователя из системы.
     */
    private OnlinerProfileTab profileTab = new OnlinerProfileTab();
    /**
     * Приватный объект класс OnlinerThemePage. Используется для взаимодействия со страницей каталога на
     * определенную тему.
     */
    private OnlinerThemePage themePage = new OnlinerThemePage();

    /**
     * Функция, выполняющаяся перед каждой тестовой функцией.
     * В setUp функции создается объект класса PropertiesHandler. С его помощью получаются данные логина и пароля,
     * тип браузера, в котором будет выполняться тестирование,
     * URL сайта, который тестируется.
     * Происходит настройка браузера:
     * 1. Устанавливается браузер соответствующий полученному типу.
     * 2. Устанавливается окно браузера на максимальный размер.
     *
     */
    @BeforeMethod
    public void setUp(){
        PropertiesHandler propertiesHandler = new PropertiesHandler();

        login = propertiesHandler.getLogin();
        password = propertiesHandler.getPassword();
        final String browserType = propertiesHandler.getBrowser();
        URL = propertiesHandler.getURL();

        Browser.setBrowser(browserType);
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    /**
     * Функция, выполняющаяся после каждой тестовой функции.
     * С помощью класса Browser методом quit закрываем браузер, завершая работу с ним.
     */
    @AfterMethod
    public void quit(){
        Browser.getDriver().quit();
    }

    /**
     * Тестовая функция класса.
     * Функция выполняет следующий сценарий:
     * 1. Переходит по полученному URL на сайт; проверяет, что сайт открылся.
     * 2. Переходит на страницу авторизации; проверяет, что страница авторизации открылась.
     * 3. Выполняет авторизацию (вводит данные логина и пароля); проверяет, что авторизация выполнена успешно.
     * 4. Получает номер рандомной темы из списка всех тем и переходит на страницу каталога на эту тему; проверяет,
     *    что открылась страница каталога заданной темы.
     * 5. Переходит на главную страницу; проверяет, что главная страница открылась.
     * 6. Выполняет выход из системы; проверяет, что пользовательно больше не авторизован.
     */
    @Test
    public void onlinerTest(){

        Browser.getDriver().get(URL);
        boolean isOpen = onlinerNotAuthorizedUserMainPage.isMainPageOpen();
        Assert.assertTrue(isOpen, "Main page was not open or open not a main page.");
        onlinerNotAuthorizedUserMainPage.clickLogIn();
        boolean isLogInPageOpen = onlinerLoginPage.isPageOpen();
        Assert.assertTrue(isLogInPageOpen, "LogIn page was not open.");

        onlinerLoginPage.login(login, password);
        onlinerLoginPage.waitUntilBackgroundStaleness();
        boolean isLogInSuccessful = onlinerAuthorizedUserMainPage.isSuccessfulLogIn();
        Assert.assertTrue(isLogInSuccessful, "Error with log in.");

        int themeNumber = onlinerAuthorizedUserMainPage.getOneRandomPopularTheme();
        String themeText = onlinerAuthorizedUserMainPage.goToRandomTheme(themeNumber);
        String realText = themePage.getThemeTitle();
        Assert.assertEquals(themeText, realText, "Not this page");

        themePage.goToMainPage();
        Browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        boolean isMainPage = onlinerAuthorizedUserMainPage.isMainPageOpen();
        Assert.assertTrue(isMainPage, "Main page was not open or open not a main page.");

        onlinerAuthorizedUserMainPage.logOut();
        profileTab.logOut();

        boolean isLoggedOut = onlinerNotAuthorizedUserMainPage.isLoggedOut();
        Assert.assertTrue(isLoggedOut, "You still logged in.");
    }
}
