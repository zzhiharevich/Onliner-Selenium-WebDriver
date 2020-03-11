package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Onliner main page class
 */
public class OnlinerMainPage {

    /**
     * Constructor to find elements on page
     * @param browser browser[Firefox/Chrome]
     */
    public OnlinerMainPage(Browser browser){
        this.loginBtns = browser.getDriver()
                .findElements(By.xpath("//div[contains(@class,'auth-bar__item--text')]"));
        loginBtn = browser.getDriver()
                .findElement(By.xpath("//div[contains(@class,'auth-bar__item--text')]"));
        onlinerLogo = browser.getDriver()
                .findElements(By.xpath("//*[@id=\"container\"]/div/div/header/div[3]/div/div[1]/a/img"));
        profileLogo = browser.getDriver()
                .findElements(By.xpath("//*[@id=\"userbar\"]/div[1]/div[1]/a[contains(@class, b-top-profile__preview)]"));
        popularThemes = browser.getDriver()
                .findElements(By.xpath("//a[contains(@class, 'project-navigation__link_primary')]//span[contains(@class, 'project-navigation__sign')]"));
    }

    /**
     * Log In buttons list to check is this element on page
     */
    private List<WebElement> loginBtns;
    /**
     * Log In buttot
     */
    private WebElement loginBtn;
    /**
     * Onliner logo list to check is logo on page
     */
    private List<WebElement> onlinerLogo;
    /**
     * Profile logo list to check is logo on page
     */
    private List<WebElement> profileLogo;
    /**
     * List of popular themes
     */
    private List<WebElement> popularThemes;

    /**
     * Logout method (click onto profile logo)
     */
    public void logOut(){
        profileLogo.get(0).click();
    }

    /**
     * Go to random theme page (click onto one of popular themes)
     * @param themeNumber number of popular themes
     * @return theme text
     */
    public String goToRandomTheme(int themeNumber){
        List<WebElement> popularThemesElements = popularThemes;
        WebElement theme = popularThemesElements.get(themeNumber);
        String themeText = theme.getText();
        theme.click();
        return  themeText;
    }

    /**
     * To get one random popular theme
     * @return a number of rundom theme
     */
    public int getOneRandomPopularTheme(){
        Random random = new Random();
        int numberOfPopularThemes = getPopularThemesList();
        int randomTheme = random.nextInt(9);
        return randomTheme;
    }

    /**
     * To get a list of popular themes
     * @return size of list
     */
    public int getPopularThemesList(){
        List<WebElement> popularThemesElements = popularThemes;
        return popularThemesElements.size();
    }

    /**
     * To check log in
     * @return true if log in / false login error
     */
    public boolean isSuccessfulLogIn(){
        List<WebElement> profileElements = profileLogo;
        if(profileElements.size() == 1) {
            return true;
        }
        return false;
    }

    /**
     * To check are you already log in
     * @return
     */
    public boolean isLoggedIn(){
        List<WebElement> btnsElements = loginBtns;
        if(btnsElements.size() == 1){
            return false;
        }
        return true;
    }

    /**
     * To log in (click onto log in button)
     */
    public void clickLogIn() {
        loginBtn.click();
    }

    /**
     * To check is main page open
     * @return true - yes / false - no
     */
    public boolean isMainPageOpen(){
        List<WebElement> elements = onlinerLogo;
        if(elements.size() > 0)
            return true;
        return false;
    }
}
