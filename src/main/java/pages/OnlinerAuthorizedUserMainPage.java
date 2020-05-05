package pages;

import elements.Logo;
import elements.PopularTheme;
import org.openqa.selenium.WebElement;
import utilities.Locators;

import java.util.Random;


public class OnlinerAuthorizedUserMainPage {

    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerAuthorizedUserMainPage.logo.onliner_xpath"));
    private Logo profileLogo = new Logo(Locators.getLocator("onlinerAuthorizedUserMainPage.logo.profile_xpath"));
    private PopularTheme popularThemesList = new PopularTheme(Locators.getLocator("onlinerAuthorizedUserMainPage.popularThemes.themes_xpath"));

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
        return random.nextInt(7);
    }

    private int getPopularThemesList(){
        return popularThemesList.size();
    }

    public boolean isSuccessfulLogIn(){
        return profileLogo.isExist();
    }

    public boolean isMainPageOpen(){
        return onlinerLogo.isExist();
    }
}
