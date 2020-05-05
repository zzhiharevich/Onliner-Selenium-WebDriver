package pages;

import elements.Logo;
import elements.Text;
import utilities.Locators;


public class OnlinerThemePage {

    private Text themeTitle = new Text(Locators.getLocator("onlinerThemePage.text.title_xpath"));
    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerThemePage.logo.onliner_className"));

    public String getThemeTitle(){
        return themeTitle.getText();
    }

    public void goToMainPage(){
        onlinerLogo.click();
    }
}
