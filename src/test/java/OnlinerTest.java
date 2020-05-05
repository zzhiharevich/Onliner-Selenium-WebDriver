import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.PropertiesHandler;

import java.util.concurrent.TimeUnit;

public class OnlinerTest {

    private String login;
    private String password;
    private String URL;
    private OnlinerAuthorizedUserMainPage onlinerAuthorizedUserMainPage = new OnlinerAuthorizedUserMainPage();
    private OnlinerNotAuthorizedUserMainPage onlinerNotAuthorizedUserMainPage = new OnlinerNotAuthorizedUserMainPage();
    private OnlinerLoginPage onlinerLoginPage = new OnlinerLoginPage();
    private OnlinerProfileTab profileTab = new OnlinerProfileTab();
    private OnlinerThemePage themePage = new OnlinerThemePage();

    @BeforeMethod
    public void setUp(){
        PropertiesHandler propertiesHandler = new PropertiesHandler();

        login = propertiesHandler.getLogin();
        password = propertiesHandler.getPassword();
        final String browserType = propertiesHandler.getBrowser();
        URL = propertiesHandler.getURL();

        //Browser.setBrowser(Type.valueOf(browserType));
        Browser.setBrowser(browserType);
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void quit(){
        Browser.getDriver().quit();
        System.out.println("QUIT");
    }

    @Test
    public void onlinerTest(){
        Browser.getDriver().get(URL);
        boolean isOpen = onlinerNotAuthorizedUserMainPage.isMainPageOpen();
        Assert.assertTrue(isOpen, "Main page was not open or open not a main page.");

        boolean isLoggedIn = onlinerNotAuthorizedUserMainPage.isLoggedIn();
        Assert.assertFalse(isLoggedIn, "You already log in.");

        onlinerNotAuthorizedUserMainPage.clickLogIn();
        boolean isLogInPageOpen = onlinerLoginPage.isPageOpen();
        Assert.assertTrue(isLogInPageOpen, "LogIn page was not open.");

        onlinerLoginPage.login(login, password);

        onlinerLoginPage.waitUntilBackgroundStaleness();

        boolean isLogInSuccessful = onlinerAuthorizedUserMainPage.isSuccessfulLogIn();
        Assert.assertTrue(isLogInSuccessful, "Error with log in.");

        int themeNumber = onlinerAuthorizedUserMainPage.getOneRandomPopularTheme();
        System.out.println(themeNumber);
        String themeText = onlinerAuthorizedUserMainPage.goToRandomTheme(themeNumber);
        String realText = themePage.getThemeTitle();
        Assert.assertEquals(themeText, realText, "Not this page");

        themePage.goToMainPage();
        boolean isMainPage = onlinerAuthorizedUserMainPage.isMainPageOpen();
        Assert.assertTrue(isMainPage, "Main page was not open or open not a main page.");

        onlinerAuthorizedUserMainPage.logOut();
        profileTab.logOut();
    }
}
