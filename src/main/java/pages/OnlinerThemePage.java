package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Page of popular theme
 */
public class OnlinerThemePage {

    /**
     * Constructor to find elements on page
     * @param browser browser[Firefox/Chrome]
     */
    public OnlinerThemePage(Browser browser){
        themeTitle = browser.getDriver()
                .findElement(By.xpath("//h1[contains(@class, 'schema-header__title')]"));
        onlinerLogo = browser.getDriver()
                .findElement(By.className("onliner_logo"));
    }

    /**
     * Theme title
     */
    private WebElement themeTitle;
    /**
     * Onliner logo
     */
    private WebElement onlinerLogo;

    /**
     * To get theme title text
     * @return titles' text
     */
    public String getThemeTitle(){
        return themeTitle.getText();
    }

    /**
     * Go to main page (click onto onliner logo)
     */
    public void goToMainPage(){
        onlinerLogo.click();
    }
}
