import driver.Browser;
import driver.ChromeBrowser;
import driver.FirefoxBrowser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.OnlinerMainPage;
import pages.OnlinerProfileTab;
import pages.OnlinerThemePage;

import java.util.concurrent.TimeUnit;

/**
 * Test class for onliner website
 */
public class OnlinerTest {

    /**
     * DataProvider to get browser
     * @return browser
     */
    @DataProvider(name = "browser")
    Object[][] getBrowser(){
        return new Object[][]{
                {new ChromeBrowser()},
                {new FirefoxBrowser()}
        };
    }

    /**
     * Test log out
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 9, dataProvider = "browser")
    public void logOutTest(Browser browser){
        browser.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        logInTest(browser);
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        browser.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        onlinerMainPage.logOut();
        OnlinerProfileTab onlinerProfileTab = new OnlinerProfileTab(browser);
        browser.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        onlinerProfileTab.logOut();
    }

    /**
     * Test Go to main page from one of the popular theme page
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 8, dataProvider = "browser")
    public void goToMainPageTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        goToRandomThemeTest(browser);
        OnlinerThemePage onlinerThemePage = new OnlinerThemePage(browser);
        onlinerThemePage.goToMainPage();
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        boolean isMainPage = onlinerMainPage.isMainPageOpen();
        Assert.assertTrue(isMainPage, "Main page was not open or open not a main page.");
    }

    /**
     * Test Go to one random popular theme page
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 7, dataProvider = "browser")
    public void goToRandomThemeTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        int themeNumber = onlinerMainPage.getOneRandomPopularTheme();
        String themeText = onlinerMainPage.goToRandomTheme(themeNumber);
        OnlinerThemePage onlinerThemePage = new OnlinerThemePage(browser);
        String realText = onlinerThemePage.getThemeTitle();
        Assert.assertEquals(themeText, realText, "Not this page");
    }

    /**
     * Test to get one random theme page from the list of popular themes
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 6, dataProvider = "browser")
    public void getRandomThemeTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        int themeNumber = onlinerMainPage.getOneRandomPopularTheme();
        System.out.println(themeNumber);
    }

    /**
     * Test to get a list of popular themes
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 5, dataProvider = "browser")
    public void getPopularThemesTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        int numberOfThemes = onlinerMainPage.getPopularThemesList();
        Assert.assertEquals(12,numberOfThemes, "Do not correct number of popular themes.");
    }

    /**
     * Test log in
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 4, dataProvider = "browser")
    public void logInTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        onlinerMainPage.clickLogIn();

        LoginForm loginForm = new LoginForm(browser);
        loginForm.login();

        boolean isLoggedIn = onlinerMainPage.isSuccessfulLogIn();
        Assert.assertTrue(isLoggedIn, "Successfully logged in!");
    }

    /**
     * Test is log in page open
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 3, dataProvider = "browser")
    public void isLogInPageOpenTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        onlinerMainPage.clickLogIn();

        LoginForm loginForm = new LoginForm(browser);
        boolean isLogInPageOpen = loginForm.isPageOpen();
        Assert.assertEquals(true, isLogInPageOpen, "LogIn page was not open.");
    }

    /**
     * Test is already logged in
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 2, dataProvider = "browser")
    public void isLoggedInTest(Browser browser){
        browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        boolean isOpen = onlinerMainPage.isLoggedIn();
        Assert.assertEquals(false, isOpen, "You already log in.");
    }

    /**
     * Test is main page open
     * @param browser browser[Firefox/Chrome]
     */
    @Test(priority = 1, dataProvider = "browser")
    public void isMainPageOpenTest(Browser browser){
        browser.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        browser.getDriver().get("http://onliner.by/");
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(browser);
        boolean isOpen = onlinerMainPage.isMainPageOpen();
        Assert.assertTrue(isOpen, "Main page was not open or open not a main page.");
    }

}
