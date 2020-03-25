import driver.Browser;
import driver.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.OnlinerMainPage;
import pages.OnlinerProfileTab;
import pages.OnlinerThemePage;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {

    private String login;
    private String password;
    private String URL;
    private OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
    private LoginForm loginForm = new LoginForm();
    private OnlinerProfileTab profileTab = new OnlinerProfileTab();
    private OnlinerThemePage themePage = new OnlinerThemePage();

    @BeforeMethod
    public void setUp(){
        ResourceBundle properties = ResourceBundle.getBundle("prop");

        login = properties.getString("login");
        password = properties.getString("password");
        final String browserType = properties.getString("browser");
        URL = properties.getString("URL");

        Browser.setBrowser(Type.valueOf(browserType));
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void onlinerTest(){
        Browser.getDriver().get(URL);
        boolean isOpen = onlinerMainPage.isMainPageOpen();
        Assert.assertTrue(isOpen, "Main page was not open or open not a main page.");

        boolean isLoggedIn = onlinerMainPage.isLoggedIn();
        Assert.assertFalse(isLoggedIn, "You already log in.");

        onlinerMainPage.clickLogIn();
        boolean isLogInPageOpen = loginForm.isPageOpen();
        Assert.assertTrue(isLogInPageOpen, "LogIn page was not open.");

        loginForm.login(login, password);

        loginForm.waitUntilBackgroundStaleness();

        boolean isLogInSuccessful = onlinerMainPage.isSuccessfulLogIn();
        Assert.assertTrue(isLogInSuccessful, "Error with log in.");

        int themeNumber = onlinerMainPage.getOneRandomPopularTheme();
        String themeText = onlinerMainPage.goToRandomTheme(themeNumber);
        String realText = themePage.getThemeTitle();
        Assert.assertEquals(themeText, realText, "Not this page");

        themePage.goToMainPage();
        boolean isMainPage = onlinerMainPage.isMainPageOpen();
        Assert.assertTrue(isMainPage, "Main page was not open or open not a main page.");

        onlinerMainPage.logOut();
        profileTab.logOut();

        Browser.getDriver().quit();
    }
}
