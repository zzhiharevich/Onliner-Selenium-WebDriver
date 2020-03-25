package pages;

import elements.Button;
import elements.Logo;
import elements.PopularTheme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;


public class OnlinerMainPage {

    private static final String LOGIN_BUTTON_LOCATOR = "//div[contains(@class,'auth-bar__item--text')]";
    private static final String ONLINER_LOGO_LOCATOR = "//*[@id=\"container\"]/div/div/header/div[3]/div/div[1]/a/img";
    private static final String PROFILE_LOGO_LOCATOR = "//*[@id=\"userbar\"]/div[1]/div[1]/a[contains(@class, b-top-profile__preview)]";
    private static final String POPULAR_THEMES_LOCATOR = "//a[contains(@class, 'project-navigation__link_primary')]//span[contains(@class, 'project-navigation__sign')]";

    private Button loginButton = new Button(By.xpath(LOGIN_BUTTON_LOCATOR));
    private Logo onlinerLogo = new Logo(By.xpath(ONLINER_LOGO_LOCATOR));
    private Logo profileLogo = new Logo(By.xpath(PROFILE_LOGO_LOCATOR));
    private PopularTheme popularThemesList = new PopularTheme(By.xpath(POPULAR_THEMES_LOCATOR));

    public void logOut(){
        profileLogo.click();
    }

    public String goToRandomTheme(int themeNumber){
        WebElement theme = popularThemesList.getElements().get(themeNumber);
        String themeText = theme.getText();
        theme.click();
        return  themeText;
    }

    public int getOneRandomPopularTheme(){
        Random random = new Random();
        int numberOfPopularThemes = getPopularThemesList();
        return random.nextInt(numberOfPopularThemes);
    }

    private int getPopularThemesList(){
        return popularThemesList.size();
    }

    public boolean isSuccessfulLogIn(){
        return profileLogo.isExist();
    }

    public boolean isLoggedIn(){
        return !loginButton.isExist();
    }

    public void clickLogIn() {

        loginButton.click();
    }

    public boolean isMainPageOpen(){
        return onlinerLogo.isExist();
    }
}
