package pages;

import elements.Button;
import elements.Logo;
import utilities.Locators;

public class OnlinerNotAuthorizedUserMainPage {

    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerNotAuthorizedUserMainPage.logo.onliner_xpath"));
    private Button loginButton = new Button(Locators.getLocator("onlinerNotAuthorizedUserMainPage.button.login_xpath"));

    public boolean isMainPageOpen(){
        return onlinerLogo.isExist();
    }
    public boolean isLoggedIn(){
        return !loginButton.isExist();
    }
    public void clickLogIn() {

        loginButton.click();
    }
}
