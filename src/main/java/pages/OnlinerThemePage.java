package pages;

import elements.Logo;
import elements.Text;
import org.openqa.selenium.By;


public class OnlinerThemePage {

    private static final String THEME_TITLE_LOCATOR = "//h1[contains(@class, 'schema-header__title')]";
    private static final String ONLINER_LOGO_LOCATOR = "onliner_logo";

    private Text themeTitle = new Text(By.xpath(THEME_TITLE_LOCATOR));
    private Logo onlinerLogo = new Logo(By.className(ONLINER_LOGO_LOCATOR));

    public String getThemeTitle(){
        return themeTitle.getText();
    }

    public void goToMainPage(){
        onlinerLogo.click();
    }
}
